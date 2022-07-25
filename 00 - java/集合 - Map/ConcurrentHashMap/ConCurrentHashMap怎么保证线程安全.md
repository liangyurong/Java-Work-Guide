## ConCurrentHashMap怎么保证线程安全

JDK1.8中，是采用CAS+volatile或synchronized实现的


添加元素时先判断容器是否为空，为空则使用cas+volatile来初始化

    容器不为空则计算元素的存储位置

如果存储位置为空，利用cas设置该节点

    如果不为空则利用synchronized加锁，然后遍历桶中数据，替换或者新增节点到桶中，最后再判断是否需要转为红黑树



















