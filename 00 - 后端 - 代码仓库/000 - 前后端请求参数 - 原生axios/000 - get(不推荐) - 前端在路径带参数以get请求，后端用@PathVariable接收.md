### vue

```text
    methods: {
      loginBtn: function () {
        this.$axios({
          method: "get",
          url: "/login/"+this.username+"/"+this.password,
        }).then(response => {
       
        }).catch(error => console.log(error, "error"));
      }
    }
```

### springboot

```text
@GetMapping("/login/{username}/{password}")
public String login(@PathVariable("username")String username, @PathVariable("password")String password){
       return username+"  "+password;
}
```

### postman构建请求

http://localhost:8074/login/yurong333/123456
