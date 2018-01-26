package com.keunsy.hub.core.designpattern.create.factorymethod;


/**
 * 定义一个创建对象的接口，让其子类自己决定实例化哪一个工厂类，工厂模式使其创建过程延迟到子类进行。
 */
public class FactoryMethod {


  public static void main(String[] args) {
    AnimalsFactory animalsFactory = new AnimalsFactory();
    //通过工厂创建一个cat对象
    Animals cat = animalsFactory.getAnimals("cat");
    //通过工厂创建一个dog对象
    Animals dog = animalsFactory.getAnimals("dog");
    cat.name();
    dog.name();
  }
}

interface Animals { //动物
  void name();
}

class Cat implements Animals { //猫
  @Override
  public void name() {
    System.out.println("this is a cat");
  }
}

class Dog implements Animals { //狗
  @Override
  public void name() {
    System.out.println("this is a dog");
  }
}

class AnimalsFactory { //动物工厂
  public Animals getAnimals(String name) {
    if (name.equalsIgnoreCase("cat"))
      return new Cat();
    else if (name.equalsIgnoreCase("dog"))
      return new Dog();
    else
      return null;
  }
}