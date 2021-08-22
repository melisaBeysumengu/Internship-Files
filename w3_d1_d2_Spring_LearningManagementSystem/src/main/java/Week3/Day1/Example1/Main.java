package Week3.Day1.Example1;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ServiceProviderFramework spf = new ServiceProviderFramework();

        BookReader bookReader = spf.getBookReaderInstance();
        List<Book> books = bookReader.read();

        System.out.println("Total Book: " + books.size());
    }
}
