

- 如果返回的是字符串类的，需要加上@ResponseBody

```java

@ResponseBody
@GetMapping("/getJson")
public String getJson(){
    return "";
}
```