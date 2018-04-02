package com.keunsy.hub.temp;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created on 2018/3/21.
 */
public class TestThread01 {


  public static void main(String[] args) throws ExecutionException, InterruptedException {


    ExecutorService executorService1 = Executors.newFixedThreadPool(5);
//    ExecutorService executorService = Executors.newCachedThreadPool();


    for (int i = 0; i < 10; i++) {
      int finalI = i;
      executorService1.submit(() ->
              {
//                System.out.println("1---" + finalI);
                try {
                  Thread.sleep(3000);
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
                return finalI;
              }
      );
    }

    ThreadPoolExecutor executorService2 = new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<>(50));
    for (int i = 0; i < 100; i++) {
      int finalI = i;
      executorService2.submit(() ->
              {
                System.out.println("2---" + finalI);
                try {
                  Thread.sleep(3000);
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
                return finalI;
              }
      );
    }
  }
}
