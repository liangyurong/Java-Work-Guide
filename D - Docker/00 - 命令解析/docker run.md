## docker run

docker run --name eureka-server -p 8761:8761 -d eureka-server:1.0  ## 运行镜像

    --name eureka-server：为容器指定一个名称为eureka-server

    -p 8761:8761 将容器的8761端口映射到主机的8761端口
    
    -d：后台运行容器

    eureka-server:1.0  使用该镜像

    