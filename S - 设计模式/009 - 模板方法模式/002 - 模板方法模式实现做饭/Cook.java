package com.sdyb.aiyimei.test;

/**
 * 将做饭的几个步骤定义为抽象类
 *
 * <p>做饭的步骤：1、开火 2、做菜 3、关火
 *
 * 所有做菜都需要开火和关火，因此可以抽离出来。
 *
 */
public abstract class Cook {

  public void openFire() {
    System.out.println("开火");
  }

  /** 菜的样式是不同的，因此得定义为抽象方法 */
  public abstract void doCook();

  public void closeFire() {
    System.out.println("关火");
  }

  /**
   * 将做饭的步骤整合起来
   *
   * 因为做饭的步骤就是如此，不能被子类去修改，所以将该类用final修饰
   * */
  public final void allCookStep(){
      this.openFire();
      this.doCook();
      this.closeFire();
  }

}
