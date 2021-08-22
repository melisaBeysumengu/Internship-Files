package Week3.Day1.Example2.config;

import Week3.Day1.Example2.entity.BookLibrary;
import Week3.Day1.Example2.entity.JavaBookLibrary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public BookLibrary bookLibrary(){
        return new JavaBookLibrary();
    }
}
