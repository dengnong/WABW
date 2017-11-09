package bluemountain.repository;

import bluemountain.pojo.HistoryChecklist;
import bluemountain.pojo.HistoryKeyword;
import bluemountain.pojo.SearchChecklistHistory;
import bluemountain.protocol.HistoryChecklistRepository;
import bluemountain.protocol.HistoryKeywordRepository;
import bluemountain.protocol.SearchChecklistHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by MainasuK on 2017-4-6.
 */
@Repository
public class JdbcSearchChecklistHistoryRepository extends JdbcRepository implements SearchChecklistHistoryRepository {

    private HistoryChecklistRepository historyChecklistRepository;
    private HistoryKeywordRepository historyKeywordRepository;


    @Autowired
    public JdbcSearchChecklistHistoryRepository(JdbcOperations jdbcOperations, HistoryChecklistRepository historyChecklistRepository, HistoryKeywordRepository historyKeywordRepository) {
        super(jdbcOperations);

        this.historyChecklistRepository = historyChecklistRepository;
        this.historyKeywordRepository = historyKeywordRepository;
    }

    @Override
    @Transactional
    public List<SearchChecklistHistory> all() {
        List<SearchChecklistHistory> list = new LinkedList<>();

        List<HistoryChecklist> historyChecklists = historyChecklistRepository.all();
        List<HistoryKeyword> historyKeywords = historyKeywordRepository.all();

        for (HistoryChecklist historyChecklist : historyChecklists) {
            List<HistoryKeyword> keywords =  historyKeywords.stream().filter(keyword -> keyword.getNumber() == historyChecklist.getNumber()).collect(Collectors.toList());
            list.add(new SearchChecklistHistory(historyChecklist, keywords));
        }

        return list;
    }

    @Override
    @Transactional
    public void save(Integer performedBy, String username, List<String> conditionsToSave, List<String>keywordsToSave) throws SQLException {

        // Insert history_checklist record
        KeyHolder holder = new GeneratedKeyHolder();

        // Create preparedStatementCreator via lambda
        PreparedStatementCreator insertSalesRecordStatementCreator = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO history_checklist (PERFORMED_BY, HISTORY_USERNAME) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1, performedBy);
            preparedStatement.setString(2, username);

            return preparedStatement;
        };

        jdbcOperations.update(insertSalesRecordStatementCreator, holder);

        int number = holder.getKey().intValue();

        BatchPreparedStatementSetter setter = new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                Integer condition = HistoryKeyword.getConditionIndexOf(conditionsToSave.get(i));
                String keyword = keywordsToSave.get(i);
                preparedStatement.setInt(1, number);
                preparedStatement.setString(2, keyword);
                preparedStatement.setInt(3, condition);
            }

            @Override
            public int getBatchSize() {
                return conditionsToSave.size();
            }
        };

        jdbcOperations.batchUpdate("INSERT INTO history_keyword (`NUMBER`, `KEYWORD`, `CONDITION`) VALUES (?, ?, ?)", setter);
    }

}
