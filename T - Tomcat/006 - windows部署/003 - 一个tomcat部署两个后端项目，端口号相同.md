## 一个tomcat部署两个后端项目

tomcat文件夹中的webapps文件夹，比如部署了一个buy和sale工程，分别是buy文件夹和sale文件夹。访问的时候直接带上项目名即可。

项目的名称，在pom.xml中的finalName中设置为buy，则生成的文件夹名称也是buy，因此带上后缀为/buy

```text
localhost:8080/buy/lookProduct

localhost:8080/sale/getMoney
```


### 不需要的步骤，一定不要去做下面的步骤（添加了<Context>反而不能启动tomcat服务）

```txt
        <Valve className="org.apache.catalina.valves.AccessLogValve" directory="logs"
               prefix="localhost_access_log" suffix=".txt"
               pattern="%h %l %u %t &quot;%r&quot; %s %b" />
               
        <!-- 添加路径 -->       
        <Context docBase="testdemo" path="/testdemo" reload="true">  
        <Context docBase="testdemo1" path="/testdemo1" reload="true">  
```

### 怎么确定两个项目都启动了？


