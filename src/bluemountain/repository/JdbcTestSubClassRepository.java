package bluemountain.repository;

import bluemountain.pojo.TestSubclass;
import bluemountain.protocol.TestSubClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;

import java.util.List;

/**
 * Created by MainasuK on 2017-3-14.
 */
public class JdbcTestSubClassRepository extends JdbcRepository implements TestSubClassRepository {

    @Autowired
    public JdbcTestSubClassRepository(JdbcOperations jdbcOperations) {
        super(jdbcOperations);
    }

    @Override
    public List<TestSubclass> all() {
        return jdbcOperations.query("SELECT SPECIMEN FROM test_subclass", (resultSet, i) -> new TestSubclass(resultSet));
    }

}
