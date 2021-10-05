package is.hi.comradefinder.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String HomeController() {
        //Buisness Logic
        //Call a method in a Service Class
        //Add data to the model
        return "home";
    }
}
