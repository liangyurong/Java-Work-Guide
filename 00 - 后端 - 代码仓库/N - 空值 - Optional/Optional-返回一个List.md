

### 可以这么做



### 不要这么做

```java
public interface UserService{
  Optional<List<User>> listUser();
}
```

这样的返回结果，会让调用者不知所措，是否我判断Optional之后，还用进行isEmpty的判断呢？

这样带来的返回值歧义！ 我认为是没有必要的。

我们要约定，对于List这种集合返回值，如果集合真的是null的，请返回空集合(Lists.newArrayList);

