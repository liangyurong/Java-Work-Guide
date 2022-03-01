
## 步骤

### 1、设置nginx.conf (设置root文件夹是gja)

```txt
server {

        listen       8888;
	
        server_name  localhost;

        location /{
            # 访问的文件夹
            root   gja;
            index  login.html;
        }
     
        error_page   500 502 503 504  /50x.html;
        location = /50x.html {
            root   html;
        }

   }
 
}
```

### 2、部署项目（项目文件放在gja文件夹，不是html文件）

1、将vue项目打包，复制里面的所有文件

2、进入含有nginx.exe的路径，新建gja文件夹，然后将文件全部粘贴在gja文件夹里面

3、访问路径：http://localhost:8888/login.html   （vue项目的端口是8609，但现在得看nginx的访问端口8888）

