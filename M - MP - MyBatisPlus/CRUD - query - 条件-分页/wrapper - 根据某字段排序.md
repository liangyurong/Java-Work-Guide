
### 根据某个字段排序：asc desc

```jshelllanguage
    @GetMapping("page")
    public Result page(@RequestParam("current")int current,@RequestParam("size")int size){

        Result result = new Result();

        Page<Student> page = new Page<>(current,size);

        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        wrapper.like("my_email","11"); // name直接对应数据库的字段，而不是实体类的字段

        // 根据某字段排序
        //wrapper.select().orderByAsc("id");
         wrapper.select().orderByDesc("id");

        Page<Student> pageStu = studentService.page(page, wrapper);

        int code = (null == pageStu || 0 == pageStu.getTotal())?1:0;
        String msg = code==0 ?"找到数据":"找不到数据";

        result.putCode(code);
        result.putMsg(msg);
        result.putData(pageStu);
        return result;
    }
```
