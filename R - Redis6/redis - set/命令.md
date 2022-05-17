sadd k1 v1 v2 v3

    将多个元素放到即可k1中

smembers k1

    列出k1集合的所有元素

sismember k1 value

    集合k1中是否有value这个值 有1无0
   
scard k1

    返回集合中的个数

srem k1 v1 v2

    删除k1集合中的v1 v2

spop k1

    随机取出一个值（也就是删除）

srandmember key n

    随机从该集合中取出n个值。不会从集合中删除。

smove 源 目标 value

    smove k1 k2 v1 

    把k1中的v1移动到k2集合

sinter k1 k2

    返回两个集合的交集元素

sunion k1 k2

    返回两个集合的并集元素

sdiff k1 k2

    返回两个集合的差集元素(key1中的，不包含key2中的)



