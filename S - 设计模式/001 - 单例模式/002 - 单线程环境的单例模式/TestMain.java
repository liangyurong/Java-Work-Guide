package com.lyr.demo.decorate;

public class TestMain {
    public static void main(String[] args) {
        // 结果：无论循环多少次，只是创建了一个构造器
        for (int i = 0; i < 10; i++) {
            Single.getInstance();
        }
    }
}
