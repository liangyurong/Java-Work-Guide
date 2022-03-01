
比如，我现在有个父组件，有许多自定义的组件，radio，checkbox之类的

```text
questions:[
 { //radio
   quName:"xxx",
   quTypeCode:0,
    options:[
     {option:"xxx1"},
     {option:"xxx2"},
     {option:"xxx3"}
   ]
 },
 { //checkbox
    quName:"xxx",
    quTypeCode:1,
    options:[
     {option:"xxx1"},
     {option:"xxx2"},
     {option:"xxx3"}
   ]
 },

]
```

现在的radio数据是
```text
quName:"xxx"
options:[
  {option:"xxx1"},
  {option:"xxx2"},
  {option:"xxx3"}
]
```
需要上面的子组件属性数据序列化成json数据
```txt
{
   quName:"xxx",
   options:[
        {
            option:"xxx1"
        },
        {
            option:"xxx2"
        },
        {
            option:"xxx3"
        }
  ]
}
```
操作
```text
var jsonData = JSON.stringify(this.questions[0]);
console.log(jsonData);//序列化输出，也就是输出json对象
```
