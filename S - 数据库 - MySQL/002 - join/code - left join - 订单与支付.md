
### 业务场景

将buy看成订单表

将pay看成支付成功表（里面有订单表的id）

那么就可以buy.id == pay.buy_id，就可以知道哪些订单是没有支付成功的

### SQL LEFT JOIN 关键字

LEFT JOIN 关键字会从左表 (table_name1) 那里返回所有的行，即使在右表 (table_name2) 中没有匹配的行。

我自己的理解：左表的会全部展示，右表的只有符合table_name1.column_name=table_name2.column_name，才会展示出来，否则为空

### 表

buy表 - 订单表

```txt
id name
1 1
2 2
3 3
4 4
5 5
```

pay表 - 已支付表

```txt
id buy_id
1  1
3  3
```

###  查看已支付订单

sql

    方法1：select b.* from buy b where b.id in (select p.id from pay p)

    方法2：select b.*  from buy b inner join pay p on b.id = p.id;  // inner join不会产生null

    方法3：select b.*  from buy b left join pay p on  b.id = p.id  where p.id is not null;

    方法4：SELECT b.* FROM buy b NATURAL JOIN pay p; // 自动查询两张连接表中所有相同的字段，然后进行等值连接（不推荐，不够灵活）

    哪个方法更好呢？

结果

    id name
    1    1
    3    3

### 获取未支付订单

sql

    方法1：select b.* from buy b where b.id not in (select p.id from pay p)

    方法2：select b.* from buy b left join pay p on b.id = p.buy_id where p.buy_id is  null;  （比较绕）

结果

    id name
    2    2
    4    4
    5    5

### 查看订单与支付的所有情况
















