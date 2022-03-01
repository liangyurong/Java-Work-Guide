

### decode函数

这是oracle数据库独有的

功能：

DECODE的语法：decode(条件,值1,返回值1,值2,返回值2,...值n,返回值n,缺省值)

该函数的含义如下：
```text
IF 条件=值1 THEN
　　　　RETURN(翻译值1)
ELSIF 条件=值2 THEN
　　　　RETURN(翻译值2)
　　　　......
ELSIF 条件=值n THEN
　　　　RETURN(翻译值n)
ELSE
　　　　RETURN(缺省值)
END IF
```

### 举例子

select decode(count(*),-1,0,90) as value from table(某个表名);

分析
```txt
if ount(*)=-1 得到 0
else 得到90
```

结果
```txt
value
90
90
```


























