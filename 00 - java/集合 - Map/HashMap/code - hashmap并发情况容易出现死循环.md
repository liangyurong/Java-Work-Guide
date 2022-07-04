
在resize()方法里得transfer()方法，会出现扩容死循环问题

```jshelllanguage
    final HashMap<String, String> map = new HashMap<String, String>();
    for (int i = 0; i < 1000; i++) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                map.put(UUID.randomUUID().toString(), "");
            }
        }).start();
    }
```