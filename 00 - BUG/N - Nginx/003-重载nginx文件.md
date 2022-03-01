
## nginx重载，出现

bug信息：nginx: [error] OpenEvent("Global\ngx_reload_16464") failed (2: The system cannot find the file specified)

背景：输入命令nginx -s reload

原因：没启动nginx

解决：输入命令start nginx



















