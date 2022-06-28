## Unable to connect to Command Metric Stream.

原因

    

解决

    # 在配置文件添加以下代码
    hystrix:
      dashboard:
        proxy-stream-allow-list: "*"
