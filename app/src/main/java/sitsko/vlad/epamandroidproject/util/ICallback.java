package sitsko.vlad.epamandroidproject.util;

public interface ICallback<T> {

    void onResult(final T pResult);

    void onError(Throwable throwable);
}
