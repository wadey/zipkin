package com.twitter.zipkin.gen

import com.twitter.scrooge.{ThriftStruct, ThriftStructCodec}
import org.apache.thrift.protocol._
import java.nio.ByteBuffer
import com.twitter.finagle.SourcedException
import scala.collection.mutable
import scala.collection.{Map, Set}
import com.twitter.zipkin.{gen => _scribe_}

object AdjustableRateException extends ThriftStructCodec[AdjustableRateException] {
  val Struct = new TStruct("AdjustableRateException")
  val MsgField = new TField("msg", TType.STRING, 1)

  def encode(_item: AdjustableRateException, _oproto: TProtocol) { _item.write(_oproto) }
  def decode(_iprot: TProtocol) = Immutable.decode(_iprot)

  def apply(_iprot: TProtocol): AdjustableRateException = decode(_iprot)

  def apply(
    `msg`: String
  ): AdjustableRateException = new Immutable(
    `msg`
  )

  def unapply(_item: AdjustableRateException): Option[String] = Some(_item.msg)

  object Immutable extends ThriftStructCodec[AdjustableRateException] {
    def encode(_item: AdjustableRateException, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = {
      var `msg`: String = null
      var _got_msg = false
      var _done = false
      _iprot.readStructBegin()
      while (!_done) {
        val _field = _iprot.readFieldBegin()
        if (_field.`type` == TType.STOP) {
          _done = true
        } else {
          _field.id match {
            case 1 => { /* msg */
              _field.`type` match {
                case TType.STRING => {
                  `msg` = {
                    _iprot.readString()
                  }
                  _got_msg = true
                }
                case _ => TProtocolUtil.skip(_iprot, _field.`type`)
              }
            }
            case _ => TProtocolUtil.skip(_iprot, _field.`type`)
          }
          _iprot.readFieldEnd()
        }
      }
      _iprot.readStructEnd()
      new Immutable(
        `msg`
      )
    }
  }

  /**
   * The default read-only implementation of AdjustableRateException.  You typically should not need to
   * directly reference this class; instead, use the AdjustableRateException.apply method to construct
   * new instances.
   */
  class Immutable(
    val `msg`: String
  ) extends AdjustableRateException

}

trait AdjustableRateException extends SourcedException with ThriftStruct
  with Product1[String]
  with java.io.Serializable
{
  import AdjustableRateException._

  def `msg`: String

  def _1 = `msg`

  override def write(_oprot: TProtocol) {
    validate()
    _oprot.writeStructBegin(Struct)
    if (true) {
      val `msg_item` = `msg`
      _oprot.writeFieldBegin(MsgField)
      _oprot.writeString(`msg_item`)
      _oprot.writeFieldEnd()
    }
    _oprot.writeFieldStop()
    _oprot.writeStructEnd()
  }

  def copy(
    `msg`: String = this.`msg`
  ): AdjustableRateException = new Immutable(
    `msg`
  )

  /**
   * Checks that all required fields are non-null.
   */
  def validate() {
  }

  def canEqual(other: Any) = other.isInstanceOf[AdjustableRateException]

  override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)

  override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)

  override def toString: String = runtime.ScalaRunTime._toString(this)

  override def productArity = 1

  override def productElement(n: Int): Any = n match {
    case 0 => `msg`
    case _ => throw new IndexOutOfBoundsException(n.toString)
  }

  override def productPrefix = "AdjustableRateException"
}