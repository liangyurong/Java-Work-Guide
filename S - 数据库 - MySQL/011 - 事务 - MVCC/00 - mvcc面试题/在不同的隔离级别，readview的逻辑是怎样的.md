## 在不同的隔离级别，read view的逻辑是怎样的


RC（读已提交）：在每一次执行快照读都会生成一个ReadView（执行普通select语句）

RR（可重复读）：仅在第一次执行快照读的时候生成ReadView，后续快照复用