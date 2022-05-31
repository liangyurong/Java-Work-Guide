### for

```jshelllanguage
    Set<String> keys = new LinkedHashSet<>();

    for (String key:keys){
        System.out.println(key);
    }
```

### iterator()

```jshelllanguage
    Set<String> keys = new LinkedHashSet<>();

    Iterator<String> it = keys.iterator();
    while (it.hasNext()){
        String next = it.next();
        System.out.println(next);
    }
```

### forEach

```jshelllanguage
    Set<String> keys = new LinkedHashSet<>();
    keys.forEach(System.out::println);
```
