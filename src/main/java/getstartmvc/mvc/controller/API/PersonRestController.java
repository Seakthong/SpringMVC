package getstartmvc.mvc.controller.API;

import getstartmvc.mvc.services.articleService.PersonServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController() //== @ResponseBody
public class PersonRestController {
    @Autowired
    private PersonServ personServ;

    @GetMapping("/showAll")
    public Map<String, Object> showAll(){
        Map data = new HashMap();
        data.put("data",personServ.showList());
        data.put("status",true);
        data.put("personCount",personServ.showList().size());
        return data;
    }
}
