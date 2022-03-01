
```jshelllanguage
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

  @Autowired
  VTestResultMapper vTestResultMapper;

  @Test
  public void pageSelectVTestResult1(){

    LocalDateTime  startDate = LocalDateTime.now();
    LocalDateTime  endDate = LocalDateTime.now().plusDays(10L);

    LambdaQueryWrapper<VTestResult> query = new LambdaQueryWrapper<>();

    // 日期范围，字段是数据库字段
    // VTestResult是实体类
    query.ge(VTestResult::getReportDate,startDate);
    query.le(VTestResult::getReportDate,endDate);

    List<VTestResult> result = vTestResultMapper.selectList(query);

    JSONObject json = new JSONObject();
    json.put("result",result);

    System.out.println(json);
  }
```
