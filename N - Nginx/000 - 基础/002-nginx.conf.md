
### nginx.conf 结构分析

Nginx的主配置文件是nginx.conf，这个配置文件一共由三部分组成，分别为全局块、events块和http块。


在http块中，又包含http全局块、多个server块。每个server块中，可以包含server全局块和多个location块。在同一配置块中嵌套的配置块，各个之间不存在次序关系。

### 全局块

从配置文件开始到events块之间的内容，主要会设置一些影响nginx服务器整体运行的配置指令，主要包括配置运行Nginx服务器的用户（组），允许生成的worker process数，进程PID存放路径，日志存放路径和类型，以及配置文件的引入等。

全局块
```txt
#user  nobody;
worker_processes  1; //值越大，可以支持处理的并发量越多

#error_log  logs/error.log;
#error_log  logs/error.log  notice;
#error_log  logs/error.log  info;

#pid        logs/nginx.pid;

```

### events块

涉及的指令，主要影响nginx服务器与用户的网络连接。

```txt
events {
    worker_connections  1024; //支持的最大连接数是1024。对nginx性能影响较大，在实际工作中应该灵活应用。
}
```

### http块


### nginx.conf

```conf

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
        listen       8081;       //nginx目前监听的端口是8081。（vue前端的端口是8081，则这里就设置为8081）
        server_name  localhost; //主机ip。（指的是部署nginx的主机ip吗）
        #charset koi8-r;
        #access_log  logs/host.access.log  main;

        location / {
            root   html;  // 根文件夹，也就是浏览器要访问的根文件夹，这里的html文件夹其实就是和nginx.exe等级的文件夹
            index  index.html;
        }

        location /research/ { // 代理访问吗？是直接对应到项目的端口和路径？
            proxy_pass   http://127.0.0.1:7788/research/;
        }

        location /cdr/ {
            proxy_pass   http://127.0.0.1:8081/cdr/;
        }
	
        #error_page  404              /404.html;

        # redirect server error pages to the static page /50x.html
        #
        error_page   500 502 503 504  /50x.html;
        location = /50x.html {
            root   html;
        }

        # proxy the PHP scripts to Apache listening on 127.0.0.1:80
        #
        #location ~ \.php$ {
        #    proxy_pass   http://127.0.0.1;
        #}

        # pass the PHP scripts to FastCGI server listening on 127.0.0.1:9000
        #
        #location ~ \.php$ {
        #    root           html;
        #    fastcgi_pass   127.0.0.1:9000;
        #    fastcgi_index  index.php;
        #    fastcgi_param  SCRIPT_FILENAME  /scripts$fastcgi_script_name;
        #    include        fastcgi_params;
        #}

        # deny access to .htaccess files, if Apache's document root
        # concurs with nginx's one
        #
        #location ~ /\.ht {
        #    deny  all;
        #}
    }


    # another virtual host using mix of IP-, name-, and port-based configuration
    #
    #server {
    #    listen       8000;
    #    listen       somename:8080;
    #    server_name  somename  alias  another.alias;

    #    location / {
    #        root   html;
    #        index  index.html index.htm;
    #    }
    #}


    # HTTPS server
    #
    #server {
    #    listen       443 ssl;
    #    server_name  localhost;

    #    ssl_certificate      cert.pem;
    #    ssl_certificate_key  cert.key;

    #    ssl_session_cache    shared:SSL:1m;
    #    ssl_session_timeout  5m;

    #    ssl_ciphers  HIGH:!aNULL:!MD5;
    #    ssl_prefer_server_ciphers  on;

    #    location / {
    #        root   html;
    #        index  index.html index.htm;
    #    }
    #}

}


```


### 分析 (生产环境下的文件)

```txt
worker_processes  1;

#工作模式与连接数上限
events {
      #单个后台 worker process 进程的最大并发链接数
      #事件模块指令，定义 nginx 每个进程最大连接数，默认 1024。最大客户连接数由 worker_processes 和 worker_connections 决定
      #即 max_client=worker_processes*worker_connections, 在作为反向代理时：max_client=worker_processes*worker_connections / 4
      worker_connections  1024;
}

#设定 http 服务器
http {
	include       mime.types;  #文件扩展名与文件类型映射表
	default_type  application/octet-stream; #默认文件类型
	
	sendfile  on;
	
	keepalive_timeout  65;  #单位是秒，客户端连接时时间，超时之后服务器端自动关闭该连接 如果 nginx 守护进程在这个等待的时间里，一直没有收到浏览发过来 http 请求，则关闭这个 http 连接

	gzip on; #开启 gzip 压缩输出
	
	upstream zyserver {
        #upstream 的负载均衡，weight 是权重，可以根据机器配置定义权重。weigth 参数表示权值，权值越高被分配到的几率越大。
		server 192.168.0.101:80 weight=1;
        server 10.6.1.116:8099 weight=1;
	}

    #虚拟主机的配置
	server {
	
			listen 8008; #监听端口，也就是浏览器访问的端口，比如 localhost:8008/inedx.html。（vue前端的端口是8008，则这里就设置为8008）
			
			server_name localhost; #域名可以有多个，用空格隔开
			
			#charset koi8-r;

			#access_log  logs/host.access.log  main;

                                                #对 "/" 启用反向代理
			location / {
				proxy_pass   http://zyserver;
				proxy_redirect off;
				proxy_set_header Host $host;    #后端的Web服务器可以通过X-Forwarded-For>获取用户真实IP
				proxy_set_header X-Real-IP $remote_addr;
				proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
				client_max_body_size 10m;   #允许客户端请求的最大单文件字节数
				client_body_buffer_size 128k; #缓冲区代理缓冲用户端请求的最大字节数
				proxy_connect_timeout 90;   #nginx跟后端服务器连接超时时间(代理连接超时)
				proxy_read_timeout 90;      #连接成功后，后端服务器响应时间(代理接收超时)
				proxy_buffer_size 4k;       #设置代理服务器（nginx）保存用户头信息的缓冲区大小
				proxy_buffers 6 32k;        #proxy_buffers缓冲区，网页平均在32k以下的话>，这样设置
				proxy_busy_buffers_size 64k; #高负荷下缓冲大小（proxy_buffers*2）
				proxy_temp_file_write_size 64k; #设定缓存文件夹大小，大于这个值，将从upstream服务器传
			}     
	}
}	
```
