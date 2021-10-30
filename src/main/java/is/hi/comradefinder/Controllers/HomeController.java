package is.hi.comradefinder.Controllers;

import is.hi.comradefinder.ComradeFinderApplication;
import is.hi.comradefinder.Persistence.Entities.Company;
import is.hi.comradefinder.Services.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    CompanyService companyService;

    public String kind;
    public String userName;
    public String password;

    private static final Logger log =  LoggerFactory.getLogger(ComradeFinderApplication.class);

    @Autowired
    public HomeController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping(value = "/")
    public String HomePage() {
        return "home";
    }

    //Works
  /* @RequestMapping(value = "/", method = RequestMethod.POST)
   public String register(@RequestParam(value="accountType") String accountType, Company company) {
       log.info(accountType);
       return "home";   }
    }*/


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loginGET(Company company) {
        return "home";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String loginPOST(Company company, BindingResult result, Model model, HttpSession session) {
        if (result.hasErrors()) {
            return "redirect:/";
        }

        Company exists = companyService .login(company);
        if (exists != null) {
            session.setAttribute("LoggedInUser", exists);
            model.addAttribute("LoggedInUser", exists);
            return "viewCompany";
        }
        return "redirect:/";
    }
}
