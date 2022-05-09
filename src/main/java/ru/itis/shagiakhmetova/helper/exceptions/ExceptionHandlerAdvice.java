package ru.itis.shagiakhmetova.helper.exceptions;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.shagiakhmetova.helper.exceptions.AccountNotExistsException;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Log4j2
public class ExceptionHandlerAdvice {
   @ExceptionHandler(AccountNotExistsException.class)
    public ModelAndView handleError(HttpServletRequest request, AccountNotExistsException exception) {
    log.error("Request: " + request.getRequestURL() + " raised " + exception);
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("exception", exception);
    modelAndView.addObject("url", request.getRequestURL());
    modelAndView.setViewName("account is not found");
    return modelAndView;
   }
}
