
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

    # 卸载旧版本
    $ sudo yum remove docker \
                      docker-client \
                      docker-client-latest \
                      docker-common \
                      docker-latest \
                      docker-latest-logrotate \
                      docker-logrotate \
                      docker-engine
    
    # 安装依赖包
    $ sudo yum install -y yum-utils
    
    # 设置镜像仓库（不推荐使用官方仓库，速度很慢）
    $ sudo yum-config-manager \
        --add-repo \
        https://download.docker.com/linux/centos/docker-ce.repo
        
    # 设置镜像仓库（推荐使用阿里云仓库）
    $ sudo yum-config-manager \
        --add-repo \
        http://mirrors.aliyun.com/docker-ce/linux/centos/docker-ce.repo
    
    # 更新yum软件包索引
    $ sudo yum makecache fast
    
    # 安装社区版docker
    $ sudo yum install docker-ce docker-ce-cli containerd.io
    启动测试    

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