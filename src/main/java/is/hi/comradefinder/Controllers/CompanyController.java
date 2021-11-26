package is.hi.comradefinder.Controllers;

import is.hi.comradefinder.ComradeFinderApplication;
import is.hi.comradefinder.Persistence.Entities.Ad;
import is.hi.comradefinder.Persistence.Entities.Application;
import is.hi.comradefinder.Persistence.Entities.Company;
import is.hi.comradefinder.Persistence.Entities.User;
import is.hi.comradefinder.Services.AdService;
import is.hi.comradefinder.Services.ApplicationService;
import is.hi.comradefinder.Services.CompanyService;
import is.hi.comradefinder.Services.UserService;
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
import java.util.ArrayList;
import java.util.List;

@Controller
public class CompanyController {

    CompanyService companyService;
    AdService adService;
    ApplicationService applicationService;
    UserService userService;
    private static final Logger log =  LoggerFactory.getLogger(ComradeFinderApplication.class);

    @Autowired
    public CompanyController (CompanyService companyService, AdService adService, ApplicationService applicationService, UserService userService) {
        this.companyService = companyService;
        this.adService = adService;
        this.applicationService = applicationService;
        this.userService = userService;
    }

    @RequestMapping(value="register/company", method= RequestMethod.GET)
    public String registerGET(Company company) {
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
        return viewCompanyREAL(companyId, model, company, session);
    }

    @RequestMapping(value="/company", method=RequestMethod.GET)
    public String viewCompanyGET2(@RequestParam(value="companyId") Long companyId, Model model, Company company, HttpSession session) {
        return viewCompanyREAL(companyId, model, company, session);
    }

    // I couldn't use the formatting of the original viewCompanyGET
    // so I created 2 that map to the same code.
    public String viewCompanyREAL(Long companyId, Model model, Company company, HttpSession session) {
        model.addAttribute("companyId", companyId);
        Company loggedInCompany = companyService.findByID(companyId);
        model.addAttribute("company", loggedInCompany);
        // Finds all ads that belong to this company
        List<Ad> allAds = adService.findAdsByCompany(loggedInCompany.getUsername());
        model.addAttribute("ads", allAds);
        return "viewCompany";
    }

    @RequestMapping(value="/viewApplicants", method=RequestMethod.POST)
    public String viewApplicantsPOST(@RequestParam(value="adID") Long adID, Model model, Company company, HttpSession session) {
        List<Application> applications = applicationService.findByAd(adService.findByID(adID));
        List<User> users = new ArrayList<User>();
        for (Application a : applications) {
            users.add(a.getUser());
        }
        model.addAttribute("users", users);

        /*
        model.addAttribute("companyId", companyId);
        Company loggedInCompany = companyService.findByID(companyId);
        model.addAttribute("company", loggedInCompany);
        // Finds all ads that belong to this company
        List<Ad> allAds = adService.findAdsByCompany(loggedInCompany.getUsername());
        model.addAttribute("ads", allAds);
        /**/
        return "viewApplicants";
    }

}
