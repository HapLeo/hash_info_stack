# Thread类的API
```java
/* 使当前线程休眠指定毫秒数 */
public static native void sleep(long millis) throws InterruptedException;
```
注意点：<br />
1. 它是一个静态方法，表示正在执行这行代码的线程休眠指定时间；
2. 如果在同步代码块中，他不放弃monitor锁，睡眠期间处于BLOCKED状态，不消耗CPU时间片，休眠结束后进入RUNNABLE状态；
3. 休眠期间如果有另外一个线程打断它，将抛出InterruptedException异常；<br />
结合现实举例：<br />
去医院看门诊，有的人感冒发烧，有的人腰酸背痛。每一个感冒的人，医生（CPU）都要求测量体温，但是只有一只水银温度计（monitor锁），每个人都需要5分钟的测量时间（睡眠5分钟）。因此，当一个人拿到温度计开始测量5分钟，期间所有其他需要测量体温的病人都需要排队等待(在同步代码块中)，直到这个人自己数完5分钟后掏出温度计，下一个人才能测量。睡眠期间，虽然占用着温度计，但医生照常可以去给别的病人看病（sleep不占用CPU，即不消耗时间片）。但是睡眠期间，突然有保安跑过来告诉他，别睡了，外面着火了，此时他就会立刻拔出温度计，冲出医院（抛出InterruptedException异常，睡眠被打断了）。

```java
/* 提醒CPU可以先执行别的线程 */
public static native void yield();
```
注意点：<br />
1. 它只是一个hint方法，只能给CPU一个提醒，有可能被CPU忽略；
2. 如果执行了，当前线程会从RUNNING状态进入RUNNABLE状态；
3. yield方法可以看成是sleep(0),因此,如果在同步代码块中，并不放弃monitor锁；
4. 因为yield方法不进入BLOCKED状态，因此不会抛出InterruptedException异常；

```java
/* 返回当前正在执行的线程 */
public static native Thread currentThread();
```

```java
/* 打断被调用线程 */
public void interrupt();
```
注意点：<br />
1. 通过调用wait/sleep/join等方法而进入阻塞状态的线程，可以被其他线程调用此线程的interrupt方法打断；
2. interrupt方法会给此线程标记一个打断状态，如果正处于阻塞状态则会立刻抛出InterruptedException异常，如果稍后才进入阻塞状态，则在进入时抛出此异常；
3. 抛出InterruptException异常后，会立刻清除打断状态的标记；
4. 由于未获取monitor锁导致的阻塞并不会被打断;

```java
/* 线程是否已被打断 */
public static boolean interrupted();
```
注意点：<br />
1. 获取当前线程的打断标记，获取到之后会重置该标记；


```java
/* 线程是否已被打断 */
public boolean isInterrupted();
```
注意点：<br />
1. 获取当前线程的打断标记，获取到之后并不会重置该标记；


```java
/**
  *  将被调用的线程加入到当前线程中
  *  调用后，当前线程会进入BLOCKED状态，直到被调用线程执行完毕或当前线程的BLOCKED状态被打断；
  */
public void join();

/**
  *  将被调用的线程加入到当前线程中
  *  调用后，当前线程会进入BLOCKED状态，直到被调用线程执行完毕或当前线程的BLOCKED状态被打断，或者超过指定时间
  */
public void join(long times);
```
注意点：<br />
1. join方法的英文注释是：Waits for this thread to die.非常简洁明了。
2. 如果这个thread还没有start或者已经terminated了，就不会有任何效果。
3. 使用场景：一个线程需要等待其他一个或者几个线程执行完毕，才能进行下一步操作时，需要在这个操作前join其他的线程；


## ThreadGroup的API
```java
/* 将该group中的所有线程的interrupt标识都设置成true */
public final void interrupt();

/* 销毁指定线程组及其子线程组 */
/* 注意：调用该方法之前必须保证该线程组下所有线程必须已经停止，即没有活动线程存在，否则将抛出异常 */
public final void destroy();

/*
 * A daemon thread group is automatically destroyed when its last
 * thread is stopped or its last thread group is destroyed.
 * 一个守护线程组会被自动销毁，当他的最后一个线程停止或者他的最后一个线程组被销毁时。
 */
public final boolean isDaemon();
```
