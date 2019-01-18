package o.lnt.service;

import o.lnt.bean.PersonBean;
import o.lnt.domain.tables.Person;

public interface PersonService {

    public void savePerson(PersonBean personBean);

    public void updatePerson(PersonBean personBean);

    public Person getPerson(Integer personID);

    public void deletePerson(Integer personID);
}
