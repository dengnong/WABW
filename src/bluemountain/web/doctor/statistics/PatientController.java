package bluemountain.web.doctor.statistics;

import bluemountain.pojo.Department;
import bluemountain.pojo.HistoryPatient;
import bluemountain.pojo.Patient;
import bluemountain.pojo.PatientExam;
import bluemountain.protocol.DepartmentRepository;
import bluemountain.protocol.HistoryPatientRepository;
import bluemountain.protocol.PatientExamRepository;
import bluemountain.protocol.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by 54472 on 2017/3/22.
 */

@Controller
public class PatientController {

    private PatientRepository patientRepository;
    private PatientExamRepository patientExamRepository;
    private DepartmentRepository departmentRepository;
    private HistoryPatientRepository historyPatientRepository;

    @Autowired
    public PatientController(PatientRepository patientRepository, PatientExamRepository patientExamRepository, DepartmentRepository departmentRepository, HistoryPatientRepository historyPatientRepository) {
        this.patientRepository = patientRepository;
        this.patientExamRepository = patientExamRepository;
        this.departmentRepository = departmentRepository;
        this.historyPatientRepository = historyPatientRepository;
    }

    @RequestMapping(value = "doctor/statistics/patient", method = RequestMethod.GET)
    public String patient(Model model) {
        model.addAttribute("patients", patientRepository.all());
        model.addAttribute("departments", departmentRepository.all());
        model.addAttribute("historyPatients",historyPatientRepository.all());

        return "doctor/statistics/patient";
    }

    @RequestMapping(value = "doctor/statistics/patient", method = RequestMethod.POST)
    public String patient(Principal principal, Model model, String gender, Integer min, Integer max, String department) {
        List<Department> departments = departmentRepository.all();
        model.addAttribute("departments", departments);

        System.out.println(gender);
        System.out.println(min);
        System.out.println(max);
        System.out.println(department);

        departments.stream().filter(dept -> dept.getDepartmentName().equals(department)).findFirst().ifPresent(dept -> {
            int minAge = (null != min) ? min : -1;
            int maxAge = (null != max) ? max : -1;
            String sex;
            if (gender.contains("男")) {
                sex = "男";
            } else if (gender.contains("女")) {
                sex = "女";
            } else {
                sex = "无";
            }

            String username = principal.getName();
            try {
                historyPatientRepository.save(sex, dept.getRequestDepartmentId(), minAge, maxAge, username);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        });

        List<PatientExam> patientExams = patientExamRepository.all();

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        if (!"".equals(gender)) {
            patientExams = patientExams.stream().filter(exam -> exam.getPatient().getSex().equals(gender)).collect(Collectors.toList());
        }

        if (null != min) {
            patientExams = patientExams.stream().filter(exam -> (currentYear - exam.getPatient().getDateOfBirth().toLocalDate().getYear()) >= min).collect(Collectors.toList());
        }

        if (null != max) {
            patientExams = patientExams.stream().filter(exam -> (currentYear - exam.getPatient().getDateOfBirth().toLocalDate().getYear()) <= max).collect(Collectors.toList());
        }

        if (!"".equals(department)) {
            patientExams = patientExams.stream().filter(exam -> exam.getChecklist().getDepartmentName().equals(department)).collect(Collectors.toList());
        }

        Set<Integer> patientIDs = patientExams.stream().map(exam -> exam.getPatient().getPatientId()).collect(Collectors.toSet());
        List<Patient> patients = patientRepository.all().stream().filter(patient -> patientIDs.contains(patient.getPatientId())).collect(Collectors.toList());
        model.addAttribute("patients", patients);

        return "doctor/statistics/patient";
    }


}
