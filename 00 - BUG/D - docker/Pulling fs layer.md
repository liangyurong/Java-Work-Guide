## Pulling fs layer

背景

    拉取docker镜像出错：Pulling fs layer

原因

    国外源下载太慢

解决

    Linux环境下，通过命令vim /etc/docker/daemon.json修改这个 Docker 服务的配置文件，也就是在该文件夹内配置docker的国内镜像源 ( 如果文件不存在，可以直接创建它 ) 

daemon.json里面的代码

    {
        "registry-mirrors":["https://docker.mirrors.ustc.edu.cn"]
    }

保存之后，重启docker

    systemctl restart docker
    