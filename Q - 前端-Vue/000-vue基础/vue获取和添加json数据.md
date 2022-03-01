

vue中有json数据,这里是optionsDesc

```txt
    data() {
      return {
        optionsDesc: [
          {
            option:'选项1'
          },
          {
            option:'选项2'
          }
        ]
      }
    },
```

- 获取某个数据

let op=this.optionsDesc[0].option; //获取到某个位置对应的值

- 向里面添加数据

```text
      addNewOption: function () { //添加一个新选项，
        let size = this.optionsDesc.length;
        size++;
          // let op=this.optionsDesc[0].option; //获取到某个位置对应的值
        let newOp="选项"+size;
        var json={"option":newOp};
        this.optionsDesc.push(json);
      }
```
