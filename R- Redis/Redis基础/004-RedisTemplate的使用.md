



### 对String的操作

```java
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = RunMyApplication.class)
public class TestRedis {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testRedis() {
        String key = "age";
        redisTemplate.opsForValue().set(key, 1);
        Object object = redisTemplate.opsForValue().get(key);
        redisTemplate.opsForValue().increment(key); // age+1
        redisTemplate.opsForValue().decrement(key); // age-1
    }
}
```

多次访问一个key的时候，我们可以将可以进行绑定，以便减少代码量
```txt
    @Test
    public void boundKey(){
        String key="age";
        BoundValueOperations operations=redisTemplate.boundValueOps(key);
        operations.increment();
        operations.increment();
        operations.increment();
        System.out.println(operations.get());
    }
```
### 对Hash的操作

```txt
   @Test
   public void testHash(){
      String key="user";
      redisTemplate.opsForHash().put(key,"id",1);
      redisTemplate.opsForHash().put(key,"name","lyr");
      Object id = redisTemplate.opsForHash().get(key, "id");
      Object name = redisTemplate.opsForHash().get(key, "name");
      System.out.println(id+" - "+name);
   }
```

### 对Set的操作

```txt
    @Test
    public void testSet(){
        String key="set";
        redisTemplate.opsForSet().add(key,"22","33","11","55","44");
        System.out.println(redisTemplate.opsForSet().size(key));
        System.out.println(redisTemplate.opsForSet().pop(key));
        System.out.println(redisTemplate.opsForSet().members(key));
    }
```

### 对SortedSet的操作

```txt
    @Test
    public void testSortedSet(){
        String key="sortedSet";
        redisTemplate.opsForZSet().add(key,"11",1);
        redisTemplate.opsForZSet().add(key,"44",4);
        redisTemplate.opsForZSet().add(key,"33",3);
        redisTemplate.opsForZSet().add(key,"55",5);
        redisTemplate.opsForZSet().add(key,"22",2);
        System.out.println(redisTemplate.opsForZSet().size(key));
        System.out.println(redisTemplate.opsForZSet().range(key,1,3));
        System.out.println(redisTemplate.opsForZSet().zCard(key));
        System.out.println(redisTemplate.opsForZSet().score(key,"22"));
        System.out.println(redisTemplate.opsForZSet().rank(key,"22"));
    }
```
















/
