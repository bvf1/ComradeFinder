package is.hi.comradefinder.Controllers;

import is.hi.comradefinder.Persistence.Entities.Company;
import is.hi.comradefinder.Services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CompanyController {
    CompanyService companyService;

    @Autowired
    public CompanyController (CompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping(value="/register", method= RequestMethod.POST)
    public String companyViewInfo(@ModelAttribute("company") Company company, Model model) {

        companyService.save(company);

        model.addAttribute("company", new Company());

        //not needed in project
        model.addAttribute("Companies", companyService.findAllReverseOrder());

        //return "companies/Companies";
        return "/Home";
    }
}
