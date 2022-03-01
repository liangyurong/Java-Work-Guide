
这里是通过GET方式从后端获取数据。

操作
1.首先在methods里面写一个函数getFromBackEnd()
2.在mounted里面调用getFromBackEnd()，则能够自动触发getFromBackEnd()方法。

```text
<script>
  export default {
    data: function () {
      return {
     
      }
    },
    methods: {
      getFromBackEnd:function () {
        this.$axios({
          method: "get",
          url: "/user/test",
        }).then(response => {  //后端响应回来的结果
          if (0 === response.data.code) {
            console.log(response.data.code + " " + response.data.msg);
          } else {
            console.log(response.data.code + " " + response.data.msg);
          }
        }).catch(error => console.log(error, "error"));
      },
    },
    mounted:function () { //自动触发写入的函数
      this.getFromBackEnd();
    }
  }
</script>
```
