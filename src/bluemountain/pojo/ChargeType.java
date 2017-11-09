package bluemountain.pojo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by MainasuK on 2017-3-9.
 */
public class ChargeType {

    private String type;

    public ChargeType(ResultSet resultSet) throws SQLException {
        type = resultSet.getString("CHARGE_TYPE");
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
