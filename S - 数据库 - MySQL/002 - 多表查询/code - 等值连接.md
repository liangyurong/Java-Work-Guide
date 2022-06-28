## 简单多表查询

### 表

emp表

    id    name    dept_id
    1	1	1
    2	2	2
    3	3	3
    4	4	1
    5	5	2
    6	6	3

dept表

    dept_id     name    addr_id
        1       dept1       1
        2       dept2       2
        3       dept3       3
        4       dept4       4

addr表

    addr_id         name
        1	        beijing
        2	        shanghai
        3	        sz
        4	        guangzhou

### 表关系说明

emp的dept_id对应dept的dept_id，dept的addr_id对应addr的addr_id

### 每个员工的部门和工作地点

```sql
SELECT
	e.NAME,
	d.NAME,
	a.NAME 
FROM
	emp e,
	dept d,
	addr a 
WHERE
	e.dept_id = d.dept_id 
	AND d.addr_id = a.addr_id;
```

说明：由于emp中id=1的员工不属于任何部门，因此没有展现。

结果

    name    name1       name2
    2       dept2       shanghai
    3       dept3       sz
    4       dept4       beijing
    5       dept5       shanghai
    6       dept6       sz

### 每个员工的部门和办公地点（左外连接，即使没有部门的员工也要展示出来）

```sql
SELECT
	e.NAME,
	d.NAME,
	a.NAME 
FROM
	emp e
	LEFT JOIN dept d ON e.dept_id = d.dept_id
	LEFT JOIN addr a ON d.addr_id = a.addr_id;
```

    name    name1       name2
    1       null        null
    2       dept2       shanghai
    3       dept3       sz
    4       dept4       beijing
    5       dept5       shanghai
    6       dept6       sz