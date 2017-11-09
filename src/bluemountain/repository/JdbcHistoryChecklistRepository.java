package bluemountain.repository;

import bluemountain.pojo.HistoryChecklist;
import bluemountain.protocol.HistoryChecklistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MainasuK on 2017-4-6.
 */
@Repository
public class JdbcHistoryChecklistRepository extends JdbcRepository implements HistoryChecklistRepository {

    @Autowired
    public JdbcHistoryChecklistRepository(JdbcOperations jdbcOperations) {
        super(jdbcOperations);
    }

    @Override
    public List<HistoryChecklist> all() {
        return jdbcOperations.query("SELECT * FROM history_checklist", (resultSet, i) -> new HistoryChecklist(resultSet));
    }

}
