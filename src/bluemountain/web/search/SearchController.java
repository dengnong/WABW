package bluemountain.web.search;

import bluemountain.pojo.PatientExam;
import bluemountain.protocol.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by MainasuK on 2017-3-9.
 */
@Controller
@RequestMapping("/search")
public class SearchController {
    private CheckItemRepository checkItemRepository;
    private CheckListRepository checkListRepository;
    private TestItemRepository testItemRepository;
    private DepartmentRepository departmentRepository;
    private PatientExamRepository patientExamRepository;



    ChargeTypeRepository chargeTypeRepository;



    @Autowired
    public SearchController(ChargeTypeRepository chargeTypeRepository,
                            CheckItemRepository checkItemsRepository,
                            CheckListRepository checkListRepository,
                            TestItemRepository testItemRepository,
                            DepartmentRepository departmentRepository,
                            PatientExamRepository patientExamRepository,
                            PatientRepository patientRepository) {
        this.chargeTypeRepository = chargeTypeRepository;
        this.checkItemRepository = checkItemsRepository;
        this.checkListRepository = checkListRepository;
        this.testItemRepository = testItemRepository;
        this.departmentRepository = departmentRepository;
        this.patientExamRepository = patientExamRepository;

    }

    @RequestMapping(value = "/charges", method = RequestMethod.GET)
    public String charges(Model model) {
        model.addAttribute("chargeTypes", chargeTypeRepository.all());

        return "search/charges" ;
    }

    @RequestMapping(value = "/checklist", method = RequestMethod.GET)
    public String checklist(Model model) {
        model.addAttribute("checkList", checkListRepository.all());

        return "search/checklist" ;
    }

    // For search test itmm
    @RequestMapping(value = "/searchtestinfo", method = RequestMethod.GET)
    public String searchtestinfo(Model model) {
        model.addAttribute("testItem", testItemRepository.all());

        return "search/searchtestinfo" ;
    }

    @RequestMapping(value = "/searchpatientinfo", method = RequestMethod.GET)
    public String searchpatientinfo(Model model) {
        model.addAttribute("departments", departmentRepository.all());

        return "search/searchpatientinfo" ;
    }

    @RequestMapping(value = "/searchpatientinfo", method = RequestMethod.POST)
    public String searchpatientinfo(Model model, String choseSex, Integer min, Integer max, String selectLevel) {
        model.addAttribute("departments", departmentRepository.all());

        System.out.println(choseSex);
        System.out.println(min);
        System.out.println(max);
        System.out.println(selectLevel);

        List<PatientExam> patientExams = patientExamRepository.all();

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        if (!"".equals(choseSex)) {
            patientExams = patientExams.stream().filter(exam -> exam.getPatient().getSex().equals(choseSex)).collect(Collectors.toList());
        }

        if (null != min) {
            patientExams = patientExams.stream().filter(exam -> (currentYear - exam.getPatient().getDateOfBirth().toLocalDate().getYear()) >= min).collect(Collectors.toList());
        }

        if (null != max) {
            patientExams = patientExams.stream().filter(exam -> (currentYear - exam.getPatient().getDateOfBirth().toLocalDate().getYear()) <= max).collect(Collectors.toList());
        }

        if (!"".equals(selectLevel)) {
            patientExams = patientExams.stream().filter(exam -> exam.getChecklist().getDepartmentName().equals(selectLevel)).collect(Collectors.toList());
        }


        patientExams.stream().forEach(exam -> System.out.println(exam.getPatient().getSex()));

        return "search/searchpatientinfo" ;
    }

    @RequestMapping(value = "/navbar")
    public String navbar() {
        // m odel.addAttribute("checkItem", checkItemRepository.all());

        return "component/navbar";
    }
    @RequestMapping(value = "/sidebar")
    public String sidebar() {
        // m odel.addAttribute("checkItem", checkItemRepository.all());

        return "search/sidebar";
    }
    @RequestMapping(value = "/index")
    public String index() {
        // m odel.addAttribute("checkItem", checkItemRepository.all());

        return "doctor/home";
    }




}
