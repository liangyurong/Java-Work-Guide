

### 获取数组的某个属性

数组
```text
questionComponent: [
    {
        id:0,
        addComponent:radio,
    },
    {
        id:1,
        addComponent:check,
    }
]
```
获取数组的addComponent属性

```text
<div v-for="(item,index) in  questionComponent"  > 
    {{item.addComponent}}
</div>
```
