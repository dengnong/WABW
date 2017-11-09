package bluemountain.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by MainasuK on 2017-3-5.
 */
@Controller
@RequestMapping("/root")
public class RootController {

    @RequestMapping(method = RequestMethod.GET)
    public String root() {
        return "root";
    }

}
