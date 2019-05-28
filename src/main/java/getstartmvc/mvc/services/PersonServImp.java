package getstartmvc.mvc.services;

import getstartmvc.mvc.repository.PersonRepoImp;
import getstartmvc.mvc.repository.model.Person;
import getstartmvc.mvc.services.articleService.PersonServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonServImp implements PersonServ {

    @Autowired
    PersonRepoImp personRepoImp;

    @Override
    public void add(Person person) {
        personRepoImp.add(person);
    }

    @Override
    public List<Person> showList() {
        return personRepoImp.showList();
    }
}
