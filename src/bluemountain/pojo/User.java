package bluemountain.pojo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by MainasuK on 2017-3-7.
 */
public class User {

    private String username;
    private String password;
    private Boolean enabled;

    private String role;

    public User() {}

    public User(String username, String password, Boolean enabled, String role) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.role = role;
    }

    public User(ResultSet resultSet) throws SQLException {
        this(
                resultSet.getString("username"),
                resultSet.getString("password"),
                resultSet.getBoolean("enabled"),
                resultSet.getString("role")
        );
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
