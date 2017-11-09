package bluemountain.repository;

import bluemountain.pojo.Doctor;
import bluemountain.protocol.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MainasuK on 2017-3-10.
 */
@Repository
public class JdbcDoctorRepository extends JdbcRepository implements DoctorRepository {

    @Autowired
    public JdbcDoctorRepository(JdbcOperations jdbcOperations) {
        super(jdbcOperations);
    }

    @Override
    public List<Doctor> all() {
        return jdbcOperations.query("SELECT DOC_NAME FROM docs", (resultSet, i) -> new Doctor(resultSet));
    }
}
