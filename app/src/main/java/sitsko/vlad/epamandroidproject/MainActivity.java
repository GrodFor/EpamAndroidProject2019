package sitsko.vlad.epamandroidproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import sitsko.vlad.epamandroidproject.adapter.NewsItemAdapter;
import sitsko.vlad.epamandroidproject.model.ArticleModel;

public class MainActivity extends AppCompatActivity {

    private ArrayList<ArticleModel> articleModels = new ArrayList<>();
    private NewsItemAdapter newsItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.news_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        newsItemAdapter = new NewsItemAdapter(this, articleModels);
        recyclerView.setAdapter(newsItemAdapter);

        filling();
    }

    private void filling() {
        for (int i = 0; i < 10; i++) {
            ArticleModel articleModel = new ArticleModel();
            articleModel.setTitle("Title " + i);
            articleModel.setByline("Author " + i);
            articleModel.setPublished_date("Date " + i);
            articleModels.add(articleModel);
        }

        newsItemAdapter.notifyDataSetChanged();
    }
}
