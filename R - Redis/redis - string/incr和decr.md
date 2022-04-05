### incr和decr

incr key

    将key中的数字+1

    只能对数值操作

    如果为空，新增值为1

decr key

    将key中的数字-1

incrby key 步长

    将vlaue加上自定义步长

decrby key 步长

    将vlaue减去自定义步长

### 原子操作

以上都是redis中特有的原子操作，是不会被线程调度机制打断的操作。

这种操作一旦开始，就一直运行到结束，中间不会切换到其他线程。

redis单命令的原子性得益于redis的单线程。

在多线程中，不能被其他线程打断的操作就是原子操作。





