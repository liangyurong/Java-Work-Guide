## sleep和yield的区别

Thread.sleep(2000); // 2s内没有机会获取到cpu时间片，因为线程处于阻塞状态

Thread.yield();     // 线程只是处于就绪状态，有机会获得cpu时间片，就会继续执行 
























