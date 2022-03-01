

### vue前端

```text
    methods: {
      loginBtn: function () {
        let config = {
          headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
          }
        };
        const myParams = new URLSearchParams();
        myParams.append('username', this.username);
        myParams.append('password', this.password);
        this.$axios({
          method: "post",
          url: "/login",
          params:myParams
        }).then(response => {
          
        }).catch(error => console.log(error, "error"));
      }
    }
```

### springboot后端

```text
@PostMapping("/login")
public String login(    @RequestParam("username")String username, 
                        @RequestParam("password")String password){
     return username+"  "+password;
}
```
