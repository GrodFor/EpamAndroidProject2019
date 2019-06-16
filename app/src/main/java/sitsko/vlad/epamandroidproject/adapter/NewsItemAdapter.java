package sitsko.vlad.epamandroidproject.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import sitsko.vlad.epamandroidproject.R;
import sitsko.vlad.epamandroidproject.model.ArticleModel;

public class NewsItemAdapter extends RecyclerView.Adapter<NewsItemViewHolder> {

    private final LayoutInflater mInflater;
    private ArrayList<ArticleModel> articleModels;

    public NewsItemAdapter(final Context pContext, ArrayList<ArticleModel> articleModels) {
        mInflater = (LayoutInflater) pContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.articleModels = articleModels;
    }

    @NonNull
    @Override
    public NewsItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.news_item, viewGroup, false);
        return new NewsItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsItemViewHolder newsItemViewHolder, int i) {
        ArticleModel articleModel = articleModels.get(i);
        newsItemViewHolder.titleTexView.setText(articleModel.getTitle());
        newsItemViewHolder.authorTextView.setText(articleModel.getByline());
        newsItemViewHolder.dateTextView.setText(articleModel.getPublished_date());
    }

    @Override
    public int getItemCount() {
        return articleModels.size();
    }
}
