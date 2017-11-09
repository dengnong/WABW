package bluemountain.protocol;

import bluemountain.pojo.HistoryPatient;

import java.sql.SQLException;

/**
 * Created by MainasuK on 2017-4-6.
 */
public interface HistoryPatientRepository extends ListRepositoryProtocol<HistoryPatient> {
    void save(String sex, int requestDepartment, int minAge, int maxAge, String username) throws SQLException;
}
