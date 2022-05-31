## n个线程分别执行for循环的一个小循环

### 需求

一个500次的循环，每次输出i+1

说明：把500次循环分开成10次执行，互相是没有影响的

### 简单代码

```jshelllanguage
  public void simpleTest() {
    for (int i = 0; i < 500; i++) {
        int tmp = i+1;
        System.out.println(tmp);
    }
  }
```

### 多线程代码

50个线程，分批执行
