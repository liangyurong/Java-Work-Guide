### 举例子

### 表

stu1

    id name
    1    1
    2    2
    3    3

stu2

    id name
    1    1
    2    22
    3    3

### union 去除重复的联合查询

查询

```sql
select id,name from stu1
union
select id,name from stu2
```

结果

    id name
    1    1
    2    2
    3    3
    2    22

### union all 两个子查询结果合并

合并的结果不会去重，只要求查询的两个列数一致

查询

    SELECT id,name FROM stu1
    union all
    select id,name from stu2;

结果

    id name
    1    1
    2    2
    3    3
    1    1
    2    22
    3    3