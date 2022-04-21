### Optional.ofNullable()



### 推荐

```java
public class Test{
    
}
```



### 不能将pDao.findById(id).get()作为参数放到Optional.ofNullable()里面

```java
public class Test{
        
    @GetMapping("/testb")
    @ResponseBody
    public Optional<People> testb(@RequestParam("id")String id){
        // 这种表达，如果根据id找不到实体类，还是会报错：java.util.NoSuchElementException: No value present。（并没有创建一个空的Optional）
        // 原因：抛异常是因为pDao.findById(id).get()找不到，和Optional.ofNullable()无关
        return Optional.ofNullable(pDao.findById(id).get());
    }
}
```



















