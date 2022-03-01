### Create User 

```sql
create user RESEARCH
    identified 123456
    default tablespace RESEARCH_DATA
    temporary tablespace RESEARCH_TEMP
```
### sql analysis - Create User 

```sql
create user RESEARCH
    default tablespace RESEARCH_DATA  --默认表空间
    temporary tablespace RESEARCH_TEMP --临时表空间
    password expire; --设置当前用户的密码为过期状态，使用户不能登录，要登录必须得重新修改密码。
```

