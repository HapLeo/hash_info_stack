#### 1. Java 基本类型与包装类型的对应关系？
基本类型 | 字节数  | 包装类型
--- | --- | ---
byte | 1 | Byte
short | 2 | Short
int | 4 | Integer
long | 8 | Long
float | 4 | Float
double | 8 | Double
char  | 视字符集而定 | Character
boolean | [视JVM而定](https://www.cnblogs.com/wangtianze/p/6690665.html?utm_source=itdadao&utm_medium=referral) | Boolean

##### 2. 何时拆箱？何时装箱？

装箱：在基本类型的值赋值给包装类型时触发。
例如：
```Java
Integer a = 1; //编译成Integer a = Integer.valueOf(1);
```

拆箱：

1.在包装类型赋值给基本类型时触发。

例如：
```Java
Integer a = 1;  // a 是Integer类型

int b = a;  // 将Integer类型赋值给int类型，触发拆箱
```
2.在做运算符运算时触发。

例如：

  ```Java
  Integer a = 1;

  Integer b = 2;

  System.out.print(a * b); //这时a*b在二进制文件中被编译成a.intValue() * b.intValue();
```


**注意点：**

a.分清比较的是什么。
- Integer == Integer : 不拆箱，比较引用地址是否相同
- Integer == int :拆箱，比较值是否相同

例如：
```Java
Integer a = 1000;
Integer b = 1000;
int c = 1000;
System.out.println(a == b); // 返回false，因为a 和 b不是同一个对象
System.out.println(a == c); // 返回true，触发拆箱，编译成System.out.println(a.intValue() == b);

```
b.装箱方法有缓存。
```java
Integer a = 128;
Integer b = 128;
Integer c = 127;
Integer d = 127;
System.out.print(a == b); // 返回false
System.out.print(c == d); // 返回true
```
>     原因是Integer 的装箱（Integer.valueOf()）方法会自动缓存-128~127之间的值，
>     多次装箱同一个值实际上用的是同一个对象，因此这里 a == b 是false，
>     因为不是同一个对象，而 c==d 是true，因为使用缓存中的同一个对象，而不是因为值相等。

【举例说明】

```java
Integer a = 127;
Integer e = new Integer(127);
Integer f  = Integer.intValue(127);
System.out.println(a == e); // 返回false，不是同一个对象
System.out.println(a == f); // 返回true，是缓存中同一个对象

```

##### 3. Java中equals()方法与hashCode()方法的关系？
- equals()和hashCode()都在Object中定义。
- Object中equals()方法与==判断相同。
- Java中八大基本类型以及String类型均重写了equals()方法，用于判断对象值是否相等。
- 通常重写equals()方法时也会重写hashCode()方法，因为Java 中约定如果equals()返回true则hashCode必须相同，反之则不然。
- hashCode的作用是将对象存入数组等hash数据结构时，会根据对象的hash值自动归类，便于快速查找。因此，多个对象hashCode相同属于正常现象。
[【文章推荐】](http://blog.csdn.net/u011208377/article/details/49744025)
