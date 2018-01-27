package id.web.sahir.tutorial.springboot.themes.thymeleaf.bootstrap.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class DefaultController {
    final static private Logger logger = LoggerFactory.getLogger(DefaultController.class);


    @RequestMapping(value = {"/","/home"})
    public ModelAndView HomeAction(HttpServletRequest request, HttpServletResponse response) {
        logger.info("load home");
        if (request.getSession().getAttribute("test") != null) {
            logger.info("session exist : " + request.getSession().getAttribute("test"));
        } else {
            logger.info("session not exist : " + request.getSession().getAttribute("test"));
        }
        request.getSession().setAttribute("test", "Sahir");

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("defaultHome");
        return modelAndView;
    }
    @RequestMapping(
            value = {"/test-error"}
    )
    public String testErroraction() {
        throw new NullPointerException("Throwing a null pointer exception");
    }
}
