package bluemountain.repository;

import bluemountain.pojo.TestList;
import bluemountain.protocol.TestListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by MainasuK on 2017-3-10.
 */
@Repository
public class JdbcTestListRepository extends JdbcRepository implements TestListRepository {

    private static String quantityOfLastWeekSQL = "SELECT count(*) FROM test_list \n" +
            "WHERE date_sub(curdate(), INTERVAL 7 DAY) <= RESULTS_RPT_DATE_TIME";
    private static String quantityOfLastMonthSQL = "SELECT count(*) FROM test_list \n" +
            "WHERE date_sub(curdate(), INTERVAL 30 DAY) <= RESULTS_RPT_DATE_TIME";
    private static String quantityOfLastYearSQL = "SELECT count(*) FROM test_list \n" +
            "WHERE date_sub(curdate(), INTERVAL 365 DAY) <= RESULTS_RPT_DATE_TIME";

    @Autowired
    public JdbcTestListRepository(JdbcOperations jdbcOperations) {
        super(jdbcOperations);
    }

    @Override
    public List<TestList> all() {
        return jdbcOperations.query("SELECT * FROM test_list", (resultSet, i) -> new TestList(resultSet));
    }

    @Override
    public int quantityOfLastWeek() {
        return jdbcOperations.queryForObject(quantityOfLastWeekSQL, Integer.class);
    }

    @Override
    public int quantityOfLastMonth() {
        return jdbcOperations.queryForObject(quantityOfLastMonthSQL, Integer.class);
    }

    @Override
    public int quantityOfLastYear() {
        return jdbcOperations.queryForObject(quantityOfLastYearSQL, Integer.class);
    }

    @Override
    public List<TestList> testListWithId(int id) {
        return jdbcOperations.query("SELECT * FROM test_list  WHERE test_list.PATIENT_ID = ?", (resultSet, i) -> new TestList(resultSet), id);
    }

}
