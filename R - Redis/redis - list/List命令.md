### 存储

lpush

    lpush k1 v1 v2 v3
    
    存放结果：v3 v2 v1

rpush
    
    rpush k1 v1 v2 v3

### 取出全部值

lrange 按照索引下标获取元素，从左到右

取出k1所有的值

    lrange k1 0 -1

    取出结果：v3 v2 v1

取出k2所有的值

    lrange k2 0 -1

    取出结果：v1 v2 v3

### 取出一定范围的值

    lrange k1 起始下标 终点下标

    从左到右获取元素

### pop取值

    lpop k1 
    弹出左边一个值

### rpoplpush k1 k2

    从k1列表右边吐出一个值，插到k2列表的左边

### lindex

    lindex key 下标
    
    从左到右，按照索引获取元素

### llen key

    获取列表长度 

### linsert key before value newValue

    在已存在的value前面添加newValue

### lrem key n value

    从value左边删除n个值（不删除value）

### lset key index value

    从左往右数，将下标为index的值替换为value
    
    比如: lset k1 1 v1 将下标为1的值替换为v1







