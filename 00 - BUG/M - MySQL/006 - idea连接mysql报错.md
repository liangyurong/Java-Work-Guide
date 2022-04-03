### idea连接mysql报错

Server returns invalid timezone. Go to 'Advanced' tab and set 'serverTimezone' property

### 解决

1、去到mysql安装的bin目录：C:\Program Files\MySQL\MySQL Server 8.0\bin

2、输入：mysql -u root -p

3、输入密码

4、输入：show variables like '%time_zone%';

5、输入：set global time_zone = '+8:00';


