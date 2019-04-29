### 单例模式的设计方法
#### 饿汉式
> 优点:线程安全<br />
> 缺点:不能懒加载,不使用也占内存


```java
public class SingletonTest {

    private static SingletonTest ourInstance = new SingletonTest();

    public static SingletonTest getInstance() {

        return ourInstance;
    }

    private SingletonTest() {
    }
}
```

#### 懒汉式
> 优点: 可以懒加载，不调用不占内存
> 缺点: 线程不安全
```java
public class Test {

    private static Test test;

    private Test() {

    }

    private static Test getInstance() {

        if (test == null) {
            test = new Test();
        }
        return test;
    }
}

## Double-Check-Lock
> 优点：可以懒加载，线程安全
```java
public class Test {

    private static Test test;

    private Test() {

    }

    private static Test getInstance() {

        if (test == null) {
            synchronized ("lock") {
                if (test == null) {
                    test = new Test();
                }
            }
        }
        return test;
    }
}
```
