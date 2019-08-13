package sitsko.vlad.epamandroidproject.backend;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import sitsko.vlad.epamandroidproject.model.ArticleModel;
import sitsko.vlad.epamandroidproject.model.BasicModel;
import sitsko.vlad.epamandroidproject.util.ICallback;

public class NewsItemWebService implements IWebService<ArticleModel> {

    private OkHttpClient httpClient = new OkHttpClient();
    private List<ArticleModel> newsItemList = new ArrayList<>();
    private final Executor executor = Executors.newSingleThreadExecutor();

    private static String api_url = "https://api.nytimes.com/svc/topstories/v2/";
    private static String api_token = ".json?api-key=uTWBBP1aiebbTQH2NpQRfYzYBwX4PDJI";

    @Override
    public void loadNewsItems(final String theme, final ICallback<List<ArticleModel>> newsItemList) {
        executor.execute(() -> {
            final Request request = new Request.Builder()
                    .url(api_url + theme + api_token).build();

            try {
                newsItemList.onResult(parseGson(httpClient.newCall(request).execute()));
            } catch (IOException e) {
                newsItemList.onResult(Collections.<ArticleModel>emptyList());
            }
        });
    }

    @Override
    public void addEntity(ArticleModel newsItem) {
        newsItemList.add(newsItem);
    }

    private List<ArticleModel> parseGson(final Response response) throws IOException {

        Gson gson = new Gson();
        ResponseBody responseBody = response.body();

        if (responseBody != null) {
            final BasicModel entity = gson.fromJson(responseBody.string(), BasicModel.class);
            newsItemList = Arrays.asList(entity.getArticle());
        } else {
            newsItemList = Collections.emptyList();
        }

        return newsItemList;
    }
}
