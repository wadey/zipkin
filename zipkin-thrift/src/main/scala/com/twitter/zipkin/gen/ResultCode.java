/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package com.twitter.zipkin.gen;


import java.util.Map;
import java.util.HashMap;
import org.apache.thrift.TEnum;

public enum ResultCode implements TEnum {
  OK(0),
  TRY_LATER(1);

  private final int value;

  private ResultCode(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  public static ResultCode findByValue(int value) { 
    switch (value) {
      case 0:
        return OK;
      case 1:
        return TRY_LATER;
      default:
        return null;
    }
  }
}
