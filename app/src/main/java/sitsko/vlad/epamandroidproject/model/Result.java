package sitsko.vlad.epamandroidproject.model;

import com.google.gson.JsonArray;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("results")
    private ArticleModel[] articles;

    Result(JsonArray json) throws JsonParseException {
        articles = new ArticleModel[json.size()];
        for (int i = 0; i < json.size(); i++) {
            //articles[i] = json.get(i);
        }
    }

    public ArticleModel[] getArticles() {
        return articles;
    }
}
