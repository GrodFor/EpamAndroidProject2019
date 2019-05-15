package sitsko.vlad.epamandroidproject.model;

import com.google.gson.annotations.SerializedName;

public class BasicModel {

    private String section;

    private int num_results;

    @SerializedName("results")
    ArticleModel article;
}
