package com.keunsy.hub.temp;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

public class Test05 {
  public static void main(String args[]) {
    List<GarbageCollectorMXBean> l = ManagementFactory.getGarbageCollectorMXBeans();
    for (GarbageCollectorMXBean b : l) {
      System.out.println(b.getName());
      System.out.println(b.getObjectName());
    }

    new Thread() {
      @Override
      public void run() {


      }
    };
  }
}  