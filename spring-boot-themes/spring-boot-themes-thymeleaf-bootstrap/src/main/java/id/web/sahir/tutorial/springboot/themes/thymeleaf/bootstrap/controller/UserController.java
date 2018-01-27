package id.web.sahir.tutorial.springboot.themes.thymeleaf.bootstrap.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(
        value = {"/user"}
)
public class UserController {
    final static private Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(
            value = {
                    "/login"
            },
            method = RequestMethod.GET
    )
    public String LoginAction() {
        logger.info("login pages");
        return "user/login";
    }

    @RequestMapping(
            value = {
                    "/signup"
            },
            method = RequestMethod.GET
    )
    public ModelAndView SignUpAction() {
        ModelAndView modelAndView = new ModelAndView("userSignUp");
        return modelAndView;
    }
    @RequestMapping(
            value = {
                    "/signUp"
            },
            method = RequestMethod.POST
    )
    public ModelAndView SignUpSaveAction() {
        ModelAndView modelAndView = new ModelAndView("userSignUp");
        return modelAndView;
    }

    @RequestMapping(
            value = {
                    "/forgotPassword"
            },
            method = RequestMethod.GET
    )
    public String ForgotPasswordAction() {
        return "userForgotPassword";
    }
}
