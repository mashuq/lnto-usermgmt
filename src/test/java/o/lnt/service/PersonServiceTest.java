package o.lnt.service;

import o.lnt.Application;
import o.lnt.bean.PersonBean;
import o.lnt.enumeration.Gender;
import o.lnt.exception.RecordNotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.jooq.JooqAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles("test")
@ImportAutoConfiguration(JooqAutoConfiguration.class)
public class PersonServiceTest {

    @Autowired
    PersonService personService;

    @Test
    public void testInsertAndGet() {
        PersonBean personBean = new PersonBean();
        personBean.setFirstName("Guybrush");
        personBean.setLastName("Threepwood");
        personBean.setGender(Gender.MALE);
        personBean.setBirthday(LocalDateTime.of(1991, 5, 22, 0, 0, 0));
        personBean.setActive(true);

        //Save
        PersonBean savedPersonBean = personService.savePerson(personBean);

        //Retrieve
        PersonBean retrievedPersonBean = personService.getPerson(savedPersonBean.getPersonID());

        Assert.assertTrue(savedPersonBean.equals(retrievedPersonBean));
    }

    @Test
    public void testUpdateAndGet() {
        PersonBean personBean = new PersonBean();
        personBean.setFirstName("Guybrush");
        personBean.setLastName("Threepwood");
        personBean.setGender(Gender.MALE);
        personBean.setBirthday(LocalDateTime.of(1988, 10, 7, 0, 0, 0));
        personBean.setActive(true);

        //Save
        PersonBean savedPersonBean = personService.savePerson(personBean);

        //Retrieve after save
        savedPersonBean = personService.getPerson(savedPersonBean.getPersonID());
        savedPersonBean.setFirstName("Rincewind");
        savedPersonBean.setLastName("Twoflower");
        personService.updatePerson(savedPersonBean);

        //Retrieve After update
        PersonBean retrievedPersonBean = personService.getPerson(savedPersonBean.getPersonID());
        Assert.assertTrue(savedPersonBean.equals(retrievedPersonBean));
    }

    @Test
    public void testDelete() {
        PersonBean personBean = new PersonBean();
        personBean.setFirstName("Lechuck");
        personBean.setLastName("LeGrande");
        personBean.setGender(Gender.MALE);
        personBean.setBirthday(LocalDateTime.of(1973, 2, 23, 0, 0, 0));
        personBean.setActive(true);

        //Save
        PersonBean savedPersonBean = personService.savePerson(personBean);

        //Delete
        personService.deletePerson(savedPersonBean.getPersonID());

        //Retrieve
        PersonBean retrievedPersonBean = personService.getPerson(savedPersonBean.getPersonID());

        Assert.assertFalse(retrievedPersonBean.isActive());
    }

    @Test (expected = RecordNotFoundException.class)
    public void testGet_withWrongID() {
        personService.getPerson(999999);
    }
}
