package o.lnt.service.impl;

import o.lnt.bean.PersonBean;
import o.lnt.domain.tables.Person;
import o.lnt.domain.tables.records.PersonRecord;
import o.lnt.service.PersonService;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springfox.documentation.swagger2.mappers.ModelMapper;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    @Autowired
    private DSLContext dsl;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PersonBean savePerson(PersonBean personBean) {
        PersonRecord personRecord = dsl.newRecord(Person.PERSON, personBean);
        personRecord.store();
        return personRecord.into(PersonBean.class);
    }

    @Override
    public PersonBean updatePerson(PersonBean personBean) {
        return null;
    }

    @Override
    public Person getPerson(Integer personID) {
        return null;
    }

    @Override
    public void deletePerson(Integer personID) {

    }
}
