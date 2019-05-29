package getstartmvc.mvc.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@PropertySource("imageType.properties")
public class FileUploadConfiguration implements WebMvcConfigurer {
    @Value("${server.path}")
    String serverPath;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry){
        resourceHandlerRegistry.addResourceHandler("/image/**").addResourceLocations("Path.");
        resourceHandlerRegistry.addResourceHandler("/image/**").addResourceLocations("file:///home/seakthongsq/Pictures/Solar%20System/");
    }
}
