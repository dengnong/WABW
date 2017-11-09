package bluemountain.protocol;

import bluemountain.pojo.User;

import java.util.List;

/**
 * Created by MainasuK on 2017-3-7.
 */
public interface UserRepository {
    List<User> users();
    void save(String username, String password, String role);
    void update(String username, User user);
    void disable(String username);
    void enable(String username);
}
