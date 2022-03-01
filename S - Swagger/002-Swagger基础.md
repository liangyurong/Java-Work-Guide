### 使用和禁用Swagger文档

@Profile、@ConditionalOnProperty两个注解用来做条件判断，在特定的条件下才加载swagger配置类。

一般情况下，在生产环境中我们需要禁用swagger文档，因为swagger文档会带来一些安全问题，我们就利用上述两个条件装配注解来解决。

用代码实现禁用Swagger文档（暂时还没用过）
```text

```

### 为什么swagger会出现？为了解决什么问题？

前后端完全分离的情况下，需要接口进行交互。

有接口就需要接口文档。以前使用word文档进行交互，但是更新不及时，于是swagger出现了。

### 
