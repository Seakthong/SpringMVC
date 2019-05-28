package getstartmvc.mvc.controller;

import getstartmvc.mvc.repository.model.Person;
import getstartmvc.mvc.services.PersonServImp;
import getstartmvc.mvc.services.articleService.PersonServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ArticleController {

    @Autowired
    PersonServ personServ;

    @GetMapping("/")
    @ResponseBody
    public String slash(){
        System.out.println(personServ.showList());
        return "show";
    }

    @GetMapping("/add")
    @ResponseBody
    public String add(){
        Person person = new Person(10,"SeakthongSQ");
        personServ.add(person);
        return "Add";
    }

}
