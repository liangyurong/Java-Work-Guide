### 补充

生成表的时候，字段也会有注释

### 操作

在PLSql工具C##YB_MED_OPENEHR账户，再生成table

### sql语句生成oralce数据库表

```sql
CREATE TABLE BASIC_INFO (
  PATIENT_ID VARCHAR ( 255 ) NOT NULL , -- 对应Java的String类型,主键not null
  NAME VARCHAR ( 255 ) DEFAULT NULL ,   -- 对应Java的String类型
  AGE NUMBER DEFAULT 0 ,                -- 对应Java的int类型
  HEIGHT FLOAT DEFAULT NULL,            -- 对应Java的float类型
  IN_HOSP_DATE DATE DEFAULT NULL        -- 对应Java的Date类型
);

COMMENT ON TABLE  BASIC_INFO is '基础信息表';
COMMENT ON COLUMN BASIC_INFO.PATIENT_ID IS '患者编号';
COMMENT ON COLUMN BASIC_INFO.NAME IS '姓名';
COMMENT ON COLUMN BASIC_INFO.AGE IS '年龄';
COMMENT ON COLUMN BASIC_INFO.HEIGHT IS '身高(cm)';
COMMENT ON COLUMN BASIC_INFO.IN_HOSP_DATE IS '住院日期';

alter table C##YB_MED_OPENEHR.BASIC_INFO add primary key (PATIENT_ID); -- 添加主键

-- 这样子添加主键不行的 alter table BASIC_INFO add constraint BASIC_INFO primary key (PATIENT_ID);

```
