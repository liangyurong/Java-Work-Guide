

### JPA的id

```jshelllanguage
@Id
@GeneratedValue(generator = "system-uuid")
@GenericGenerator(name = "system-uuid", strategy = "uuid")
@Column(length = 55)
private String id; // 生成uuid
```

### MP的id

```jshelllanguage
@TableId
private String id; //MP采用雪花算法自动生成id
```

### JPA字段 

```jshelllanguage
@Column("name")
private String name;

@Column("payRemark") // 对应数据库中的字段payRemark。如果数据库字段不是下划线命名pay_remark，则可以在此备注对应。
private String payRemark;

```
### MP字段

```jshelllanguage
@TableField("name")
private String name;
@TableField("payRemark") // 对应数据库中的字段payRemark。如果数据库字段不是下划线命名pay_remark，则可以在此备注对应。
private String payRemark;
```
