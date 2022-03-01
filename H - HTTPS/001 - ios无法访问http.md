### 安卓可以访问http，ios不可以访问http

安卓使用http可以项目接口，但是ios不可以通过http访问项目接口

ios需要使用https才能访问

### 解决思路

- 所有的安卓机和ios机，都通过https来访问项目接口

- nginx配置好https相关的（好像需要证书什么的，这是还没具体时间过）

- nginx访问路径：https://域名或ip/项目路径

### 参考路径

一般的请求路径： http://zhfy2.sdyunban.com:9852/wechatgyf2/doc.html

转换后的请求路径：https://zhfy2.sdyunban.com/wechatgyf2/doc.html

### nginx配置参考

```txt

server {
        listen         443 ssl;
        server_name  zhfy2.sdyunban.com;  #网站域名
		if  (  $http_frontend_protocol = 'http') {
			return 301 https://$server_name$request_uri;
		}
        ssl             on;
        ssl_certificate /etc/nginx/1_sdyunban.com_bundle.crt;       #证书公钥
        ssl_certificate_key  /etc/nginx/2_sdyunban.com.key;  #证书私钥
        ssl_session_cache    shared:SSL:1m;
        ssl_session_timeout  5m;
        ssl_protocols TLSv1 TLSv1.1 TLSv1.2; 
        ssl_ciphers ECDH:AESGCM:HIGH:!RC4:!DH:!MD5:!3DES:!aNULL:!eNULL;
        ssl_prefer_server_ciphers  on;
		charset utf-8;
     
        location /{
        }	
		
		location /wechatgyf2 {
			proxy_pass http://159.75.5.223:9852/wechatgyf2/;
			proxy_redirect off;
			proxy_set_header Host $host; #后端的Web服务器可以通过X-Forwarded-For>获取用户真实IP
			proxy_set_header X-Real-IP $remote_addr;
			proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
			charset utf-8;
        }
		
        error_page 404 /404.html;
            location = /40x.html {
        }

        error_page 500 502 503 504 /50x.html;
            location = /50x.html {
        }
    }


```
