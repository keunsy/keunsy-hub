package com.keunsy.hub.core.algorithm.bit;

import java.util.BitSet;

/**
 * Created on 2018/3/9.
 *
 * 位图算法
 *
 * 比如有一堆数字，需要存储，source=[3,5,6,9]
 * 用int就需要4*4个字节。
 * java.util.BitSet可以存true/false。
 * 如果用java.util.BitSet，则会少很多，其原理是：
 * 1，先找出数据中最大值maxvalue=9
 * 2，声明一个BitSet bs,它的size是maxvalue+1=10
 * 3，遍历数据source，bs[source[i]]设置成true.
 * 最后的值是：
 * (0为false;1为true)
 * bs [0,0,0,1,0,1,1,0,0,1]
 * 3, 5,6, 9
 * 这样一个本来要int型需要占4字节共32位的数字现在只用了1位，这样就省下了很大空间。
 *
 * 见 java 中的 BitSet;
 * long[]实现 为64位
 *
 * 存储时：long[] 数组的位置由当前数对64取余来判定，而且其存的值是十进制码（比如存储：1 ，2 ， 3，那么二进制是 1110，转化为十进制就是14 ）
 *
 * 1L << bitIndex： bitIndex取余64，如 1L << 2  = 2 % 64 = 2
 *
 * words[wordIndex] |= (1L << bitIndex) ： 先取余，后进行“或运算” 也就是存在一个1即为1，都是0才为零，结果会自动转为十进制
 *
 * 去重高效，占内存低；(处理海量数据)
 */
public class BitMap {

  public static void main(String[] args) {
    int[] array = new int[]{1, 2, 2120, 3, 22, 0, 3, 126, 1150};
    BitSet bitSet = new BitSet();
    //将数组内容组bitmap
    for (int i = 0; i < array.length; i++) {
      bitSet.set(array[i], true);
    }
    System.out.println(bitSet.length());
    System.out.println(bitSet.size());
    System.out.println(bitSet.get(3));
  }

}
