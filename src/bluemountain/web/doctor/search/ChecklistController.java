package bluemountain.web.doctor.search;

import bluemountain.pojo.CheckItem;
import bluemountain.pojo.HistoryKeyword;
import bluemountain.pojo.PatientExam;
import bluemountain.protocol.CheckItemRepository;
import bluemountain.protocol.PatientExamRepository;
import bluemountain.protocol.SearchChecklistHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by MainasuK on 2017-3-27.
 */
@Controller
public class ChecklistController {

    private CheckItemRepository checkItemRepository;
    private PatientExamRepository patientExamRepository;
    private SearchChecklistHistoryRepository searchChecklistHistoryRepository;


    @Autowired
    public ChecklistController(CheckItemRepository checkItemRepository, PatientExamRepository patientExamRepository, SearchChecklistHistoryRepository searchChecklistHistoryRepository) {
        this.checkItemRepository = checkItemRepository;
        this.patientExamRepository = patientExamRepository;
        this.searchChecklistHistoryRepository = searchChecklistHistoryRepository;
    }

    @RequestMapping(value = "/doctor/search/checklist", method = RequestMethod.GET)
    public String checklist(Model model) {
        model.addAttribute("checkItems", checkItemRepository.all());
        model.addAttribute("patientExams", patientExamRepository.all());

        return "doctor/search/checklist";
    }

    @RequestMapping(value = "/doctor/search/checklist", method = RequestMethod.POST)
    public String checklist(Principal principal, Model model, HttpServletRequest request) {
        List<CheckItem> checkItems = checkItemRepository.all();
        model.addAttribute("checkItems", checkItems);

        String and = HistoryKeyword.getConditionOfAnd();
        String or  = HistoryKeyword.getConditionOfOr();
        String not = HistoryKeyword.getConditionOfNot();

        List<PatientExam> patientExams = patientExamRepository.all().stream().collect(Collectors.toList());

        String examClass = request.getParameter("examClass");
        if (!examClass.contains("不限")) {
            patientExams = patientExams.stream().filter(exam -> exam.getChecklist().getCheckItem().getExamclass().contentEquals(examClass)).collect(Collectors.toList());
        }

        List<String> conditionsToSave = new ArrayList<>();
        List<String> keywordsToSave = new ArrayList<>();

        Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements()) {
            String key = names.nextElement();
            String value = request.getParameter(key);

            if (key.startsWith("item") && names.hasMoreElements()) {
                String inputValue = request.getParameter(names.nextElement());
                conditionsToSave.add(value);
                keywordsToSave.add(inputValue);

                if (value.equals(and)) {
                    patientExams = patientExams.stream().filter(exam -> exam.getChecklist().getPhysicSign().contains(inputValue)).collect(Collectors.toList());
                } else if (value.equals(or)) {
                    patientExams = patientExams.stream().filter(exam -> !exam.getChecklist().getPhysicSign().contains(inputValue)).collect(Collectors.toList());
                } else {
                    List<PatientExam> result = patientExams.stream().filter(exam -> exam.getChecklist().getPhysicSign().contains(inputValue)).collect(Collectors.toList());
                    result.removeAll(patientExams);
                    patientExams.addAll(result);
                }
            }

            System.out.println(key + "::" + value);
        }

        String username = principal.getName();
        if (null != username && "" != username) {
            checkItems.stream().filter(item -> item.getExamclass().equals(examClass)).findFirst().ifPresent(item -> {
                try {
                    searchChecklistHistoryRepository.save(item.getPerformedby(), username, conditionsToSave, keywordsToSave);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
        }

        model.addAttribute("patientExams", patientExams);

        return "doctor/search/checklist";
    }

}
