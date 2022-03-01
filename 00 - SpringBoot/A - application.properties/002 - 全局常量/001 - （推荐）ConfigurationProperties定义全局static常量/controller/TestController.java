@RestController
public class TestController {

    @GetMapping("/hi")
    public String hi(){
        return GlobalProperties.getBaseUrl();
    }

}
