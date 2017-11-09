package bluemountain.repository;

import bluemountain.pojo.Article;
import bluemountain.protocol.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 54472 on 2017/6/3.
 */
@Repository
public class JdbcArticleRepository extends JdbcRepository implements ArticleRepository {

    @Autowired
    public JdbcArticleRepository(JdbcOperations jdbcOperations) {
        super(jdbcOperations);
    }

    @Override
    public List<Article> all() {
        return jdbcOperations.query("SELECT * FROM article", (resultSet, i) -> new Article(resultSet));
    }

}
