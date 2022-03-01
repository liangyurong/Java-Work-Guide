### FastJson基础

JSONObject是 fastJson提供的对象。

想通过键值对的形式获取数据，使用JSONObject。

如果后台查询的是某个bean的list集合向前端页面传递，使用JSONArray。

JSONArray getJSONArray(String key)  // 如果JSONObject对象中的value是一个JSONObject数组，既根据key获取对应的JSONObject数组；

toJSONString() / toString()          // 将JSONObject对象转换为json的字符串

JSONObject.get(String key)          // 根据key值获取JSONObject对象中对应的value值，获取到的值是Object类型，需要手动转化为需要的数据类型

JSONObject.getString(String key)

获取到的值是String类型
