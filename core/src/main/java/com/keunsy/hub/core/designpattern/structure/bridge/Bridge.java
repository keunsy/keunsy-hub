package com.keunsy.hub.core.designpattern.structure.bridge;

/**
 * Created on 2018/3/8.
 * 桥接模式
 */
public class Bridge {

  public static void main(String[] args) {
    AnimalsBridge bridge = new AnimalsBridge(new Dog());
    bridge.method();
    AnimalsBridge bridge2 = new AnimalsBridge(new Cat());
    bridge2.method();
  }
}

//接口
interface Animals {
  public void method();
}

//实现1
class Cat implements Animals {
  @Override
  public void method() {
    System.out.println("this is cat!");
  }
}

//实现2
class Dog implements Animals {
  @Override
  public void method() {
    System.out.println("this is dog!");
  }
}

//将Animals接口下的不同实现，
//通过桥接模式使它们在抽象层建立一个关联关系。
//实现之间独立变化，减少耦合
class AnimalsBridge {
  private Animals animals;

  public AnimalsBridge(Animals animals) {
    this.animals = animals;
  }

  public void method() {
    animals.method();
  }
}
