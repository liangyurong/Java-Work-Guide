### 父类pom文件依赖爆红

### 原因

父项目只是用于父工程管理依赖的，用于统一管理jar的版本，并没有真正下载jar文件到本地仓库。

子工程需要使用相应的jar引入依赖即可，这时才真正的使用到相应jar，才会去下载。所以将<dependencyManagement>标签先去除。先让maven去把jar下载到本地仓库，下好了再加上<dependencyManagement>标签即可解决

### 解决

暂时注释<dependencyManagement>和</dependencyManagement>，jar包下载完毕后在把注释去了












