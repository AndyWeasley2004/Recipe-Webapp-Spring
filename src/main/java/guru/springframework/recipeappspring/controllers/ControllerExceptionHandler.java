package guru.springframework.recipeappspring.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handle global exception
 */
@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST) // handler has higher precedence
    @ExceptionHandler(NumberFormatException.class)
    public ModelAndView handleBadNumberFormat(Exception exception){
        log.error("Handle Number Format Exception");
        log.error(exception.getMessage());
        String errorMessage = exception.getMessage();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("numberFormatError");
        modelAndView.addObject("exception", exception);
        modelAndView.addObject("message", errorMessage);
        return modelAndView;
    }
}
