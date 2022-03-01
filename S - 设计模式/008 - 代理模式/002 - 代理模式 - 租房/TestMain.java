package com.sdyb.aiyimei.test;

public class TestMain {
  public static void main(String[] args) {
     House yurong = new Yurong();

     HouseProxy proxy = new HouseProxy(yurong);

     proxy.findHouse();

  }
}
