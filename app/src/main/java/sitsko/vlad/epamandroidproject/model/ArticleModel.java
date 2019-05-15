package sitsko.vlad.epamandroidproject.model;

import com.google.gson.annotations.SerializedName;

public class ArticleModel {

    @SerializedName("section")
    private String section;

    @SerializedName("title")
    private String title;

    @SerializedName("abstract")
    private String paragraph;

    @SerializedName("short_url")
    private String short_url;

    //2019-05-09T06:00:04-04:00
    @SerializedName("published_date")
    private String published_date;

    @SerializedName("byline")
    private String byline;

    @SerializedName("multimedia")
    private MultimediaModel[] multimedia;

    public String getSection() {
        return section;
    }

    public String getTitle() {
        return title;
    }

    public String getParagraph() {
        return paragraph;
    }

    public String getShort_url() {
        return short_url;
    }

    public String getPublished_date() {
        return published_date;
    }

    public String getByline() {
        return byline;
    }

    public MultimediaModel[] getMultimedia() {
        return multimedia;
    }
}
