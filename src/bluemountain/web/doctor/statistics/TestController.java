package bluemountain.web.doctor.statistics;

import bluemountain.protocol.TestItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by MainasuK on 2017-3-24.
 */
@Controller
@RequestMapping(value = "/doctor/statistics")
public class TestController {

    private TestItemRepository testItemRepository;

    @Autowired
    public TestController(TestItemRepository testItemRepository) {
        this.testItemRepository = testItemRepository;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(Model model) {
        model.addAttribute("testItems", testItemRepository.all());

        return "doctor/statistics/testItem";
    }

}
