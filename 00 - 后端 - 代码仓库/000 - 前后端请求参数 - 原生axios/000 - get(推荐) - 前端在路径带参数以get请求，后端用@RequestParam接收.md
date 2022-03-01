### vue前端（推荐）

```text
    methods: {
      loginBtn: function () {
        this.$axios({
          method: "get",
          url: "/login?username="+this.username+"&password="+this.password,
        }).then(response => {
          
        }).catch(error => console.log(error, "error"));

      }
    }
```

### springboot后端

```text
@GetMapping("/login")
public String login(    @RequestParam("username")String username,
                        @RequestParam("password")String password){
    return username+"  "+password;
}
```

### post中构建请求

http://localhost:8074/login?username=yurong333&password=123456
