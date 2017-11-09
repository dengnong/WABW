package bluemountain.web.doctor.statistics;

import bluemountain.protocol.CheckItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.stream.Collectors;

/**
 * Created by MainasuK on 2017-3-24.
 */
@Controller
@RequestMapping(value = "/doctor/statistics/check")
public class CheckController {

    private CheckItemRepository checkItemRepository;

    @Autowired
    public CheckController(CheckItemRepository checkItemRepository) {
        this.checkItemRepository = checkItemRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String checkitems(Model model) {
        model.addAttribute("checkItems", checkItemRepository.all());

        return "doctor/statistics/checkItem";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String checkitems(String keyword) {
        return "redirect:/doctor/statistics/check/" + keyword.trim(); // Be careful with the '/'
    }

    @RequestMapping(value = "/{keyword}", method = RequestMethod.GET)
    public String showCheckitemsFor(@PathVariable String keyword, Model model) {
        model.addAttribute("checkItem",
                checkItemRepository.all()
                        .parallelStream()
                        .filter(item ->
                                item.getExamclass().contains(keyword) || ("" + item.getPerformedby()).contains(keyword)
                        ).collect(Collectors.toList())
        );

        return "doctor/statistics/checkItem";
    }

}
