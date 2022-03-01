package com.sdyb.aiyimei.test;

/**
 * 需要找房子的租客
 */
public class Yurong implements House {
    @Override
    public void findHouse(){
       // 这个动作相当于是业务代码
       System.out.println("yurong找到了房子");
    }
}
