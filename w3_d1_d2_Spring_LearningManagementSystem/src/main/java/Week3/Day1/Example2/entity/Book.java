package Week3.Day1.Example2.entity;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Book implements BookLibrary{
    String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public List<Book> search(String title) {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("asd"));
        return bookList;
    }
}
