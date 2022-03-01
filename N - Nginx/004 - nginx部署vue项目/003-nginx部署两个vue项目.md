## nginx部署两个vue项目

### 1、设置nginx.conf

```txt
worker_processes  1;

events {
    worker_connections  1024;
}

http {
    include       mime.types;
    default_type  application/octet-stream;
    sendfile        on;
    keepalive_timeout  65;
	
# 主要配置	
server {

        listen   8888;
		
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

1、将两个vue项目打包，分别是people和student文件夹

2、进入含有nginx.exe的路径，然后将两个文件夹放在html里面

3、访问路径：http://localhost:8609/people/login.html , http://localhost:8609/student/login.html 
