
### 一、@Parm

一般用在dao层，用来给参数命名，在Mybatis的mapper中加上该注解，传递的参数与Sql中的字段名一致。

```text
List<Employee> getAllEmployeeByPage(@Param("page") Integer page, @Param("size") Integer size);
```

## 一、@RequestParam

前端传递这种类型的参数比较方便。

一般用在Controller层，用来解决前端与后端参数不一致的问题，在参数上加上@RequestParam，那么前端的参数必须和后端参数一致，否则会报错。

```java
@PostMapping(value="/showUser/")
 public Map<String,Object> testRequestParam(@RequestParam("name") String name, @RequestParam("pwd") String pwd){
    Map<String,Object> map = new HashMap<>();
    map.put("name",name);
    map.put("pwd",pwd);
    return map;
 }
```

浏览器的请求路径: localhost:8080/showUser?name=myname&pwd=123
