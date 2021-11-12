package is.hi.comradefinder.Controllers;

import is.hi.comradefinder.ComradeFinderApplication;
import is.hi.comradefinder.Persistence.Entities.Ad;
import is.hi.comradefinder.Persistence.Entities.Company;
import is.hi.comradefinder.Services.AdService;
import is.hi.comradefinder.Services.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;


@Controller
public class  AdController {

    AdService adService;
    private static final Logger log =  LoggerFactory.getLogger(ComradeFinderApplication.class);


    @Autowired
    public AdController (AdService adService) {
        this.adService = adService;
    }

    @RequestMapping(value="/makeAd", method = RequestMethod.GET)
    public String makeAdGET(Ad ad, Model model, HttpSession session) {
        Company company = (Company) session.getAttribute("LoggedInUser");

        log.info(String.valueOf(company));

        if (company != null) {
            log.info("no is not null");
            log.info(company.toString());

            return "makeAd";


        }
        log.info("company is null");
        return "redirect:/";
        // return "makeAd";

    }


    @RequestMapping(value="/makeAd", method = RequestMethod.POST)
    public String makeAd(Ad ad, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "makeAd";
        }
        

        if (adService.findById(ad.getId()) != null) {
            return "viewCompany";
        }
        adService.save(ad);
        return "redirect:/";
    }
/*
    @RequestMapping(path= "/CreateAd/{companyId}", method=RequestMethod.GET)
    public String Ad(@PathVariable String companyId, /*Model model*/ /*) {
       // Company company = companyService.findCompany(companyId);
        return "CreateAd";
    }
    */

}
