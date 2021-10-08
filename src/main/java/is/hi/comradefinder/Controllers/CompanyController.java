package is.hi.comradefinder.Controllers;

import is.hi.comradefinder.Persistence.Entities.Company;
import is.hi.comradefinder.Services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CompanyController {

    CompanyService companyService;

    @Autowired
    public CompanyController (CompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping(value="/register", method= RequestMethod.POST)
    public String companyViewInfo(@ModelAttribute("company") Company company, Model model) {

        companyService.save(company);

        model.addAttribute("company", new Company());

        model.addAttribute("Companies", companyService.findAllReverseOrder());

        return "/companies";
    }

    @RequestMapping(value = "/companies/{name}", method = RequestMethod.GET)
    public String findByName(@PathVariable String name, Model model) {

        model.addAttribute("companies", companyService.findByName(name));
        model.addAttribute("company", new Company());
        return "/companies";
    }
    @RequestMapping(value = "/companies", method = RequestMethod.GET)
    public String companyViewGet(Model model) {
        model.addAttribute("company", new Company());
        model.addAttribute("companies", companyService.findAllReverseOrder());
        return "/companies";
    }
}
