### buffer的三个属性

capacity

    buffer作为一个内存块，是有一个固定值的。你只能在里面写capacity个byte，long，char等类型。一旦buffer满了，需要将其清空（通过读数据或者清除数据），才能继续往里面写数据

position 和 limit，取决于buffer处在写模式还是读模式

