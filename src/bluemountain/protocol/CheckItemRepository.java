package bluemountain.protocol;

import bluemountain.pojo.CheckItem;
import org.springframework.stereotype.Repository;

/**
 * Created by MainasuK on 2017-3-10.
 */
public interface CheckItemRepository extends ListRepositoryProtocol<CheckItem> {
    int size();
}

