### 001-vue刷新页面会重置数据

本质：vue路由传参的方式

bug
```text
vue项目，经常会遇到组件之间数据的传递问题，B页面通过params或者query传参数id给A页面，但是，当A页面刷新的时候，数据会丢失，找不到数据
```
解决
```text
方法：B页面传递给A页面的方式，不要用params，而是用query

推荐：let id = this.$route.query.id; //A页面获取从父组件B传递过来的id

不推荐：let id = this.$route.params.id , 刷新页面导致数据丢失
```

```text
B页面
<template>
    <div>
        <button @click="toB(id)">跳转到A页面</button>
    </div>
</template>
<script>
export default {
    methods:{
        toA(id){
          this.$router.push({
            name:'A',
            query:{
              id:id
            }
          })
        }
    }
}
</script>

A页面
//获取id值
this.$route.query.id
```

### 002-写组件，用了v-if和v-for，直接得不到组件数据，得刷新才能看到组件的数据

这是因为vue不能监听数组的更新和修改。

解决：首先应该清空数组，再进行复制

### 003-跨域问题The value of the 'Access-Control-Allow-Origin' header in the response must not be the wildcard '*' when the request's credentials mode is 'include'. The credentials mode of requests initiated by t

原因

1、上面说到，CORS请求默认不发送Cookie和HTTP认证信息。如果要把Cookie发到服务器，一方面要服务器同意，指定Access-Control-Allow-Credentials字段。

2、出现这个报错信息很可能是你在前端设置了withCredentials = true;你可以去掉


解决：前端，在main.js中去掉这行代码：axios.defaults.withCredentials=true;


### 004-Access to XMLHttpRequest at 'http://localhost:8074/select' from origin 'http://localhost:8080' has been blocked by CORS policy: Response to preflight request doesn't pass access control check: Redirect is not allowed for a preflight request.

分析：你访问一个什么地址被CORS 协议阻止， 没有 在Hearder 里面发现 Access-Control-Allow-Origin 的参数的 资源

原因：浏览器出于安全考虑，限制访问本站点以为的资源。

### 005-直接访问ip地址的路径可以访问得到，但是通过扫描识别后不能访问得到






