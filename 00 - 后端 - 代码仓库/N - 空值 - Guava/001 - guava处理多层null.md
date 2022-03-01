## guava处理多层null

### 待解決的代碼

```jshelllanguage
JSONObject json = JSONArray.getJSONObject(0);
if(null != json){
   JOSNObject person =  json.getJSONObject("person");
   if(null != person){
     String name =  person.getString("name");   
     if(null != name){
         name += "233";
     }
   }
}
```

```jshelllanguage
JSONObject json = JSONArray.getJSONObject(0);
if(null != json){
   JOSNObject person =  json.getJSONObject("person");
   
   if(null == person){
       return;
   }
   
   String name =  person.getString("name");   
   
   if(null == name){
       return ;
   }
   
   name += "233";

}
```
