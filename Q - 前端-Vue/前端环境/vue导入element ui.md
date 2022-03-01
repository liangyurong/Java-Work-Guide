
### vue导入element ui

- 打开cmd，在命令行中输入npm i element-ui
- 在main.js中输入以下代码
```vue
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
Vue.use(ElementUI)
```
- 完整的main.js如下
```vue

// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios'; //导入axios
import ElementUI from 'element-ui'  //导入elementui
import 'element-ui/lib/theme-chalk/index.css' //导入elementui

//全局注册，使用方法为:this.$axios
Vue.prototype.$axios = axios

//设置全局的访问路径， 之后在axios的请求路径中就没必要添加
axios.defaults.baseURL = 'http://localhost:8002';

Vue.prototype.HOST='/user'
Vue.prototype.$axios = axios
Vue.config.productionTip = false
Vue.use(ElementUI)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },   //调用组件
  template: '<App/>'
})
```
