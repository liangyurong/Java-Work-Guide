### docker安装mysql

启动docker

    sudo systemctl start docker

拉取mysql镜像

    sudo docker pull mysql:5.7

查看镜像

    docker images

启动MySQL容器

    docker run -p 3306:3306 --name mysql -v /mydata/mysql/log:/var/log/mysql -v /mydata/mysql/data:/var/lib/mysql -v /mydata/mysql/conf:/etc/mysql -e MYSQL_ROOT_PASSWORD=123456 -d mysql:5.7

    启动成功输出：3728a4b77f937402708f5de98b30e0482e76294953307196c6cf2f8c4c5519b2，说明容器启动成功

启动命令行解释

    -v /mydata/mysql/log:/var/log/mysql ： 将日志文件夹挂载到主机
    -v /mydata/mysql/data:/var/lib/mysql： 将配置文件夹挂载到主机
    -v /mydata/mysql/conf:/etc/mysql    ： 将配置文件夹挂载到主机
    -e MYSQL_ROOT_PASSWORD=123456       ： 初始化用户密码

    什么是挂载：将容器内的文件类似快捷方式放到linux容器中，这样就不用每次都去到docker容器里面查看文件。

查看启动的容器

    docker ps
    
重启mysql容器

    docker restart mysql
    

    
    