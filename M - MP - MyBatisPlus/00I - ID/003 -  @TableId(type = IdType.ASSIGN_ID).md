##  @TableId(type = IdType.ASSIGN_ID)

```jshelllanguage
    @TableId
    private String id; // 默认使用雪花算法生成uuid
```

等同于

```jshelllanguage
    @TableId(type = IdType.ASSIGN_ID)
    private String id;
```
























