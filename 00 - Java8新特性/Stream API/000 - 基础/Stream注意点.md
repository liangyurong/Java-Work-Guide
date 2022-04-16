对于Collection（List、Set、Queue等），直接调用stream()方法就可以获得Stream。


Map不能直接使用stream()方法。但是可以使用map.entrySet().stream()

        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();

        entrySet.stream()
                .filter(entry -> entry.getValue()>23)
                .forEach(entry -> System.out.println(entry.getKey()+" : "+entry.getValue()));




