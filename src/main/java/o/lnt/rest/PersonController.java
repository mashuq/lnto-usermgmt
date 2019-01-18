package o.lnt.rest;

import o.lnt.bean.PersonBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class PersonController {

    @PostMapping("/person")
    PersonBean newPerson(@RequestBody PersonBean personBean) {
        System.out.println(personBean);
        return personBean;
    }

    @GetMapping("/persons")
    List<PersonBean> all() {
        return Collections.EMPTY_LIST;
    }
}
