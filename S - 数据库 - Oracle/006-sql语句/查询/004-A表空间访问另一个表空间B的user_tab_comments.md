## A表空间访问另一个表空间B的user_tab_comments

首先需要授予权限


### 错误做法：授予权限

以sys身份登录，执行下列语句，报错：表或视图不存在
```sql
grant select on C##MED_OPENEHR.user_tab_comments to C##YB_MED_RES;
```


### 备注：目前并没有办法去实现（2021-08-30）
