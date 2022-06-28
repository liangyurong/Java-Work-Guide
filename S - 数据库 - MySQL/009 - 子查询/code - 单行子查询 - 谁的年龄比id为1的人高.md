### 谁的年龄比id为1的人高


### 子查询实现

查询结果作为查询条件

    SELECT * FROM  student  WHERE  age > ( SELECT age FROM student WHERE id = 1 );

### 自连接实现

单表作为多表

    SELECT s2.* FROM student s1 , student s2 where s2.age > s1.age and s1.id = 1; 