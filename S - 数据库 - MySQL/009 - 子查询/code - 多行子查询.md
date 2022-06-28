## 多行子查询

 返回所有比 任意一个《id>1的学生》年龄大的学生信息

     SELECT * FROM  student  WHERE  age > any ( SELECT age FROM student WHERE id > 1 );

返回所有比 全部《id>1的学生》年龄大的学生信息

    SELECT * FROM  student  WHERE  age > all ( SELECT age FROM student WHERE id > 1 );
