
### 一、nginx设置

监听的是8010端口，因此登录用的是http://134.175.207.83:8010/login

134.175.207.83对应的域名是zhcktest.sdyunban.com

```vue
server {
        # 1.监听 8010 端口
        listen       8010;
        # 2.这是你部署的IP，你服务器的公网IP
        server_name  134.175.207.83;
        # 3.这里配置前端打包文件的映射路径
        root /usr/local/tomcat/vue_project/questionnaire_system/dist;

        # Load configuration files for the default server block.
        include /etc/nginx/default.d/*.conf;

        location / {
    		root   /usr/local/tomcat/vue_project/questionnaire_system/dist/;
    		index  index.html;
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
### 二、vue

main.js设置
```vue
axios.defaults.baseURL = 'http://zhcktest.sdyunban.com:8009'; //配置请求的基础路径， 之后在axios的请求路径中就没必要添加
```

### 三、后端访问

端口是8009，

我们在浏览器访问8010，nginx会帮我们进行转发到vue的项目，然后vue项目访问到后端


