package com.twitter.zipkin.gen

import com.twitter.scrooge.{ThriftStruct, ThriftStructCodec}
import org.apache.thrift.protocol._
import java.nio.ByteBuffer
import com.twitter.finagle.SourcedException
import scala.collection.mutable
import scala.collection.{Map, Set}
import com.twitter.zipkin.{gen => _zipkinCore_}

object TimelineAnnotation extends ThriftStructCodec[TimelineAnnotation] {
  val Struct = new TStruct("TimelineAnnotation")
  val TimestampField = new TField("timestamp", TType.I64, 1)
  val ValueField = new TField("value", TType.STRING, 2)
  val HostField = new TField("host", TType.STRUCT, 3)
  val SpanIdField = new TField("spanId", TType.I64, 4)
  val ParentIdField = new TField("parentId", TType.I64, 5)
  val ServiceNameField = new TField("serviceName", TType.STRING, 6)
  val SpanNameField = new TField("spanName", TType.STRING, 7)

  def encode(_item: TimelineAnnotation, _oproto: TProtocol) { _item.write(_oproto) }
  def decode(_iprot: TProtocol) = Immutable.decode(_iprot)

  def apply(_iprot: TProtocol): TimelineAnnotation = decode(_iprot)

  def apply(
    `timestamp`: Long,
    `value`: String,
    `host`: _zipkinCore_.Endpoint,
    `spanId`: Long,
    `parentId`: Option[Long] = None,
    `serviceName`: String,
    `spanName`: String
  ): TimelineAnnotation = new Immutable(
    `timestamp`,
    `value`,
    `host`,
    `spanId`,
    `parentId`,
    `serviceName`,
    `spanName`
  )

  def unapply(_item: TimelineAnnotation): Option[Product7[Long, String, _zipkinCore_.Endpoint, Long, Option[Long], String, String]] = Some(_item)

  object Immutable extends ThriftStructCodec[TimelineAnnotation] {
    def encode(_item: TimelineAnnotation, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = {
      var `timestamp`: Long = 0L
      var _got_timestamp = false
      var `value`: String = null
      var _got_value = false
      var `host`: _zipkinCore_.Endpoint = null
      var _got_host = false
      var `spanId`: Long = 0L
      var _got_spanId = false
      var `parentId`: Long = 0L
      var _got_parentId = false
      var `serviceName`: String = null
      var _got_serviceName = false
      var `spanName`: String = null
      var _got_spanName = false
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
                    _zipkinCore_.Endpoint.decode(_iprot)
                  }
                  _got_host = true
                }
                case _ => TProtocolUtil.skip(_iprot, _field.`type`)
              }
            }
            case 4 => { /* spanId */
              _field.`type` match {
                case TType.I64 => {
                  `spanId` = {
                    _iprot.readI64()
                  }
                  _got_spanId = true
                }
                case _ => TProtocolUtil.skip(_iprot, _field.`type`)
              }
            }
            case 5 => { /* parentId */
              _field.`type` match {
                case TType.I64 => {
                  `parentId` = {
                    _iprot.readI64()
                  }
                  _got_parentId = true
                }
                case _ => TProtocolUtil.skip(_iprot, _field.`type`)
              }
            }
            case 6 => { /* serviceName */
              _field.`type` match {
                case TType.STRING => {
                  `serviceName` = {
                    _iprot.readString()
                  }
                  _got_serviceName = true
                }
                case _ => TProtocolUtil.skip(_iprot, _field.`type`)
              }
            }
            case 7 => { /* spanName */
              _field.`type` match {
                case TType.STRING => {
                  `spanName` = {
                    _iprot.readString()
                  }
                  _got_spanName = true
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
        `host`,
        `spanId`,
        if (_got_parentId) Some(`parentId`) else None,
        `serviceName`,
        `spanName`
      )
    }
  }

  /**
   * The default read-only implementation of TimelineAnnotation.  You typically should not need to
   * directly reference this class; instead, use the TimelineAnnotation.apply method to construct
   * new instances.
   */
  class Immutable(
    val `timestamp`: Long,
    val `value`: String,
    val `host`: _zipkinCore_.Endpoint,
    val `spanId`: Long,
    val `parentId`: Option[Long] = None,
    val `serviceName`: String,
    val `spanName`: String
  ) extends TimelineAnnotation

  /**
   * This Proxy trait allows you to extend the TimelineAnnotation trait with additional state or
   * behavior and implement the read-only methods from TimelineAnnotation using an underlying
   * instance.
   */
  trait Proxy extends TimelineAnnotation {
    protected def _underlyingTimelineAnnotation: TimelineAnnotation
    def `timestamp`: Long = _underlyingTimelineAnnotation.`timestamp`
    def `value`: String = _underlyingTimelineAnnotation.`value`
    def `host`: _zipkinCore_.Endpoint = _underlyingTimelineAnnotation.`host`
    def `spanId`: Long = _underlyingTimelineAnnotation.`spanId`
    def `parentId`: Option[Long] = _underlyingTimelineAnnotation.`parentId`
    def `serviceName`: String = _underlyingTimelineAnnotation.`serviceName`
    def `spanName`: String = _underlyingTimelineAnnotation.`spanName`
  }
}

trait TimelineAnnotation extends ThriftStruct
  with Product7[Long, String, _zipkinCore_.Endpoint, Long, Option[Long], String, String]
  with java.io.Serializable
{
  import TimelineAnnotation._

  def `timestamp`: Long
  def `value`: String
  def `host`: _zipkinCore_.Endpoint
  def `spanId`: Long
  def `parentId`: Option[Long]
  def `serviceName`: String
  def `spanName`: String

  def _1 = `timestamp`
  def _2 = `value`
  def _3 = `host`
  def _4 = `spanId`
  def _5 = `parentId`
  def _6 = `serviceName`
  def _7 = `spanName`

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
    if (true) {
      val `host_item` = `host`
      _oprot.writeFieldBegin(HostField)
      `host_item`.write(_oprot)
      _oprot.writeFieldEnd()
    }
    if (true) {
      val `spanId_item` = `spanId`
      _oprot.writeFieldBegin(SpanIdField)
      _oprot.writeI64(`spanId_item`)
      _oprot.writeFieldEnd()
    }
    if (`parentId`.isDefined) {
      val `parentId_item` = `parentId`.get
      _oprot.writeFieldBegin(ParentIdField)
      _oprot.writeI64(`parentId_item`)
      _oprot.writeFieldEnd()
    }
    if (true) {
      val `serviceName_item` = `serviceName`
      _oprot.writeFieldBegin(ServiceNameField)
      _oprot.writeString(`serviceName_item`)
      _oprot.writeFieldEnd()
    }
    if (true) {
      val `spanName_item` = `spanName`
      _oprot.writeFieldBegin(SpanNameField)
      _oprot.writeString(`spanName_item`)
      _oprot.writeFieldEnd()
    }
    _oprot.writeFieldStop()
    _oprot.writeStructEnd()
  }

  def copy(
    `timestamp`: Long = this.`timestamp`,
    `value`: String = this.`value`,
    `host`: _zipkinCore_.Endpoint = this.`host`,
    `spanId`: Long = this.`spanId`,
    `parentId`: Option[Long] = this.`parentId`,
    `serviceName`: String = this.`serviceName`,
    `spanName`: String = this.`spanName`
  ): TimelineAnnotation = new Immutable(
    `timestamp`,
    `value`,
    `host`,
    `spanId`,
    `parentId`,
    `serviceName`,
    `spanName`
  )

  /**
   * Checks that all required fields are non-null.
   */
  def validate() {
  }

  def canEqual(other: Any) = other.isInstanceOf[TimelineAnnotation]

  override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)

  override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)

  override def toString: String = runtime.ScalaRunTime._toString(this)

  override def productArity = 7

  override def productElement(n: Int): Any = n match {
    case 0 => `timestamp`
    case 1 => `value`
    case 2 => `host`
    case 3 => `spanId`
    case 4 => `parentId`
    case 5 => `serviceName`
    case 6 => `spanName`
    case _ => throw new IndexOutOfBoundsException(n.toString)
  }

  override def productPrefix = "TimelineAnnotation"
}