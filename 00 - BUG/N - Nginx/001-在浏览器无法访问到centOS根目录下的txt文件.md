
## 在浏览器无法访问到centOS根目录下的txt文件


### 出现bug操作

1、MP_verify_7xeHOqHIb99fOdqQ.txt文件放在了服务器的根目录

2、浏览器访问地址:https://zhfy2.sdyunban.com/MP_verify_7xeHOqHIb99fOdqQ.txt


### bug信息

This is the default 404 error page for nginx that is distributed with Red Hat Enterprise Linux


### 可能的原因

1、Nginx配置问题

2、服务器没开放对应的权限

### 解决:Nginx的配置问题

1、nginx中配置监听的是80端口，设置的root路径是/usr/local/tomcat/vueWeChatPay;

2、在浏览器中访问：https://zhfy2.sdyunban.com/MP_verify_7xeHOqHIb99fOdqQ.txt，其实是会去/usr/local/tomcat/vueWeChatPay的文件目录下查找txt文件

3、而我是把txt文件放在服务器的根目录，而不是在vueWeChatPay文件夹下，因此报错404

4、解决方法：将txt文件放在vueWeChatPay文件夹下

### nginx配置的前端

```text
server {
    # 1.监听80端口。也就是你在浏览器访问你vue项目使用的那个端口。
        listen       80 ;
        # 2.这是你部署的IP，你服务器的公网IP
        server_name  zhfy2.sdyunban.com;
        # 3.这里配置前端打包文件的映射路径
        root  /usr/local/tomcat/vueWeChatPay; 

        # Load configuration files for the default server block.
        include /etc/nginx/default.d/*.conf;

        # 如果vue项目中统一加一个前缀比如/survey，而后端并没有加上前缀/survey，则这里就必须写成 location /survey{ ... }
        location / {
            # 
            root   /usr/local/tomcat/vueWeChatPay;
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

### 注意点

注意是http还是https

