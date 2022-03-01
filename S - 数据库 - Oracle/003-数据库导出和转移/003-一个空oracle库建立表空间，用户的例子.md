### 操作步骤

```txt
1. win+r , open cmd
2. enter :  sqlplus
3. enter user : system
4. enter password : 123456
```

### 说明

下面所有命令直接从cmd进入oracle进行操作，不要在PL/SQL操作。

### 本地环境说明

本地是从来没建立过相关表空间的。


### RESEARCH库：表空间，用户，用户权限

说明
```txt
文件地址要修改为Windows系统的路径

推荐选择oracle的路径：D:\oracleInstall\oradata\ORCL
```

创建表空间
```text
CREATE TABLESPACE "RESEARCH_DATA" DATAFILE
  'D:\oracleInstall\oradata\ORCL\RESEARCH_DATA.dbf' SIZE 52428800
  AUTOEXTEND ON NEXT 52428800 MAXSIZE 20480M
  LOGGING
  ONLINE
  PERMANENT
  BLOCKSIZE 8192
  EXTENT MANAGEMENT LOCAL AUTOALLOCATE DEFAULT
  NOCOMPRESS
  SEGMENT SPACE MANAGEMENT AUTO;
```

创建临时表
```text
 CREATE TEMPORARY TABLESPACE "RESEARCH_TEMP" TEMPFILE
  'D:\oracleInstall\oradata\ORCL\RESEARCH_TEMP.dbf' SIZE 52428800
  AUTOEXTEND ON NEXT 52428800 MAXSIZE 20480M
  EXTENT MANAGEMENT LOCAL UNIFORM SIZE 1048576;
```

创建用户
```txt
create user MED_RES
    identified by zteict2017
    default tablespace RESEARCH_DATA
    temporary tablespace RESEARCH_TEMP;
```

用户授权
```text
grant connect to MED_RES;
grant resource to MED_RES;
grant create view to MED_RES;
grant unlimited tablespace to MED_RES;
```

### MED_OPENEHR库：表空间，用户，用户权限

表空间
```text
CREATE TABLESPACE "OPENEHR_DATA" DATAFILE
    'D:\oracleInstall\oradata\ORCL\OPENEHR_DATA.dbf' SIZE 52428800
    AUTOEXTEND ON NEXT 52428800 MAXSIZE 20480M
    LOGGING 
    ONLINE 
    PERMANENT 
    BLOCKSIZE 8192
    EXTENT MANAGEMENT LOCAL AUTOALLOCATE DEFAULT
    NOCOMPRESS  
    SEGMENT SPACE MANAGEMENT AUTO;
```

更改大小
```text
   ALTER DATABASE DATAFILE
  'D:\oracleInstall\oradata\ORCL\OPENEHR_DATA.dbf' RESIZE 104857600;
```

临时表空间
```text
  CREATE TEMPORARY TABLESPACE "OPENEHR_TEMP" TEMPFILE
  'D:\oracleInstall\oradata\ORCL\OPENEHR_TEMP.dbf' SIZE 52428800
  AUTOEXTEND ON NEXT 52428800 MAXSIZE 20480M
  EXTENT MANAGEMENT LOCAL UNIFORM SIZE 1048576;
```

创建用户
```text
create user C##MED_OPENEHR
       identified by zteict2017
       default tablespace OPENEHR_DATA
       temporary tablespace OPENEHR_TEMP;
```

授予/撤销角色权限
```text
grant connect to C##MED_OPENEHR;
grant ctxapp to C##MED_OPENEHR;
grant resource to C##MED_OPENEHR;
```

授予/撤销系统权限
```text
grant create view to C##MED_OPENEHR;
grant unlimited tablespace to C##MED_OPENEHR;
```

### MED_BASE库：表空间，用户，用户权限

表空间
```text
CREATE TABLESPACE "BASE_DATA" DATAFILE
'D:\oracleInstall\oradata\ORCL\BASE_DATA.dbf' SIZE 209715200
AUTOEXTEND ON NEXT 10485760 MAXSIZE 32767M
LOGGING ONLINE PERMANENT BLOCKSIZE 8192
EXTENT MANAGEMENT LOCAL AUTOALLOCATE DEFAULT
NOCOMPRESS  SEGMENT SPACE MANAGEMENT AUTO;
```

更改大小
```text
ALTER DATABASE DATAFILE 'D:\oracleInstall\oradata\ORCL\BASE_DATA.dbf' RESIZE 34351349760;
```

临时表空间
```text
  CREATE TEMPORARY TABLESPACE "BASE_TEMP" TEMPFILE
  'D:\oracleInstall\oradata\ORCL\BASE_TEMP.dbf' SIZE 785383424
  AUTOEXTEND ON NEXT 655360 MAXSIZE 32767M
  EXTENT MANAGEMENT LOCAL UNIFORM SIZE 1048576;
```

创建用户
```text
create user MED_BASE
       identified by zteict2017
       default tablespace BASE_DATA
       temporary tablespace BASE_TEMP
       profile DEFAULT;
```

授予/撤销角色权限
```text
grant connect to MED_BASE;
grant ctxapp to MED_BASE;
grant dba to MED_BASE;
grant resource to MED_BASE;
```

授予/撤销系统权限
```text
grant create view to MED_BASE;
grant select any table to MED_BASEE;
grant unlimited tablespace to MED_BASE;
```

### 建完表和用户之后，就导入数据

如果用户权限不够，无法导入dmp文件
```sql
grant imp_full_database to username(写你的用户名)
```









