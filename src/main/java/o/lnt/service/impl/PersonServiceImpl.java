package o.lnt.service.impl;

import o.lnt.bean.PersonBean;
import o.lnt.domain.tables.Person;
import o.lnt.domain.tables.records.PersonRecord;
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
    public PersonBean savePerson(PersonBean personBean) {
        validatePersonBean(personBean, false);
        PersonRecord personRecord = dsl.newRecord(Person.PERSON, personBean);
        personRecord.store();
        return personRecord.into(PersonBean.class);
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
        return personRecord.into(PersonBean.class);
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
        PersonRecord personRecord = dsl.fetchOne(Person.PERSON, Person.PERSON.PERSONID.eq(personID));
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
