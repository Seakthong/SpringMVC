package getstartmvc.mvc;

import getstartmvc.mvc.repository.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public Person getBean(){
        return new Person();
    }

}
