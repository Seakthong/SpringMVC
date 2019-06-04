package getstartmvc.mvc.controller;

import getstartmvc.mvc.repository.model.Person;
import getstartmvc.mvc.services.PersonServImp;
import getstartmvc.mvc.services.articleService.PersonServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

@Controller
public class PersonController {

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

    @GetMapping("/person/{id}/{name}")
    @ResponseBody
    public String search(@PathVariable int id, @PathVariable String name){
        //person/id/name
        return id +" & "+name;
    }

    @GetMapping("/person")
    @ResponseBody
    public String search2(@RequestParam int id, @RequestParam String name){
        //person?id=...&name=...
        return id + " : " +name;
    }

    @GetMapping("/modelMap")
    public String modelMap(ModelMap modelMap){
        modelMap.addAttribute("id",10).addAttribute("name","SQ");
        return "index";
    }

    @GetMapping("/model")
    public String model(Model model){
        model.addAttribute("id",101);
        return "index";
    }

//    @GetMapping("/form")
//    public String form(@RequestParam ModelMap modelMap){
////        @Bean
////        Person per;
////        modelMap.addAttribute("id",);
//        return "form";
//    }

//    @PostMapping("/submit")
//    public String submit(){
//        return null;
//    }

    @PostMapping("/person")
    public String push(@ModelAttribute Person person){
        personServ.add(person);
        return "form";
    }

    @PutMapping("/uploadfile")
    public String fileForm(){
        return "fileform";
    }

    @PostMapping("/upload")
    public String postme(@RequestParam MultipartFile file){
        String fileName = UUID.randomUUID().toString();
        if(!file.isEmpty())
            try{
                Files.copy(file.getInputStream(), Paths.get("/directory","name + extension"));
            }catch(IOException ex){}
        return "redirect:/fileform";
    }

    @PostMapping("/uploads")
    public String postme(@RequestParam List<MultipartFile> files){
        String fileName = UUID.randomUUID().toString();
        for(MultipartFile file : files){
            if(!file.isEmpty())
                try{
                    Files.copy(file.getInputStream(), Paths.get("/directory","name + extension"));
                }catch(IOException ex){}
        }
        return "redirect:/fileform";
    }


}
