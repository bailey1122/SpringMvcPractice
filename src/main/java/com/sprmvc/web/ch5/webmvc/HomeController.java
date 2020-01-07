package com.sprmvc.web.ch5.webmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping(value = "/")
//@RequestMapping({"/", "/homepage"})
public class HomeController {

//    @RequestMapping(value = "/", method = GET)
    @RequestMapping(method = GET)
    public String home() {
        return "home";
    }
}
