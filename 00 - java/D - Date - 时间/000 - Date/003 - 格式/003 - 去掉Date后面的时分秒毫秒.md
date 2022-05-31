## 去掉Date后面的时分秒毫秒



### Date

如果直接返回now，后面会带有时分秒

### 解决

Date now = new Date();
String date = new SimpleDateFormat("yyyy-MM-dd").format(date)



























