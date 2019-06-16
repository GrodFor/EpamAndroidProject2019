package sitsko.vlad.epamandroidproject.model;

import com.google.gson.annotations.SerializedName;

public class BasicModel {

    private String section;

    private int num_results;

    @SerializedName("results")
    ArticleModel[] article;

    public String getSection() {
        return section;
    }

    public int getNum_results() {
        return num_results;
    }

    public ArticleModel[] getArticle() {
        return article;
    }
}
