package id.web.sahir.framework.security.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(
        value = {"/user"}
)
public class MyUserController {
    final static private Logger logger = LoggerFactory.getLogger(MyUserController.class);

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
                    "/forgotPassword"
            },
            method = RequestMethod.GET
    )
    public String ForgotPasswordAction() {
        return "user/forgotPassword";
    }

    @RequestMapping(
            value = {
                    "/profile"
            },
            method = RequestMethod.GET
    )
    public String ProfileAction() {
        return "user/profile";
    }
}
