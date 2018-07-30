package bingoee.sso.demo.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author kael.
 */
@Controller
@RequestMapping("/")
public class HomeController {
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String getCommonPage() {
        return "home";
    }
}
