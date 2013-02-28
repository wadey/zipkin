package com.twitter.zipkin.gen

import com.twitter.scrooge.{ThriftStruct, ThriftStructCodec}
import org.apache.thrift.protocol._
import java.nio.ByteBuffer
import com.twitter.finagle.SourcedException
import scala.collection.mutable
import scala.collection.{Map, Set}

object Endpoint extends ThriftStructCodec[Endpoint] {
  val Struct = new TStruct("Endpoint")
  val Ipv4Field = new TField("ipv4", TType.I32, 1)
  val PortField = new TField("port", TType.I16, 2)
  val ServiceNameField = new TField("serviceName", TType.STRING, 3)

  def encode(_item: Endpoint, _oproto: TProtocol) { _item.write(_oproto) }
  def decode(_iprot: TProtocol) = Immutable.decode(_iprot)

  def apply(_iprot: TProtocol): Endpoint = decode(_iprot)

  def apply(
    `ipv4`: Int,
    `port`: Short,
    `serviceName`: String
  ): Endpoint = new Immutable(
    `ipv4`,
    `port`,
    `serviceName`
  )

  def unapply(_item: Endpoint): Option[Product3[Int, Short, String]] = Some(_item)

  object Immutable extends ThriftStructCodec[Endpoint] {
    def encode(_item: Endpoint, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = {
      var `ipv4`: Int = 0
      var _got_ipv4 = false
      var `port`: Short = 0
      var _got_port = false
      var `serviceName`: String = null
      var _got_serviceName = false
      var _done = false
      _iprot.readStructBegin()
      while (!_done) {
        val _field = _iprot.readFieldBegin()
        if (_field.`type` == TType.STOP) {
          _done = true
        } else {
          _field.id match {
            case 1 => { /* ipv4 */
              _field.`type` match {
                case TType.I32 => {
                  `ipv4` = {
                    _iprot.readI32()
                  }
                  _got_ipv4 = true
                }
                case _ => TProtocolUtil.skip(_iprot, _field.`type`)
              }
            }
            case 2 => { /* port */
              _field.`type` match {
                case TType.I16 => {
                  `port` = {
                    _iprot.readI16()
                  }
                  _got_port = true
                }
                case _ => TProtocolUtil.skip(_iprot, _field.`type`)
              }
            }
            case 3 => { /* serviceName */
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
            case _ => TProtocolUtil.skip(_iprot, _field.`type`)
          }
          _iprot.readFieldEnd()
        }
      }
      _iprot.readStructEnd()
      new Immutable(
        `ipv4`,
        `port`,
        `serviceName`
      )
    }
  }

  /**
   * The default read-only implementation of Endpoint.  You typically should not need to
   * directly reference this class; instead, use the Endpoint.apply method to construct
   * new instances.
   */
  class Immutable(
    val `ipv4`: Int,
    val `port`: Short,
    val `serviceName`: String
  ) extends Endpoint

  /**
   * This Proxy trait allows you to extend the Endpoint trait with additional state or
   * behavior and implement the read-only methods from Endpoint using an underlying
   * instance.
   */
  trait Proxy extends Endpoint {
    protected def _underlyingEndpoint: Endpoint
    def `ipv4`: Int = _underlyingEndpoint.`ipv4`
    def `port`: Short = _underlyingEndpoint.`port`
    def `serviceName`: String = _underlyingEndpoint.`serviceName`
  }
}

trait Endpoint extends ThriftStruct
  with Product3[Int, Short, String]
  with java.io.Serializable
{
  import Endpoint._

  def `ipv4`: Int
  def `port`: Short
  def `serviceName`: String

  def _1 = `ipv4`
  def _2 = `port`
  def _3 = `serviceName`

  override def write(_oprot: TProtocol) {
    validate()
    _oprot.writeStructBegin(Struct)
    if (true) {
      val `ipv4_item` = `ipv4`
      _oprot.writeFieldBegin(Ipv4Field)
      _oprot.writeI32(`ipv4_item`)
      _oprot.writeFieldEnd()
    }
    if (true) {
      val `port_item` = `port`
      _oprot.writeFieldBegin(PortField)
      _oprot.writeI16(`port_item`)
      _oprot.writeFieldEnd()
    }
    if (true) {
      val `serviceName_item` = `serviceName`
      _oprot.writeFieldBegin(ServiceNameField)
      _oprot.writeString(`serviceName_item`)
      _oprot.writeFieldEnd()
    }
    _oprot.writeFieldStop()
    _oprot.writeStructEnd()
  }

  def copy(
    `ipv4`: Int = this.`ipv4`,
    `port`: Short = this.`port`,
    `serviceName`: String = this.`serviceName`
  ): Endpoint = new Immutable(
    `ipv4`,
    `port`,
    `serviceName`
  )

  /**
   * Checks that all required fields are non-null.
   */
  def validate() {
  }

  def canEqual(other: Any) = other.isInstanceOf[Endpoint]

  override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)

  override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)

  override def toString: String = runtime.ScalaRunTime._toString(this)

  override def productArity = 3

  override def productElement(n: Int): Any = n match {
    case 0 => `ipv4`
    case 1 => `port`
    case 2 => `serviceName`
    case _ => throw new IndexOutOfBoundsException(n.toString)
  }

  override def productPrefix = "Endpoint"
}