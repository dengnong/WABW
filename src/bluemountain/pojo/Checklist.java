package bluemountain.pojo;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by MainasuK on 2017-3-10.
 */
public class Checklist {

    private int examNo;
    private int patientId;
    private int visitId;
    private String examsubClass;
    private String clinicSymptom;
    private String physicSign;
    private String relevantDiag;
    private String clinicDiag;
    private CheckItem checkItem;
    private int patientsource;
    private Date requestDateTime;
    private int requestDept;
    private Date scheduledDateTime;
    private String notice;
    private int resultStatus;
    private int chargeIndicator;
    private String chargeType;
    private Date realReportDateTime;
    private String departmentName;
    private int performedby;

    public Checklist(ResultSet resultSet) throws SQLException {
        examNo = resultSet.getInt("EXAM_NO");
        patientId = resultSet.getInt("PATIENT_ID");
        visitId = resultSet.getInt("VISIT_ID");
        examsubClass = resultSet.getString("EXAM_SUB_CLASS");
        clinicSymptom = resultSet.getString("CLIN_SYMP");
        physicSign = resultSet.getString("PHYS_SIGN");
        relevantDiag = resultSet.getString("RELEVANT_DIAG");
        clinicDiag = resultSet.getString("CLIN_DIAG");
        checkItem = new CheckItem(resultSet);
        patientsource = resultSet.getInt("PATIENT_SOURCE");
        requestDateTime = resultSet.getDate("REQ_DATE_TIME");
        requestDept = resultSet.getInt("REQ_DEPT");
        scheduledDateTime = resultSet.getDate("SCHEDULED_DATE_TIME");
        notice = resultSet.getString("NOTICE");
        resultStatus = resultSet.getInt("RESULT_STATUS");
        chargeIndicator = resultSet.getInt("CHARGE_INDICATOR");
        chargeType = resultSet.getString("CHARGE_TYPE");
        realReportDateTime = resultSet.getDate("REAL_REPORT_DATE_TIME");
        departmentName = resultSet.getString("DEPT_NAME");
        performedby = resultSet.getInt("PERFORMED_BY");

    }

    public int getExamNo() {
        return examNo;
    }

    public void setExamNo(int examNo) {
        this.examNo = examNo;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getVisitId() {
        return visitId;
    }

    public void setVisitId(int visitId) {
        this.visitId = visitId;
    }

    public String getExamsubClass() {
        return examsubClass;
    }

    public void setExamsubClass(String examsubClass) {
        this.examsubClass = examsubClass;
    }

    public String getClinicSymptom() {
        return clinicSymptom;
    }

    public void setClinicSymptom(String clinicSymptom) {
        this.clinicSymptom = clinicSymptom;
    }

    public String getPhysicSign() {
        return physicSign;
    }

    public void setPhysicSign(String physicSign) {
        this.physicSign = physicSign;
    }

    public String getRelevantDiag() {
        return relevantDiag;
    }

    public void setRelevantDiag(String relevantDiag) {
        this.relevantDiag = relevantDiag;
    }

    public CheckItem getCheckItem() {
        return checkItem;
    }

    public void setCheckItem(CheckItem checkItem) {
        this.checkItem = checkItem;
    }

    public int getPatientsource() {
        return patientsource;
    }

    public void setPatientsource(int patientsource) {
        this.patientsource = patientsource;
    }

    public Date getRequestDateTime() {
        return requestDateTime;
    }

    public void setRequestDateTime(Date requestDateTime) {
        this.requestDateTime = requestDateTime;
    }

    public int getRequestDept() {
        return requestDept;
    }

    public void setRequestDept(int requestDept) {
        this.requestDept = requestDept;
    }

    public Date getScheduledDateTime() {
        return scheduledDateTime;
    }

    public void setScheduledDateTime(Date scheduledDateTime) {
        this.scheduledDateTime = scheduledDateTime;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public int getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(int resultStatus) {
        this.resultStatus = resultStatus;
    }

    public int getChargeIndicator() {
        return chargeIndicator;
    }

    public void setChargeIndicator(int chargeIndicator) {
        this.chargeIndicator = chargeIndicator;
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }

    public Date getRealReportDateTime() {
        return realReportDateTime;
    }

    public void setRealReportDateTime(Date realReportDateTime) {
        this.realReportDateTime = realReportDateTime;
    }

    public String getClinicDiag() {
        return clinicDiag;
    }

    public void setClinicDiag(String clinicDiag) {
        this.clinicDiag = clinicDiag;
    }

    public Checklist() {
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getPerformedby() {
        return performedby;
    }

    public void setPerformedby(int performedby) {
        this.performedby = performedby;
    }
}
