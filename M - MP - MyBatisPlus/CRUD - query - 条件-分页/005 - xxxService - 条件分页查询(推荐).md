
### 推荐原因

直接service调用方法，不直接编写mapper里面的方法

### 源码

```jshelllanguage
/**
     * 分页和条件查询
     * 示例：http://localhost:8888/student/page1?currentPage=1&size=3
     * @param current 当前页，从1开始
     * @param size 每页展示的数量
     * @return result
     */
    @GetMapping("page1")
    public Result page1(@RequestParam("current")int current,@RequestParam("size")int size){

        Result result = new Result();

        Page<Student> page = new Page<>(current,size);

        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        // name直接对应数据库的字段，而不是实体类的字段
        wrapper.like("my_email","11");

        // 根据某字段排序
        // wrapper.select().orderByAsc("id");
        // wrapper.select().orderByDesc("id");

        Page<Student> pageStu = studentService.page(page, wrapper);

        if(null == pageStu || 0 == pageStu.getTotal()){
            result.putCode(1);
            result.putMsg("找不打数据");
            result.putData(null);
        }else {
            result.putCode(0);
            result.putMsg("找到数据");
            result.putData(pageStu);
        }

        return result;
    }
```
