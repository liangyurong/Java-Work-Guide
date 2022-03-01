
this.permissionsArr是一个自定义数组

```text
   <div v-for="(item,index) in this.permissionsArr" :key="index">
      <el-button v-if="item==='user:select'" type="primary" @click="selectBtn">查询按钮</el-button>
      <el-button v-if="item==='user:add'" type="primary" @click="addBtn">增加按钮</el-button>
      <el-button v-if="item==='user:update'" type="primary" @click="updateBtn">更新按钮</el-button>
      <el-button v-if="item==='user:delete'" type="danger" @click="deleteBtn">删除按钮</el-button>
    </div>
```
