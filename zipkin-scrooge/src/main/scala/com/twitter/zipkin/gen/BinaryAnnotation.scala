package com.twitter.zipkin.gen

import com.twitter.scrooge.{ThriftStruct, ThriftStructCodec}
import org.apache.thrift.protocol._
import java.nio.ByteBuffer
import com.twitter.finagle.SourcedException
import scala.collection.mutable
import scala.collection.{Map, Set}

object BinaryAnnotation extends ThriftStructCodec[BinaryAnnotation] {
  val Struct = new TStruct("BinaryAnnotation")
  val KeyField = new TField("key", TType.STRING, 1)
  val ValueField = new TField("value", TType.STRING, 2)
  val AnnotationTypeField = new TField("annotationType", TType.I32, 3)
  val HostField = new TField("host", TType.STRUCT, 4)

  def encode(_item: BinaryAnnotation, _oproto: TProtocol) { _item.write(_oproto) }
  def decode(_iprot: TProtocol) = Immutable.decode(_iprot)

  def apply(_iprot: TProtocol): BinaryAnnotation = decode(_iprot)

  def apply(
    `key`: String,
    `value`: ByteBuffer,
    `annotationType`: AnnotationType,
    `host`: Option[Endpoint] = None
  ): BinaryAnnotation = new Immutable(
    `key`,
    `value`,
    `annotationType`,
    `host`
  )

  def unapply(_item: BinaryAnnotation): Option[Product4[String, ByteBuffer, AnnotationType, Option[Endpoint]]] = Some(_item)

  object Immutable extends ThriftStructCodec[BinaryAnnotation] {
    def encode(_item: BinaryAnnotation, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = {
      var `key`: String = null
      var _got_key = false
      var `value`: ByteBuffer = null
      var _got_value = false
      var `annotationType`: AnnotationType = null
      var _got_annotationType = false
      var `host`: Endpoint = null
      var _got_host = false
      var _done = false
      _iprot.readStructBegin()
      while (!_done) {
        val _field = _iprot.readFieldBegin()
        if (_field.`type` == TType.STOP) {
          _done = true
        } else {
          _field.id match {
            case 1 => { /* key */
              _field.`type` match {
                case TType.STRING => {
                  `key` = {
                    _iprot.readString()
                  }
                  _got_key = true
                }
                case _ => TProtocolUtil.skip(_iprot, _field.`type`)
              }
            }
            case 2 => { /* value */
              _field.`type` match {
                case TType.STRING => {
                  `value` = {
                    _iprot.readBinary()
                  }
                  _got_value = true
                }
                case _ => TProtocolUtil.skip(_iprot, _field.`type`)
              }
            }
            case 3 => { /* annotationType */
              _field.`type` match {
                case TType.I32 => {
                  `annotationType` = {
                    AnnotationType(_iprot.readI32())
                  }
                  _got_annotationType = true
                }
                case _ => TProtocolUtil.skip(_iprot, _field.`type`)
              }
            }
            case 4 => { /* host */
              _field.`type` match {
                case TType.STRUCT => {
                  `host` = {
                    Endpoint.decode(_iprot)
                  }
                  _got_host = true
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
        `key`,
        `value`,
        `annotationType`,
        if (_got_host) Some(`host`) else None
      )
    }
  }

  /**
   * The default read-only implementation of BinaryAnnotation.  You typically should not need to
   * directly reference this class; instead, use the BinaryAnnotation.apply method to construct
   * new instances.
   */
  class Immutable(
    val `key`: String,
    val `value`: ByteBuffer,
    val `annotationType`: AnnotationType,
    val `host`: Option[Endpoint] = None
  ) extends BinaryAnnotation

  /**
   * This Proxy trait allows you to extend the BinaryAnnotation trait with additional state or
   * behavior and implement the read-only methods from BinaryAnnotation using an underlying
   * instance.
   */
  trait Proxy extends BinaryAnnotation {
    protected def _underlyingBinaryAnnotation: BinaryAnnotation
    def `key`: String = _underlyingBinaryAnnotation.`key`
    def `value`: ByteBuffer = _underlyingBinaryAnnotation.`value`
    def `annotationType`: AnnotationType = _underlyingBinaryAnnotation.`annotationType`
    def `host`: Option[Endpoint] = _underlyingBinaryAnnotation.`host`
  }
}

trait BinaryAnnotation extends ThriftStruct
  with Product4[String, ByteBuffer, AnnotationType, Option[Endpoint]]
  with java.io.Serializable
{
  import BinaryAnnotation._

  def `key`: String
  def `value`: ByteBuffer
  def `annotationType`: AnnotationType
  def `host`: Option[Endpoint]

  def _1 = `key`
  def _2 = `value`
  def _3 = `annotationType`
  def _4 = `host`

  override def write(_oprot: TProtocol) {
    validate()
    _oprot.writeStructBegin(Struct)
    if (true) {
      val `key_item` = `key`
      _oprot.writeFieldBegin(KeyField)
      _oprot.writeString(`key_item`)
      _oprot.writeFieldEnd()
    }
    if (true) {
      val `value_item` = `value`
      _oprot.writeFieldBegin(ValueField)
      _oprot.writeBinary(`value_item`)
      _oprot.writeFieldEnd()
    }
    if (true) {
      val `annotationType_item` = `annotationType`
      _oprot.writeFieldBegin(AnnotationTypeField)
      _oprot.writeI32(`annotationType_item`.value)
      _oprot.writeFieldEnd()
    }
    if (`host`.isDefined) {
      val `host_item` = `host`.get
      _oprot.writeFieldBegin(HostField)
      `host_item`.write(_oprot)
      _oprot.writeFieldEnd()
    }
    _oprot.writeFieldStop()
    _oprot.writeStructEnd()
  }

  def copy(
    `key`: String = this.`key`,
    `value`: ByteBuffer = this.`value`,
    `annotationType`: AnnotationType = this.`annotationType`,
    `host`: Option[Endpoint] = this.`host`
  ): BinaryAnnotation = new Immutable(
    `key`,
    `value`,
    `annotationType`,
    `host`
  )

  /**
   * Checks that all required fields are non-null.
   */
  def validate() {
  }

  def canEqual(other: Any) = other.isInstanceOf[BinaryAnnotation]

  override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)

  override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)

  override def toString: String = runtime.ScalaRunTime._toString(this)

  override def productArity = 4

  override def productElement(n: Int): Any = n match {
    case 0 => `key`
    case 1 => `value`
    case 2 => `annotationType`
    case 3 => `host`
    case _ => throw new IndexOutOfBoundsException(n.toString)
  }

  override def productPrefix = "BinaryAnnotation"
}