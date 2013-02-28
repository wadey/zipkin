package com.twitter.zipkin.gen

import com.twitter.scrooge.{ThriftStruct, ThriftStructCodec}
import org.apache.thrift.protocol._
import java.nio.ByteBuffer
import com.twitter.finagle.SourcedException
import scala.collection.mutable
import scala.collection.{Map, Set}

object LogEntry extends ThriftStructCodec[LogEntry] {
  val Struct = new TStruct("LogEntry")
  val CategoryField = new TField("category", TType.STRING, 1)
  val MessageField = new TField("message", TType.STRING, 2)

  def encode(_item: LogEntry, _oproto: TProtocol) { _item.write(_oproto) }
  def decode(_iprot: TProtocol) = Immutable.decode(_iprot)

  def apply(_iprot: TProtocol): LogEntry = decode(_iprot)

  def apply(
    `category`: String,
    `message`: String
  ): LogEntry = new Immutable(
    `category`,
    `message`
  )

  def unapply(_item: LogEntry): Option[Product2[String, String]] = Some(_item)

  object Immutable extends ThriftStructCodec[LogEntry] {
    def encode(_item: LogEntry, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = {
      var `category`: String = null
      var _got_category = false
      var `message`: String = null
      var _got_message = false
      var _done = false
      _iprot.readStructBegin()
      while (!_done) {
        val _field = _iprot.readFieldBegin()
        if (_field.`type` == TType.STOP) {
          _done = true
        } else {
          _field.id match {
            case 1 => { /* category */
              _field.`type` match {
                case TType.STRING => {
                  `category` = {
                    _iprot.readString()
                  }
                  _got_category = true
                }
                case _ => TProtocolUtil.skip(_iprot, _field.`type`)
              }
            }
            case 2 => { /* message */
              _field.`type` match {
                case TType.STRING => {
                  `message` = {
                    _iprot.readString()
                  }
                  _got_message = true
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
        `category`,
        `message`
      )
    }
  }

  /**
   * The default read-only implementation of LogEntry.  You typically should not need to
   * directly reference this class; instead, use the LogEntry.apply method to construct
   * new instances.
   */
  class Immutable(
    val `category`: String,
    val `message`: String
  ) extends LogEntry

  /**
   * This Proxy trait allows you to extend the LogEntry trait with additional state or
   * behavior and implement the read-only methods from LogEntry using an underlying
   * instance.
   */
  trait Proxy extends LogEntry {
    protected def _underlyingLogEntry: LogEntry
    def `category`: String = _underlyingLogEntry.`category`
    def `message`: String = _underlyingLogEntry.`message`
  }
}

trait LogEntry extends ThriftStruct
  with Product2[String, String]
  with java.io.Serializable
{
  import LogEntry._

  def `category`: String
  def `message`: String

  def _1 = `category`
  def _2 = `message`

  override def write(_oprot: TProtocol) {
    validate()
    _oprot.writeStructBegin(Struct)
    if (true) {
      val `category_item` = `category`
      _oprot.writeFieldBegin(CategoryField)
      _oprot.writeString(`category_item`)
      _oprot.writeFieldEnd()
    }
    if (true) {
      val `message_item` = `message`
      _oprot.writeFieldBegin(MessageField)
      _oprot.writeString(`message_item`)
      _oprot.writeFieldEnd()
    }
    _oprot.writeFieldStop()
    _oprot.writeStructEnd()
  }

  def copy(
    `category`: String = this.`category`,
    `message`: String = this.`message`
  ): LogEntry = new Immutable(
    `category`,
    `message`
  )

  /**
   * Checks that all required fields are non-null.
   */
  def validate() {
  }

  def canEqual(other: Any) = other.isInstanceOf[LogEntry]

  override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)

  override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)

  override def toString: String = runtime.ScalaRunTime._toString(this)

  override def productArity = 2

  override def productElement(n: Int): Any = n match {
    case 0 => `category`
    case 1 => `message`
    case _ => throw new IndexOutOfBoundsException(n.toString)
  }

  override def productPrefix = "LogEntry"
}