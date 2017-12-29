package id.web.sahir.tutorial.springboot.mvc.controller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class DefaultController {


    public String homeAction() {
        return "home";
    }
}
