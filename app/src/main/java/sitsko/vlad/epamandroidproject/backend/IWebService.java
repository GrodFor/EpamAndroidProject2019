package sitsko.vlad.epamandroidproject.backend;

import java.util.List;

import sitsko.vlad.epamandroidproject.util.ICallback;

public interface IWebService<T> {

    void loadNewsItems(final String theme, final ICallback<List<T>> callback);

    void addEntity(final T newsItem);
}
