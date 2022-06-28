## having基础

作用：过滤数据

having需要在group by后面（一般也是这两个搭配使用）

筛选条件中含有聚合函数，则不能使用where，应该使用having

     根据执行顺序，having可以使用group by之后的分组数据，但是where在group by之前执行

    

