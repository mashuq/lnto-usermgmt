/*
 * This file is generated by jOOQ.
 */
package o.lnt.domain.tables.records;


import java.time.LocalDateTime;

import javax.annotation.Generated;

import o.lnt.domain.tables.Person;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
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
public class PersonRecord extends UpdatableRecordImpl<PersonRecord> implements Record9<Integer, String, String, String, String, LocalDateTime, String, String, Byte> {

    private static final long serialVersionUID = -1163935606;

    /**
     * Setter for <code>person.PersonID</code>.
     */
    public void setPersonid(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>person.PersonID</code>.
     */
    public Integer getPersonid() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>person.FirstName</code>.
     */
    public void setFirstname(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>person.FirstName</code>.
     */
    public String getFirstname() {
        return (String) get(1);
    }

    /**
     * Setter for <code>person.LastName</code>.
     */
    public void setLastname(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>person.LastName</code>.
     */
    public String getLastname() {
        return (String) get(2);
    }

    /**
     * Setter for <code>person.MiddleName</code>.
     */
    public void setMiddlename(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>person.MiddleName</code>.
     */
    public String getMiddlename() {
        return (String) get(3);
    }

    /**
     * Setter for <code>person.Gender</code>.
     */
    public void setGender(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>person.Gender</code>.
     */
    public String getGender() {
        return (String) get(4);
    }

    /**
     * Setter for <code>person.Birthday</code>.
     */
    public void setBirthday(LocalDateTime value) {
        set(5, value);
    }

    /**
     * Getter for <code>person.Birthday</code>.
     */
    public LocalDateTime getBirthday() {
        return (LocalDateTime) get(5);
    }

    /**
     * Setter for <code>person.Title</code>.
     */
    public void setTitle(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>person.Title</code>.
     */
    public String getTitle() {
        return (String) get(6);
    }

    /**
     * Setter for <code>person.Suffix</code>.
     */
    public void setSuffix(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>person.Suffix</code>.
     */
    public String getSuffix() {
        return (String) get(7);
    }

    /**
     * Setter for <code>person.Active</code>.
     */
    public void setActive(Byte value) {
        set(8, value);
    }

    /**
     * Getter for <code>person.Active</code>.
     */
    public Byte getActive() {
        return (Byte) get(8);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record9 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<Integer, String, String, String, String, LocalDateTime, String, String, Byte> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<Integer, String, String, String, String, LocalDateTime, String, String, Byte> valuesRow() {
        return (Row9) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Person.PERSON.PERSONID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Person.PERSON.FIRSTNAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Person.PERSON.LASTNAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Person.PERSON.MIDDLENAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Person.PERSON.GENDER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<LocalDateTime> field6() {
        return Person.PERSON.BIRTHDAY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return Person.PERSON.TITLE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return Person.PERSON.SUFFIX;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Byte> field9() {
        return Person.PERSON.ACTIVE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getPersonid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getFirstname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getLastname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getMiddlename();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getGender();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime component6() {
        return getBirthday();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getTitle();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component8() {
        return getSuffix();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte component9() {
        return getActive();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getPersonid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getFirstname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getLastname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getMiddlename();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getGender();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime value6() {
        return getBirthday();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getTitle();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getSuffix();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte value9() {
        return getActive();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PersonRecord value1(Integer value) {
        setPersonid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PersonRecord value2(String value) {
        setFirstname(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PersonRecord value3(String value) {
        setLastname(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PersonRecord value4(String value) {
        setMiddlename(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PersonRecord value5(String value) {
        setGender(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PersonRecord value6(LocalDateTime value) {
        setBirthday(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PersonRecord value7(String value) {
        setTitle(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PersonRecord value8(String value) {
        setSuffix(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PersonRecord value9(Byte value) {
        setActive(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PersonRecord values(Integer value1, String value2, String value3, String value4, String value5, LocalDateTime value6, String value7, String value8, Byte value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PersonRecord
     */
    public PersonRecord() {
        super(Person.PERSON);
    }

    /**
     * Create a detached, initialised PersonRecord
     */
    public PersonRecord(Integer personid, String firstname, String lastname, String middlename, String gender, LocalDateTime birthday, String title, String suffix, Byte active) {
        super(Person.PERSON);

        set(0, personid);
        set(1, firstname);
        set(2, lastname);
        set(3, middlename);
        set(4, gender);
        set(5, birthday);
        set(6, title);
        set(7, suffix);
        set(8, active);
    }
}
