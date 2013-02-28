package com.twitter.zipkin.gen

import com.twitter.scrooge.{ThriftStruct, ThriftStructCodec}
import org.apache.thrift.protocol._
import java.nio.ByteBuffer
import com.twitter.finagle.SourcedException
import scala.collection.mutable
import scala.collection.{Map, Set}
import com.twitter.zipkin.{gen => _zipkinCore_}

object QueryRequest extends ThriftStructCodec[QueryRequest] {
  val Struct = new TStruct("QueryRequest")
  val ServiceNameField = new TField("serviceName", TType.STRING, 1)
  val SpanNameField = new TField("spanName", TType.STRING, 2)
  val AnnotationsField = new TField("annotations", TType.LIST, 3)
  val BinaryAnnotationsField = new TField("binaryAnnotations", TType.LIST, 4)
  val EndTsField = new TField("endTs", TType.I64, 5)
  val LimitField = new TField("limit", TType.I32, 6)
  val OrderField = new TField("order", TType.I32, 7)

  def encode(_item: QueryRequest, _oproto: TProtocol) { _item.write(_oproto) }
  def decode(_iprot: TProtocol) = Immutable.decode(_iprot)

  def apply(_iprot: TProtocol): QueryRequest = decode(_iprot)

  def apply(
    `serviceName`: String,
    `spanName`: Option[String] = None,
    `annotations`: Option[Seq[String]] = None,
    `binaryAnnotations`: Option[Seq[_zipkinCore_.BinaryAnnotation]] = None,
    `endTs`: Long,
    `limit`: Int,
    `order`: Order
  ): QueryRequest = new Immutable(
    `serviceName`,
    `spanName`,
    `annotations`,
    `binaryAnnotations`,
    `endTs`,
    `limit`,
    `order`
  )

  def unapply(_item: QueryRequest): Option[Product7[String, Option[String], Option[Seq[String]], Option[Seq[_zipkinCore_.BinaryAnnotation]], Long, Int, Order]] = Some(_item)

  object Immutable extends ThriftStructCodec[QueryRequest] {
    def encode(_item: QueryRequest, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = {
      var `serviceName`: String = null
      var _got_serviceName = false
      var `spanName`: String = null
      var _got_spanName = false
      var `annotations`: Seq[String] = Seq[String]()
      var _got_annotations = false
      var `binaryAnnotations`: Seq[_zipkinCore_.BinaryAnnotation] = Seq[_zipkinCore_.BinaryAnnotation]()
      var _got_binaryAnnotations = false
      var `endTs`: Long = 0L
      var _got_endTs = false
      var `limit`: Int = 0
      var _got_limit = false
      var `order`: Order = null
      var _got_order = false
      var _done = false
      _iprot.readStructBegin()
      while (!_done) {
        val _field = _iprot.readFieldBegin()
        if (_field.`type` == TType.STOP) {
          _done = true
        } else {
          _field.id match {
            case 1 => { /* serviceName */
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
            case 2 => { /* spanName */
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
            case 3 => { /* annotations */
              _field.`type` match {
                case TType.LIST => {
                  `annotations` = {
                    val _list = _iprot.readListBegin()
                    val _rv = new mutable.ArrayBuffer[String](_list.size)
                    var _i = 0
                    while (_i < _list.size) {
                      _rv += {
                        _iprot.readString()
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
            case 4 => { /* binaryAnnotations */
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
            case 5 => { /* endTs */
              _field.`type` match {
                case TType.I64 => {
                  `endTs` = {
                    _iprot.readI64()
                  }
                  _got_endTs = true
                }
                case _ => TProtocolUtil.skip(_iprot, _field.`type`)
              }
            }
            case 6 => { /* limit */
              _field.`type` match {
                case TType.I32 => {
                  `limit` = {
                    _iprot.readI32()
                  }
                  _got_limit = true
                }
                case _ => TProtocolUtil.skip(_iprot, _field.`type`)
              }
            }
            case 7 => { /* order */
              _field.`type` match {
                case TType.I32 => {
                  `order` = {
                    Order(_iprot.readI32())
                  }
                  _got_order = true
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
        `serviceName`,
        if (_got_spanName) Some(`spanName`) else None,
        if (_got_annotations) Some(`annotations`) else None,
        if (_got_binaryAnnotations) Some(`binaryAnnotations`) else None,
        `endTs`,
        `limit`,
        `order`
      )
    }
  }

  /**
   * The default read-only implementation of QueryRequest.  You typically should not need to
   * directly reference this class; instead, use the QueryRequest.apply method to construct
   * new instances.
   */
  class Immutable(
    val `serviceName`: String,
    val `spanName`: Option[String] = None,
    val `annotations`: Option[Seq[String]] = None,
    val `binaryAnnotations`: Option[Seq[_zipkinCore_.BinaryAnnotation]] = None,
    val `endTs`: Long,
    val `limit`: Int,
    val `order`: Order
  ) extends QueryRequest

  /**
   * This Proxy trait allows you to extend the QueryRequest trait with additional state or
   * behavior and implement the read-only methods from QueryRequest using an underlying
   * instance.
   */
  trait Proxy extends QueryRequest {
    protected def _underlyingQueryRequest: QueryRequest
    def `serviceName`: String = _underlyingQueryRequest.`serviceName`
    def `spanName`: Option[String] = _underlyingQueryRequest.`spanName`
    def `annotations`: Option[Seq[String]] = _underlyingQueryRequest.`annotations`
    def `binaryAnnotations`: Option[Seq[_zipkinCore_.BinaryAnnotation]] = _underlyingQueryRequest.`binaryAnnotations`
    def `endTs`: Long = _underlyingQueryRequest.`endTs`
    def `limit`: Int = _underlyingQueryRequest.`limit`
    def `order`: Order = _underlyingQueryRequest.`order`
  }
}

trait QueryRequest extends ThriftStruct
  with Product7[String, Option[String], Option[Seq[String]], Option[Seq[_zipkinCore_.BinaryAnnotation]], Long, Int, Order]
  with java.io.Serializable
{
  import QueryRequest._

  def `serviceName`: String
  def `spanName`: Option[String]
  def `annotations`: Option[Seq[String]]
  def `binaryAnnotations`: Option[Seq[_zipkinCore_.BinaryAnnotation]]
  def `endTs`: Long
  def `limit`: Int
  def `order`: Order

  def _1 = `serviceName`
  def _2 = `spanName`
  def _3 = `annotations`
  def _4 = `binaryAnnotations`
  def _5 = `endTs`
  def _6 = `limit`
  def _7 = `order`

  override def write(_oprot: TProtocol) {
    validate()
    _oprot.writeStructBegin(Struct)
    if (true) {
      val `serviceName_item` = `serviceName`
      _oprot.writeFieldBegin(ServiceNameField)
      _oprot.writeString(`serviceName_item`)
      _oprot.writeFieldEnd()
    }
    if (`spanName`.isDefined) {
      val `spanName_item` = `spanName`.get
      _oprot.writeFieldBegin(SpanNameField)
      _oprot.writeString(`spanName_item`)
      _oprot.writeFieldEnd()
    }
    if (`annotations`.isDefined) {
      val `annotations_item` = `annotations`.get
      _oprot.writeFieldBegin(AnnotationsField)
      _oprot.writeListBegin(new TList(TType.STRING, `annotations_item`.size))
      `annotations_item`.foreach { `_annotations_item_element` =>
        _oprot.writeString(`_annotations_item_element`)
      }
      _oprot.writeListEnd()
      _oprot.writeFieldEnd()
    }
    if (`binaryAnnotations`.isDefined) {
      val `binaryAnnotations_item` = `binaryAnnotations`.get
      _oprot.writeFieldBegin(BinaryAnnotationsField)
      _oprot.writeListBegin(new TList(TType.STRUCT, `binaryAnnotations_item`.size))
      `binaryAnnotations_item`.foreach { `_binaryAnnotations_item_element` =>
        `_binaryAnnotations_item_element`.write(_oprot)
      }
      _oprot.writeListEnd()
      _oprot.writeFieldEnd()
    }
    if (true) {
      val `endTs_item` = `endTs`
      _oprot.writeFieldBegin(EndTsField)
      _oprot.writeI64(`endTs_item`)
      _oprot.writeFieldEnd()
    }
    if (true) {
      val `limit_item` = `limit`
      _oprot.writeFieldBegin(LimitField)
      _oprot.writeI32(`limit_item`)
      _oprot.writeFieldEnd()
    }
    if (true) {
      val `order_item` = `order`
      _oprot.writeFieldBegin(OrderField)
      _oprot.writeI32(`order_item`.value)
      _oprot.writeFieldEnd()
    }
    _oprot.writeFieldStop()
    _oprot.writeStructEnd()
  }

  def copy(
    `serviceName`: String = this.`serviceName`,
    `spanName`: Option[String] = this.`spanName`,
    `annotations`: Option[Seq[String]] = this.`annotations`,
    `binaryAnnotations`: Option[Seq[_zipkinCore_.BinaryAnnotation]] = this.`binaryAnnotations`,
    `endTs`: Long = this.`endTs`,
    `limit`: Int = this.`limit`,
    `order`: Order = this.`order`
  ): QueryRequest = new Immutable(
    `serviceName`,
    `spanName`,
    `annotations`,
    `binaryAnnotations`,
    `endTs`,
    `limit`,
    `order`
  )

  /**
   * Checks that all required fields are non-null.
   */
  def validate() {
  }

  def canEqual(other: Any) = other.isInstanceOf[QueryRequest]

  override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)

  override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)

  override def toString: String = runtime.ScalaRunTime._toString(this)

  override def productArity = 7

  override def productElement(n: Int): Any = n match {
    case 0 => `serviceName`
    case 1 => `spanName`
    case 2 => `annotations`
    case 3 => `binaryAnnotations`
    case 4 => `endTs`
    case 5 => `limit`
    case 6 => `order`
    case _ => throw new IndexOutOfBoundsException(n.toString)
  }

  override def productPrefix = "QueryRequest"
}