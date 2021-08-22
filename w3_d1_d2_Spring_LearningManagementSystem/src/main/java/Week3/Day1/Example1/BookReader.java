package Week3.Day1.Example1;

import java.util.List;

public class BookReader {
    private BookLibrary bookLibrary;

    public BookReader(BookLibrary bookLibrary) {
        this.bookLibrary = bookLibrary;
    }
     public List<Book> read(){
        List<Book> books = bookLibrary.search("somebook");
         for (int i = 0; i < books.size(); i++) {
             System.out.println("Book is: "+ books.get(i));
         }
         return books;
     }
}
