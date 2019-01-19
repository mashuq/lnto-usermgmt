package o.lnt.rest;

import o.lnt.bean.PersonBean;
import o.lnt.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/person")
    PersonBean newPerson(@RequestBody @Valid PersonBean personBean) {
        return personService.savePerson(personBean);
     }

    @GetMapping("/persons")
    List<PersonBean> all() {
        return Collections.EMPTY_LIST;
    }
}
