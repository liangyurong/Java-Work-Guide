## 配置代理

如果代理无需账号密码，可以直接：

```jshelllanguage
HttpResponse response = HttpRequest.post(url)
    .setHttpProxy("127.0.0.1", 9080)
    .body(json)
    .execute();

String body = response.body();
```
