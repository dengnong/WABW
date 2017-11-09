package bluemountain.pojo;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by MainasuK on 2017-3-10.
 */
public class TestList {
    private String testNo;
    private int patientID;
    private int visitID;
    private Date executeDate;
    private String relevantClincDiag;
    private String specimen;
    private Date pecmSampleDateTime;
    private Date requestdDateTime;
    private int orderingDept;
    private String orderProvider;
    private int performedBy;
    private int resultStatus;
    private Date resultRptDateTime;
    private String transcriptionist;
    private String verifiedBy;
    private int billingIndicator;
    private int applyPrintTime;


    public TestList(ResultSet resultSet) throws SQLException{
        this.testNo = resultSet.getString("TEST_NO");
        this.patientID = resultSet.getInt("PATIENT_ID");
        this.visitID = resultSet.getInt("VISIT_ID");
        this.executeDate = resultSet.getDate("EXECUTE_DATE");
        this.relevantClincDiag = resultSet.getString("RELEVANT_CLINIC_DIAG");
        this.specimen = resultSet.getString("SPECIMEN");
        this.pecmSampleDateTime = resultSet.getDate("SPCM_SAMPLE_DATE_TIME");
        this.requestdDateTime = resultSet.getDate("REQUESTED_DATE_TIME");
        this.orderingDept = resultSet.getInt("ORDERING_DEPT");
        this.orderProvider = resultSet.getString("ORDERING_PROVIDER");
        this.performedBy = resultSet.getInt("PERFORMED_BY");
        this.resultStatus = resultSet.getInt("RESULT_STATUS");
        this.resultRptDateTime = resultSet.getDate("RESULTS_RPT_DATE_TIME");
        this.transcriptionist = resultSet.getString("TRANSCRIPTIONIST");
        this.verifiedBy = resultSet.getString("VERIFIED_BY");
        this.billingIndicator = resultSet.getInt("BILLING_INDICATOR");
        this.applyPrintTime = resultSet.getInt("APPLY_PRINT_TIMES");

    }

    public String getTestNo() {
        return testNo;
    }

    public void setTestNo(String testNo) {
        this.testNo = testNo;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public int getVisitID() {
        return visitID;
    }

    public void setVisitID(int visitID) {
        this.visitID = visitID;
    }

    public Date getExecuteDate() {
        return executeDate;
    }

    public void setExecuteDate(Date executeDate) {
        this.executeDate = executeDate;
    }

    public String getRelevantClincDiag() {
        return relevantClincDiag;
    }

    public void setRelevantClincDiag(String relevantClincDiag) {
        this.relevantClincDiag = relevantClincDiag;
    }

    public String getSpecimen() {
        return specimen;
    }

    public void setSpecimen(String specimen) {
        this.specimen = specimen;
    }

    public Date getPecmSampleDateTime() {
        return pecmSampleDateTime;
    }

    public void setPecmSampleDateTime(Date pecmSampleDateTime) {
        this.pecmSampleDateTime = pecmSampleDateTime;
    }

    public Date getRequestdDateTime() {
        return requestdDateTime;
    }

    public void setRequestdDateTime(Date requestdDateTime) {
        this.requestdDateTime = requestdDateTime;
    }

    public int getOrderingDept() {
        return orderingDept;
    }

    public void setOrderingDept(int orderingDept) {
        this.orderingDept = orderingDept;
    }

    public TestList() {
    }

    public String getOrderProvider() {
        return orderProvider;
    }

    public void setOrderProvider(String orderProvider) {
        this.orderProvider = orderProvider;
    }

    public int getPerformedBy() {
        return performedBy;
    }

    public void setPerformedBy(int performedBy) {
        this.performedBy = performedBy;
    }

    public int getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(int resultStatus) {
        this.resultStatus = resultStatus;
    }

    public Date getResultRptDateTime() {
        return resultRptDateTime;
    }

    public void setResultRptDateTime(Date resultRptDateTime) {
        this.resultRptDateTime = resultRptDateTime;
    }

    public String getTranscriptionist() {
        return transcriptionist;
    }

    public void setTranscriptionist(String transcriptionist) {
        this.transcriptionist = transcriptionist;
    }

    public String getVerifiedBy() {
        return verifiedBy;
    }

    public void setVerifiedBy(String verifiedBy) {
        this.verifiedBy = verifiedBy;
    }

    public int getBillingIndicator() {
        return billingIndicator;
    }

    public void setBillingIndicator(int billingIndicator) {
        this.billingIndicator = billingIndicator;
    }

    public int getApplyPrintTime() {
        return applyPrintTime;
    }

    public void setApplyPrintTime(int applyPrintTime) {
        this.applyPrintTime = applyPrintTime;
    }

    @Override
    public String toString() {
        return "\"" +
                testNo + "\",\"" + patientID + "\",\"" + visitID + "\",\"" + executeDate + "\",\"" +
                relevantClincDiag + "\",\"" + specimen + "\",\"" + pecmSampleDateTime + "\",\"" +
                requestdDateTime + "\",\"" + orderingDept + "\",\"" +
                orderProvider + "\",\"" + performedBy + "\",\"" + resultRptDateTime + "\",\"" +
                transcriptionist + "\",\"" + verifiedBy + "\",\"" + billingIndicator + "\",\"" + applyPrintTime +
                "\"";
    }
}
