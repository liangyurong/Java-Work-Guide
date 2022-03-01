
### 说明

在navicat中通过图形界面创建表

### MySQL 使用下列数据类型在数据库中存储日期或日期/时间值：

DATE - 格式 YYYY-MM-DD

DATETIME - 格式: YYYY-MM-DD HH:MM:SS  -- 对应java的LocalDateTime

TIMESTAMP - 格式: YYYY-MM-DD HH:MM:SS

YEAR - 格式 YYYY 或 YY

### SQL Server 使用下列数据类型在数据库中存储日期或日期/时间值：

DATE - 格式 YYYY-MM-DD

DATETIME - 格式: YYYY-MM-DD HH:MM:SS

SMALLDATETIME - 格式: YYYY-MM-DD HH:MM:SS

TIMESTAMP - 格式: 唯一的数字

### sqlserver与java字段的对应

timedate类型，build_date

```text
    private Date buildDate;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    public Date getBuildDate() {
        return buildDate;
    }
```
