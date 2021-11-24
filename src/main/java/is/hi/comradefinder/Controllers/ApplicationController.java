package is.hi.comradefinder.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ApplicationController {

    // should be in application controller
    @RequestMapping(value="/makeApplication", method = RequestMethod.GET)
    public String makeApplication() {

        return "makeApplication";
    }
    @RequestMapping(value="/makeApplication", method = RequestMethod.POST)
    public String makeApplicationPOST() {

        return "makeApplication";
    }
}
