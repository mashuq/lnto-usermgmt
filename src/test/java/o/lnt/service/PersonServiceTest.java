package o.lnt.service;

import o.lnt.Application;
import o.lnt.bean.PersonBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class)
@ActiveProfiles("test")
public class PersonServiceTest {

    @Autowired PersonService personService;

    @Test
    public void testInsert(){
        PersonBean personBean = new PersonBean();
        personBean.setFirstName("Guybrush");
        personBean.setLastName("Threepwood");
        personBean.setActive(true);
        personService.savePerson(personBean);
    }
}
