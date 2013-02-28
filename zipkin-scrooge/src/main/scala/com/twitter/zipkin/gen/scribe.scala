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


object scribe {
  trait Iface {
    def log(`messages`: Seq[LogEntry] = Seq[LogEntry]()): ResultCode
  }

  trait FutureIface {
    def log(`messages`: Seq[LogEntry] = Seq[LogEntry]()): Future[ResultCode]
  }

  object log_args extends ThriftStructCodec[log_args] {
    val Struct = new TStruct("log_args")
    val MessagesField = new TField("messages", TType.LIST, 1)
  
    def encode(_item: log_args, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = Immutable.decode(_iprot)
  
    def apply(_iprot: TProtocol): log_args = decode(_iprot)
  
    def apply(
      `messages`: Seq[LogEntry] = Seq[LogEntry]()
    ): log_args = new Immutable(
      `messages`
    )
  
    def unapply(_item: log_args): Option[Seq[LogEntry]] = Some(_item.messages)
  
    object Immutable extends ThriftStructCodec[log_args] {
      def encode(_item: log_args, _oproto: TProtocol) { _item.write(_oproto) }
      def decode(_iprot: TProtocol) = {
        var `messages`: Seq[LogEntry] = Seq[LogEntry]()
        var _got_messages = false
        var _done = false
        _iprot.readStructBegin()
        while (!_done) {
          val _field = _iprot.readFieldBegin()
          if (_field.`type` == TType.STOP) {
            _done = true
          } else {
            _field.id match {
              case 1 => { /* messages */
                _field.`type` match {
                  case TType.LIST => {
                    `messages` = {
                      val _list = _iprot.readListBegin()
                      val _rv = new mutable.ArrayBuffer[LogEntry](_list.size)
                      var _i = 0
                      while (_i < _list.size) {
                        _rv += {
                          LogEntry.decode(_iprot)
                        }
                        _i += 1
                      }
                      _iprot.readListEnd()
                      _rv
                    }
                    _got_messages = true
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
          `messages`
        )
      }
    }
  
    /**
     * The default read-only implementation of log_args.  You typically should not need to
     * directly reference this class; instead, use the log_args.apply method to construct
     * new instances.
     */
    class Immutable(
      val `messages`: Seq[LogEntry] = Seq[LogEntry]()
    ) extends log_args
  
  }
  
  trait log_args extends ThriftStruct
    with Product1[Seq[LogEntry]]
    with java.io.Serializable
  {
    import log_args._
  
    def `messages`: Seq[LogEntry]
  
    def _1 = `messages`
  
    override def write(_oprot: TProtocol) {
      validate()
      _oprot.writeStructBegin(Struct)
      if (true) {
        val `messages_item` = `messages`
        _oprot.writeFieldBegin(MessagesField)
        _oprot.writeListBegin(new TList(TType.STRUCT, `messages_item`.size))
        `messages_item`.foreach { `_messages_item_element` =>
          `_messages_item_element`.write(_oprot)
        }
        _oprot.writeListEnd()
        _oprot.writeFieldEnd()
      }
      _oprot.writeFieldStop()
      _oprot.writeStructEnd()
    }
  
    def copy(
      `messages`: Seq[LogEntry] = this.`messages`
    ): log_args = new Immutable(
      `messages`
    )
  
    /**
     * Checks that all required fields are non-null.
     */
    def validate() {
    }
  
    def canEqual(other: Any) = other.isInstanceOf[log_args]
  
    override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)
  
    override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)
  
    override def toString: String = runtime.ScalaRunTime._toString(this)
  
    override def productArity = 1
  
    override def productElement(n: Int): Any = n match {
      case 0 => `messages`
      case _ => throw new IndexOutOfBoundsException(n.toString)
    }
  
    override def productPrefix = "log_args"
  }
  object log_result extends ThriftStructCodec[log_result] {
    val Struct = new TStruct("log_result")
    val SuccessField = new TField("success", TType.I32, 0)
  
    def encode(_item: log_result, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = Immutable.decode(_iprot)
  
    def apply(_iprot: TProtocol): log_result = decode(_iprot)
  
    def apply(
      `success`: Option[ResultCode] = None
    ): log_result = new Immutable(
      `success`
    )
  
    def unapply(_item: log_result): Option[Option[ResultCode]] = Some(_item.success)
  
    object Immutable extends ThriftStructCodec[log_result] {
      def encode(_item: log_result, _oproto: TProtocol) { _item.write(_oproto) }
      def decode(_iprot: TProtocol) = {
        var `success`: ResultCode = null
        var _got_success = false
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
                      ResultCode(_iprot.readI32())
                    }
                    _got_success = true
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
          if (_got_success) Some(`success`) else None
        )
      }
    }
  
    /**
     * The default read-only implementation of log_result.  You typically should not need to
     * directly reference this class; instead, use the log_result.apply method to construct
     * new instances.
     */
    class Immutable(
      val `success`: Option[ResultCode] = None
    ) extends log_result
  
  }
  
  trait log_result extends ThriftStruct
    with Product1[Option[ResultCode]]
    with java.io.Serializable
  {
    import log_result._
  
    def `success`: Option[ResultCode]
  
    def _1 = `success`
  
    override def write(_oprot: TProtocol) {
      validate()
      _oprot.writeStructBegin(Struct)
      if (`success`.isDefined) {
        val `success_item` = `success`.get
        _oprot.writeFieldBegin(SuccessField)
        _oprot.writeI32(`success_item`.value)
        _oprot.writeFieldEnd()
      }
      _oprot.writeFieldStop()
      _oprot.writeStructEnd()
    }
  
    def copy(
      `success`: Option[ResultCode] = this.`success`
    ): log_result = new Immutable(
      `success`
    )
  
    /**
     * Checks that all required fields are non-null.
     */
    def validate() {
    }
  
    def canEqual(other: Any) = other.isInstanceOf[log_result]
  
    override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)
  
    override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)
  
    override def toString: String = runtime.ScalaRunTime._toString(this)
  
    override def productArity = 1
  
    override def productElement(n: Int): Any = n match {
      case 0 => `success`
      case _ => throw new IndexOutOfBoundsException(n.toString)
    }
  
    override def productPrefix = "log_result"
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
    private[this] object __stats_Log {
      val RequestsCounter = scopedStats.scope("Log").counter("requests")
      val SuccessCounter = scopedStats.scope("Log").counter("success")
      val FailuresCounter = scopedStats.scope("Log").counter("failures")
      val FailuresScope = scopedStats.scope("Log").scope("failures")
    }
  
    def log(`messages`: Seq[LogEntry] = Seq[LogEntry]()): Future[ResultCode] = {
      __stats_Log.RequestsCounter.incr()
      this.service(encodeRequest("Log", log_args(messages))) flatMap { response =>
        val result = decodeResponse(response, log_result)
        val exception =
          None
        exception.orElse(result.success.map(Future.value)).getOrElse(Future.exception(missingResult("Log")))
      } rescue {
        case ex: SourcedException => {
          if (this.serviceName != "") { ex.serviceName = this.serviceName }
          Future.exception(ex)
        }
      } onSuccess { _ =>
        __stats_Log.SuccessCounter.incr()
      } onFailure { ex =>
        __stats_Log.FailuresCounter.incr()
        __stats_Log.FailuresScope.counter(ex.getClass.getName).incr()
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
  
    addFunction("Log", { (iprot: TProtocol, seqid: Int) =>
      try {
        val args = log_args.decode(iprot)
        iprot.readMessageEnd()
        (try {
          iface.log(args.messages)
        } catch {
          case e: Exception => Future.exception(e)
        }) flatMap { value: ResultCode =>
          reply("Log", seqid, log_result(success = Some(value)))
        } rescue {
          case e => Future.exception(e)
        }
      } catch {
        case e: TProtocolException => {
          iprot.readMessageEnd()
          exception("Log", seqid, TApplicationException.PROTOCOL_ERROR, e.getMessage)
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