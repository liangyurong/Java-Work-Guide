我觉得得写下代码实践才能知道这是在做啥

### bean的生命周期

实例化（Instantiation）

    在堆里面申请开辟一块内存空间

属性赋值（Populate）

    为 bean 设置相关属性和依赖

    设置属性：比如A对象里面有个 private B b ; 那么这个b就是A的属性

初始化（Initialization）

销毁（Destruction）

### 成品和半成品

成品

    既完成实例化，也完成初始化

半成品

    完成实例化，没有完成初始化