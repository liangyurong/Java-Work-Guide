## mysql开启远程

### 打开cmd

```txt
mysql -uroot -p

use mysql;
 
update user set host='%' where user='root';

flush privileges;
```
