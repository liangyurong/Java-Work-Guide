## dependencyManagement和dependency的区别

dependencyManagement只是声明依赖，并不引入。

    只是管理版本号和子模块的依赖，并不会引入依赖

dependencyManagement能让所有在子项目中引用一个依赖而不用显式列出版本号。maven会沿着父子层级往上走，直到找到一个拥有dependencyManagement元素的项目，然后就会使用dependencyManagement元素中指定的版本号。

子模块pom继承父类之后，dependencyManagement提供的作用：锁定版本+子module不用写groupId和version

