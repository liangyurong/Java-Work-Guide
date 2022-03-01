

### 前提

cmd输入taskmgc进入任务管理器，无法关闭nginx.exe

nginx -s stop也没用

### 解决

进入含有nginx.exe的目录，在路径输入cmd然后回车，打开cmd之后输入命令：taskkill /f /t /im nginx.exe

然后双击nginx.exe启动


