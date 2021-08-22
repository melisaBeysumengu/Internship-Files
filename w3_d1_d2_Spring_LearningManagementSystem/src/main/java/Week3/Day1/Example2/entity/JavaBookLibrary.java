package Week3.Day1.Example2.entity;

import java.util.ArrayList;
import java.util.List;

public class JavaBookLibrary implements BookLibrary{
    @Override
    public List<Book> search(String title) {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("asd"));
        return bookList;
    }
}
