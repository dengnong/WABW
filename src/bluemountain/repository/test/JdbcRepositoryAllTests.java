package bluemountain.repository.test;

import bluemountain.config.DBConfig;
import bluemountain.pojo.*;
import bluemountain.protocol.HistoryChecklistRepository;
import bluemountain.protocol.HistoryKeywordRepository;
import bluemountain.repository.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by MainasuK on 2017-3-9.
 */

// MARK: test .all()
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DBConfig.class })
public class JdbcRepositoryAllTests {

    @Autowired
    JdbcTemplate template;

    @Test
    public void testChargeTypeRepositoryAll() {
        List<ChargeType> charges = new JdbcChargeTypeRepository(template).all();
        charges.stream().forEach(charge -> System.out.println(charge.getType()));

        Assert.notNull(charges, "Charges should not null");
    }

    @Test
    public void testCheckItemRepositoryAll() {
        List<CheckItem> checkItems = new JdbcCheckItemRepository(template).all();
        checkItems.stream().forEach(checkItem -> System.out.println(checkItem.getExamclass()));
        checkItems.stream().forEach(checkItem -> System.out.println(checkItem.getPerformedby()));

        Assert.notNull(checkItems, "checkItems should not null");
    }

    @Test
    public void testCheckListRepositoryAll() {
        Assert.notNull(new JdbcCheckListRepository(template).all(), "");
        List<Checklist> checklists = new JdbcCheckListRepository(template).all();
        checklists.stream().forEach(checklist -> System.out.println(checklist.getExamNo()));
    }

    @Test
    public void testDoctorRepositoryAll() {
        Assert.notNull(new JdbcDoctorRepository(template).all(), "");
    }

    @Test
    public void testPatientRepositoryAll() {
        List<Patient> patients = new JdbcPatientRepository(template).all();
        Assert.notNull(patients, "");
        patients.stream().forEach(testItem -> System.out.println(testItem.getPatientId()));
    }

    @Test
    public void testTestItemRepositoryAll() {
        Assert.notNull(new JdbcTestItemRepository(template).all(), "");
        List<TestItem> testItems = new JdbcTestItemRepository(template).all();
        testItems.stream().forEach(testItem -> System.out.println(testItem.getItemCode()));
    }

    @Test
    public void testTestListRepositoryAll() {
        List<TestList> testLists = new JdbcTestListRepository(template).all();
        Assert.notNull(testLists, "");

        testLists.stream().forEach(testList -> System.out.println(testList));
    }

    @Test
    public void testArticleRepositoryAll() {
        List<Article> articles = new JdbcArticleRepository(template).all();
        Assert.notNull(articles,"");
        articles.stream().forEach(article -> System.out.println(article.getArticleID()));

    }

    @Test
    public void testPatientExamRepositoryAll() {
        Assert.notNull(new JdbcPatientExamRepository(template).all(), "");

        System.out.println();
    }

    @Test
    public void testCheckSubclassRepositoryAll() {
        Assert.notNull(new JdbcCheckSubclassRepository(template).all(), "");
    }

    @Test
    public void testTestSubclassRepositoryAll() {
        Assert.notNull(new JdbcTestSubClassRepository(template).all(), "");
    }

    @Test
    public void testDepartmentRepositoryAll() {
        Assert.notNull(new JdbcDepartmentRepository(template).all(), "");
    }

    @Test
    public void testPatientRepositoryPatientWithId() {
        Assert.notNull(new JdbcPatientRepository(template).patientWithId(123141), "");
    }

    @Test
    public void testChecklistRepositorylistsOfPatient() {
        Assert.notNull(new JdbcCheckListRepository(template).listsOfPatient(123141), "");
    }

    @Test
    public void testTestListRepositoryTestListWithId() {
        Assert.notNull(new JdbcTestListRepository(template).testListWithId(123141), "");
    }

    @Test
    public void testHistoryCheckListRepositoryAll() {
        Assert.notNull(new JdbcHistoryChecklistRepository(template).all(), "");
    }

    @Test
    public void testHistoryPatientRepositoryAll() {
        Assert.notNull(new JdbcHistoryPatientRepository(template).all(), "");
    }

    @Test
    public void testHistoryKeywordRepositoryAll() {
        Assert.notNull(new JdbcHistoryKeywordRepository(template).all(), "");
    }

    @Test
    public void testSearchChecklistHistoryAll() {
        HistoryChecklistRepository historyChecklistRepository = new JdbcHistoryChecklistRepository(template);
        HistoryKeywordRepository historyKeywordRepository = new JdbcHistoryKeywordRepository(template);
        List<SearchChecklistHistory> searchChecklistHistories = new JdbcSearchChecklistHistoryRepository(template, historyChecklistRepository, historyKeywordRepository).all();
        Assert.notNull(searchChecklistHistories, "");
        searchChecklistHistories.stream().forEach(history -> {
            System.out.println(history.getHistoryChecklist().getNumber() + ": ");
            history.getHistoryKeywords().forEach(keyword -> System.out.println("    " + keyword.getKeyword()));
        });
    }

    @Test
    public void testPatientRepositoryNewest() {
        Assert.notNull(new JdbcPatientRepository(template).newestPatientsOf(5));
    }

}
