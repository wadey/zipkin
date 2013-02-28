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

public class Span implements TBase<Span, Span._Fields>, java.io.Serializable, Cloneable {
  private static final TStruct STRUCT_DESC = new TStruct("Span");

  private static final TField TRACE_ID_FIELD_DESC = new TField("trace_id", TType.I64, (short)1);
  private static final TField NAME_FIELD_DESC = new TField("name", TType.STRING, (short)3);
  private static final TField ID_FIELD_DESC = new TField("id", TType.I64, (short)4);
  private static final TField PARENT_ID_FIELD_DESC = new TField("parent_id", TType.I64, (short)5);
  private static final TField ANNOTATIONS_FIELD_DESC = new TField("annotations", TType.LIST, (short)6);
  private static final TField BINARY_ANNOTATIONS_FIELD_DESC = new TField("binary_annotations", TType.LIST, (short)8);
  private static final TField DEBUG_FIELD_DESC = new TField("debug", TType.BOOL, (short)9);

  public long trace_id;
  public String name;
  public long id;
  public long parent_id;
  public List<Annotation> annotations;
  public List<BinaryAnnotation> binary_annotations;
  public boolean debug;

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements TFieldIdEnum {
    TRACE_ID((short)1, "trace_id"),
    NAME((short)3, "name"),
    ID((short)4, "id"),
    PARENT_ID((short)5, "parent_id"),
    ANNOTATIONS((short)6, "annotations"),
    BINARY_ANNOTATIONS((short)8, "binary_annotations"),
    DEBUG((short)9, "debug");

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
        case 1: // TRACE_ID
          return TRACE_ID;
        case 3: // NAME
          return NAME;
        case 4: // ID
          return ID;
        case 5: // PARENT_ID
          return PARENT_ID;
        case 6: // ANNOTATIONS
          return ANNOTATIONS;
        case 8: // BINARY_ANNOTATIONS
          return BINARY_ANNOTATIONS;
        case 9: // DEBUG
          return DEBUG;
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
  private static final int __TRACE_ID_ISSET_ID = 0;
  private static final int __ID_ISSET_ID = 1;
  private static final int __PARENT_ID_ISSET_ID = 2;
  private static final int __DEBUG_ISSET_ID = 3;
  private BitSet __isset_bit_vector = new BitSet(4);

  public static final Map<_Fields, FieldMetaData> metaDataMap;
  static {
    Map<_Fields, FieldMetaData> tmpMap = new EnumMap<_Fields, FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TRACE_ID, new FieldMetaData("trace_id", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.I64)));
    tmpMap.put(_Fields.NAME, new FieldMetaData("name", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.STRING)));
    tmpMap.put(_Fields.ID, new FieldMetaData("id", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.I64)));
    tmpMap.put(_Fields.PARENT_ID, new FieldMetaData("parent_id", TFieldRequirementType.OPTIONAL, 
        new FieldValueMetaData(TType.I64)));
    tmpMap.put(_Fields.ANNOTATIONS, new FieldMetaData("annotations", TFieldRequirementType.DEFAULT, 
        new ListMetaData(TType.LIST, 
            new StructMetaData(TType.STRUCT, Annotation.class))));
    tmpMap.put(_Fields.BINARY_ANNOTATIONS, new FieldMetaData("binary_annotations", TFieldRequirementType.DEFAULT, 
        new ListMetaData(TType.LIST, 
            new StructMetaData(TType.STRUCT, BinaryAnnotation.class))));
    tmpMap.put(_Fields.DEBUG, new FieldMetaData("debug", TFieldRequirementType.OPTIONAL, 
        new FieldValueMetaData(TType.BOOL)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    FieldMetaData.addStructMetaDataMap(Span.class, metaDataMap);
  }

  public Span() {
    this.debug = false;

  }

  public Span(
    long trace_id,
    String name,
    long id,
    List<Annotation> annotations,
    List<BinaryAnnotation> binary_annotations)
  {
    this();
    this.trace_id = trace_id;
    setTrace_idIsSet(true);
    this.name = name;
    this.id = id;
    setIdIsSet(true);
    this.annotations = annotations;
    this.binary_annotations = binary_annotations;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Span(Span other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    this.trace_id = other.trace_id;
    if (other.isSetName()) {
      this.name = other.name;
    }
    this.id = other.id;
    this.parent_id = other.parent_id;
    if (other.isSetAnnotations()) {
      List<Annotation> __this__annotations = new ArrayList<Annotation>();
      for (Annotation other_element : other.annotations) {
        __this__annotations.add(new Annotation(other_element));
      }
      this.annotations = __this__annotations;
    }
    if (other.isSetBinary_annotations()) {
      List<BinaryAnnotation> __this__binary_annotations = new ArrayList<BinaryAnnotation>();
      for (BinaryAnnotation other_element : other.binary_annotations) {
        __this__binary_annotations.add(new BinaryAnnotation(other_element));
      }
      this.binary_annotations = __this__binary_annotations;
    }
    this.debug = other.debug;
  }

  public Span deepCopy() {
    return new Span(this);
  }

  @Override
  public void clear() {
    setTrace_idIsSet(false);
    this.trace_id = 0;
    this.name = null;
    setIdIsSet(false);
    this.id = 0;
    setParent_idIsSet(false);
    this.parent_id = 0;
    this.annotations = null;
    this.binary_annotations = null;
    this.debug = false;

  }

  public long getTrace_id() {
    return this.trace_id;
  }

  public Span setTrace_id(long trace_id) {
    this.trace_id = trace_id;
    setTrace_idIsSet(true);
    return this;
  }

  public void unsetTrace_id() {
    __isset_bit_vector.clear(__TRACE_ID_ISSET_ID);
  }

  /** Returns true if field trace_id is set (has been asigned a value) and false otherwise */
  public boolean isSetTrace_id() {
    return __isset_bit_vector.get(__TRACE_ID_ISSET_ID);
  }

  public void setTrace_idIsSet(boolean value) {
    __isset_bit_vector.set(__TRACE_ID_ISSET_ID, value);
  }

  public String getName() {
    return this.name;
  }

  public Span setName(String name) {
    this.name = name;
    return this;
  }

  public void unsetName() {
    this.name = null;
  }

  /** Returns true if field name is set (has been asigned a value) and false otherwise */
  public boolean isSetName() {
    return this.name != null;
  }

  public void setNameIsSet(boolean value) {
    if (!value) {
      this.name = null;
    }
  }

  public long getId() {
    return this.id;
  }

  public Span setId(long id) {
    this.id = id;
    setIdIsSet(true);
    return this;
  }

  public void unsetId() {
    __isset_bit_vector.clear(__ID_ISSET_ID);
  }

  /** Returns true if field id is set (has been asigned a value) and false otherwise */
  public boolean isSetId() {
    return __isset_bit_vector.get(__ID_ISSET_ID);
  }

  public void setIdIsSet(boolean value) {
    __isset_bit_vector.set(__ID_ISSET_ID, value);
  }

  public long getParent_id() {
    return this.parent_id;
  }

  public Span setParent_id(long parent_id) {
    this.parent_id = parent_id;
    setParent_idIsSet(true);
    return this;
  }

  public void unsetParent_id() {
    __isset_bit_vector.clear(__PARENT_ID_ISSET_ID);
  }

  /** Returns true if field parent_id is set (has been asigned a value) and false otherwise */
  public boolean isSetParent_id() {
    return __isset_bit_vector.get(__PARENT_ID_ISSET_ID);
  }

  public void setParent_idIsSet(boolean value) {
    __isset_bit_vector.set(__PARENT_ID_ISSET_ID, value);
  }

  public int getAnnotationsSize() {
    return (this.annotations == null) ? 0 : this.annotations.size();
  }

  public java.util.Iterator<Annotation> getAnnotationsIterator() {
    return (this.annotations == null) ? null : this.annotations.iterator();
  }

  public void addToAnnotations(Annotation elem) {
    if (this.annotations == null) {
      this.annotations = new ArrayList<Annotation>();
    }
    this.annotations.add(elem);
  }

  public List<Annotation> getAnnotations() {
    return this.annotations;
  }

  public Span setAnnotations(List<Annotation> annotations) {
    this.annotations = annotations;
    return this;
  }

  public void unsetAnnotations() {
    this.annotations = null;
  }

  /** Returns true if field annotations is set (has been asigned a value) and false otherwise */
  public boolean isSetAnnotations() {
    return this.annotations != null;
  }

  public void setAnnotationsIsSet(boolean value) {
    if (!value) {
      this.annotations = null;
    }
  }

  public int getBinary_annotationsSize() {
    return (this.binary_annotations == null) ? 0 : this.binary_annotations.size();
  }

  public java.util.Iterator<BinaryAnnotation> getBinary_annotationsIterator() {
    return (this.binary_annotations == null) ? null : this.binary_annotations.iterator();
  }

  public void addToBinary_annotations(BinaryAnnotation elem) {
    if (this.binary_annotations == null) {
      this.binary_annotations = new ArrayList<BinaryAnnotation>();
    }
    this.binary_annotations.add(elem);
  }

  public List<BinaryAnnotation> getBinary_annotations() {
    return this.binary_annotations;
  }

  public Span setBinary_annotations(List<BinaryAnnotation> binary_annotations) {
    this.binary_annotations = binary_annotations;
    return this;
  }

  public void unsetBinary_annotations() {
    this.binary_annotations = null;
  }

  /** Returns true if field binary_annotations is set (has been asigned a value) and false otherwise */
  public boolean isSetBinary_annotations() {
    return this.binary_annotations != null;
  }

  public void setBinary_annotationsIsSet(boolean value) {
    if (!value) {
      this.binary_annotations = null;
    }
  }

  public boolean isDebug() {
    return this.debug;
  }

  public Span setDebug(boolean debug) {
    this.debug = debug;
    setDebugIsSet(true);
    return this;
  }

  public void unsetDebug() {
    __isset_bit_vector.clear(__DEBUG_ISSET_ID);
  }

  /** Returns true if field debug is set (has been asigned a value) and false otherwise */
  public boolean isSetDebug() {
    return __isset_bit_vector.get(__DEBUG_ISSET_ID);
  }

  public void setDebugIsSet(boolean value) {
    __isset_bit_vector.set(__DEBUG_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case TRACE_ID:
      if (value == null) {
        unsetTrace_id();
      } else {
        setTrace_id((Long)value);
      }
      break;

    case NAME:
      if (value == null) {
        unsetName();
      } else {
        setName((String)value);
      }
      break;

    case ID:
      if (value == null) {
        unsetId();
      } else {
        setId((Long)value);
      }
      break;

    case PARENT_ID:
      if (value == null) {
        unsetParent_id();
      } else {
        setParent_id((Long)value);
      }
      break;

    case ANNOTATIONS:
      if (value == null) {
        unsetAnnotations();
      } else {
        setAnnotations((List<Annotation>)value);
      }
      break;

    case BINARY_ANNOTATIONS:
      if (value == null) {
        unsetBinary_annotations();
      } else {
        setBinary_annotations((List<BinaryAnnotation>)value);
      }
      break;

    case DEBUG:
      if (value == null) {
        unsetDebug();
      } else {
        setDebug((Boolean)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case TRACE_ID:
      return new Long(getTrace_id());

    case NAME:
      return getName();

    case ID:
      return new Long(getId());

    case PARENT_ID:
      return new Long(getParent_id());

    case ANNOTATIONS:
      return getAnnotations();

    case BINARY_ANNOTATIONS:
      return getBinary_annotations();

    case DEBUG:
      return new Boolean(isDebug());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been asigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case TRACE_ID:
      return isSetTrace_id();
    case NAME:
      return isSetName();
    case ID:
      return isSetId();
    case PARENT_ID:
      return isSetParent_id();
    case ANNOTATIONS:
      return isSetAnnotations();
    case BINARY_ANNOTATIONS:
      return isSetBinary_annotations();
    case DEBUG:
      return isSetDebug();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Span)
      return this.equals((Span)that);
    return false;
  }

  public boolean equals(Span that) {
    if (that == null)
      return false;

    boolean this_present_trace_id = true;
    boolean that_present_trace_id = true;
    if (this_present_trace_id || that_present_trace_id) {
      if (!(this_present_trace_id && that_present_trace_id))
        return false;
      if (this.trace_id != that.trace_id)
        return false;
    }

    boolean this_present_name = true && this.isSetName();
    boolean that_present_name = true && that.isSetName();
    if (this_present_name || that_present_name) {
      if (!(this_present_name && that_present_name))
        return false;
      if (!this.name.equals(that.name))
        return false;
    }

    boolean this_present_id = true;
    boolean that_present_id = true;
    if (this_present_id || that_present_id) {
      if (!(this_present_id && that_present_id))
        return false;
      if (this.id != that.id)
        return false;
    }

    boolean this_present_parent_id = true && this.isSetParent_id();
    boolean that_present_parent_id = true && that.isSetParent_id();
    if (this_present_parent_id || that_present_parent_id) {
      if (!(this_present_parent_id && that_present_parent_id))
        return false;
      if (this.parent_id != that.parent_id)
        return false;
    }

    boolean this_present_annotations = true && this.isSetAnnotations();
    boolean that_present_annotations = true && that.isSetAnnotations();
    if (this_present_annotations || that_present_annotations) {
      if (!(this_present_annotations && that_present_annotations))
        return false;
      if (!this.annotations.equals(that.annotations))
        return false;
    }

    boolean this_present_binary_annotations = true && this.isSetBinary_annotations();
    boolean that_present_binary_annotations = true && that.isSetBinary_annotations();
    if (this_present_binary_annotations || that_present_binary_annotations) {
      if (!(this_present_binary_annotations && that_present_binary_annotations))
        return false;
      if (!this.binary_annotations.equals(that.binary_annotations))
        return false;
    }

    boolean this_present_debug = true && this.isSetDebug();
    boolean that_present_debug = true && that.isSetDebug();
    if (this_present_debug || that_present_debug) {
      if (!(this_present_debug && that_present_debug))
        return false;
      if (this.debug != that.debug)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(Span other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    Span typedOther = (Span)other;

    lastComparison = Boolean.valueOf(isSetTrace_id()).compareTo(typedOther.isSetTrace_id());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTrace_id()) {
      lastComparison = TBaseHelper.compareTo(this.trace_id, typedOther.trace_id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetName()).compareTo(typedOther.isSetName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetName()) {
      lastComparison = TBaseHelper.compareTo(this.name, typedOther.name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetId()).compareTo(typedOther.isSetId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId()) {
      lastComparison = TBaseHelper.compareTo(this.id, typedOther.id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetParent_id()).compareTo(typedOther.isSetParent_id());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetParent_id()) {
      lastComparison = TBaseHelper.compareTo(this.parent_id, typedOther.parent_id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAnnotations()).compareTo(typedOther.isSetAnnotations());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAnnotations()) {
      lastComparison = TBaseHelper.compareTo(this.annotations, typedOther.annotations);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetBinary_annotations()).compareTo(typedOther.isSetBinary_annotations());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBinary_annotations()) {
      lastComparison = TBaseHelper.compareTo(this.binary_annotations, typedOther.binary_annotations);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDebug()).compareTo(typedOther.isSetDebug());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDebug()) {
      lastComparison = TBaseHelper.compareTo(this.debug, typedOther.debug);
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
        case 1: // TRACE_ID
          if (field.type == TType.I64) {
            this.trace_id = iprot.readI64();
            setTrace_idIsSet(true);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // NAME
          if (field.type == TType.STRING) {
            this.name = iprot.readString();
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 4: // ID
          if (field.type == TType.I64) {
            this.id = iprot.readI64();
            setIdIsSet(true);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 5: // PARENT_ID
          if (field.type == TType.I64) {
            this.parent_id = iprot.readI64();
            setParent_idIsSet(true);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 6: // ANNOTATIONS
          if (field.type == TType.LIST) {
            {
              TList _list0 = iprot.readListBegin();
              this.annotations = new ArrayList<Annotation>(_list0.size);
              for (int _i1 = 0; _i1 < _list0.size; ++_i1)
              {
                Annotation _elem2;
                _elem2 = new Annotation();
                _elem2.read(iprot);
                this.annotations.add(_elem2);
              }
              iprot.readListEnd();
            }
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 8: // BINARY_ANNOTATIONS
          if (field.type == TType.LIST) {
            {
              TList _list3 = iprot.readListBegin();
              this.binary_annotations = new ArrayList<BinaryAnnotation>(_list3.size);
              for (int _i4 = 0; _i4 < _list3.size; ++_i4)
              {
                BinaryAnnotation _elem5;
                _elem5 = new BinaryAnnotation();
                _elem5.read(iprot);
                this.binary_annotations.add(_elem5);
              }
              iprot.readListEnd();
            }
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 9: // DEBUG
          if (field.type == TType.BOOL) {
            this.debug = iprot.readBool();
            setDebugIsSet(true);
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
    oprot.writeFieldBegin(TRACE_ID_FIELD_DESC);
    oprot.writeI64(this.trace_id);
    oprot.writeFieldEnd();
    if (this.name != null) {
      oprot.writeFieldBegin(NAME_FIELD_DESC);
      oprot.writeString(this.name);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldBegin(ID_FIELD_DESC);
    oprot.writeI64(this.id);
    oprot.writeFieldEnd();
    if (isSetParent_id()) {
      oprot.writeFieldBegin(PARENT_ID_FIELD_DESC);
      oprot.writeI64(this.parent_id);
      oprot.writeFieldEnd();
    }
    if (this.annotations != null) {
      oprot.writeFieldBegin(ANNOTATIONS_FIELD_DESC);
      {
        oprot.writeListBegin(new TList(TType.STRUCT, this.annotations.size()));
        for (Annotation _iter6 : this.annotations)
        {
          _iter6.write(oprot);
        }
        oprot.writeListEnd();
      }
      oprot.writeFieldEnd();
    }
    if (this.binary_annotations != null) {
      oprot.writeFieldBegin(BINARY_ANNOTATIONS_FIELD_DESC);
      {
        oprot.writeListBegin(new TList(TType.STRUCT, this.binary_annotations.size()));
        for (BinaryAnnotation _iter7 : this.binary_annotations)
        {
          _iter7.write(oprot);
        }
        oprot.writeListEnd();
      }
      oprot.writeFieldEnd();
    }
    if (isSetDebug()) {
      oprot.writeFieldBegin(DEBUG_FIELD_DESC);
      oprot.writeBool(this.debug);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Span(");
    boolean first = true;

    sb.append("trace_id:");
    sb.append(this.trace_id);
    first = false;
    if (!first) sb.append(", ");
    sb.append("name:");
    if (this.name == null) {
      sb.append("null");
    } else {
      sb.append(this.name);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("id:");
    sb.append(this.id);
    first = false;
    if (isSetParent_id()) {
      if (!first) sb.append(", ");
      sb.append("parent_id:");
      sb.append(this.parent_id);
      first = false;
    }
    if (!first) sb.append(", ");
    sb.append("annotations:");
    if (this.annotations == null) {
      sb.append("null");
    } else {
      sb.append(this.annotations);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("binary_annotations:");
    if (this.binary_annotations == null) {
      sb.append("null");
    } else {
      sb.append(this.binary_annotations);
    }
    first = false;
    if (isSetDebug()) {
      if (!first) sb.append(", ");
      sb.append("debug:");
      sb.append(this.debug);
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
  }

}

