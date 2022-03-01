package com.sdyb.aiyimei.test;

/**
 * 具体的做菜。
 *
 * 只需要重写doCook()方法，其余父类的方法都能继承过来。
 */
public class CookTomato extends Cook {


    @Override
    public void doCook() {
      System.out.println("炒西红柿");
    }


}
