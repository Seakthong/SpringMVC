package getstartmvc.mvc.services.articleService;

import getstartmvc.mvc.repository.model.Person;

import java.util.List;

public interface PersonServ {
    void add(Person person);
    List<Person> showList();
}
