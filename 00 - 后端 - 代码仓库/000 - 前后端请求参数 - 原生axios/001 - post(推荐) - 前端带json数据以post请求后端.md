

### 说明

headers要设置正确

### vue中构造Post请求

```vue
    methods: {
      loginBtn: function () {
        let config = {
          headers: {
            'Content-Type': 'application/json'
          }
        };
        this.$axios({
          method: "post",
          url: "/login",
          data: {
            "username": "yurong333"
            "password": "123456"
          }
        }).then(response => {
        
        }).catch(error => console.log(error, "error"));

      }
    }
```

### springboot后端

```text
import com.alibaba.fastjson.JSONObject; // 需要在pom.xml引入fastjson

@PostMapping("/login")
public String login(@RequestBody JSONObject json){

        String username = json.getString("username");
        String password = json.getString("password");
        
         return username+"  "+password;
        
    }
```
