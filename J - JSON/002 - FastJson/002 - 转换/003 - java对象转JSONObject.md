## java对象转JSONObject
  
    import com.alibaba.fastjson.JSONObject;
     
    Student stu = new Student("公众号BiggerBoy", "m", 2);
        
    //Java对象转化为JSON对象
    JSONObject jsonObject = (JSONObject) JSONObject.toJSON(stu);




















