/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package com.twitter.zipkin.gen;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.thrift.*;
import org.apache.thrift.async.*;
import org.apache.thrift.meta_data.*;
import org.apache.thrift.transport.*;
import org.apache.thrift.protocol.*;

public class scribe {

  public interface Iface {

    public ResultCode Log(List<LogEntry> messages) throws TException;

  }

  public interface AsyncIface {

    public void Log(List<LogEntry> messages, AsyncMethodCallback<AsyncClient.Log_call> resultHandler) throws TException;

  }

  public static class Client implements TServiceClient, Iface {
    public static class Factory implements TServiceClientFactory<Client> {
      public Factory() {}
      public Client getClient(TProtocol prot) {
        return new Client(prot);
      }
      public Client getClient(TProtocol iprot, TProtocol oprot) {
        return new Client(iprot, oprot);
      }
    }

    public Client(TProtocol prot)
    {
      this(prot, prot);
    }

    public Client(TProtocol iprot, TProtocol oprot)
    {
      iprot_ = iprot;
      oprot_ = oprot;
    }

    protected TProtocol iprot_;
    protected TProtocol oprot_;

    protected int seqid_;

    public TProtocol getInputProtocol()
    {
      return this.iprot_;
    }

    public TProtocol getOutputProtocol()
    {
      return this.oprot_;
    }

    public ResultCode Log(List<LogEntry> messages) throws TException
    {
      send_Log(messages);
      return recv_Log();
    }

    public void send_Log(List<LogEntry> messages) throws TException
    {
      oprot_.writeMessageBegin(new TMessage("Log", TMessageType.CALL, ++seqid_));
      Log_args args = new Log_args();
      args.setMessages(messages);
      args.write(oprot_);
      oprot_.writeMessageEnd();
      oprot_.getTransport().flush();
    }

    public ResultCode recv_Log() throws TException
    {
      TMessage msg = iprot_.readMessageBegin();
      if (msg.type == TMessageType.EXCEPTION) {
        TApplicationException x = TApplicationException.read(iprot_);
        iprot_.readMessageEnd();
        throw x;
      }
      if (msg.seqid != seqid_) {
        throw new TApplicationException(TApplicationException.BAD_SEQUENCE_ID, "Log failed: out of sequence response");
      }
      Log_result result = new Log_result();
      result.read(iprot_);
      iprot_.readMessageEnd();
      if (result.isSetSuccess()) {
        return result.success;
      }
      throw new TApplicationException(TApplicationException.MISSING_RESULT, "Log failed: unknown result");
    }

  }
  public static class AsyncClient extends TAsyncClient implements AsyncIface {
    public static class Factory implements TAsyncClientFactory<AsyncClient> {
      private TAsyncClientManager clientManager;
      private TProtocolFactory protocolFactory;
      public Factory(TAsyncClientManager clientManager, TProtocolFactory protocolFactory) {
        this.clientManager = clientManager;
        this.protocolFactory = protocolFactory;
      }
      public AsyncClient getAsyncClient(TNonblockingTransport transport) {
        return new AsyncClient(protocolFactory, clientManager, transport);
      }
    }

    public AsyncClient(TProtocolFactory protocolFactory, TAsyncClientManager clientManager, TNonblockingTransport transport) {
      super(protocolFactory, clientManager, transport);
    }

    public void Log(List<LogEntry> messages, AsyncMethodCallback<Log_call> resultHandler) throws TException {
      checkReady();
      Log_call method_call = new Log_call(messages, resultHandler, this, protocolFactory, transport);
      manager.call(method_call);
    }

    public static class Log_call extends TAsyncMethodCall {
      private List<LogEntry> messages;
      public Log_call(List<LogEntry> messages, AsyncMethodCallback<Log_call> resultHandler, TAsyncClient client, TProtocolFactory protocolFactory, TNonblockingTransport transport) throws TException {
        super(client, protocolFactory, transport, resultHandler, false);
        this.messages = messages;
      }

      public void write_args(TProtocol prot) throws TException {
        prot.writeMessageBegin(new TMessage("Log", TMessageType.CALL, 0));
        Log_args args = new Log_args();
        args.setMessages(messages);
        args.write(prot);
        prot.writeMessageEnd();
      }

      public ResultCode getResult() throws TException {
        if (getState() != State.RESPONSE_READ) {
          throw new IllegalStateException("Method call not finished!");
        }
        TMemoryInputTransport memoryTransport = new TMemoryInputTransport(getFrameBuffer().array());
        TProtocol prot = client.getProtocolFactory().getProtocol(memoryTransport);
        return (new Client(prot)).recv_Log();
      }
    }

  }

  public static class Processor implements TProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(Processor.class.getName());
    public Processor(Iface iface)
    {
      iface_ = iface;
      processMap_.put("Log", new Log());
    }

    protected static interface ProcessFunction {
      public void process(int seqid, TProtocol iprot, TProtocol oprot) throws TException;
    }

    private Iface iface_;
    protected final HashMap<String,ProcessFunction> processMap_ = new HashMap<String,ProcessFunction>();

    public boolean process(TProtocol iprot, TProtocol oprot) throws TException
    {
      TMessage msg = iprot.readMessageBegin();
      ProcessFunction fn = processMap_.get(msg.name);
      if (fn == null) {
        TProtocolUtil.skip(iprot, TType.STRUCT);
        iprot.readMessageEnd();
        TApplicationException x = new TApplicationException(TApplicationException.UNKNOWN_METHOD, "Invalid method name: '"+msg.name+"'");
        oprot.writeMessageBegin(new TMessage(msg.name, TMessageType.EXCEPTION, msg.seqid));
        x.write(oprot);
        oprot.writeMessageEnd();
        oprot.getTransport().flush();
        return true;
      }
      fn.process(msg.seqid, iprot, oprot);
      return true;
    }

    private class Log implements ProcessFunction {
      public void process(int seqid, TProtocol iprot, TProtocol oprot) throws TException
      {
        Log_args args = new Log_args();
        try {
          args.read(iprot);
        } catch (TProtocolException e) {
          iprot.readMessageEnd();
          TApplicationException x = new TApplicationException(TApplicationException.PROTOCOL_ERROR, e.getMessage());
          oprot.writeMessageBegin(new TMessage("Log", TMessageType.EXCEPTION, seqid));
          x.write(oprot);
          oprot.writeMessageEnd();
          oprot.getTransport().flush();
          return;
        }
        iprot.readMessageEnd();
        Log_result result = new Log_result();
        result.success = iface_.Log(args.messages);
        oprot.writeMessageBegin(new TMessage("Log", TMessageType.REPLY, seqid));
        result.write(oprot);
        oprot.writeMessageEnd();
        oprot.getTransport().flush();
      }

    }

  }

  public static class Log_args implements TBase<Log_args, Log_args._Fields>, java.io.Serializable, Cloneable   {
    private static final TStruct STRUCT_DESC = new TStruct("Log_args");

    private static final TField MESSAGES_FIELD_DESC = new TField("messages", TType.LIST, (short)1);

    public List<LogEntry> messages;

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements TFieldIdEnum {
      MESSAGES((short)1, "messages");

      private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

      static {
        for (_Fields field : EnumSet.allOf(_Fields.class)) {
          byName.put(field.getFieldName(), field);
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, or null if its not found.
       */
      public static _Fields findByThriftId(int fieldId) {
        switch(fieldId) {
          case 1: // MESSAGES
            return MESSAGES;
          default:
            return null;
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, throwing an exception
       * if it is not found.
       */
      public static _Fields findByThriftIdOrThrow(int fieldId) {
        _Fields fields = findByThriftId(fieldId);
        if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
        return fields;
      }

      /**
       * Find the _Fields constant that matches name, or null if its not found.
       */
      public static _Fields findByName(String name) {
        return byName.get(name);
      }

      private final short _thriftId;
      private final String _fieldName;

      _Fields(short thriftId, String fieldName) {
        _thriftId = thriftId;
        _fieldName = fieldName;
      }

      public short getThriftFieldId() {
        return _thriftId;
      }

      public String getFieldName() {
        return _fieldName;
      }
    }

    // isset id assignments

    public static final Map<_Fields, FieldMetaData> metaDataMap;
    static {
      Map<_Fields, FieldMetaData> tmpMap = new EnumMap<_Fields, FieldMetaData>(_Fields.class);
      tmpMap.put(_Fields.MESSAGES, new FieldMetaData("messages", TFieldRequirementType.DEFAULT, 
          new ListMetaData(TType.LIST, 
              new StructMetaData(TType.STRUCT, LogEntry.class))));
      metaDataMap = Collections.unmodifiableMap(tmpMap);
      FieldMetaData.addStructMetaDataMap(Log_args.class, metaDataMap);
    }

    public Log_args() {
    }

    public Log_args(
      List<LogEntry> messages)
    {
      this();
      this.messages = messages;
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public Log_args(Log_args other) {
      if (other.isSetMessages()) {
        List<LogEntry> __this__messages = new ArrayList<LogEntry>();
        for (LogEntry other_element : other.messages) {
          __this__messages.add(new LogEntry(other_element));
        }
        this.messages = __this__messages;
      }
    }

    public Log_args deepCopy() {
      return new Log_args(this);
    }

    @Override
    public void clear() {
      this.messages = null;
    }

    public int getMessagesSize() {
      return (this.messages == null) ? 0 : this.messages.size();
    }

    public java.util.Iterator<LogEntry> getMessagesIterator() {
      return (this.messages == null) ? null : this.messages.iterator();
    }

    public void addToMessages(LogEntry elem) {
      if (this.messages == null) {
        this.messages = new ArrayList<LogEntry>();
      }
      this.messages.add(elem);
    }

    public List<LogEntry> getMessages() {
      return this.messages;
    }

    public Log_args setMessages(List<LogEntry> messages) {
      this.messages = messages;
      return this;
    }

    public void unsetMessages() {
      this.messages = null;
    }

    /** Returns true if field messages is set (has been asigned a value) and false otherwise */
    public boolean isSetMessages() {
      return this.messages != null;
    }

    public void setMessagesIsSet(boolean value) {
      if (!value) {
        this.messages = null;
      }
    }

    public void setFieldValue(_Fields field, Object value) {
      switch (field) {
      case MESSAGES:
        if (value == null) {
          unsetMessages();
        } else {
          setMessages((List<LogEntry>)value);
        }
        break;

      }
    }

    public Object getFieldValue(_Fields field) {
      switch (field) {
      case MESSAGES:
        return getMessages();

      }
      throw new IllegalStateException();
    }

    /** Returns true if field corresponding to fieldID is set (has been asigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
      if (field == null) {
        throw new IllegalArgumentException();
      }

      switch (field) {
      case MESSAGES:
        return isSetMessages();
      }
      throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object that) {
      if (that == null)
        return false;
      if (that instanceof Log_args)
        return this.equals((Log_args)that);
      return false;
    }

    public boolean equals(Log_args that) {
      if (that == null)
        return false;

      boolean this_present_messages = true && this.isSetMessages();
      boolean that_present_messages = true && that.isSetMessages();
      if (this_present_messages || that_present_messages) {
        if (!(this_present_messages && that_present_messages))
          return false;
        if (!this.messages.equals(that.messages))
          return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      return 0;
    }

    public int compareTo(Log_args other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;
      Log_args typedOther = (Log_args)other;

      lastComparison = Boolean.valueOf(isSetMessages()).compareTo(typedOther.isSetMessages());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetMessages()) {
        lastComparison = TBaseHelper.compareTo(this.messages, typedOther.messages);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      return 0;
    }

    public _Fields fieldForId(int fieldId) {
      return _Fields.findByThriftId(fieldId);
    }

    public void read(TProtocol iprot) throws TException {
      TField field;
      iprot.readStructBegin();
      while (true)
      {
        field = iprot.readFieldBegin();
        if (field.type == TType.STOP) { 
          break;
        }
        switch (field.id) {
          case 1: // MESSAGES
            if (field.type == TType.LIST) {
              {
                TList _list0 = iprot.readListBegin();
                this.messages = new ArrayList<LogEntry>(_list0.size);
                for (int _i1 = 0; _i1 < _list0.size; ++_i1)
                {
                  LogEntry _elem2;
                  _elem2 = new LogEntry();
                  _elem2.read(iprot);
                  this.messages.add(_elem2);
                }
                iprot.readListEnd();
              }
            } else { 
              TProtocolUtil.skip(iprot, field.type);
            }
            break;
          default:
            TProtocolUtil.skip(iprot, field.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      validate();
    }

    public void write(TProtocol oprot) throws TException {
      validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (this.messages != null) {
        oprot.writeFieldBegin(MESSAGES_FIELD_DESC);
        {
          oprot.writeListBegin(new TList(TType.STRUCT, this.messages.size()));
          for (LogEntry _iter3 : this.messages)
          {
            _iter3.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("Log_args(");
      boolean first = true;

      sb.append("messages:");
      if (this.messages == null) {
        sb.append("null");
      } else {
        sb.append(this.messages);
      }
      first = false;
      sb.append(")");
      return sb.toString();
    }

    public void validate() throws TException {
      // check for required fields
    }

  }

  public static class Log_result implements TBase<Log_result, Log_result._Fields>, java.io.Serializable, Cloneable   {
    private static final TStruct STRUCT_DESC = new TStruct("Log_result");

    private static final TField SUCCESS_FIELD_DESC = new TField("success", TType.I32, (short)0);

    /**
     * 
     * @see ResultCode
     */
    public ResultCode success;

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements TFieldIdEnum {
      /**
       * 
       * @see ResultCode
       */
      SUCCESS((short)0, "success");

      private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

      static {
        for (_Fields field : EnumSet.allOf(_Fields.class)) {
          byName.put(field.getFieldName(), field);
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, or null if its not found.
       */
      public static _Fields findByThriftId(int fieldId) {
        switch(fieldId) {
          case 0: // SUCCESS
            return SUCCESS;
          default:
            return null;
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, throwing an exception
       * if it is not found.
       */
      public static _Fields findByThriftIdOrThrow(int fieldId) {
        _Fields fields = findByThriftId(fieldId);
        if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
        return fields;
      }

      /**
       * Find the _Fields constant that matches name, or null if its not found.
       */
      public static _Fields findByName(String name) {
        return byName.get(name);
      }

      private final short _thriftId;
      private final String _fieldName;

      _Fields(short thriftId, String fieldName) {
        _thriftId = thriftId;
        _fieldName = fieldName;
      }

      public short getThriftFieldId() {
        return _thriftId;
      }

      public String getFieldName() {
        return _fieldName;
      }
    }

    // isset id assignments

    public static final Map<_Fields, FieldMetaData> metaDataMap;
    static {
      Map<_Fields, FieldMetaData> tmpMap = new EnumMap<_Fields, FieldMetaData>(_Fields.class);
      tmpMap.put(_Fields.SUCCESS, new FieldMetaData("success", TFieldRequirementType.DEFAULT, 
          new EnumMetaData(TType.ENUM, ResultCode.class)));
      metaDataMap = Collections.unmodifiableMap(tmpMap);
      FieldMetaData.addStructMetaDataMap(Log_result.class, metaDataMap);
    }

    public Log_result() {
    }

    public Log_result(
      ResultCode success)
    {
      this();
      this.success = success;
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public Log_result(Log_result other) {
      if (other.isSetSuccess()) {
        this.success = other.success;
      }
    }

    public Log_result deepCopy() {
      return new Log_result(this);
    }

    @Override
    public void clear() {
      this.success = null;
    }

    /**
     * 
     * @see ResultCode
     */
    public ResultCode getSuccess() {
      return this.success;
    }

    /**
     * 
     * @see ResultCode
     */
    public Log_result setSuccess(ResultCode success) {
      this.success = success;
      return this;
    }

    public void unsetSuccess() {
      this.success = null;
    }

    /** Returns true if field success is set (has been asigned a value) and false otherwise */
    public boolean isSetSuccess() {
      return this.success != null;
    }

    public void setSuccessIsSet(boolean value) {
      if (!value) {
        this.success = null;
      }
    }

    public void setFieldValue(_Fields field, Object value) {
      switch (field) {
      case SUCCESS:
        if (value == null) {
          unsetSuccess();
        } else {
          setSuccess((ResultCode)value);
        }
        break;

      }
    }

    public Object getFieldValue(_Fields field) {
      switch (field) {
      case SUCCESS:
        return getSuccess();

      }
      throw new IllegalStateException();
    }

    /** Returns true if field corresponding to fieldID is set (has been asigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
      if (field == null) {
        throw new IllegalArgumentException();
      }

      switch (field) {
      case SUCCESS:
        return isSetSuccess();
      }
      throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object that) {
      if (that == null)
        return false;
      if (that instanceof Log_result)
        return this.equals((Log_result)that);
      return false;
    }

    public boolean equals(Log_result that) {
      if (that == null)
        return false;

      boolean this_present_success = true && this.isSetSuccess();
      boolean that_present_success = true && that.isSetSuccess();
      if (this_present_success || that_present_success) {
        if (!(this_present_success && that_present_success))
          return false;
        if (!this.success.equals(that.success))
          return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      return 0;
    }

    public int compareTo(Log_result other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;
      Log_result typedOther = (Log_result)other;

      lastComparison = Boolean.valueOf(isSetSuccess()).compareTo(typedOther.isSetSuccess());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetSuccess()) {
        lastComparison = TBaseHelper.compareTo(this.success, typedOther.success);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      return 0;
    }

    public _Fields fieldForId(int fieldId) {
      return _Fields.findByThriftId(fieldId);
    }

    public void read(TProtocol iprot) throws TException {
      TField field;
      iprot.readStructBegin();
      while (true)
      {
        field = iprot.readFieldBegin();
        if (field.type == TType.STOP) { 
          break;
        }
        switch (field.id) {
          case 0: // SUCCESS
            if (field.type == TType.I32) {
              this.success = ResultCode.findByValue(iprot.readI32());
            } else { 
              TProtocolUtil.skip(iprot, field.type);
            }
            break;
          default:
            TProtocolUtil.skip(iprot, field.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      validate();
    }

    public void write(TProtocol oprot) throws TException {
      oprot.writeStructBegin(STRUCT_DESC);

      if (this.isSetSuccess()) {
        oprot.writeFieldBegin(SUCCESS_FIELD_DESC);
        oprot.writeI32(this.success.getValue());
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("Log_result(");
      boolean first = true;

      sb.append("success:");
      if (this.success == null) {
        sb.append("null");
      } else {
        sb.append(this.success);
      }
      first = false;
      sb.append(")");
      return sb.toString();
    }

    public void validate() throws TException {
      // check for required fields
    }

  }

}
