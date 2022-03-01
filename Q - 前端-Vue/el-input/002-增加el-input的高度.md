### 一、组件

```vue
<div class="my-style">
  <el-input></el-input>
</div>
```

### 二、样式

必须在el-input的上一层去修改

```js
.my-style>>>.el-input__inner{
    height: 130px;
}
```







