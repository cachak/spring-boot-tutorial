package id.web.sahir.tutorial.springboot.themes.thymeleaf.bootstrap.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class DefaultController {
    final static private Logger logger = LoggerFactory.getLogger(DefaultController.class);


    @RequestMapping(value = {"/","/home"})
    public String DefaultAction() {
        return "default";
    }
}
