
### student表

id name 
1  1
2  2
3  2
4  3
5  3
6  3

### 找出重复的记录

找出重复的name值

SELECT *,count(*) as count FROM `student` group by name having count>1

结果
```text
id name count
2   2    2
4   4    3
```
### 去除重复的记录

select * , count(*) as num from student group by name having num >= 1;
