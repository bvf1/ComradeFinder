package is.hi.comradefinder.Controllers;

import is.hi.comradefinder.Persistence.Entities.Ad;
import is.hi.comradefinder.Persistence.Entities.Application;
import is.hi.comradefinder.Persistence.Entities.User;
import is.hi.comradefinder.Services.AdService;
import is.hi.comradefinder.Services.ApplicationService;
import is.hi.comradefinder.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ApplicationController {
    UserService userService;
    AdService adService;
    ApplicationService applicationService;

    @Autowired
    public ApplicationController (ApplicationService applicationService, UserService userService, AdService adService) {
        this.applicationService = applicationService;
        this.userService = userService;
        this.adService = adService;
    }

    // should be in application controller
    @RequestMapping(value="/makeApplication/{adId}", method = RequestMethod.GET)
    public String makeApplication(@PathVariable Long adId, Model model) {

        Long userId = (Long) model.getAttribute("user");

        User user = userService.findByID(userId);
        Ad ad = adService.findById(adId).get();
        Application application = new Application(user, ad);

        applicationService.save(application);

        return "redirect:/user/{" + userId.toString() + "}";
    }
    @RequestMapping(value="/makeApplication/{adId}", method = RequestMethod.POST)
    public String makeApplicationPOST() {

        return "makeApplication";
    }
}
