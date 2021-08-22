package Week3.Day2.exception;

public class NameNotFoundException extends BaseException{

    public NameNotFoundException(String message, String path) {
        super(message, path);
    }
}
