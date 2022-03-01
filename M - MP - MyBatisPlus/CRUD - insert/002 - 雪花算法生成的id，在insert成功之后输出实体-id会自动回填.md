## insert成功-输出实体-id会自动回填

如果类是雪花算法生成的id，则会自动回填

### 实体类

```jshelllanguage
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@TableName("v_test_result")
public class VTestResult implements Serializable {

    private static final long serialVersionUID=1L;

    private String id;

    private String name;
}
```

### 测试

```jshelllanguage
  @Test
  public void insert() {
    VTestResult v = new VTestResult();
    v.setName("aaaa");
    int insert = vTestResultMapper.insert(v);
    System.out.println("insert="+insert);
    System.out.println(v);
  }
```

### 结果

输出的实体类会有id
