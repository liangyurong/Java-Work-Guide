

### 须知

内网服务器需要开放端口，否则nginx是跳转不到的。

### 我们想做什么

比如我们想访问B，但是直接访问不到B。A可以直接访问B，因此我们需要在nginx配置，通过A去访问B。

### 配置说明

-当我们访问192.168.0.1:8008 ， 就会转发到 http://116.168.0.1:8099
- 192.168.0.1必须对应8008端口，否则是不会进行转发的。
- 只是写了server部分，nginx.conf的其他部分并没有给出。

```txt
server {
			listen 8008; #监听端口
			server_name 192.168.0.1; #监听的地址
			#charset koi8-r;
			#access_log  logs/host.access.log  main;

            #对 "/" 启用反向代理
			location / {
				proxy_pass   http://116.168.0.1:8099;
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

```
