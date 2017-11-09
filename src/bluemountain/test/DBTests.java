package bluemountain.test;



import bluemountain.config.DBConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

import static org.junit.Assert.assertNotNull;

/**
 * Created by MainasuK on 2017-3-5.
 */
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration(classes = {DBConfig.class})
public class DBTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate template;

    @Test
    public void testDataSource() {
        assertNotNull(dataSource);
    }

    @Test
    public void testJdbcTemplate() {
        template.query("SELECT username, password, enabled FROM users WHERE username = 'root'", resultSet -> {
            String username = resultSet.getString("username");
            System.out.println(username);

            assertNotNull(username);
        });
    }

}
