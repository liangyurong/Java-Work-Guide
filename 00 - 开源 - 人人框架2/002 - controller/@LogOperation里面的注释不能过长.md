## @LogOperation("") 里面的注释不能过长

```jshelllanguage
 @PostMapping("checkIsExist")
    @ApiOperation("查询某个时间段是否已经存在测量结果") 
    @LogOperation("查询某个时间段是否已经存在测量结果")
    public Result checkIsExist(@RequestBody BloodPressureDTO dto) {
      // ....
    }
```

### @LogOperation("") 里面的注释不能过长

否则报错：Data truncation: Data too long for column ‘xxx‘ at row 1














