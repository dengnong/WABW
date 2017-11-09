package bluemountain.protocol;

import bluemountain.pojo.SearchChecklistHistory;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by MainasuK on 2017-4-6.
 */
public interface SearchChecklistHistoryRepository extends ListRepositoryProtocol<SearchChecklistHistory> {
    void save(Integer performedBy, String username, List<String> conditionsToSave, List<String>keywordsToSave) throws SQLException;
}
