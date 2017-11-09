package bluemountain.pojo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by MainasuK on 2017-3-10.
 */
public class TestItem {

    private String itemCode;
    private String itemName;



    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public TestItem() {
    }

    public TestItem(ResultSet resultSet)throws SQLException{
        itemCode = resultSet.getString("ITEM_CODE");
        itemName = resultSet.getString("ITEM_NAME");

    }
}
