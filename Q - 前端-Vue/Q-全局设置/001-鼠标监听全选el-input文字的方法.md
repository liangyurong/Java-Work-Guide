
### 一、新建mycommon.js（注意需要与main.js同级）

以后添加的格式就是： Vue.prototype.$方法名 = function(){}

全局方法最好以$开头

```vue
export default {
  install (Vue, options) {

    // 鼠标点击el-input输入框，则全选文字
    Vue.prototype.$selectAllText = function (event) {
      event.currentTarget.select();
    }

  }
}
```

### 二、main.js设置

```vue
import mycommon from './mycommon';  // 全局方法和全局变量
Vue.use(mycommon);
```

### 三、组件中使用

```vue
 <el-input @focus="selectAllText($event)"></el-input>
```

方法中使用（注意selectAllText是组件声明的方法，$selectAllText是全局自定义的方法）
```vue
selectAllText: function ($event) {
    this.$selectAllText($event);
}
```
