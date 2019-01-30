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

        List<EmailBean> emails = saveEmails(person.getEmails(), personRecord.getPersonid());
        List<AddressBean> addresses = saveAddresses(person.getAddresses(), personRecord.getPersonid());
        List<PhoneBean> phones = savePhones(person.getPhones(), personRecord.getPersonid());

        PersonBean savedPersonBean = personRecord.into(PersonBean.class);
        savedPersonBean.setEmails(emails);
        savedPersonBean.setAddresses(addresses);
        savedPersonBean.setPhones(phones);
        return savedPersonBean;
    }

    private List<AddressBean> saveAddresses(List<AddressBean> addresses, Integer personid) {
        if(null == addresses || addresses.isEmpty()){
            return Collections.EMPTY_LIST;
        }

        List<AddressBean> savedAddresss = new ArrayList<>();

        for(AddressBean address : addresses){
            AddressRecord addressRecord = dsl.newRecord(Address.ADDRESS, address);
            addressRecord.setPersonid(personid);
            addressRecord.store();
            savedAddresss.add(addressRecord.into(AddressBean.class));
        }
        return savedAddresss;
    }

    private List<EmailBean> saveEmails(List<EmailBean> emails, Integer personid) {
        if(null == emails || emails.isEmpty()){
            return Collections.EMPTY_LIST;
        }

        List<EmailBean> savedEmails = new ArrayList<>();

        for(EmailBean email : emails){
            EmailRecord emailRecord = dsl.newRecord(Email.EMAIL, email);
            emailRecord.setPersonid(personid);
            emailRecord.store();
            savedEmails.add(emailRecord.into(EmailBean.class));
        }
        return savedEmails;
    }

    private List<PhoneBean> savePhones(List<PhoneBean> phones, Integer personid) {
        if(null == phones || phones.isEmpty()){
            return Collections.EMPTY_LIST;
        }

        List<PhoneBean> savedPhones = new ArrayList<>();

        for(PhoneBean phone : phones){
            PhoneRecord phoneRecord = dsl.newRecord(Phone.PHONE, phone);
            phoneRecord.setPersonid(personid);
            phoneRecord.store();
            savedPhones.add(phoneRecord.into(PhoneBean.class));
        }
        return savedPhones;
    }

    @Override
    public PersonBean updatePerson(PersonBean personBean) {
        validatePersonBean(personBean, true);
        PersonRecord personRecord = this.getPersonRecord(personBean.getPersonID());
        personRecord.from(personBean);
        personRecord.update();
        return personRecord.into(PersonBean.class);
    }

    @Override
    public PersonBean getPerson(Integer personID) {
        PersonRecord personRecord = this.getPersonRecord(personID);
        PersonBean person =  personRecord.into(PersonBean.class);

        person.setEmails(getEmails(person.getPersonID()));

        return person;
    }

    private List<EmailBean> getEmails(Integer personID) {
        return dsl.select().from(Email.EMAIL).where(Email.EMAIL.PERSONID.eq(personID)).fetchInto(EmailBean.class);
    }

    @Override
    public void deletePerson(Integer personID) {
        PersonRecord personRecord = this.getPersonRecord(personID);
        personRecord.setActive((byte) 0);
        personRecord.update();
    }

    private PersonRecord getPersonRecord(Integer personID) {
        if(null == personID){
            throw new InvalidParameterException("personID is expected but null");
        }
        PersonRecord personRecord = dsl.fetchOne(Person.PERSON, Person.PERSON.PERSONID.eq(personID).and(Person.PERSON.ACTIVE.eq((byte)1)));
        if(null == personRecord){
            throw new RecordNotFoundException();
        }
        return personRecord;
    }

    private void validatePersonBean(PersonBean personBean, boolean isPersonIDRequired) {
        if (null == personBean) {
            throw new InvalidParameterException("personBean is null");
        }
        if(isPersonIDRequired && null == personBean.getPersonID()){
            throw new InvalidParameterException("personID is expected but null");
        }
        Set<ConstraintViolation<PersonBean>> violations = validator.validate(personBean);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }

}
