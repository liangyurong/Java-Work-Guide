

将名字相同的age都合并计算起来

```sql
select name,sum(age) from customer group by name;
```
