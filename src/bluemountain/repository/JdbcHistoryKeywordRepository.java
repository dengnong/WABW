package bluemountain.repository;

import bluemountain.pojo.HistoryKeyword;
import bluemountain.protocol.HistoryKeywordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MainasuK on 2017-4-6.
 */
@Repository
public class JdbcHistoryKeywordRepository extends JdbcRepository implements HistoryKeywordRepository{

    @Autowired
    public JdbcHistoryKeywordRepository(JdbcOperations jdbcOperations) {
        super(jdbcOperations);
    }

    @Override
    public List<HistoryKeyword> all() {
        return jdbcOperations.query("SELECT * FROM  history_keyword", (resultSet, i) -> new HistoryKeyword(resultSet));
    }
}
