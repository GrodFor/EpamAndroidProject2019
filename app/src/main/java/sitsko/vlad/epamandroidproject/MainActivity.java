package sitsko.vlad.epamandroidproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import java.util.List;

import sitsko.vlad.epamandroidproject.adapter.NewsItemAdapter;
import sitsko.vlad.epamandroidproject.backend.IWebService;
import sitsko.vlad.epamandroidproject.backend.NewsItemWebService;
import sitsko.vlad.epamandroidproject.model.ArticleModel;
import sitsko.vlad.epamandroidproject.util.ICallback;

public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();

    private NewsItemAdapter newsItemAdapter;
    private final IWebService<ArticleModel> webService = new NewsItemWebService();
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = findViewById(R.id.news_recyclerView);
        progressBar = findViewById(R.id.progressBar);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        newsItemAdapter = new NewsItemAdapter(this);
        recyclerView.setAdapter(newsItemAdapter);

        showProgress();
        getApiResponse();
    }

    private void getApiResponse() {

        webService.loadNewsItems(new ICallback<List<ArticleModel>>() {
            @Override
            public void onResult(final List<ArticleModel> pResult) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d(TAG, "onResult: " + pResult.size());
                        newsItemAdapter.addItems(pResult);
                        hideProgress();
                    }
                });

            }

            @Override
            public void onError(Throwable throwable) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d(TAG, "run: onError");
                        hideProgress();
                    }
                });
            }
        });
    }

    private void hideProgress() {
        if (progressBar.getVisibility() != View.GONE) {
            progressBar.setVisibility(View.GONE);
        }
    }

    private void showProgress() {
        if (progressBar.getVisibility() != View.VISIBLE) {
            progressBar.setVisibility(View.VISIBLE);
        }
    }
}
