## code - having简单示例

having要放在group by的后面

sql解析：求出每个岗位的平均年龄，且只显示 age>3

    SELECT job,avg(age) FROM `emp` GROUP BY job having avg(age)>3;