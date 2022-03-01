
### 在嵌套查询中，select后面不一定要跟表名

在嵌套查询中，子查询的结果是作为一个派生表给上一级进行查询，所以子查询的结果必须有一个别名


### customer表

```text
id name
1 111
2 233
3 311
4 411
```

### 查询语句

在子查询的后面增加一句 AS total，相当于给子查询的结果集派生表取别名为total
```sql
SELECT
	*
FROM
	( SELECT cc.* FROM customer cc WHERE cc.NAME LIKE '%3%' ) AS total
WHERE
	id = '3';
```

sql分析
```text
1、SELECT cc.* FROM customer cc WHERE cc.NAME LIKE '%3%'：查询到name有含有1的所有记录
2、整体的sql：再从查询到的记录中找到name中含有3的记录
```

结果
```text
3 311
```





