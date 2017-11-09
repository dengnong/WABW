package bluemountain.pojo;



import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by MainasuK on 2017-3-10.
 */
public class CheckItem {

    private int performedby;
    private String examclass;

    public CheckItem(ResultSet resultSet) throws SQLException{
        performedby = resultSet.getInt("PERFORMED_BY");
        examclass = resultSet.getString("EXAM_CLASS");

    }

    public int getPerformedby() {
        return performedby;
    }

    public void setPerformedby(int performedby) {
        this.performedby = performedby;
    }

    public String getExamclass() {
        return examclass;
    }

    public void setExamclass(String examclass) {
        this.examclass = examclass;
    }
}
