package com.keunsy.hub.core.justforfun;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class RandomToBuyUtils {

  public RandomToBuyUtils() {
  }

  public static void main(String[] args) {
    String[] noteBook = new String[]{"n550", "y50"};
    String type = getFinalResult(noteBook);
    type = type.substring(0, type.indexOf("="));

    try {
      System.out.println("选机倒计时开始：");
      Thread.sleep(10000L);
      System.out.println("当当当当！经过亿次轮循，最终决定要购买的笔记本电脑为：" + type + "!!!");
    } catch (InterruptedException var4) {
      var4.printStackTrace();
    }

  }

  public static String getFinalResult(String[] noteBook) {
    Map<String, Integer> noteMap = new HashMap();
    Random random = new Random();

    int i;
    for (i = 0; i < noteBook.length; ++i) {
      noteMap.put(noteBook[i], 0);
    }

    for (i = 0; i < 100000000; ++i) {
      System.out.println("第" + i + "次！");
      int num = random.nextInt(noteBook.length);

      for (int j = 0; j < noteBook.length; ++j) {
        if (num == j) {
          noteMap.put(noteBook[j], (Integer) noteMap.get(noteBook[j]) + 1);
          break;
        }
      }
    }

    Map.Entry[] entry = getSortedHashtableByValue(noteMap);
    return entry[0].toString();
  }

  public static Map.Entry[] getSortedHashtableByValue(Map<String, Integer> map) {
    Set set = map.entrySet();
    Map.Entry[] entries = (Map.Entry[]) set.toArray(new Map.Entry[set.size()]);
    Arrays.sort(entries, new Comparator() {
      public int compare(Object arg0, Object arg1) {
        Long key1 = Long.valueOf(((Map.Entry) arg0).getValue().toString());
        Long key2 = Long.valueOf(((Map.Entry) arg1).getValue().toString());
        return key2.compareTo(key1);
      }
    });
    return entries;
  }
}