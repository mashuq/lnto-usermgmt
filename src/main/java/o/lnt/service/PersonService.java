package o.lnt.service;

import o.lnt.bean.PersonBean;

public interface PersonService {

    public PersonBean savePerson(PersonBean personBean);

    public PersonBean updatePerson(PersonBean personBean);

    public PersonBean getPerson(String uuid);

    public void deletePerson(String uuid);
}
