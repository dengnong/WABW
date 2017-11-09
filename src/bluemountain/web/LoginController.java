package bluemountain.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

/**
 * Created by MainasuK on 2017-3-5.
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model, Principal principal, Authentication authentication) {
        if (null == principal) {
            return "redirect: /login";
        }

        // if doctor login
        if (authentication != null && authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_DOCTOR"))) {
            return "redirect: /doctor/home";
        } else if (authentication != null && authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_USER"))) {
            return "redirect: /patient/case";
        } else {
            return "redirect: /login";
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, Principal principal, Authentication authentication) {

        if (null == principal || null == principal.getName()) {
            model.addAttribute("username", "");
        } else {
            model.addAttribute("username", principal.getName());
        }

        return "login";
    }

}
