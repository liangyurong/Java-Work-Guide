idea使用技巧：https://www.zhihu.com/question/300830746

idea结合github，可以成为一个具有版本控制的笔记本。写了笔记之后就提交到github仓库。

代码格式化：ctrl + alt + L  ，现在改为alt+w

快速提示	按住ctrl，鼠标移动到对应的位置，就可以看到相应的提示。

在当前页查找	ctrl + F

全局搜索某个方法	alt+F7

全局搜搜	ctrl+shift+R

循环输出String[] atr=new String[3];	快速写法：str.for，再enter

在IDEA左侧搜索文件名

关闭打开的标签页

引入相关类：alt  + enter

全局搜索：ctrl+shift+R



文件夹展开所有层级结构：点击"Compact Middle Packages"

展开文件夹所有文件：选中文件夹，再单击 *

字体行间距：File - setting - editor - front

sitka，small，14

设置字体与大小：file - setting - appearance

- 设置注释颜色：file - setting - color scheme - language default

#629755

重写方法：ctrl + o （字母）

编译：ctrl + F9 ， 也就是build project

更改代码格式化的快捷键：file - setting - 搜reformat code

查看源码：ctrl + 鼠标左击


如果不能查看源码：file - setting - 搜plugins - 搜Java Bytecode Decompiler  

复制当前代码到下一行：ctrl + d

添加变量的get，set方法：alt + ins

查看Jar依赖图：在pom.xml文件中选中dependencies，右键选择Diagrams -> show Dependences

在当前类中查找方法：ctrl + F12

搜索项目中的任何方法与类：按shift两次

智能代码提示：ctrl + shift + space

- 展示类或方法的API文档：ctrl + Q

 手动打开IDEA的方法注释：file - setting - editor - general - show quick documentation on mouse move，勾选即可

删除没用到的package：ctrl + alt + o

查找当前类中的一些东西：ctrl + F

展现当前类的所有方法的列表：alt + 7

IDEA上的源码没有注释：原因是用了src.zip和人javafx.src.zip，将两个文件后缀改为jar即可。两个文件在JDk的安装路径：project structure- SDKs - spurce path - 添加两个jar文件

更改使用插件的快捷键，比如在IDEA快速调用translate翻译插件：file - setting - 搜keymap - 在editor actions下通过搜索找到translate，即可修改快捷键

IDEA上的谷歌翻译插件：alt + x

快速运行：alt + t

md add picture

```
![description](link)
```

自定义IDEA的工具栏（以添加git的push为例）

![tupian](https://github.com/LiangYurong/imageHouse/blob/master/%E5%9B%BE%E7%89%87%E5%BA%93/000.png)

