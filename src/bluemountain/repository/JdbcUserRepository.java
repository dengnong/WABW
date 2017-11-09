package bluemountain.repository;

import bluemountain.pojo.User;
import bluemountain.protocol.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by MainasuK on 2017-3-7.
 */
@Repository
@EnableTransactionManagement
public class JdbcUserRepository extends JdbcRepository implements UserRepository {


    @Autowired
    public JdbcUserRepository(JdbcOperations jdbcOperations) {
        super(jdbcOperations);
    }

    @Override
    public List<User> users() {
        return jdbcOperations.query("SELECT * FROM users_view", (resultSet, i) -> new User(resultSet));
    }

    @Override
    @Transactional
    public void save(String username, String password, String role) {
        jdbcOperations.update("INSERT INTO users (username, password) VALUES (?, ?)", username, password);
        jdbcOperations.update("INSERT INTO user_roles (username, role) VALUES (?, ?)", username, role);
    }

    @Override
    @Transactional
    public void update(String username, User user) {
        jdbcOperations.update("UPDATE users u SET u.password = ? where u.username = ?",
                user.getPassword(), username);
        jdbcOperations.update("UPDATE user_roles ur SET ur.role = ? where ur.username = ?", user.getRole(), username);
    }

    @Override
    public void disable(String username) {
        jdbcOperations.update("UPDATE users u SET u.enabled = ? WHERE u.username = ?", false, username);
    }

    @Override
    public void enable(String username) {
        jdbcOperations.update("UPDATE users u SET u.enabled = ? WHERE u.username = ?", true, username);
    }
}
