package bluemountain.repository;

import bluemountain.pojo.TestItem;
import bluemountain.protocol.TestItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MainasuK on 2017-3-10.
 */
@Repository
public class JdbcTestItemRepository extends JdbcRepository implements TestItemRepository {

    @Autowired
    public JdbcTestItemRepository(JdbcOperations jdbcOperations) {
        super(jdbcOperations);
    }

    @Override
    public List<TestItem> all() {
        return jdbcOperations.query("SELECT ITEM_CODE, ITEM_NAME FROM test_items", (resultSet, i) -> new TestItem(resultSet));
    }

    @Override
    public int size() {
        return jdbcOperations.queryForObject("SELECT COUNT(*) SIZE FROM test_items", Integer.class);
    }

}
