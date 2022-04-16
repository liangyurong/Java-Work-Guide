### @PathVariable与@RequestParm

@PathVariable与@RequestParm注解都是用于从request中接收请求的，两个注解都可以接收参数。

**不同点**

1. @RequestParm是从request里面取值
2. @pathVariable是从一个URI模板里面去填充

```html
http://localhost:8080/springmvc/hello/101?param1=10&param2=20
```

**根据URL，@RequestParm可以这么去取值。（101后面是?而不是/）**

```java
public String getDetails(
    @RequestParam(value="param1", required=true,,defaultValue = "0") String param1,
    @RequestParam(value="param2", required=false) String param2){
...
}
```

**@RequestParm支持四种参数**

1. defaultValue 如果本次请求没有携带这个参数，或者参数为空，那么就会启用默认值
2. name 绑定本次参数的名称，要跟URL上面的一样
3. required 这个参数是不是必须的
4. value 跟name一样的作用，是name属性的一个别名

@pathVariable接收参数时，参数值需要在URL中占位，也就是有个/

```URL
http://localhost:8081/toEdit/5
```

```java
 @RequestMapping("/toEdit/{id}")
public String toEdit(@PathVariable(value = "id") Integer id) {
        。。。
    }
```



