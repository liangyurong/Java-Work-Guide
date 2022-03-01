## RIGHT JOIN

RIGHT JOIN 关键字会右表 (table_name2) 那里返回所有的行，即使在左表 (table_name1) 中没有匹配的行。

### RIGHT JOIN 关键字语法

```text
SELECT column_name(s)
FROM table_name1
RIGHT JOIN table_name2 
ON table_name1.column_name=table_name2.column_name
```

### 怎么用

people表
```txt
id email name
1 1 1
2 2 2
3 3 3
```

student表
```txt
id address name
1  1  1
2  2  2
4  4  4
```

sql语句
```sql
select * from people p 
right join student s 
on p.name = s.name;
```

结果：
```text
id email name id(1) address name(1)
1    1     1    1      1      1
2    2     2    2      2      2
                4      4      4
```
