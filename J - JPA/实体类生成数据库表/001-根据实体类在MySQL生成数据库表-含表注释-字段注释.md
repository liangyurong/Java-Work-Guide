

### 补充

可以连接到mysql生成表

但是不能连接到oracle生成，会出错：ORA-00907: 缺失右括号

### 说明

自定义了字段的属性，默认值，注释。

最重要的是添加了字段的注释。

### java实体类

```java
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;

/** 基本信息 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BASIC_INFO")
@org.hibernate.annotations.Table(appliesTo = "basic_info", comment = "Table for cats") // 里面的basic_info必须对应@Table的BASIC_INFO
public class BasicInfo {

    /** 主键里面不能写default null */
    @Id
    @Column(name = "PATIENT_ID",columnDefinition = "varchar(255)  COMMENT '患者编号'") 
    private String patientId;

    @Column(name = "NAME",columnDefinition = "varchar(255) default NULL COMMENT '姓名'")
    private String name;

    @Column(name = "AGE",columnDefinition = "int(11) default 0 COMMENT '年龄'")
    private Integer age;

    @Column(name = "IN_HOSP_DATE",columnDefinition = "DATE DEFAULT NULL COMMENT '住院日期'")
    private Date inHospDate;

    @Column(name = "HEIGHT",columnDefinition = "DOUBLE default NULL COMMENT '身高(cm)'")
    private Double height;

}

```

### 根据实体类生成的数据库表的sql结构

```sql
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for basic_info
-- ----------------------------
DROP TABLE IF EXISTS `basic_info`;
CREATE TABLE `basic_info`  (
  `patient_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '患者编号',
  `age` int(0) NULL DEFAULT 0 COMMENT '年龄',
  `height` double NULL DEFAULT NULL COMMENT '身高(cm)',
  `in_hosp_date` date NULL DEFAULT NULL COMMENT '住院日期',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  PRIMARY KEY (`patient_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
```
