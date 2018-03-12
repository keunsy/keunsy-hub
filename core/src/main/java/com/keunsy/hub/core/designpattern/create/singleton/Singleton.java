package com.keunsy.hub.core.designpattern.create.singleton;

/**
 * Created on 2018/3/8.
 * 内部静态类实现单例
 * 延迟加载，线程安全
 */
public class Singleton {


  private static class SingletonInner {
    private static final Singleton instance = new Singleton();
  }

  public static Singleton getInstance() {
    return SingletonInner.instance;
  }
}

/**
 * 枚举方式
 * 延迟加载，线程安全,防止反序列化重新创建对象
 */
enum SingletonEnum {

  instance;

  public void whateverMethod() {
  }
}

/**
 * 双重检查锁定方式
 * 线程安全
 */
class SingletonDoubleCheck {

  private volatile static SingletonDoubleCheck instance;

  private SingletonDoubleCheck() {
  }

  public static SingletonDoubleCheck getInstance() {
    if (instance == null) {
      synchronized (SingletonDoubleCheck.class) {
        if (instance == null) {
          instance = new SingletonDoubleCheck();
        }
      }
    }
    return instance;
  }
}