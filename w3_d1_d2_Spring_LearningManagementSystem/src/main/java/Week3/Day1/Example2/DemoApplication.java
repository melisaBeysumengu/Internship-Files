package Week3.Day1.Example2;

import Week3.Day1.Example2.config.AppConfig;
import Week3.Day1.Example2.entity.Book;
import Week3.Day1.Example2.entity.BookLibrary;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

//@Configuration
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(DemoApplication.class, args);

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		BookLibrary library = context.getBean(BookLibrary.class);

		List<Book> bookList = library.search("asd");

		for (Book b: bookList
			 ) {
			System.out.println(b.getTitle());
		}

	}

}
