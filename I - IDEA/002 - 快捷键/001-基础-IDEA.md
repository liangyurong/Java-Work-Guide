
### 000-进入自定义快捷键

setting - keymap - main menu - 

### 001 - 安装jetbrains字体

下载之后随便在某个文件夹解压。右键点击“为所有用户安装”。单纯点击“安装”，在2018版本的IDEA中无法找到。

### 002 - IDEA去掉mapper中的黄色

settings -> Editor -> Inspections -> SQL -> No data sources configure取消
settings -> Editor -> Inspections -> SQL -> SQL dialect detection 取消
settings -> Editor -> Color Scheme -> General -> Code -> Injected language fragment -> Background取消

### 003 - 过一段时间打开项目发现很多东西都错误了

鼠标放到IDEA的项目， 右键，maven-->reimport。重新导入之后就可以了。

### 004 - 20英寸屏幕的字体设置

file - setting - 搜索font
- Font：JetBrains Mono
- Size：12
- Line spacing：1.2

### 005 - 去掉enum类的提示

在黄色背景里面，alt+enter，去掉勾选，关闭项目再重启即可。

### 006-IDEA的Project不显示/src/main/java

关闭idea，open，找到项目打开。

备注：不要选择“open recent”

### 去掉重复代码提醒

ctrl+shift+A，搜索Duplicated Code，将General下面的Duplicated Code关闭即可
