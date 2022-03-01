1. 显示所有的表空间

```sql
select * from dba_tablespaces;

select name from v$tablespace;

select tablespace_name from user_tablespaces; //use this sql
```

2. show the users of the XXX table space

```sql

```

3. check if there is a database named XXX

```sql

```

4. 显示数据库文件路径

```sql
select name from v$datafile;
```

5. 删除名为"C##RESEARCH"的用户

```sql
drop user C##RESEARCH cascade;
```

6. in cmd . enter "sqlplus" , after login , enter following code to search

```sql
select * from global_name //GLOBAL_NAME in listener.ora file .

select instance_name from V$instance; // SID_NAME in listener.ora file 
```

**Query users**

```sql
select user_id,username,default_tablespace from dba_users order by user_id asc;
```

**表空间路径**

```sql
select file_name,tablespace_name from dba_data_files; 
```

### 查询所有表空间

select * from v$tablespace;

### which users have susdba or sysoper system permissions**

select * from V$PWFILE_USERS;

### 查找数据库版本

```sql
SELECT banner FROM v$version WHERE ROWNUM = 1;
```

**Query user**

```sql
select table_name from user_tables; 
```

**Query table space** 

```sql
SELECT tablespace_name,file_name  FROM dba_data_files;
```

**Query Oracle current container**

```sql
select sys_context('userenv','con_name') from dual;
```

**Query whether a user exists**

```sql
select * from dba_users where USERNAME= 'C##RESEARCH'  ; 
```

**Query whether there are users in a tablespace**

```sql

```

