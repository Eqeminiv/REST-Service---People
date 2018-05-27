package personRest.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import personRest.uuid.uuid;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.List;

@RestController
public class PersonController {

    final String ticket = "e550d817-534c-4140-bb76-4395f83cac08";
    uuid temp;


 //   @Autowired
    private PersonService personService = new PersonService();


    @RequestMapping("/login")
    public uuid getUUID(@RequestParam String username, @RequestBody String password)
    {
        Person p = personService.checkLogin(username, password);
        if(p != null){
            p.updateUUID();
            System.out.println(p.getUUID().getHash());
            return p.getUUID();
        }
        return null;
    }

    @RequestMapping("/{userId}/getperson")
    public Person getPerson(@PathVariable("userId") int user, @RequestBody uuid uuid)
    {
        //System.out.println(System.currentTimeMillis()+" - "+uuid.getDate().getTime()+" = "+(System.currentTimeMillis() - uuid.getDate().getTime()));
        if(System.currentTimeMillis() - uuid.getDate().getTime() < 60000 &&
                personService.checkUUID(uuid))
        {
            //uuid.setDate(new Timestamp(System.currentTimeMillis()));
            return personService.getPerson(user);
        }
        else
            return null;
    }

    @RequestMapping("/persons")
    public List<Person> getAllPersons()
    {
        return personService.getAllPersons();
    }

    @PostMapping("/addperson")
    public void addPerson(@RequestBody @Valid Person person)
    {
        personService.addPerson(person);
        return;
    }

    @RequestMapping("/{userId}/deleteperson")
    public @ResponseBody void deletePerson(@PathVariable("userId") int user)
    {
        personService.deletePerson(user);
        return;
    }



}

