展示所有数据库

```sql
select * from sys.databases
```

查询一张表的字段有多少个

```sql
select count(*) from syscolumns where id = object_id('表名')
```

查询一张表中的记录数量

```sql
 select count(*)  from 表名
```

