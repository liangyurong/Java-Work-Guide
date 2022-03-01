### vue项目中引用element

main.js
```js
import Vuex from 'vuex'                   //引入状态管理
import Vue from 'vue'                     // vue 模块在 node_modules 中
import router from './router'             // router 即 router 文件夹里定义的路由
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
Vue.use(ElementUI);

// 阻止vue 在启动时生成生产提示。
Vue.config.productionTip = false;

new Vue({
  el: '#app',
  router,
  template: '<App/>',
  components: { App }
});
```
