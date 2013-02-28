package com.twitter.zipkin.gen

import org.apache.thrift.TEnum

object Adjust {
  case object Nothing extends Adjust(0, "Nothing")
  case object TimeSkew extends Adjust(1, "TimeSkew")

  def apply(value: Int): Adjust = {
    value match {
      case 0 => Nothing
      case 1 => TimeSkew
      case _ => throw new NoSuchElementException(value.toString)
    }
  }

  def get(value: Int): Option[Adjust] = {
    value match {
      case 0 => scala.Some(Nothing)
      case 1 => scala.Some(TimeSkew)
      case _ => scala.None
    }
  }

  def valueOf(name: String): Option[Adjust] = {
    name.toLowerCase match {
      case "nothing" => scala.Some(Adjust.Nothing)
      case "timeskew" => scala.Some(Adjust.TimeSkew)
      case _ => scala.None
    }
  }
}

abstract class Adjust(val value: Int, val name: String) extends TEnum {
  def getValue = value
}
