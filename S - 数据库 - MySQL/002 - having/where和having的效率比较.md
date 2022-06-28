## where和having的效率比较

### 数据表

    id name dept_id dept_name job age
    1   1	1   研发部     前端	4
    2   2	2   后勤部     行政	5
    3   3	1   研发部     前端	2
    4   4	2   后勤部     运营	5
    5   5	1   研发部     后端	7
    6   6	2   后勤部     行政	6

### 需求

查询部门id为1,2,3,4,5,6这几个部门中，平均年龄>3的job岗位有哪些

### where

```sql
SELECT
    dept_id,
    job,
    avg( age )
FROM
    `emp`
WHERE
    dept_id IN ( 1, 2, 3, 4, 5, 6 )
GROUP BY
    job
HAVING
    avg( age )> 3;
```

### having

```sql
SELECT
    dept_id,
    job,
    avg( age )
FROM
	`emp` 
GROUP BY
	job 
HAVING
	avg( age )> 3 
	AND dept_id IN ( 1, 2, 3, 4, 5, 6 );
```

### 两个语句的执行结果都是
    dept_id job     avg(age)
    2       行政      5.5000
    2       运营      5.0000
    1       后端      7.0000

### 结论

where比having执行效率高

### 效率高的原因

因为where可以先筛选，用一个筛选后的较小数据集和关联表进行连接，这样占用的资源比较少，执行效率较高。

    缺点：不能使用分组中的计算函数进行筛选

having则需要先把结果集准备好，也就是用没有被筛选的数据集进行关联，然后对这个大的数据集进行筛选，这样占用的资源比较多，效率比较低。

    优点：能使用分组中的计算函数进行筛选


