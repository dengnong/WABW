package bluemountain.repository;

import org.springframework.jdbc.core.JdbcOperations;

/**
 * Created by MainasuK on 2017-3-10.
 */
public class JdbcRepository {
    protected JdbcOperations jdbcOperations;

    public JdbcRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

}
