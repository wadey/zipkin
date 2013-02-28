package com.twitter.zipkin.gen

import com.twitter.scrooge.{ThriftStruct, ThriftStructCodec}
import org.apache.thrift.protocol._
import java.nio.ByteBuffer
import com.twitter.finagle.SourcedException
import scala.collection.mutable
import scala.collection.{Map, Set}
import com.twitter.zipkin.{gen => _zipkinCore_}

object Trace extends ThriftStructCodec[Trace] {
  val Struct = new TStruct("Trace")
  val SpansField = new TField("spans", TType.LIST, 1)

  def encode(_item: Trace, _oproto: TProtocol) { _item.write(_oproto) }
  def decode(_iprot: TProtocol) = Immutable.decode(_iprot)

  def apply(_iprot: TProtocol): Trace = decode(_iprot)

  def apply(
    `spans`: Seq[_zipkinCore_.Span] = Seq[_zipkinCore_.Span]()
  ): Trace = new Immutable(
    `spans`
  )

  def unapply(_item: Trace): Option[Seq[_zipkinCore_.Span]] = Some(_item.spans)

  object Immutable extends ThriftStructCodec[Trace] {
    def encode(_item: Trace, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = {
      var `spans`: Seq[_zipkinCore_.Span] = Seq[_zipkinCore_.Span]()
      var _got_spans = false
      var _done = false
      _iprot.readStructBegin()
      while (!_done) {
        val _field = _iprot.readFieldBegin()
        if (_field.`type` == TType.STOP) {
          _done = true
        } else {
          _field.id match {
            case 1 => { /* spans */
              _field.`type` match {
                case TType.LIST => {
                  `spans` = {
                    val _list = _iprot.readListBegin()
                    val _rv = new mutable.ArrayBuffer[_zipkinCore_.Span](_list.size)
                    var _i = 0
                    while (_i < _list.size) {
                      _rv += {
                        _zipkinCore_.Span.decode(_iprot)
                      }
                      _i += 1
                    }
                    _iprot.readListEnd()
                    _rv
                  }
                  _got_spans = true
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
        `spans`
      )
    }
  }

  /**
   * The default read-only implementation of Trace.  You typically should not need to
   * directly reference this class; instead, use the Trace.apply method to construct
   * new instances.
   */
  class Immutable(
    val `spans`: Seq[_zipkinCore_.Span] = Seq[_zipkinCore_.Span]()
  ) extends Trace

  /**
   * This Proxy trait allows you to extend the Trace trait with additional state or
   * behavior and implement the read-only methods from Trace using an underlying
   * instance.
   */
  trait Proxy extends Trace {
    protected def _underlyingTrace: Trace
    def `spans`: Seq[_zipkinCore_.Span] = _underlyingTrace.`spans`
  }
}

trait Trace extends ThriftStruct
  with Product1[Seq[_zipkinCore_.Span]]
  with java.io.Serializable
{
  import Trace._

  def `spans`: Seq[_zipkinCore_.Span]

  def _1 = `spans`

  override def write(_oprot: TProtocol) {
    validate()
    _oprot.writeStructBegin(Struct)
    if (true) {
      val `spans_item` = `spans`
      _oprot.writeFieldBegin(SpansField)
      _oprot.writeListBegin(new TList(TType.STRUCT, `spans_item`.size))
      `spans_item`.foreach { `_spans_item_element` =>
        `_spans_item_element`.write(_oprot)
      }
      _oprot.writeListEnd()
      _oprot.writeFieldEnd()
    }
    _oprot.writeFieldStop()
    _oprot.writeStructEnd()
  }

  def copy(
    `spans`: Seq[_zipkinCore_.Span] = this.`spans`
  ): Trace = new Immutable(
    `spans`
  )

  /**
   * Checks that all required fields are non-null.
   */
  def validate() {
  }

  def canEqual(other: Any) = other.isInstanceOf[Trace]

  override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)

  override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)

  override def toString: String = runtime.ScalaRunTime._toString(this)

  override def productArity = 1

  override def productElement(n: Int): Any = n match {
    case 0 => `spans`
    case _ => throw new IndexOutOfBoundsException(n.toString)
  }

  override def productPrefix = "Trace"
}