package bluemountain.pojo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by MainasuK on 2017-3-14.
 */
public class CheckSubclass {

    String eaxmSubClass;

    public CheckSubclass(ResultSet resultSet) throws SQLException {
        this.eaxmSubClass = resultSet.getString("EXAM_SUB_CLASS");
    }

}
