package o.lnt.service;

import o.lnt.Application;
import o.lnt.bean.PersonBean;
import o.lnt.enumeration.Gender;
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
@SpringBootTest(classes=Application.class)
@ActiveProfiles("test")
@ImportAutoConfiguration(JooqAutoConfiguration.class)
public class PersonServiceTest {

    @Autowired PersonService personService;

    @Test
    public void testInsert(){
        PersonBean personBean = new PersonBean();
        personBean.setFirstName("Guybrush");
        personBean.setLastName("Threepwood");
        personBean.setGender(Gender.MALE);
        personBean.setBirthday(LocalDateTime.of(1985,3,2,0,0,0));
        personBean.setActive(true);
        personService.savePerson(personBean);
    }
}
