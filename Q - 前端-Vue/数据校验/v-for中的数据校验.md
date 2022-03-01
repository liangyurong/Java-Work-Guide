

### 分析

因为现在是变量，只能使用以下方法

options是一个数组，需要校验item里面的myoption

:prop必须这么写 -》 数组+index+校验字段

:rules直接写校验，在方法里面写不奏效（暂时没想到更好的方法）

```vue
<el-form-item  v-for="(item,index) in options" :key="index" :prop="'options.'+index+'.myoption'" :rules="rules.myoption">
   <el-radio>
       <el-input  v-model="item.myoption" />
   </el-radio>
  </el-form-item>
```

```vue
  rules:{
       myoption:[{ required: true, message: '请输入选项', trigger: 'blur'}]
   },
```
