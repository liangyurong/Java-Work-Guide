
预编译是什么

    预编译就是将sql语句中的值用占位符代替，即sql语句模板化。做到了一次编译到处运行，省去了分析优化的过程。

为什么需要预编译

    数据库接收到sql语句之后，需要进行词法和语义解析，优化sql语句，制定执行计划。

    如果一条语句需要反复执行，每次都进行上述过程，会耗费很多时间。

怎么实现预编译

    mybatis是通过PreparedStatement和占位符来实现预编译的。

    默认情况下，PreparedStatement对所有sql进行预编译。

    将#{}替换为？，然后将带有占位符？的sql模板发送到mysql服务器，由mysql服务器对此无参数的sql进行编译，将编译结果缓存，然后直接执行带有真实参数的sql。

预编译的作用

    1、优化sql执行。预编译之后的sql多数情况下可以直接执行，数据库不需要再次编译，提升性能

    2、重复利用。将sql预编译后产生的PreparedStatement对象缓存下来，下一次对于同一个sql，可以直接使用这个缓存对象，

    3、防止sql注入。使用预编译后，之后注入的参数将不再进行sql编译，也就是不再认为参数会是sql语句，而默认是一个参数。