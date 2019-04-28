public class SynTest{

  /**
     * 使用lock替代synchronized关键字同步代码块
     */
    public void test1() {
        Lock lock = new ReentrantLock();
        lock.lock();
        while (!isInterrupted()) {
            //do something...
        }
        lock.unlock();
    }

    /**
     * 同一个锁上的多个监视器睡眠和唤醒
     */
    public void test2() {
        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        lock.lock();
        try {
            // 等待
            condition1.await();

            // 唤醒
            condition2.notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 读写锁，适应于大量读少量写的场景
     */
    public void test3() {

        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
        List<String> list = new ArrayList<>();

        // 读锁，当所有线程都只读取时，线程不需要同步执行
        if (list.size() > 0) {
            readLock.lock();
            list.get(0);
            readLock.unlock();
        } else {

            // 写锁，当存在线程获取写锁时，所有线程都同步执行
            writeLock.lock();
            list.add("A");
            writeLock.unlock();
        }
    }
}
