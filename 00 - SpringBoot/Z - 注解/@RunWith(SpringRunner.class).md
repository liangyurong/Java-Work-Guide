## @RunWith(SpringRunner.class)

Springboot的@RunWith(SpringRunner.class)

注解的意义在于Test测试类要使用注入的类，比如@Autowired注入的类，

有了@RunWith(SpringRunner.class)这些类才能实例化到spring容器中，自动注入才能生效，

不然直接一个NullPointerExecption









