##  驱动程序无法通过使用安全套接字层(SSL)加密与 SQL Server 建立安全连接

### bug信息

com.microsoft.sqlserver.jdbc.SQLServerException: 驱动程序无法通过使用安全套接字层(SSL)加密与 SQL Server 建立安全连接。错误:“The server selected protocol version TLS10 is not accepted by client preferences [TLS12]”。 ClientConnectionId:44ec2e6d-a2da-4f89-98f0-bc323ae72c4c

### 原因

服务器的jdk没装好jre

### 解决

重装服务器上的jdk








