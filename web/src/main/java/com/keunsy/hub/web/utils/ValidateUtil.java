/**
 * 文件名：ValidateUtil.java
 *
 * 版本信息： 日期：2015-4-7 Copyright 足下 Corporation 2015 版权所有
 */
package com.keunsy.hub.web.utils;

import org.apache.commons.collections4.CollectionUtils;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;

/**
 * 验证封装
 */
public class ValidateUtil {

  // 初始化验证器
  private static final String NOT_NULL_MSG = "不能为空";
  private static final String CANNOT_MSG = "不能";

  private ValidateUtil() {
  }

  public static Validator getValidator() {

    return Nested.VALIDATOR;
  }


  /**
   * validateProperty(校验某对象中的某个字段值)
   *
   * @param obj          验证的对象
   * @param propertyName 属性名称
   */
  public static void validateProperty(Object obj, String propertyName) {

    validateProperty(obj, propertyName, null);
  }


  /**
   * validateProperty(校验某对象中的某个字段值)
   *
   * @param obj          验证的对象
   * @param propertyName 属性名称
   * @param group        组类
   */
  public static void validateProperty(Object obj, String propertyName, Class<?>... group) {

    // 获取不合法 集合
    Set<ConstraintViolation<Object>> set;
    if (group != null && group.length > 0) {
      set = getValidator().validateProperty(obj, propertyName, group);
    } else {
      set = getValidator().validateProperty(obj, propertyName);
    }
    throwErrorMessage(set);
  }


  /**
   * validate(校验某对象所有需要校验的字段值)
   *
   * @param obj 验证的对象
   */
  public static void validate(Object obj) {
    validate(obj, null);
  }


  /**
   * validate(校验某对象所有需要校验的字段值)
   *
   * @param obj   验证的对象
   * @param group 组类
   */
  public static void validate(Object obj, Class<?>... group) {

    // 获取不合法 集合
    Set<ConstraintViolation<Object>> set;
    if (group != null && group.length > 0) {
      set = getValidator().validate(obj, group);
    } else {
      set = getValidator().validate(obj);
    }

    throwErrorMessage(set);
  }

  /**
   * validateValue(验证某个类某个属性给定的值是否符合)
   *
   * @param clz          验证类
   * @param propertyName 属性名称
   * @param value        属性值
   */
  public static void validateValue(Class clz, String propertyName, Object value) {

    validateValue(clz, propertyName, value, null);
  }

  /**
   * validateValue(验证某个类某个属性给定的值是否符合)
   *
   * @param clz          验证类
   * @param propertyName 属性名称
   * @param value        属性值
   * @param group        组类
   */
  public static void validateValue(Class clz, String propertyName, Object value, Class<?>... group) {

    // 获取不合法 集合
    Set<ConstraintViolation<Object>> set;
    if (group != null && group.length > 0) {
      set = getValidator().validateValue(clz, propertyName, value, group);
    } else {
      set = getValidator().validateValue(clz, propertyName, value);
    }
    throwErrorMessage(set);
  }


  /**
   * throwErrorMessage(抛出错误信息)
   *
   * @param set 验证结果集合
   */
  private static void throwErrorMessage(Set<ConstraintViolation<Object>> set) {
    if (CollectionUtils.isEmpty(set)) {
      return;
    }
    StringBuilder sb = new StringBuilder();
    for (ConstraintViolation<Object> violation : set) {
      sb.append(violation.getMessage());
      if (violation.getConstraintDescriptor().getAnnotation() instanceof NotNull && !violation.getMessage().contains(CANNOT_MSG)) {
        sb.append(NOT_NULL_MSG);
      }
      sb.append(";");
    }
    throw new RuntimeException(sb.toString());
  }

  /**
   * createErrorMessage(获取错误提示信息)
   *
   * @param set 验证结果集合
   */
  private static String createErrorMessage(Set<ConstraintViolation<Object>> set) {
    StringBuilder sb = new StringBuilder();
    for (ConstraintViolation<Object> violation : set) {
      sb.append(violation.getMessage()).append(";");
      // 默认存在于/org/hibernate/VALIDATOR/ValidationMessages.properties下或对应的语言包下
    }
    return sb.toString();
  }

  private static class Nested {
    private static final Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();
  }
}
