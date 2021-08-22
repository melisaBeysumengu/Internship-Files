package Week3.Day1.Example1;

public class ServiceProviderFramework {
    private BookReader bookReader;

    ServiceProviderFramework(){
        this.bookReader = new BookReader(new JavaBookLibrary());
    }

    BookReader getBookReaderInstance(){
        return this.bookReader;
    }

}
