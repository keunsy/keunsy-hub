package com.keunsy.hub.core.designpattern.structure.proxy;

public class Proxy {

  public static void main(String[] args) {
    Animals dog = new DogProxy(new Dog());
    dog.run();
  }
}

interface Animals {
  public void run();
}

class Dog implements Animals {
  @Override
  public void run() {
    System.out.println("run!");
  }
}

//通过代理类，在被代理类的run()方法执行前后添加额外的功能
class DogProxy implements Animals {
  private Animals animals;

  public DogProxy(Animals animals) {
    super();
    this.animals = animals;
  }

  @Override
  public void run() {
    before();
    animals.run();
    atfer();
  }

  private void atfer() {
    System.out.println("after run!");
  }

  private void before() {
    System.out.println("before run!");
  }
} 