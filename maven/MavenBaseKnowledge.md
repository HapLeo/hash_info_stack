1.常见的开源构建工具：Maven/Ant/gradle

---

2.Maven是什么？

- 基于项目对象模型（POM），可以通过一小段描述信息来管理项目的构建、报告和文档的软件项目管理工具；

---

3.Maven目录中boot\plexus_classwords.jar是一个类加载器框架，Maven通过该类加载器来加载自己的类库；

---


4.Maven的环境变量配置：
- 跟JDK配置类似，先新建M2_HOME变量并配置上安装包路径，再在path下添加%M2_HOME%\bin;

---

5.Maven中央仓库如何修改？
- Maven默认使用全球中央仓库，可设置国内镜像仓库，方法如下：
    - 打开Maven安装包下conf\settings.xml文件,搜索```<mirrors>```标签，修改相关参数；

---

6.Maven本地仓库配置：
Maven默认本地仓库在用户目录下的.m2目录，通常默认在系统盘，容易丢失，可通过修改settings.xml来改变，方法如下：
 - 搜索```<localRepository>```标签，修改该值。

---

 7.常用版本标识：

 标识 | 含义
 ---|---
 snapshot |  快照版本
 alpha(α) | 内侧版本
 beta(β) | 公测版本
 release | 稳定版本
 GA | 发布版本

---

 8.Maven常用命令：

 命令|作用
 --- | ---
 compile | 编译
 test | 测试
 package|打包
 clean | 删除target
 install | 安装jar包到本地仓库
