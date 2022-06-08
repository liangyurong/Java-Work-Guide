

### EXISTS

EXISTS 运算符用于判断查询子句是否有记录，如果有一条或多条记录存在返回 True，否则返回 False。

### 示例

SELECT * FROM `customer` where  EXISTS (select * from customer where id = "1")
```text
1 11
2 22
```

SELECT * FROM `customer` where  EXISTS (select * from customer where id = "3")
```text
不会返回任何结果
```

分析：

EXISTS (select * from customer where id = "1") 返回true，因此执行select * from customer，返回了两条记录

EXISTS (select * from customer where id = "3") 返回false，因此不执行select * from customer

### customer表中的记录

id  name
1    11
2    22






