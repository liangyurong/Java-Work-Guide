## MySQL 遇到过死锁问题吗

排查死锁的一般步骤

    （1）查看死锁日志 show engine innodb status; 
    （2）找出死锁Sql 
    （3）分析sql加锁情况 
    （4）模拟死锁案发
    （5）分析死锁日志
    （6）分析死锁结果

