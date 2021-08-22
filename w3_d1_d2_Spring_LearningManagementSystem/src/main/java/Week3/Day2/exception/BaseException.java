package Week3.Day2.exception;

public class BaseException extends Exception{

    private String message;
    private String path;

    public BaseException(String message, String path) {
        this.message = message;
        this.path = path;
    }
}
