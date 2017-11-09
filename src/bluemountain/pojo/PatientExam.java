package bluemountain.pojo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by MainasuK on 2017-3-13.
 */
public class PatientExam {
    Patient patient;
    Checklist checklist;

    public PatientExam() {
    }

    public PatientExam(Patient patient, Checklist checklist) {
        this.patient = patient;
        this.checklist = checklist;
    }

    public PatientExam(ResultSet resultSet) throws SQLException {
        this(new Patient(resultSet), new Checklist(resultSet));
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Checklist getChecklist() {
        return checklist;
    }

    public void setChecklist(Checklist checklist) {
        this.checklist = checklist;
    }
}
