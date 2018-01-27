package id.web.sahir.tutorial.springboot.security.javaconfig.controller;

import id.web.sahir.framework.security.controller.MyUserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(
        value = {"/user"}
)
public class UserController extends MyUserController {
    final static private Logger logger = LoggerFactory.getLogger(UserController.class);


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
    public ModelAndView SignUpSaveAction(BindingResult result) {
        ModelAndView modelAndView = new ModelAndView("userSignUp");
        return modelAndView;
    }

}
