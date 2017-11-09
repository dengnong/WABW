package bluemountain.protocol;

import bluemountain.pojo.Checklist;
import bluemountain.pojo.Patient;

import java.util.List;

/**
 * Created by MainasuK on 2017-3-10.
 */
public interface CheckListRepository extends ListRepositoryProtocol<Checklist> {
    int quantityOfLastWeek();
    int quantityOfLastMonth();
    int qunaityOfLastYear();
    List<Checklist> listsOfPatient(int patientID);
}
