
## 将oracle的sql导入一个新的oracle库中

对于oracle的sql表，打开，查看用户（比如是MCHSUSER），在cmd窗口进入sqlplus，新建一个表空间和一个用户C##MCHSUSER

使用notepad++，将sql表中的MCHSUSER全部替换为C##MCHSUSER

将sql表导入plsql

## oracle表转mysql表

1、打开navicat

2、打开需要转换的数据库 - “工具” - 选择“数据传输”

3、左边选择需要转换的数据库，右边选择目标数据库

4、点击下一步，“自定义”中选择需要转化的表。（也可选择运行期间全部的表）

5、一直下一步即可
