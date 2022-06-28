### 基于轮询的负载均衡

访问链接：http://localhost:8083/feign/hello ， 轮询的结果

    第一种：这是provider AAA的接口

    第二种：这是provider BBB的接口

当关闭了全部的provider，则出现熔断

    访问/hello ， 出现提醒：服务维护中

