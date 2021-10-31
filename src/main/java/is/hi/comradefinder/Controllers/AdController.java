package is.hi.comradefinder.Controllers;

import is.hi.comradefinder.Persistence.Entities.Company;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;


@Controller
public class AdController {


    @RequestMapping(value="/makeAd", method = RequestMethod.GET)
    public String makeAdGET(Model model) {

        return "makeAd";
    }

    @RequestMapping(value="/makeAd", method = RequestMethod.POST)
    public String makeAd(Model model) {

        return "makeAd";
    }
/*
    @RequestMapping(path= "/CreateAd/{companyId}", method=RequestMethod.GET)
    public String Ad(@PathVariable String companyId, /*Model model*/ /*) {
       // Company company = companyService.findCompany(companyId);
        return "CreateAd";
    }
    */

}
