## 循环输出map

### 第一种：低效率

```jshelllanguage
        Map<String,Object> map = new HashMap<>();
        Set<String> keys = map.keySet();
        for(Object key:keys){
            System.out.println(key+" : "+ map.get(key));
        }
```

为什么效率低

### 第二种：高效率

```jshelllanguage
        Map<String, Object> map = new HashMap<>();
        Set<Map.Entry<String, Integer>> es = map.entrySet();
        for(Map.Entry entry: es) {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
```

为什么效率高