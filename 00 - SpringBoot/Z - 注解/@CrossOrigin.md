
### what is it ? usefulness ?

### how to use

The first method is to use the @CrossOrigin annotation. You can define a @CrossOrigin at the class or method level of @RestController, for example:

```java
@CrossOrigin(origins = "http://local.liaoxuefeng.com:8080")
@RestController
@RequestMapping("/api")
public class ApiController {
    //code
}
```
The above definition @CrossOrigin at ApiController specifies that only cross-domain access from local.liaoxuefeng.com is allowed, 
and access to multiple domains needs to be written in the form of an array, 
for example origins = {"http://a.com", "https:/ /www.b.com"}). If you want to allow access from any domain, just write origins = "*".

