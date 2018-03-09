package com.keunsy.hub.temp;

/**
 * Created on 2018/3/9.
 */
public class Test02 {

  public static void main(String[] args) {


    for (; ; ) {
      Thread thread = new Thread() {
        @Override
        public void run() {
          System.out.println("1111111111");
          try {
            Thread.sleep(1000000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      };
      thread.start();
    }
  }
}
