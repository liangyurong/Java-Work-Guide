
### 

```jshelllanguage
    private ResponseParam BcTextScan(BcSecret genSign, List<TaskDTO> sendList) {
       
        // 构建url
        url=url+"?appId="+genSign.getAppId()+"&timestamp="+genSign.getTimestamp()+"&sign="+genSign.getSign();

        // 构建json形式的字符串，发送post请求
        RequireParam param = new RequireParam();
        param.setTasks(sendList);
        param.setBizType("nickName");
        String result = HttpUtil.post(url, JSONObject.toJSONString(param));

        return result;
    }
```
