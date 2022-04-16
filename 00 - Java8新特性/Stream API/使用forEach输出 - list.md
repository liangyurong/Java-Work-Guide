### list使用forEach输出

```jshelllanguage
    public static void main(String[] args) {
        List<Student> list = new LinkedList<>();
        list.add(new Student("1","name1"));
        list.add(new Student("2","name2"));
        list.add(new Student("3","name3"));
        list.add(new Student("4","name4"));
        list.add(new Student("5","name5"));

        list.stream().forEach(System.out::print);

    }
```
