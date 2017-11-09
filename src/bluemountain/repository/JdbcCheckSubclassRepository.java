package bluemountain.repository;

import bluemountain.pojo.CheckSubclass;
import bluemountain.protocol.CheckSubclassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;

import java.util.List;

/**
 * Created by MainasuK on 2017-3-14.
 */
public class JdbcCheckSubclassRepository extends JdbcRepository implements CheckSubclassRepository {

    @Autowired
    public JdbcCheckSubclassRepository(JdbcOperations jdbcOperations) {
        super(jdbcOperations);
    }

    @Override
    public List<CheckSubclass> all() {
        return jdbcOperations.query("SELECT EXAM_SUB_CLASS FROM check_subclass", (resultSet, i) -> new CheckSubclass(resultSet));
    }

}
