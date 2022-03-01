
### 拷贝

2021-12-22，是深拷贝

使用：int num = System.identityHashCode(Object);

### 源码

```jshelllanguage
    // Spring 的BeanUtils.copyProperties
    @GetMapping("testCopy4")
    public String testCopy4() {
        Student source = new Student("id1", "name1", "email1");
        StudentDto target = new StudentDto();

        // 目标在右 源在左
        // 可以引用依赖，不用写那么长的东西
        org.springframework.beans.BeanUtils.copyProperties(source,target);
        return target.getName()+" "+target.getMyEmail();
    }
```
