### tcp-backlog

设置tcp的backlog，back log其实是个连接队列

backlog队列总和 = 未完成三次握手队列 + 已经完成三次握手队列

在高并发环境下你需要一个高backlog值来避免慢客户端连接问题

注意Linux内核会将这个值减小到proc/sys/net/core/somaxconn的值(l28),所以需要确认增大proc/sys/net/core/somaxconn和proc/sys/net/ipv4/tcp_max_syn_backlog(128)两个值来达到想要的效果