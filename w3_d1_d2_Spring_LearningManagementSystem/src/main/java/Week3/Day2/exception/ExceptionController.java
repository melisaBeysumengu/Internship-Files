package Week3.Day2.exception;

import Week3.Day2.model.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@ResponseBody
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public ErrorResponse handleException(HttpServletRequest request, Exception ex){
        ErrorResponse response = new ErrorResponse();
        response.setMessage(ex.getMessage());
        response.setPath(request.getRequestURI());
        return response;
    }

    @ExceptionHandler(BaseException.class)
    public ErrorResponse handleException(HttpServletRequest request, BaseException ex){
        ErrorResponse response = new ErrorResponse();
        response.setMessage(ex.getMessage());
        response.setPath(request.getRequestURI());
        return response;
    }

    @ExceptionHandler(NameNotFoundException.class)
    public ErrorResponse handleException(HttpServletRequest request, NameNotFoundException ex){
        ErrorResponse response = new ErrorResponse();
        response.setMessage(ex.getMessage());
        response.setPath(request.getRequestURI());
        return response;
    }

}
