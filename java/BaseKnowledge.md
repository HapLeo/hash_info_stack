1.native修饰符的用法？
-  native修饰符用于修饰方法，表示该方法为原生方法（本地方法），
被修饰的方法不能有方法体，其具体实现由C/C++/汇编等语言完成；

- native是Java 的 JNI(Java Native Interface) 部分，是Java与底层操作系统、硬件信息、其他语言交互的通道。其他语言实现的方法生成dll(Dynamic Link Library 动态链接库)文件，当执行native方法时通过JVM的java.system.loadLibrary()加载执行；
- 参考：[百度百科](https://baike.baidu.com/item/native/13128691#viewPageContent)

---

2.创建对象有哪些方法？
- 用new语句调用构造函数创建；
- 反射：调用java.lang.Class或java.lang.reflect.Constructor类的newInstance()方法；
- 克隆：调用对象的clone()方法复制已有的对象；
- 反序列化：调用java.io.ObjectInputStream对象的readObject()方法；

---

3.[注意点]Java中URL对象的equals（）判断方式：
- 在联网状态下将URL解析为IP地址再进行比较，因此不同的URL也可能相等；
- 非联网状态下URL无法解析成IP地址，因此根据URL的字符串值判断；
- 这个注意点告诉我们，不要用Set或Map的key存储URL对象，因为有可能会被覆盖。
- 解决办法：可以使用URI来代替URL；

---

4.HashMap与Hashtable的区别？
- HashMap效率高，非线程安全；Hashtable效率低，线程安全；
- HashMap的key和value均允许为null，切最多一个；Hashtable的key和value均不允许null;
- HashMap: extends AbstractMap implements Map;
  Hashtable: extends Dictionary implements Map;

5.关于构造函数：
- 不能被覆盖（很好理解，父类和子类名称不可能相同）；
- 子类执行构造函数（实例化）前会先执行父类的构造函数（先实例化父类），父类的属性、方法因此能被子类对象调用；

---

6.方法/元素的访问级别是怎样的？
- 从严到宽：
- private：自己
- default：自己+同包
- protected： 自己+同胞+子类
- public：所有

控制符|自己 |同胞|子类|所有
---|---|---|---|---
private|√|×|×|×
default|√|√|×|×
protected|√|√|√|×
public|√|√|√|√
---

7.分布式与集群该如何理解？
- 分布式：分解任务，同一任务多台机器执行，提高效率；
- 集群：分散任务，多个任务分散执行，提高可靠性；
- 场景：
    - 食堂有多个窗口，每个窗口的任务都是提供饭菜，多个窗口的任务相同，是为了分散每个窗口的任务量，这叫集群；
    - 每个窗口里面都有各自的打饭阿姨、厨师、配菜员、清洁员，分工明确，这叫分布式；

---
8.常用的线程池有哪些？
- Java中可以通过Executors类的几个静态方法来创建线程池：


  方法名 | 特点
    --- | ---
    newCachedThreadPool()|有线程请求时才创建,超时自动结束线程
    newFixedThreadPool(int coreThreadSize)| 创建一个固定大小的缓冲池
    newSingleThreadExecutor() |创建容量为1的缓冲池

  - 上述静态方法均是调用ThreadPoolExecutor的构造方法传入不同的值进行实例化获得的。Java推荐使用上述三种静态方法创建线程池；
  - [参考博客](http://blog.csdn.net/u011531613/article/details/61921473)

---

9.数据库优化有哪些方法？
- SQL优化
- 建立索引
- 横向分割（解决单表数据量大问题）
- 纵向分割（解决多表之间IO竞争问题）
- 读写分离
- 数据库参数配置（最大连接数/连接超时时间等）
- 提高硬件性能



10.ThreadLocal的使用？

11.equals()与hashCode()的关系？

- 推荐好文：[散列码/HashCode的理解与应用](http://blog.csdn.net/u011208377/article/details/49744025)

12.自动装箱/拆箱相关知识点？

13.常用的查找算法/排序算法及复杂度总结？

14.多线程编程在工作中的应用？

15.HashMap的底层实现原理？

16.分表分库数据处理方式？

17.秒杀系统的设计与实现？

18.哪些方法能够保持同步？

19.Java的多态性体现在哪里？

20.String 为什么是不可变的？

21.字符串倒序算法？

22.静态方法能否调用非静态方法？

23.分布式框架需要了解！
