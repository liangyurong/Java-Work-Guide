
### zset数据结构

SortedSet(zset)是Redis提供的一个非常特别的数据结构

一方面它等价于Java的数据结构Map<String,double>,可以给每个元素value赋予一个权重score

另一方面它又类似于TreeSet,内部的元素会按照权重score进行排序，可以得到每个元素的名次，还可以通过score的范围来获取元素的列表。

### 两个底层结构

hash

    hash的作用就是关联元素value和权重score,保障元素value的唯一性，可以通过元素value找到相应的score值。

跳跃表
    
    跳跃表的作用在于给元素value排序，根据score的范围获取元素列表


