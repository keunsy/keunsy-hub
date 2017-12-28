package com.keunsy.hub.core.algorithm;

import com.google.common.collect.Lists;

import java.util.List;

import lombok.Builder;
import lombok.Data;

/**
 * Created on 2017/12/28.
 * - 根据比例轮流
 * - 举例：
 * A:B = 3:7
 * 则：
 * A B A B A B B B B B
 * 即：assignTimes=0 返回 A;assignTimes=1 返回 B
 */
public class RollByRate {


  public static void main(String[] args) {
//
//    List<People> list = Lists.newArrayList();
//    list.add(People.builder().name("A").rate(1).build());
//    list.add(People.builder().name("B").rate(3).build());
//    list.add(People.builder().name("C").rate(6).build());
//
//    for (int i = 0; i < TOTAL_RATE; i++) {
//      System.out.println(i + ":" + roll(i, list));
//    }

    //    for (int i = 0; i < TOTAL_RATE; i++) {
//      System.out.println("roll times:" + i + ";result:" + roll(i, list));
//    }


    for (int i = 1; i < TOTAL_RATE; i++) {
      List<People> list = Lists.newArrayList();
      list.add(People.builder().name("A").rate(i).build());

      list.add(People.builder().name("B").rate(10 - i).build());

//      int bRate = RandomUtils.nextInt(1, 10 - i);
//      list.add(People.builder().name("B").rate(bRate).build());
//      list.add(People.builder().name("C").rate(TOTAL_RATE - i - bRate).build());

      System.out.println("========" + i + "================");
      System.out.println(list);
      for (int j = 0; j < TOTAL_RATE; j++) {
        System.out.println(j + ":" + roll(j, list));
      }
    }

  }

  private static final int TOTAL_RATE = 10;

  public static String roll(int assignTimes, List<People> peoples) {

    if (TOTAL_RATE != peoples.stream().mapToInt(x -> x.getRate()).sum()) {
      throw new RuntimeException("数据异常");
    }

    if (assignTimes >= 10 || assignTimes <= 0) {
      return peoples.get(0).getName();
    }

    int loopTimes = 0;
    int size = peoples.size();
    List<People> list = Lists.newArrayList();

    while (list.size() <= assignTimes) {
      int index = loopTimes % size;
      int times = loopTimes / size;
      if (peoples.get(index).getRate() > times) {
        list.add(peoples.get(index));
      }
      loopTimes++;
    }
    return list.get(assignTimes).getName();
  }

  @Data
  @Builder
  private static class People {

    int rate;
    String name;
  }
}
