
### 一、组件

```vue
<el-radio-group class="group-style">
   <!--单个选项-->
   <el-radio class="option-style">
        <label style="font-size: 14px;" disabled>{{item.myoption}}</label>
   </el-radio>
</el-radio-group>
```

### 二、样式

需要在el-radio的上一层去改

```vue
  .group-style>>>.el-radio__inner{
    height: 10px;
  }
```























