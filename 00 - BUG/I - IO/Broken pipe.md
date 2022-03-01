## bug信息

org.apache.catalina.connector.ClientAbortException: java.io.IOException: Broken pipe

## 原因

客户端读取超时关闭了连接,这时候服务器端再向客户端已经断开的连接写数据时就发生了broken pipe异常

## 解决（还没解决）

1、nginx配置超时？











