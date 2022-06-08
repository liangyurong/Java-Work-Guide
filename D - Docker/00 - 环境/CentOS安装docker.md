
### docker有两个版本

社区版（Community Edition，缩写为 CE）

企业版（Enterprise Edition，缩写为 EE）

### 安装环境要求

    系统内核需要 3.10 以上
    uname -r
    3.10.0-1062....
    
    查看系统版本
    cat /etc/os-release
    NAME="CentOS Linux"
    VERSION="7 (Core)"
    
### 安装 docker

sudo yum install docker-ce docker-ce-cli containerd.io

 
### 启动测试

    # 服务方式启动
    $ sudo systemctl start docker
    
    # 查看版本
    $ sudo docker version
    
    # 测试运行容器
    $ sudo docker run hello-world
    
    # 查看下载的镜像
    $ sudo docker images

### 卸载docker

    # 停止服务
    $ sudo systemctl start docker
    
    # 卸载相关依赖
    $ sudo yum remove docker-ce docker-ce-cli containerd.io
    
    # 清空工作路径
    $ sudo rm -rf /var/lib/docker