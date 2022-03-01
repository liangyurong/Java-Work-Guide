


### 1、查看数据库启动状态
```sql
select status from v$instance;
```
### 2、查询某张表的所有信息
```sql
select * FROM table_name
```

### 查看某张表的位置
```sql

```

### 3、查看当前用户能访问的表
```sql
select * from user_tables;
```
### 4、查询user_tab_cols属于哪个用户，比如这张表是user_tab_cols
```sql
select * from all_all_tables t where t.table_name ='user_tab_cols';
```
### 5、显示所有的表空间
```sql
select tablespace_name from user_tablespaces;

SELECT tablespace_name,file_name  FROM dba_data_files;
```

### 6、查询当前用户的所有表
```sql
select * from all_tables where owner='xxx'; --xxx是用户名
```

### 7、显示数据库文件的路径 show  the path of database file
```sql
select name from v$datafile;
```

### 8、 删除用户，名字是 "C##RESEARCH"
```sql
drop user C##RESEARCH cascade;
```

### 查找用户
```sql
select user_id,username,default_tablespace from dba_users order by user_id asc;
```

### 查找表空间的路径
```sql
select file_name,tablespace_name from dba_data_files;
```

### 查询：哪个用户拥有sysdba权限
```sql
select * from V$PWFILE_USERS;
```

### 检查数据库版本
```sql
SELECT banner FROM v$version WHERE ROWNUM = 1;
```

### 查询用户
```sql
select table_name from user_tables;
```

### 查询oracle当前容器
```sql
select sys_context('userenv','con_name') from dual;
```

### 查询某个用户是否存在
```sql
select * from dba_users where USERNAME= 'C##RESEARCH'  ;
```

### 切换到 PDB/CDB 环境
```sql
alter session set container=ORCLPDB;

alter session set container=CDB$ROOT;
```

### 导入.dmp file (打开cmd，输入下面代码)

```sql
imp RESEARCH/123456@orcl file=C:\Users\lyr\Desktop\DBFILE\med_res.dmp  full=y
```

### 清空表的数据

delete from tableName

### 使用sys删除某个角色的权限
