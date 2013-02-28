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


object ZipkinQuery {
  trait Iface {
    @throws(classOf[QueryException])
    def getTraceIds(`request`: QueryRequest): QueryResponse
    @throws(classOf[QueryException])
    def getTraceIdsBySpanName(`serviceName`: String, `spanName`: String, `endTs`: Long, `limit`: Int, `order`: Order): Seq[Long]
    @throws(classOf[QueryException])
    def getTraceIdsByServiceName(`serviceName`: String, `endTs`: Long, `limit`: Int, `order`: Order): Seq[Long]
    @throws(classOf[QueryException])
    def getTraceIdsByAnnotation(`serviceName`: String, `annotation`: String, `value`: ByteBuffer, `endTs`: Long, `limit`: Int, `order`: Order): Seq[Long]
    @throws(classOf[QueryException])
    def tracesExist(`traceIds`: Seq[Long] = Seq[Long]()): Set[Long]
    @throws(classOf[QueryException])
    def getTracesByIds(`traceIds`: Seq[Long] = Seq[Long](), `adjust`: Seq[Adjust] = Seq[Adjust]()): Seq[Trace]
    @throws(classOf[QueryException])
    def getTraceTimelinesByIds(`traceIds`: Seq[Long] = Seq[Long](), `adjust`: Seq[Adjust] = Seq[Adjust]()): Seq[TraceTimeline]
    @throws(classOf[QueryException])
    def getTraceSummariesByIds(`traceIds`: Seq[Long] = Seq[Long](), `adjust`: Seq[Adjust] = Seq[Adjust]()): Seq[TraceSummary]
    @throws(classOf[QueryException])
    def getTraceCombosByIds(`traceIds`: Seq[Long] = Seq[Long](), `adjust`: Seq[Adjust] = Seq[Adjust]()): Seq[TraceCombo]
    @throws(classOf[QueryException])
    def getServiceNames(): Set[String]
    @throws(classOf[QueryException])
    def getSpanNames(`serviceName`: String): Set[String]
    @throws(classOf[QueryException])
    def setTraceTimeToLive(`traceId`: Long, `ttlSeconds`: Int): Unit
    @throws(classOf[QueryException])
    def getTraceTimeToLive(`traceId`: Long): Int
    @throws(classOf[QueryException])
    def getDataTimeToLive(): Int
    @throws(classOf[QueryException])
    def getDependencies(`serviceName`: String): Seq[String]
    @throws(classOf[QueryException])
    def getTopAnnotations(`serviceName`: String): Seq[String]
    @throws(classOf[QueryException])
    def getTopKeyValueAnnotations(`serviceName`: String): Seq[String]
  }

  trait FutureIface {
    def getTraceIds(`request`: QueryRequest): Future[QueryResponse]
    def getTraceIdsBySpanName(`serviceName`: String, `spanName`: String, `endTs`: Long, `limit`: Int, `order`: Order): Future[Seq[Long]]
    def getTraceIdsByServiceName(`serviceName`: String, `endTs`: Long, `limit`: Int, `order`: Order): Future[Seq[Long]]
    def getTraceIdsByAnnotation(`serviceName`: String, `annotation`: String, `value`: ByteBuffer, `endTs`: Long, `limit`: Int, `order`: Order): Future[Seq[Long]]
    def tracesExist(`traceIds`: Seq[Long] = Seq[Long]()): Future[Set[Long]]
    def getTracesByIds(`traceIds`: Seq[Long] = Seq[Long](), `adjust`: Seq[Adjust] = Seq[Adjust]()): Future[Seq[Trace]]
    def getTraceTimelinesByIds(`traceIds`: Seq[Long] = Seq[Long](), `adjust`: Seq[Adjust] = Seq[Adjust]()): Future[Seq[TraceTimeline]]
    def getTraceSummariesByIds(`traceIds`: Seq[Long] = Seq[Long](), `adjust`: Seq[Adjust] = Seq[Adjust]()): Future[Seq[TraceSummary]]
    def getTraceCombosByIds(`traceIds`: Seq[Long] = Seq[Long](), `adjust`: Seq[Adjust] = Seq[Adjust]()): Future[Seq[TraceCombo]]
    def getServiceNames(): Future[Set[String]]
    def getSpanNames(`serviceName`: String): Future[Set[String]]
    def setTraceTimeToLive(`traceId`: Long, `ttlSeconds`: Int): Future[Unit]
    def getTraceTimeToLive(`traceId`: Long): Future[Int]
    def getDataTimeToLive(): Future[Int]
    def getDependencies(`serviceName`: String): Future[Seq[String]]
    def getTopAnnotations(`serviceName`: String): Future[Seq[String]]
    def getTopKeyValueAnnotations(`serviceName`: String): Future[Seq[String]]
  }

  object getTraceIds_args extends ThriftStructCodec[getTraceIds_args] {
    val Struct = new TStruct("getTraceIds_args")
    val RequestField = new TField("request", TType.STRUCT, 1)
  
    def encode(_item: getTraceIds_args, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = Immutable.decode(_iprot)
  
    def apply(_iprot: TProtocol): getTraceIds_args = decode(_iprot)
  
    def apply(
      `request`: QueryRequest
    ): getTraceIds_args = new Immutable(
      `request`
    )
  
    def unapply(_item: getTraceIds_args): Option[QueryRequest] = Some(_item.request)
  
    object Immutable extends ThriftStructCodec[getTraceIds_args] {
      def encode(_item: getTraceIds_args, _oproto: TProtocol) { _item.write(_oproto) }
      def decode(_iprot: TProtocol) = {
        var `request`: QueryRequest = null
        var _got_request = false
        var _done = false
        _iprot.readStructBegin()
        while (!_done) {
          val _field = _iprot.readFieldBegin()
          if (_field.`type` == TType.STOP) {
            _done = true
          } else {
            _field.id match {
              case 1 => { /* request */
                _field.`type` match {
                  case TType.STRUCT => {
                    `request` = {
                      QueryRequest.decode(_iprot)
                    }
                    _got_request = true
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
          `request`
        )
      }
    }
  
    /**
     * The default read-only implementation of getTraceIds_args.  You typically should not need to
     * directly reference this class; instead, use the getTraceIds_args.apply method to construct
     * new instances.
     */
    class Immutable(
      val `request`: QueryRequest
    ) extends getTraceIds_args
  
  }
  
  trait getTraceIds_args extends ThriftStruct
    with Product1[QueryRequest]
    with java.io.Serializable
  {
    import getTraceIds_args._
  
    def `request`: QueryRequest
  
    def _1 = `request`
  
    override def write(_oprot: TProtocol) {
      validate()
      _oprot.writeStructBegin(Struct)
      if (true) {
        val `request_item` = `request`
        _oprot.writeFieldBegin(RequestField)
        `request_item`.write(_oprot)
        _oprot.writeFieldEnd()
      }
      _oprot.writeFieldStop()
      _oprot.writeStructEnd()
    }
  
    def copy(
      `request`: QueryRequest = this.`request`
    ): getTraceIds_args = new Immutable(
      `request`
    )
  
    /**
     * Checks that all required fields are non-null.
     */
    def validate() {
    }
  
    def canEqual(other: Any) = other.isInstanceOf[getTraceIds_args]
  
    override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)
  
    override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)
  
    override def toString: String = runtime.ScalaRunTime._toString(this)
  
    override def productArity = 1
  
    override def productElement(n: Int): Any = n match {
      case 0 => `request`
      case _ => throw new IndexOutOfBoundsException(n.toString)
    }
  
    override def productPrefix = "getTraceIds_args"
  }
  object getTraceIds_result extends ThriftStructCodec[getTraceIds_result] {
    val Struct = new TStruct("getTraceIds_result")
    val SuccessField = new TField("success", TType.STRUCT, 0)
    val QeField = new TField("qe", TType.STRUCT, 1)
  
    def encode(_item: getTraceIds_result, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = Immutable.decode(_iprot)
  
    def apply(_iprot: TProtocol): getTraceIds_result = decode(_iprot)
  
    def apply(
      `success`: Option[QueryResponse] = None,
      `qe`: Option[QueryException] = None
    ): getTraceIds_result = new Immutable(
      `success`,
      `qe`
    )
  
    def unapply(_item: getTraceIds_result): Option[Product2[Option[QueryResponse], Option[QueryException]]] = Some(_item)
  
    object Immutable extends ThriftStructCodec[getTraceIds_result] {
      def encode(_item: getTraceIds_result, _oproto: TProtocol) { _item.write(_oproto) }
      def decode(_iprot: TProtocol) = {
        var `success`: QueryResponse = null
        var _got_success = false
        var `qe`: QueryException = null
        var _got_qe = false
        var _done = false
        _iprot.readStructBegin()
        while (!_done) {
          val _field = _iprot.readFieldBegin()
          if (_field.`type` == TType.STOP) {
            _done = true
          } else {
            _field.id match {
              case 0 => { /* success */
                _field.`type` match {
                  case TType.STRUCT => {
                    `success` = {
                      QueryResponse.decode(_iprot)
                    }
                    _got_success = true
                  }
                  case _ => TProtocolUtil.skip(_iprot, _field.`type`)
                }
              }
              case 1 => { /* qe */
                _field.`type` match {
                  case TType.STRUCT => {
                    `qe` = {
                      QueryException.decode(_iprot)
                    }
                    _got_qe = true
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
          if (_got_success) Some(`success`) else None,
          if (_got_qe) Some(`qe`) else None
        )
      }
    }
  
    /**
     * The default read-only implementation of getTraceIds_result.  You typically should not need to
     * directly reference this class; instead, use the getTraceIds_result.apply method to construct
     * new instances.
     */
    class Immutable(
      val `success`: Option[QueryResponse] = None,
      val `qe`: Option[QueryException] = None
    ) extends getTraceIds_result
  
  }
  
  trait getTraceIds_result extends ThriftStruct
    with Product2[Option[QueryResponse], Option[QueryException]]
    with java.io.Serializable
  {
    import getTraceIds_result._
  
    def `success`: Option[QueryResponse]
    def `qe`: Option[QueryException]
  
    def _1 = `success`
    def _2 = `qe`
  
    override def write(_oprot: TProtocol) {
      validate()
      _oprot.writeStructBegin(Struct)
      if (`success`.isDefined) {
        val `success_item` = `success`.get
        _oprot.writeFieldBegin(SuccessField)
        `success_item`.write(_oprot)
        _oprot.writeFieldEnd()
      }
      if (`qe`.isDefined) {
        val `qe_item` = `qe`.get
        _oprot.writeFieldBegin(QeField)
        `qe_item`.write(_oprot)
        _oprot.writeFieldEnd()
      }
      _oprot.writeFieldStop()
      _oprot.writeStructEnd()
    }
  
    def copy(
      `success`: Option[QueryResponse] = this.`success`,
      `qe`: Option[QueryException] = this.`qe`
    ): getTraceIds_result = new Immutable(
      `success`,
      `qe`
    )
  
    /**
     * Checks that all required fields are non-null.
     */
    def validate() {
    }
  
    def canEqual(other: Any) = other.isInstanceOf[getTraceIds_result]
  
    override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)
  
    override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)
  
    override def toString: String = runtime.ScalaRunTime._toString(this)
  
    override def productArity = 2
  
    override def productElement(n: Int): Any = n match {
      case 0 => `success`
      case 1 => `qe`
      case _ => throw new IndexOutOfBoundsException(n.toString)
    }
  
    override def productPrefix = "getTraceIds_result"
  }
  object getTraceIdsBySpanName_args extends ThriftStructCodec[getTraceIdsBySpanName_args] {
    val Struct = new TStruct("getTraceIdsBySpanName_args")
    val ServiceNameField = new TField("serviceName", TType.STRING, 1)
    val SpanNameField = new TField("spanName", TType.STRING, 2)
    val EndTsField = new TField("endTs", TType.I64, 4)
    val LimitField = new TField("limit", TType.I32, 5)
    val OrderField = new TField("order", TType.I32, 6)
  
    def encode(_item: getTraceIdsBySpanName_args, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = Immutable.decode(_iprot)
  
    def apply(_iprot: TProtocol): getTraceIdsBySpanName_args = decode(_iprot)
  
    def apply(
      `serviceName`: String,
      `spanName`: String,
      `endTs`: Long,
      `limit`: Int,
      `order`: Order
    ): getTraceIdsBySpanName_args = new Immutable(
      `serviceName`,
      `spanName`,
      `endTs`,
      `limit`,
      `order`
    )
  
    def unapply(_item: getTraceIdsBySpanName_args): Option[Product5[String, String, Long, Int, Order]] = Some(_item)
  
    object Immutable extends ThriftStructCodec[getTraceIdsBySpanName_args] {
      def encode(_item: getTraceIdsBySpanName_args, _oproto: TProtocol) { _item.write(_oproto) }
      def decode(_iprot: TProtocol) = {
        var `serviceName`: String = null
        var _got_serviceName = false
        var `spanName`: String = null
        var _got_spanName = false
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
              case 4 => { /* endTs */
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
              case 5 => { /* limit */
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
              case 6 => { /* order */
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
          `spanName`,
          `endTs`,
          `limit`,
          `order`
        )
      }
    }
  
    /**
     * The default read-only implementation of getTraceIdsBySpanName_args.  You typically should not need to
     * directly reference this class; instead, use the getTraceIdsBySpanName_args.apply method to construct
     * new instances.
     */
    class Immutable(
      val `serviceName`: String,
      val `spanName`: String,
      val `endTs`: Long,
      val `limit`: Int,
      val `order`: Order
    ) extends getTraceIdsBySpanName_args
  
  }
  
  trait getTraceIdsBySpanName_args extends ThriftStruct
    with Product5[String, String, Long, Int, Order]
    with java.io.Serializable
  {
    import getTraceIdsBySpanName_args._
  
    def `serviceName`: String
    def `spanName`: String
    def `endTs`: Long
    def `limit`: Int
    def `order`: Order
  
    def _1 = `serviceName`
    def _2 = `spanName`
    def _3 = `endTs`
    def _4 = `limit`
    def _5 = `order`
  
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
        val `spanName_item` = `spanName`
        _oprot.writeFieldBegin(SpanNameField)
        _oprot.writeString(`spanName_item`)
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
      `spanName`: String = this.`spanName`,
      `endTs`: Long = this.`endTs`,
      `limit`: Int = this.`limit`,
      `order`: Order = this.`order`
    ): getTraceIdsBySpanName_args = new Immutable(
      `serviceName`,
      `spanName`,
      `endTs`,
      `limit`,
      `order`
    )
  
    /**
     * Checks that all required fields are non-null.
     */
    def validate() {
    }
  
    def canEqual(other: Any) = other.isInstanceOf[getTraceIdsBySpanName_args]
  
    override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)
  
    override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)
  
    override def toString: String = runtime.ScalaRunTime._toString(this)
  
    override def productArity = 5
  
    override def productElement(n: Int): Any = n match {
      case 0 => `serviceName`
      case 1 => `spanName`
      case 2 => `endTs`
      case 3 => `limit`
      case 4 => `order`
      case _ => throw new IndexOutOfBoundsException(n.toString)
    }
  
    override def productPrefix = "getTraceIdsBySpanName_args"
  }
  object getTraceIdsBySpanName_result extends ThriftStructCodec[getTraceIdsBySpanName_result] {
    val Struct = new TStruct("getTraceIdsBySpanName_result")
    val SuccessField = new TField("success", TType.LIST, 0)
    val QeField = new TField("qe", TType.STRUCT, 1)
  
    def encode(_item: getTraceIdsBySpanName_result, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = Immutable.decode(_iprot)
  
    def apply(_iprot: TProtocol): getTraceIdsBySpanName_result = decode(_iprot)
  
    def apply(
      `success`: Option[Seq[Long]] = None,
      `qe`: Option[QueryException] = None
    ): getTraceIdsBySpanName_result = new Immutable(
      `success`,
      `qe`
    )
  
    def unapply(_item: getTraceIdsBySpanName_result): Option[Product2[Option[Seq[Long]], Option[QueryException]]] = Some(_item)
  
    object Immutable extends ThriftStructCodec[getTraceIdsBySpanName_result] {
      def encode(_item: getTraceIdsBySpanName_result, _oproto: TProtocol) { _item.write(_oproto) }
      def decode(_iprot: TProtocol) = {
        var `success`: Seq[Long] = Seq[Long]()
        var _got_success = false
        var `qe`: QueryException = null
        var _got_qe = false
        var _done = false
        _iprot.readStructBegin()
        while (!_done) {
          val _field = _iprot.readFieldBegin()
          if (_field.`type` == TType.STOP) {
            _done = true
          } else {
            _field.id match {
              case 0 => { /* success */
                _field.`type` match {
                  case TType.LIST => {
                    `success` = {
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
                    _got_success = true
                  }
                  case _ => TProtocolUtil.skip(_iprot, _field.`type`)
                }
              }
              case 1 => { /* qe */
                _field.`type` match {
                  case TType.STRUCT => {
                    `qe` = {
                      QueryException.decode(_iprot)
                    }
                    _got_qe = true
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
          if (_got_success) Some(`success`) else None,
          if (_got_qe) Some(`qe`) else None
        )
      }
    }
  
    /**
     * The default read-only implementation of getTraceIdsBySpanName_result.  You typically should not need to
     * directly reference this class; instead, use the getTraceIdsBySpanName_result.apply method to construct
     * new instances.
     */
    class Immutable(
      val `success`: Option[Seq[Long]] = None,
      val `qe`: Option[QueryException] = None
    ) extends getTraceIdsBySpanName_result
  
  }
  
  trait getTraceIdsBySpanName_result extends ThriftStruct
    with Product2[Option[Seq[Long]], Option[QueryException]]
    with java.io.Serializable
  {
    import getTraceIdsBySpanName_result._
  
    def `success`: Option[Seq[Long]]
    def `qe`: Option[QueryException]
  
    def _1 = `success`
    def _2 = `qe`
  
    override def write(_oprot: TProtocol) {
      validate()
      _oprot.writeStructBegin(Struct)
      if (`success`.isDefined) {
        val `success_item` = `success`.get
        _oprot.writeFieldBegin(SuccessField)
        _oprot.writeListBegin(new TList(TType.I64, `success_item`.size))
        `success_item`.foreach { `_success_item_element` =>
          _oprot.writeI64(`_success_item_element`)
        }
        _oprot.writeListEnd()
        _oprot.writeFieldEnd()
      }
      if (`qe`.isDefined) {
        val `qe_item` = `qe`.get
        _oprot.writeFieldBegin(QeField)
        `qe_item`.write(_oprot)
        _oprot.writeFieldEnd()
      }
      _oprot.writeFieldStop()
      _oprot.writeStructEnd()
    }
  
    def copy(
      `success`: Option[Seq[Long]] = this.`success`,
      `qe`: Option[QueryException] = this.`qe`
    ): getTraceIdsBySpanName_result = new Immutable(
      `success`,
      `qe`
    )
  
    /**
     * Checks that all required fields are non-null.
     */
    def validate() {
    }
  
    def canEqual(other: Any) = other.isInstanceOf[getTraceIdsBySpanName_result]
  
    override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)
  
    override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)
  
    override def toString: String = runtime.ScalaRunTime._toString(this)
  
    override def productArity = 2
  
    override def productElement(n: Int): Any = n match {
      case 0 => `success`
      case 1 => `qe`
      case _ => throw new IndexOutOfBoundsException(n.toString)
    }
  
    override def productPrefix = "getTraceIdsBySpanName_result"
  }
  object getTraceIdsByServiceName_args extends ThriftStructCodec[getTraceIdsByServiceName_args] {
    val Struct = new TStruct("getTraceIdsByServiceName_args")
    val ServiceNameField = new TField("serviceName", TType.STRING, 1)
    val EndTsField = new TField("endTs", TType.I64, 3)
    val LimitField = new TField("limit", TType.I32, 4)
    val OrderField = new TField("order", TType.I32, 5)
  
    def encode(_item: getTraceIdsByServiceName_args, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = Immutable.decode(_iprot)
  
    def apply(_iprot: TProtocol): getTraceIdsByServiceName_args = decode(_iprot)
  
    def apply(
      `serviceName`: String,
      `endTs`: Long,
      `limit`: Int,
      `order`: Order
    ): getTraceIdsByServiceName_args = new Immutable(
      `serviceName`,
      `endTs`,
      `limit`,
      `order`
    )
  
    def unapply(_item: getTraceIdsByServiceName_args): Option[Product4[String, Long, Int, Order]] = Some(_item)
  
    object Immutable extends ThriftStructCodec[getTraceIdsByServiceName_args] {
      def encode(_item: getTraceIdsByServiceName_args, _oproto: TProtocol) { _item.write(_oproto) }
      def decode(_iprot: TProtocol) = {
        var `serviceName`: String = null
        var _got_serviceName = false
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
              case 4 => { /* limit */
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
              case 5 => { /* order */
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
          `endTs`,
          `limit`,
          `order`
        )
      }
    }
  
    /**
     * The default read-only implementation of getTraceIdsByServiceName_args.  You typically should not need to
     * directly reference this class; instead, use the getTraceIdsByServiceName_args.apply method to construct
     * new instances.
     */
    class Immutable(
      val `serviceName`: String,
      val `endTs`: Long,
      val `limit`: Int,
      val `order`: Order
    ) extends getTraceIdsByServiceName_args
  
  }
  
  trait getTraceIdsByServiceName_args extends ThriftStruct
    with Product4[String, Long, Int, Order]
    with java.io.Serializable
  {
    import getTraceIdsByServiceName_args._
  
    def `serviceName`: String
    def `endTs`: Long
    def `limit`: Int
    def `order`: Order
  
    def _1 = `serviceName`
    def _2 = `endTs`
    def _3 = `limit`
    def _4 = `order`
  
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
      `endTs`: Long = this.`endTs`,
      `limit`: Int = this.`limit`,
      `order`: Order = this.`order`
    ): getTraceIdsByServiceName_args = new Immutable(
      `serviceName`,
      `endTs`,
      `limit`,
      `order`
    )
  
    /**
     * Checks that all required fields are non-null.
     */
    def validate() {
    }
  
    def canEqual(other: Any) = other.isInstanceOf[getTraceIdsByServiceName_args]
  
    override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)
  
    override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)
  
    override def toString: String = runtime.ScalaRunTime._toString(this)
  
    override def productArity = 4
  
    override def productElement(n: Int): Any = n match {
      case 0 => `serviceName`
      case 1 => `endTs`
      case 2 => `limit`
      case 3 => `order`
      case _ => throw new IndexOutOfBoundsException(n.toString)
    }
  
    override def productPrefix = "getTraceIdsByServiceName_args"
  }
  object getTraceIdsByServiceName_result extends ThriftStructCodec[getTraceIdsByServiceName_result] {
    val Struct = new TStruct("getTraceIdsByServiceName_result")
    val SuccessField = new TField("success", TType.LIST, 0)
    val QeField = new TField("qe", TType.STRUCT, 1)
  
    def encode(_item: getTraceIdsByServiceName_result, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = Immutable.decode(_iprot)
  
    def apply(_iprot: TProtocol): getTraceIdsByServiceName_result = decode(_iprot)
  
    def apply(
      `success`: Option[Seq[Long]] = None,
      `qe`: Option[QueryException] = None
    ): getTraceIdsByServiceName_result = new Immutable(
      `success`,
      `qe`
    )
  
    def unapply(_item: getTraceIdsByServiceName_result): Option[Product2[Option[Seq[Long]], Option[QueryException]]] = Some(_item)
  
    object Immutable extends ThriftStructCodec[getTraceIdsByServiceName_result] {
      def encode(_item: getTraceIdsByServiceName_result, _oproto: TProtocol) { _item.write(_oproto) }
      def decode(_iprot: TProtocol) = {
        var `success`: Seq[Long] = Seq[Long]()
        var _got_success = false
        var `qe`: QueryException = null
        var _got_qe = false
        var _done = false
        _iprot.readStructBegin()
        while (!_done) {
          val _field = _iprot.readFieldBegin()
          if (_field.`type` == TType.STOP) {
            _done = true
          } else {
            _field.id match {
              case 0 => { /* success */
                _field.`type` match {
                  case TType.LIST => {
                    `success` = {
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
                    _got_success = true
                  }
                  case _ => TProtocolUtil.skip(_iprot, _field.`type`)
                }
              }
              case 1 => { /* qe */
                _field.`type` match {
                  case TType.STRUCT => {
                    `qe` = {
                      QueryException.decode(_iprot)
                    }
                    _got_qe = true
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
          if (_got_success) Some(`success`) else None,
          if (_got_qe) Some(`qe`) else None
        )
      }
    }
  
    /**
     * The default read-only implementation of getTraceIdsByServiceName_result.  You typically should not need to
     * directly reference this class; instead, use the getTraceIdsByServiceName_result.apply method to construct
     * new instances.
     */
    class Immutable(
      val `success`: Option[Seq[Long]] = None,
      val `qe`: Option[QueryException] = None
    ) extends getTraceIdsByServiceName_result
  
  }
  
  trait getTraceIdsByServiceName_result extends ThriftStruct
    with Product2[Option[Seq[Long]], Option[QueryException]]
    with java.io.Serializable
  {
    import getTraceIdsByServiceName_result._
  
    def `success`: Option[Seq[Long]]
    def `qe`: Option[QueryException]
  
    def _1 = `success`
    def _2 = `qe`
  
    override def write(_oprot: TProtocol) {
      validate()
      _oprot.writeStructBegin(Struct)
      if (`success`.isDefined) {
        val `success_item` = `success`.get
        _oprot.writeFieldBegin(SuccessField)
        _oprot.writeListBegin(new TList(TType.I64, `success_item`.size))
        `success_item`.foreach { `_success_item_element` =>
          _oprot.writeI64(`_success_item_element`)
        }
        _oprot.writeListEnd()
        _oprot.writeFieldEnd()
      }
      if (`qe`.isDefined) {
        val `qe_item` = `qe`.get
        _oprot.writeFieldBegin(QeField)
        `qe_item`.write(_oprot)
        _oprot.writeFieldEnd()
      }
      _oprot.writeFieldStop()
      _oprot.writeStructEnd()
    }
  
    def copy(
      `success`: Option[Seq[Long]] = this.`success`,
      `qe`: Option[QueryException] = this.`qe`
    ): getTraceIdsByServiceName_result = new Immutable(
      `success`,
      `qe`
    )
  
    /**
     * Checks that all required fields are non-null.
     */
    def validate() {
    }
  
    def canEqual(other: Any) = other.isInstanceOf[getTraceIdsByServiceName_result]
  
    override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)
  
    override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)
  
    override def toString: String = runtime.ScalaRunTime._toString(this)
  
    override def productArity = 2
  
    override def productElement(n: Int): Any = n match {
      case 0 => `success`
      case 1 => `qe`
      case _ => throw new IndexOutOfBoundsException(n.toString)
    }
  
    override def productPrefix = "getTraceIdsByServiceName_result"
  }
  object getTraceIdsByAnnotation_args extends ThriftStructCodec[getTraceIdsByAnnotation_args] {
    val Struct = new TStruct("getTraceIdsByAnnotation_args")
    val ServiceNameField = new TField("serviceName", TType.STRING, 1)
    val AnnotationField = new TField("annotation", TType.STRING, 2)
    val ValueField = new TField("value", TType.STRING, 3)
    val EndTsField = new TField("endTs", TType.I64, 5)
    val LimitField = new TField("limit", TType.I32, 6)
    val OrderField = new TField("order", TType.I32, 7)
  
    def encode(_item: getTraceIdsByAnnotation_args, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = Immutable.decode(_iprot)
  
    def apply(_iprot: TProtocol): getTraceIdsByAnnotation_args = decode(_iprot)
  
    def apply(
      `serviceName`: String,
      `annotation`: String,
      `value`: ByteBuffer,
      `endTs`: Long,
      `limit`: Int,
      `order`: Order
    ): getTraceIdsByAnnotation_args = new Immutable(
      `serviceName`,
      `annotation`,
      `value`,
      `endTs`,
      `limit`,
      `order`
    )
  
    def unapply(_item: getTraceIdsByAnnotation_args): Option[Product6[String, String, ByteBuffer, Long, Int, Order]] = Some(_item)
  
    object Immutable extends ThriftStructCodec[getTraceIdsByAnnotation_args] {
      def encode(_item: getTraceIdsByAnnotation_args, _oproto: TProtocol) { _item.write(_oproto) }
      def decode(_iprot: TProtocol) = {
        var `serviceName`: String = null
        var _got_serviceName = false
        var `annotation`: String = null
        var _got_annotation = false
        var `value`: ByteBuffer = null
        var _got_value = false
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
              case 2 => { /* annotation */
                _field.`type` match {
                  case TType.STRING => {
                    `annotation` = {
                      _iprot.readString()
                    }
                    _got_annotation = true
                  }
                  case _ => TProtocolUtil.skip(_iprot, _field.`type`)
                }
              }
              case 3 => { /* value */
                _field.`type` match {
                  case TType.STRING => {
                    `value` = {
                      _iprot.readBinary()
                    }
                    _got_value = true
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
          `annotation`,
          `value`,
          `endTs`,
          `limit`,
          `order`
        )
      }
    }
  
    /**
     * The default read-only implementation of getTraceIdsByAnnotation_args.  You typically should not need to
     * directly reference this class; instead, use the getTraceIdsByAnnotation_args.apply method to construct
     * new instances.
     */
    class Immutable(
      val `serviceName`: String,
      val `annotation`: String,
      val `value`: ByteBuffer,
      val `endTs`: Long,
      val `limit`: Int,
      val `order`: Order
    ) extends getTraceIdsByAnnotation_args
  
  }
  
  trait getTraceIdsByAnnotation_args extends ThriftStruct
    with Product6[String, String, ByteBuffer, Long, Int, Order]
    with java.io.Serializable
  {
    import getTraceIdsByAnnotation_args._
  
    def `serviceName`: String
    def `annotation`: String
    def `value`: ByteBuffer
    def `endTs`: Long
    def `limit`: Int
    def `order`: Order
  
    def _1 = `serviceName`
    def _2 = `annotation`
    def _3 = `value`
    def _4 = `endTs`
    def _5 = `limit`
    def _6 = `order`
  
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
        val `annotation_item` = `annotation`
        _oprot.writeFieldBegin(AnnotationField)
        _oprot.writeString(`annotation_item`)
        _oprot.writeFieldEnd()
      }
      if (true) {
        val `value_item` = `value`
        _oprot.writeFieldBegin(ValueField)
        _oprot.writeBinary(`value_item`)
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
      `annotation`: String = this.`annotation`,
      `value`: ByteBuffer = this.`value`,
      `endTs`: Long = this.`endTs`,
      `limit`: Int = this.`limit`,
      `order`: Order = this.`order`
    ): getTraceIdsByAnnotation_args = new Immutable(
      `serviceName`,
      `annotation`,
      `value`,
      `endTs`,
      `limit`,
      `order`
    )
  
    /**
     * Checks that all required fields are non-null.
     */
    def validate() {
    }
  
    def canEqual(other: Any) = other.isInstanceOf[getTraceIdsByAnnotation_args]
  
    override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)
  
    override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)
  
    override def toString: String = runtime.ScalaRunTime._toString(this)
  
    override def productArity = 6
  
    override def productElement(n: Int): Any = n match {
      case 0 => `serviceName`
      case 1 => `annotation`
      case 2 => `value`
      case 3 => `endTs`
      case 4 => `limit`
      case 5 => `order`
      case _ => throw new IndexOutOfBoundsException(n.toString)
    }
  
    override def productPrefix = "getTraceIdsByAnnotation_args"
  }
  object getTraceIdsByAnnotation_result extends ThriftStructCodec[getTraceIdsByAnnotation_result] {
    val Struct = new TStruct("getTraceIdsByAnnotation_result")
    val SuccessField = new TField("success", TType.LIST, 0)
    val QeField = new TField("qe", TType.STRUCT, 1)
  
    def encode(_item: getTraceIdsByAnnotation_result, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = Immutable.decode(_iprot)
  
    def apply(_iprot: TProtocol): getTraceIdsByAnnotation_result = decode(_iprot)
  
    def apply(
      `success`: Option[Seq[Long]] = None,
      `qe`: Option[QueryException] = None
    ): getTraceIdsByAnnotation_result = new Immutable(
      `success`,
      `qe`
    )
  
    def unapply(_item: getTraceIdsByAnnotation_result): Option[Product2[Option[Seq[Long]], Option[QueryException]]] = Some(_item)
  
    object Immutable extends ThriftStructCodec[getTraceIdsByAnnotation_result] {
      def encode(_item: getTraceIdsByAnnotation_result, _oproto: TProtocol) { _item.write(_oproto) }
      def decode(_iprot: TProtocol) = {
        var `success`: Seq[Long] = Seq[Long]()
        var _got_success = false
        var `qe`: QueryException = null
        var _got_qe = false
        var _done = false
        _iprot.readStructBegin()
        while (!_done) {
          val _field = _iprot.readFieldBegin()
          if (_field.`type` == TType.STOP) {
            _done = true
          } else {
            _field.id match {
              case 0 => { /* success */
                _field.`type` match {
                  case TType.LIST => {
                    `success` = {
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
                    _got_success = true
                  }
                  case _ => TProtocolUtil.skip(_iprot, _field.`type`)
                }
              }
              case 1 => { /* qe */
                _field.`type` match {
                  case TType.STRUCT => {
                    `qe` = {
                      QueryException.decode(_iprot)
                    }
                    _got_qe = true
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
          if (_got_success) Some(`success`) else None,
          if (_got_qe) Some(`qe`) else None
        )
      }
    }
  
    /**
     * The default read-only implementation of getTraceIdsByAnnotation_result.  You typically should not need to
     * directly reference this class; instead, use the getTraceIdsByAnnotation_result.apply method to construct
     * new instances.
     */
    class Immutable(
      val `success`: Option[Seq[Long]] = None,
      val `qe`: Option[QueryException] = None
    ) extends getTraceIdsByAnnotation_result
  
  }
  
  trait getTraceIdsByAnnotation_result extends ThriftStruct
    with Product2[Option[Seq[Long]], Option[QueryException]]
    with java.io.Serializable
  {
    import getTraceIdsByAnnotation_result._
  
    def `success`: Option[Seq[Long]]
    def `qe`: Option[QueryException]
  
    def _1 = `success`
    def _2 = `qe`
  
    override def write(_oprot: TProtocol) {
      validate()
      _oprot.writeStructBegin(Struct)
      if (`success`.isDefined) {
        val `success_item` = `success`.get
        _oprot.writeFieldBegin(SuccessField)
        _oprot.writeListBegin(new TList(TType.I64, `success_item`.size))
        `success_item`.foreach { `_success_item_element` =>
          _oprot.writeI64(`_success_item_element`)
        }
        _oprot.writeListEnd()
        _oprot.writeFieldEnd()
      }
      if (`qe`.isDefined) {
        val `qe_item` = `qe`.get
        _oprot.writeFieldBegin(QeField)
        `qe_item`.write(_oprot)
        _oprot.writeFieldEnd()
      }
      _oprot.writeFieldStop()
      _oprot.writeStructEnd()
    }
  
    def copy(
      `success`: Option[Seq[Long]] = this.`success`,
      `qe`: Option[QueryException] = this.`qe`
    ): getTraceIdsByAnnotation_result = new Immutable(
      `success`,
      `qe`
    )
  
    /**
     * Checks that all required fields are non-null.
     */
    def validate() {
    }
  
    def canEqual(other: Any) = other.isInstanceOf[getTraceIdsByAnnotation_result]
  
    override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)
  
    override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)
  
    override def toString: String = runtime.ScalaRunTime._toString(this)
  
    override def productArity = 2
  
    override def productElement(n: Int): Any = n match {
      case 0 => `success`
      case 1 => `qe`
      case _ => throw new IndexOutOfBoundsException(n.toString)
    }
  
    override def productPrefix = "getTraceIdsByAnnotation_result"
  }
  object tracesExist_args extends ThriftStructCodec[tracesExist_args] {
    val Struct = new TStruct("tracesExist_args")
    val TraceIdsField = new TField("traceIds", TType.LIST, 1)
  
    def encode(_item: tracesExist_args, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = Immutable.decode(_iprot)
  
    def apply(_iprot: TProtocol): tracesExist_args = decode(_iprot)
  
    def apply(
      `traceIds`: Seq[Long] = Seq[Long]()
    ): tracesExist_args = new Immutable(
      `traceIds`
    )
  
    def unapply(_item: tracesExist_args): Option[Seq[Long]] = Some(_item.traceIds)
  
    object Immutable extends ThriftStructCodec[tracesExist_args] {
      def encode(_item: tracesExist_args, _oproto: TProtocol) { _item.write(_oproto) }
      def decode(_iprot: TProtocol) = {
        var `traceIds`: Seq[Long] = Seq[Long]()
        var _got_traceIds = false
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
              case _ => TProtocolUtil.skip(_iprot, _field.`type`)
            }
            _iprot.readFieldEnd()
          }
        }
        _iprot.readStructEnd()
        new Immutable(
          `traceIds`
        )
      }
    }
  
    /**
     * The default read-only implementation of tracesExist_args.  You typically should not need to
     * directly reference this class; instead, use the tracesExist_args.apply method to construct
     * new instances.
     */
    class Immutable(
      val `traceIds`: Seq[Long] = Seq[Long]()
    ) extends tracesExist_args
  
  }
  
  trait tracesExist_args extends ThriftStruct
    with Product1[Seq[Long]]
    with java.io.Serializable
  {
    import tracesExist_args._
  
    def `traceIds`: Seq[Long]
  
    def _1 = `traceIds`
  
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
      _oprot.writeFieldStop()
      _oprot.writeStructEnd()
    }
  
    def copy(
      `traceIds`: Seq[Long] = this.`traceIds`
    ): tracesExist_args = new Immutable(
      `traceIds`
    )
  
    /**
     * Checks that all required fields are non-null.
     */
    def validate() {
    }
  
    def canEqual(other: Any) = other.isInstanceOf[tracesExist_args]
  
    override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)
  
    override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)
  
    override def toString: String = runtime.ScalaRunTime._toString(this)
  
    override def productArity = 1
  
    override def productElement(n: Int): Any = n match {
      case 0 => `traceIds`
      case _ => throw new IndexOutOfBoundsException(n.toString)
    }
  
    override def productPrefix = "tracesExist_args"
  }
  object tracesExist_result extends ThriftStructCodec[tracesExist_result] {
    val Struct = new TStruct("tracesExist_result")
    val SuccessField = new TField("success", TType.SET, 0)
    val QeField = new TField("qe", TType.STRUCT, 1)
  
    def encode(_item: tracesExist_result, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = Immutable.decode(_iprot)
  
    def apply(_iprot: TProtocol): tracesExist_result = decode(_iprot)
  
    def apply(
      `success`: Option[Set[Long]] = None,
      `qe`: Option[QueryException] = None
    ): tracesExist_result = new Immutable(
      `success`,
      `qe`
    )
  
    def unapply(_item: tracesExist_result): Option[Product2[Option[Set[Long]], Option[QueryException]]] = Some(_item)
  
    object Immutable extends ThriftStructCodec[tracesExist_result] {
      def encode(_item: tracesExist_result, _oproto: TProtocol) { _item.write(_oproto) }
      def decode(_iprot: TProtocol) = {
        var `success`: Set[Long] = Set[Long]()
        var _got_success = false
        var `qe`: QueryException = null
        var _got_qe = false
        var _done = false
        _iprot.readStructBegin()
        while (!_done) {
          val _field = _iprot.readFieldBegin()
          if (_field.`type` == TType.STOP) {
            _done = true
          } else {
            _field.id match {
              case 0 => { /* success */
                _field.`type` match {
                  case TType.SET => {
                    `success` = {
                      val _set = _iprot.readSetBegin()
                      val _rv = new mutable.HashSet[Long]
                      var _i = 0
                      while (_i < _set.size) {
                        _rv += {
                          _iprot.readI64()
                        }
                        _i += 1
                      }
                      _iprot.readSetEnd()
                      _rv
                    }
                    _got_success = true
                  }
                  case _ => TProtocolUtil.skip(_iprot, _field.`type`)
                }
              }
              case 1 => { /* qe */
                _field.`type` match {
                  case TType.STRUCT => {
                    `qe` = {
                      QueryException.decode(_iprot)
                    }
                    _got_qe = true
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
          if (_got_success) Some(`success`) else None,
          if (_got_qe) Some(`qe`) else None
        )
      }
    }
  
    /**
     * The default read-only implementation of tracesExist_result.  You typically should not need to
     * directly reference this class; instead, use the tracesExist_result.apply method to construct
     * new instances.
     */
    class Immutable(
      val `success`: Option[Set[Long]] = None,
      val `qe`: Option[QueryException] = None
    ) extends tracesExist_result
  
  }
  
  trait tracesExist_result extends ThriftStruct
    with Product2[Option[Set[Long]], Option[QueryException]]
    with java.io.Serializable
  {
    import tracesExist_result._
  
    def `success`: Option[Set[Long]]
    def `qe`: Option[QueryException]
  
    def _1 = `success`
    def _2 = `qe`
  
    override def write(_oprot: TProtocol) {
      validate()
      _oprot.writeStructBegin(Struct)
      if (`success`.isDefined) {
        val `success_item` = `success`.get
        _oprot.writeFieldBegin(SuccessField)
        _oprot.writeSetBegin(new TSet(TType.I64, `success_item`.size))
        `success_item`.foreach { `_success_item_element` =>
          _oprot.writeI64(`_success_item_element`)
        }
        _oprot.writeSetEnd()
        _oprot.writeFieldEnd()
      }
      if (`qe`.isDefined) {
        val `qe_item` = `qe`.get
        _oprot.writeFieldBegin(QeField)
        `qe_item`.write(_oprot)
        _oprot.writeFieldEnd()
      }
      _oprot.writeFieldStop()
      _oprot.writeStructEnd()
    }
  
    def copy(
      `success`: Option[Set[Long]] = this.`success`,
      `qe`: Option[QueryException] = this.`qe`
    ): tracesExist_result = new Immutable(
      `success`,
      `qe`
    )
  
    /**
     * Checks that all required fields are non-null.
     */
    def validate() {
    }
  
    def canEqual(other: Any) = other.isInstanceOf[tracesExist_result]
  
    override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)
  
    override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)
  
    override def toString: String = runtime.ScalaRunTime._toString(this)
  
    override def productArity = 2
  
    override def productElement(n: Int): Any = n match {
      case 0 => `success`
      case 1 => `qe`
      case _ => throw new IndexOutOfBoundsException(n.toString)
    }
  
    override def productPrefix = "tracesExist_result"
  }
  object getTracesByIds_args extends ThriftStructCodec[getTracesByIds_args] {
    val Struct = new TStruct("getTracesByIds_args")
    val TraceIdsField = new TField("traceIds", TType.LIST, 1)
    val AdjustField = new TField("adjust", TType.LIST, 2)
  
    def encode(_item: getTracesByIds_args, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = Immutable.decode(_iprot)
  
    def apply(_iprot: TProtocol): getTracesByIds_args = decode(_iprot)
  
    def apply(
      `traceIds`: Seq[Long] = Seq[Long](),
      `adjust`: Seq[Adjust] = Seq[Adjust]()
    ): getTracesByIds_args = new Immutable(
      `traceIds`,
      `adjust`
    )
  
    def unapply(_item: getTracesByIds_args): Option[Product2[Seq[Long], Seq[Adjust]]] = Some(_item)
  
    object Immutable extends ThriftStructCodec[getTracesByIds_args] {
      def encode(_item: getTracesByIds_args, _oproto: TProtocol) { _item.write(_oproto) }
      def decode(_iprot: TProtocol) = {
        var `traceIds`: Seq[Long] = Seq[Long]()
        var _got_traceIds = false
        var `adjust`: Seq[Adjust] = Seq[Adjust]()
        var _got_adjust = false
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
              case 2 => { /* adjust */
                _field.`type` match {
                  case TType.LIST => {
                    `adjust` = {
                      val _list = _iprot.readListBegin()
                      val _rv = new mutable.ArrayBuffer[Adjust](_list.size)
                      var _i = 0
                      while (_i < _list.size) {
                        _rv += {
                          Adjust(_iprot.readI32())
                        }
                        _i += 1
                      }
                      _iprot.readListEnd()
                      _rv
                    }
                    _got_adjust = true
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
          `adjust`
        )
      }
    }
  
    /**
     * The default read-only implementation of getTracesByIds_args.  You typically should not need to
     * directly reference this class; instead, use the getTracesByIds_args.apply method to construct
     * new instances.
     */
    class Immutable(
      val `traceIds`: Seq[Long] = Seq[Long](),
      val `adjust`: Seq[Adjust] = Seq[Adjust]()
    ) extends getTracesByIds_args
  
  }
  
  trait getTracesByIds_args extends ThriftStruct
    with Product2[Seq[Long], Seq[Adjust]]
    with java.io.Serializable
  {
    import getTracesByIds_args._
  
    def `traceIds`: Seq[Long]
    def `adjust`: Seq[Adjust]
  
    def _1 = `traceIds`
    def _2 = `adjust`
  
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
        val `adjust_item` = `adjust`
        _oprot.writeFieldBegin(AdjustField)
        _oprot.writeListBegin(new TList(TType.I32, `adjust_item`.size))
        `adjust_item`.foreach { `_adjust_item_element` =>
          _oprot.writeI32(`_adjust_item_element`.value)
        }
        _oprot.writeListEnd()
        _oprot.writeFieldEnd()
      }
      _oprot.writeFieldStop()
      _oprot.writeStructEnd()
    }
  
    def copy(
      `traceIds`: Seq[Long] = this.`traceIds`,
      `adjust`: Seq[Adjust] = this.`adjust`
    ): getTracesByIds_args = new Immutable(
      `traceIds`,
      `adjust`
    )
  
    /**
     * Checks that all required fields are non-null.
     */
    def validate() {
    }
  
    def canEqual(other: Any) = other.isInstanceOf[getTracesByIds_args]
  
    override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)
  
    override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)
  
    override def toString: String = runtime.ScalaRunTime._toString(this)
  
    override def productArity = 2
  
    override def productElement(n: Int): Any = n match {
      case 0 => `traceIds`
      case 1 => `adjust`
      case _ => throw new IndexOutOfBoundsException(n.toString)
    }
  
    override def productPrefix = "getTracesByIds_args"
  }
  object getTracesByIds_result extends ThriftStructCodec[getTracesByIds_result] {
    val Struct = new TStruct("getTracesByIds_result")
    val SuccessField = new TField("success", TType.LIST, 0)
    val QeField = new TField("qe", TType.STRUCT, 1)
  
    def encode(_item: getTracesByIds_result, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = Immutable.decode(_iprot)
  
    def apply(_iprot: TProtocol): getTracesByIds_result = decode(_iprot)
  
    def apply(
      `success`: Option[Seq[Trace]] = None,
      `qe`: Option[QueryException] = None
    ): getTracesByIds_result = new Immutable(
      `success`,
      `qe`
    )
  
    def unapply(_item: getTracesByIds_result): Option[Product2[Option[Seq[Trace]], Option[QueryException]]] = Some(_item)
  
    object Immutable extends ThriftStructCodec[getTracesByIds_result] {
      def encode(_item: getTracesByIds_result, _oproto: TProtocol) { _item.write(_oproto) }
      def decode(_iprot: TProtocol) = {
        var `success`: Seq[Trace] = Seq[Trace]()
        var _got_success = false
        var `qe`: QueryException = null
        var _got_qe = false
        var _done = false
        _iprot.readStructBegin()
        while (!_done) {
          val _field = _iprot.readFieldBegin()
          if (_field.`type` == TType.STOP) {
            _done = true
          } else {
            _field.id match {
              case 0 => { /* success */
                _field.`type` match {
                  case TType.LIST => {
                    `success` = {
                      val _list = _iprot.readListBegin()
                      val _rv = new mutable.ArrayBuffer[Trace](_list.size)
                      var _i = 0
                      while (_i < _list.size) {
                        _rv += {
                          Trace.decode(_iprot)
                        }
                        _i += 1
                      }
                      _iprot.readListEnd()
                      _rv
                    }
                    _got_success = true
                  }
                  case _ => TProtocolUtil.skip(_iprot, _field.`type`)
                }
              }
              case 1 => { /* qe */
                _field.`type` match {
                  case TType.STRUCT => {
                    `qe` = {
                      QueryException.decode(_iprot)
                    }
                    _got_qe = true
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
          if (_got_success) Some(`success`) else None,
          if (_got_qe) Some(`qe`) else None
        )
      }
    }
  
    /**
     * The default read-only implementation of getTracesByIds_result.  You typically should not need to
     * directly reference this class; instead, use the getTracesByIds_result.apply method to construct
     * new instances.
     */
    class Immutable(
      val `success`: Option[Seq[Trace]] = None,
      val `qe`: Option[QueryException] = None
    ) extends getTracesByIds_result
  
  }
  
  trait getTracesByIds_result extends ThriftStruct
    with Product2[Option[Seq[Trace]], Option[QueryException]]
    with java.io.Serializable
  {
    import getTracesByIds_result._
  
    def `success`: Option[Seq[Trace]]
    def `qe`: Option[QueryException]
  
    def _1 = `success`
    def _2 = `qe`
  
    override def write(_oprot: TProtocol) {
      validate()
      _oprot.writeStructBegin(Struct)
      if (`success`.isDefined) {
        val `success_item` = `success`.get
        _oprot.writeFieldBegin(SuccessField)
        _oprot.writeListBegin(new TList(TType.STRUCT, `success_item`.size))
        `success_item`.foreach { `_success_item_element` =>
          `_success_item_element`.write(_oprot)
        }
        _oprot.writeListEnd()
        _oprot.writeFieldEnd()
      }
      if (`qe`.isDefined) {
        val `qe_item` = `qe`.get
        _oprot.writeFieldBegin(QeField)
        `qe_item`.write(_oprot)
        _oprot.writeFieldEnd()
      }
      _oprot.writeFieldStop()
      _oprot.writeStructEnd()
    }
  
    def copy(
      `success`: Option[Seq[Trace]] = this.`success`,
      `qe`: Option[QueryException] = this.`qe`
    ): getTracesByIds_result = new Immutable(
      `success`,
      `qe`
    )
  
    /**
     * Checks that all required fields are non-null.
     */
    def validate() {
    }
  
    def canEqual(other: Any) = other.isInstanceOf[getTracesByIds_result]
  
    override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)
  
    override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)
  
    override def toString: String = runtime.ScalaRunTime._toString(this)
  
    override def productArity = 2
  
    override def productElement(n: Int): Any = n match {
      case 0 => `success`
      case 1 => `qe`
      case _ => throw new IndexOutOfBoundsException(n.toString)
    }
  
    override def productPrefix = "getTracesByIds_result"
  }
  object getTraceTimelinesByIds_args extends ThriftStructCodec[getTraceTimelinesByIds_args] {
    val Struct = new TStruct("getTraceTimelinesByIds_args")
    val TraceIdsField = new TField("traceIds", TType.LIST, 1)
    val AdjustField = new TField("adjust", TType.LIST, 2)
  
    def encode(_item: getTraceTimelinesByIds_args, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = Immutable.decode(_iprot)
  
    def apply(_iprot: TProtocol): getTraceTimelinesByIds_args = decode(_iprot)
  
    def apply(
      `traceIds`: Seq[Long] = Seq[Long](),
      `adjust`: Seq[Adjust] = Seq[Adjust]()
    ): getTraceTimelinesByIds_args = new Immutable(
      `traceIds`,
      `adjust`
    )
  
    def unapply(_item: getTraceTimelinesByIds_args): Option[Product2[Seq[Long], Seq[Adjust]]] = Some(_item)
  
    object Immutable extends ThriftStructCodec[getTraceTimelinesByIds_args] {
      def encode(_item: getTraceTimelinesByIds_args, _oproto: TProtocol) { _item.write(_oproto) }
      def decode(_iprot: TProtocol) = {
        var `traceIds`: Seq[Long] = Seq[Long]()
        var _got_traceIds = false
        var `adjust`: Seq[Adjust] = Seq[Adjust]()
        var _got_adjust = false
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
              case 2 => { /* adjust */
                _field.`type` match {
                  case TType.LIST => {
                    `adjust` = {
                      val _list = _iprot.readListBegin()
                      val _rv = new mutable.ArrayBuffer[Adjust](_list.size)
                      var _i = 0
                      while (_i < _list.size) {
                        _rv += {
                          Adjust(_iprot.readI32())
                        }
                        _i += 1
                      }
                      _iprot.readListEnd()
                      _rv
                    }
                    _got_adjust = true
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
          `adjust`
        )
      }
    }
  
    /**
     * The default read-only implementation of getTraceTimelinesByIds_args.  You typically should not need to
     * directly reference this class; instead, use the getTraceTimelinesByIds_args.apply method to construct
     * new instances.
     */
    class Immutable(
      val `traceIds`: Seq[Long] = Seq[Long](),
      val `adjust`: Seq[Adjust] = Seq[Adjust]()
    ) extends getTraceTimelinesByIds_args
  
  }
  
  trait getTraceTimelinesByIds_args extends ThriftStruct
    with Product2[Seq[Long], Seq[Adjust]]
    with java.io.Serializable
  {
    import getTraceTimelinesByIds_args._
  
    def `traceIds`: Seq[Long]
    def `adjust`: Seq[Adjust]
  
    def _1 = `traceIds`
    def _2 = `adjust`
  
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
        val `adjust_item` = `adjust`
        _oprot.writeFieldBegin(AdjustField)
        _oprot.writeListBegin(new TList(TType.I32, `adjust_item`.size))
        `adjust_item`.foreach { `_adjust_item_element` =>
          _oprot.writeI32(`_adjust_item_element`.value)
        }
        _oprot.writeListEnd()
        _oprot.writeFieldEnd()
      }
      _oprot.writeFieldStop()
      _oprot.writeStructEnd()
    }
  
    def copy(
      `traceIds`: Seq[Long] = this.`traceIds`,
      `adjust`: Seq[Adjust] = this.`adjust`
    ): getTraceTimelinesByIds_args = new Immutable(
      `traceIds`,
      `adjust`
    )
  
    /**
     * Checks that all required fields are non-null.
     */
    def validate() {
    }
  
    def canEqual(other: Any) = other.isInstanceOf[getTraceTimelinesByIds_args]
  
    override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)
  
    override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)
  
    override def toString: String = runtime.ScalaRunTime._toString(this)
  
    override def productArity = 2
  
    override def productElement(n: Int): Any = n match {
      case 0 => `traceIds`
      case 1 => `adjust`
      case _ => throw new IndexOutOfBoundsException(n.toString)
    }
  
    override def productPrefix = "getTraceTimelinesByIds_args"
  }
  object getTraceTimelinesByIds_result extends ThriftStructCodec[getTraceTimelinesByIds_result] {
    val Struct = new TStruct("getTraceTimelinesByIds_result")
    val SuccessField = new TField("success", TType.LIST, 0)
    val QeField = new TField("qe", TType.STRUCT, 1)
  
    def encode(_item: getTraceTimelinesByIds_result, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = Immutable.decode(_iprot)
  
    def apply(_iprot: TProtocol): getTraceTimelinesByIds_result = decode(_iprot)
  
    def apply(
      `success`: Option[Seq[TraceTimeline]] = None,
      `qe`: Option[QueryException] = None
    ): getTraceTimelinesByIds_result = new Immutable(
      `success`,
      `qe`
    )
  
    def unapply(_item: getTraceTimelinesByIds_result): Option[Product2[Option[Seq[TraceTimeline]], Option[QueryException]]] = Some(_item)
  
    object Immutable extends ThriftStructCodec[getTraceTimelinesByIds_result] {
      def encode(_item: getTraceTimelinesByIds_result, _oproto: TProtocol) { _item.write(_oproto) }
      def decode(_iprot: TProtocol) = {
        var `success`: Seq[TraceTimeline] = Seq[TraceTimeline]()
        var _got_success = false
        var `qe`: QueryException = null
        var _got_qe = false
        var _done = false
        _iprot.readStructBegin()
        while (!_done) {
          val _field = _iprot.readFieldBegin()
          if (_field.`type` == TType.STOP) {
            _done = true
          } else {
            _field.id match {
              case 0 => { /* success */
                _field.`type` match {
                  case TType.LIST => {
                    `success` = {
                      val _list = _iprot.readListBegin()
                      val _rv = new mutable.ArrayBuffer[TraceTimeline](_list.size)
                      var _i = 0
                      while (_i < _list.size) {
                        _rv += {
                          TraceTimeline.decode(_iprot)
                        }
                        _i += 1
                      }
                      _iprot.readListEnd()
                      _rv
                    }
                    _got_success = true
                  }
                  case _ => TProtocolUtil.skip(_iprot, _field.`type`)
                }
              }
              case 1 => { /* qe */
                _field.`type` match {
                  case TType.STRUCT => {
                    `qe` = {
                      QueryException.decode(_iprot)
                    }
                    _got_qe = true
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
          if (_got_success) Some(`success`) else None,
          if (_got_qe) Some(`qe`) else None
        )
      }
    }
  
    /**
     * The default read-only implementation of getTraceTimelinesByIds_result.  You typically should not need to
     * directly reference this class; instead, use the getTraceTimelinesByIds_result.apply method to construct
     * new instances.
     */
    class Immutable(
      val `success`: Option[Seq[TraceTimeline]] = None,
      val `qe`: Option[QueryException] = None
    ) extends getTraceTimelinesByIds_result
  
  }
  
  trait getTraceTimelinesByIds_result extends ThriftStruct
    with Product2[Option[Seq[TraceTimeline]], Option[QueryException]]
    with java.io.Serializable
  {
    import getTraceTimelinesByIds_result._
  
    def `success`: Option[Seq[TraceTimeline]]
    def `qe`: Option[QueryException]
  
    def _1 = `success`
    def _2 = `qe`
  
    override def write(_oprot: TProtocol) {
      validate()
      _oprot.writeStructBegin(Struct)
      if (`success`.isDefined) {
        val `success_item` = `success`.get
        _oprot.writeFieldBegin(SuccessField)
        _oprot.writeListBegin(new TList(TType.STRUCT, `success_item`.size))
        `success_item`.foreach { `_success_item_element` =>
          `_success_item_element`.write(_oprot)
        }
        _oprot.writeListEnd()
        _oprot.writeFieldEnd()
      }
      if (`qe`.isDefined) {
        val `qe_item` = `qe`.get
        _oprot.writeFieldBegin(QeField)
        `qe_item`.write(_oprot)
        _oprot.writeFieldEnd()
      }
      _oprot.writeFieldStop()
      _oprot.writeStructEnd()
    }
  
    def copy(
      `success`: Option[Seq[TraceTimeline]] = this.`success`,
      `qe`: Option[QueryException] = this.`qe`
    ): getTraceTimelinesByIds_result = new Immutable(
      `success`,
      `qe`
    )
  
    /**
     * Checks that all required fields are non-null.
     */
    def validate() {
    }
  
    def canEqual(other: Any) = other.isInstanceOf[getTraceTimelinesByIds_result]
  
    override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)
  
    override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)
  
    override def toString: String = runtime.ScalaRunTime._toString(this)
  
    override def productArity = 2
  
    override def productElement(n: Int): Any = n match {
      case 0 => `success`
      case 1 => `qe`
      case _ => throw new IndexOutOfBoundsException(n.toString)
    }
  
    override def productPrefix = "getTraceTimelinesByIds_result"
  }
  object getTraceSummariesByIds_args extends ThriftStructCodec[getTraceSummariesByIds_args] {
    val Struct = new TStruct("getTraceSummariesByIds_args")
    val TraceIdsField = new TField("traceIds", TType.LIST, 1)
    val AdjustField = new TField("adjust", TType.LIST, 2)
  
    def encode(_item: getTraceSummariesByIds_args, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = Immutable.decode(_iprot)
  
    def apply(_iprot: TProtocol): getTraceSummariesByIds_args = decode(_iprot)
  
    def apply(
      `traceIds`: Seq[Long] = Seq[Long](),
      `adjust`: Seq[Adjust] = Seq[Adjust]()
    ): getTraceSummariesByIds_args = new Immutable(
      `traceIds`,
      `adjust`
    )
  
    def unapply(_item: getTraceSummariesByIds_args): Option[Product2[Seq[Long], Seq[Adjust]]] = Some(_item)
  
    object Immutable extends ThriftStructCodec[getTraceSummariesByIds_args] {
      def encode(_item: getTraceSummariesByIds_args, _oproto: TProtocol) { _item.write(_oproto) }
      def decode(_iprot: TProtocol) = {
        var `traceIds`: Seq[Long] = Seq[Long]()
        var _got_traceIds = false
        var `adjust`: Seq[Adjust] = Seq[Adjust]()
        var _got_adjust = false
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
              case 2 => { /* adjust */
                _field.`type` match {
                  case TType.LIST => {
                    `adjust` = {
                      val _list = _iprot.readListBegin()
                      val _rv = new mutable.ArrayBuffer[Adjust](_list.size)
                      var _i = 0
                      while (_i < _list.size) {
                        _rv += {
                          Adjust(_iprot.readI32())
                        }
                        _i += 1
                      }
                      _iprot.readListEnd()
                      _rv
                    }
                    _got_adjust = true
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
          `adjust`
        )
      }
    }
  
    /**
     * The default read-only implementation of getTraceSummariesByIds_args.  You typically should not need to
     * directly reference this class; instead, use the getTraceSummariesByIds_args.apply method to construct
     * new instances.
     */
    class Immutable(
      val `traceIds`: Seq[Long] = Seq[Long](),
      val `adjust`: Seq[Adjust] = Seq[Adjust]()
    ) extends getTraceSummariesByIds_args
  
  }
  
  trait getTraceSummariesByIds_args extends ThriftStruct
    with Product2[Seq[Long], Seq[Adjust]]
    with java.io.Serializable
  {
    import getTraceSummariesByIds_args._
  
    def `traceIds`: Seq[Long]
    def `adjust`: Seq[Adjust]
  
    def _1 = `traceIds`
    def _2 = `adjust`
  
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
        val `adjust_item` = `adjust`
        _oprot.writeFieldBegin(AdjustField)
        _oprot.writeListBegin(new TList(TType.I32, `adjust_item`.size))
        `adjust_item`.foreach { `_adjust_item_element` =>
          _oprot.writeI32(`_adjust_item_element`.value)
        }
        _oprot.writeListEnd()
        _oprot.writeFieldEnd()
      }
      _oprot.writeFieldStop()
      _oprot.writeStructEnd()
    }
  
    def copy(
      `traceIds`: Seq[Long] = this.`traceIds`,
      `adjust`: Seq[Adjust] = this.`adjust`
    ): getTraceSummariesByIds_args = new Immutable(
      `traceIds`,
      `adjust`
    )
  
    /**
     * Checks that all required fields are non-null.
     */
    def validate() {
    }
  
    def canEqual(other: Any) = other.isInstanceOf[getTraceSummariesByIds_args]
  
    override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)
  
    override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)
  
    override def toString: String = runtime.ScalaRunTime._toString(this)
  
    override def productArity = 2
  
    override def productElement(n: Int): Any = n match {
      case 0 => `traceIds`
      case 1 => `adjust`
      case _ => throw new IndexOutOfBoundsException(n.toString)
    }
  
    override def productPrefix = "getTraceSummariesByIds_args"
  }
  object getTraceSummariesByIds_result extends ThriftStructCodec[getTraceSummariesByIds_result] {
    val Struct = new TStruct("getTraceSummariesByIds_result")
    val SuccessField = new TField("success", TType.LIST, 0)
    val QeField = new TField("qe", TType.STRUCT, 1)
  
    def encode(_item: getTraceSummariesByIds_result, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = Immutable.decode(_iprot)
  
    def apply(_iprot: TProtocol): getTraceSummariesByIds_result = decode(_iprot)
  
    def apply(
      `success`: Option[Seq[TraceSummary]] = None,
      `qe`: Option[QueryException] = None
    ): getTraceSummariesByIds_result = new Immutable(
      `success`,
      `qe`
    )
  
    def unapply(_item: getTraceSummariesByIds_result): Option[Product2[Option[Seq[TraceSummary]], Option[QueryException]]] = Some(_item)
  
    object Immutable extends ThriftStructCodec[getTraceSummariesByIds_result] {
      def encode(_item: getTraceSummariesByIds_result, _oproto: TProtocol) { _item.write(_oproto) }
      def decode(_iprot: TProtocol) = {
        var `success`: Seq[TraceSummary] = Seq[TraceSummary]()
        var _got_success = false
        var `qe`: QueryException = null
        var _got_qe = false
        var _done = false
        _iprot.readStructBegin()
        while (!_done) {
          val _field = _iprot.readFieldBegin()
          if (_field.`type` == TType.STOP) {
            _done = true
          } else {
            _field.id match {
              case 0 => { /* success */
                _field.`type` match {
                  case TType.LIST => {
                    `success` = {
                      val _list = _iprot.readListBegin()
                      val _rv = new mutable.ArrayBuffer[TraceSummary](_list.size)
                      var _i = 0
                      while (_i < _list.size) {
                        _rv += {
                          TraceSummary.decode(_iprot)
                        }
                        _i += 1
                      }
                      _iprot.readListEnd()
                      _rv
                    }
                    _got_success = true
                  }
                  case _ => TProtocolUtil.skip(_iprot, _field.`type`)
                }
              }
              case 1 => { /* qe */
                _field.`type` match {
                  case TType.STRUCT => {
                    `qe` = {
                      QueryException.decode(_iprot)
                    }
                    _got_qe = true
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
          if (_got_success) Some(`success`) else None,
          if (_got_qe) Some(`qe`) else None
        )
      }
    }
  
    /**
     * The default read-only implementation of getTraceSummariesByIds_result.  You typically should not need to
     * directly reference this class; instead, use the getTraceSummariesByIds_result.apply method to construct
     * new instances.
     */
    class Immutable(
      val `success`: Option[Seq[TraceSummary]] = None,
      val `qe`: Option[QueryException] = None
    ) extends getTraceSummariesByIds_result
  
  }
  
  trait getTraceSummariesByIds_result extends ThriftStruct
    with Product2[Option[Seq[TraceSummary]], Option[QueryException]]
    with java.io.Serializable
  {
    import getTraceSummariesByIds_result._
  
    def `success`: Option[Seq[TraceSummary]]
    def `qe`: Option[QueryException]
  
    def _1 = `success`
    def _2 = `qe`
  
    override def write(_oprot: TProtocol) {
      validate()
      _oprot.writeStructBegin(Struct)
      if (`success`.isDefined) {
        val `success_item` = `success`.get
        _oprot.writeFieldBegin(SuccessField)
        _oprot.writeListBegin(new TList(TType.STRUCT, `success_item`.size))
        `success_item`.foreach { `_success_item_element` =>
          `_success_item_element`.write(_oprot)
        }
        _oprot.writeListEnd()
        _oprot.writeFieldEnd()
      }
      if (`qe`.isDefined) {
        val `qe_item` = `qe`.get
        _oprot.writeFieldBegin(QeField)
        `qe_item`.write(_oprot)
        _oprot.writeFieldEnd()
      }
      _oprot.writeFieldStop()
      _oprot.writeStructEnd()
    }
  
    def copy(
      `success`: Option[Seq[TraceSummary]] = this.`success`,
      `qe`: Option[QueryException] = this.`qe`
    ): getTraceSummariesByIds_result = new Immutable(
      `success`,
      `qe`
    )
  
    /**
     * Checks that all required fields are non-null.
     */
    def validate() {
    }
  
    def canEqual(other: Any) = other.isInstanceOf[getTraceSummariesByIds_result]
  
    override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)
  
    override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)
  
    override def toString: String = runtime.ScalaRunTime._toString(this)
  
    override def productArity = 2
  
    override def productElement(n: Int): Any = n match {
      case 0 => `success`
      case 1 => `qe`
      case _ => throw new IndexOutOfBoundsException(n.toString)
    }
  
    override def productPrefix = "getTraceSummariesByIds_result"
  }
  object getTraceCombosByIds_args extends ThriftStructCodec[getTraceCombosByIds_args] {
    val Struct = new TStruct("getTraceCombosByIds_args")
    val TraceIdsField = new TField("traceIds", TType.LIST, 1)
    val AdjustField = new TField("adjust", TType.LIST, 2)
  
    def encode(_item: getTraceCombosByIds_args, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = Immutable.decode(_iprot)
  
    def apply(_iprot: TProtocol): getTraceCombosByIds_args = decode(_iprot)
  
    def apply(
      `traceIds`: Seq[Long] = Seq[Long](),
      `adjust`: Seq[Adjust] = Seq[Adjust]()
    ): getTraceCombosByIds_args = new Immutable(
      `traceIds`,
      `adjust`
    )
  
    def unapply(_item: getTraceCombosByIds_args): Option[Product2[Seq[Long], Seq[Adjust]]] = Some(_item)
  
    object Immutable extends ThriftStructCodec[getTraceCombosByIds_args] {
      def encode(_item: getTraceCombosByIds_args, _oproto: TProtocol) { _item.write(_oproto) }
      def decode(_iprot: TProtocol) = {
        var `traceIds`: Seq[Long] = Seq[Long]()
        var _got_traceIds = false
        var `adjust`: Seq[Adjust] = Seq[Adjust]()
        var _got_adjust = false
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
              case 2 => { /* adjust */
                _field.`type` match {
                  case TType.LIST => {
                    `adjust` = {
                      val _list = _iprot.readListBegin()
                      val _rv = new mutable.ArrayBuffer[Adjust](_list.size)
                      var _i = 0
                      while (_i < _list.size) {
                        _rv += {
                          Adjust(_iprot.readI32())
                        }
                        _i += 1
                      }
                      _iprot.readListEnd()
                      _rv
                    }
                    _got_adjust = true
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
          `adjust`
        )
      }
    }
  
    /**
     * The default read-only implementation of getTraceCombosByIds_args.  You typically should not need to
     * directly reference this class; instead, use the getTraceCombosByIds_args.apply method to construct
     * new instances.
     */
    class Immutable(
      val `traceIds`: Seq[Long] = Seq[Long](),
      val `adjust`: Seq[Adjust] = Seq[Adjust]()
    ) extends getTraceCombosByIds_args
  
  }
  
  trait getTraceCombosByIds_args extends ThriftStruct
    with Product2[Seq[Long], Seq[Adjust]]
    with java.io.Serializable
  {
    import getTraceCombosByIds_args._
  
    def `traceIds`: Seq[Long]
    def `adjust`: Seq[Adjust]
  
    def _1 = `traceIds`
    def _2 = `adjust`
  
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
        val `adjust_item` = `adjust`
        _oprot.writeFieldBegin(AdjustField)
        _oprot.writeListBegin(new TList(TType.I32, `adjust_item`.size))
        `adjust_item`.foreach { `_adjust_item_element` =>
          _oprot.writeI32(`_adjust_item_element`.value)
        }
        _oprot.writeListEnd()
        _oprot.writeFieldEnd()
      }
      _oprot.writeFieldStop()
      _oprot.writeStructEnd()
    }
  
    def copy(
      `traceIds`: Seq[Long] = this.`traceIds`,
      `adjust`: Seq[Adjust] = this.`adjust`
    ): getTraceCombosByIds_args = new Immutable(
      `traceIds`,
      `adjust`
    )
  
    /**
     * Checks that all required fields are non-null.
     */
    def validate() {
    }
  
    def canEqual(other: Any) = other.isInstanceOf[getTraceCombosByIds_args]
  
    override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)
  
    override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)
  
    override def toString: String = runtime.ScalaRunTime._toString(this)
  
    override def productArity = 2
  
    override def productElement(n: Int): Any = n match {
      case 0 => `traceIds`
      case 1 => `adjust`
      case _ => throw new IndexOutOfBoundsException(n.toString)
    }
  
    override def productPrefix = "getTraceCombosByIds_args"
  }
  object getTraceCombosByIds_result extends ThriftStructCodec[getTraceCombosByIds_result] {
    val Struct = new TStruct("getTraceCombosByIds_result")
    val SuccessField = new TField("success", TType.LIST, 0)
    val QeField = new TField("qe", TType.STRUCT, 1)
  
    def encode(_item: getTraceCombosByIds_result, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = Immutable.decode(_iprot)
  
    def apply(_iprot: TProtocol): getTraceCombosByIds_result = decode(_iprot)
  
    def apply(
      `success`: Option[Seq[TraceCombo]] = None,
      `qe`: Option[QueryException] = None
    ): getTraceCombosByIds_result = new Immutable(
      `success`,
      `qe`
    )
  
    def unapply(_item: getTraceCombosByIds_result): Option[Product2[Option[Seq[TraceCombo]], Option[QueryException]]] = Some(_item)
  
    object Immutable extends ThriftStructCodec[getTraceCombosByIds_result] {
      def encode(_item: getTraceCombosByIds_result, _oproto: TProtocol) { _item.write(_oproto) }
      def decode(_iprot: TProtocol) = {
        var `success`: Seq[TraceCombo] = Seq[TraceCombo]()
        var _got_success = false
        var `qe`: QueryException = null
        var _got_qe = false
        var _done = false
        _iprot.readStructBegin()
        while (!_done) {
          val _field = _iprot.readFieldBegin()
          if (_field.`type` == TType.STOP) {
            _done = true
          } else {
            _field.id match {
              case 0 => { /* success */
                _field.`type` match {
                  case TType.LIST => {
                    `success` = {
                      val _list = _iprot.readListBegin()
                      val _rv = new mutable.ArrayBuffer[TraceCombo](_list.size)
                      var _i = 0
                      while (_i < _list.size) {
                        _rv += {
                          TraceCombo.decode(_iprot)
                        }
                        _i += 1
                      }
                      _iprot.readListEnd()
                      _rv
                    }
                    _got_success = true
                  }
                  case _ => TProtocolUtil.skip(_iprot, _field.`type`)
                }
              }
              case 1 => { /* qe */
                _field.`type` match {
                  case TType.STRUCT => {
                    `qe` = {
                      QueryException.decode(_iprot)
                    }
                    _got_qe = true
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
          if (_got_success) Some(`success`) else None,
          if (_got_qe) Some(`qe`) else None
        )
      }
    }
  
    /**
     * The default read-only implementation of getTraceCombosByIds_result.  You typically should not need to
     * directly reference this class; instead, use the getTraceCombosByIds_result.apply method to construct
     * new instances.
     */
    class Immutable(
      val `success`: Option[Seq[TraceCombo]] = None,
      val `qe`: Option[QueryException] = None
    ) extends getTraceCombosByIds_result
  
  }
  
  trait getTraceCombosByIds_result extends ThriftStruct
    with Product2[Option[Seq[TraceCombo]], Option[QueryException]]
    with java.io.Serializable
  {
    import getTraceCombosByIds_result._
  
    def `success`: Option[Seq[TraceCombo]]
    def `qe`: Option[QueryException]
  
    def _1 = `success`
    def _2 = `qe`
  
    override def write(_oprot: TProtocol) {
      validate()
      _oprot.writeStructBegin(Struct)
      if (`success`.isDefined) {
        val `success_item` = `success`.get
        _oprot.writeFieldBegin(SuccessField)
        _oprot.writeListBegin(new TList(TType.STRUCT, `success_item`.size))
        `success_item`.foreach { `_success_item_element` =>
          `_success_item_element`.write(_oprot)
        }
        _oprot.writeListEnd()
        _oprot.writeFieldEnd()
      }
      if (`qe`.isDefined) {
        val `qe_item` = `qe`.get
        _oprot.writeFieldBegin(QeField)
        `qe_item`.write(_oprot)
        _oprot.writeFieldEnd()
      }
      _oprot.writeFieldStop()
      _oprot.writeStructEnd()
    }
  
    def copy(
      `success`: Option[Seq[TraceCombo]] = this.`success`,
      `qe`: Option[QueryException] = this.`qe`
    ): getTraceCombosByIds_result = new Immutable(
      `success`,
      `qe`
    )
  
    /**
     * Checks that all required fields are non-null.
     */
    def validate() {
    }
  
    def canEqual(other: Any) = other.isInstanceOf[getTraceCombosByIds_result]
  
    override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)
  
    override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)
  
    override def toString: String = runtime.ScalaRunTime._toString(this)
  
    override def productArity = 2
  
    override def productElement(n: Int): Any = n match {
      case 0 => `success`
      case 1 => `qe`
      case _ => throw new IndexOutOfBoundsException(n.toString)
    }
  
    override def productPrefix = "getTraceCombosByIds_result"
  }
  object getServiceNames_args extends ThriftStructCodec[getServiceNames_args] {
    val Struct = new TStruct("getServiceNames_args")
  
    def encode(_item: getServiceNames_args, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = Immutable.decode(_iprot)
  
    def apply(_iprot: TProtocol): getServiceNames_args = decode(_iprot)
  
    def apply(
    ): getServiceNames_args = new Immutable(
    )
  
    def unapply(_item: getServiceNames_args): Boolean = true
  
    object Immutable extends ThriftStructCodec[getServiceNames_args] {
      def encode(_item: getServiceNames_args, _oproto: TProtocol) { _item.write(_oproto) }
      def decode(_iprot: TProtocol) = {
        var _done = false
        _iprot.readStructBegin()
        while (!_done) {
          val _field = _iprot.readFieldBegin()
          if (_field.`type` == TType.STOP) {
            _done = true
          } else {
            _field.id match {
              case _ => TProtocolUtil.skip(_iprot, _field.`type`)
            }
            _iprot.readFieldEnd()
          }
        }
        _iprot.readStructEnd()
        new Immutable(
        )
      }
    }
  
    /**
     * The default read-only implementation of getServiceNames_args.  You typically should not need to
     * directly reference this class; instead, use the getServiceNames_args.apply method to construct
     * new instances.
     */
    class Immutable(
    ) extends getServiceNames_args
  
  }
  
  trait getServiceNames_args extends ThriftStruct
    with Product
    with java.io.Serializable
  {
    import getServiceNames_args._
  
  
  
    override def write(_oprot: TProtocol) {
      validate()
      _oprot.writeStructBegin(Struct)
      _oprot.writeFieldStop()
      _oprot.writeStructEnd()
    }
  
    def copy(
    ): getServiceNames_args = new Immutable(
    )
  
    /**
     * Checks that all required fields are non-null.
     */
    def validate() {
    }
  
    def canEqual(other: Any) = other.isInstanceOf[getServiceNames_args]
  
    override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)
  
    override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)
  
    override def toString: String = runtime.ScalaRunTime._toString(this)
  
    override def productArity = 0
  
    override def productElement(n: Int): Any = n match {
      case _ => throw new IndexOutOfBoundsException(n.toString)
    }
  
    override def productPrefix = "getServiceNames_args"
  }
  object getServiceNames_result extends ThriftStructCodec[getServiceNames_result] {
    val Struct = new TStruct("getServiceNames_result")
    val SuccessField = new TField("success", TType.SET, 0)
    val QeField = new TField("qe", TType.STRUCT, 1)
  
    def encode(_item: getServiceNames_result, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = Immutable.decode(_iprot)
  
    def apply(_iprot: TProtocol): getServiceNames_result = decode(_iprot)
  
    def apply(
      `success`: Option[Set[String]] = None,
      `qe`: Option[QueryException] = None
    ): getServiceNames_result = new Immutable(
      `success`,
      `qe`
    )
  
    def unapply(_item: getServiceNames_result): Option[Product2[Option[Set[String]], Option[QueryException]]] = Some(_item)
  
    object Immutable extends ThriftStructCodec[getServiceNames_result] {
      def encode(_item: getServiceNames_result, _oproto: TProtocol) { _item.write(_oproto) }
      def decode(_iprot: TProtocol) = {
        var `success`: Set[String] = Set[String]()
        var _got_success = false
        var `qe`: QueryException = null
        var _got_qe = false
        var _done = false
        _iprot.readStructBegin()
        while (!_done) {
          val _field = _iprot.readFieldBegin()
          if (_field.`type` == TType.STOP) {
            _done = true
          } else {
            _field.id match {
              case 0 => { /* success */
                _field.`type` match {
                  case TType.SET => {
                    `success` = {
                      val _set = _iprot.readSetBegin()
                      val _rv = new mutable.HashSet[String]
                      var _i = 0
                      while (_i < _set.size) {
                        _rv += {
                          _iprot.readString()
                        }
                        _i += 1
                      }
                      _iprot.readSetEnd()
                      _rv
                    }
                    _got_success = true
                  }
                  case _ => TProtocolUtil.skip(_iprot, _field.`type`)
                }
              }
              case 1 => { /* qe */
                _field.`type` match {
                  case TType.STRUCT => {
                    `qe` = {
                      QueryException.decode(_iprot)
                    }
                    _got_qe = true
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
          if (_got_success) Some(`success`) else None,
          if (_got_qe) Some(`qe`) else None
        )
      }
    }
  
    /**
     * The default read-only implementation of getServiceNames_result.  You typically should not need to
     * directly reference this class; instead, use the getServiceNames_result.apply method to construct
     * new instances.
     */
    class Immutable(
      val `success`: Option[Set[String]] = None,
      val `qe`: Option[QueryException] = None
    ) extends getServiceNames_result
  
  }
  
  trait getServiceNames_result extends ThriftStruct
    with Product2[Option[Set[String]], Option[QueryException]]
    with java.io.Serializable
  {
    import getServiceNames_result._
  
    def `success`: Option[Set[String]]
    def `qe`: Option[QueryException]
  
    def _1 = `success`
    def _2 = `qe`
  
    override def write(_oprot: TProtocol) {
      validate()
      _oprot.writeStructBegin(Struct)
      if (`success`.isDefined) {
        val `success_item` = `success`.get
        _oprot.writeFieldBegin(SuccessField)
        _oprot.writeSetBegin(new TSet(TType.STRING, `success_item`.size))
        `success_item`.foreach { `_success_item_element` =>
          _oprot.writeString(`_success_item_element`)
        }
        _oprot.writeSetEnd()
        _oprot.writeFieldEnd()
      }
      if (`qe`.isDefined) {
        val `qe_item` = `qe`.get
        _oprot.writeFieldBegin(QeField)
        `qe_item`.write(_oprot)
        _oprot.writeFieldEnd()
      }
      _oprot.writeFieldStop()
      _oprot.writeStructEnd()
    }
  
    def copy(
      `success`: Option[Set[String]] = this.`success`,
      `qe`: Option[QueryException] = this.`qe`
    ): getServiceNames_result = new Immutable(
      `success`,
      `qe`
    )
  
    /**
     * Checks that all required fields are non-null.
     */
    def validate() {
    }
  
    def canEqual(other: Any) = other.isInstanceOf[getServiceNames_result]
  
    override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)
  
    override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)
  
    override def toString: String = runtime.ScalaRunTime._toString(this)
  
    override def productArity = 2
  
    override def productElement(n: Int): Any = n match {
      case 0 => `success`
      case 1 => `qe`
      case _ => throw new IndexOutOfBoundsException(n.toString)
    }
  
    override def productPrefix = "getServiceNames_result"
  }
  object getSpanNames_args extends ThriftStructCodec[getSpanNames_args] {
    val Struct = new TStruct("getSpanNames_args")
    val ServiceNameField = new TField("serviceName", TType.STRING, 1)
  
    def encode(_item: getSpanNames_args, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = Immutable.decode(_iprot)
  
    def apply(_iprot: TProtocol): getSpanNames_args = decode(_iprot)
  
    def apply(
      `serviceName`: String
    ): getSpanNames_args = new Immutable(
      `serviceName`
    )
  
    def unapply(_item: getSpanNames_args): Option[String] = Some(_item.serviceName)
  
    object Immutable extends ThriftStructCodec[getSpanNames_args] {
      def encode(_item: getSpanNames_args, _oproto: TProtocol) { _item.write(_oproto) }
      def decode(_iprot: TProtocol) = {
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
              case _ => TProtocolUtil.skip(_iprot, _field.`type`)
            }
            _iprot.readFieldEnd()
          }
        }
        _iprot.readStructEnd()
        new Immutable(
          `serviceName`
        )
      }
    }
  
    /**
     * The default read-only implementation of getSpanNames_args.  You typically should not need to
     * directly reference this class; instead, use the getSpanNames_args.apply method to construct
     * new instances.
     */
    class Immutable(
      val `serviceName`: String
    ) extends getSpanNames_args
  
  }
  
  trait getSpanNames_args extends ThriftStruct
    with Product1[String]
    with java.io.Serializable
  {
    import getSpanNames_args._
  
    def `serviceName`: String
  
    def _1 = `serviceName`
  
    override def write(_oprot: TProtocol) {
      validate()
      _oprot.writeStructBegin(Struct)
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
      `serviceName`: String = this.`serviceName`
    ): getSpanNames_args = new Immutable(
      `serviceName`
    )
  
    /**
     * Checks that all required fields are non-null.
     */
    def validate() {
    }
  
    def canEqual(other: Any) = other.isInstanceOf[getSpanNames_args]
  
    override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)
  
    override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)
  
    override def toString: String = runtime.ScalaRunTime._toString(this)
  
    override def productArity = 1
  
    override def productElement(n: Int): Any = n match {
      case 0 => `serviceName`
      case _ => throw new IndexOutOfBoundsException(n.toString)
    }
  
    override def productPrefix = "getSpanNames_args"
  }
  object getSpanNames_result extends ThriftStructCodec[getSpanNames_result] {
    val Struct = new TStruct("getSpanNames_result")
    val SuccessField = new TField("success", TType.SET, 0)
    val QeField = new TField("qe", TType.STRUCT, 1)
  
    def encode(_item: getSpanNames_result, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = Immutable.decode(_iprot)
  
    def apply(_iprot: TProtocol): getSpanNames_result = decode(_iprot)
  
    def apply(
      `success`: Option[Set[String]] = None,
      `qe`: Option[QueryException] = None
    ): getSpanNames_result = new Immutable(
      `success`,
      `qe`
    )
  
    def unapply(_item: getSpanNames_result): Option[Product2[Option[Set[String]], Option[QueryException]]] = Some(_item)
  
    object Immutable extends ThriftStructCodec[getSpanNames_result] {
      def encode(_item: getSpanNames_result, _oproto: TProtocol) { _item.write(_oproto) }
      def decode(_iprot: TProtocol) = {
        var `success`: Set[String] = Set[String]()
        var _got_success = false
        var `qe`: QueryException = null
        var _got_qe = false
        var _done = false
        _iprot.readStructBegin()
        while (!_done) {
          val _field = _iprot.readFieldBegin()
          if (_field.`type` == TType.STOP) {
            _done = true
          } else {
            _field.id match {
              case 0 => { /* success */
                _field.`type` match {
                  case TType.SET => {
                    `success` = {
                      val _set = _iprot.readSetBegin()
                      val _rv = new mutable.HashSet[String]
                      var _i = 0
                      while (_i < _set.size) {
                        _rv += {
                          _iprot.readString()
                        }
                        _i += 1
                      }
                      _iprot.readSetEnd()
                      _rv
                    }
                    _got_success = true
                  }
                  case _ => TProtocolUtil.skip(_iprot, _field.`type`)
                }
              }
              case 1 => { /* qe */
                _field.`type` match {
                  case TType.STRUCT => {
                    `qe` = {
                      QueryException.decode(_iprot)
                    }
                    _got_qe = true
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
          if (_got_success) Some(`success`) else None,
          if (_got_qe) Some(`qe`) else None
        )
      }
    }
  
    /**
     * The default read-only implementation of getSpanNames_result.  You typically should not need to
     * directly reference this class; instead, use the getSpanNames_result.apply method to construct
     * new instances.
     */
    class Immutable(
      val `success`: Option[Set[String]] = None,
      val `qe`: Option[QueryException] = None
    ) extends getSpanNames_result
  
  }
  
  trait getSpanNames_result extends ThriftStruct
    with Product2[Option[Set[String]], Option[QueryException]]
    with java.io.Serializable
  {
    import getSpanNames_result._
  
    def `success`: Option[Set[String]]
    def `qe`: Option[QueryException]
  
    def _1 = `success`
    def _2 = `qe`
  
    override def write(_oprot: TProtocol) {
      validate()
      _oprot.writeStructBegin(Struct)
      if (`success`.isDefined) {
        val `success_item` = `success`.get
        _oprot.writeFieldBegin(SuccessField)
        _oprot.writeSetBegin(new TSet(TType.STRING, `success_item`.size))
        `success_item`.foreach { `_success_item_element` =>
          _oprot.writeString(`_success_item_element`)
        }
        _oprot.writeSetEnd()
        _oprot.writeFieldEnd()
      }
      if (`qe`.isDefined) {
        val `qe_item` = `qe`.get
        _oprot.writeFieldBegin(QeField)
        `qe_item`.write(_oprot)
        _oprot.writeFieldEnd()
      }
      _oprot.writeFieldStop()
      _oprot.writeStructEnd()
    }
  
    def copy(
      `success`: Option[Set[String]] = this.`success`,
      `qe`: Option[QueryException] = this.`qe`
    ): getSpanNames_result = new Immutable(
      `success`,
      `qe`
    )
  
    /**
     * Checks that all required fields are non-null.
     */
    def validate() {
    }
  
    def canEqual(other: Any) = other.isInstanceOf[getSpanNames_result]
  
    override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)
  
    override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)
  
    override def toString: String = runtime.ScalaRunTime._toString(this)
  
    override def productArity = 2
  
    override def productElement(n: Int): Any = n match {
      case 0 => `success`
      case 1 => `qe`
      case _ => throw new IndexOutOfBoundsException(n.toString)
    }
  
    override def productPrefix = "getSpanNames_result"
  }
  object setTraceTimeToLive_args extends ThriftStructCodec[setTraceTimeToLive_args] {
    val Struct = new TStruct("setTraceTimeToLive_args")
    val TraceIdField = new TField("traceId", TType.I64, 1)
    val TtlSecondsField = new TField("ttlSeconds", TType.I32, 2)
  
    def encode(_item: setTraceTimeToLive_args, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = Immutable.decode(_iprot)
  
    def apply(_iprot: TProtocol): setTraceTimeToLive_args = decode(_iprot)
  
    def apply(
      `traceId`: Long,
      `ttlSeconds`: Int
    ): setTraceTimeToLive_args = new Immutable(
      `traceId`,
      `ttlSeconds`
    )
  
    def unapply(_item: setTraceTimeToLive_args): Option[Product2[Long, Int]] = Some(_item)
  
    object Immutable extends ThriftStructCodec[setTraceTimeToLive_args] {
      def encode(_item: setTraceTimeToLive_args, _oproto: TProtocol) { _item.write(_oproto) }
      def decode(_iprot: TProtocol) = {
        var `traceId`: Long = 0L
        var _got_traceId = false
        var `ttlSeconds`: Int = 0
        var _got_ttlSeconds = false
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
              case 2 => { /* ttlSeconds */
                _field.`type` match {
                  case TType.I32 => {
                    `ttlSeconds` = {
                      _iprot.readI32()
                    }
                    _got_ttlSeconds = true
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
          `ttlSeconds`
        )
      }
    }
  
    /**
     * The default read-only implementation of setTraceTimeToLive_args.  You typically should not need to
     * directly reference this class; instead, use the setTraceTimeToLive_args.apply method to construct
     * new instances.
     */
    class Immutable(
      val `traceId`: Long,
      val `ttlSeconds`: Int
    ) extends setTraceTimeToLive_args
  
  }
  
  trait setTraceTimeToLive_args extends ThriftStruct
    with Product2[Long, Int]
    with java.io.Serializable
  {
    import setTraceTimeToLive_args._
  
    def `traceId`: Long
    def `ttlSeconds`: Int
  
    def _1 = `traceId`
    def _2 = `ttlSeconds`
  
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
        val `ttlSeconds_item` = `ttlSeconds`
        _oprot.writeFieldBegin(TtlSecondsField)
        _oprot.writeI32(`ttlSeconds_item`)
        _oprot.writeFieldEnd()
      }
      _oprot.writeFieldStop()
      _oprot.writeStructEnd()
    }
  
    def copy(
      `traceId`: Long = this.`traceId`,
      `ttlSeconds`: Int = this.`ttlSeconds`
    ): setTraceTimeToLive_args = new Immutable(
      `traceId`,
      `ttlSeconds`
    )
  
    /**
     * Checks that all required fields are non-null.
     */
    def validate() {
    }
  
    def canEqual(other: Any) = other.isInstanceOf[setTraceTimeToLive_args]
  
    override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)
  
    override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)
  
    override def toString: String = runtime.ScalaRunTime._toString(this)
  
    override def productArity = 2
  
    override def productElement(n: Int): Any = n match {
      case 0 => `traceId`
      case 1 => `ttlSeconds`
      case _ => throw new IndexOutOfBoundsException(n.toString)
    }
  
    override def productPrefix = "setTraceTimeToLive_args"
  }
  object setTraceTimeToLive_result extends ThriftStructCodec[setTraceTimeToLive_result] {
    val Struct = new TStruct("setTraceTimeToLive_result")
    val QeField = new TField("qe", TType.STRUCT, 1)
  
    def encode(_item: setTraceTimeToLive_result, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = Immutable.decode(_iprot)
  
    def apply(_iprot: TProtocol): setTraceTimeToLive_result = decode(_iprot)
  
    def apply(
      `qe`: Option[QueryException] = None
    ): setTraceTimeToLive_result = new Immutable(
      `qe`
    )
  
    def unapply(_item: setTraceTimeToLive_result): Option[Option[QueryException]] = Some(_item.qe)
  
    object Immutable extends ThriftStructCodec[setTraceTimeToLive_result] {
      def encode(_item: setTraceTimeToLive_result, _oproto: TProtocol) { _item.write(_oproto) }
      def decode(_iprot: TProtocol) = {
        var `qe`: QueryException = null
        var _got_qe = false
        var _done = false
        _iprot.readStructBegin()
        while (!_done) {
          val _field = _iprot.readFieldBegin()
          if (_field.`type` == TType.STOP) {
            _done = true
          } else {
            _field.id match {
              case 1 => { /* qe */
                _field.`type` match {
                  case TType.STRUCT => {
                    `qe` = {
                      QueryException.decode(_iprot)
                    }
                    _got_qe = true
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
          if (_got_qe) Some(`qe`) else None
        )
      }
    }
  
    /**
     * The default read-only implementation of setTraceTimeToLive_result.  You typically should not need to
     * directly reference this class; instead, use the setTraceTimeToLive_result.apply method to construct
     * new instances.
     */
    class Immutable(
      val `qe`: Option[QueryException] = None
    ) extends setTraceTimeToLive_result
  
  }
  
  trait setTraceTimeToLive_result extends ThriftStruct
    with Product1[Option[QueryException]]
    with java.io.Serializable
  {
    import setTraceTimeToLive_result._
  
    def `qe`: Option[QueryException]
  
    def _1 = `qe`
  
    override def write(_oprot: TProtocol) {
      validate()
      _oprot.writeStructBegin(Struct)
      if (`qe`.isDefined) {
        val `qe_item` = `qe`.get
        _oprot.writeFieldBegin(QeField)
        `qe_item`.write(_oprot)
        _oprot.writeFieldEnd()
      }
      _oprot.writeFieldStop()
      _oprot.writeStructEnd()
    }
  
    def copy(
      `qe`: Option[QueryException] = this.`qe`
    ): setTraceTimeToLive_result = new Immutable(
      `qe`
    )
  
    /**
     * Checks that all required fields are non-null.
     */
    def validate() {
    }
  
    def canEqual(other: Any) = other.isInstanceOf[setTraceTimeToLive_result]
  
    override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)
  
    override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)
  
    override def toString: String = runtime.ScalaRunTime._toString(this)
  
    override def productArity = 1
  
    override def productElement(n: Int): Any = n match {
      case 0 => `qe`
      case _ => throw new IndexOutOfBoundsException(n.toString)
    }
  
    override def productPrefix = "setTraceTimeToLive_result"
  }
  object getTraceTimeToLive_args extends ThriftStructCodec[getTraceTimeToLive_args] {
    val Struct = new TStruct("getTraceTimeToLive_args")
    val TraceIdField = new TField("traceId", TType.I64, 1)
  
    def encode(_item: getTraceTimeToLive_args, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = Immutable.decode(_iprot)
  
    def apply(_iprot: TProtocol): getTraceTimeToLive_args = decode(_iprot)
  
    def apply(
      `traceId`: Long
    ): getTraceTimeToLive_args = new Immutable(
      `traceId`
    )
  
    def unapply(_item: getTraceTimeToLive_args): Option[Long] = Some(_item.traceId)
  
    object Immutable extends ThriftStructCodec[getTraceTimeToLive_args] {
      def encode(_item: getTraceTimeToLive_args, _oproto: TProtocol) { _item.write(_oproto) }
      def decode(_iprot: TProtocol) = {
        var `traceId`: Long = 0L
        var _got_traceId = false
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
              case _ => TProtocolUtil.skip(_iprot, _field.`type`)
            }
            _iprot.readFieldEnd()
          }
        }
        _iprot.readStructEnd()
        new Immutable(
          `traceId`
        )
      }
    }
  
    /**
     * The default read-only implementation of getTraceTimeToLive_args.  You typically should not need to
     * directly reference this class; instead, use the getTraceTimeToLive_args.apply method to construct
     * new instances.
     */
    class Immutable(
      val `traceId`: Long
    ) extends getTraceTimeToLive_args
  
  }
  
  trait getTraceTimeToLive_args extends ThriftStruct
    with Product1[Long]
    with java.io.Serializable
  {
    import getTraceTimeToLive_args._
  
    def `traceId`: Long
  
    def _1 = `traceId`
  
    override def write(_oprot: TProtocol) {
      validate()
      _oprot.writeStructBegin(Struct)
      if (true) {
        val `traceId_item` = `traceId`
        _oprot.writeFieldBegin(TraceIdField)
        _oprot.writeI64(`traceId_item`)
        _oprot.writeFieldEnd()
      }
      _oprot.writeFieldStop()
      _oprot.writeStructEnd()
    }
  
    def copy(
      `traceId`: Long = this.`traceId`
    ): getTraceTimeToLive_args = new Immutable(
      `traceId`
    )
  
    /**
     * Checks that all required fields are non-null.
     */
    def validate() {
    }
  
    def canEqual(other: Any) = other.isInstanceOf[getTraceTimeToLive_args]
  
    override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)
  
    override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)
  
    override def toString: String = runtime.ScalaRunTime._toString(this)
  
    override def productArity = 1
  
    override def productElement(n: Int): Any = n match {
      case 0 => `traceId`
      case _ => throw new IndexOutOfBoundsException(n.toString)
    }
  
    override def productPrefix = "getTraceTimeToLive_args"
  }
  object getTraceTimeToLive_result extends ThriftStructCodec[getTraceTimeToLive_result] {
    val Struct = new TStruct("getTraceTimeToLive_result")
    val SuccessField = new TField("success", TType.I32, 0)
    val QeField = new TField("qe", TType.STRUCT, 1)
  
    def encode(_item: getTraceTimeToLive_result, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = Immutable.decode(_iprot)
  
    def apply(_iprot: TProtocol): getTraceTimeToLive_result = decode(_iprot)
  
    def apply(
      `success`: Option[Int] = None,
      `qe`: Option[QueryException] = None
    ): getTraceTimeToLive_result = new Immutable(
      `success`,
      `qe`
    )
  
    def unapply(_item: getTraceTimeToLive_result): Option[Product2[Option[Int], Option[QueryException]]] = Some(_item)
  
    object Immutable extends ThriftStructCodec[getTraceTimeToLive_result] {
      def encode(_item: getTraceTimeToLive_result, _oproto: TProtocol) { _item.write(_oproto) }
      def decode(_iprot: TProtocol) = {
        var `success`: Int = 0
        var _got_success = false
        var `qe`: QueryException = null
        var _got_qe = false
        var _done = false
        _iprot.readStructBegin()
        while (!_done) {
          val _field = _iprot.readFieldBegin()
          if (_field.`type` == TType.STOP) {
            _done = true
          } else {
            _field.id match {
              case 0 => { /* success */
                _field.`type` match {
                  case TType.I32 => {
                    `success` = {
                      _iprot.readI32()
                    }
                    _got_success = true
                  }
                  case _ => TProtocolUtil.skip(_iprot, _field.`type`)
                }
              }
              case 1 => { /* qe */
                _field.`type` match {
                  case TType.STRUCT => {
                    `qe` = {
                      QueryException.decode(_iprot)
                    }
                    _got_qe = true
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
          if (_got_success) Some(`success`) else None,
          if (_got_qe) Some(`qe`) else None
        )
      }
    }
  
    /**
     * The default read-only implementation of getTraceTimeToLive_result.  You typically should not need to
     * directly reference this class; instead, use the getTraceTimeToLive_result.apply method to construct
     * new instances.
     */
    class Immutable(
      val `success`: Option[Int] = None,
      val `qe`: Option[QueryException] = None
    ) extends getTraceTimeToLive_result
  
  }
  
  trait getTraceTimeToLive_result extends ThriftStruct
    with Product2[Option[Int], Option[QueryException]]
    with java.io.Serializable
  {
    import getTraceTimeToLive_result._
  
    def `success`: Option[Int]
    def `qe`: Option[QueryException]
  
    def _1 = `success`
    def _2 = `qe`
  
    override def write(_oprot: TProtocol) {
      validate()
      _oprot.writeStructBegin(Struct)
      if (`success`.isDefined) {
        val `success_item` = `success`.get
        _oprot.writeFieldBegin(SuccessField)
        _oprot.writeI32(`success_item`)
        _oprot.writeFieldEnd()
      }
      if (`qe`.isDefined) {
        val `qe_item` = `qe`.get
        _oprot.writeFieldBegin(QeField)
        `qe_item`.write(_oprot)
        _oprot.writeFieldEnd()
      }
      _oprot.writeFieldStop()
      _oprot.writeStructEnd()
    }
  
    def copy(
      `success`: Option[Int] = this.`success`,
      `qe`: Option[QueryException] = this.`qe`
    ): getTraceTimeToLive_result = new Immutable(
      `success`,
      `qe`
    )
  
    /**
     * Checks that all required fields are non-null.
     */
    def validate() {
    }
  
    def canEqual(other: Any) = other.isInstanceOf[getTraceTimeToLive_result]
  
    override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)
  
    override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)
  
    override def toString: String = runtime.ScalaRunTime._toString(this)
  
    override def productArity = 2
  
    override def productElement(n: Int): Any = n match {
      case 0 => `success`
      case 1 => `qe`
      case _ => throw new IndexOutOfBoundsException(n.toString)
    }
  
    override def productPrefix = "getTraceTimeToLive_result"
  }
  object getDataTimeToLive_args extends ThriftStructCodec[getDataTimeToLive_args] {
    val Struct = new TStruct("getDataTimeToLive_args")
  
    def encode(_item: getDataTimeToLive_args, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = Immutable.decode(_iprot)
  
    def apply(_iprot: TProtocol): getDataTimeToLive_args = decode(_iprot)
  
    def apply(
    ): getDataTimeToLive_args = new Immutable(
    )
  
    def unapply(_item: getDataTimeToLive_args): Boolean = true
  
    object Immutable extends ThriftStructCodec[getDataTimeToLive_args] {
      def encode(_item: getDataTimeToLive_args, _oproto: TProtocol) { _item.write(_oproto) }
      def decode(_iprot: TProtocol) = {
        var _done = false
        _iprot.readStructBegin()
        while (!_done) {
          val _field = _iprot.readFieldBegin()
          if (_field.`type` == TType.STOP) {
            _done = true
          } else {
            _field.id match {
              case _ => TProtocolUtil.skip(_iprot, _field.`type`)
            }
            _iprot.readFieldEnd()
          }
        }
        _iprot.readStructEnd()
        new Immutable(
        )
      }
    }
  
    /**
     * The default read-only implementation of getDataTimeToLive_args.  You typically should not need to
     * directly reference this class; instead, use the getDataTimeToLive_args.apply method to construct
     * new instances.
     */
    class Immutable(
    ) extends getDataTimeToLive_args
  
  }
  
  trait getDataTimeToLive_args extends ThriftStruct
    with Product
    with java.io.Serializable
  {
    import getDataTimeToLive_args._
  
  
  
    override def write(_oprot: TProtocol) {
      validate()
      _oprot.writeStructBegin(Struct)
      _oprot.writeFieldStop()
      _oprot.writeStructEnd()
    }
  
    def copy(
    ): getDataTimeToLive_args = new Immutable(
    )
  
    /**
     * Checks that all required fields are non-null.
     */
    def validate() {
    }
  
    def canEqual(other: Any) = other.isInstanceOf[getDataTimeToLive_args]
  
    override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)
  
    override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)
  
    override def toString: String = runtime.ScalaRunTime._toString(this)
  
    override def productArity = 0
  
    override def productElement(n: Int): Any = n match {
      case _ => throw new IndexOutOfBoundsException(n.toString)
    }
  
    override def productPrefix = "getDataTimeToLive_args"
  }
  object getDataTimeToLive_result extends ThriftStructCodec[getDataTimeToLive_result] {
    val Struct = new TStruct("getDataTimeToLive_result")
    val SuccessField = new TField("success", TType.I32, 0)
    val QeField = new TField("qe", TType.STRUCT, 1)
  
    def encode(_item: getDataTimeToLive_result, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = Immutable.decode(_iprot)
  
    def apply(_iprot: TProtocol): getDataTimeToLive_result = decode(_iprot)
  
    def apply(
      `success`: Option[Int] = None,
      `qe`: Option[QueryException] = None
    ): getDataTimeToLive_result = new Immutable(
      `success`,
      `qe`
    )
  
    def unapply(_item: getDataTimeToLive_result): Option[Product2[Option[Int], Option[QueryException]]] = Some(_item)
  
    object Immutable extends ThriftStructCodec[getDataTimeToLive_result] {
      def encode(_item: getDataTimeToLive_result, _oproto: TProtocol) { _item.write(_oproto) }
      def decode(_iprot: TProtocol) = {
        var `success`: Int = 0
        var _got_success = false
        var `qe`: QueryException = null
        var _got_qe = false
        var _done = false
        _iprot.readStructBegin()
        while (!_done) {
          val _field = _iprot.readFieldBegin()
          if (_field.`type` == TType.STOP) {
            _done = true
          } else {
            _field.id match {
              case 0 => { /* success */
                _field.`type` match {
                  case TType.I32 => {
                    `success` = {
                      _iprot.readI32()
                    }
                    _got_success = true
                  }
                  case _ => TProtocolUtil.skip(_iprot, _field.`type`)
                }
              }
              case 1 => { /* qe */
                _field.`type` match {
                  case TType.STRUCT => {
                    `qe` = {
                      QueryException.decode(_iprot)
                    }
                    _got_qe = true
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
          if (_got_success) Some(`success`) else None,
          if (_got_qe) Some(`qe`) else None
        )
      }
    }
  
    /**
     * The default read-only implementation of getDataTimeToLive_result.  You typically should not need to
     * directly reference this class; instead, use the getDataTimeToLive_result.apply method to construct
     * new instances.
     */
    class Immutable(
      val `success`: Option[Int] = None,
      val `qe`: Option[QueryException] = None
    ) extends getDataTimeToLive_result
  
  }
  
  trait getDataTimeToLive_result extends ThriftStruct
    with Product2[Option[Int], Option[QueryException]]
    with java.io.Serializable
  {
    import getDataTimeToLive_result._
  
    def `success`: Option[Int]
    def `qe`: Option[QueryException]
  
    def _1 = `success`
    def _2 = `qe`
  
    override def write(_oprot: TProtocol) {
      validate()
      _oprot.writeStructBegin(Struct)
      if (`success`.isDefined) {
        val `success_item` = `success`.get
        _oprot.writeFieldBegin(SuccessField)
        _oprot.writeI32(`success_item`)
        _oprot.writeFieldEnd()
      }
      if (`qe`.isDefined) {
        val `qe_item` = `qe`.get
        _oprot.writeFieldBegin(QeField)
        `qe_item`.write(_oprot)
        _oprot.writeFieldEnd()
      }
      _oprot.writeFieldStop()
      _oprot.writeStructEnd()
    }
  
    def copy(
      `success`: Option[Int] = this.`success`,
      `qe`: Option[QueryException] = this.`qe`
    ): getDataTimeToLive_result = new Immutable(
      `success`,
      `qe`
    )
  
    /**
     * Checks that all required fields are non-null.
     */
    def validate() {
    }
  
    def canEqual(other: Any) = other.isInstanceOf[getDataTimeToLive_result]
  
    override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)
  
    override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)
  
    override def toString: String = runtime.ScalaRunTime._toString(this)
  
    override def productArity = 2
  
    override def productElement(n: Int): Any = n match {
      case 0 => `success`
      case 1 => `qe`
      case _ => throw new IndexOutOfBoundsException(n.toString)
    }
  
    override def productPrefix = "getDataTimeToLive_result"
  }
  object getDependencies_args extends ThriftStructCodec[getDependencies_args] {
    val Struct = new TStruct("getDependencies_args")
    val ServiceNameField = new TField("serviceName", TType.STRING, 1)
  
    def encode(_item: getDependencies_args, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = Immutable.decode(_iprot)
  
    def apply(_iprot: TProtocol): getDependencies_args = decode(_iprot)
  
    def apply(
      `serviceName`: String
    ): getDependencies_args = new Immutable(
      `serviceName`
    )
  
    def unapply(_item: getDependencies_args): Option[String] = Some(_item.serviceName)
  
    object Immutable extends ThriftStructCodec[getDependencies_args] {
      def encode(_item: getDependencies_args, _oproto: TProtocol) { _item.write(_oproto) }
      def decode(_iprot: TProtocol) = {
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
              case _ => TProtocolUtil.skip(_iprot, _field.`type`)
            }
            _iprot.readFieldEnd()
          }
        }
        _iprot.readStructEnd()
        new Immutable(
          `serviceName`
        )
      }
    }
  
    /**
     * The default read-only implementation of getDependencies_args.  You typically should not need to
     * directly reference this class; instead, use the getDependencies_args.apply method to construct
     * new instances.
     */
    class Immutable(
      val `serviceName`: String
    ) extends getDependencies_args
  
  }
  
  trait getDependencies_args extends ThriftStruct
    with Product1[String]
    with java.io.Serializable
  {
    import getDependencies_args._
  
    def `serviceName`: String
  
    def _1 = `serviceName`
  
    override def write(_oprot: TProtocol) {
      validate()
      _oprot.writeStructBegin(Struct)
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
      `serviceName`: String = this.`serviceName`
    ): getDependencies_args = new Immutable(
      `serviceName`
    )
  
    /**
     * Checks that all required fields are non-null.
     */
    def validate() {
    }
  
    def canEqual(other: Any) = other.isInstanceOf[getDependencies_args]
  
    override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)
  
    override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)
  
    override def toString: String = runtime.ScalaRunTime._toString(this)
  
    override def productArity = 1
  
    override def productElement(n: Int): Any = n match {
      case 0 => `serviceName`
      case _ => throw new IndexOutOfBoundsException(n.toString)
    }
  
    override def productPrefix = "getDependencies_args"
  }
  object getDependencies_result extends ThriftStructCodec[getDependencies_result] {
    val Struct = new TStruct("getDependencies_result")
    val SuccessField = new TField("success", TType.LIST, 0)
    val QeField = new TField("qe", TType.STRUCT, 1)
  
    def encode(_item: getDependencies_result, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = Immutable.decode(_iprot)
  
    def apply(_iprot: TProtocol): getDependencies_result = decode(_iprot)
  
    def apply(
      `success`: Option[Seq[String]] = None,
      `qe`: Option[QueryException] = None
    ): getDependencies_result = new Immutable(
      `success`,
      `qe`
    )
  
    def unapply(_item: getDependencies_result): Option[Product2[Option[Seq[String]], Option[QueryException]]] = Some(_item)
  
    object Immutable extends ThriftStructCodec[getDependencies_result] {
      def encode(_item: getDependencies_result, _oproto: TProtocol) { _item.write(_oproto) }
      def decode(_iprot: TProtocol) = {
        var `success`: Seq[String] = Seq[String]()
        var _got_success = false
        var `qe`: QueryException = null
        var _got_qe = false
        var _done = false
        _iprot.readStructBegin()
        while (!_done) {
          val _field = _iprot.readFieldBegin()
          if (_field.`type` == TType.STOP) {
            _done = true
          } else {
            _field.id match {
              case 0 => { /* success */
                _field.`type` match {
                  case TType.LIST => {
                    `success` = {
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
                    _got_success = true
                  }
                  case _ => TProtocolUtil.skip(_iprot, _field.`type`)
                }
              }
              case 1 => { /* qe */
                _field.`type` match {
                  case TType.STRUCT => {
                    `qe` = {
                      QueryException.decode(_iprot)
                    }
                    _got_qe = true
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
          if (_got_success) Some(`success`) else None,
          if (_got_qe) Some(`qe`) else None
        )
      }
    }
  
    /**
     * The default read-only implementation of getDependencies_result.  You typically should not need to
     * directly reference this class; instead, use the getDependencies_result.apply method to construct
     * new instances.
     */
    class Immutable(
      val `success`: Option[Seq[String]] = None,
      val `qe`: Option[QueryException] = None
    ) extends getDependencies_result
  
  }
  
  trait getDependencies_result extends ThriftStruct
    with Product2[Option[Seq[String]], Option[QueryException]]
    with java.io.Serializable
  {
    import getDependencies_result._
  
    def `success`: Option[Seq[String]]
    def `qe`: Option[QueryException]
  
    def _1 = `success`
    def _2 = `qe`
  
    override def write(_oprot: TProtocol) {
      validate()
      _oprot.writeStructBegin(Struct)
      if (`success`.isDefined) {
        val `success_item` = `success`.get
        _oprot.writeFieldBegin(SuccessField)
        _oprot.writeListBegin(new TList(TType.STRING, `success_item`.size))
        `success_item`.foreach { `_success_item_element` =>
          _oprot.writeString(`_success_item_element`)
        }
        _oprot.writeListEnd()
        _oprot.writeFieldEnd()
      }
      if (`qe`.isDefined) {
        val `qe_item` = `qe`.get
        _oprot.writeFieldBegin(QeField)
        `qe_item`.write(_oprot)
        _oprot.writeFieldEnd()
      }
      _oprot.writeFieldStop()
      _oprot.writeStructEnd()
    }
  
    def copy(
      `success`: Option[Seq[String]] = this.`success`,
      `qe`: Option[QueryException] = this.`qe`
    ): getDependencies_result = new Immutable(
      `success`,
      `qe`
    )
  
    /**
     * Checks that all required fields are non-null.
     */
    def validate() {
    }
  
    def canEqual(other: Any) = other.isInstanceOf[getDependencies_result]
  
    override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)
  
    override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)
  
    override def toString: String = runtime.ScalaRunTime._toString(this)
  
    override def productArity = 2
  
    override def productElement(n: Int): Any = n match {
      case 0 => `success`
      case 1 => `qe`
      case _ => throw new IndexOutOfBoundsException(n.toString)
    }
  
    override def productPrefix = "getDependencies_result"
  }
  object getTopAnnotations_args extends ThriftStructCodec[getTopAnnotations_args] {
    val Struct = new TStruct("getTopAnnotations_args")
    val ServiceNameField = new TField("serviceName", TType.STRING, 1)
  
    def encode(_item: getTopAnnotations_args, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = Immutable.decode(_iprot)
  
    def apply(_iprot: TProtocol): getTopAnnotations_args = decode(_iprot)
  
    def apply(
      `serviceName`: String
    ): getTopAnnotations_args = new Immutable(
      `serviceName`
    )
  
    def unapply(_item: getTopAnnotations_args): Option[String] = Some(_item.serviceName)
  
    object Immutable extends ThriftStructCodec[getTopAnnotations_args] {
      def encode(_item: getTopAnnotations_args, _oproto: TProtocol) { _item.write(_oproto) }
      def decode(_iprot: TProtocol) = {
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
              case _ => TProtocolUtil.skip(_iprot, _field.`type`)
            }
            _iprot.readFieldEnd()
          }
        }
        _iprot.readStructEnd()
        new Immutable(
          `serviceName`
        )
      }
    }
  
    /**
     * The default read-only implementation of getTopAnnotations_args.  You typically should not need to
     * directly reference this class; instead, use the getTopAnnotations_args.apply method to construct
     * new instances.
     */
    class Immutable(
      val `serviceName`: String
    ) extends getTopAnnotations_args
  
  }
  
  trait getTopAnnotations_args extends ThriftStruct
    with Product1[String]
    with java.io.Serializable
  {
    import getTopAnnotations_args._
  
    def `serviceName`: String
  
    def _1 = `serviceName`
  
    override def write(_oprot: TProtocol) {
      validate()
      _oprot.writeStructBegin(Struct)
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
      `serviceName`: String = this.`serviceName`
    ): getTopAnnotations_args = new Immutable(
      `serviceName`
    )
  
    /**
     * Checks that all required fields are non-null.
     */
    def validate() {
    }
  
    def canEqual(other: Any) = other.isInstanceOf[getTopAnnotations_args]
  
    override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)
  
    override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)
  
    override def toString: String = runtime.ScalaRunTime._toString(this)
  
    override def productArity = 1
  
    override def productElement(n: Int): Any = n match {
      case 0 => `serviceName`
      case _ => throw new IndexOutOfBoundsException(n.toString)
    }
  
    override def productPrefix = "getTopAnnotations_args"
  }
  object getTopAnnotations_result extends ThriftStructCodec[getTopAnnotations_result] {
    val Struct = new TStruct("getTopAnnotations_result")
    val SuccessField = new TField("success", TType.LIST, 0)
    val QeField = new TField("qe", TType.STRUCT, 1)
  
    def encode(_item: getTopAnnotations_result, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = Immutable.decode(_iprot)
  
    def apply(_iprot: TProtocol): getTopAnnotations_result = decode(_iprot)
  
    def apply(
      `success`: Option[Seq[String]] = None,
      `qe`: Option[QueryException] = None
    ): getTopAnnotations_result = new Immutable(
      `success`,
      `qe`
    )
  
    def unapply(_item: getTopAnnotations_result): Option[Product2[Option[Seq[String]], Option[QueryException]]] = Some(_item)
  
    object Immutable extends ThriftStructCodec[getTopAnnotations_result] {
      def encode(_item: getTopAnnotations_result, _oproto: TProtocol) { _item.write(_oproto) }
      def decode(_iprot: TProtocol) = {
        var `success`: Seq[String] = Seq[String]()
        var _got_success = false
        var `qe`: QueryException = null
        var _got_qe = false
        var _done = false
        _iprot.readStructBegin()
        while (!_done) {
          val _field = _iprot.readFieldBegin()
          if (_field.`type` == TType.STOP) {
            _done = true
          } else {
            _field.id match {
              case 0 => { /* success */
                _field.`type` match {
                  case TType.LIST => {
                    `success` = {
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
                    _got_success = true
                  }
                  case _ => TProtocolUtil.skip(_iprot, _field.`type`)
                }
              }
              case 1 => { /* qe */
                _field.`type` match {
                  case TType.STRUCT => {
                    `qe` = {
                      QueryException.decode(_iprot)
                    }
                    _got_qe = true
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
          if (_got_success) Some(`success`) else None,
          if (_got_qe) Some(`qe`) else None
        )
      }
    }
  
    /**
     * The default read-only implementation of getTopAnnotations_result.  You typically should not need to
     * directly reference this class; instead, use the getTopAnnotations_result.apply method to construct
     * new instances.
     */
    class Immutable(
      val `success`: Option[Seq[String]] = None,
      val `qe`: Option[QueryException] = None
    ) extends getTopAnnotations_result
  
  }
  
  trait getTopAnnotations_result extends ThriftStruct
    with Product2[Option[Seq[String]], Option[QueryException]]
    with java.io.Serializable
  {
    import getTopAnnotations_result._
  
    def `success`: Option[Seq[String]]
    def `qe`: Option[QueryException]
  
    def _1 = `success`
    def _2 = `qe`
  
    override def write(_oprot: TProtocol) {
      validate()
      _oprot.writeStructBegin(Struct)
      if (`success`.isDefined) {
        val `success_item` = `success`.get
        _oprot.writeFieldBegin(SuccessField)
        _oprot.writeListBegin(new TList(TType.STRING, `success_item`.size))
        `success_item`.foreach { `_success_item_element` =>
          _oprot.writeString(`_success_item_element`)
        }
        _oprot.writeListEnd()
        _oprot.writeFieldEnd()
      }
      if (`qe`.isDefined) {
        val `qe_item` = `qe`.get
        _oprot.writeFieldBegin(QeField)
        `qe_item`.write(_oprot)
        _oprot.writeFieldEnd()
      }
      _oprot.writeFieldStop()
      _oprot.writeStructEnd()
    }
  
    def copy(
      `success`: Option[Seq[String]] = this.`success`,
      `qe`: Option[QueryException] = this.`qe`
    ): getTopAnnotations_result = new Immutable(
      `success`,
      `qe`
    )
  
    /**
     * Checks that all required fields are non-null.
     */
    def validate() {
    }
  
    def canEqual(other: Any) = other.isInstanceOf[getTopAnnotations_result]
  
    override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)
  
    override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)
  
    override def toString: String = runtime.ScalaRunTime._toString(this)
  
    override def productArity = 2
  
    override def productElement(n: Int): Any = n match {
      case 0 => `success`
      case 1 => `qe`
      case _ => throw new IndexOutOfBoundsException(n.toString)
    }
  
    override def productPrefix = "getTopAnnotations_result"
  }
  object getTopKeyValueAnnotations_args extends ThriftStructCodec[getTopKeyValueAnnotations_args] {
    val Struct = new TStruct("getTopKeyValueAnnotations_args")
    val ServiceNameField = new TField("serviceName", TType.STRING, 1)
  
    def encode(_item: getTopKeyValueAnnotations_args, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = Immutable.decode(_iprot)
  
    def apply(_iprot: TProtocol): getTopKeyValueAnnotations_args = decode(_iprot)
  
    def apply(
      `serviceName`: String
    ): getTopKeyValueAnnotations_args = new Immutable(
      `serviceName`
    )
  
    def unapply(_item: getTopKeyValueAnnotations_args): Option[String] = Some(_item.serviceName)
  
    object Immutable extends ThriftStructCodec[getTopKeyValueAnnotations_args] {
      def encode(_item: getTopKeyValueAnnotations_args, _oproto: TProtocol) { _item.write(_oproto) }
      def decode(_iprot: TProtocol) = {
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
              case _ => TProtocolUtil.skip(_iprot, _field.`type`)
            }
            _iprot.readFieldEnd()
          }
        }
        _iprot.readStructEnd()
        new Immutable(
          `serviceName`
        )
      }
    }
  
    /**
     * The default read-only implementation of getTopKeyValueAnnotations_args.  You typically should not need to
     * directly reference this class; instead, use the getTopKeyValueAnnotations_args.apply method to construct
     * new instances.
     */
    class Immutable(
      val `serviceName`: String
    ) extends getTopKeyValueAnnotations_args
  
  }
  
  trait getTopKeyValueAnnotations_args extends ThriftStruct
    with Product1[String]
    with java.io.Serializable
  {
    import getTopKeyValueAnnotations_args._
  
    def `serviceName`: String
  
    def _1 = `serviceName`
  
    override def write(_oprot: TProtocol) {
      validate()
      _oprot.writeStructBegin(Struct)
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
      `serviceName`: String = this.`serviceName`
    ): getTopKeyValueAnnotations_args = new Immutable(
      `serviceName`
    )
  
    /**
     * Checks that all required fields are non-null.
     */
    def validate() {
    }
  
    def canEqual(other: Any) = other.isInstanceOf[getTopKeyValueAnnotations_args]
  
    override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)
  
    override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)
  
    override def toString: String = runtime.ScalaRunTime._toString(this)
  
    override def productArity = 1
  
    override def productElement(n: Int): Any = n match {
      case 0 => `serviceName`
      case _ => throw new IndexOutOfBoundsException(n.toString)
    }
  
    override def productPrefix = "getTopKeyValueAnnotations_args"
  }
  object getTopKeyValueAnnotations_result extends ThriftStructCodec[getTopKeyValueAnnotations_result] {
    val Struct = new TStruct("getTopKeyValueAnnotations_result")
    val SuccessField = new TField("success", TType.LIST, 0)
    val QeField = new TField("qe", TType.STRUCT, 1)
  
    def encode(_item: getTopKeyValueAnnotations_result, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = Immutable.decode(_iprot)
  
    def apply(_iprot: TProtocol): getTopKeyValueAnnotations_result = decode(_iprot)
  
    def apply(
      `success`: Option[Seq[String]] = None,
      `qe`: Option[QueryException] = None
    ): getTopKeyValueAnnotations_result = new Immutable(
      `success`,
      `qe`
    )
  
    def unapply(_item: getTopKeyValueAnnotations_result): Option[Product2[Option[Seq[String]], Option[QueryException]]] = Some(_item)
  
    object Immutable extends ThriftStructCodec[getTopKeyValueAnnotations_result] {
      def encode(_item: getTopKeyValueAnnotations_result, _oproto: TProtocol) { _item.write(_oproto) }
      def decode(_iprot: TProtocol) = {
        var `success`: Seq[String] = Seq[String]()
        var _got_success = false
        var `qe`: QueryException = null
        var _got_qe = false
        var _done = false
        _iprot.readStructBegin()
        while (!_done) {
          val _field = _iprot.readFieldBegin()
          if (_field.`type` == TType.STOP) {
            _done = true
          } else {
            _field.id match {
              case 0 => { /* success */
                _field.`type` match {
                  case TType.LIST => {
                    `success` = {
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
                    _got_success = true
                  }
                  case _ => TProtocolUtil.skip(_iprot, _field.`type`)
                }
              }
              case 1 => { /* qe */
                _field.`type` match {
                  case TType.STRUCT => {
                    `qe` = {
                      QueryException.decode(_iprot)
                    }
                    _got_qe = true
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
          if (_got_success) Some(`success`) else None,
          if (_got_qe) Some(`qe`) else None
        )
      }
    }
  
    /**
     * The default read-only implementation of getTopKeyValueAnnotations_result.  You typically should not need to
     * directly reference this class; instead, use the getTopKeyValueAnnotations_result.apply method to construct
     * new instances.
     */
    class Immutable(
      val `success`: Option[Seq[String]] = None,
      val `qe`: Option[QueryException] = None
    ) extends getTopKeyValueAnnotations_result
  
  }
  
  trait getTopKeyValueAnnotations_result extends ThriftStruct
    with Product2[Option[Seq[String]], Option[QueryException]]
    with java.io.Serializable
  {
    import getTopKeyValueAnnotations_result._
  
    def `success`: Option[Seq[String]]
    def `qe`: Option[QueryException]
  
    def _1 = `success`
    def _2 = `qe`
  
    override def write(_oprot: TProtocol) {
      validate()
      _oprot.writeStructBegin(Struct)
      if (`success`.isDefined) {
        val `success_item` = `success`.get
        _oprot.writeFieldBegin(SuccessField)
        _oprot.writeListBegin(new TList(TType.STRING, `success_item`.size))
        `success_item`.foreach { `_success_item_element` =>
          _oprot.writeString(`_success_item_element`)
        }
        _oprot.writeListEnd()
        _oprot.writeFieldEnd()
      }
      if (`qe`.isDefined) {
        val `qe_item` = `qe`.get
        _oprot.writeFieldBegin(QeField)
        `qe_item`.write(_oprot)
        _oprot.writeFieldEnd()
      }
      _oprot.writeFieldStop()
      _oprot.writeStructEnd()
    }
  
    def copy(
      `success`: Option[Seq[String]] = this.`success`,
      `qe`: Option[QueryException] = this.`qe`
    ): getTopKeyValueAnnotations_result = new Immutable(
      `success`,
      `qe`
    )
  
    /**
     * Checks that all required fields are non-null.
     */
    def validate() {
    }
  
    def canEqual(other: Any) = other.isInstanceOf[getTopKeyValueAnnotations_result]
  
    override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)
  
    override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)
  
    override def toString: String = runtime.ScalaRunTime._toString(this)
  
    override def productArity = 2
  
    override def productElement(n: Int): Any = n match {
      case 0 => `success`
      case 1 => `qe`
      case _ => throw new IndexOutOfBoundsException(n.toString)
    }
  
    override def productPrefix = "getTopKeyValueAnnotations_result"
  }
  class FinagledClient(
    service: FinagleService[ThriftClientRequest, Array[Byte]],
    protocolFactory: TProtocolFactory = new TBinaryProtocol.Factory,
    serviceName: String = "",
    stats: StatsReceiver = NullStatsReceiver
  ) extends FutureIface {
    // ----- boilerplate that should eventually be moved into finagle:
  
    protected def encodeRequest(name: String, args: ThriftStruct) = {
      val buf = new TMemoryBuffer(512)
      val oprot = protocolFactory.getProtocol(buf)
  
      oprot.writeMessageBegin(new TMessage(name, TMessageType.CALL, 0))
      args.write(oprot)
      oprot.writeMessageEnd()
  
      val bytes = Arrays.copyOfRange(buf.getArray, 0, buf.length)
      new ThriftClientRequest(bytes, false)
    }
  
    protected def decodeResponse[T <: ThriftStruct](resBytes: Array[Byte], codec: ThriftStructCodec[T]) = {
      val iprot = protocolFactory.getProtocol(new TMemoryInputTransport(resBytes))
      val msg = iprot.readMessageBegin()
      try {
        if (msg.`type` == TMessageType.EXCEPTION) {
          val exception = TApplicationException.read(iprot) match {
            case sourced: SourcedException =>
              if (serviceName != "") sourced.serviceName = serviceName
              sourced
            case e => e
          }
          throw exception
        } else {
          codec.decode(iprot)
        }
      } finally {
        iprot.readMessageEnd()
      }
    }
  
    protected def missingResult(name: String) = {
      new TApplicationException(
        TApplicationException.MISSING_RESULT,
        "`" + name + "` failed: unknown result"
      )
    }
  
    // ----- end boilerplate.
  
    private[this] val scopedStats = if (serviceName != "") stats.scope(serviceName) else stats
    private[this] object __stats_getTraceIds {
      val RequestsCounter = scopedStats.scope("getTraceIds").counter("requests")
      val SuccessCounter = scopedStats.scope("getTraceIds").counter("success")
      val FailuresCounter = scopedStats.scope("getTraceIds").counter("failures")
      val FailuresScope = scopedStats.scope("getTraceIds").scope("failures")
    }
  
    def getTraceIds(`request`: QueryRequest): Future[QueryResponse] = {
      __stats_getTraceIds.RequestsCounter.incr()
      this.service(encodeRequest("getTraceIds", getTraceIds_args(request))) flatMap { response =>
        val result = decodeResponse(response, getTraceIds_result)
        val exception =
          (result.qe).map(Future.exception)
        exception.orElse(result.success.map(Future.value)).getOrElse(Future.exception(missingResult("getTraceIds")))
      } rescue {
        case ex: SourcedException => {
          if (this.serviceName != "") { ex.serviceName = this.serviceName }
          Future.exception(ex)
        }
      } onSuccess { _ =>
        __stats_getTraceIds.SuccessCounter.incr()
      } onFailure { ex =>
        __stats_getTraceIds.FailuresCounter.incr()
        __stats_getTraceIds.FailuresScope.counter(ex.getClass.getName).incr()
      }
    }
    private[this] object __stats_getTraceIdsBySpanName {
      val RequestsCounter = scopedStats.scope("getTraceIdsBySpanName").counter("requests")
      val SuccessCounter = scopedStats.scope("getTraceIdsBySpanName").counter("success")
      val FailuresCounter = scopedStats.scope("getTraceIdsBySpanName").counter("failures")
      val FailuresScope = scopedStats.scope("getTraceIdsBySpanName").scope("failures")
    }
  
    def getTraceIdsBySpanName(`serviceName`: String, `spanName`: String, `endTs`: Long, `limit`: Int, `order`: Order): Future[Seq[Long]] = {
      __stats_getTraceIdsBySpanName.RequestsCounter.incr()
      this.service(encodeRequest("getTraceIdsBySpanName", getTraceIdsBySpanName_args(serviceName, spanName, endTs, limit, order))) flatMap { response =>
        val result = decodeResponse(response, getTraceIdsBySpanName_result)
        val exception =
          (result.qe).map(Future.exception)
        exception.orElse(result.success.map(Future.value)).getOrElse(Future.exception(missingResult("getTraceIdsBySpanName")))
      } rescue {
        case ex: SourcedException => {
          if (this.serviceName != "") { ex.serviceName = this.serviceName }
          Future.exception(ex)
        }
      } onSuccess { _ =>
        __stats_getTraceIdsBySpanName.SuccessCounter.incr()
      } onFailure { ex =>
        __stats_getTraceIdsBySpanName.FailuresCounter.incr()
        __stats_getTraceIdsBySpanName.FailuresScope.counter(ex.getClass.getName).incr()
      }
    }
    private[this] object __stats_getTraceIdsByServiceName {
      val RequestsCounter = scopedStats.scope("getTraceIdsByServiceName").counter("requests")
      val SuccessCounter = scopedStats.scope("getTraceIdsByServiceName").counter("success")
      val FailuresCounter = scopedStats.scope("getTraceIdsByServiceName").counter("failures")
      val FailuresScope = scopedStats.scope("getTraceIdsByServiceName").scope("failures")
    }
  
    def getTraceIdsByServiceName(`serviceName`: String, `endTs`: Long, `limit`: Int, `order`: Order): Future[Seq[Long]] = {
      __stats_getTraceIdsByServiceName.RequestsCounter.incr()
      this.service(encodeRequest("getTraceIdsByServiceName", getTraceIdsByServiceName_args(serviceName, endTs, limit, order))) flatMap { response =>
        val result = decodeResponse(response, getTraceIdsByServiceName_result)
        val exception =
          (result.qe).map(Future.exception)
        exception.orElse(result.success.map(Future.value)).getOrElse(Future.exception(missingResult("getTraceIdsByServiceName")))
      } rescue {
        case ex: SourcedException => {
          if (this.serviceName != "") { ex.serviceName = this.serviceName }
          Future.exception(ex)
        }
      } onSuccess { _ =>
        __stats_getTraceIdsByServiceName.SuccessCounter.incr()
      } onFailure { ex =>
        __stats_getTraceIdsByServiceName.FailuresCounter.incr()
        __stats_getTraceIdsByServiceName.FailuresScope.counter(ex.getClass.getName).incr()
      }
    }
    private[this] object __stats_getTraceIdsByAnnotation {
      val RequestsCounter = scopedStats.scope("getTraceIdsByAnnotation").counter("requests")
      val SuccessCounter = scopedStats.scope("getTraceIdsByAnnotation").counter("success")
      val FailuresCounter = scopedStats.scope("getTraceIdsByAnnotation").counter("failures")
      val FailuresScope = scopedStats.scope("getTraceIdsByAnnotation").scope("failures")
    }
  
    def getTraceIdsByAnnotation(`serviceName`: String, `annotation`: String, `value`: ByteBuffer, `endTs`: Long, `limit`: Int, `order`: Order): Future[Seq[Long]] = {
      __stats_getTraceIdsByAnnotation.RequestsCounter.incr()
      this.service(encodeRequest("getTraceIdsByAnnotation", getTraceIdsByAnnotation_args(serviceName, annotation, value, endTs, limit, order))) flatMap { response =>
        val result = decodeResponse(response, getTraceIdsByAnnotation_result)
        val exception =
          (result.qe).map(Future.exception)
        exception.orElse(result.success.map(Future.value)).getOrElse(Future.exception(missingResult("getTraceIdsByAnnotation")))
      } rescue {
        case ex: SourcedException => {
          if (this.serviceName != "") { ex.serviceName = this.serviceName }
          Future.exception(ex)
        }
      } onSuccess { _ =>
        __stats_getTraceIdsByAnnotation.SuccessCounter.incr()
      } onFailure { ex =>
        __stats_getTraceIdsByAnnotation.FailuresCounter.incr()
        __stats_getTraceIdsByAnnotation.FailuresScope.counter(ex.getClass.getName).incr()
      }
    }
    private[this] object __stats_tracesExist {
      val RequestsCounter = scopedStats.scope("tracesExist").counter("requests")
      val SuccessCounter = scopedStats.scope("tracesExist").counter("success")
      val FailuresCounter = scopedStats.scope("tracesExist").counter("failures")
      val FailuresScope = scopedStats.scope("tracesExist").scope("failures")
    }
  
    def tracesExist(`traceIds`: Seq[Long] = Seq[Long]()): Future[Set[Long]] = {
      __stats_tracesExist.RequestsCounter.incr()
      this.service(encodeRequest("tracesExist", tracesExist_args(traceIds))) flatMap { response =>
        val result = decodeResponse(response, tracesExist_result)
        val exception =
          (result.qe).map(Future.exception)
        exception.orElse(result.success.map(Future.value)).getOrElse(Future.exception(missingResult("tracesExist")))
      } rescue {
        case ex: SourcedException => {
          if (this.serviceName != "") { ex.serviceName = this.serviceName }
          Future.exception(ex)
        }
      } onSuccess { _ =>
        __stats_tracesExist.SuccessCounter.incr()
      } onFailure { ex =>
        __stats_tracesExist.FailuresCounter.incr()
        __stats_tracesExist.FailuresScope.counter(ex.getClass.getName).incr()
      }
    }
    private[this] object __stats_getTracesByIds {
      val RequestsCounter = scopedStats.scope("getTracesByIds").counter("requests")
      val SuccessCounter = scopedStats.scope("getTracesByIds").counter("success")
      val FailuresCounter = scopedStats.scope("getTracesByIds").counter("failures")
      val FailuresScope = scopedStats.scope("getTracesByIds").scope("failures")
    }
  
    def getTracesByIds(`traceIds`: Seq[Long] = Seq[Long](), `adjust`: Seq[Adjust] = Seq[Adjust]()): Future[Seq[Trace]] = {
      __stats_getTracesByIds.RequestsCounter.incr()
      this.service(encodeRequest("getTracesByIds", getTracesByIds_args(traceIds, adjust))) flatMap { response =>
        val result = decodeResponse(response, getTracesByIds_result)
        val exception =
          (result.qe).map(Future.exception)
        exception.orElse(result.success.map(Future.value)).getOrElse(Future.exception(missingResult("getTracesByIds")))
      } rescue {
        case ex: SourcedException => {
          if (this.serviceName != "") { ex.serviceName = this.serviceName }
          Future.exception(ex)
        }
      } onSuccess { _ =>
        __stats_getTracesByIds.SuccessCounter.incr()
      } onFailure { ex =>
        __stats_getTracesByIds.FailuresCounter.incr()
        __stats_getTracesByIds.FailuresScope.counter(ex.getClass.getName).incr()
      }
    }
    private[this] object __stats_getTraceTimelinesByIds {
      val RequestsCounter = scopedStats.scope("getTraceTimelinesByIds").counter("requests")
      val SuccessCounter = scopedStats.scope("getTraceTimelinesByIds").counter("success")
      val FailuresCounter = scopedStats.scope("getTraceTimelinesByIds").counter("failures")
      val FailuresScope = scopedStats.scope("getTraceTimelinesByIds").scope("failures")
    }
  
    def getTraceTimelinesByIds(`traceIds`: Seq[Long] = Seq[Long](), `adjust`: Seq[Adjust] = Seq[Adjust]()): Future[Seq[TraceTimeline]] = {
      __stats_getTraceTimelinesByIds.RequestsCounter.incr()
      this.service(encodeRequest("getTraceTimelinesByIds", getTraceTimelinesByIds_args(traceIds, adjust))) flatMap { response =>
        val result = decodeResponse(response, getTraceTimelinesByIds_result)
        val exception =
          (result.qe).map(Future.exception)
        exception.orElse(result.success.map(Future.value)).getOrElse(Future.exception(missingResult("getTraceTimelinesByIds")))
      } rescue {
        case ex: SourcedException => {
          if (this.serviceName != "") { ex.serviceName = this.serviceName }
          Future.exception(ex)
        }
      } onSuccess { _ =>
        __stats_getTraceTimelinesByIds.SuccessCounter.incr()
      } onFailure { ex =>
        __stats_getTraceTimelinesByIds.FailuresCounter.incr()
        __stats_getTraceTimelinesByIds.FailuresScope.counter(ex.getClass.getName).incr()
      }
    }
    private[this] object __stats_getTraceSummariesByIds {
      val RequestsCounter = scopedStats.scope("getTraceSummariesByIds").counter("requests")
      val SuccessCounter = scopedStats.scope("getTraceSummariesByIds").counter("success")
      val FailuresCounter = scopedStats.scope("getTraceSummariesByIds").counter("failures")
      val FailuresScope = scopedStats.scope("getTraceSummariesByIds").scope("failures")
    }
  
    def getTraceSummariesByIds(`traceIds`: Seq[Long] = Seq[Long](), `adjust`: Seq[Adjust] = Seq[Adjust]()): Future[Seq[TraceSummary]] = {
      __stats_getTraceSummariesByIds.RequestsCounter.incr()
      this.service(encodeRequest("getTraceSummariesByIds", getTraceSummariesByIds_args(traceIds, adjust))) flatMap { response =>
        val result = decodeResponse(response, getTraceSummariesByIds_result)
        val exception =
          (result.qe).map(Future.exception)
        exception.orElse(result.success.map(Future.value)).getOrElse(Future.exception(missingResult("getTraceSummariesByIds")))
      } rescue {
        case ex: SourcedException => {
          if (this.serviceName != "") { ex.serviceName = this.serviceName }
          Future.exception(ex)
        }
      } onSuccess { _ =>
        __stats_getTraceSummariesByIds.SuccessCounter.incr()
      } onFailure { ex =>
        __stats_getTraceSummariesByIds.FailuresCounter.incr()
        __stats_getTraceSummariesByIds.FailuresScope.counter(ex.getClass.getName).incr()
      }
    }
    private[this] object __stats_getTraceCombosByIds {
      val RequestsCounter = scopedStats.scope("getTraceCombosByIds").counter("requests")
      val SuccessCounter = scopedStats.scope("getTraceCombosByIds").counter("success")
      val FailuresCounter = scopedStats.scope("getTraceCombosByIds").counter("failures")
      val FailuresScope = scopedStats.scope("getTraceCombosByIds").scope("failures")
    }
  
    def getTraceCombosByIds(`traceIds`: Seq[Long] = Seq[Long](), `adjust`: Seq[Adjust] = Seq[Adjust]()): Future[Seq[TraceCombo]] = {
      __stats_getTraceCombosByIds.RequestsCounter.incr()
      this.service(encodeRequest("getTraceCombosByIds", getTraceCombosByIds_args(traceIds, adjust))) flatMap { response =>
        val result = decodeResponse(response, getTraceCombosByIds_result)
        val exception =
          (result.qe).map(Future.exception)
        exception.orElse(result.success.map(Future.value)).getOrElse(Future.exception(missingResult("getTraceCombosByIds")))
      } rescue {
        case ex: SourcedException => {
          if (this.serviceName != "") { ex.serviceName = this.serviceName }
          Future.exception(ex)
        }
      } onSuccess { _ =>
        __stats_getTraceCombosByIds.SuccessCounter.incr()
      } onFailure { ex =>
        __stats_getTraceCombosByIds.FailuresCounter.incr()
        __stats_getTraceCombosByIds.FailuresScope.counter(ex.getClass.getName).incr()
      }
    }
    private[this] object __stats_getServiceNames {
      val RequestsCounter = scopedStats.scope("getServiceNames").counter("requests")
      val SuccessCounter = scopedStats.scope("getServiceNames").counter("success")
      val FailuresCounter = scopedStats.scope("getServiceNames").counter("failures")
      val FailuresScope = scopedStats.scope("getServiceNames").scope("failures")
    }
  
    def getServiceNames(): Future[Set[String]] = {
      __stats_getServiceNames.RequestsCounter.incr()
      this.service(encodeRequest("getServiceNames", getServiceNames_args())) flatMap { response =>
        val result = decodeResponse(response, getServiceNames_result)
        val exception =
          (result.qe).map(Future.exception)
        exception.orElse(result.success.map(Future.value)).getOrElse(Future.exception(missingResult("getServiceNames")))
      } rescue {
        case ex: SourcedException => {
          if (this.serviceName != "") { ex.serviceName = this.serviceName }
          Future.exception(ex)
        }
      } onSuccess { _ =>
        __stats_getServiceNames.SuccessCounter.incr()
      } onFailure { ex =>
        __stats_getServiceNames.FailuresCounter.incr()
        __stats_getServiceNames.FailuresScope.counter(ex.getClass.getName).incr()
      }
    }
    private[this] object __stats_getSpanNames {
      val RequestsCounter = scopedStats.scope("getSpanNames").counter("requests")
      val SuccessCounter = scopedStats.scope("getSpanNames").counter("success")
      val FailuresCounter = scopedStats.scope("getSpanNames").counter("failures")
      val FailuresScope = scopedStats.scope("getSpanNames").scope("failures")
    }
  
    def getSpanNames(`serviceName`: String): Future[Set[String]] = {
      __stats_getSpanNames.RequestsCounter.incr()
      this.service(encodeRequest("getSpanNames", getSpanNames_args(serviceName))) flatMap { response =>
        val result = decodeResponse(response, getSpanNames_result)
        val exception =
          (result.qe).map(Future.exception)
        exception.orElse(result.success.map(Future.value)).getOrElse(Future.exception(missingResult("getSpanNames")))
      } rescue {
        case ex: SourcedException => {
          if (this.serviceName != "") { ex.serviceName = this.serviceName }
          Future.exception(ex)
        }
      } onSuccess { _ =>
        __stats_getSpanNames.SuccessCounter.incr()
      } onFailure { ex =>
        __stats_getSpanNames.FailuresCounter.incr()
        __stats_getSpanNames.FailuresScope.counter(ex.getClass.getName).incr()
      }
    }
    private[this] object __stats_setTraceTimeToLive {
      val RequestsCounter = scopedStats.scope("setTraceTimeToLive").counter("requests")
      val SuccessCounter = scopedStats.scope("setTraceTimeToLive").counter("success")
      val FailuresCounter = scopedStats.scope("setTraceTimeToLive").counter("failures")
      val FailuresScope = scopedStats.scope("setTraceTimeToLive").scope("failures")
    }
  
    def setTraceTimeToLive(`traceId`: Long, `ttlSeconds`: Int): Future[Unit] = {
      __stats_setTraceTimeToLive.RequestsCounter.incr()
      this.service(encodeRequest("setTraceTimeToLive", setTraceTimeToLive_args(traceId, ttlSeconds))) flatMap { response =>
        val result = decodeResponse(response, setTraceTimeToLive_result)
        val exception =
          (result.qe).map(Future.exception)
        Future.Done
      } rescue {
        case ex: SourcedException => {
          if (this.serviceName != "") { ex.serviceName = this.serviceName }
          Future.exception(ex)
        }
      } onSuccess { _ =>
        __stats_setTraceTimeToLive.SuccessCounter.incr()
      } onFailure { ex =>
        __stats_setTraceTimeToLive.FailuresCounter.incr()
        __stats_setTraceTimeToLive.FailuresScope.counter(ex.getClass.getName).incr()
      }
    }
    private[this] object __stats_getTraceTimeToLive {
      val RequestsCounter = scopedStats.scope("getTraceTimeToLive").counter("requests")
      val SuccessCounter = scopedStats.scope("getTraceTimeToLive").counter("success")
      val FailuresCounter = scopedStats.scope("getTraceTimeToLive").counter("failures")
      val FailuresScope = scopedStats.scope("getTraceTimeToLive").scope("failures")
    }
  
    def getTraceTimeToLive(`traceId`: Long): Future[Int] = {
      __stats_getTraceTimeToLive.RequestsCounter.incr()
      this.service(encodeRequest("getTraceTimeToLive", getTraceTimeToLive_args(traceId))) flatMap { response =>
        val result = decodeResponse(response, getTraceTimeToLive_result)
        val exception =
          (result.qe).map(Future.exception)
        exception.orElse(result.success.map(Future.value)).getOrElse(Future.exception(missingResult("getTraceTimeToLive")))
      } rescue {
        case ex: SourcedException => {
          if (this.serviceName != "") { ex.serviceName = this.serviceName }
          Future.exception(ex)
        }
      } onSuccess { _ =>
        __stats_getTraceTimeToLive.SuccessCounter.incr()
      } onFailure { ex =>
        __stats_getTraceTimeToLive.FailuresCounter.incr()
        __stats_getTraceTimeToLive.FailuresScope.counter(ex.getClass.getName).incr()
      }
    }
    private[this] object __stats_getDataTimeToLive {
      val RequestsCounter = scopedStats.scope("getDataTimeToLive").counter("requests")
      val SuccessCounter = scopedStats.scope("getDataTimeToLive").counter("success")
      val FailuresCounter = scopedStats.scope("getDataTimeToLive").counter("failures")
      val FailuresScope = scopedStats.scope("getDataTimeToLive").scope("failures")
    }
  
    def getDataTimeToLive(): Future[Int] = {
      __stats_getDataTimeToLive.RequestsCounter.incr()
      this.service(encodeRequest("getDataTimeToLive", getDataTimeToLive_args())) flatMap { response =>
        val result = decodeResponse(response, getDataTimeToLive_result)
        val exception =
          (result.qe).map(Future.exception)
        exception.orElse(result.success.map(Future.value)).getOrElse(Future.exception(missingResult("getDataTimeToLive")))
      } rescue {
        case ex: SourcedException => {
          if (this.serviceName != "") { ex.serviceName = this.serviceName }
          Future.exception(ex)
        }
      } onSuccess { _ =>
        __stats_getDataTimeToLive.SuccessCounter.incr()
      } onFailure { ex =>
        __stats_getDataTimeToLive.FailuresCounter.incr()
        __stats_getDataTimeToLive.FailuresScope.counter(ex.getClass.getName).incr()
      }
    }
    private[this] object __stats_getDependencies {
      val RequestsCounter = scopedStats.scope("getDependencies").counter("requests")
      val SuccessCounter = scopedStats.scope("getDependencies").counter("success")
      val FailuresCounter = scopedStats.scope("getDependencies").counter("failures")
      val FailuresScope = scopedStats.scope("getDependencies").scope("failures")
    }
  
    def getDependencies(`serviceName`: String): Future[Seq[String]] = {
      __stats_getDependencies.RequestsCounter.incr()
      this.service(encodeRequest("getDependencies", getDependencies_args(serviceName))) flatMap { response =>
        val result = decodeResponse(response, getDependencies_result)
        val exception =
          (result.qe).map(Future.exception)
        exception.orElse(result.success.map(Future.value)).getOrElse(Future.exception(missingResult("getDependencies")))
      } rescue {
        case ex: SourcedException => {
          if (this.serviceName != "") { ex.serviceName = this.serviceName }
          Future.exception(ex)
        }
      } onSuccess { _ =>
        __stats_getDependencies.SuccessCounter.incr()
      } onFailure { ex =>
        __stats_getDependencies.FailuresCounter.incr()
        __stats_getDependencies.FailuresScope.counter(ex.getClass.getName).incr()
      }
    }
    private[this] object __stats_getTopAnnotations {
      val RequestsCounter = scopedStats.scope("getTopAnnotations").counter("requests")
      val SuccessCounter = scopedStats.scope("getTopAnnotations").counter("success")
      val FailuresCounter = scopedStats.scope("getTopAnnotations").counter("failures")
      val FailuresScope = scopedStats.scope("getTopAnnotations").scope("failures")
    }
  
    def getTopAnnotations(`serviceName`: String): Future[Seq[String]] = {
      __stats_getTopAnnotations.RequestsCounter.incr()
      this.service(encodeRequest("getTopAnnotations", getTopAnnotations_args(serviceName))) flatMap { response =>
        val result = decodeResponse(response, getTopAnnotations_result)
        val exception =
          (result.qe).map(Future.exception)
        exception.orElse(result.success.map(Future.value)).getOrElse(Future.exception(missingResult("getTopAnnotations")))
      } rescue {
        case ex: SourcedException => {
          if (this.serviceName != "") { ex.serviceName = this.serviceName }
          Future.exception(ex)
        }
      } onSuccess { _ =>
        __stats_getTopAnnotations.SuccessCounter.incr()
      } onFailure { ex =>
        __stats_getTopAnnotations.FailuresCounter.incr()
        __stats_getTopAnnotations.FailuresScope.counter(ex.getClass.getName).incr()
      }
    }
    private[this] object __stats_getTopKeyValueAnnotations {
      val RequestsCounter = scopedStats.scope("getTopKeyValueAnnotations").counter("requests")
      val SuccessCounter = scopedStats.scope("getTopKeyValueAnnotations").counter("success")
      val FailuresCounter = scopedStats.scope("getTopKeyValueAnnotations").counter("failures")
      val FailuresScope = scopedStats.scope("getTopKeyValueAnnotations").scope("failures")
    }
  
    def getTopKeyValueAnnotations(`serviceName`: String): Future[Seq[String]] = {
      __stats_getTopKeyValueAnnotations.RequestsCounter.incr()
      this.service(encodeRequest("getTopKeyValueAnnotations", getTopKeyValueAnnotations_args(serviceName))) flatMap { response =>
        val result = decodeResponse(response, getTopKeyValueAnnotations_result)
        val exception =
          (result.qe).map(Future.exception)
        exception.orElse(result.success.map(Future.value)).getOrElse(Future.exception(missingResult("getTopKeyValueAnnotations")))
      } rescue {
        case ex: SourcedException => {
          if (this.serviceName != "") { ex.serviceName = this.serviceName }
          Future.exception(ex)
        }
      } onSuccess { _ =>
        __stats_getTopKeyValueAnnotations.SuccessCounter.incr()
      } onFailure { ex =>
        __stats_getTopKeyValueAnnotations.FailuresCounter.incr()
        __stats_getTopKeyValueAnnotations.FailuresScope.counter(ex.getClass.getName).incr()
      }
    }
  }
  class FinagledService(
    iface: FutureIface,
    protocolFactory: TProtocolFactory
  ) extends FinagleService[Array[Byte], Array[Byte]] {
    // ----- boilerplate that should eventually be moved into finagle:
  
    protected val functionMap = new mutable.HashMap[String, (TProtocol, Int) => Future[Array[Byte]]]()
  
    protected def addFunction(name: String, f: (TProtocol, Int) => Future[Array[Byte]]) {
      functionMap(name) = f
    }
  
    protected def exception(name: String, seqid: Int, code: Int, message: String): Future[Array[Byte]] = {
      try {
        val x = new TApplicationException(code, message)
        val memoryBuffer = new TMemoryBuffer(512)
        val oprot = protocolFactory.getProtocol(memoryBuffer)
  
        oprot.writeMessageBegin(new TMessage(name, TMessageType.EXCEPTION, seqid))
        x.write(oprot)
        oprot.writeMessageEnd()
        oprot.getTransport().flush()
        Future.value(Arrays.copyOfRange(memoryBuffer.getArray(), 0, memoryBuffer.length()))
      } catch {
        case e: Exception => Future.exception(e)
      }
    }
  
    protected def reply(name: String, seqid: Int, result: ThriftStruct): Future[Array[Byte]] = {
      try {
        val memoryBuffer = new TMemoryBuffer(512)
        val oprot = protocolFactory.getProtocol(memoryBuffer)
  
        oprot.writeMessageBegin(new TMessage(name, TMessageType.REPLY, seqid))
        result.write(oprot)
        oprot.writeMessageEnd()
  
        Future.value(Arrays.copyOfRange(memoryBuffer.getArray(), 0, memoryBuffer.length()))
      } catch {
        case e: Exception => Future.exception(e)
      }
    }
  
    final def apply(request: Array[Byte]): Future[Array[Byte]] = {
      val inputTransport = new TMemoryInputTransport(request)
      val iprot = protocolFactory.getProtocol(inputTransport)
  
      try {
        val msg = iprot.readMessageBegin()
        functionMap.get(msg.name) map { _.apply(iprot, msg.seqid) } getOrElse {
          TProtocolUtil.skip(iprot, TType.STRUCT)
          exception(msg.name, msg.seqid, TApplicationException.UNKNOWN_METHOD,
            "Invalid method name: '" + msg.name + "'")
        }
      } catch {
        case e: Exception => Future.exception(e)
      }
    }
  
    // ---- end boilerplate.
  
    addFunction("getTraceIds", { (iprot: TProtocol, seqid: Int) =>
      try {
        val args = getTraceIds_args.decode(iprot)
        iprot.readMessageEnd()
        (try {
          iface.getTraceIds(args.request)
        } catch {
          case e: Exception => Future.exception(e)
        }) flatMap { value: QueryResponse =>
          reply("getTraceIds", seqid, getTraceIds_result(success = Some(value)))
        } rescue {
          case e: QueryException => {
            reply("getTraceIds", seqid, getTraceIds_result(qe = Some(e)))
          }
          case e => Future.exception(e)
        }
      } catch {
        case e: TProtocolException => {
          iprot.readMessageEnd()
          exception("getTraceIds", seqid, TApplicationException.PROTOCOL_ERROR, e.getMessage)
        }
        case e: Exception => Future.exception(e)
      }
    })
    addFunction("getTraceIdsBySpanName", { (iprot: TProtocol, seqid: Int) =>
      try {
        val args = getTraceIdsBySpanName_args.decode(iprot)
        iprot.readMessageEnd()
        (try {
          iface.getTraceIdsBySpanName(args.serviceName, args.spanName, args.endTs, args.limit, args.order)
        } catch {
          case e: Exception => Future.exception(e)
        }) flatMap { value: Seq[Long] =>
          reply("getTraceIdsBySpanName", seqid, getTraceIdsBySpanName_result(success = Some(value)))
        } rescue {
          case e: QueryException => {
            reply("getTraceIdsBySpanName", seqid, getTraceIdsBySpanName_result(qe = Some(e)))
          }
          case e => Future.exception(e)
        }
      } catch {
        case e: TProtocolException => {
          iprot.readMessageEnd()
          exception("getTraceIdsBySpanName", seqid, TApplicationException.PROTOCOL_ERROR, e.getMessage)
        }
        case e: Exception => Future.exception(e)
      }
    })
    addFunction("getTraceIdsByServiceName", { (iprot: TProtocol, seqid: Int) =>
      try {
        val args = getTraceIdsByServiceName_args.decode(iprot)
        iprot.readMessageEnd()
        (try {
          iface.getTraceIdsByServiceName(args.serviceName, args.endTs, args.limit, args.order)
        } catch {
          case e: Exception => Future.exception(e)
        }) flatMap { value: Seq[Long] =>
          reply("getTraceIdsByServiceName", seqid, getTraceIdsByServiceName_result(success = Some(value)))
        } rescue {
          case e: QueryException => {
            reply("getTraceIdsByServiceName", seqid, getTraceIdsByServiceName_result(qe = Some(e)))
          }
          case e => Future.exception(e)
        }
      } catch {
        case e: TProtocolException => {
          iprot.readMessageEnd()
          exception("getTraceIdsByServiceName", seqid, TApplicationException.PROTOCOL_ERROR, e.getMessage)
        }
        case e: Exception => Future.exception(e)
      }
    })
    addFunction("getTraceIdsByAnnotation", { (iprot: TProtocol, seqid: Int) =>
      try {
        val args = getTraceIdsByAnnotation_args.decode(iprot)
        iprot.readMessageEnd()
        (try {
          iface.getTraceIdsByAnnotation(args.serviceName, args.annotation, args.value, args.endTs, args.limit, args.order)
        } catch {
          case e: Exception => Future.exception(e)
        }) flatMap { value: Seq[Long] =>
          reply("getTraceIdsByAnnotation", seqid, getTraceIdsByAnnotation_result(success = Some(value)))
        } rescue {
          case e: QueryException => {
            reply("getTraceIdsByAnnotation", seqid, getTraceIdsByAnnotation_result(qe = Some(e)))
          }
          case e => Future.exception(e)
        }
      } catch {
        case e: TProtocolException => {
          iprot.readMessageEnd()
          exception("getTraceIdsByAnnotation", seqid, TApplicationException.PROTOCOL_ERROR, e.getMessage)
        }
        case e: Exception => Future.exception(e)
      }
    })
    addFunction("tracesExist", { (iprot: TProtocol, seqid: Int) =>
      try {
        val args = tracesExist_args.decode(iprot)
        iprot.readMessageEnd()
        (try {
          iface.tracesExist(args.traceIds)
        } catch {
          case e: Exception => Future.exception(e)
        }) flatMap { value: Set[Long] =>
          reply("tracesExist", seqid, tracesExist_result(success = Some(value)))
        } rescue {
          case e: QueryException => {
            reply("tracesExist", seqid, tracesExist_result(qe = Some(e)))
          }
          case e => Future.exception(e)
        }
      } catch {
        case e: TProtocolException => {
          iprot.readMessageEnd()
          exception("tracesExist", seqid, TApplicationException.PROTOCOL_ERROR, e.getMessage)
        }
        case e: Exception => Future.exception(e)
      }
    })
    addFunction("getTracesByIds", { (iprot: TProtocol, seqid: Int) =>
      try {
        val args = getTracesByIds_args.decode(iprot)
        iprot.readMessageEnd()
        (try {
          iface.getTracesByIds(args.traceIds, args.adjust)
        } catch {
          case e: Exception => Future.exception(e)
        }) flatMap { value: Seq[Trace] =>
          reply("getTracesByIds", seqid, getTracesByIds_result(success = Some(value)))
        } rescue {
          case e: QueryException => {
            reply("getTracesByIds", seqid, getTracesByIds_result(qe = Some(e)))
          }
          case e => Future.exception(e)
        }
      } catch {
        case e: TProtocolException => {
          iprot.readMessageEnd()
          exception("getTracesByIds", seqid, TApplicationException.PROTOCOL_ERROR, e.getMessage)
        }
        case e: Exception => Future.exception(e)
      }
    })
    addFunction("getTraceTimelinesByIds", { (iprot: TProtocol, seqid: Int) =>
      try {
        val args = getTraceTimelinesByIds_args.decode(iprot)
        iprot.readMessageEnd()
        (try {
          iface.getTraceTimelinesByIds(args.traceIds, args.adjust)
        } catch {
          case e: Exception => Future.exception(e)
        }) flatMap { value: Seq[TraceTimeline] =>
          reply("getTraceTimelinesByIds", seqid, getTraceTimelinesByIds_result(success = Some(value)))
        } rescue {
          case e: QueryException => {
            reply("getTraceTimelinesByIds", seqid, getTraceTimelinesByIds_result(qe = Some(e)))
          }
          case e => Future.exception(e)
        }
      } catch {
        case e: TProtocolException => {
          iprot.readMessageEnd()
          exception("getTraceTimelinesByIds", seqid, TApplicationException.PROTOCOL_ERROR, e.getMessage)
        }
        case e: Exception => Future.exception(e)
      }
    })
    addFunction("getTraceSummariesByIds", { (iprot: TProtocol, seqid: Int) =>
      try {
        val args = getTraceSummariesByIds_args.decode(iprot)
        iprot.readMessageEnd()
        (try {
          iface.getTraceSummariesByIds(args.traceIds, args.adjust)
        } catch {
          case e: Exception => Future.exception(e)
        }) flatMap { value: Seq[TraceSummary] =>
          reply("getTraceSummariesByIds", seqid, getTraceSummariesByIds_result(success = Some(value)))
        } rescue {
          case e: QueryException => {
            reply("getTraceSummariesByIds", seqid, getTraceSummariesByIds_result(qe = Some(e)))
          }
          case e => Future.exception(e)
        }
      } catch {
        case e: TProtocolException => {
          iprot.readMessageEnd()
          exception("getTraceSummariesByIds", seqid, TApplicationException.PROTOCOL_ERROR, e.getMessage)
        }
        case e: Exception => Future.exception(e)
      }
    })
    addFunction("getTraceCombosByIds", { (iprot: TProtocol, seqid: Int) =>
      try {
        val args = getTraceCombosByIds_args.decode(iprot)
        iprot.readMessageEnd()
        (try {
          iface.getTraceCombosByIds(args.traceIds, args.adjust)
        } catch {
          case e: Exception => Future.exception(e)
        }) flatMap { value: Seq[TraceCombo] =>
          reply("getTraceCombosByIds", seqid, getTraceCombosByIds_result(success = Some(value)))
        } rescue {
          case e: QueryException => {
            reply("getTraceCombosByIds", seqid, getTraceCombosByIds_result(qe = Some(e)))
          }
          case e => Future.exception(e)
        }
      } catch {
        case e: TProtocolException => {
          iprot.readMessageEnd()
          exception("getTraceCombosByIds", seqid, TApplicationException.PROTOCOL_ERROR, e.getMessage)
        }
        case e: Exception => Future.exception(e)
      }
    })
    addFunction("getServiceNames", { (iprot: TProtocol, seqid: Int) =>
      try {
        val args = getServiceNames_args.decode(iprot)
        iprot.readMessageEnd()
        (try {
          iface.getServiceNames()
        } catch {
          case e: Exception => Future.exception(e)
        }) flatMap { value: Set[String] =>
          reply("getServiceNames", seqid, getServiceNames_result(success = Some(value)))
        } rescue {
          case e: QueryException => {
            reply("getServiceNames", seqid, getServiceNames_result(qe = Some(e)))
          }
          case e => Future.exception(e)
        }
      } catch {
        case e: TProtocolException => {
          iprot.readMessageEnd()
          exception("getServiceNames", seqid, TApplicationException.PROTOCOL_ERROR, e.getMessage)
        }
        case e: Exception => Future.exception(e)
      }
    })
    addFunction("getSpanNames", { (iprot: TProtocol, seqid: Int) =>
      try {
        val args = getSpanNames_args.decode(iprot)
        iprot.readMessageEnd()
        (try {
          iface.getSpanNames(args.serviceName)
        } catch {
          case e: Exception => Future.exception(e)
        }) flatMap { value: Set[String] =>
          reply("getSpanNames", seqid, getSpanNames_result(success = Some(value)))
        } rescue {
          case e: QueryException => {
            reply("getSpanNames", seqid, getSpanNames_result(qe = Some(e)))
          }
          case e => Future.exception(e)
        }
      } catch {
        case e: TProtocolException => {
          iprot.readMessageEnd()
          exception("getSpanNames", seqid, TApplicationException.PROTOCOL_ERROR, e.getMessage)
        }
        case e: Exception => Future.exception(e)
      }
    })
    addFunction("setTraceTimeToLive", { (iprot: TProtocol, seqid: Int) =>
      try {
        val args = setTraceTimeToLive_args.decode(iprot)
        iprot.readMessageEnd()
        (try {
          iface.setTraceTimeToLive(args.traceId, args.ttlSeconds)
        } catch {
          case e: Exception => Future.exception(e)
        }) flatMap { value: Unit =>
          reply("setTraceTimeToLive", seqid, setTraceTimeToLive_result())
        } rescue {
          case e: QueryException => {
            reply("setTraceTimeToLive", seqid, setTraceTimeToLive_result(qe = Some(e)))
          }
          case e => Future.exception(e)
        }
      } catch {
        case e: TProtocolException => {
          iprot.readMessageEnd()
          exception("setTraceTimeToLive", seqid, TApplicationException.PROTOCOL_ERROR, e.getMessage)
        }
        case e: Exception => Future.exception(e)
      }
    })
    addFunction("getTraceTimeToLive", { (iprot: TProtocol, seqid: Int) =>
      try {
        val args = getTraceTimeToLive_args.decode(iprot)
        iprot.readMessageEnd()
        (try {
          iface.getTraceTimeToLive(args.traceId)
        } catch {
          case e: Exception => Future.exception(e)
        }) flatMap { value: Int =>
          reply("getTraceTimeToLive", seqid, getTraceTimeToLive_result(success = Some(value)))
        } rescue {
          case e: QueryException => {
            reply("getTraceTimeToLive", seqid, getTraceTimeToLive_result(qe = Some(e)))
          }
          case e => Future.exception(e)
        }
      } catch {
        case e: TProtocolException => {
          iprot.readMessageEnd()
          exception("getTraceTimeToLive", seqid, TApplicationException.PROTOCOL_ERROR, e.getMessage)
        }
        case e: Exception => Future.exception(e)
      }
    })
    addFunction("getDataTimeToLive", { (iprot: TProtocol, seqid: Int) =>
      try {
        val args = getDataTimeToLive_args.decode(iprot)
        iprot.readMessageEnd()
        (try {
          iface.getDataTimeToLive()
        } catch {
          case e: Exception => Future.exception(e)
        }) flatMap { value: Int =>
          reply("getDataTimeToLive", seqid, getDataTimeToLive_result(success = Some(value)))
        } rescue {
          case e: QueryException => {
            reply("getDataTimeToLive", seqid, getDataTimeToLive_result(qe = Some(e)))
          }
          case e => Future.exception(e)
        }
      } catch {
        case e: TProtocolException => {
          iprot.readMessageEnd()
          exception("getDataTimeToLive", seqid, TApplicationException.PROTOCOL_ERROR, e.getMessage)
        }
        case e: Exception => Future.exception(e)
      }
    })
    addFunction("getDependencies", { (iprot: TProtocol, seqid: Int) =>
      try {
        val args = getDependencies_args.decode(iprot)
        iprot.readMessageEnd()
        (try {
          iface.getDependencies(args.serviceName)
        } catch {
          case e: Exception => Future.exception(e)
        }) flatMap { value: Seq[String] =>
          reply("getDependencies", seqid, getDependencies_result(success = Some(value)))
        } rescue {
          case e: QueryException => {
            reply("getDependencies", seqid, getDependencies_result(qe = Some(e)))
          }
          case e => Future.exception(e)
        }
      } catch {
        case e: TProtocolException => {
          iprot.readMessageEnd()
          exception("getDependencies", seqid, TApplicationException.PROTOCOL_ERROR, e.getMessage)
        }
        case e: Exception => Future.exception(e)
      }
    })
    addFunction("getTopAnnotations", { (iprot: TProtocol, seqid: Int) =>
      try {
        val args = getTopAnnotations_args.decode(iprot)
        iprot.readMessageEnd()
        (try {
          iface.getTopAnnotations(args.serviceName)
        } catch {
          case e: Exception => Future.exception(e)
        }) flatMap { value: Seq[String] =>
          reply("getTopAnnotations", seqid, getTopAnnotations_result(success = Some(value)))
        } rescue {
          case e: QueryException => {
            reply("getTopAnnotations", seqid, getTopAnnotations_result(qe = Some(e)))
          }
          case e => Future.exception(e)
        }
      } catch {
        case e: TProtocolException => {
          iprot.readMessageEnd()
          exception("getTopAnnotations", seqid, TApplicationException.PROTOCOL_ERROR, e.getMessage)
        }
        case e: Exception => Future.exception(e)
      }
    })
    addFunction("getTopKeyValueAnnotations", { (iprot: TProtocol, seqid: Int) =>
      try {
        val args = getTopKeyValueAnnotations_args.decode(iprot)
        iprot.readMessageEnd()
        (try {
          iface.getTopKeyValueAnnotations(args.serviceName)
        } catch {
          case e: Exception => Future.exception(e)
        }) flatMap { value: Seq[String] =>
          reply("getTopKeyValueAnnotations", seqid, getTopKeyValueAnnotations_result(success = Some(value)))
        } rescue {
          case e: QueryException => {
            reply("getTopKeyValueAnnotations", seqid, getTopKeyValueAnnotations_result(qe = Some(e)))
          }
          case e => Future.exception(e)
        }
      } catch {
        case e: TProtocolException => {
          iprot.readMessageEnd()
          exception("getTopKeyValueAnnotations", seqid, TApplicationException.PROTOCOL_ERROR, e.getMessage)
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