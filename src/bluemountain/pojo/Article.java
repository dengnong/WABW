package bluemountain.pojo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 54472 on 2017/6/3.
 */
public class Article {
    private int articleID;
    private String title;
    private String body;

    public Article(ResultSet resultSet) throws SQLException {
        articleID = resultSet.getInt("articleID");
        title = resultSet.getString("title");
        body = resultSet.getString("body");
    }

    public int getArticleID() {
        return articleID;
    }

    public void setArticleID(int articleID) {
        this.articleID = articleID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Article() {

    }
}
