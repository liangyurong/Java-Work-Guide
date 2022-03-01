
### 常见格式

```java
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    
}
```

### 官方推荐

官方推荐直接实现WebMvcConfigurer或者直接继承WebMvcConfigurationSupport

方式一实现WebMvcConfigurer接口（推荐）

方式二继承WebMvcConfigurationSupport类

### 常见方法

这些方法还不知道是不是过时的。待验证
```java
/** 拦截器配置 **/
void addInterceptors(InterceptorRegistry var1);

/** 视图跳转控制器 **/
void addViewControllers(ViewControllerRegistry registry);

/** 静态资源处理 **/
void addResourceHandlers(ResourceHandlerRegistry registry);

/** 默认静态资源处理器 **/
void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer);

/** 这里配置视图解析器 **/
void configureViewResolvers(ViewResolverRegistry registry);

/** 配置内容裁决的一些选项 **/
void configureContentNegotiation(ContentNegotiationConfigurer configurer);

/** 解决跨域问题 **/
public void addCorsMappings(CorsRegistry registry) ;
```























