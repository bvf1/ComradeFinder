package is.hi.comradefinder.Controllers;

import is.hi.comradefinder.ComradeFinderApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    public String kind;
    public String userName;
    public String password;

    private static final Logger log =  LoggerFactory.getLogger(ComradeFinderApplication.class);

    @RequestMapping("/")
    public String HomeController() {
        return "home";
    }

    @RequestMapping(value= "/home/{user}", method = RequestMethod.POST)
    public String logIn(@ModelAttribute Model model) {
       // model.addAttribute("kind", kind);
        model.addAttribute("user", userName);
        model.addAttribute("password", password);
        log.info(userName + " " + password);
        return "home";
    }



}
