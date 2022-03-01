### 0. 删除环境变量

- 如果你之前使用过解压版tomcat，那么需要去系统的环境变量中删除相关变量。比如catlina相关的，比如tomcat路径相关的。

- 只删除以前配置的tomcat相关的。但是不要删除jdk，jre的路径。

### 1. 下载tomcat.exe，最好选择版本8。

- [点击从官网下载版本8的链接](https://tomcat.apache.org/download-80.cgi)

- 从我的115网盘获取。[链接](https://115.com/s/swnsfbu3w3l?password=p997&#) 访问码：p997

![](https://github.com/LiangYurong/imageHouse/blob/master/tomcat/003-%E5%B0%86tomcat%E5%81%9A%E6%88%90%E8%87%AA%E5%90%AF%E5%8A%A8%E6%9C%8D%E5%8A%A1%E5%B9%B6%E9%83%A8%E7%BD%B2war%E5%8C%85/1.png)

- 下载的tomcat.exe如下图

 ![](https://github.com/LiangYurong/imageHouse/blob/master/tomcat/003-%E5%B0%86tomcat%E5%81%9A%E6%88%90%E8%87%AA%E5%90%AF%E5%8A%A8%E6%9C%8D%E5%8A%A1%E5%B9%B6%E9%83%A8%E7%BD%B2war%E5%8C%85/2.png)

### 2. 新建文件夹，命名为tomcat8_8092_mybatisplus。

- 命名规则：tomcat版本+运行端口号+项目名称。

![](https://github.com/LiangYurong/imageHouse/blob/master/tomcat/003-%E5%B0%86tomcat%E5%81%9A%E6%88%90%E8%87%AA%E5%90%AF%E5%8A%A8%E6%9C%8D%E5%8A%A1%E5%B9%B6%E9%83%A8%E7%BD%B2war%E5%8C%85/3.png)

### 3. 复制tomcat.exe到tomcat8_8092_mybatisplus，点击安装tomcat.exe。

![](https://github.com/LiangYurong/imageHouse/blob/master/tomcat/003-%E5%B0%86tomcat%E5%81%9A%E6%88%90%E8%87%AA%E5%90%AF%E5%8A%A8%E6%9C%8D%E5%8A%A1%E5%B9%B6%E9%83%A8%E7%BD%B2war%E5%8C%85/4.png)

### 4. 点击next。

![](https://github.com/LiangYurong/imageHouse/blob/master/tomcat/003-%E5%B0%86tomcat%E5%81%9A%E6%88%90%E8%87%AA%E5%90%AF%E5%8A%A8%E6%9C%8D%E5%8A%A1%E5%B9%B6%E9%83%A8%E7%BD%B2war%E5%8C%85/5.png)

### 5. 点解agree。

![](https://github.com/LiangYurong/imageHouse/blob/master/tomcat/003-%E5%B0%86tomcat%E5%81%9A%E6%88%90%E8%87%AA%E5%90%AF%E5%8A%A8%E6%9C%8D%E5%8A%A1%E5%B9%B6%E9%83%A8%E7%BD%B2war%E5%8C%85/6.png)

### 6. 默认勾选，并不用点击其他选项，直接点击next。

![](https://github.com/LiangYurong/imageHouse/blob/master/tomcat/003-%E5%B0%86tomcat%E5%81%9A%E6%88%90%E8%87%AA%E5%90%AF%E5%8A%A8%E6%9C%8D%E5%8A%A1%E5%B9%B6%E9%83%A8%E7%BD%B2war%E5%8C%85/7.png)

### 7.设置端口，服务名称，设置username和password。点击next。

比如该tomcat设置的端口是8092，以后部署到该tomcat的项目，访问里面项目的端口就是8092，即使项目打包时候的port设置为8081，以后外界访问的也是8092

![](https://github.com/LiangYurong/imageHouse/blob/master/tomcat/003-%E5%B0%86tomcat%E5%81%9A%E6%88%90%E8%87%AA%E5%90%AF%E5%8A%A8%E6%9C%8D%E5%8A%A1%E5%B9%B6%E9%83%A8%E7%BD%B2war%E5%8C%85/8.png)

### 8.默认选择，点击next。（如果默认路径不对，需要进行修改。一般都是对的）

![](https://github.com/LiangYurong/imageHouse/blob/master/tomcat/003-%E5%B0%86tomcat%E5%81%9A%E6%88%90%E8%87%AA%E5%90%AF%E5%8A%A8%E6%9C%8D%E5%8A%A1%E5%B9%B6%E9%83%A8%E7%BD%B2war%E5%8C%85/9.png)

### 9. 选择自己刚建立的文件夹。点击install。出现提示，直接点击确定即可。最后安装完成点击finish。

![](https://github.com/LiangYurong/imageHouse/blob/master/tomcat/003-%E5%B0%86tomcat%E5%81%9A%E6%88%90%E8%87%AA%E5%90%AF%E5%8A%A8%E6%9C%8D%E5%8A%A1%E5%B9%B6%E9%83%A8%E7%BD%B2war%E5%8C%85/10.png)

### 10. 显示正在启动。启动之后点击close。

![](https://github.com/LiangYurong/imageHouse/blob/master/tomcat/003-%E5%B0%86tomcat%E5%81%9A%E6%88%90%E8%87%AA%E5%90%AF%E5%8A%A8%E6%9C%8D%E5%8A%A1%E5%B9%B6%E9%83%A8%E7%BD%B2war%E5%8C%85/11.png)

### 11.安装成功，查看文件。

![](https://github.com/LiangYurong/imageHouse/blob/master/tomcat/003-%E5%B0%86tomcat%E5%81%9A%E6%88%90%E8%87%AA%E5%90%AF%E5%8A%A8%E6%9C%8D%E5%8A%A1%E5%B9%B6%E9%83%A8%E7%BD%B2war%E5%8C%85/12.png)

### 12. win+r，输入services.msc，发现服务存在且开启。

![](https://github.com/LiangYurong/imageHouse/blob/master/tomcat/003-%E5%B0%86tomcat%E5%81%9A%E6%88%90%E8%87%AA%E5%90%AF%E5%8A%A8%E6%9C%8D%E5%8A%A1%E5%B9%B6%E9%83%A8%E7%BD%B2war%E5%8C%85/13.png)

### 13.浏览器输入：localhost:8092，出现下面界面说明启动成功。

![](https://github.com/LiangYurong/imageHouse/blob/master/tomcat/003-%E5%B0%86tomcat%E5%81%9A%E6%88%90%E8%87%AA%E5%90%AF%E5%8A%A8%E6%9C%8D%E5%8A%A1%E5%B9%B6%E9%83%A8%E7%BD%B2war%E5%8C%85/14.png)

### 14.关闭tomcat服务。去到tomcat的安装目录，打开webapps文件夹，删除里面所有的文件（不用删除也行），然后放入一个打包好的war包。然后重启tomcat服务。


war包下载链接：https://115.com/s/swnsfod3w3l?password=i1f3&#   访问码：i1f3

![](https://github.com/LiangYurong/imageHouse/blob/master/tomcat/003-%E5%B0%86tomcat%E5%81%9A%E6%88%90%E8%87%AA%E5%90%AF%E5%8A%A8%E6%9C%8D%E5%8A%A1%E5%B9%B6%E9%83%A8%E7%BD%B2war%E5%8C%85/15.png)

### 15.重启之后，webapps文件夹如下。增加了testdemo文件夹。

![](https://github.com/LiangYurong/imageHouse/blob/master/tomcat/003-%E5%B0%86tomcat%E5%81%9A%E6%88%90%E8%87%AA%E5%90%AF%E5%8A%A8%E6%9C%8D%E5%8A%A1%E5%B9%B6%E9%83%A8%E7%BD%B2war%E5%8C%85/16.png)

### 16.打开浏览器，输入http://localhost:8092/testdemo/hi 。出现结果说明部署war且运行成功。（访问路径需要带上项目名称）

![](https://github.com/LiangYurong/imageHouse/blob/master/tomcat/003-%E5%B0%86tomcat%E5%81%9A%E6%88%90%E8%87%AA%E5%90%AF%E5%8A%A8%E6%9C%8D%E5%8A%A1%E5%B9%B6%E9%83%A8%E7%BD%B2war%E5%8C%85/17.png)

### 17.  方法一：访问路径去掉项目名。比如这里的项目名是testdemo。

- 以前的访问路径：localhost:8092/testdemo/hi

- 设置之后的访问路径：localhost:8092/hi

- 操作：关闭tomcat服务。打开tomcat目录下的conf文件夹，找到server.xml。将里面的appBase设置为空，并添加下边那一行代码，其中docBase设置为项目的部署目录路径。

```java
<Host name="localhost"  appBase="" unpackWARs="true" autoDeploy="true">
<!--下面一行代码需要自己手动添加-->
<Context path="" docBase="D:\lyr\mytomcat\tomcat8_8092_mybatisplus\webapps\testdemo" debug="0" reloadable="true" crossContext="true"/>
```
- 设置之后，打开tomcat服务。打开浏览器输入：localhost:8092/hi，得到结果即说明设置成功。

![](https://github.com/LiangYurong/imageHouse/blob/master/tomcat/003-%E5%B0%86tomcat%E5%81%9A%E6%88%90%E8%87%AA%E5%90%AF%E5%8A%A8%E6%9C%8D%E5%8A%A1%E5%B9%B6%E9%83%A8%E7%BD%B2war%E5%8C%85/18.png)

### 18. 方法二：访问路径去掉项目名。比如这里的项目名是testdemo。

- 注意点：只能在没有进行方法一的情况下进行操作。

- 关闭tomcat服务。

- 新建ROOT文件夹。

![](https://github.com/LiangYurong/imageHouse/blob/master/tomcat/003-%E5%B0%86tomcat%E5%81%9A%E6%88%90%E8%87%AA%E5%90%AF%E5%8A%A8%E6%9C%8D%E5%8A%A1%E5%B9%B6%E9%83%A8%E7%BD%B2war%E5%8C%85/19.png)

- 将testdemo文件夹的所有文件，剪切到ROOT文件夹。

- 开启toncat服务，ok。访问路径也可以不带testmo项目名：localhost:8092/hi
