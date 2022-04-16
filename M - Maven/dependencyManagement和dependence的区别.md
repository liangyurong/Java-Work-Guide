### dependencyManagement和dependence的区别

Maven使用dependencyManagement元素来提供一种管理依赖版本号的方式。

通常会在一个组织或者项目的最顶层的父POM中看到dependencyManagement元素。

使用pom.xml中的dependencyManagement元素能让所有在子项目中引用一个依赖而不用显式的列出版本号。

Maven会沿着父子层次向上走，直到找到一个拥有dependencyManagement元素的项目，然后它就会使用这个dependencyManagement元素中指定的版本号。

### 这么做的好处

如果有多个子项目都引用同一样依赖，则可以避免在每个使用的子项目里都声明版本号

这样当想升级或切换到另一个版本时，只需要在顶层父类容器更新，而不需要在众多的子项目中更改。

另外如果某个子项目需要另外的版本，只需要声明version即可。































