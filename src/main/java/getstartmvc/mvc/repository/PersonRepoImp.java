package getstartmvc.mvc.repository;

import getstartmvc.mvc.repository.articleRepository.PersonRepo;
import getstartmvc.mvc.repository.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepoImp implements PersonRepo {

    List<Person> personList = new ArrayList<>();
    @Override
    public void add(Person person) {
        personList.add(person);
    }

    @Override
    public List<Person> showList() {
        return personList;
    }
}
