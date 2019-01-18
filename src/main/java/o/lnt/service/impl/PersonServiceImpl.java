package o.lnt.service.impl;

import o.lnt.bean.PersonBean;
import o.lnt.domain.tables.Person;
import o.lnt.domain.tables.records.PersonRecord;
import o.lnt.service.PersonService;
import org.jooq.DSLContext;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    @Autowired
    private DSLContext dsl;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void savePerson(PersonBean personBean) {
        System.out.println(personBean);
        PersonRecord personRecord = modelMapper.map(personBean, PersonRecord.class);
        System.out.println(personRecord);
        dsl.executeInsert(personRecord);
    }

    @Override
    public void updatePerson(PersonBean personBean) {

    }

    @Override
    public Person getPerson(Integer personID) {
        return null;
    }

    @Override
    public void deletePerson(Integer personID) {

    }
}
