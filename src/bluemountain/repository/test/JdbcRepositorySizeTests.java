package bluemountain.repository.test;

import bluemountain.config.DBConfig;
import bluemountain.repository.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

/**
 * Created by MainasuK on 2017-3-24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DBConfig.class })
public class JdbcRepositorySizeTests {

    @Autowired
    JdbcTemplate template;

    @Test
    public void testPatientRepositorySize() {
        int size = new JdbcPatientRepository(template).size();
        System.out.println(size);

        Assert.notNull(size, "");
    }

    @Test
    public void testCheckItemRepositorySize() {
        int size = new JdbcCheckItemRepository(template).size();
        System.out.println(size);

        Assert.notNull(size, "");
    }

    @Test
    public void testTestItemRepositorySize() {
        int size = new JdbcTestItemRepository(template).size();
        System.out.println(size);

        Assert.notNull(size, "");
    }

    @Test
    public void testCheckListQuantityOfLastWeek() {
        int size = new JdbcTestListRepository(template).quantityOfLastWeek();
        System.out.println(size);

        Assert.notNull(size, "");
    }

    @Test
    public void testCheckListQuantityOfLastMonth() {
        int size = new JdbcTestListRepository(template).quantityOfLastMonth();
        System.out.println(size);

        Assert.notNull(size, "");
    }

    @Test
    public void testCheckListQuantityOfLastYear() {
        int size = new JdbcTestListRepository(template).quantityOfLastYear();
        System.out.println(size);

        Assert.notNull(size, "");
    }

    @Test
    public void testTestListQuantityOfLastWeek() {
        int size = new JdbcTestListRepository(template).quantityOfLastWeek();
        System.out.println(size);

        Assert.notNull(size, "");
    }

    @Test
    public void testTestListQuantityOfLastMonth() {
        int size = new JdbcTestListRepository(template).quantityOfLastMonth();
        System.out.println(size);

        Assert.notNull(size, "");
    }

    @Test
    public void testTestListQuantityOfLastYear() {
        int size = new JdbcTestListRepository(template).quantityOfLastYear();
        System.out.println(size);

        Assert.notNull(size, "");
    }

    @Test
    public void testPatientQuantityOfMale() {
        int size = new JdbcPatientRepository(template).quantityOfMale();
        System.out.println(size);

        Assert.notNull(size, "");
    }

    @Test
    public void testPatientQuantityOfFemale() {
        int size = new JdbcPatientRepository(template).quantityOfFemale();
        System.out.println(size);

        Assert.notNull(size, "");
    }

    @Test
    public void testPatientQuantityInRange() {
        int size = new JdbcPatientRepository(template).quantityInRange(30, 50);
        System.out.println(size);

        Assert.notNull(size, "");
    }

}
