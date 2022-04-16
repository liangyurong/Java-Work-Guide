


## 

## @PathVariable

```jshelllanguage
    @GetMapping("/getCode/{code}")
    public String getSignFromCode(@PathVariable("code") String code){
        return code;
    }
```

浏览器请求路径：localhost:8078/getCode/001

## 设置参数可以为空

```jshelllanguage
    @GetMapping("/getCode/{code}")
    public String getSignFromCode(@PathVariable(value = "code",required = false) String code){
        return code;
    }
```









