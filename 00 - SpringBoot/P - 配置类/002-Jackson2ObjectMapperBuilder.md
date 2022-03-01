待解决

### Jackson2ObjectMapperBuilder

导包
```java
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
```

### 作用

处理时间

代码举例子：我现在还不知道这个东西究竟有什么用
```java
	/** 处理时间格式  */
	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper objectMapper = jackson2ObjectMapperBuilder.build();
		DateFormat dateFormat = objectMapper.getDateFormat();
		objectMapper.setDateFormat(new CommonDateFormat(dateFormat));
		return objectMapper;
	}
```





























