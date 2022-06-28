## limit

从第4条记录开始，显示2条记录

    select * from buy limit 3,2

找到年龄最大的记录(从第一条记录开始，显示1条记录)

    select * from buy ORDER BY age DESC limit 0,1

