
## 条件分页查询

```jshelllanguage
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

  @Autowired
  VTestResultService vTestResultService;

  @Test
  public void pageSelectVTestResult(){

    QueryWrapper<VTestResult> query = new QueryWrapper<>();

    LocalDateTime  startDate = LocalDateTime.now();             // 今天
    LocalDateTime endDate = LocalDateTime.now().plusDays(10L);  // 今天的往后十天

    // 日期范围，字段是数据库字段
    query.ge("report_date",startDate);
    query.le("report_date",endDate);

    // 当前页面和一页显示的数量
    // 当前页面从1开始算起，不是从0开始算起
    Page<VTestResult> page = new Page<>(1,10);

    // 条件分页
    Page<VTestResult>  result = vTestResultService.page(page, query);

    JSONObject json = new JSONObject();
    json.put("result",result);

    System.out.println(json);
  }

```
