package com.twitter.zipkin.gen

import org.apache.thrift.TEnum

object ResultCode {
  case object Ok extends ResultCode(0, "Ok")
  case object TryLater extends ResultCode(1, "TryLater")

  def apply(value: Int): ResultCode = {
    value match {
      case 0 => Ok
      case 1 => TryLater
      case _ => throw new NoSuchElementException(value.toString)
    }
  }

  def get(value: Int): Option[ResultCode] = {
    value match {
      case 0 => scala.Some(Ok)
      case 1 => scala.Some(TryLater)
      case _ => scala.None
    }
  }

  def valueOf(name: String): Option[ResultCode] = {
    name.toLowerCase match {
      case "ok" => scala.Some(ResultCode.Ok)
      case "trylater" => scala.Some(ResultCode.TryLater)
      case _ => scala.None
    }
  }
}

abstract class ResultCode(val value: Int, val name: String) extends TEnum {
  def getValue = value
}
