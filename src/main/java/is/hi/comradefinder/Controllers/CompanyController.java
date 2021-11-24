package is.hi.comradefinder.Controllers;

import is.hi.comradefinder.ComradeFinderApplication;
import is.hi.comradefinder.Persistence.Entities.Company;
import is.hi.comradefinder.Services.CompanyService;
import org.apache.coyote.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class CompanyController {

    CompanyService companyService;
    private static final Logger log =  LoggerFactory.getLogger(ComradeFinderApplication.class);

    @Autowired
    public CompanyController (CompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping(value="register/company", method= RequestMethod.GET)
    public String registerGET(Company company) {
        log.info("what");
        return "registercompany";
    }

    @RequestMapping(value = "/register/company", method = RequestMethod.POST)
    public String registerPOST(Company company, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "registercompany";
        }
        if (companyService.findByUsername(company.getUsername()) != null) {
            return "registercompany";
        }
        companyService.save(company);
        return "redirect:/";
    }

    @RequestMapping(value="/company/{companyId}", method=RequestMethod.GET)
    public String viewCompanyGET(@PathVariable Long companyId, Model model, Company company, HttpSession session) {
        model.addAttribute("companyId", companyId);
        model.addAttribute("company", companyService.findByID(companyId));
        return "viewCompany";

    }

}
