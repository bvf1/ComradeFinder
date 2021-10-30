package is.hi.comradefinder.Controllers;

import is.hi.comradefinder.ComradeFinderApplication;
import is.hi.comradefinder.Persistence.Entities.Company;
import is.hi.comradefinder.Persistence.Entities.User;
import is.hi.comradefinder.Services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    UserService userService;

    private static final Logger log =  LoggerFactory.getLogger(ComradeFinderApplication.class);


    @Autowired
    public UserController (UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value="register/user", method= RequestMethod.GET)
    public String registerGET(User user) {
        return "registeruser";
    }
/*
    @RequestMapping(value = "/register/user", method = RequestMethod.POST)
    public String registerPOST(User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "registeruser";
        }
        if (userService.findByUsername(user.getUsername()) != null) {
            return "registeruser";
        }
        companyService.save(company);
        return "redirect:/";
    }*/
}
