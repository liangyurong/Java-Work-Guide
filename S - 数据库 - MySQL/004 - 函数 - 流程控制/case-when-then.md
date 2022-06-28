## case-when-then

```sql
SELECT
    id,
    CASE
        WHEN id > 6 THEN
            '大于6'
        WHEN id > 5 THEN
            '大于5'
        WHEN id > 4 THEN
            '大于4'
        WHEN id > 3 THEN
            '大于3'
        WHEN id > 2 THEN
            '大于2'
        WHEN id > 1 THEN
            '大于1' ELSE '小于等于1'
        END 
        AS 'id等级评估'  -- 别名
FROM
    buy;
```

结果

    id       id等级评估
    1	    小于等于1
    2	    大于1
    3	    大于2
    4	    大于3
    5	    大于4
    6	    大于5

