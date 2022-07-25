## Read View

Read View是一个数据结构，包含4个字段

    m_ids：当前活跃的事务编号集合（事务已经开启但是还没有commit）

    min_trx_id：最小活跃事务编号

    max_trx_id：预分配事务编号，当前最大事务编号+1

    creator_trx_id：ReadView创建者的事务编号

Read View是什么？

    Read View是事务进行快照读操作的时候产生的读视图。

什么是当前活跃的事务？

    事务已经开启，但还没commit的，就是活跃事务



根据ReadView中的四个字段，决定怎么从版本链中进行提取


