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
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class  AdController {

    AdService adService;
    private static final Logger log =  LoggerFactory.getLogger(ComradeFinderApplication.class);


    @Autowired
    public AdController (AdService adService) {
        this.adService = adService;
    }

    @RequestMapping(value="/makeAd", method = RequestMethod.GET)
    public String makeAdGET(Ad ad) {
        return "makeAd";
    }


    @RequestMapping(value="/makeAd", method = RequestMethod.POST)
    public String makeAd(Ad ad, BindingResult result, Model model, HttpSession session) {
        if (result.hasErrors()) {
            return "makeAd";
        }
        Company company = (Company) session.getAttribute("LoggedInUser");
        ad.setCompany(company);


        if (ad != null && company != null ) {
            adService.save(ad);
            model.addAttribute("LoggedInUser", company);
            return "redirect:/company/" + company.getID();
        }
        return "redirect:/";
    }

    @RequestMapping(value="/makeAd/delete/{id}", method = RequestMethod.POST)
    public String makeAdDELETE(@PathVariable("id") long id, Model model, HttpSession session) {
        Company company = (Company) session.getAttribute("LoggedInUser");
        Ad ad = adService.findByID(id);

        if (ad != null && company != null ) {
            adService.delete(ad);
            model.addAttribute("LoggedInUser", company);
            return "redirect:/company/" + company.getID();
        }
        return "redirect:/";
    }


}
