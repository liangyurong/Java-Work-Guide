
不是在el-input设置样式，而是在上一级设置样式
```vue
<div class="inputDeep">
    <el-input></el-input>
</div>
```

解决
```text
/* 利用穿透，设置input边框隐藏 */
  .inputDeep>>>.el-input__inner {
    border: 0;
  }

  /* 如果你的 el-input type 设置成textarea ，就要用这个了 */
  .inputDeep>>>.el-textarea__inner {
    border: 0;
    resize: none;/* 这个是去掉 textarea 下面拉伸的那个标志，如下图 */
  }
```
