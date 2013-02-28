package com.twitter.zipkin.gen

import org.apache.thrift.TEnum

object Order {
  case object TimestampDesc extends Order(0, "TimestampDesc")
  case object TimestampAsc extends Order(1, "TimestampAsc")
  case object DurationAsc extends Order(2, "DurationAsc")
  case object DurationDesc extends Order(3, "DurationDesc")
  case object None extends Order(4, "None")

  def apply(value: Int): Order = {
    value match {
      case 0 => TimestampDesc
      case 1 => TimestampAsc
      case 2 => DurationAsc
      case 3 => DurationDesc
      case 4 => None
      case _ => throw new NoSuchElementException(value.toString)
    }
  }

  def get(value: Int): Option[Order] = {
    value match {
      case 0 => scala.Some(TimestampDesc)
      case 1 => scala.Some(TimestampAsc)
      case 2 => scala.Some(DurationAsc)
      case 3 => scala.Some(DurationDesc)
      case 4 => scala.Some(None)
      case _ => scala.None
    }
  }

  def valueOf(name: String): Option[Order] = {
    name.toLowerCase match {
      case "timestampdesc" => scala.Some(Order.TimestampDesc)
      case "timestampasc" => scala.Some(Order.TimestampAsc)
      case "durationasc" => scala.Some(Order.DurationAsc)
      case "durationdesc" => scala.Some(Order.DurationDesc)
      case "none" => scala.Some(Order.None)
      case _ => scala.None
    }
  }
}

abstract class Order(val value: Int, val name: String) extends TEnum {
  def getValue = value
}
