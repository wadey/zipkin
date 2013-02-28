package com.twitter.zipkin.gen

import com.twitter.scrooge.{ThriftStruct, ThriftStructCodec}
import org.apache.thrift.protocol._
import java.nio.ByteBuffer
import com.twitter.finagle.SourcedException
import scala.collection.mutable
import scala.collection.{Map, Set}

object Annotation extends ThriftStructCodec[Annotation] {
  val Struct = new TStruct("Annotation")
  val TimestampField = new TField("timestamp", TType.I64, 1)
  val ValueField = new TField("value", TType.STRING, 2)
  val HostField = new TField("host", TType.STRUCT, 3)
  val DurationField = new TField("duration", TType.I32, 4)

  def encode(_item: Annotation, _oproto: TProtocol) { _item.write(_oproto) }
  def decode(_iprot: TProtocol) = Immutable.decode(_iprot)

  def apply(_iprot: TProtocol): Annotation = decode(_iprot)

  def apply(
    `timestamp`: Long,
    `value`: String,
    `host`: Option[Endpoint] = None,
    `duration`: Option[Int] = None
  ): Annotation = new Immutable(
    `timestamp`,
    `value`,
    `host`,
    `duration`
  )

  def unapply(_item: Annotation): Option[Product4[Long, String, Option[Endpoint], Option[Int]]] = Some(_item)

  object Immutable extends ThriftStructCodec[Annotation] {
    def encode(_item: Annotation, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = {
      var `timestamp`: Long = 0L
      var _got_timestamp = false
      var `value`: String = null
      var _got_value = false
      var `host`: Endpoint = null
      var _got_host = false
      var `duration`: Int = 0
      var _got_duration = false
      var _done = false
      _iprot.readStructBegin()
      while (!_done) {
        val _field = _iprot.readFieldBegin()
        if (_field.`type` == TType.STOP) {
          _done = true
        } else {
          _field.id match {
            case 1 => { /* timestamp */
              _field.`type` match {
                case TType.I64 => {
                  `timestamp` = {
                    _iprot.readI64()
                  }
                  _got_timestamp = true
                }
                case _ => TProtocolUtil.skip(_iprot, _field.`type`)
              }
            }
            case 2 => { /* value */
              _field.`type` match {
                case TType.STRING => {
                  `value` = {
                    _iprot.readString()
                  }
                  _got_value = true
                }
                case _ => TProtocolUtil.skip(_iprot, _field.`type`)
              }
            }
            case 3 => { /* host */
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
            case 4 => { /* duration */
              _field.`type` match {
                case TType.I32 => {
                  `duration` = {
                    _iprot.readI32()
                  }
                  _got_duration = true
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
        `timestamp`,
        `value`,
        if (_got_host) Some(`host`) else None,
        if (_got_duration) Some(`duration`) else None
      )
    }
  }

  /**
   * The default read-only implementation of Annotation.  You typically should not need to
   * directly reference this class; instead, use the Annotation.apply method to construct
   * new instances.
   */
  class Immutable(
    val `timestamp`: Long,
    val `value`: String,
    val `host`: Option[Endpoint] = None,
    val `duration`: Option[Int] = None
  ) extends Annotation

  /**
   * This Proxy trait allows you to extend the Annotation trait with additional state or
   * behavior and implement the read-only methods from Annotation using an underlying
   * instance.
   */
  trait Proxy extends Annotation {
    protected def _underlyingAnnotation: Annotation
    def `timestamp`: Long = _underlyingAnnotation.`timestamp`
    def `value`: String = _underlyingAnnotation.`value`
    def `host`: Option[Endpoint] = _underlyingAnnotation.`host`
    def `duration`: Option[Int] = _underlyingAnnotation.`duration`
  }
}

trait Annotation extends ThriftStruct
  with Product4[Long, String, Option[Endpoint], Option[Int]]
  with java.io.Serializable
{
  import Annotation._

  def `timestamp`: Long
  def `value`: String
  def `host`: Option[Endpoint]
  def `duration`: Option[Int]

  def _1 = `timestamp`
  def _2 = `value`
  def _3 = `host`
  def _4 = `duration`

  override def write(_oprot: TProtocol) {
    validate()
    _oprot.writeStructBegin(Struct)
    if (true) {
      val `timestamp_item` = `timestamp`
      _oprot.writeFieldBegin(TimestampField)
      _oprot.writeI64(`timestamp_item`)
      _oprot.writeFieldEnd()
    }
    if (true) {
      val `value_item` = `value`
      _oprot.writeFieldBegin(ValueField)
      _oprot.writeString(`value_item`)
      _oprot.writeFieldEnd()
    }
    if (`host`.isDefined) {
      val `host_item` = `host`.get
      _oprot.writeFieldBegin(HostField)
      `host_item`.write(_oprot)
      _oprot.writeFieldEnd()
    }
    if (`duration`.isDefined) {
      val `duration_item` = `duration`.get
      _oprot.writeFieldBegin(DurationField)
      _oprot.writeI32(`duration_item`)
      _oprot.writeFieldEnd()
    }
    _oprot.writeFieldStop()
    _oprot.writeStructEnd()
  }

  def copy(
    `timestamp`: Long = this.`timestamp`,
    `value`: String = this.`value`,
    `host`: Option[Endpoint] = this.`host`,
    `duration`: Option[Int] = this.`duration`
  ): Annotation = new Immutable(
    `timestamp`,
    `value`,
    `host`,
    `duration`
  )

  /**
   * Checks that all required fields are non-null.
   */
  def validate() {
  }

  def canEqual(other: Any) = other.isInstanceOf[Annotation]

  override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)

  override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)

  override def toString: String = runtime.ScalaRunTime._toString(this)

  override def productArity = 4

  override def productElement(n: Int): Any = n match {
    case 0 => `timestamp`
    case 1 => `value`
    case 2 => `host`
    case 3 => `duration`
    case _ => throw new IndexOutOfBoundsException(n.toString)
  }

  override def productPrefix = "Annotation"
}