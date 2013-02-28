package com.twitter.zipkin.gen

import com.twitter.scrooge.{ThriftStruct, ThriftStructCodec}
import org.apache.thrift.protocol._
import java.nio.ByteBuffer
import com.twitter.finagle.SourcedException
import scala.collection.mutable
import scala.collection.{Map, Set}

object Span extends ThriftStructCodec[Span] {
  val Struct = new TStruct("Span")
  val TraceIdField = new TField("traceId", TType.I64, 1)
  val NameField = new TField("name", TType.STRING, 3)
  val IdField = new TField("id", TType.I64, 4)
  val ParentIdField = new TField("parentId", TType.I64, 5)
  val AnnotationsField = new TField("annotations", TType.LIST, 6)
  val BinaryAnnotationsField = new TField("binaryAnnotations", TType.LIST, 8)
  val DebugField = new TField("debug", TType.BOOL, 9)

  def encode(_item: Span, _oproto: TProtocol) { _item.write(_oproto) }
  def decode(_iprot: TProtocol) = Immutable.decode(_iprot)

  def apply(_iprot: TProtocol): Span = decode(_iprot)

  def apply(
    `traceId`: Long,
    `name`: String,
    `id`: Long,
    `parentId`: Option[Long] = None,
    `annotations`: Seq[Annotation] = Seq[Annotation](),
    `binaryAnnotations`: Seq[BinaryAnnotation] = Seq[BinaryAnnotation](),
    `debug`: Boolean = false
  ): Span = new Immutable(
    `traceId`,
    `name`,
    `id`,
    `parentId`,
    `annotations`,
    `binaryAnnotations`,
    `debug`
  )

  def unapply(_item: Span): Option[Product7[Long, String, Long, Option[Long], Seq[Annotation], Seq[BinaryAnnotation], Boolean]] = Some(_item)

  object Immutable extends ThriftStructCodec[Span] {
    def encode(_item: Span, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = {
      var `traceId`: Long = 0L
      var _got_traceId = false
      var `name`: String = null
      var _got_name = false
      var `id`: Long = 0L
      var _got_id = false
      var `parentId`: Long = 0L
      var _got_parentId = false
      var `annotations`: Seq[Annotation] = Seq[Annotation]()
      var _got_annotations = false
      var `binaryAnnotations`: Seq[BinaryAnnotation] = Seq[BinaryAnnotation]()
      var _got_binaryAnnotations = false
      var `debug`: Boolean = false
      var _got_debug = false
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
            case 3 => { /* name */
              _field.`type` match {
                case TType.STRING => {
                  `name` = {
                    _iprot.readString()
                  }
                  _got_name = true
                }
                case _ => TProtocolUtil.skip(_iprot, _field.`type`)
              }
            }
            case 4 => { /* id */
              _field.`type` match {
                case TType.I64 => {
                  `id` = {
                    _iprot.readI64()
                  }
                  _got_id = true
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
            case 6 => { /* annotations */
              _field.`type` match {
                case TType.LIST => {
                  `annotations` = {
                    val _list = _iprot.readListBegin()
                    val _rv = new mutable.ArrayBuffer[Annotation](_list.size)
                    var _i = 0
                    while (_i < _list.size) {
                      _rv += {
                        Annotation.decode(_iprot)
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
            case 8 => { /* binaryAnnotations */
              _field.`type` match {
                case TType.LIST => {
                  `binaryAnnotations` = {
                    val _list = _iprot.readListBegin()
                    val _rv = new mutable.ArrayBuffer[BinaryAnnotation](_list.size)
                    var _i = 0
                    while (_i < _list.size) {
                      _rv += {
                        BinaryAnnotation.decode(_iprot)
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
            case 9 => { /* debug */
              _field.`type` match {
                case TType.BOOL => {
                  `debug` = {
                    _iprot.readBool()
                  }
                  _got_debug = true
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
        `name`,
        `id`,
        if (_got_parentId) Some(`parentId`) else None,
        `annotations`,
        `binaryAnnotations`,
        `debug`
      )
    }
  }

  /**
   * The default read-only implementation of Span.  You typically should not need to
   * directly reference this class; instead, use the Span.apply method to construct
   * new instances.
   */
  class Immutable(
    val `traceId`: Long,
    val `name`: String,
    val `id`: Long,
    val `parentId`: Option[Long] = None,
    val `annotations`: Seq[Annotation] = Seq[Annotation](),
    val `binaryAnnotations`: Seq[BinaryAnnotation] = Seq[BinaryAnnotation](),
    val `debug`: Boolean = false
  ) extends Span

  /**
   * This Proxy trait allows you to extend the Span trait with additional state or
   * behavior and implement the read-only methods from Span using an underlying
   * instance.
   */
  trait Proxy extends Span {
    protected def _underlyingSpan: Span
    def `traceId`: Long = _underlyingSpan.`traceId`
    def `name`: String = _underlyingSpan.`name`
    def `id`: Long = _underlyingSpan.`id`
    def `parentId`: Option[Long] = _underlyingSpan.`parentId`
    def `annotations`: Seq[Annotation] = _underlyingSpan.`annotations`
    def `binaryAnnotations`: Seq[BinaryAnnotation] = _underlyingSpan.`binaryAnnotations`
    def `debug`: Boolean = _underlyingSpan.`debug`
  }
}

trait Span extends ThriftStruct
  with Product7[Long, String, Long, Option[Long], Seq[Annotation], Seq[BinaryAnnotation], Boolean]
  with java.io.Serializable
{
  import Span._

  def `traceId`: Long
  def `name`: String
  def `id`: Long
  def `parentId`: Option[Long]
  def `annotations`: Seq[Annotation]
  def `binaryAnnotations`: Seq[BinaryAnnotation]
  def `debug`: Boolean

  def _1 = `traceId`
  def _2 = `name`
  def _3 = `id`
  def _4 = `parentId`
  def _5 = `annotations`
  def _6 = `binaryAnnotations`
  def _7 = `debug`

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
      val `name_item` = `name`
      _oprot.writeFieldBegin(NameField)
      _oprot.writeString(`name_item`)
      _oprot.writeFieldEnd()
    }
    if (true) {
      val `id_item` = `id`
      _oprot.writeFieldBegin(IdField)
      _oprot.writeI64(`id_item`)
      _oprot.writeFieldEnd()
    }
    if (`parentId`.isDefined) {
      val `parentId_item` = `parentId`.get
      _oprot.writeFieldBegin(ParentIdField)
      _oprot.writeI64(`parentId_item`)
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
    if (true) {
      val `debug_item` = `debug`
      _oprot.writeFieldBegin(DebugField)
      _oprot.writeBool(`debug_item`)
      _oprot.writeFieldEnd()
    }
    _oprot.writeFieldStop()
    _oprot.writeStructEnd()
  }

  def copy(
    `traceId`: Long = this.`traceId`,
    `name`: String = this.`name`,
    `id`: Long = this.`id`,
    `parentId`: Option[Long] = this.`parentId`,
    `annotations`: Seq[Annotation] = this.`annotations`,
    `binaryAnnotations`: Seq[BinaryAnnotation] = this.`binaryAnnotations`,
    `debug`: Boolean = this.`debug`
  ): Span = new Immutable(
    `traceId`,
    `name`,
    `id`,
    `parentId`,
    `annotations`,
    `binaryAnnotations`,
    `debug`
  )

  /**
   * Checks that all required fields are non-null.
   */
  def validate() {
  }

  def canEqual(other: Any) = other.isInstanceOf[Span]

  override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)

  override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)

  override def toString: String = runtime.ScalaRunTime._toString(this)

  override def productArity = 7

  override def productElement(n: Int): Any = n match {
    case 0 => `traceId`
    case 1 => `name`
    case 2 => `id`
    case 3 => `parentId`
    case 4 => `annotations`
    case 5 => `binaryAnnotations`
    case 6 => `debug`
    case _ => throw new IndexOutOfBoundsException(n.toString)
  }

  override def productPrefix = "Span"
}