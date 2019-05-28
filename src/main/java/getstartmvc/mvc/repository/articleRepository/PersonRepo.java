package getstartmvc.mvc.repository.articleRepository;

import getstartmvc.mvc.repository.model.Person;

import java.util.List;

public interface PersonRepo {
    void add(Person person);
    List<Person> showList();
}
