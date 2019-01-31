package o.lnt.service.impl;

import o.lnt.bean.AddressBean;
import o.lnt.bean.EmailBean;
import o.lnt.bean.PersonBean;
import o.lnt.bean.PhoneBean;
import o.lnt.domain.tables.Address;
import o.lnt.domain.tables.Email;
import o.lnt.domain.tables.Person;
import o.lnt.domain.tables.Phone;
import o.lnt.domain.tables.records.AddressRecord;
import o.lnt.domain.tables.records.EmailRecord;
import o.lnt.domain.tables.records.PersonRecord;
import o.lnt.domain.tables.records.PhoneRecord;
import o.lnt.exception.RecordNotFoundException;
import o.lnt.service.PersonService;
import org.jooq.DSLContext;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    @Autowired
    private DSLContext dsl;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private Validator validator;

    @Override
    public PersonBean savePerson(PersonBean person) {
        validatePersonBean(person, false);
        PersonRecord personRecord = dsl.newRecord(Person.PERSON, person);
        personRecord.store();

        if (null != person.getEmails()) person.getEmails().stream().forEach(email -> email.setEmailID(null));
        if (null != person.getAddresses())
            person.getAddresses().stream().forEach(address -> address.setAddressID(null));
        if (null != person.getPhones()) person.getPhones().stream().forEach(phone -> phone.setPhoneID(null));

        List<EmailBean> emails = saveEmails(person.getEmails(), personRecord.getPersonid());
        List<AddressBean> addresses = saveAddresses(person.getAddresses(), personRecord.getPersonid());
        List<PhoneBean> phones = savePhones(person.getPhones(), personRecord.getPersonid());

        PersonBean savedPersonBean = personRecord.into(PersonBean.class);
        savedPersonBean.setEmails(emails);
        savedPersonBean.setAddresses(addresses);
        savedPersonBean.setPhones(phones);
        return savedPersonBean;
    }

    @Override
    public PersonBean updatePerson(PersonBean person) {
        validatePersonBean(person, true);
        PersonRecord personRecord = this.getPersonRecord(person.getPersonID());
        personRecord.from(person);
        personRecord.update();
        PersonBean updatedPersonBean = personRecord.into(PersonBean.class);

        List<EmailBean> emails = saveEmails(person.getEmails(), personRecord.getPersonid());
        List<AddressBean> addresses = saveAddresses(person.getAddresses(), personRecord.getPersonid());
        List<PhoneBean> phones = savePhones(person.getPhones(), personRecord.getPersonid());

        updatedPersonBean.setEmails(emails);
        updatedPersonBean.setAddresses(addresses);
        updatedPersonBean.setPhones(phones);
        return updatedPersonBean;
    }

    @Override
    public PersonBean getPerson(Integer personID) {
        PersonRecord personRecord = this.getPersonRecord(personID);
        PersonBean person = personRecord.into(PersonBean.class);

        person.setEmails(getEmails(personID));
        person.setAddresses(getAddresses(personID));
        person.setPhones(getPhones(personID));

        return person;
    }

    @Override
    public void deletePerson(Integer personID) {
        PersonRecord personRecord = this.getPersonRecord(personID);
        personRecord.setActive((byte) 0);
        personRecord.update();
    }

    private List<AddressBean> saveAddresses(List<AddressBean> addresses, Integer personid) {
        if (null == addresses || addresses.isEmpty()) {
            return Collections.EMPTY_LIST;
        }

        List<Integer> existingIDs = addresses.stream().filter(address ->
                address.getAddressID() != null && address.getAddressID() != 0
        ).map(AddressBean::getAddressID).collect(Collectors.toList());

        dsl.delete(Address.ADDRESS).where(Address.ADDRESS.ADDRESSID.notIn(existingIDs).and(Address.ADDRESS.PERSONID.eq(personid))).execute();

        List<AddressBean> savedAddresss = new ArrayList<>();

        for (AddressBean address : addresses) {
            AddressRecord addressRecord = dsl.newRecord(Address.ADDRESS, address);
            addressRecord.setPersonid(personid);
            if (null == addressRecord.getAddressid() || addressRecord.getAddressid() == 0) {
                addressRecord.store();
            } else {
                addressRecord.update();
            }
            savedAddresss.add(addressRecord.into(AddressBean.class));
        }
        return savedAddresss;
    }

    private List<EmailBean> saveEmails(List<EmailBean> emails, Integer personid) {
        if (null == emails || emails.isEmpty()) {
            return Collections.EMPTY_LIST;
        }

        List<Integer> existingIDs = emails.stream().filter(emaail ->
                emaail.getEmailID() != null && emaail.getEmailID() != 0
        ).map(EmailBean::getEmailID).collect(Collectors.toList());

        dsl.delete(Email.EMAIL).where(Email.EMAIL.EMAILID.notIn(existingIDs).and(Email.EMAIL.PERSONID.eq(personid))).execute();

        List<EmailBean> savedEmails = new ArrayList<>();

        for (EmailBean email : emails) {
            EmailRecord emailRecord = dsl.newRecord(Email.EMAIL, email);
            emailRecord.setPersonid(personid);
            if (null == emailRecord.getEmailid() || emailRecord.getEmailid() == 0) {
                emailRecord.store();
            } else {
                emailRecord.update();
            }
            savedEmails.add(emailRecord.into(EmailBean.class));
        }
        return savedEmails;
    }

    private List<PhoneBean> savePhones(List<PhoneBean> phones, Integer personid) {
        if (null == phones || phones.isEmpty()) {
            return Collections.EMPTY_LIST;
        }

        List<Integer> existingIDs = phones.stream().filter(phone ->
                phone.getPhoneID() != null && phone.getPhoneID() != 0
        ).map(PhoneBean::getPhoneID).collect(Collectors.toList());

        dsl.delete(Phone.PHONE).where(Phone.PHONE.PHONEID.notIn(existingIDs).and(Phone.PHONE.PERSONID.eq(personid))).execute();

        List<PhoneBean> savedPhones = new ArrayList<>();

        for (PhoneBean phone : phones) {
            PhoneRecord phoneRecord = dsl.newRecord(Phone.PHONE, phone);
            phoneRecord.setPersonid(personid);
            if (null == phoneRecord.getPhoneid() || phoneRecord.getPhoneid() == 0) {
                phoneRecord.store();
            } else {
                phoneRecord.update();
            }
            savedPhones.add(phoneRecord.into(PhoneBean.class));
        }
        return savedPhones;
    }


    private List<EmailBean> getEmails(Integer personID) {
        if (null == personID || personID == 0) return Collections.EMPTY_LIST;
        return dsl.select().from(Email.EMAIL).where(Email.EMAIL.PERSONID.eq(personID)).fetchInto(EmailBean.class);
    }

    private List<AddressBean> getAddresses(Integer personID) {
        if (null == personID || personID == 0) return Collections.EMPTY_LIST;
        return dsl.select().from(Address.ADDRESS).where(Address.ADDRESS.PERSONID.eq(personID)).fetchInto(AddressBean.class);
    }

    private List<PhoneBean> getPhones(Integer personID) {
        if (null == personID || personID == 0) return Collections.EMPTY_LIST;
        return dsl.select().from(Phone.PHONE).where(Phone.PHONE.PERSONID.eq(personID)).fetchInto(PhoneBean.class);
    }

    private PersonRecord getPersonRecord(Integer personID) {
        if (null == personID || personID == 0) {
            throw new InvalidParameterException("personID is expected but null or 0");
        }
        PersonRecord personRecord = dsl.fetchOne(Person.PERSON, Person.PERSON.PERSONID.eq(personID).and(Person.PERSON.ACTIVE.eq((byte) 1)));
        if (null == personRecord) {
            throw new RecordNotFoundException();
        }
        return personRecord;
    }

    private void validatePersonBean(PersonBean personBean, boolean isPersonIDRequired) {
        if (null == personBean) {
            throw new InvalidParameterException("personBean is null");
        }
        if (isPersonIDRequired && (null == personBean.getPersonID() || personBean.getPersonID() == 0)) {
            throw new InvalidParameterException("personID is expected but null");
        }
        Set<ConstraintViolation<PersonBean>> violations = validator.validate(personBean);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }

}
