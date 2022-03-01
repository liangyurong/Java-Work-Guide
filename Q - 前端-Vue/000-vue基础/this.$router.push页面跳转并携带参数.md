
## this.$router.push是什么作用？

跳转到vue定义的url，能够给你展示不同的页面

```text
        this.$axios({
          method: "post",
          url: "/login",
          data:this.user,
        }).then(response => {
          if (0 === response.data.code) {
            this.$router.push(
              {
                path:"/index",
                query:{
                  myUserData:response.data.data // 传递给下个页面的数据是user
                }
              }
            );
          }else{
            console.log("oh ! login fail...");
          }
        })
```

下一个页面获取数据
```text
this.$route.query.myUserData
```
