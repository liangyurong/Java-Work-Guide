### mset、mget、msetnx

mset

    mset k1 v1 k2 v2 k3 v3...

    同时设置一个或多个键值对

mget

    mget k1 k2 k3

    同时获取一个或多个value

msetnx

    msetnx k1 v1 k2 v2 k3 v3...

    同时设置一个或多个键值对，当且仅当所有给定的key都不存在
    
    原子性：有一个失败则所有的都失败


