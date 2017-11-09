package bluemountain.pojo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * Created by MainasuK on 2017-4-6.
 */
public class HistoryPatient {

    private int historyHistoryPatientId;
    private String sex;
    private int requestDepartment;
    private int minAge;
    private int maxAge;
    private String historyUsername;
    private Timestamp historyTimestamp;

    public HistoryPatient(ResultSet resultSet) throws SQLException {
        this.historyHistoryPatientId = resultSet.getInt("HISTORY_PATIENT_ID");
        this.sex = resultSet.getString("SEX");
        this.requestDepartment = resultSet.getInt("REQ_DEPT");
        this.minAge = resultSet.getInt("MIN_AGE");
        this.maxAge = resultSet.getInt("MAX_AGE");
        this.historyUsername = resultSet.getString("HISTORY_USERNAME");
        this.historyTimestamp = resultSet.getTimestamp("TIMESTAMP_HISTORY");
    }

    public int getHistoryHistoryPatientId() {
        return historyHistoryPatientId;
    }

    public void setHistoryHistoryPatientId(int historyHistoryPatientId) {
        this.historyHistoryPatientId = historyHistoryPatientId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getRequestDepartment() {
        return requestDepartment;
    }

    public void setRequestDepartment(int requestDepartment) {
        this.requestDepartment = requestDepartment;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public String getHistoryUsername() {
        return historyUsername;
    }

    public void setHistoryUsername(String historyUsername) {
        this.historyUsername = historyUsername;
    }

    public Timestamp getHistoryTimestamp() {
        return historyTimestamp;
    }

    public void setHistoryTimestamp(Timestamp historyTimestamp) {
        this.historyTimestamp = historyTimestamp;
    }
}
