
### 字段注释

可以直接生成字段注释

### 补充

只能生成mysql数据库表

不能生成Oracle数据库表

### sql语句

```sql

CREATE TABLE basic_info (
	patient_id VARCHAR ( 255 ) COMMENT '患者编号' NOT NULL,  -- 主键
	age int ( 11 ) DEFAULT 0 COMMENT '年龄', -- int类型
	alcoholism_history VARCHAR ( 255 ) DEFAULT NULL COMMENT '酗酒史', -- string类型
	height DOUBLE DEFAULT NULL COMMENT '身高(cm)', -- double类型
	in_hosp_date DATE DEFAULT NULL COMMENT '住院日期', -- Date类型
primary key ( patient_id ) 
);
```
