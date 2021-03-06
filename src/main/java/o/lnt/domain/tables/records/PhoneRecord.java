/*
 * This file is generated by jOOQ.
 */
package o.lnt.domain.tables.records;


import javax.annotation.Generated;

import o.lnt.domain.tables.Phone;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PhoneRecord extends UpdatableRecordImpl<PhoneRecord> implements Record5<Integer, String, String, Integer, Byte> {

    private static final long serialVersionUID = -1964028665;

    /**
     * Setter for <code>phone.PhoneID</code>.
     */
    public void setPhoneid(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>phone.PhoneID</code>.
     */
    public Integer getPhoneid() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>phone.AddressType</code>.
     */
    public void setAddresstype(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>phone.AddressType</code>.
     */
    public String getAddresstype() {
        return (String) get(1);
    }

    /**
     * Setter for <code>phone.PhoneNumber</code>.
     */
    public void setPhonenumber(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>phone.PhoneNumber</code>.
     */
    public String getPhonenumber() {
        return (String) get(2);
    }

    /**
     * Setter for <code>phone.PersonID</code>.
     */
    public void setPersonid(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>phone.PersonID</code>.
     */
    public Integer getPersonid() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>phone.Default</code>.
     */
    public void setDefault(Byte value) {
        set(4, value);
    }

    /**
     * Getter for <code>phone.Default</code>.
     */
    public Byte getDefault() {
        return (Byte) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record2<Integer, Integer> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<Integer, String, String, Integer, Byte> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<Integer, String, String, Integer, Byte> valuesRow() {
        return (Row5) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Phone.PHONE.PHONEID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Phone.PHONE.ADDRESSTYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Phone.PHONE.PHONENUMBER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return Phone.PHONE.PERSONID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Byte> field5() {
        return Phone.PHONE.DEFAULT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getPhoneid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getAddresstype();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getPhonenumber();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component4() {
        return getPersonid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte component5() {
        return getDefault();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getPhoneid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getAddresstype();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getPhonenumber();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getPersonid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte value5() {
        return getDefault();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PhoneRecord value1(Integer value) {
        setPhoneid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PhoneRecord value2(String value) {
        setAddresstype(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PhoneRecord value3(String value) {
        setPhonenumber(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PhoneRecord value4(Integer value) {
        setPersonid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PhoneRecord value5(Byte value) {
        setDefault(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PhoneRecord values(Integer value1, String value2, String value3, Integer value4, Byte value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PhoneRecord
     */
    public PhoneRecord() {
        super(Phone.PHONE);
    }

    /**
     * Create a detached, initialised PhoneRecord
     */
    public PhoneRecord(Integer phoneid, String addresstype, String phonenumber, Integer personid, Byte default_) {
        super(Phone.PHONE);

        set(0, phoneid);
        set(1, addresstype);
        set(2, phonenumber);
        set(3, personid);
        set(4, default_);
    }
}
