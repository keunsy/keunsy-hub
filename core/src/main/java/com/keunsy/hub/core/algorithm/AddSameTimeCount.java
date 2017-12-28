package com.keunsy.hub.core.algorithm;

import com.google.common.collect.Lists;

import org.apache.commons.collections4.CollectionUtils;

import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * Created on 2017/12/28.
 *
 * - 介绍：用于重新计算多个带有时间段以及数量的对象进行同时段数量累加
 *
 * -
 * 举例：
 * a：2017-01-01 00：00:00 -- 2017-06-01 00:00:00     20
 * b:2017-03-01 00：00:00 -- 2017-06-01 00:00:00     30
 * 则结果：
 * 1.2017-01-01 00：00:00 -2017-03-01 00：00:00   20
 * 2.2017-03-01 00：00:00 -2017-06-01 00：00:00   50
 *
 * - 特殊：非优化版，仅适用于按天计算的场景（可改造）
 */
public class AddSameTimeCount {

  private static final int DEVIATION_TIME = 60 * 1000;//允许的误差时间

  public List<Situation> reCreateSituation(List<Situation> situations) {

    if (CollectionUtils.isEmpty(situations)) {
      return situations;
    }
    if (situations.size() == 1) {
      if (situations.get(0).getCount() <= 0) {
        return Lists.newArrayList();
      } else {
        return situations;
      }
    }

    int len = situations.size();
    long[] timeArray = new long[len * 2];//新的时间区间
    for (int i = 0; i < len; i++) {
      timeArray[i * 2] = situations.get(i).getStartTime().getTime();
      timeArray[i * 2 + 1] = situations.get(i).getEndTime().getTime();
    }
    QuickSort.doQuickSort(timeArray);//进行排序

    List<Situation> list = Lists.newArrayList();
    for (int i = 0, timeArrayLen = timeArray.length; i < timeArrayLen - 1; i++) {

      if (timeArray[i] + DEVIATION_TIME > timeArray[i + 1]) {//时间相差一分钟则直接跳过，避免重复累加
        continue;
      }
      long midTime = (timeArray[i + 1] + timeArray[i]) / 2;//取中间进行比对
      Situation newSituation = null;
      for (Situation situation : situations) {
        if (midTime >= situation.getStartTime().getTime() && midTime <= situation.getEndTime().getTime()) {//在区间内
          if (newSituation == null) {//只需要设置一次
            newSituation = new Situation();
            newSituation.setStartTime(new Date(timeArray[i]));
            newSituation.setEndTime(new Date(timeArray[i + 1]));
            newSituation.setCount(situation.getCount() == null ? Integer.valueOf(0) : situation.getCount());
          } else {
            newSituation.setCount(newSituation.getCount() + situation.getCount());//区间数量进行累加
          }
        }
      }
      //剔除数量为零或者小于零的
      if (newSituation != null && newSituation.getCount() != null && newSituation.getCount() > 0) {
        list.add(newSituation);
      }
    }
    //进行再次合并，相邻数量相等则合并
    doCombine(list);
    return list;
  }

  /**
   * 相邻时间进行合并，前提为list内的数据是顺序的
   */
  private void doCombine(List<Situation> list) {
    if (CollectionUtils.isEmpty(list) || list.size() == 1) {
      return;
    }

    for (int i = 0, tempLen = list.size(); i < tempLen - 1; i++) {
      if (list.get(i).getCount().equals(list.get(i + 1).getCount()) && (list.get(i).getEndTime().getTime() + DEVIATION_TIME >= list.get(i + 1).getStartTime().getTime())) {
        //set value
        Situation newSituation = new Situation();
        newSituation.setCount(list.get(i).getCount());
        newSituation.setStartTime(list.get(i).getStartTime());
        newSituation.setEndTime(list.get(i + 1).getEndTime());
        //reset loop
        list.remove(i);
        list.add(i, newSituation);
        list.remove(i + 1);
        i--;
        tempLen--;
      }
    }
  }

  @Data
  public class Situation {
    Integer count;
    Date startTime;
    Date endTime;
  }
}
