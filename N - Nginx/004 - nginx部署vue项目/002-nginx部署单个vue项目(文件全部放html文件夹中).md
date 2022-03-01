## 注意

将项目部署到nginx中，此时vue项目中的端口已经没用了，得在nginx.conf中设置监听端口

直接将vue项目打包，放到nginx的html文件夹中，则router文件夹的index.js文件，需要去掉mode:'history'，此时访问路径有#号
```text
const router = new Router({
  // mode: 'history',
  ...
}  
```

### 如果有mode: 'history'

此时配置nginx进行转发

## 步骤

### 1、设置nginx.conf

```txt

#user  nobody;
worker_processes  1;

#error_log  logs/error.log;
#error_log  logs/error.log  notice;
#error_log  logs/error.log  info;

#pid        logs/nginx.pid;


events {
    worker_connections  1024;
}


http {
    include       mime.types;
    default_type  application/octet-stream;

    #log_format  main  '$remote_addr - $remote_user [$time_local] "$request" '
    #                  '$status $body_bytes_sent "$http_referer" '
    #                  '"$http_user_agent" "$http_x_forwarded_for"';

    #access_log  logs/access.log  main;

    sendfile        on;
    #tcp_nopush     on;

    #keepalive_timeout  0;
    keepalive_timeout  65;

    #gzip  on;
	
	
server {

        listen       8888;
		
        server_name  localhost;

        #charset koi8-r;

        #access_log  logs/host.access.log  main;

        location /{
            # 主文件夹
            root   html;  
            index  login.html;
        }
     
        error_page   500 502 503 504  /50x.html;
        location = /50x.html {
            root   html;
        }

   }
 
}

```

### 2、部署项目

1、将vue项目打包，复制里面的所有文件

2、进入含有nginx.exe的路径，然后将文件放在html里面

3、访问路径：http://localhost:8888/login.html   （vue项目的端口是8609，但现在得看nginx的访问端口8888）

