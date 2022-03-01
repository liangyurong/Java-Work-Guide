
## 不推荐

this.$router.go(0); // 刷新页面的时候会白屏一下，给用户的体验不好

## 推荐

1.Vue项目中有一个App.vue。首先在 App.vue 的 <router-link /> 添加 v-if 属性
2.其次在 data 里面添加 isRouetrAlive，这个属性名可以自定义，默认设置为 true，如果为 false 整个页面就不会显示了。
3.然后在 methods 里面添加一个刷新方法reload()
4.最后需要把这个函数 provide 出去

完整的App.vue
```text
<template>
  <div id="app">
    <router-view v-if="isRouterAlive"></router-view>
  </div>
</template>

<script>
export default {
  name:'App',
  provide () {
    return {
      reload: this.reload
    }
  },
  data () {
    return {
      isRouterAlive: true
    }
  },
  methods: {
    reload () {
      this.isRouterAlive = false;
      this.$nextTick(function() {
        this.isRouterAlive = true
      })
    }
  }
};
</script>
```

某个refresh组件(名字是我随便定义的)需要使用的时候，则
```text
要使用的组件：

<template>
  <button @click="refresh"></button>
</template>
<script>
  export default{
    name: 'refresh',
    inject: ['reload'], // 必不可少
    methods: {
      refresh () {
        this.reload() // 需要刷新的时候，直接调用this.reload
      }
    }
  }
</script>
```
