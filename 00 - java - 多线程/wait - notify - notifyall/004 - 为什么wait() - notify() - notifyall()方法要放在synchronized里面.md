## 为什么wait()方法要放在synchronized里面

不搭配的话会造成Lost Wake-UP Problem。这个是什么问题？怎么证明？

不放的话，执行会抛出异常：java.lang.IllegalMonitorStateException

    这只是表面原因

