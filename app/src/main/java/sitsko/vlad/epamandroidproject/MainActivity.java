package sitsko.vlad.epamandroidproject;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import sitsko.vlad.epamandroidproject.adapter.NewsItemAdapter;
import sitsko.vlad.epamandroidproject.backend.IWebService;
import sitsko.vlad.epamandroidproject.backend.NewsItemWebService;
import sitsko.vlad.epamandroidproject.model.ArticleModel;
import sitsko.vlad.epamandroidproject.util.ICallback;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private final String TAG = MainActivity.class.getSimpleName();
    private final String DEFAULT_THEME = "home";

    private NewsItemAdapter newsItemAdapter;
    private final IWebService<ArticleModel> webService = new NewsItemWebService();
    private ProgressBar progressBar;
    private String theme;

    //TODO onSaveState
    //TODO checkInternet

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        /////////////////////////////////////////
        final RecyclerView recyclerView = findViewById(R.id.news_recyclerView);
        progressBar = findViewById(R.id.progressBar);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        newsItemAdapter = new NewsItemAdapter(this);
        recyclerView.setAdapter(newsItemAdapter);

        showProgress();
        theme = DEFAULT_THEME;
        getApiResponse(theme);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        theme = item.getTitle().toString().toLowerCase();
        Toast.makeText(this, theme, Toast.LENGTH_SHORT).show();

        getApiResponse(theme);
//        int id = item.getItemId();
//        if (id == R.id.nav_arts) {
//
//        } else if (id == R.id.nav_automobiles) {
//            theme = item.getTitle().toString().toLowerCase();
//            Toast.makeText(this, theme, Toast.LENGTH_SHORT).show();
//        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void getApiResponse(String theme) {

        webService.loadNewsItems(theme, new ICallback<List<ArticleModel>>() {
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
