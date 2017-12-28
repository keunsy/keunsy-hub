package com.keunsy.hub.web.enums;


public enum TempEnum {

  ONE(1, "ONE"),
  TWO(2, "TWO"),
  THREE(3, "THREE");

  private int value;
  private String name;

  TempEnum(int value, String name) {
    this.value = value;
    this.name = name;
  }

  public static TempEnum getFromValue(Integer value) {

    if (value != null) {
      for (TempEnum e : TempEnum.values()) {
        if (e.value == value)
          return e;
      }
    }
    return null;
  }


  public String getName() {
    return name;
  }

  public int getValue() {
    return value;
  }
}
