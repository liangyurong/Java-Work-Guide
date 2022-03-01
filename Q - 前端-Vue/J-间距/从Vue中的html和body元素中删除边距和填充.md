### 题目链接

https://stackoverflow.com/questions/59827261/remove-margin-and-padding-from-html-and-body-elements-in-vue

### 解决

在App.vue中添加下面的style代码即可。如果不行就刷新一下页面。

```vue
<template>
 // 只是给个参考位置
</template>
<script>
 // 只是给个参考位置
</script>

<style>
  /** element ui会默认有一些padding，导致页面有间隔不美观。因此在此设置 */
  body{
    padding: 0;
    margin: 0;
  }
</style>


```

