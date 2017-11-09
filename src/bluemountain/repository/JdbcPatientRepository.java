package bluemountain.repository;

import bluemountain.pojo.Patient;
import bluemountain.protocol.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by MainasuK on 2017-3-10.
 */
@Repository
public class JdbcPatientRepository extends JdbcRepository implements PatientRepository {
    private static String patientSQL = "SELECT pi.*,\n" +
            "(SELECT COUNT(*) FROM check_list cl WHERE pi.PATIENT_ID = cl.PATIENT_ID) AS CHECK_COUNT,\n" +
            "(SELECT COUNT(*) FROM test_list tl WHERE pi.PATIENT_ID = tl.PATIENT_ID) AS TEST_COUNT\n" +
            "FROM patient_info pi";
    private static String patientSizeSQL = "SELECT COUNT(*) SIZE FROM patient_info";
    private static String patientSizeOfMaleSQL = "SELECT COUNT(*) FROM patient_info pi where pi.SEX = '男'";
    private static String patientSizeOfFemaleSQL = "SELECT COUNT(*) FROM patient_info pi where pi.SEX = '女'";
    private static String patientSizeInRangeSQL = "SELECT COUNT(*) FROM\n" +
            "(SELECT TIMESTAMPDIFF(YEAR, DATE_OF_BIRTH, CURDATE()) AS age FROM patient_info) age_table\n" +
            "WHERE age_table.age >= ? AND age_table.age < ?";

    private static String patientWithIdSQL = "SELECT pi.*,\n" +
            "(SELECT COUNT(*) FROM check_list cl WHERE pi.PATIENT_ID = cl.PATIENT_ID) AS CHECK_COUNT,\n" +
            "(SELECT COUNT(*) FROM test_list tl WHERE pi.PATIENT_ID = tl.PATIENT_ID) AS TEST_COUNT\n" +
            "FROM patient_info pi\n" +
            "WHERE pi.PATIENT_ID = ?";
    private static String patientNewestSQL = "SELECT pev.*,\n" +
            "(SELECT COUNT(*) FROM check_list cl WHERE pev.PATIENT_ID = cl.PATIENT_ID) AS CHECK_COUNT,\n" +
            "(SELECT COUNT(*) FROM test_list tl WHERE pev.PATIENT_ID = tl.PATIENT_ID) AS TEST_COUNT\n" +
            "FROM patient_exam_view pev\n" +
            "ORDER BY REQ_DATE_TIME DESC LIMIT ?";

    @Autowired
    public JdbcPatientRepository(JdbcOperations jdbcOperations) {
        super(jdbcOperations);
    }

    @Override
    public List<Patient> all() {
        return jdbcOperations.query(patientSQL, (resultSet, i) -> new Patient(resultSet));
    }


    @Override
    public int size() {
        return jdbcOperations.queryForObject(patientSizeSQL, Integer.class);
    }

    @Override
    public int quantityOfMale() {
        return jdbcOperations.queryForObject(patientSizeOfMaleSQL, Integer.class);
    }

    @Override
    public int quantityOfFemale() {
        return jdbcOperations.queryForObject(patientSizeOfFemaleSQL, Integer.class);
    }

    @Override
    public int quantityInRange(int min, int max) {
        // patient's age in [min, max)
        return jdbcOperations.queryForObject(patientSizeInRangeSQL, new Object[] {min, max}, Integer.class);
    }

    @Override
    public Patient patientWithId(int id) {
        List<Patient> patients = jdbcOperations.query(patientWithIdSQL, (resultSet, i) -> new Patient(resultSet), id);
        Optional<Patient> optional = patients.stream().findFirst();
        if (optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }

    @Override
    public List<Patient> newestPatientsOf(int num) {
        return jdbcOperations.query(patientNewestSQL, (resultSet, i) -> new Patient(resultSet), num);
    }

}
