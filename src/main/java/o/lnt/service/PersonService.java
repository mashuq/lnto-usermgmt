package o.lnt.service;

import o.lnt.bean.PersonBean;
import o.lnt.domain.tables.Person;

public interface PersonService {

    public PersonBean savePerson(PersonBean personBean);

    public PersonBean updatePerson(PersonBean personBean);

    public Person getPerson(Integer personID);

    public void deletePerson(Integer personID);
}
