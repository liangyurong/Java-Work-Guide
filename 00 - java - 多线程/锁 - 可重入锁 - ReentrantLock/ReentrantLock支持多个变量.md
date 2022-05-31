## ReentrantLock支持多个条件变量

synchronized中有条件变量，就是waitSet休息室，当条件不满足的时候进入waitSet等待

ReentrantLock支持多个条件变量，也就是拥有多个休息室

    synchronized中不满足条件的线程都只在一间休息室

    ReentrantLock支持多间休息室，比如等早餐，等外卖，等快递的休息室。唤醒的时候也是按照休息室来唤醒的

### 使用流程

await前需要获得锁

await执行后，会释放锁，进行conditionObject等待

await的线程被唤醒（打断，超时），需要重新竞争锁

竞争锁成功后，从await后继续执行代码


