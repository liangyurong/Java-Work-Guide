

```vue
<el-form ref="form" label-width="100px" class="title-desc-inFormStyle" :model="survey" :rules="rules"  id="selectForm">
     <el-form-item label="问卷名称" class="title-style" prop="title">
          <el-input type="text" v-model="survey.title" class="title-desc-input-style"></el-input>
     </el-form-item>
</el-form>
```

样式:只有对el-form添加了一个id才能达到修改el-form-item的label效果
```vue
  #selectForm>>>.el-form-item__label {
    font-size:18px;
    margin-left: 10px;
  }
```













