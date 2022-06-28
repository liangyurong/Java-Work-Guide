
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 重点
 * 1、常量是static ( 一般不设置为private String baseUrl ， 因为本意就是要设置该变量为全局变量 )
 * 2、set方法没有static
 * 3、get方法有static
 * 4、不使用@Data，而是使用set和get的原始方法，这样在项目还没编译运行时候使用GlobalProperties.getXXX()才会不报错
 */
// set方法没有static , 如果有的话，取值为null
@Configuration
@ConfigurationProperties(prefix="lhrm") // prefix不可使用驼峰命名或者下划线命名
@Data
public class GlobalProperties {

    private static String baseUrl;

    public static String getBaseUrl() {
        return baseUrl;
    }

    public  void setBaseUrl(String baseUrl) {
        GlobalProperties.baseUrl = baseUrl;
    }

}
