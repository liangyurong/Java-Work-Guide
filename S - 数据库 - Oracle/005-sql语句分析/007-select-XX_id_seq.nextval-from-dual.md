
## select-XX_id_seq.nextval-from-dual.md

dual ：是oracle 数据库中的虚拟表，并不是真实存在的

XX_id_seq：这个是我们创建序列时自定义的一个序列名称

ctg_fault_list_id_seq.nextval：这个是取出序列的下一个值，序列可以用户id生成器，每次我们都通过序列取到不同的值，并且不会重复


### 用处

划重点：当一个值必须返回，且只返回一次，可以从dual表选择返回。

