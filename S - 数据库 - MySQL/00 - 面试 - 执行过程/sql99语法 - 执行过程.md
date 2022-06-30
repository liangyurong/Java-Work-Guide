## sql99语法

```sql
select xxx(存在聚合函数)
from 表
join 表1 on 多表连接条件
join 表2 on 多表连接条件
where 不包含聚合函数的过滤条件
group by 字段
having 包含聚合函数的过滤条件
order by 字段(升序/降序)
limit xxx分页条件
```

### 执行过程

from 表 // 找到表

join xxx on xxx // 

where xxx

group by xxx

having xxx

select xxx // 显示信息

order by // 排序

limit // 分页





