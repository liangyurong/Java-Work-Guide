## Unresolved function or method $axios() 

解决

在main.js添加以下代码
```text
import axios from 'axios'                 // 异步请求
Vue.prototype.$axios = axios;//全局注册，使用方法为:this.$axios
```
