package bluemountain.web.doctor;

import bluemountain.protocol.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

/**
 * Created by 54472 on 2017/3/24.
 */
@Controller
public class DoctorHomeController {

    PatientRepository patientRepository;
    CheckItemRepository checkItemRepository;
    CheckListRepository checkListRepository;
    TestItemRepository testItemRepository;
    TestListRepository testListRepository;

    @Autowired
    public DoctorHomeController(PatientRepository patientRepository, CheckItemRepository checkItemRepository, CheckListRepository checkListRepository, TestItemRepository testItemRepository, TestListRepository testListRepository) {
        this.patientRepository = patientRepository;
        this.checkItemRepository = checkItemRepository;
        this.checkListRepository = checkListRepository;
        this.testItemRepository = testItemRepository;
        this.testListRepository = testListRepository;
    }

    @RequestMapping(value = "/doctor/home", method = RequestMethod.GET)
    public String home(Model model, Principal principal) {

        if (null == principal || null == principal.getName()) {
            model.addAttribute("username", "");
        } else {
            model.addAttribute("username", principal.getName());
        }

        model.addAttribute("patientQuantity", patientRepository.size());
        model.addAttribute("checkItemQuantity", checkItemRepository.size());
        model.addAttribute("testItemQuantity", testItemRepository.size());

        model.addAttribute("checkQuantityOfLastWeek", checkListRepository.quantityOfLastWeek());
        model.addAttribute("checkQuantityOfLastMonth", checkListRepository.quantityOfLastMonth());
        model.addAttribute("checkQuantityOfLastYear", checkListRepository.qunaityOfLastYear());

        model.addAttribute("testQuantityOfLastWeek", testListRepository.quantityOfLastWeek());
        model.addAttribute("testQuantityOfLastMonth", testListRepository.quantityOfLastMonth());
        model.addAttribute("testQuantityOfLastYear", testListRepository.quantityOfLastYear());

        model.addAttribute("newestThreeCheckedPatients", patientRepository.newestPatientsOf(3));

        model.addAttribute("checkQuantityOfMale", patientRepository.quantityOfMale());
        model.addAttribute("checkQuantityOfFemale", patientRepository.quantityOfFemale());

        model.addAttribute("checkQuantityOfAge2", patientRepository.quantityInRange(0,20));
        model.addAttribute("checkQuantityOfAge3", patientRepository.quantityInRange(20,30));
        model.addAttribute("checkQuantityOfAge4", patientRepository.quantityInRange(30,40));
        model.addAttribute("checkQuantityOfAge5", patientRepository.quantityInRange(40,50));
        model.addAttribute("checkQuantityOfAge6", patientRepository.quantityInRange(50,60));
        model.addAttribute("checkQuantityOfAge10", patientRepository.quantityInRange(60,150));


        return "doctor/home";
    }

}
