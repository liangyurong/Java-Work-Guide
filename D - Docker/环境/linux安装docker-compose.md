
### 哪些需要安装

docker for windows不需要安装

docker的linux版本需要安装

### linux安装docker-compose步骤

1、来到linux的根目录

2、执行命令，安装

    sudo curl -L "https://github.com/docker/compose/releases/download/1.29.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
    
    sudo chmod +x /usr/local/bin/docker-compose

3、执行命令。查看是否已经安装

    docker-compose

4、出现下面命令说明已安装

    Commands:
      build              Build or rebuild services
      config             Validate and view the Compose file
      create             Create services
      down               Stop and remove resources
      events             Receive real time events from containers
      exec               Execute a command in a running container
      help               Get help on a command
      images             List images
      kill               Kill containers
      logs               View output from containers
      pause              Pause services
      port               Print the public port for a port binding
      ps                 List containers
      pull               Pull service images
      push               Push service images
      restart            Restart services
      rm                 Remove stopped containers
      run                Run a one-off command
      scale              Set number of containers for a service
      start              Start services
      stop               Stop services
      top                Display the running processes
      unpause            Unpause services
      up                 Create and start containers
      version            Show version information and quit


















