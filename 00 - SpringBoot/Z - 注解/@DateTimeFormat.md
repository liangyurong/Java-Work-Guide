
### 规定某个Date字段的格式

```jshelllanguage
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "检查时间")
    private Date checkDate;
```
