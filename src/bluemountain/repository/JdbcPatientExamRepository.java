package bluemountain.repository;

import bluemountain.pojo.PatientExam;
import bluemountain.protocol.PatientExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MainasuK on 2017-3-13.
 */

@Repository
public class JdbcPatientExamRepository extends JdbcRepository implements PatientExamRepository {

    private static String patientExamSQL = "SELECT pi.*,\n" +
            "(SELECT COUNT(*) FROM check_list cl WHERE pi.PATIENT_ID = cl.PATIENT_ID) AS CHECK_COUNT,\n" +
            "(SELECT COUNT(*) FROM test_list tl WHERE pi.PATIENT_ID = tl.PATIENT_ID) AS TEST_COUNT\n" +
            "FROM patient_exam_view pi";

    @Autowired
    public JdbcPatientExamRepository(JdbcOperations jdbcOperations) {
        super(jdbcOperations);
    }

    @Override
    public List<PatientExam> all() {
        return jdbcOperations.query(patientExamSQL, (resultSet, i) -> new PatientExam(resultSet));
    }

}
