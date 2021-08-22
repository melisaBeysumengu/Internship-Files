package Week3.Day1.Example1;

import java.util.List;

public class JavaBookLibrary implements BookLibrary {
    List<BookLibrary> bookLibrary;


    @Override
    public List<Book> search(String title) {
        List<Book> books = bookLibrary.get(0).search("somebook");
        for (int i = 0; i < books.size(); i++) {
            System.out.println("Book is: "+ books.get(i));
        }
        return books;
    }
}
