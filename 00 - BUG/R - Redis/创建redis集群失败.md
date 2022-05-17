bug

     Either the node already knows other nodes (check with CLUSTER NODES) or contains some key in database 0

原因

    主要原因是该节点中默认生成的配置或历史存储数据不一致导致的

解决

    清除对应节点的dump.rdb、nodes.conf文件

    关闭redis：./redis-cli -p 6379 shutdown

    重启redis：./redis-server redis.conf

