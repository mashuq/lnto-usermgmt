package o.lnt.rest;

import o.lnt.bean.PersonBean;
import o.lnt.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/person")
    PersonBean createPerson(@RequestBody @Valid PersonBean personBean) {
        return personService.savePerson(personBean);
    }

    @PutMapping("/person")
    PersonBean updatPerson(@RequestBody @Valid PersonBean personBean) {
        return personService.updatePerson(personBean);
    }

    @GetMapping("/person/{uuid}")
    PersonBean getPerson(@RequestParam(name = "uuid") String uuid) {
        return personService.getPerson(uuid);
    }

    @DeleteMapping("/person/{uuid}")
    @ResponseStatus(value = HttpStatus.OK)
    void deletePerson(@RequestParam(name = "uuid") String uuid){
        personService.deletePerson(uuid);
    }
}
