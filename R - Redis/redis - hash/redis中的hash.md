redis中的hash是一个键值对集合

Redis hash是个string类型的field和value的映射表，hash特别适合用于存储对象。类似Java里面的Map<String,Object>

### 使用该种方法存储对象的优点

存取方便

### 其他不好的做法

1、user 对应的value是 {id=1,name=lyr,age=26}

    取出，修改很麻烦

2、userid:1 username:lyr userage:26

    如果很多对象，则存储非常混乱

### 存储形式

用户ID为查找的key,存储的value用户对象包含id、姓名，年龄

    key是user

    value是三个键值对   id:1    name:lyr   age:26






































