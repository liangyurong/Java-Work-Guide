## count

忽略空值的count操作

    select count(age) from student;

不忽略空值的count操作

    SELECT count(
	 IF( age IS NOT NULL, age, 0 )) 
    FROM student;

    