package bluemountain.web.patient;

import bluemountain.protocol.CheckListRepository;
import bluemountain.protocol.PatientRepository;
import bluemountain.protocol.TestListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 54472 on 2017/4/2.
 */

@Controller
public class PatientCaseController {
    private PatientRepository patientRepository;
    private CheckListRepository checkListRepository;
    private TestListRepository testListRepository;

    @Autowired
    public PatientCaseController(PatientRepository patientRepository,
                                 CheckListRepository checkListRepository,
                                 TestListRepository testListRepository) {
        this.patientRepository = patientRepository;
        this.checkListRepository = checkListRepository;
        this.testListRepository = testListRepository;
    }

    @RequestMapping(value = {"/patient/case/{patientId}","/doctor/statistics/patient/{patientId}"}, method = RequestMethod.GET)
    public String Case(@PathVariable int patientId, Model model) {
        model.addAttribute("patient", patientRepository.patientWithId(patientId));
        model.addAttribute("checklists", checkListRepository.listsOfPatient(patientId));
        model.addAttribute("testLists", testListRepository.testListWithId(patientId));
        return "patient/case";
    }

}
