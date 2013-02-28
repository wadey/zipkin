package com.twitter.zipkin.gen

import org.apache.thrift.TEnum

object AnnotationType {
  case object Bool extends AnnotationType(0, "Bool")
  case object Bytes extends AnnotationType(1, "Bytes")
  case object I16 extends AnnotationType(2, "I16")
  case object I32 extends AnnotationType(3, "I32")
  case object I64 extends AnnotationType(4, "I64")
  case object Double extends AnnotationType(5, "Double")
  case object String extends AnnotationType(6, "String")

  def apply(value: Int): AnnotationType = {
    value match {
      case 0 => Bool
      case 1 => Bytes
      case 2 => I16
      case 3 => I32
      case 4 => I64
      case 5 => Double
      case 6 => String
      case _ => throw new NoSuchElementException(value.toString)
    }
  }

  def get(value: Int): Option[AnnotationType] = {
    value match {
      case 0 => scala.Some(Bool)
      case 1 => scala.Some(Bytes)
      case 2 => scala.Some(I16)
      case 3 => scala.Some(I32)
      case 4 => scala.Some(I64)
      case 5 => scala.Some(Double)
      case 6 => scala.Some(String)
      case _ => scala.None
    }
  }

  def valueOf(name: String): Option[AnnotationType] = {
    name.toLowerCase match {
      case "bool" => scala.Some(AnnotationType.Bool)
      case "bytes" => scala.Some(AnnotationType.Bytes)
      case "i16" => scala.Some(AnnotationType.I16)
      case "i32" => scala.Some(AnnotationType.I32)
      case "i64" => scala.Some(AnnotationType.I64)
      case "double" => scala.Some(AnnotationType.Double)
      case "string" => scala.Some(AnnotationType.String)
      case _ => scala.None
    }
  }
}

abstract class AnnotationType(val value: Int, val name: String) extends TEnum {
  def getValue = value
}
