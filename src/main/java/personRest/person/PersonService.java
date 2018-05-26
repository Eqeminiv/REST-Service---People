package personRest.person;

import org.springframework.stereotype.Service;
import personRest.uuid.uuid;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PersonService {

    List<Person> personList = new ArrayList<Person>();


    public Person getPerson(int user)
    {
        for (Person p : personList) {
            if (p.getId() == user) {
                return p;
            }
        }
        return null;
    }

    public List<Person> getAllPersons()
    {
        return personList;
    }

    public void addPerson(Person person)
    {
        personList.add(person);
    }

    public void deletePerson(int user)
    {
        for(Person p : personList)
        {
            if (p.getId() == user)
            {
                personList.remove(p);
                return;
            }
        }
        return;
    }
}

