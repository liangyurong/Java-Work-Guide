### basic

给用户授权时，要注意自己是不能为自己授权的，要么利用第三方具有该对象授权权限的用户进行授权，或者利用具有DBA权限的用户授权。

### User authorization

```sql
grant connect to RESEARCH;
grant resource to RESEARCH;
-- Grant/Revoke system privileges 授予/撤消系统权限
grant create view to RESEARCH;
grant unlimited tablespace to RESEARCH;
```

### sql analysis - User authorization

```sql
-- 此时的C##RESEARCH是用户

grant connect to RESEARCH; --授予connect角色
grant resource to RESEARCH; --授予resource角色
grant create view to RESEARCH; --为用户创建视图的权限
grant unlimited tablespace to RESEARCH; --不对C##RESEARCH用户作配额限制
```

