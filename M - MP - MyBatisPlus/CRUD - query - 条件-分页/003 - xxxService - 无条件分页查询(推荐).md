## 步骤

1、配置拦截器组件

2、直接使用: xxxService.page()

### 1、配置拦截器组件

```java
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement(proxyTargetClass = true)
@Configuration
public class MybatisPlusConfig {

    /**
     * MybatisPlus分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}

```

### 直接使用: xxxService.page()

```jshelllanguage
import com.sdyb.aiyimei.service.VPatientService;

  @Autowired
  VPatientService vPatientService;

  @Test
  public void pageSelectVPatient(){
      // 当前页面从1开始算起，不是从0开始算起
      Page<VPatient> page = new Page<>(1,2);
      Page<VPatient> vPatientPage = vPatientService.page(page);
  }
```

### xxxService，比如实体类是VPatient

```jshelllanguage
import com.sdyb.aiyimei.entity.VPatient;
import com.baomidou.mybatisplus.extension.service.IService;
public interface VPatientService extends IService<VPatient> {

}
```
