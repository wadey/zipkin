package com.twitter.zipkin.gen

import com.twitter.scrooge.{ThriftStruct, ThriftStructCodec}
import org.apache.thrift.protocol._
import java.nio.ByteBuffer
import com.twitter.finagle.SourcedException
import scala.collection.mutable
import scala.collection.{Map, Set}
import com.twitter.zipkin.{gen => _zipkinCore_}

object TraceCombo extends ThriftStructCodec[TraceCombo] {
  val Struct = new TStruct("TraceCombo")
  val TraceField = new TField("trace", TType.STRUCT, 1)
  val SummaryField = new TField("summary", TType.STRUCT, 2)
  val TimelineField = new TField("timeline", TType.STRUCT, 3)
  val SpanDepthsField = new TField("spanDepths", TType.MAP, 4)

  def encode(_item: TraceCombo, _oproto: TProtocol) { _item.write(_oproto) }
  def decode(_iprot: TProtocol) = Immutable.decode(_iprot)

  def apply(_iprot: TProtocol): TraceCombo = decode(_iprot)

  def apply(
    `trace`: Trace,
    `summary`: Option[TraceSummary] = None,
    `timeline`: Option[TraceTimeline] = None,
    `spanDepths`: Option[Map[Long, Int]] = None
  ): TraceCombo = new Immutable(
    `trace`,
    `summary`,
    `timeline`,
    `spanDepths`
  )

  def unapply(_item: TraceCombo): Option[Product4[Trace, Option[TraceSummary], Option[TraceTimeline], Option[Map[Long, Int]]]] = Some(_item)

  object Immutable extends ThriftStructCodec[TraceCombo] {
    def encode(_item: TraceCombo, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = {
      var `trace`: Trace = null
      var _got_trace = false
      var `summary`: TraceSummary = null
      var _got_summary = false
      var `timeline`: TraceTimeline = null
      var _got_timeline = false
      var `spanDepths`: Map[Long, Int] = Map[Long, Int]()
      var _got_spanDepths = false
      var _done = false
      _iprot.readStructBegin()
      while (!_done) {
        val _field = _iprot.readFieldBegin()
        if (_field.`type` == TType.STOP) {
          _done = true
        } else {
          _field.id match {
            case 1 => { /* trace */
              _field.`type` match {
                case TType.STRUCT => {
                  `trace` = {
                    Trace.decode(_iprot)
                  }
                  _got_trace = true
                }
                case _ => TProtocolUtil.skip(_iprot, _field.`type`)
              }
            }
            case 2 => { /* summary */
              _field.`type` match {
                case TType.STRUCT => {
                  `summary` = {
                    TraceSummary.decode(_iprot)
                  }
                  _got_summary = true
                }
                case _ => TProtocolUtil.skip(_iprot, _field.`type`)
              }
            }
            case 3 => { /* timeline */
              _field.`type` match {
                case TType.STRUCT => {
                  `timeline` = {
                    TraceTimeline.decode(_iprot)
                  }
                  _got_timeline = true
                }
                case _ => TProtocolUtil.skip(_iprot, _field.`type`)
              }
            }
            case 4 => { /* spanDepths */
              _field.`type` match {
                case TType.MAP => {
                  `spanDepths` = {
                    val _map = _iprot.readMapBegin()
                    val _rv = new mutable.HashMap[Long, Int]
                    var _i = 0
                    while (_i < _map.size) {
                      val _key = {
                        _iprot.readI64()
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
                  _got_spanDepths = true
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
        `trace`,
        if (_got_summary) Some(`summary`) else None,
        if (_got_timeline) Some(`timeline`) else None,
        if (_got_spanDepths) Some(`spanDepths`) else None
      )
    }
  }

  /**
   * The default read-only implementation of TraceCombo.  You typically should not need to
   * directly reference this class; instead, use the TraceCombo.apply method to construct
   * new instances.
   */
  class Immutable(
    val `trace`: Trace,
    val `summary`: Option[TraceSummary] = None,
    val `timeline`: Option[TraceTimeline] = None,
    val `spanDepths`: Option[Map[Long, Int]] = None
  ) extends TraceCombo

  /**
   * This Proxy trait allows you to extend the TraceCombo trait with additional state or
   * behavior and implement the read-only methods from TraceCombo using an underlying
   * instance.
   */
  trait Proxy extends TraceCombo {
    protected def _underlyingTraceCombo: TraceCombo
    def `trace`: Trace = _underlyingTraceCombo.`trace`
    def `summary`: Option[TraceSummary] = _underlyingTraceCombo.`summary`
    def `timeline`: Option[TraceTimeline] = _underlyingTraceCombo.`timeline`
    def `spanDepths`: Option[Map[Long, Int]] = _underlyingTraceCombo.`spanDepths`
  }
}

trait TraceCombo extends ThriftStruct
  with Product4[Trace, Option[TraceSummary], Option[TraceTimeline], Option[Map[Long, Int]]]
  with java.io.Serializable
{
  import TraceCombo._

  def `trace`: Trace
  def `summary`: Option[TraceSummary]
  def `timeline`: Option[TraceTimeline]
  def `spanDepths`: Option[Map[Long, Int]]

  def _1 = `trace`
  def _2 = `summary`
  def _3 = `timeline`
  def _4 = `spanDepths`

  override def write(_oprot: TProtocol) {
    validate()
    _oprot.writeStructBegin(Struct)
    if (true) {
      val `trace_item` = `trace`
      _oprot.writeFieldBegin(TraceField)
      `trace_item`.write(_oprot)
      _oprot.writeFieldEnd()
    }
    if (`summary`.isDefined) {
      val `summary_item` = `summary`.get
      _oprot.writeFieldBegin(SummaryField)
      `summary_item`.write(_oprot)
      _oprot.writeFieldEnd()
    }
    if (`timeline`.isDefined) {
      val `timeline_item` = `timeline`.get
      _oprot.writeFieldBegin(TimelineField)
      `timeline_item`.write(_oprot)
      _oprot.writeFieldEnd()
    }
    if (`spanDepths`.isDefined) {
      val `spanDepths_item` = `spanDepths`.get
      _oprot.writeFieldBegin(SpanDepthsField)
      _oprot.writeMapBegin(new TMap(TType.I64, TType.I32, `spanDepths_item`.size))
      `spanDepths_item`.foreach { _pair =>
        val `_spanDepths_item_key` = _pair._1
        val `_spanDepths_item_value` = _pair._2
        _oprot.writeI64(`_spanDepths_item_key`)
        _oprot.writeI32(`_spanDepths_item_value`)
      }
      _oprot.writeMapEnd()
      _oprot.writeFieldEnd()
    }
    _oprot.writeFieldStop()
    _oprot.writeStructEnd()
  }

  def copy(
    `trace`: Trace = this.`trace`,
    `summary`: Option[TraceSummary] = this.`summary`,
    `timeline`: Option[TraceTimeline] = this.`timeline`,
    `spanDepths`: Option[Map[Long, Int]] = this.`spanDepths`
  ): TraceCombo = new Immutable(
    `trace`,
    `summary`,
    `timeline`,
    `spanDepths`
  )

  /**
   * Checks that all required fields are non-null.
   */
  def validate() {
  }

  def canEqual(other: Any) = other.isInstanceOf[TraceCombo]

  override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)

  override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)

  override def toString: String = runtime.ScalaRunTime._toString(this)

  override def productArity = 4

  override def productElement(n: Int): Any = n match {
    case 0 => `trace`
    case 1 => `summary`
    case 2 => `timeline`
    case 3 => `spanDepths`
    case _ => throw new IndexOutOfBoundsException(n.toString)
  }

  override def productPrefix = "TraceCombo"
}