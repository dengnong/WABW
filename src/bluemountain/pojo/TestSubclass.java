package bluemountain.pojo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by MainasuK on 2017-3-14.
 */
public class TestSubclass {

    String specimen;

    public TestSubclass(ResultSet resultSet) throws SQLException {
        this.specimen = resultSet.getString("SPECIMEN");
    }
}
