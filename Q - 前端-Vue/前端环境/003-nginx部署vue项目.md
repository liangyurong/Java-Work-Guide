

1、假设已经完全写好了一个vue项目。比如当前的项目路径如下

```txt
D:\test\vuepro\vue-test
```

2、cd到当前的项目路径下，输入以下命令进行打包，会生成dist项目

```txt
npm run build  //相当于打包项目
```

补充：注意：需要完整版的vue-cli项目，即通过vue init webpack初始化的项目才可以。
通过vue init webpack-simple初始化的项目没有打包文件，无法打包。

3、复制dist里面所有的文件

4、去到nginx目录的html文件夹里面，粘贴 **所复制的内容** 到html文件夹

5、去到nginx的conf文件夹，编辑nginx.conf文件

```txt
    server {
        listen       8081;   //端口号
        server_name  localhost; //服务名
        #charset koi8-r;
        #access_log  logs/host.access.log  main;
        location / {
            root   html;  //根路径
            index  index.html; //首页
        }
```

6、cd到nginx的安装目录，输入 start nginx ，启动nginx

7、打开浏览器输入：localhost:8081/ , 即可访问到首页
