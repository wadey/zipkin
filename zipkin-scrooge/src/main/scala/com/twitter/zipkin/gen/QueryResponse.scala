package com.twitter.zipkin.gen

import com.twitter.scrooge.{ThriftStruct, ThriftStructCodec}
import org.apache.thrift.protocol._
import java.nio.ByteBuffer
import com.twitter.finagle.SourcedException
import scala.collection.mutable
import scala.collection.{Map, Set}
import com.twitter.zipkin.{gen => _zipkinCore_}

object QueryResponse extends ThriftStructCodec[QueryResponse] {
  val Struct = new TStruct("QueryResponse")
  val TraceIdsField = new TField("traceIds", TType.LIST, 1)
  val StartTsField = new TField("startTs", TType.I64, 2)
  val EndTsField = new TField("endTs", TType.I64, 3)

  def encode(_item: QueryResponse, _oproto: TProtocol) { _item.write(_oproto) }
  def decode(_iprot: TProtocol) = Immutable.decode(_iprot)

  def apply(_iprot: TProtocol): QueryResponse = decode(_iprot)

  def apply(
    `traceIds`: Seq[Long] = Seq[Long](),
    `startTs`: Long,
    `endTs`: Long
  ): QueryResponse = new Immutable(
    `traceIds`,
    `startTs`,
    `endTs`
  )

  def unapply(_item: QueryResponse): Option[Product3[Seq[Long], Long, Long]] = Some(_item)

  object Immutable extends ThriftStructCodec[QueryResponse] {
    def encode(_item: QueryResponse, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = {
      var `traceIds`: Seq[Long] = Seq[Long]()
      var _got_traceIds = false
      var `startTs`: Long = 0L
      var _got_startTs = false
      var `endTs`: Long = 0L
      var _got_endTs = false
      var _done = false
      _iprot.readStructBegin()
      while (!_done) {
        val _field = _iprot.readFieldBegin()
        if (_field.`type` == TType.STOP) {
          _done = true
        } else {
          _field.id match {
            case 1 => { /* traceIds */
              _field.`type` match {
                case TType.LIST => {
                  `traceIds` = {
                    val _list = _iprot.readListBegin()
                    val _rv = new mutable.ArrayBuffer[Long](_list.size)
                    var _i = 0
                    while (_i < _list.size) {
                      _rv += {
                        _iprot.readI64()
                      }
                      _i += 1
                    }
                    _iprot.readListEnd()
                    _rv
                  }
                  _got_traceIds = true
                }
                case _ => TProtocolUtil.skip(_iprot, _field.`type`)
              }
            }
            case 2 => { /* startTs */
              _field.`type` match {
                case TType.I64 => {
                  `startTs` = {
                    _iprot.readI64()
                  }
                  _got_startTs = true
                }
                case _ => TProtocolUtil.skip(_iprot, _field.`type`)
              }
            }
            case 3 => { /* endTs */
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
            case _ => TProtocolUtil.skip(_iprot, _field.`type`)
          }
          _iprot.readFieldEnd()
        }
      }
      _iprot.readStructEnd()
      new Immutable(
        `traceIds`,
        `startTs`,
        `endTs`
      )
    }
  }

  /**
   * The default read-only implementation of QueryResponse.  You typically should not need to
   * directly reference this class; instead, use the QueryResponse.apply method to construct
   * new instances.
   */
  class Immutable(
    val `traceIds`: Seq[Long] = Seq[Long](),
    val `startTs`: Long,
    val `endTs`: Long
  ) extends QueryResponse

  /**
   * This Proxy trait allows you to extend the QueryResponse trait with additional state or
   * behavior and implement the read-only methods from QueryResponse using an underlying
   * instance.
   */
  trait Proxy extends QueryResponse {
    protected def _underlyingQueryResponse: QueryResponse
    def `traceIds`: Seq[Long] = _underlyingQueryResponse.`traceIds`
    def `startTs`: Long = _underlyingQueryResponse.`startTs`
    def `endTs`: Long = _underlyingQueryResponse.`endTs`
  }
}

trait QueryResponse extends ThriftStruct
  with Product3[Seq[Long], Long, Long]
  with java.io.Serializable
{
  import QueryResponse._

  def `traceIds`: Seq[Long]
  def `startTs`: Long
  def `endTs`: Long

  def _1 = `traceIds`
  def _2 = `startTs`
  def _3 = `endTs`

  override def write(_oprot: TProtocol) {
    validate()
    _oprot.writeStructBegin(Struct)
    if (true) {
      val `traceIds_item` = `traceIds`
      _oprot.writeFieldBegin(TraceIdsField)
      _oprot.writeListBegin(new TList(TType.I64, `traceIds_item`.size))
      `traceIds_item`.foreach { `_traceIds_item_element` =>
        _oprot.writeI64(`_traceIds_item_element`)
      }
      _oprot.writeListEnd()
      _oprot.writeFieldEnd()
    }
    if (true) {
      val `startTs_item` = `startTs`
      _oprot.writeFieldBegin(StartTsField)
      _oprot.writeI64(`startTs_item`)
      _oprot.writeFieldEnd()
    }
    if (true) {
      val `endTs_item` = `endTs`
      _oprot.writeFieldBegin(EndTsField)
      _oprot.writeI64(`endTs_item`)
      _oprot.writeFieldEnd()
    }
    _oprot.writeFieldStop()
    _oprot.writeStructEnd()
  }

  def copy(
    `traceIds`: Seq[Long] = this.`traceIds`,
    `startTs`: Long = this.`startTs`,
    `endTs`: Long = this.`endTs`
  ): QueryResponse = new Immutable(
    `traceIds`,
    `startTs`,
    `endTs`
  )

  /**
   * Checks that all required fields are non-null.
   */
  def validate() {
  }

  def canEqual(other: Any) = other.isInstanceOf[QueryResponse]

  override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)

  override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)

  override def toString: String = runtime.ScalaRunTime._toString(this)

  override def productArity = 3

  override def productElement(n: Int): Any = n match {
    case 0 => `traceIds`
    case 1 => `startTs`
    case 2 => `endTs`
    case _ => throw new IndexOutOfBoundsException(n.toString)
  }

  override def productPrefix = "QueryResponse"
}