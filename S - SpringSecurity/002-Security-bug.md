

001- 添加exclude = {SecurityAutoConfiguration.class }，才不会导致跨域失效
````java
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class }) // 不添加，则跨域失败
public class RunApplication {
    public static void main(String[] args) {
        SpringApplication.run(RunApplication.class,args);
    }
}
````
