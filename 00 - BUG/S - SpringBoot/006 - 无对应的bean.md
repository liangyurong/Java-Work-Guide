
### bug

1、expected at least 1 bean which qualifies as autowire candidate

2、No qualifying bean of type

### 原因

没扫描到。可能是启动类的MapperScan扫描的路径不全

### 解决

在启动类添加：@MapperScan("com.sdyb.demo.*")

demo文件夹是顶层文件夹，可能很多dao在demo文件夹下的其他几个文件夹。






















