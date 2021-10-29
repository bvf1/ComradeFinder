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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    CompanyService companyService;

    public String kind;
    public String userName;
    public String password;

    @Autowired
    public HomeController(CompanyService companyService) {
        this.companyService = companyService;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loginGET(Company company) {
        return "home";
    }
    //{"/home.html", "/login.html"}
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String loginPOST(Company company, BindingResult result, Model model, HttpSession session) {
        if (result.hasErrors()) {
            return "redirect:/home";
        }

        Company exists = companyService .login(company);
        if (exists != null) {
            session.setAttribute("LoggedInUser", exists);
            model.addAttribute("LoggedInUser", exists);
            return "viewCompany";
        }
        return "redirect:/home";
    }


    @RequestMapping(value"/info")
    /*
    @RequestMapping(value= "/home/{user}", method = RequestMethod.POST)
    public String logIn(@ModelAttribute Model model) {
       // model.addAttribute("kind", kind);
        model.addAttribute("user", userName);
        model.addAttribute("password", password);
        log.info(userName + " " + password);
        return "home";
    }

    @RequestMapping(value = "RequestMethod.GET)



*/


}
