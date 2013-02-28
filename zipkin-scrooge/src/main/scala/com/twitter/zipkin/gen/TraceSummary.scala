package com.twitter.zipkin.gen

import com.twitter.scrooge.{ThriftStruct, ThriftStructCodec}
import org.apache.thrift.protocol._
import java.nio.ByteBuffer
import com.twitter.finagle.SourcedException
import scala.collection.mutable
import scala.collection.{Map, Set}
import com.twitter.zipkin.{gen => _zipkinCore_}

object TraceSummary extends ThriftStructCodec[TraceSummary] {
  val Struct = new TStruct("TraceSummary")
  val TraceIdField = new TField("traceId", TType.I64, 1)
  val StartTimestampField = new TField("startTimestamp", TType.I64, 2)
  val EndTimestampField = new TField("endTimestamp", TType.I64, 3)
  val DurationMicroField = new TField("durationMicro", TType.I32, 4)
  val ServiceCountsField = new TField("serviceCounts", TType.MAP, 5)
  val EndpointsField = new TField("endpoints", TType.LIST, 6)

  def encode(_item: TraceSummary, _oproto: TProtocol) { _item.write(_oproto) }
  def decode(_iprot: TProtocol) = Immutable.decode(_iprot)

  def apply(_iprot: TProtocol): TraceSummary = decode(_iprot)

  def apply(
    `traceId`: Long,
    `startTimestamp`: Long,
    `endTimestamp`: Long,
    `durationMicro`: Int,
    `serviceCounts`: Map[String, Int] = Map[String, Int](),
    `endpoints`: Seq[_zipkinCore_.Endpoint] = Seq[_zipkinCore_.Endpoint]()
  ): TraceSummary = new Immutable(
    `traceId`,
    `startTimestamp`,
    `endTimestamp`,
    `durationMicro`,
    `serviceCounts`,
    `endpoints`
  )

  def unapply(_item: TraceSummary): Option[Product6[Long, Long, Long, Int, Map[String, Int], Seq[_zipkinCore_.Endpoint]]] = Some(_item)

  object Immutable extends ThriftStructCodec[TraceSummary] {
    def encode(_item: TraceSummary, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = {
      var `traceId`: Long = 0L
      var _got_traceId = false
      var `startTimestamp`: Long = 0L
      var _got_startTimestamp = false
      var `endTimestamp`: Long = 0L
      var _got_endTimestamp = false
      var `durationMicro`: Int = 0
      var _got_durationMicro = false
      var `serviceCounts`: Map[String, Int] = Map[String, Int]()
      var _got_serviceCounts = false
      var `endpoints`: Seq[_zipkinCore_.Endpoint] = Seq[_zipkinCore_.Endpoint]()
      var _got_endpoints = false
      var _done = false
      _iprot.readStructBegin()
      while (!_done) {
        val _field = _iprot.readFieldBegin()
        if (_field.`type` == TType.STOP) {
          _done = true
        } else {
          _field.id match {
            case 1 => { /* traceId */
              _field.`type` match {
                case TType.I64 => {
                  `traceId` = {
                    _iprot.readI64()
                  }
                  _got_traceId = true
                }
                case _ => TProtocolUtil.skip(_iprot, _field.`type`)
              }
            }
            case 2 => { /* startTimestamp */
              _field.`type` match {
                case TType.I64 => {
                  `startTimestamp` = {
                    _iprot.readI64()
                  }
                  _got_startTimestamp = true
                }
                case _ => TProtocolUtil.skip(_iprot, _field.`type`)
              }
            }
            case 3 => { /* endTimestamp */
              _field.`type` match {
                case TType.I64 => {
                  `endTimestamp` = {
                    _iprot.readI64()
                  }
                  _got_endTimestamp = true
                }
                case _ => TProtocolUtil.skip(_iprot, _field.`type`)
              }
            }
            case 4 => { /* durationMicro */
              _field.`type` match {
                case TType.I32 => {
                  `durationMicro` = {
                    _iprot.readI32()
                  }
                  _got_durationMicro = true
                }
                case _ => TProtocolUtil.skip(_iprot, _field.`type`)
              }
            }
            case 5 => { /* serviceCounts */
              _field.`type` match {
                case TType.MAP => {
                  `serviceCounts` = {
                    val _map = _iprot.readMapBegin()
                    val _rv = new mutable.HashMap[String, Int]
                    var _i = 0
                    while (_i < _map.size) {
                      val _key = {
                        _iprot.readString()
                      }
                      val _value = {
                        _iprot.readI32()
                      }
                      _rv(_key) = _value
                      _i += 1
                    }
                    _iprot.readMapEnd()
                    _rv
                  }
                  _got_serviceCounts = true
                }
                case _ => TProtocolUtil.skip(_iprot, _field.`type`)
              }
            }
            case 6 => { /* endpoints */
              _field.`type` match {
                case TType.LIST => {
                  `endpoints` = {
                    val _list = _iprot.readListBegin()
                    val _rv = new mutable.ArrayBuffer[_zipkinCore_.Endpoint](_list.size)
                    var _i = 0
                    while (_i < _list.size) {
                      _rv += {
                        _zipkinCore_.Endpoint.decode(_iprot)
                      }
                      _i += 1
                    }
                    _iprot.readListEnd()
                    _rv
                  }
                  _got_endpoints = true
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
        `traceId`,
        `startTimestamp`,
        `endTimestamp`,
        `durationMicro`,
        `serviceCounts`,
        `endpoints`
      )
    }
  }

  /**
   * The default read-only implementation of TraceSummary.  You typically should not need to
   * directly reference this class; instead, use the TraceSummary.apply method to construct
   * new instances.
   */
  class Immutable(
    val `traceId`: Long,
    val `startTimestamp`: Long,
    val `endTimestamp`: Long,
    val `durationMicro`: Int,
    val `serviceCounts`: Map[String, Int] = Map[String, Int](),
    val `endpoints`: Seq[_zipkinCore_.Endpoint] = Seq[_zipkinCore_.Endpoint]()
  ) extends TraceSummary

  /**
   * This Proxy trait allows you to extend the TraceSummary trait with additional state or
   * behavior and implement the read-only methods from TraceSummary using an underlying
   * instance.
   */
  trait Proxy extends TraceSummary {
    protected def _underlyingTraceSummary: TraceSummary
    def `traceId`: Long = _underlyingTraceSummary.`traceId`
    def `startTimestamp`: Long = _underlyingTraceSummary.`startTimestamp`
    def `endTimestamp`: Long = _underlyingTraceSummary.`endTimestamp`
    def `durationMicro`: Int = _underlyingTraceSummary.`durationMicro`
    def `serviceCounts`: Map[String, Int] = _underlyingTraceSummary.`serviceCounts`
    def `endpoints`: Seq[_zipkinCore_.Endpoint] = _underlyingTraceSummary.`endpoints`
  }
}

trait TraceSummary extends ThriftStruct
  with Product6[Long, Long, Long, Int, Map[String, Int], Seq[_zipkinCore_.Endpoint]]
  with java.io.Serializable
{
  import TraceSummary._

  def `traceId`: Long
  def `startTimestamp`: Long
  def `endTimestamp`: Long
  def `durationMicro`: Int
  def `serviceCounts`: Map[String, Int]
  def `endpoints`: Seq[_zipkinCore_.Endpoint]

  def _1 = `traceId`
  def _2 = `startTimestamp`
  def _3 = `endTimestamp`
  def _4 = `durationMicro`
  def _5 = `serviceCounts`
  def _6 = `endpoints`

  override def write(_oprot: TProtocol) {
    validate()
    _oprot.writeStructBegin(Struct)
    if (true) {
      val `traceId_item` = `traceId`
      _oprot.writeFieldBegin(TraceIdField)
      _oprot.writeI64(`traceId_item`)
      _oprot.writeFieldEnd()
    }
    if (true) {
      val `startTimestamp_item` = `startTimestamp`
      _oprot.writeFieldBegin(StartTimestampField)
      _oprot.writeI64(`startTimestamp_item`)
      _oprot.writeFieldEnd()
    }
    if (true) {
      val `endTimestamp_item` = `endTimestamp`
      _oprot.writeFieldBegin(EndTimestampField)
      _oprot.writeI64(`endTimestamp_item`)
      _oprot.writeFieldEnd()
    }
    if (true) {
      val `durationMicro_item` = `durationMicro`
      _oprot.writeFieldBegin(DurationMicroField)
      _oprot.writeI32(`durationMicro_item`)
      _oprot.writeFieldEnd()
    }
    if (true) {
      val `serviceCounts_item` = `serviceCounts`
      _oprot.writeFieldBegin(ServiceCountsField)
      _oprot.writeMapBegin(new TMap(TType.STRING, TType.I32, `serviceCounts_item`.size))
      `serviceCounts_item`.foreach { _pair =>
        val `_serviceCounts_item_key` = _pair._1
        val `_serviceCounts_item_value` = _pair._2
        _oprot.writeString(`_serviceCounts_item_key`)
        _oprot.writeI32(`_serviceCounts_item_value`)
      }
      _oprot.writeMapEnd()
      _oprot.writeFieldEnd()
    }
    if (true) {
      val `endpoints_item` = `endpoints`
      _oprot.writeFieldBegin(EndpointsField)
      _oprot.writeListBegin(new TList(TType.STRUCT, `endpoints_item`.size))
      `endpoints_item`.foreach { `_endpoints_item_element` =>
        `_endpoints_item_element`.write(_oprot)
      }
      _oprot.writeListEnd()
      _oprot.writeFieldEnd()
    }
    _oprot.writeFieldStop()
    _oprot.writeStructEnd()
  }

  def copy(
    `traceId`: Long = this.`traceId`,
    `startTimestamp`: Long = this.`startTimestamp`,
    `endTimestamp`: Long = this.`endTimestamp`,
    `durationMicro`: Int = this.`durationMicro`,
    `serviceCounts`: Map[String, Int] = this.`serviceCounts`,
    `endpoints`: Seq[_zipkinCore_.Endpoint] = this.`endpoints`
  ): TraceSummary = new Immutable(
    `traceId`,
    `startTimestamp`,
    `endTimestamp`,
    `durationMicro`,
    `serviceCounts`,
    `endpoints`
  )

  /**
   * Checks that all required fields are non-null.
   */
  def validate() {
  }

  def canEqual(other: Any) = other.isInstanceOf[TraceSummary]

  override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)

  override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)

  override def toString: String = runtime.ScalaRunTime._toString(this)

  override def productArity = 6

  override def productElement(n: Int): Any = n match {
    case 0 => `traceId`
    case 1 => `startTimestamp`
    case 2 => `endTimestamp`
    case 3 => `durationMicro`
    case 4 => `serviceCounts`
    case 5 => `endpoints`
    case _ => throw new IndexOutOfBoundsException(n.toString)
  }

  override def productPrefix = "TraceSummary"
}