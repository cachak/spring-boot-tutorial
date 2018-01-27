package id.web.sahir.tutorial.springboot.themes.thymeleaf.bootstrap.controller;

 import java.text.MessageFormat;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyErrorController implements ErrorController {
    final static private Logger logger = LoggerFactory.getLogger(MyErrorController.class);

    @RequestMapping(
            value = {"/error"},
            produces = {"text/html"}
    )
    public ModelAndView errorPageAction(HttpServletRequest request,Exception exception) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
        // String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
        String exceptionMessage = exception.getMessage();// getExceptionMessage(throwable, statusCode);
        if (exceptionMessage == null || exceptionMessage.isEmpty()) {
            if (throwable != null) {
                exceptionMessage = throwable.getMessage();
            }
        }

        String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
        if (requestUri == null) {
            requestUri = "Unknown";
        }

        String message = MessageFormat.format("{0} returned for {1} with message {2}",
                statusCode, requestUri, exceptionMessage
        );
        logger.error("Request: " + request.getRequestURI() + ". Raised: " + exception + ". Message: " + message + ".");

        String errorPage = "error/error";
        int httpErrorCode = getErrorCode(request);
        switch (httpErrorCode) {
            case 400: {
                errorPage = "error/400";
                break;
            }
            case 401: {
                errorPage = "error/401";
                break;
            }
            case 404: {
                errorPage = "error/404";
                break;
            }
            case 500: {
                errorPage = "error/500";
                break;
            }
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", exception);
        modelAndView.addObject("url", request.getRequestURL());
        modelAndView.setViewName(errorPage);
        return modelAndView;
    }

    private int getErrorCode(HttpServletRequest request) {
        return (Integer) request.getAttribute("javax.servlet.error.status_code");
    }

    /*
    private String getExceptionMessage(Throwable throwable, Integer statusCode) {
        if (throwable != null) {
            return Throwables.getRootCause(throwable).getMessage();
        }
        HttpStatus httpStatus = HttpStatus.valueOf(statusCode);
        return httpStatus.getReasonPhrase();
    }
    */

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
