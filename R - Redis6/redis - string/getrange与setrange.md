### getrange

getrange key 起始位置 结束位置

例子

    比如有个键值对 name: yurong333

    则 getrange name 0 3 得到 yuro

### setrange

setrange key 起始位置 value

从起始位置覆盖value长的字符串，比如一个键值对是 name:abcde

setrange name 1 yyy ， 则得到 ayyye
