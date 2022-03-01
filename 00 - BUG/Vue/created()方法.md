## 多次进入vue页面，created()方法只执行第一次，后面不在执行，需要刷新才能执行

原因
```text
当页面点击跳转详情请求在created中只执行第一次。创建后有缓存，关闭后也不会再执行created（具体是否有缓存可根据keepAlive和跳转路径进行判断）
```

解决：修改created为activated
```text
// 修改之前
created() {
    this.getList();
},
  
// 修改之后  
activated() {
    this.getList();
},  
```
