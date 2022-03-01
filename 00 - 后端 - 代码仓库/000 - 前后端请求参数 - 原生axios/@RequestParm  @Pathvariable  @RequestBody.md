

### 一、@RequestParm

- 用于PostMapping。

- 参数在请求body上面。username要对应前端传递过来的名称username，不能不一样。

- 在浏览器的路径是能够看到参数的。

- 在后端的controller路径是看不到参数的。

- 请求的URL：localhost:8080/login?name=yurong&password=123456  （name和password是在请求体上。用postman就能更加直观看出来）

- 如果没有传递参数，controller将会报错，有如下两种解决方法。
  - 使用 required = false 标注参数是非必须的。
  - 使用 defaultValue 给参数指定个默认值。


```java
@PostMapping("/login")
public String login(@RequestParam String name,@RequestParam String password) {
    return "";
}
```

### 二、@PathVariable

- 参数在URL路由上面。

- 用于GetMapping。

- 请求的URL：localhost:8080/blogs/id  （id就是传递的参数，在url的路径上）

```java
//接口路由的参数如果和方法参数命名不一致，需要@pathVariable来指定，如下。最好命名一致。
@GetMapping("/blogs/{id})
public String editInput(@PathVariable("id") Long studentId) {
  return "";  
}
```

#### @PathVariable和@RequestParm的区别

- 区别在于在请求时，参数是在URL路由上还是在请求的body上。
- @PathVariable的参数在请求路由上
- @RequestParm的参数在请求body上

### 三、@RequestBody

- 主要用来前端传给后端的json字符串中的数据（请求体中的数据）

- GET方式没有请求体，因此使用@RequestBody接收数据一定是使用POST来提交的。

- URL：localhost:8080/save

```java
@PostMapping("/save")
public void save(@RequestBody User user) {
    service.save(user);
}
```

### 四、路径参数和查询参数结合

URL：localhost:8080/12?pos=3

```java
@GetMapping("/{id}")
public Map test(@Pathvariable Integer id , @RequestParm Integer pos){
    return "";
}
```