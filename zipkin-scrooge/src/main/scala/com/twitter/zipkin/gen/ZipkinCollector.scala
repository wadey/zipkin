package com.twitter.zipkin.gen

import com.twitter.conversions.time._
import com.twitter.finagle.SourcedException
import com.twitter.scrooge.{ThriftStruct, ThriftStructCodec}
import com.twitter.util.Future
import java.net.InetSocketAddress
import java.nio.ByteBuffer
import org.apache.thrift.protocol._
import org.apache.thrift.TApplicationException
import scala.collection.mutable
import scala.collection.{Map, Set}
import com.twitter.finagle.{Service => FinagleService}
import com.twitter.finagle.stats.{NullStatsReceiver, StatsReceiver}
import com.twitter.finagle.thrift.ThriftClientRequest
import com.twitter.finagle.{Service => FinagleService}
import java.util.Arrays
import org.apache.thrift.transport.{TMemoryBuffer, TMemoryInputTransport, TTransport}
import com.twitter.finagle.builder.{Server, ServerBuilder}
import com.twitter.finagle.stats.{StatsReceiver, OstrichStatsReceiver}
import com.twitter.finagle.thrift.ThriftServerFramedCodec
import com.twitter.finagle.tracing.{NullTracer, Tracer}
import com.twitter.logging.Logger
import com.twitter.ostrich.admin.Service
import com.twitter.util.Duration
import java.util.concurrent.atomic.AtomicReference


object ZipkinCollector {
  trait Iface extends scribe.Iface {
    @throws(classOf[StoreAggregatesException])
    def storeTopAnnotations(`serviceName`: String, `annotations`: Seq[String] = Seq[String]()): Unit
    @throws(classOf[StoreAggregatesException])
    def storeTopKeyValueAnnotations(`serviceName`: String, `annotations`: Seq[String] = Seq[String]()): Unit
    @throws(classOf[StoreAggregatesException])
    def storeDependencies(`serviceName`: String, `endpoints`: Seq[String] = Seq[String]()): Unit
  }

  trait FutureIface extends scribe.FutureIface {
    def storeTopAnnotations(`serviceName`: String, `annotations`: Seq[String] = Seq[String]()): Future[Unit]
    def storeTopKeyValueAnnotations(`serviceName`: String, `annotations`: Seq[String] = Seq[String]()): Future[Unit]
    def storeDependencies(`serviceName`: String, `endpoints`: Seq[String] = Seq[String]()): Future[Unit]
  }

  object storeTopAnnotations_args extends ThriftStructCodec[storeTopAnnotations_args] {
    val Struct = new TStruct("storeTopAnnotations_args")
    val ServiceNameField = new TField("serviceName", TType.STRING, 1)
    val AnnotationsField = new TField("annotations", TType.LIST, 2)
  
    def encode(_item: storeTopAnnotations_args, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = Immutable.decode(_iprot)
  
    def apply(_iprot: TProtocol): storeTopAnnotations_args = decode(_iprot)
  
    def apply(
      `serviceName`: String,
      `annotations`: Seq[String] = Seq[String]()
    ): storeTopAnnotations_args = new Immutable(
      `serviceName`,
      `annotations`
    )
  
    def unapply(_item: storeTopAnnotations_args): Option[Product2[String, Seq[String]]] = Some(_item)
  
    object Immutable extends ThriftStructCodec[storeTopAnnotations_args] {
      def encode(_item: storeTopAnnotations_args, _oproto: TProtocol) { _item.write(_oproto) }
      def decode(_iprot: TProtocol) = {
        var `serviceName`: String = null
        var _got_serviceName = false
        var `annotations`: Seq[String] = Seq[String]()
        var _got_annotations = false
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
              case 2 => { /* annotations */
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
              case _ => TProtocolUtil.skip(_iprot, _field.`type`)
            }
            _iprot.readFieldEnd()
          }
        }
        _iprot.readStructEnd()
        new Immutable(
          `serviceName`,
          `annotations`
        )
      }
    }
  
    /**
     * The default read-only implementation of storeTopAnnotations_args.  You typically should not need to
     * directly reference this class; instead, use the storeTopAnnotations_args.apply method to construct
     * new instances.
     */
    class Immutable(
      val `serviceName`: String,
      val `annotations`: Seq[String] = Seq[String]()
    ) extends storeTopAnnotations_args
  
  }
  
  trait storeTopAnnotations_args extends ThriftStruct
    with Product2[String, Seq[String]]
    with java.io.Serializable
  {
    import storeTopAnnotations_args._
  
    def `serviceName`: String
    def `annotations`: Seq[String]
  
    def _1 = `serviceName`
    def _2 = `annotations`
  
    override def write(_oprot: TProtocol) {
      validate()
      _oprot.writeStructBegin(Struct)
      if (true) {
        val `serviceName_item` = `serviceName`
        _oprot.writeFieldBegin(ServiceNameField)
        _oprot.writeString(`serviceName_item`)
        _oprot.writeFieldEnd()
      }
      if (true) {
        val `annotations_item` = `annotations`
        _oprot.writeFieldBegin(AnnotationsField)
        _oprot.writeListBegin(new TList(TType.STRING, `annotations_item`.size))
        `annotations_item`.foreach { `_annotations_item_element` =>
          _oprot.writeString(`_annotations_item_element`)
        }
        _oprot.writeListEnd()
        _oprot.writeFieldEnd()
      }
      _oprot.writeFieldStop()
      _oprot.writeStructEnd()
    }
  
    def copy(
      `serviceName`: String = this.`serviceName`,
      `annotations`: Seq[String] = this.`annotations`
    ): storeTopAnnotations_args = new Immutable(
      `serviceName`,
      `annotations`
    )
  
    /**
     * Checks that all required fields are non-null.
     */
    def validate() {
    }
  
    def canEqual(other: Any) = other.isInstanceOf[storeTopAnnotations_args]
  
    override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)
  
    override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)
  
    override def toString: String = runtime.ScalaRunTime._toString(this)
  
    override def productArity = 2
  
    override def productElement(n: Int): Any = n match {
      case 0 => `serviceName`
      case 1 => `annotations`
      case _ => throw new IndexOutOfBoundsException(n.toString)
    }
  
    override def productPrefix = "storeTopAnnotations_args"
  }
  object storeTopAnnotations_result extends ThriftStructCodec[storeTopAnnotations_result] {
    val Struct = new TStruct("storeTopAnnotations_result")
    val EField = new TField("e", TType.STRUCT, 1)
  
    def encode(_item: storeTopAnnotations_result, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = Immutable.decode(_iprot)
  
    def apply(_iprot: TProtocol): storeTopAnnotations_result = decode(_iprot)
  
    def apply(
      `e`: Option[StoreAggregatesException] = None
    ): storeTopAnnotations_result = new Immutable(
      `e`
    )
  
    def unapply(_item: storeTopAnnotations_result): Option[Option[StoreAggregatesException]] = Some(_item.e)
  
    object Immutable extends ThriftStructCodec[storeTopAnnotations_result] {
      def encode(_item: storeTopAnnotations_result, _oproto: TProtocol) { _item.write(_oproto) }
      def decode(_iprot: TProtocol) = {
        var `e`: StoreAggregatesException = null
        var _got_e = false
        var _done = false
        _iprot.readStructBegin()
        while (!_done) {
          val _field = _iprot.readFieldBegin()
          if (_field.`type` == TType.STOP) {
            _done = true
          } else {
            _field.id match {
              case 1 => { /* e */
                _field.`type` match {
                  case TType.STRUCT => {
                    `e` = {
                      StoreAggregatesException.decode(_iprot)
                    }
                    _got_e = true
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
          if (_got_e) Some(`e`) else None
        )
      }
    }
  
    /**
     * The default read-only implementation of storeTopAnnotations_result.  You typically should not need to
     * directly reference this class; instead, use the storeTopAnnotations_result.apply method to construct
     * new instances.
     */
    class Immutable(
      val `e`: Option[StoreAggregatesException] = None
    ) extends storeTopAnnotations_result
  
  }
  
  trait storeTopAnnotations_result extends ThriftStruct
    with Product1[Option[StoreAggregatesException]]
    with java.io.Serializable
  {
    import storeTopAnnotations_result._
  
    def `e`: Option[StoreAggregatesException]
  
    def _1 = `e`
  
    override def write(_oprot: TProtocol) {
      validate()
      _oprot.writeStructBegin(Struct)
      if (`e`.isDefined) {
        val `e_item` = `e`.get
        _oprot.writeFieldBegin(EField)
        `e_item`.write(_oprot)
        _oprot.writeFieldEnd()
      }
      _oprot.writeFieldStop()
      _oprot.writeStructEnd()
    }
  
    def copy(
      `e`: Option[StoreAggregatesException] = this.`e`
    ): storeTopAnnotations_result = new Immutable(
      `e`
    )
  
    /**
     * Checks that all required fields are non-null.
     */
    def validate() {
    }
  
    def canEqual(other: Any) = other.isInstanceOf[storeTopAnnotations_result]
  
    override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)
  
    override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)
  
    override def toString: String = runtime.ScalaRunTime._toString(this)
  
    override def productArity = 1
  
    override def productElement(n: Int): Any = n match {
      case 0 => `e`
      case _ => throw new IndexOutOfBoundsException(n.toString)
    }
  
    override def productPrefix = "storeTopAnnotations_result"
  }
  object storeTopKeyValueAnnotations_args extends ThriftStructCodec[storeTopKeyValueAnnotations_args] {
    val Struct = new TStruct("storeTopKeyValueAnnotations_args")
    val ServiceNameField = new TField("serviceName", TType.STRING, 1)
    val AnnotationsField = new TField("annotations", TType.LIST, 2)
  
    def encode(_item: storeTopKeyValueAnnotations_args, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = Immutable.decode(_iprot)
  
    def apply(_iprot: TProtocol): storeTopKeyValueAnnotations_args = decode(_iprot)
  
    def apply(
      `serviceName`: String,
      `annotations`: Seq[String] = Seq[String]()
    ): storeTopKeyValueAnnotations_args = new Immutable(
      `serviceName`,
      `annotations`
    )
  
    def unapply(_item: storeTopKeyValueAnnotations_args): Option[Product2[String, Seq[String]]] = Some(_item)
  
    object Immutable extends ThriftStructCodec[storeTopKeyValueAnnotations_args] {
      def encode(_item: storeTopKeyValueAnnotations_args, _oproto: TProtocol) { _item.write(_oproto) }
      def decode(_iprot: TProtocol) = {
        var `serviceName`: String = null
        var _got_serviceName = false
        var `annotations`: Seq[String] = Seq[String]()
        var _got_annotations = false
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
              case 2 => { /* annotations */
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
              case _ => TProtocolUtil.skip(_iprot, _field.`type`)
            }
            _iprot.readFieldEnd()
          }
        }
        _iprot.readStructEnd()
        new Immutable(
          `serviceName`,
          `annotations`
        )
      }
    }
  
    /**
     * The default read-only implementation of storeTopKeyValueAnnotations_args.  You typically should not need to
     * directly reference this class; instead, use the storeTopKeyValueAnnotations_args.apply method to construct
     * new instances.
     */
    class Immutable(
      val `serviceName`: String,
      val `annotations`: Seq[String] = Seq[String]()
    ) extends storeTopKeyValueAnnotations_args
  
  }
  
  trait storeTopKeyValueAnnotations_args extends ThriftStruct
    with Product2[String, Seq[String]]
    with java.io.Serializable
  {
    import storeTopKeyValueAnnotations_args._
  
    def `serviceName`: String
    def `annotations`: Seq[String]
  
    def _1 = `serviceName`
    def _2 = `annotations`
  
    override def write(_oprot: TProtocol) {
      validate()
      _oprot.writeStructBegin(Struct)
      if (true) {
        val `serviceName_item` = `serviceName`
        _oprot.writeFieldBegin(ServiceNameField)
        _oprot.writeString(`serviceName_item`)
        _oprot.writeFieldEnd()
      }
      if (true) {
        val `annotations_item` = `annotations`
        _oprot.writeFieldBegin(AnnotationsField)
        _oprot.writeListBegin(new TList(TType.STRING, `annotations_item`.size))
        `annotations_item`.foreach { `_annotations_item_element` =>
          _oprot.writeString(`_annotations_item_element`)
        }
        _oprot.writeListEnd()
        _oprot.writeFieldEnd()
      }
      _oprot.writeFieldStop()
      _oprot.writeStructEnd()
    }
  
    def copy(
      `serviceName`: String = this.`serviceName`,
      `annotations`: Seq[String] = this.`annotations`
    ): storeTopKeyValueAnnotations_args = new Immutable(
      `serviceName`,
      `annotations`
    )
  
    /**
     * Checks that all required fields are non-null.
     */
    def validate() {
    }
  
    def canEqual(other: Any) = other.isInstanceOf[storeTopKeyValueAnnotations_args]
  
    override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)
  
    override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)
  
    override def toString: String = runtime.ScalaRunTime._toString(this)
  
    override def productArity = 2
  
    override def productElement(n: Int): Any = n match {
      case 0 => `serviceName`
      case 1 => `annotations`
      case _ => throw new IndexOutOfBoundsException(n.toString)
    }
  
    override def productPrefix = "storeTopKeyValueAnnotations_args"
  }
  object storeTopKeyValueAnnotations_result extends ThriftStructCodec[storeTopKeyValueAnnotations_result] {
    val Struct = new TStruct("storeTopKeyValueAnnotations_result")
    val EField = new TField("e", TType.STRUCT, 1)
  
    def encode(_item: storeTopKeyValueAnnotations_result, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = Immutable.decode(_iprot)
  
    def apply(_iprot: TProtocol): storeTopKeyValueAnnotations_result = decode(_iprot)
  
    def apply(
      `e`: Option[StoreAggregatesException] = None
    ): storeTopKeyValueAnnotations_result = new Immutable(
      `e`
    )
  
    def unapply(_item: storeTopKeyValueAnnotations_result): Option[Option[StoreAggregatesException]] = Some(_item.e)
  
    object Immutable extends ThriftStructCodec[storeTopKeyValueAnnotations_result] {
      def encode(_item: storeTopKeyValueAnnotations_result, _oproto: TProtocol) { _item.write(_oproto) }
      def decode(_iprot: TProtocol) = {
        var `e`: StoreAggregatesException = null
        var _got_e = false
        var _done = false
        _iprot.readStructBegin()
        while (!_done) {
          val _field = _iprot.readFieldBegin()
          if (_field.`type` == TType.STOP) {
            _done = true
          } else {
            _field.id match {
              case 1 => { /* e */
                _field.`type` match {
                  case TType.STRUCT => {
                    `e` = {
                      StoreAggregatesException.decode(_iprot)
                    }
                    _got_e = true
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
          if (_got_e) Some(`e`) else None
        )
      }
    }
  
    /**
     * The default read-only implementation of storeTopKeyValueAnnotations_result.  You typically should not need to
     * directly reference this class; instead, use the storeTopKeyValueAnnotations_result.apply method to construct
     * new instances.
     */
    class Immutable(
      val `e`: Option[StoreAggregatesException] = None
    ) extends storeTopKeyValueAnnotations_result
  
  }
  
  trait storeTopKeyValueAnnotations_result extends ThriftStruct
    with Product1[Option[StoreAggregatesException]]
    with java.io.Serializable
  {
    import storeTopKeyValueAnnotations_result._
  
    def `e`: Option[StoreAggregatesException]
  
    def _1 = `e`
  
    override def write(_oprot: TProtocol) {
      validate()
      _oprot.writeStructBegin(Struct)
      if (`e`.isDefined) {
        val `e_item` = `e`.get
        _oprot.writeFieldBegin(EField)
        `e_item`.write(_oprot)
        _oprot.writeFieldEnd()
      }
      _oprot.writeFieldStop()
      _oprot.writeStructEnd()
    }
  
    def copy(
      `e`: Option[StoreAggregatesException] = this.`e`
    ): storeTopKeyValueAnnotations_result = new Immutable(
      `e`
    )
  
    /**
     * Checks that all required fields are non-null.
     */
    def validate() {
    }
  
    def canEqual(other: Any) = other.isInstanceOf[storeTopKeyValueAnnotations_result]
  
    override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)
  
    override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)
  
    override def toString: String = runtime.ScalaRunTime._toString(this)
  
    override def productArity = 1
  
    override def productElement(n: Int): Any = n match {
      case 0 => `e`
      case _ => throw new IndexOutOfBoundsException(n.toString)
    }
  
    override def productPrefix = "storeTopKeyValueAnnotations_result"
  }
  object storeDependencies_args extends ThriftStructCodec[storeDependencies_args] {
    val Struct = new TStruct("storeDependencies_args")
    val ServiceNameField = new TField("serviceName", TType.STRING, 1)
    val EndpointsField = new TField("endpoints", TType.LIST, 2)
  
    def encode(_item: storeDependencies_args, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = Immutable.decode(_iprot)
  
    def apply(_iprot: TProtocol): storeDependencies_args = decode(_iprot)
  
    def apply(
      `serviceName`: String,
      `endpoints`: Seq[String] = Seq[String]()
    ): storeDependencies_args = new Immutable(
      `serviceName`,
      `endpoints`
    )
  
    def unapply(_item: storeDependencies_args): Option[Product2[String, Seq[String]]] = Some(_item)
  
    object Immutable extends ThriftStructCodec[storeDependencies_args] {
      def encode(_item: storeDependencies_args, _oproto: TProtocol) { _item.write(_oproto) }
      def decode(_iprot: TProtocol) = {
        var `serviceName`: String = null
        var _got_serviceName = false
        var `endpoints`: Seq[String] = Seq[String]()
        var _got_endpoints = false
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
              case 2 => { /* endpoints */
                _field.`type` match {
                  case TType.LIST => {
                    `endpoints` = {
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
          `serviceName`,
          `endpoints`
        )
      }
    }
  
    /**
     * The default read-only implementation of storeDependencies_args.  You typically should not need to
     * directly reference this class; instead, use the storeDependencies_args.apply method to construct
     * new instances.
     */
    class Immutable(
      val `serviceName`: String,
      val `endpoints`: Seq[String] = Seq[String]()
    ) extends storeDependencies_args
  
  }
  
  trait storeDependencies_args extends ThriftStruct
    with Product2[String, Seq[String]]
    with java.io.Serializable
  {
    import storeDependencies_args._
  
    def `serviceName`: String
    def `endpoints`: Seq[String]
  
    def _1 = `serviceName`
    def _2 = `endpoints`
  
    override def write(_oprot: TProtocol) {
      validate()
      _oprot.writeStructBegin(Struct)
      if (true) {
        val `serviceName_item` = `serviceName`
        _oprot.writeFieldBegin(ServiceNameField)
        _oprot.writeString(`serviceName_item`)
        _oprot.writeFieldEnd()
      }
      if (true) {
        val `endpoints_item` = `endpoints`
        _oprot.writeFieldBegin(EndpointsField)
        _oprot.writeListBegin(new TList(TType.STRING, `endpoints_item`.size))
        `endpoints_item`.foreach { `_endpoints_item_element` =>
          _oprot.writeString(`_endpoints_item_element`)
        }
        _oprot.writeListEnd()
        _oprot.writeFieldEnd()
      }
      _oprot.writeFieldStop()
      _oprot.writeStructEnd()
    }
  
    def copy(
      `serviceName`: String = this.`serviceName`,
      `endpoints`: Seq[String] = this.`endpoints`
    ): storeDependencies_args = new Immutable(
      `serviceName`,
      `endpoints`
    )
  
    /**
     * Checks that all required fields are non-null.
     */
    def validate() {
    }
  
    def canEqual(other: Any) = other.isInstanceOf[storeDependencies_args]
  
    override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)
  
    override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)
  
    override def toString: String = runtime.ScalaRunTime._toString(this)
  
    override def productArity = 2
  
    override def productElement(n: Int): Any = n match {
      case 0 => `serviceName`
      case 1 => `endpoints`
      case _ => throw new IndexOutOfBoundsException(n.toString)
    }
  
    override def productPrefix = "storeDependencies_args"
  }
  object storeDependencies_result extends ThriftStructCodec[storeDependencies_result] {
    val Struct = new TStruct("storeDependencies_result")
    val EField = new TField("e", TType.STRUCT, 1)
  
    def encode(_item: storeDependencies_result, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = Immutable.decode(_iprot)
  
    def apply(_iprot: TProtocol): storeDependencies_result = decode(_iprot)
  
    def apply(
      `e`: Option[StoreAggregatesException] = None
    ): storeDependencies_result = new Immutable(
      `e`
    )
  
    def unapply(_item: storeDependencies_result): Option[Option[StoreAggregatesException]] = Some(_item.e)
  
    object Immutable extends ThriftStructCodec[storeDependencies_result] {
      def encode(_item: storeDependencies_result, _oproto: TProtocol) { _item.write(_oproto) }
      def decode(_iprot: TProtocol) = {
        var `e`: StoreAggregatesException = null
        var _got_e = false
        var _done = false
        _iprot.readStructBegin()
        while (!_done) {
          val _field = _iprot.readFieldBegin()
          if (_field.`type` == TType.STOP) {
            _done = true
          } else {
            _field.id match {
              case 1 => { /* e */
                _field.`type` match {
                  case TType.STRUCT => {
                    `e` = {
                      StoreAggregatesException.decode(_iprot)
                    }
                    _got_e = true
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
          if (_got_e) Some(`e`) else None
        )
      }
    }
  
    /**
     * The default read-only implementation of storeDependencies_result.  You typically should not need to
     * directly reference this class; instead, use the storeDependencies_result.apply method to construct
     * new instances.
     */
    class Immutable(
      val `e`: Option[StoreAggregatesException] = None
    ) extends storeDependencies_result
  
  }
  
  trait storeDependencies_result extends ThriftStruct
    with Product1[Option[StoreAggregatesException]]
    with java.io.Serializable
  {
    import storeDependencies_result._
  
    def `e`: Option[StoreAggregatesException]
  
    def _1 = `e`
  
    override def write(_oprot: TProtocol) {
      validate()
      _oprot.writeStructBegin(Struct)
      if (`e`.isDefined) {
        val `e_item` = `e`.get
        _oprot.writeFieldBegin(EField)
        `e_item`.write(_oprot)
        _oprot.writeFieldEnd()
      }
      _oprot.writeFieldStop()
      _oprot.writeStructEnd()
    }
  
    def copy(
      `e`: Option[StoreAggregatesException] = this.`e`
    ): storeDependencies_result = new Immutable(
      `e`
    )
  
    /**
     * Checks that all required fields are non-null.
     */
    def validate() {
    }
  
    def canEqual(other: Any) = other.isInstanceOf[storeDependencies_result]
  
    override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)
  
    override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)
  
    override def toString: String = runtime.ScalaRunTime._toString(this)
  
    override def productArity = 1
  
    override def productElement(n: Int): Any = n match {
      case 0 => `e`
      case _ => throw new IndexOutOfBoundsException(n.toString)
    }
  
    override def productPrefix = "storeDependencies_result"
  }
  class FinagledClient(
    service: FinagleService[ThriftClientRequest, Array[Byte]],
    protocolFactory: TProtocolFactory = new TBinaryProtocol.Factory,
    serviceName: String = "",
    stats: StatsReceiver = NullStatsReceiver
  ) extends scribe.FinagledClient(service, protocolFactory, serviceName, stats) with FutureIface {
    private[this] val scopedStats = if (serviceName != "") stats.scope(serviceName) else stats
    private[this] object __stats_storeTopAnnotations {
      val RequestsCounter = scopedStats.scope("storeTopAnnotations").counter("requests")
      val SuccessCounter = scopedStats.scope("storeTopAnnotations").counter("success")
      val FailuresCounter = scopedStats.scope("storeTopAnnotations").counter("failures")
      val FailuresScope = scopedStats.scope("storeTopAnnotations").scope("failures")
    }
  
    def storeTopAnnotations(`serviceName`: String, `annotations`: Seq[String] = Seq[String]()): Future[Unit] = {
      __stats_storeTopAnnotations.RequestsCounter.incr()
      this.service(encodeRequest("storeTopAnnotations", storeTopAnnotations_args(serviceName, annotations))) flatMap { response =>
        val result = decodeResponse(response, storeTopAnnotations_result)
        val exception =
          (result.e).map(Future.exception)
        Future.Done
      } rescue {
        case ex: SourcedException => {
          if (this.serviceName != "") { ex.serviceName = this.serviceName }
          Future.exception(ex)
        }
      } onSuccess { _ =>
        __stats_storeTopAnnotations.SuccessCounter.incr()
      } onFailure { ex =>
        __stats_storeTopAnnotations.FailuresCounter.incr()
        __stats_storeTopAnnotations.FailuresScope.counter(ex.getClass.getName).incr()
      }
    }
    private[this] object __stats_storeTopKeyValueAnnotations {
      val RequestsCounter = scopedStats.scope("storeTopKeyValueAnnotations").counter("requests")
      val SuccessCounter = scopedStats.scope("storeTopKeyValueAnnotations").counter("success")
      val FailuresCounter = scopedStats.scope("storeTopKeyValueAnnotations").counter("failures")
      val FailuresScope = scopedStats.scope("storeTopKeyValueAnnotations").scope("failures")
    }
  
    def storeTopKeyValueAnnotations(`serviceName`: String, `annotations`: Seq[String] = Seq[String]()): Future[Unit] = {
      __stats_storeTopKeyValueAnnotations.RequestsCounter.incr()
      this.service(encodeRequest("storeTopKeyValueAnnotations", storeTopKeyValueAnnotations_args(serviceName, annotations))) flatMap { response =>
        val result = decodeResponse(response, storeTopKeyValueAnnotations_result)
        val exception =
          (result.e).map(Future.exception)
        Future.Done
      } rescue {
        case ex: SourcedException => {
          if (this.serviceName != "") { ex.serviceName = this.serviceName }
          Future.exception(ex)
        }
      } onSuccess { _ =>
        __stats_storeTopKeyValueAnnotations.SuccessCounter.incr()
      } onFailure { ex =>
        __stats_storeTopKeyValueAnnotations.FailuresCounter.incr()
        __stats_storeTopKeyValueAnnotations.FailuresScope.counter(ex.getClass.getName).incr()
      }
    }
    private[this] object __stats_storeDependencies {
      val RequestsCounter = scopedStats.scope("storeDependencies").counter("requests")
      val SuccessCounter = scopedStats.scope("storeDependencies").counter("success")
      val FailuresCounter = scopedStats.scope("storeDependencies").counter("failures")
      val FailuresScope = scopedStats.scope("storeDependencies").scope("failures")
    }
  
    def storeDependencies(`serviceName`: String, `endpoints`: Seq[String] = Seq[String]()): Future[Unit] = {
      __stats_storeDependencies.RequestsCounter.incr()
      this.service(encodeRequest("storeDependencies", storeDependencies_args(serviceName, endpoints))) flatMap { response =>
        val result = decodeResponse(response, storeDependencies_result)
        val exception =
          (result.e).map(Future.exception)
        Future.Done
      } rescue {
        case ex: SourcedException => {
          if (this.serviceName != "") { ex.serviceName = this.serviceName }
          Future.exception(ex)
        }
      } onSuccess { _ =>
        __stats_storeDependencies.SuccessCounter.incr()
      } onFailure { ex =>
        __stats_storeDependencies.FailuresCounter.incr()
        __stats_storeDependencies.FailuresScope.counter(ex.getClass.getName).incr()
      }
    }
  }
  class FinagledService(
    iface: FutureIface,
    protocolFactory: TProtocolFactory
  ) extends scribe.FinagledService(iface, protocolFactory) {
    addFunction("storeTopAnnotations", { (iprot: TProtocol, seqid: Int) =>
      try {
        val args = storeTopAnnotations_args.decode(iprot)
        iprot.readMessageEnd()
        (try {
          iface.storeTopAnnotations(args.serviceName, args.annotations)
        } catch {
          case e: Exception => Future.exception(e)
        }) flatMap { value: Unit =>
          reply("storeTopAnnotations", seqid, storeTopAnnotations_result())
        } rescue {
          case e: StoreAggregatesException => {
            reply("storeTopAnnotations", seqid, storeTopAnnotations_result(e = Some(e)))
          }
          case e => Future.exception(e)
        }
      } catch {
        case e: TProtocolException => {
          iprot.readMessageEnd()
          exception("storeTopAnnotations", seqid, TApplicationException.PROTOCOL_ERROR, e.getMessage)
        }
        case e: Exception => Future.exception(e)
      }
    })
    addFunction("storeTopKeyValueAnnotations", { (iprot: TProtocol, seqid: Int) =>
      try {
        val args = storeTopKeyValueAnnotations_args.decode(iprot)
        iprot.readMessageEnd()
        (try {
          iface.storeTopKeyValueAnnotations(args.serviceName, args.annotations)
        } catch {
          case e: Exception => Future.exception(e)
        }) flatMap { value: Unit =>
          reply("storeTopKeyValueAnnotations", seqid, storeTopKeyValueAnnotations_result())
        } rescue {
          case e: StoreAggregatesException => {
            reply("storeTopKeyValueAnnotations", seqid, storeTopKeyValueAnnotations_result(e = Some(e)))
          }
          case e => Future.exception(e)
        }
      } catch {
        case e: TProtocolException => {
          iprot.readMessageEnd()
          exception("storeTopKeyValueAnnotations", seqid, TApplicationException.PROTOCOL_ERROR, e.getMessage)
        }
        case e: Exception => Future.exception(e)
      }
    })
    addFunction("storeDependencies", { (iprot: TProtocol, seqid: Int) =>
      try {
        val args = storeDependencies_args.decode(iprot)
        iprot.readMessageEnd()
        (try {
          iface.storeDependencies(args.serviceName, args.endpoints)
        } catch {
          case e: Exception => Future.exception(e)
        }) flatMap { value: Unit =>
          reply("storeDependencies", seqid, storeDependencies_result())
        } rescue {
          case e: StoreAggregatesException => {
            reply("storeDependencies", seqid, storeDependencies_result(e = Some(e)))
          }
          case e => Future.exception(e)
        }
      } catch {
        case e: TProtocolException => {
          iprot.readMessageEnd()
          exception("storeDependencies", seqid, TApplicationException.PROTOCOL_ERROR, e.getMessage)
        }
        case e: Exception => Future.exception(e)
      }
    })
  }
  trait ThriftServer extends Service with FutureIface {
    val log = Logger.get(getClass)
  
    def thriftCodec = ThriftServerFramedCodec()
    def statsReceiver: StatsReceiver = new OstrichStatsReceiver
    def tracerFactory: Tracer.Factory = NullTracer.factory
    val thriftProtocolFactory: TProtocolFactory = new TBinaryProtocol.Factory()
    val thriftPort: Int
    val serverName: String
  
    // Must be thread-safe as different threads can start and shutdown the service.
    private[this] val _server = new AtomicReference[Server]
    def server: Server = _server.get
  
    def start() {
      val thriftImpl = new FinagledService(this, thriftProtocolFactory)
      _server.set(serverBuilder.build(thriftImpl))
    }
  
    /**
     * You can override this to provide additional configuration
     * to the ServerBuilder.
     */
    def serverBuilder =
      ServerBuilder()
        .codec(thriftCodec)
        .name(serverName)
        .reportTo(statsReceiver)
        .bindTo(new InetSocketAddress(thriftPort))
        .tracerFactory(tracerFactory)
  
    /**
     * Close the underlying server gracefully with the given grace
     * period. close() will drain the current channels, waiting up to
     * ``timeout'', after which channels are forcibly closed.
     */
    def shutdown(timeout: Duration = 0.seconds) {
      synchronized {
        val s = server
        if (s != null) {
          s.close(timeout)
        }
      }
    }
  }
}