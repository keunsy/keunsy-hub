package com.keunsy.hub.core.designpattern.create.abstractfactory;

/**
 * Created on 2018/1/25.
 * 抽象工厂模式：提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类。
 * 主要角色：
 * 1.抽象工厂类
 * 2.具体工厂类
 * 3.抽象产品类
 * 4.具体产品类
 */
public class AbstractFactory {

  //工厂生成器：生产具体的工厂
  public AbstractFactoryAll getFactory(String factoryName) {
    if (factoryName.equalsIgnoreCase("animals"))
      return new AnimalsFactory();
    else if (factoryName.equalsIgnoreCase("others"))
      return new OthersFactory();
    else
      return null;
  }

  public static void main(String[] args) {

    //生产动物工厂
    AbstractFactoryAll animalsFactory = new AbstractFactory().getFactory("animals");
    //通过动物工厂创建一个cat对象
    Animals cat = animalsFactory.getAnimals("cat");
    cat.name();
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

  class AnimalsFactory extends AbstractFactoryAll { //动物工厂
    public Animals getAnimals(String name) {
      if (name.equalsIgnoreCase("cat"))
        return new Cat();
      else
        return null;
    }

    public Object getObject() {
      return null;
    }
  }

  class OthersFactory extends AbstractFactoryAll { //其他工厂
    public Object getObject() {
      return null;
    }

    public Animals getAnimals(String name) {
      return null;
    }
  }

  abstract class AbstractFactoryAll { //抽象工厂

    abstract public Animals getAnimals(String name);

    abstract public Object getObject();
  }

}
