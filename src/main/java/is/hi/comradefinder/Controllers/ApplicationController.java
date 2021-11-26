package is.hi.comradefinder.Controllers;

import is.hi.comradefinder.ComradeFinderApplication;
import is.hi.comradefinder.Persistence.Entities.Ad;
import is.hi.comradefinder.Persistence.Entities.Application;
import is.hi.comradefinder.Persistence.Entities.User;
import is.hi.comradefinder.Services.AdService;
import is.hi.comradefinder.Services.ApplicationService;
import is.hi.comradefinder.Services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class ApplicationController {
    UserService userService;
    AdService adService;
    ApplicationService applicationService;
    private static final Logger log =  LoggerFactory.getLogger(ComradeFinderApplication.class);



    @Autowired
    public ApplicationController (ApplicationService applicationService, UserService userService, AdService adService) {
        this.applicationService = applicationService;
        this.userService = userService;
        this.adService = adService;
    }

    // should be in application controller
    @RequestMapping(value="/makeApplication", method = RequestMethod.POST)
    public String makeApplicationGET(
            @RequestParam(value="id") Long id, Model model, HttpSession session) {
        //  model.addAttribute("id", id);

        User user = (User) session.getAttribute("LoggedInUser");
        Ad ad = adService.findByID(id);
        model.addAttribute("ad", ad);

        Application application = new Application(user, ad);

        List<Application> applications = applicationService.findAll();

        for(Application a : applications) {
            if (a.getAd().getID() == ad.getID() && a.getUser().getID() == user.getID()) {

                applicationService.delete(a);
            }
        }

        applicationService.save(application);

        return "redirect:/user/" + user.getID();
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deleteApplication(@PathVariable("id") long id, Model model, HttpSession session){
        List<Application> applications = applicationService.findAll();
        User user = (User) session.getAttribute("LoggedInUser");

        Ad ad = adService.findByID(id);

        if(applicationService.findApplicationByUserAndAd(user, ad).isPresent()){
            Application theApplication = applicationService.findApplicationByUserAndAd(user, ad).get();

            applicationService.delete(theApplication);
        }

        return "redirect:/user/" + user.getID();
    }

   /* @RequestMapping(value="/makeApplication", method = RequestMethod.GET)
    public String makeApplicationPOST(
            @RequestParam(value="id") Long id, Model model, HttpSession session) {
        //  model.addAttribute("id", id);


    /*    List<Application> applications = applicationService.findAll();
        for(Application a : applications) {
            if (a.getID().equals(application)) {

            }
            applicationService.findById(a.getApplicationID());
        }
        return "/";
    }*/
}
