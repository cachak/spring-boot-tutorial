package id.web.sahir.tutorial.springboot.mvc.controller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/redirect")
public class RedirectController {

    @RequestMapping(value = {"/","/landing"})
    public String defaultAction() {
        return "redirectDefault";
    }

}
