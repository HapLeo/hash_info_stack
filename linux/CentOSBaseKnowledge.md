1.vim: command not found 命令找不到。
- 用 ``rpm -qa | grep vim  ``命令查看vim相关组件是否缺少；
正常会有：
  - vim -X11
  - vim -minimal
  - vim -common
  - vim -enhanced
  - vim -filesystem

- 如果缺少,则可用``yum -y install vim [缺少的控件名]``进行安装；
- 也可使用``yum -y install vim*``安装全部控件；
- [说明1] rpm:RedHat Package Manager.RedHat发行版的软件包管理器，-q查询(query) -a:所有(all)；
- [说明2] yum: YellowDog Updater Modified.YellowDog发行版的基于rpm的软件包管理器，具有自动下载和安装功能，-y:所有选项默认yes；
