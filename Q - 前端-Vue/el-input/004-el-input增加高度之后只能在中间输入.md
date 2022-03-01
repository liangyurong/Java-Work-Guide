
解决：加入type="textarea"

```vue
<div class="my-style">
  <el-input type="textarea"></el-input>
</div>
```

须在el-input的上一层去修改.

因为type="textarea"，所以这里需要写el-textarea__inner，而不是el-input__inner

```js
/** 调整el-input的高度 */
.my-style>>>.el-textarea__inner{
    height: 130px !important;
  }
```
