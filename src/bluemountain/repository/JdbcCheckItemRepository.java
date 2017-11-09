package bluemountain.repository;

import bluemountain.pojo.CheckItem;
import bluemountain.protocol.CheckItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.util.List;

/**
 * Created by MainasuK on 2017-3-10.
 */
@Repository
public class JdbcCheckItemRepository extends JdbcRepository implements CheckItemRepository {

    @Autowired
    public JdbcCheckItemRepository(JdbcOperations jdbcOperations) {
        super(jdbcOperations);
    }

    @Override
    public List<CheckItem> all() {
        return jdbcOperations.query("SELECT PERFORMED_BY, EXAM_CLASS FROM check_items", (resultSet, i) -> new CheckItem(resultSet));
    }

    @Override
    public int size() {
        return jdbcOperations.queryForObject("SELECT COUNT(*) SIZE FROM check_items", Integer.class);
    }

}
