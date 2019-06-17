package sitsko.vlad.epamandroidproject.model;

import java.io.Serializable;

public class MultimediaModel implements Serializable {

    private String url;

    private String format;

    private String height;

    private String width;

    //private String caption;

    public String getUrl() {
        return url;
    }

    public String getFormat() {
        return format;
    }

    public String getHeight() {
        return height;
    }

    public String getWidth() {
        return width;
    }
}
