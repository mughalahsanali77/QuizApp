package app.quiz.common.helper;

import app.quiz.common.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

  /*  @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleAllUncaughtException(
            RuntimeException exception,
            WebRequest request) {
        exception.printStackTrace();
        return ResponseUtil.returnResponse(exception);
    }*/

    @ExceptionHandler(CustomException.class)
    ResponseEntity<Object> handleCustomException(CustomException customException){
        customException.printStackTrace();
        return ResponseUtil.returnResponse(customException);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    ResponseEntity<Object>handleIllegalArgumentException(IllegalArgumentException illegalArgumentException){
        illegalArgumentException.printStackTrace();
        return ResponseUtil.returnResponse(illegalArgumentException);
    }
}
