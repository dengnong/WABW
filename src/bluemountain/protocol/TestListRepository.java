package bluemountain.protocol;

import bluemountain.pojo.TestList;

import java.util.List;

/**
 * Created by MainasuK on 2017-3-10.
 */
public interface TestListRepository extends ListRepositoryProtocol<TestList> {
    int quantityOfLastWeek();
    int quantityOfLastMonth();
    int quantityOfLastYear();
    List<TestList> testListWithId(int id);
}
