package com.twitter.zipkin.gen

import com.twitter.scrooge.{ThriftStruct, ThriftStructCodec}
import org.apache.thrift.protocol._
import java.nio.ByteBuffer
import com.twitter.finagle.SourcedException
import scala.collection.mutable
import scala.collection.{Map, Set}
import com.twitter.zipkin.{gen => _zipkinCore_}

object TraceTimeline extends ThriftStructCodec[TraceTimeline] {
  val Struct = new TStruct("TraceTimeline")
  val TraceIdField = new TField("traceId", TType.I64, 1)
  val RootMostSpanIdField = new TField("rootMostSpanId", TType.I64, 2)
  val AnnotationsField = new TField("annotations", TType.LIST, 6)
  val BinaryAnnotationsField = new TField("binaryAnnotations", TType.LIST, 7)

  def encode(_item: TraceTimeline, _oproto: TProtocol) { _item.write(_oproto) }
  def decode(_iprot: TProtocol) = Immutable.decode(_iprot)

  def apply(_iprot: TProtocol): TraceTimeline = decode(_iprot)

  def apply(
    `traceId`: Long,
    `rootMostSpanId`: Long,
    `annotations`: Seq[TimelineAnnotation] = Seq[TimelineAnnotation](),
    `binaryAnnotations`: Seq[_zipkinCore_.BinaryAnnotation] = Seq[_zipkinCore_.BinaryAnnotation]()
  ): TraceTimeline = new Immutable(
    `traceId`,
    `rootMostSpanId`,
    `annotations`,
    `binaryAnnotations`
  )

  def unapply(_item: TraceTimeline): Option[Product4[Long, Long, Seq[TimelineAnnotation], Seq[_zipkinCore_.BinaryAnnotation]]] = Some(_item)

  object Immutable extends ThriftStructCodec[TraceTimeline] {
    def encode(_item: TraceTimeline, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = {
      var `traceId`: Long = 0L
      var _got_traceId = false
      var `rootMostSpanId`: Long = 0L
      var _got_rootMostSpanId = false
      var `annotations`: Seq[TimelineAnnotation] = Seq[TimelineAnnotation]()
      var _got_annotations = false
      var `binaryAnnotations`: Seq[_zipkinCore_.BinaryAnnotation] = Seq[_zipkinCore_.BinaryAnnotation]()
      var _got_binaryAnnotations = false
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
            case 2 => { /* rootMostSpanId */
              _field.`type` match {
                case TType.I64 => {
                  `rootMostSpanId` = {
                    _iprot.readI64()
                  }
                  _got_rootMostSpanId = true
                }
                case _ => TProtocolUtil.skip(_iprot, _field.`type`)
              }
            }
            case 6 => { /* annotations */
              _field.`type` match {
                case TType.LIST => {
                  `annotations` = {
                    val _list = _iprot.readListBegin()
                    val _rv = new mutable.ArrayBuffer[TimelineAnnotation](_list.size)
                    var _i = 0
                    while (_i < _list.size) {
                      _rv += {
                        TimelineAnnotation.decode(_iprot)
                      }
                      _i += 1
                    }
                    _iprot.readListEnd()
                    _rv
                  }
                  _got_annotations = true
                }
                case _ => TProtocolUtil.skip(_iprot, _field.`type`)
              }
            }
            case 7 => { /* binaryAnnotations */
              _field.`type` match {
                case TType.LIST => {
                  `binaryAnnotations` = {
                    val _list = _iprot.readListBegin()
                    val _rv = new mutable.ArrayBuffer[_zipkinCore_.BinaryAnnotation](_list.size)
                    var _i = 0
                    while (_i < _list.size) {
                      _rv += {
                        _zipkinCore_.BinaryAnnotation.decode(_iprot)
                      }
                      _i += 1
                    }
                    _iprot.readListEnd()
                    _rv
                  }
                  _got_binaryAnnotations = true
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
        `rootMostSpanId`,
        `annotations`,
        `binaryAnnotations`
      )
    }
  }

  /**
   * The default read-only implementation of TraceTimeline.  You typically should not need to
   * directly reference this class; instead, use the TraceTimeline.apply method to construct
   * new instances.
   */
  class Immutable(
    val `traceId`: Long,
    val `rootMostSpanId`: Long,
    val `annotations`: Seq[TimelineAnnotation] = Seq[TimelineAnnotation](),
    val `binaryAnnotations`: Seq[_zipkinCore_.BinaryAnnotation] = Seq[_zipkinCore_.BinaryAnnotation]()
  ) extends TraceTimeline

  /**
   * This Proxy trait allows you to extend the TraceTimeline trait with additional state or
   * behavior and implement the read-only methods from TraceTimeline using an underlying
   * instance.
   */
  trait Proxy extends TraceTimeline {
    protected def _underlyingTraceTimeline: TraceTimeline
    def `traceId`: Long = _underlyingTraceTimeline.`traceId`
    def `rootMostSpanId`: Long = _underlyingTraceTimeline.`rootMostSpanId`
    def `annotations`: Seq[TimelineAnnotation] = _underlyingTraceTimeline.`annotations`
    def `binaryAnnotations`: Seq[_zipkinCore_.BinaryAnnotation] = _underlyingTraceTimeline.`binaryAnnotations`
  }
}

trait TraceTimeline extends ThriftStruct
  with Product4[Long, Long, Seq[TimelineAnnotation], Seq[_zipkinCore_.BinaryAnnotation]]
  with java.io.Serializable
{
  import TraceTimeline._

  def `traceId`: Long
  def `rootMostSpanId`: Long
  def `annotations`: Seq[TimelineAnnotation]
  def `binaryAnnotations`: Seq[_zipkinCore_.BinaryAnnotation]

  def _1 = `traceId`
  def _2 = `rootMostSpanId`
  def _3 = `annotations`
  def _4 = `binaryAnnotations`

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
      val `rootMostSpanId_item` = `rootMostSpanId`
      _oprot.writeFieldBegin(RootMostSpanIdField)
      _oprot.writeI64(`rootMostSpanId_item`)
      _oprot.writeFieldEnd()
    }
    if (true) {
      val `annotations_item` = `annotations`
      _oprot.writeFieldBegin(AnnotationsField)
      _oprot.writeListBegin(new TList(TType.STRUCT, `annotations_item`.size))
      `annotations_item`.foreach { `_annotations_item_element` =>
        `_annotations_item_element`.write(_oprot)
      }
      _oprot.writeListEnd()
      _oprot.writeFieldEnd()
    }
    if (true) {
      val `binaryAnnotations_item` = `binaryAnnotations`
      _oprot.writeFieldBegin(BinaryAnnotationsField)
      _oprot.writeListBegin(new TList(TType.STRUCT, `binaryAnnotations_item`.size))
      `binaryAnnotations_item`.foreach { `_binaryAnnotations_item_element` =>
        `_binaryAnnotations_item_element`.write(_oprot)
      }
      _oprot.writeListEnd()
      _oprot.writeFieldEnd()
    }
    _oprot.writeFieldStop()
    _oprot.writeStructEnd()
  }

  def copy(
    `traceId`: Long = this.`traceId`,
    `rootMostSpanId`: Long = this.`rootMostSpanId`,
    `annotations`: Seq[TimelineAnnotation] = this.`annotations`,
    `binaryAnnotations`: Seq[_zipkinCore_.BinaryAnnotation] = this.`binaryAnnotations`
  ): TraceTimeline = new Immutable(
    `traceId`,
    `rootMostSpanId`,
    `annotations`,
    `binaryAnnotations`
  )

  /**
   * Checks that all required fields are non-null.
   */
  def validate() {
  }

  def canEqual(other: Any) = other.isInstanceOf[TraceTimeline]

  override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)

  override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)

  override def toString: String = runtime.ScalaRunTime._toString(this)

  override def productArity = 4

  override def productElement(n: Int): Any = n match {
    case 0 => `traceId`
    case 1 => `rootMostSpanId`
    case 2 => `annotations`
    case 3 => `binaryAnnotations`
    case _ => throw new IndexOutOfBoundsException(n.toString)
  }

  override def productPrefix = "TraceTimeline"
}