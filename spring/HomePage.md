# Spring by Pivotal.
>     Privotal:英文“关键的”意思，这里是开发Spring的公司，该公司同时拥有VMWare,Redis,RabitMQ等产品

### Spring FrameWork 5.0 --- The right stack for the right job.
End to end support for reactive & servlet based apps on the JVM.[Learn more](https://content.pivotal.io/spring/oct-4-getting-reactive-with-spring-framework-5-0-s-ga-release-webinar)
>     [α]Spring 框架 --- 正确的堆栈为正确的职能。
>     对基于响应式（Reactive）和servlet的JVM应用提供端到端的支持。
>     [α]端到端可理解为客户端到服务器端。

### SpringOne Platform by Pivotal. --- Put a little spring in your app.
Join your cloud-native community at SpringOne Platform  and build software people love.[Register Now](https://springoneplatform.io/?utm_source=springio&utm_medium=homepage-banner&utm_campaign=s1p-registration-promo)
>     SpringOne 平台 --- 放置一个小的spring到你的应用中。
>     在SpringOne平台加入云原生社区，构建人们喜爱的软件。
>     知乎上关于云原生的讲解[点此了解](https://zhuanlan.zhihu.com/p/27196777)

### Automate Ops for Spring Cloud on Cloud Foundry.
Build Spring microservices with Cloud Foundry's new container networking stack.[Learn more](https://content.pivotal.io/blog/building-spring-microservices-with-cloud-foundrys-new-container-networking-stack)

>     在Cloud Foundry 上进行Spring Cloud 的自动化部署。
>     通过Cloud Foundry 的新的网络堆叠栈容器构建Spring 微服务。
>     Cloud Foundry（云工厂）:VMware推出的业界第一个开源PaaS云平台,
>     它支持多种框架、语言、运行时环境、云平台及应用服务，
>     使开发人员能够在几秒钟内进行应用程序的部署和扩展，
>     无需担心任何基础架构的问题。[来源](https://baike.baidu.com/item/Cloud%20Foundry/6868029?fr=aladdin)
>     Spring Cloud: 一系列框架的有序集合。
>     它利用Spring Boot的开发便利性巧妙地简化了分布式系统基础设施的开发，
>     如服务发现注册、配置中心、消息总线、负载均衡、断路器、数据监控等，
>     都可以用Spring Boot的开发风格做到一键启动和部署。
>     [来源](https://baike.baidu.com/item/spring%20cloud/20269825?fr=aladdin)


### Pivotal web services
Zero friction Spring Boot deployment to the cloud.[Learn more](http://run.pivotal.io/spring/)
>     Pivotal 的Web 服务
>     Spring Boot的零冲突部署到云。

### Spring Cloud Dalston Released
Spring Cloud Dalston debuts composite Config Server backends,Vault secrets.[Learn more](https://spring.io/blog/2017/04/12/spring-cloud-dalston-released)

>     Spring 云 Dalston 已发布
>     Spring 云 Dalston 首次整合Config Server 后端和Vault secrets.
>     Spring Cloud Config Server:Spring 云端配置服务中心。[了解更多](https://segmentfault.com/a/1190000006138698)
>     Vault:HashiCorp Vault是一个私密信息管理工具，
>     用于管理数据库登录信息、SSL证书、秘钥、API认证等私密信息。
>     [了解更多](https://www.huangyunkun.com/2016/12/11/hashicorp-vault/)


### Spring :the source for modern java
![](https://github.com/HapLeo/HashInfoStack/blob/master/Spring/images/Spring.jpg)
>     Spring:新式Java的资源。

- Spring Boot:build anything.
  - Spring Boot is designed to get you up and running as quickly as possible,with minimal upfront configuration of Spring.Spring Boot takes an opinionated view of building production ready applications.

>     Spring Boot:搭建一切。
>     Spring Boot 致力于对Spring最小化前期配置下让你尽可能快速的搭建和运行项目。
>     Spring Boot 执念于搭建预产品应用。

- Spring Cloud:coordinate anything.
  - Built directly on Spring Boot's innovative approach to enterprice Java,Spring Cloud simplifies distributed,microservice-style architecture by implementing proven patterns to bring resilience,reliability,and coordination to your microservices.

>     Spring Cloud : 整合一切。
>     基于Spring Boot 的创新型方法直接搭建企业级Java,
>     Spring Cloud 通过实现成熟的模式简化了分布式、微服务风格的架构，
>     为你的微服务提供弹性、可靠性和扩展性。

- Spring Cloud Data Flow: Connect Everything.
  - Connect the Enterprise  to the  Internet of Anything-mobile devices,sensors,wearables,automobiles,and more.Spring Cloud Data Flow provides a unified service for creating composable data microservices that address streaming and ETL-based data processing patterns.

>     Spring Cloud Data Flow:连接一切。
>     连接企业到互联网的任意移动设备、传感器、可穿戴设备、汽车(automobiles)或者更多。
>     [α]Spring Cloud Data Flow 为创建可共存的数据微服务提供了一个统一的服务，
>     这些微服务用于处理Streaming 和基于ETL的数据过程模式。
>     Streaming:流媒体。[了解更多](https://baike.baidu.com/item/Streaming/3790847?fr=aladdin)
>     ETL: Extract-Transform-Load,抽取-转换-加载，一种数据仓库技术。
>     [了解更多](https://baike.baidu.com/item/ETL/1251949)

### Spring Framework 5
![](https://github.com/HapLeo/HashInfoStack/blob/master/Spring/images/Spring-support-architecture.jpg)

#### Reactive stack
Spring WebFlux is a non-blocking web framework built from the ground up to take advantage of multi-core,next-generation processors and handle massive numbers of concurrent connections.

>     Spring WebFlux 是一个非阻塞式的web框架，利用多核、下一代处理器处理大量的并发连接。

#### Servlet stack
Spring MVC is built on the Servlet API and uses a synchronous blocking I/O architecture with a one-request-per-thread model.

>     Spring MVC 基于Servlet API搭建并且使用一次请求一个线程模式的同步阻塞I/O架构。


Reactive stack | Servlet stack
--- | ---
Netty,Servlet3.1+ 容器 | Servlet 容器
响应式流适配器 | Servlet API
响应式Spring Security框架 | Spring Security框架
Spring WebFlux | Spring MVC
Spring Data Reactive Repositories | Spring Data Repositories

>     [α]Spring Data Reactive Repositories : Spring 响应式数据仓库，
>     指Spring提供对Mongo,Cassandra,Redis,Couchbase等响应式数据库的支持。
>     [α]Spring Data Repositories: Spring 数据仓库
>     ，指Spring提供对JDBC,JPA,NoSQL的支持。

#### The right technology stack for the job at hand
Developers are constantly challenged with choosing the most effective runtime,programming   model and architecture for their application's requirements and team's skill-set.For example,some [use cases](https://spring.io/blog/2016/06/07/notes-on-reactive-programming-part-i-the-reactive-landscape#reactive-use-cases) are best handled by a technology stack based on  synchronous blocking I/O architecture while others would be better served by an asynchronous,and non-blocking stack built on the reactive design principles described in the [Reactive Stream Specification](http://www.reactive-streams.org/).


Reactive Spring represents a platform wide initiative to deliver reactive support at every level of the development stack - web,security,data,messaging,etc.Spring Framework 5 delivers on this vision by providing a new reactive web stack called,Spring WebFlux,witch is offered side-by-side with the traditional Spring MVC web stack. The choice is yours!


[WebFlux Reference Documentation](https://docs.spring.io/spring/docs/current/spring-framework-reference/web-reactive.html#spring-webflux)

>     开发者在为他们的应用需求和团队技能池选择最有效的模型和架构时常常会遇到挑战。
>     例如，一些用例被基于同步阻塞I/O架构很好的处理，
>     而其他的用例使用基于响应式流规范的响应式设计原则搭建的非同步的、非阻塞栈会更好。
>     [WebFlux相关文档](https://docs.spring.io/spring/docs/current/spring-framework-reference/web-reactive.html#spring-webflux)

>     Reactive Spring 代表了一个在每个开发栈级别广泛提供响应式支持的平台-web,安全，数据，消息等。
>     Spring Framework 5 兑现了提供一个新的响应式web栈的愿景，叫做Spring WebFlux，
>     它与传统的Spring MVC web 栈同时提供。由你来选择！


### Spring Boot

#### BUILD ANYTHING WITH SPIRNG BOOT

Spring Boot is the starting point for building all Spring based applications.Spring Boot is designed to get you up and running as quickly as possible,with minimal upfront configuration of Spring.
- Get started in seconds using Spring Initializr

- Build anything -REST API,WebSocket,Web,Streaming,Tasks,and more

- Simplified Security

- Rich support for SQL and  NoSQL

- Embedded runtime support - Tomcat,Jetty,and Undertow

- Developer productivity tools such as live reload and auto restart

- Curated dependencies that just work

- Production-ready features such as tracing,metrics and health status.

- Works in your favorite IDE -Spring Tool Suite,Intellij IDEA and NetBeans

[Spring Boot Reference Manual](https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/)
[Getting Started Guide](https://spring.io/guides/gs/spring-boot/)

>     用Spring Boot 搭建一切
>     Spring Boot 是搭建所有基于Spring应用的原点。
>     Spring Boot 致力于对Spring最小化前期配置下让你尽可能快速的搭建和运行项目。
>     - 通过 Spring Initializr 秒级启动
>     - 简单的安全机制
>     - 对SQL和NoSQL的丰富支持
>     - 嵌入式运行支持 - Tomcat,Jetty和[Undertow](http://www.jianshu.com/p/0eb011915839)
>     - 开发者生产力工具例如LiveReload和AotoRestart
>     - 精选有效的依赖
>     - 预产品特征例如Tracing,Metrics和 health status.
>     - 支持你最爱的IDE - Spring Tool Suite,Intellij IDEA 和NetBeans.
>     - [Tracing](http://www.jianshu.com/p/599aa49ac79a)
>     - [Metrics](http://blog.csdn.net/tracymkgld/article/details/51899721)
>     - [Spring Tool Suite -Spring定制版Eclipse](https://spring.io/tools/sts/)

### Spring Cloud
COORDINATE ANYTHING:DISTRIBUTED SYSTEMS SIMPLIFIED

Building distributed systems doesn't need to be complex and error-prone.Spring Cloud offers a simple and accessible programming model to the most common distributed system patterns,helping developers build resilient,reliable,and coordinated applications.Spring Cloud is built on top of Spring Boot,making it easy for developers to get started and become productive quickly.

>     整合一切：简化分布式系统
>     搭建分布式系统不需要那么复杂和易错。
>     Spring Cloud 为最普通的分布式系统模式提供了简单易懂的编程模型，帮助开发者建立弹性的、可靠的和可伸缩的应用。
>     Spring Cloud 在Spring Boot 顶端建立，使它更易于开发者开始开发和变得更快速有效。


![from Spring](https://spring.io/img/homepage/diagram-distributed-systems.svg)

#### [Service Discovery](http://blog.csdn.net/top_code/article/details/53559160)
A dynamic directory that enables client side load balancing and smart routing.

>     服务发现：一个允许客户端负载均衡和智能路由的动态目录
#### [Circuit Breaker](http://blog.sina.com.cn/s/blog_72ef7bea0102vvsn.html)
Microservices fault tolerance with a monitoring dashboard.
>     断路器：微服务通过监控仪表板进行容错。

#### [Configuration Server]()
Dynamic,centralized configuration management for your decentralized applications.

>     配置服务：为你的分散的应用提供动态的、中心化的配置管理。

#### [API Geteway](https://www.cnblogs.com/Leo_wl/p/4934036.html)
Single entry point for API consumers(browsers,devices,other APIs)
>     API网关：为API消费者（浏览器、设备、其他API）提供单点入口。


#### [Distributed Tracing]()
Automated application instrumentation and operational visibility for distributed systems.

>     分布式跟踪：为分布式系统提供自动化应用仪表和操作可见性。

#### [OAuth2](http://www.ruanyifeng.com/blog/2014/05/oauth_2_0.html)
Support for single sign on,token relay and token exchange.
>     支持单点登录，令牌传递和令牌交换。


#### Consumer-Driven Contracts(https://martinfowler.com/articles/consumerDrivenContracts.html)
Service evolution patterns to support both HTTP based and message based APIs.
>     消费者驱动协议：服务演化模式支持基于HTTP和基于消息的API。

[View All](http://projects.spring.io/spring-cloud/)

[Spring Cloud Reference Manual](http://cloud.spring.io/spring-cloud-static/Edgware.RELEASE/)

##### Getting Started Guides
[Config：配置](https://spring.io/guides/gs/centralized-configuration/)
[Registry：注册](https://spring.io/guides/gs/service-registration-and-discovery/)
[Breakers：熔断器](https://spring.io/guides/gs/circuit-breaker/)
[Load Balancing：负载均衡](https://spring.io/guides/gs/client-side-load-balancing/)
[Routing：路由](https://spring.io/guides/gs/routing-and-filtering/)


### Spring Cloud Data Flow
#### CONNECT ANYTHING
Spring Cloud Data Flow makes it easy to build and orchestrate cloud-native data
pipelines for use cases such as data ingest,realtime analytics,and data import/export.Spring Cloud Data Flow makes it simple to connect systems by providing out of the box connectors for the most common integration scenarious.

>     Spring Cloud Data Flow 使得搭建和设计例如数据输入、实时分析和数据导入/导出等云原生数据通道更简单。
>     Spring Cloud Data Flow 通过为最常见的整合场景提供外链接使得连接多个系统变得简单。

- Supports processing data in real-time streams and batch
>     支持实时流数据和批数据处理

- Ingest,transform,analyze & store Data
>     输入、传输、分析和存储数据

- Connectors for FTP,RDBMS,Cassandra,RabbitMQ,GemFire,Redis,and much more
>     将FTP,RDBMS,Cassandra,RabbitMQ,GemFire,Redis等等连接起来。

- Spring Flo visual designer for pipelines[了解更多](http://blog.csdn.net/u011054333/article/details/54348014)
>     [α]Spring Flo 为管道提供可视化设计(用于设计流程图的前端框架)

- Operational dashboard -[metrics](https://www.cnblogs.com/super-d2/p/5002061.html),
[health checks](https://segmentfault.com/a/1190000002446630),
and remote management
>     可操作的仪表盘 -metrics,health checks和remote management

- Supported platforms:[Cloud Foundry](https://baike.baidu.com/item/Cloud%20Foundry/6868029?fr=aladdin),
[Kubernetes](http://www.infoq.com/cn/articles/Kubernetes-system-architecture-introduction),
[Apache YARN](https://baike.baidu.com/item/yarn/16075826?fr=aladdin),
[Apache Mesos](https://baike.baidu.com/item/Mesos/19669143?fr=aladdin)
>      支持的平台：Cloud Foundry,Kubernetes,Apache YARN,Apache Mesos

[Spring Cloud Data Flow Reference Manual](https://docs.spring.io/spring-cloud-dataflow/docs/current/reference/htmlsingle/#getting-started)
