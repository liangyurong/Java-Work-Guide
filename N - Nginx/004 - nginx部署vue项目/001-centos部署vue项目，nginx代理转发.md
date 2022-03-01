
## 步骤

### 1、在webstorm将vue项目打包为dist

```text
- 找到项目的config文件夹下面的index.js，定位到build，将里面的assetsPublicPath改成 ./
- 在terminal输入：npm run build 即可打包成dist文件夹 

- 也可以指定打包的路径和包名称，比如： assetsRoot: path.resolve(__dirname, '../docker/html/'),

```

### 2、在centos，将dist文件夹放到该路径：  /usr/local/tomcat/vue_project/questionnaire_system

```text
补充
- 有些目录的权限是不足的，可能在浏览器访问不到，比如root
- /usr/local/tomcat 的路径是本来就存在的，因此我只是将？？？
```

### 3、修改nginx.conf的配置（使用nginx -t查看文件所在路径）（不需要什么跨域和代理）
```text
server {
        # 1.监听8010 端口。也就是你在浏览器访问你vue项目使用的那个端口。
        listen       8010;
        # 2.这是你部署的IP，你服务器的公网IP
        server_name  134.175.207.83;
        # 3.这里配置前端打包文件的映射路径
        root /usr/local/tomcat/vue_project/questionnaire_system/dist; 

        # Load configuration files for the default server block.
        include /etc/nginx/default.d/*.conf;

        # 如果vue项目中统一加一个前缀比如/survey，而后端并没有加上前缀/survey，则这里就必须写成 location /survey{ ... }
        location / {
            # 
            root   /usr/local/tomcat/vue_project/questionnaire_system/dist/;
            index  index.html;
            # 将vue项目部署到nginx，在浏览器刷新页面会出现404，因此要添加 try_files  $uri $uri/ /index.html;
            try_files  $uri $uri/ /index.html;
        }
		
        error_page 404 /404.html;
            location = /40x.html {
        }

        error_page 500 502 503 504 /50x.html;
            location = /50x.html {
        }
    }

```

vue项目中router文件夹中的index.js设置
```text
const router = new Router({
  mode: 'history',
  base:'survey', // 访问路径统一添加前缀
  routes: []
  ...
```


### 4、重载nginx.conf
```text
去到nginx的目录
nginx -s reload
```

### linux查看是否存在nginx

查看 nginx 安装目录
```text
命令：ps -ef | grep nginx

返回结果
nginx      713 28606  0 Feb24 ?        00:01:00 nginx: worker process
root     21597 20868  0 14:24 pts/3    00:00:00 grep --color=auto nginx
root     28606     1  0  2020 ?        00:00:00 nginx: master process /usr/sbin/nginx -c /etc/nginx/nginx.conf
```

查看配置文件nginx.conf 路径。也可以用于检查配置文件是否正确。
```text
nginx -t

返回结果
nginx: the configuration file /etc/nginx/nginx.conf syntax is ok
nginx: configuration file /etc/nginx/nginx.conf test is successful
```

find 命令，从 / 根目录下查找文件名为 nginx.conf 的文件
> find / -name nginx.conf


find 命令，从 /etc 目录下查找文件名为 nginx.conf 的文件
> find /etc -name nginx.conf


### 使nginx.conf重新生效

```text
nginx -s reload
nginx -s stop
nginx
```

### 问题：nginx代理后刷新显示404












