package is.hi.comradefinder.Controllers;

import is.hi.comradefinder.ComradeFinderApplication;
import is.hi.comradefinder.Persistence.Entities.Ad;
import is.hi.comradefinder.Persistence.Entities.User;
import is.hi.comradefinder.Services.AdService;
import is.hi.comradefinder.Services.ApplicationService;
import is.hi.comradefinder.Services.UserService;
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
import java.util.List;

@Controller
public class UserController {
    UserService userService;
    AdService adService;
    ApplicationService applicationService;

    private static final Logger log =  LoggerFactory.getLogger(ComradeFinderApplication.class);


    @Autowired
    public UserController (UserService userService, AdService adService, ApplicationService applicationService) {
        this.userService = userService;
        this.adService = adService;
        this.applicationService = applicationService;
    }

    @RequestMapping(value="register/user", method= RequestMethod.GET)
    public String registerGET(User user) {
        return "registeruser";
    }


    @RequestMapping(value = "/register/user", method = RequestMethod.POST)
    public String registerPOST(User user, BindingResult result, Model model) {
        log.info("register user");
        if (result.hasErrors()) {
            return "registeruser";
        }
        if (userService.findByUsername(user.getUsername()) != null) {
            return "registeruser";
        }
        userService.save(user);
        return "redirect:/";
    }

    @RequestMapping(value="/user/{userId}", method=RequestMethod.GET)
    public String viewUserGET(@PathVariable Long userId, Model model, User user, HttpSession session) {
        model.addAttribute("companyId", userId);
        model.addAttribute("user", userService.findByID(userId));
        // Send ads for HTML to use
        List<Ad> allAds = adService.findAll();
        model.addAttribute("ads", allAds);
        // PLZ WORK
        model.addAttribute("appServ", applicationService);
        return "viewUser";

    }

}
