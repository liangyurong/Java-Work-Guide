

### 设置id

在v-for中设置id，必须使用:id

```vue
<div v-for="(item,index) in survey.questions" :key="item.myid" :id="gernerateId(index)">
   <radio></radio>
   <checkbox></checkbox>
   <mytext></mytext>
</div>
```

### js方法

```js
// 为div生成一个特定的id
gernerateId: function(index){
    return "index_" +index
}
```

### 跳转到

```js
document.querySelector("#index_"+this.indexWarn).scrollIntoView(true);
```

