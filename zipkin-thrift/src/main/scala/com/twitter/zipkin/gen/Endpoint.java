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

public class Endpoint implements TBase<Endpoint, Endpoint._Fields>, java.io.Serializable, Cloneable {
  private static final TStruct STRUCT_DESC = new TStruct("Endpoint");

  private static final TField IPV4_FIELD_DESC = new TField("ipv4", TType.I32, (short)1);
  private static final TField PORT_FIELD_DESC = new TField("port", TType.I16, (short)2);
  private static final TField SERVICE_NAME_FIELD_DESC = new TField("service_name", TType.STRING, (short)3);

  public int ipv4;
  public short port;
  public String service_name;

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements TFieldIdEnum {
    IPV4((short)1, "ipv4"),
    PORT((short)2, "port"),
    SERVICE_NAME((short)3, "service_name");

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
        case 1: // IPV4
          return IPV4;
        case 2: // PORT
          return PORT;
        case 3: // SERVICE_NAME
          return SERVICE_NAME;
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
  private static final int __IPV4_ISSET_ID = 0;
  private static final int __PORT_ISSET_ID = 1;
  private BitSet __isset_bit_vector = new BitSet(2);

  public static final Map<_Fields, FieldMetaData> metaDataMap;
  static {
    Map<_Fields, FieldMetaData> tmpMap = new EnumMap<_Fields, FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.IPV4, new FieldMetaData("ipv4", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.I32)));
    tmpMap.put(_Fields.PORT, new FieldMetaData("port", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.I16)));
    tmpMap.put(_Fields.SERVICE_NAME, new FieldMetaData("service_name", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    FieldMetaData.addStructMetaDataMap(Endpoint.class, metaDataMap);
  }

  public Endpoint() {
  }

  public Endpoint(
    int ipv4,
    short port,
    String service_name)
  {
    this();
    this.ipv4 = ipv4;
    setIpv4IsSet(true);
    this.port = port;
    setPortIsSet(true);
    this.service_name = service_name;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Endpoint(Endpoint other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    this.ipv4 = other.ipv4;
    this.port = other.port;
    if (other.isSetService_name()) {
      this.service_name = other.service_name;
    }
  }

  public Endpoint deepCopy() {
    return new Endpoint(this);
  }

  @Override
  public void clear() {
    setIpv4IsSet(false);
    this.ipv4 = 0;
    setPortIsSet(false);
    this.port = 0;
    this.service_name = null;
  }

  public int getIpv4() {
    return this.ipv4;
  }

  public Endpoint setIpv4(int ipv4) {
    this.ipv4 = ipv4;
    setIpv4IsSet(true);
    return this;
  }

  public void unsetIpv4() {
    __isset_bit_vector.clear(__IPV4_ISSET_ID);
  }

  /** Returns true if field ipv4 is set (has been asigned a value) and false otherwise */
  public boolean isSetIpv4() {
    return __isset_bit_vector.get(__IPV4_ISSET_ID);
  }

  public void setIpv4IsSet(boolean value) {
    __isset_bit_vector.set(__IPV4_ISSET_ID, value);
  }

  public short getPort() {
    return this.port;
  }

  public Endpoint setPort(short port) {
    this.port = port;
    setPortIsSet(true);
    return this;
  }

  public void unsetPort() {
    __isset_bit_vector.clear(__PORT_ISSET_ID);
  }

  /** Returns true if field port is set (has been asigned a value) and false otherwise */
  public boolean isSetPort() {
    return __isset_bit_vector.get(__PORT_ISSET_ID);
  }

  public void setPortIsSet(boolean value) {
    __isset_bit_vector.set(__PORT_ISSET_ID, value);
  }

  public String getService_name() {
    return this.service_name;
  }

  public Endpoint setService_name(String service_name) {
    this.service_name = service_name;
    return this;
  }

  public void unsetService_name() {
    this.service_name = null;
  }

  /** Returns true if field service_name is set (has been asigned a value) and false otherwise */
  public boolean isSetService_name() {
    return this.service_name != null;
  }

  public void setService_nameIsSet(boolean value) {
    if (!value) {
      this.service_name = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case IPV4:
      if (value == null) {
        unsetIpv4();
      } else {
        setIpv4((Integer)value);
      }
      break;

    case PORT:
      if (value == null) {
        unsetPort();
      } else {
        setPort((Short)value);
      }
      break;

    case SERVICE_NAME:
      if (value == null) {
        unsetService_name();
      } else {
        setService_name((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case IPV4:
      return new Integer(getIpv4());

    case PORT:
      return new Short(getPort());

    case SERVICE_NAME:
      return getService_name();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been asigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case IPV4:
      return isSetIpv4();
    case PORT:
      return isSetPort();
    case SERVICE_NAME:
      return isSetService_name();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Endpoint)
      return this.equals((Endpoint)that);
    return false;
  }

  public boolean equals(Endpoint that) {
    if (that == null)
      return false;

    boolean this_present_ipv4 = true;
    boolean that_present_ipv4 = true;
    if (this_present_ipv4 || that_present_ipv4) {
      if (!(this_present_ipv4 && that_present_ipv4))
        return false;
      if (this.ipv4 != that.ipv4)
        return false;
    }

    boolean this_present_port = true;
    boolean that_present_port = true;
    if (this_present_port || that_present_port) {
      if (!(this_present_port && that_present_port))
        return false;
      if (this.port != that.port)
        return false;
    }

    boolean this_present_service_name = true && this.isSetService_name();
    boolean that_present_service_name = true && that.isSetService_name();
    if (this_present_service_name || that_present_service_name) {
      if (!(this_present_service_name && that_present_service_name))
        return false;
      if (!this.service_name.equals(that.service_name))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(Endpoint other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    Endpoint typedOther = (Endpoint)other;

    lastComparison = Boolean.valueOf(isSetIpv4()).compareTo(typedOther.isSetIpv4());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIpv4()) {
      lastComparison = TBaseHelper.compareTo(this.ipv4, typedOther.ipv4);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPort()).compareTo(typedOther.isSetPort());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPort()) {
      lastComparison = TBaseHelper.compareTo(this.port, typedOther.port);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetService_name()).compareTo(typedOther.isSetService_name());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetService_name()) {
      lastComparison = TBaseHelper.compareTo(this.service_name, typedOther.service_name);
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
        case 1: // IPV4
          if (field.type == TType.I32) {
            this.ipv4 = iprot.readI32();
            setIpv4IsSet(true);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // PORT
          if (field.type == TType.I16) {
            this.port = iprot.readI16();
            setPortIsSet(true);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // SERVICE_NAME
          if (field.type == TType.STRING) {
            this.service_name = iprot.readString();
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
    oprot.writeFieldBegin(IPV4_FIELD_DESC);
    oprot.writeI32(this.ipv4);
    oprot.writeFieldEnd();
    oprot.writeFieldBegin(PORT_FIELD_DESC);
    oprot.writeI16(this.port);
    oprot.writeFieldEnd();
    if (this.service_name != null) {
      oprot.writeFieldBegin(SERVICE_NAME_FIELD_DESC);
      oprot.writeString(this.service_name);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Endpoint(");
    boolean first = true;

    sb.append("ipv4:");
    sb.append(this.ipv4);
    first = false;
    if (!first) sb.append(", ");
    sb.append("port:");
    sb.append(this.port);
    first = false;
    if (!first) sb.append(", ");
    sb.append("service_name:");
    if (this.service_name == null) {
      sb.append("null");
    } else {
      sb.append(this.service_name);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
  }

}

