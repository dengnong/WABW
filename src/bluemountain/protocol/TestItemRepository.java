package bluemountain.protocol;

import bluemountain.pojo.TestItem;

/**
 * Created by MainasuK on 2017-3-10.
 */
public interface TestItemRepository extends ListRepositoryProtocol<TestItem> {
    int size();
}
