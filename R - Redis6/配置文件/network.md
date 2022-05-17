

    # By default, if no "bind" configuration directive is specified, Redis listens
    # for connections from all the network interfaces available on the server.
    # It is possible to listen to just one or multiple selected interfaces using
    # the "bind" configuration directive, followed by one or more IP addresses.

    默认情况下，如果没有指定“绑定”配置指令，Redis 会监听用于来自服务器上所有可用网络接口的连接。

    可以使用仅收听一个或多个选定的接口“绑定”配置指令，后跟一个或多个 IP 地址。

    # Examples:
    #
    # bind 192.168.1.100 10.0.0.1
    # bind 192.168.64.128 ::1

其他机器可远程连接redis

    # bind 127.0.0.1 (注释掉之后，就能够让其他机器远程连接redis)

protected-mode no

    关闭保护模式，支持远程访问

port 6379

    端口号默认6379，不需要修改

tcp-backlog 511

    在每秒请求数较高的环境中，您需要大量积压工作以避免缓慢的客户端连接问题。

    请注意，Linux 内核 会默默地将其截断为 /proc/sys/net/core/somaxconn 的值，所以确保同时提高 somaxconn 和 tcp_max_syn_backlog 的值 以获得想要的效果

timeout 0

    客户端空闲 N 秒后关闭连接（0 表示禁用，表示永不超时）

tcp-keepalive 300

    每隔300s检测心跳，检测连接是否还活着

    活着：继续服务

    不活着：释放连接

pidfile /var/run/redis_6379.pid

    redis的每次操作都是进程号，帮我们把进程号写到上面的文件中

loglevel notice

    日志级别，默认是notice

    # debug (a lot of information, useful for development/testing)
    # verbose (many rarely useful info, but not a mess like the debug level)
    # notice (moderately verbose, what you want in production probably)
    # warning (only very important / critical messages are logged)
    

    