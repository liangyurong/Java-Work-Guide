## 返回所有的数据

实体类：Student

使用List接收所有的Student

### 源码

```jshelllanguage
    @GetMapping("list")
    public Result list(){

        Result result = new Result();

        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        wrapper.like("name","2");
        List list = studentService.list(wrapper);

        int code = (null == list || 0 == list.size()) ? 1:0;
        String msg = code==0 ?"找到数据":"找不打数据";

        result.putCode(code);
        result.putMsg(msg);
        result.putData(list);
        return result;

    }
```















