### 集合中的对象排序

两个语句等同。Student是一个对象，age是一个属性。

list.sort((Student s1, Student s2) -> s1.getAge() - s2.getAge());

list.sort(Comparator.comparingInt(Student::getAge));  // 固定格式
