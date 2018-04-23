## Core Technologies
Version 5.0.2.RELEASE

This part of the reference documentation covers all of those technologies that are absolutely integral to the Spring Framework.

Foremost amongst these is the Spring Framework’s Inversion of Control (IoC) container. A thorough treatment of the Spring Framework’s IoC container is closely followed by comprehensive coverage of Spring’s Aspect-Oriented Programming (AOP) technologies. The Spring Framework has its own AOP framework, which is conceptually easy to understand, and which successfully addresses the 80% sweet spot of AOP requirements in Java enterprise programming.

Coverage of Spring’s integration with AspectJ (currently the richest - in terms of features - and certainly most mature AOP implementation in the Java enterprise space) is also provided.

```explain
这部分涵盖了Spring Framework的核心技术。
首先是IOC容器，之后紧跟着AOP技术。Spring有自己的AOP框架，而且在企业开发中可以解决80%的AOP需求。Spring也对AspectJ提供了支持，AspectJ是当前在Java企业级领域内功能最丰富、最成熟的AOP实现。
```
### 1. The IoC container
#### 1.1. Introduction to the Spring IoC container and beans
This chapter covers the Spring Framework implementation of the Inversion of Control (IoC) [1] principle. IoC is also known as dependency injection (DI). It is a process whereby objects define their dependencies, that is, the other objects they work with, only through constructor arguments, arguments to a factory method, or properties that are set on the object instance after it is constructed or returned from a factory method. The container then injects those dependencies when it creates the bean. This process is fundamentally the inverse, hence the name Inversion of Control (IoC), of the bean itself controlling the instantiation or location of its dependencies by using direct construction of classes, or a mechanism such as the Service Locator pattern.

The org.springframework.beans and org.springframework.context packages are the basis for Spring Framework’s IoC container. The BeanFactory interface provides an advanced configuration mechanism capable of managing any type of object. ApplicationContext is a sub-interface of BeanFactory. It adds easier integration with Spring’s AOP features; message resource handling (for use in internationalization), event publication; and application-layer specific contexts such as the WebApplicationContext for use in web applications.

In short, the BeanFactory provides the configuration framework and basic functionality, and the ApplicationContext adds more enterprise-specific functionality. The ApplicationContext is a complete superset of the BeanFactory, and is used exclusively in this chapter in descriptions of Spring’s IoC container. For more information on using the BeanFactory instead of the ApplicationContext, refer to The BeanFactory.

In Spring, the objects that form the backbone(骨架) of your application and that are managed by the Spring IoC container are called beans. A bean is an object that is instantiated(被实例化), assembled, and otherwise managed by a Spring IoC container. Otherwise, a bean is simply one of many objects in your application. Beans, and the dependencies among them, are reflected in the configuration metadata used by a container.

```explain
1. Spring的IOC容器代码在org.springframework.beans 和 org.springframework.context包内；
2. BeanFactory接口提供了能够管理任何类型对象的高级配置机制；
3. ApplicationContext是BeanFactory接口的子接口，它添加了与AOP更易整合的特征、信息资源处理（国际化）、事件发布以及应用层特定的上下文如用于web应用的 WebApplicationContext 。
```

#### 1.2. Container overview（容器总览）
The interface org.springframework.context.ApplicationContext represents the Spring IoC container and is responsible for instantiating, configuring, and assembling the aforementioned beans. The container gets its instructions on what objects to instantiate, configure, and assemble by reading configuration metadata. The configuration metadata is represented in XML, Java annotations, or Java code. It allows you to express the objects that compose（组成） your application and the rich interdependencies between such objects.

Several implementations of the ApplicationContext interface are supplied out-of-the-box with Spring. In standalone applications it is common to create an instance of ClassPathXmlApplicationContext or FileSystemXmlApplicationContext. While XML has been the traditional format for defining configuration metadata you can instruct（通知） the container to use Java annotations or code as the metadata format by providing a small amount of XML configuration to declaratively（声明） enable support for these additional metadata formats.

In most application scenarios（场景）, explicit（显式的） user code is not required to instantiate one or more instances of a Spring IoC container. For example, in a web application scenario, a simple eight (or so) lines of boilerplate（模板化的） web descriptor XML in the web.xml file of the application will typically suffice（足够） (see Convenient ApplicationContext instantiation for web applications). If you are using the Spring Tool Suite Eclipse-powered development environment this boilerplate configuration can be easily created with few mouse clicks or keystrokes.

The following diagram is a high-level view of how Spring works. Your application classes are combined with configuration metadata so that after the ApplicationContext is created and initialized, you have a fully configured and executable system or application.

![container-magic](https://github.com/HapLeo/HashInfoStack/tree/master/Spring/images/container-magic.png)

Figure 1. The Spring IoC container

```explain
1. ApplicationContext接口代表了IOC容器，负责实例化、配置、组装对象。
2. 独立项目中通常实例化ClassPathXmlApplicationContext或者FileSystemXmlApplicationContext对象，因为XML是定义配置数据的传统方式，你也可以同时使用注解方式以减少XML中的配置。
```


##### 1.2.1. Configuration metadata（配置元数据）
As the preceding diagram shows, the Spring IoC container consumes a form of configuration metadata; this configuration metadata represents how you as an application developer tell the Spring container to instantiate, configure, and assemble the objects in your application.

Configuration metadata is traditionally supplied in a simple and intuitive(直观的) XML format, which is what most of this chapter uses to convey（传达） key concepts（概念） and features of the Spring IoC container.

XML-based metadata is not the only allowed form of configuration metadata. The Spring IoC container itself is totally decoupled（减弱） from the format in which this configuration metadata is actually written. These days many developers choose Java-based configuration for their Spring applications.

For information about using other forms of metadata with the Spring container, see:

Annotation-based configuration: Spring 2.5 introduced support for annotation-based configuration metadata.

Java-based configuration: Starting with Spring 3.0, many features provided by the Spring JavaConfig project became part of the core Spring Framework. Thus you can define beans external to your application classes by using Java rather than XML files. To use these new features, see the @Configuration, @Bean, @Import and @DependsOn annotations.

Spring configuration consists of at least one and typically more than one bean definition that the container must manage. XML-based configuration metadata shows these beans configured as <bean/> elements inside a top-level <beans/> element. Java configuration typically uses @Bean annotated methods within a @Configuration class.

These bean definitions（定义） correspond（符合） to the actual objects that make up your application. Typically you define service layer objects, data access objects (DAOs), presentation objects such as Struts Action instances, infrastructure objects such as Hibernate SessionFactories, JMS Queues, and so forth. Typically one does not configure fine-grained（细粒度的） domain（域） objects in the container, because it is usually the responsibility of DAOs and business logic（逻辑） to create and load domain objects. However, you can use Spring’s integration（整合） with AspectJ to configure objects that have been created outside the control of an IoC container. See Using AspectJ to dependency-inject domain objects with Spring.

The following example shows the basic structure of XML-based configuration metadata:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="..." class="...">
        <!-- collaborators and configuration for this bean go here -->
    </bean>

    <bean id="..." class="...">
        <!-- collaborators and configuration for this bean go here -->
    </bean>

    <!-- more bean definitions go here -->

</beans>
```
The id attribute is a string that you use to identify（识别） the individual（单独的） bean definition（定义）. The class attribute defines the type of the bean and uses the fully qualified classname. The value of the id attribute refers to collaborating（合作） objects. The XML for referring to collaborating objects is not shown in this example; see Dependencies for more information.

```explain
1. 配置元数据表示开发人员如何告诉Spring容器实例化、配置和装配应用程序中的对象。
2. id属性用来唯一确定一个bean，class属性用来确定这个bean的类型。id用于关联合作对象。

```


##### 1.2.2. Instantiating a container（初始化一个容器）
Instantiating a Spring IoC container is straightforward（直截了当的）. The location path or paths supplied to an ApplicationContext constructor are actually resource strings that allow the container to load configuration metadata from a variety（多样的） of external resources（外部资源） such as the local file system, from the Java CLASSPATH, and so on.

```java
ApplicationContext context = new ClassPathXmlApplicationContext("services.xml", "daos.xml");
```
After you learn about Spring’s IoC container, you may want to know more about Spring’s Resource abstraction(抽象), as described in Resources, which provides a convenient mechanism（机制） for reading an InputStream from locations defined in a URI syntax. In particular（特别地）, Resource paths are used to construct applications contexts as described in Application contexts and Resource paths.

The following example shows the service layer objects (services.xml) configuration file:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- services -->

    <bean id="petStore" class="org.springframework.samples.jpetstore.services.PetStoreServiceImpl">
        <property name="accountDao" ref="accountDao"/>
        <property name="itemDao" ref="itemDao"/>
        <!-- additional collaborators and configuration for this bean go here -->
    </bean>

    <!-- more bean definitions for services go here -->

</beans>
```

The following example shows the data access objects daos.xml file:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="accountDao"
        class="org.springframework.samples.jpetstore.dao.jpa.JpaAccountDao">
        <!-- additional collaborators and configuration for this bean go here -->
    </bean>

    <bean id="itemDao" class="org.springframework.samples.jpetstore.dao.jpa.JpaItemDao">
        <!-- additional collaborators and configuration for this bean go here -->
    </bean>

    <!-- more bean definitions for data access objects go here -->

</beans>
```
In the preceding(前面的) example, the service layer consists of（由...组成） the class PetStoreServiceImpl, and two data access objects of the type JpaAccountDao and JpaItemDao (based on the JPA Object/Relational mapping standard). The property name element refers to the name of the JavaBean property, and the ref element refers to the name of another bean definition. This linkage（联系） between id and ref elements expresses the dependency between collaborating objects. For details of configuring an object’s dependencies, see Dependencies.

######  Composing（组建） XML-based configuration metadata
It can be useful to have bean definitions span multiple XML files(跨多个XML文件). Often each individual（单独的） XML configuration file represents a logical layer（逻辑层） or module in your architecture.

You can use the application context constructor to load bean definitions from all these XML fragments（碎片）. This constructor takes multiple Resource locations, as was shown in the previous section. Alternatively（或者）, use one or more occurrences of the <import/> element to load bean definitions from another file or files. For example:

```xml
<beans>
    <import resource="services.xml"/>
    <import resource="resources/messageSource.xml"/>
    <import resource="/resources/themeSource.xml"/>

    <bean id="bean1" class="..."/>
    <bean id="bean2" class="..."/>
</beans>
```
In the preceding（前面的） example, external（外部的） bean definitions are loaded from three files: services.xml, messageSource.xml, and themeSource.xml. All location paths are relative to the definition file doing the importing, so services.xml must be in the same directory or classpath location as the file doing the importing, while messageSource.xml and themeSource.xml must be in a resources location below the location of the importing file. As you can see, a leading slash（前导斜线，斜杠） is ignored, but given that these paths are relative（相对的）, it is better form not to use the slash at all. The contents of the files being imported, including the top level <beans/> element, must be valid XML bean definitions according to the Spring Schema.

It is possible, but not recommended, to reference files in parent directories using a relative "../" path. Doing so creates a dependency on a file that is outside the current application. In particular, this reference is not recommended for "classpath:" URLs (for example, "classpath:../services.xml"), where the runtime resolution process chooses the "nearest" classpath root and then looks into its parent directory. Classpath configuration changes may lead to the choice of a different, incorrect directory.

You can always use fully qualified resource locations instead of relative paths: for example, "file:C:/config/services.xml" or "classpath:/config/services.xml". However, be aware that you are coupling your application’s configuration to specific absolute locations. It is generally preferable to keep an indirection for such absolute locations, for example, through "${…​}" placeholders that are resolved against JVM system properties at runtime.

The import directive is a feature provided by the beans namespace itself. Further configuration features beyond plain bean definitions are available in a selection of XML namespaces provided by Spring, e.g. the "context" and the "util" namespace.

###### The Groovy Bean Definition DSL（GroovyBean 定义DSL）
As a further example for externalized(实现) configuration metadata, bean definitions can also be expressed in Spring’s Groovy Bean Definition DSL, as known from the Grails framework. Typically, such configuration will live in a ".groovy" file with a structure as follows:

```javascript
beans {
    dataSource(BasicDataSource) {
        driverClassName = "org.hsqldb.jdbcDriver"
        url = "jdbc:hsqldb:mem:grailsDB"
        username = "sa"
        password = ""
        settings = [mynew:"setting"]
    }
    sessionFactory(SessionFactory) {
        dataSource = dataSource
    }
    myService(MyService) {
        nestedBean = { AnotherBean bean ->
            dataSource = dataSource
        }
    }
}
```
This configuration style is largely equivalent（等效的） to XML bean definitions and even supports Spring’s XML configuration namespaces. It also allows for importing XML bean definition files through an "importBeans" directive.

```explain
1. 通常bean的配置会分布在多个xml文件中，每个逻辑层配置一个xml,通过ApplicationContext的构造方法载入多个xml，或者将多个xml通过import标签配置到同一个xml中。
2. 被import的xml最好放在当前xml同级或子文件夹，最好不要放到父文件夹，以免classpath的改变带来加载失败的错误。
```

##### 1.2.3. Using the container（使用容器）
The ApplicationContext is the interface for an advanced factory（高级工厂） capable of（致力于） maintaining a registry of different beans and their dependencies. Using the method T getBean(String name, Class<T> requiredType) you can retrieve instances of your beans.

The ApplicationContext enables you to read bean definitions and access them as follows:

```java
// create and configure beans
ApplicationContext context = new ClassPathXmlApplicationContext("services.xml", "daos.xml");

// retrieve configured instance
PetStoreService service = context.getBean("petStore", PetStoreService.class);

// use configured instance
List<String> userList = service.getUsernameList();
```

With Groovy configuration, bootstrapping（引导） looks very similar（相似）, just a different context implementation class which is Groovy-aware (but also understands XML bean definitions):

```java
ApplicationContext context = new GenericGroovyApplicationContext("services.groovy", "daos.groovy");
```

The most flexible(灵活的) variant（变体） is GenericApplicationContext in combination with（与...联合） reader delegates（读取器委托）, e.g. with XmlBeanDefinitionReader for XML files:

```java
GenericApplicationContext context = new GenericApplicationContext();
new XmlBeanDefinitionReader(context).loadBeanDefinitions("services.xml", "daos.xml");
context.refresh();
```

Or with GroovyBeanDefinitionReader for Groovy files:

```java
GenericApplicationContext context = new GenericApplicationContext();
new GroovyBeanDefinitionReader(context).loadBeanDefinitions("services.groovy", "daos.groovy");
context.refresh();
```

Such reader delegates can be mixed and matched on the same ApplicationContext, reading bean definitions from diverse configuration sources, if desired(渴望的).

You can then use getBean to retrieve（取回） instances of your beans. The ApplicationContext interface has a few other methods for retrieving beans, but ideally your application code should never use them. Indeed, your application code should have no calls to the getBean() method at all, and thus（因此） no dependency on Spring APIs at all. For example, Spring’s integration with web frameworks provides dependency injection for various web framework components such as controllers and JSF-managed beans, allowing you to declare a dependency on a specific bean through metadata (e.g. an autowiring annotation).

```explain
1. 通过  T getBean(String name, Class requiredType) 方法能够拿回容器中实例化的对象，但通常不会这么做，以减少与Spring API的耦合，而是通过声明依赖对象来获得。（例如自动装配的注解）
2. 可以通过DefinitionReader将其他容器中的内容合并到一个GenericApplicationContext 容器中。
```
