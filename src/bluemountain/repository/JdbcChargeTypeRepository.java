package bluemountain.repository;

import bluemountain.pojo.ChargeType;
import bluemountain.protocol.ChargeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MainasuK on 2017-3-9.
 */
@Repository
public class JdbcChargeTypeRepository extends JdbcRepository implements ChargeTypeRepository {

    @Autowired
    public JdbcChargeTypeRepository(JdbcOperations jdbcOperations) {
        super(jdbcOperations);
    }

    @Override
    public List<ChargeType> all() {
        return jdbcOperations.query("SELECT CHARGE_TYPE FROM charge_type", (resultSet, i) -> new ChargeType(resultSet));
    }

}

