package bluemountain.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by MainasuK on 2017-4-6.
 */
public class SearchChecklistHistory {

    private HistoryChecklist historyChecklist;
    private List<HistoryKeyword> historyKeywords;

    public SearchChecklistHistory(HistoryChecklist historyChecklist, List<HistoryKeyword> historyKeywords) {
        this.historyChecklist = historyChecklist;
        this.historyKeywords = historyKeywords;
    }

    public HistoryChecklist getHistoryChecklist() {
        return historyChecklist;
    }

    public void setHistoryChecklist(HistoryChecklist historyChecklist) {
        this.historyChecklist = historyChecklist;
    }

    public List<HistoryKeyword> getHistoryKeywords() {
        return historyKeywords;
    }

    public void setHistoryKeywords(List<HistoryKeyword> historyKeywords) {
        this.historyKeywords = historyKeywords;
    }
}
