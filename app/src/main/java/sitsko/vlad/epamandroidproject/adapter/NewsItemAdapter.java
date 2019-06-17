package sitsko.vlad.epamandroidproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import sitsko.vlad.epamandroidproject.DetailPageActivity;
import sitsko.vlad.epamandroidproject.R;
import sitsko.vlad.epamandroidproject.model.ArticleModel;
import sitsko.vlad.epamandroidproject.model.MultimediaModel;

public class NewsItemAdapter extends RecyclerView.Adapter<NewsItemViewHolder> {

    private final LayoutInflater mInflater;
    private ArrayList<ArticleModel> articleModels = new ArrayList<>();

    public NewsItemAdapter(final Context pContext) {
        mInflater = (LayoutInflater) pContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public NewsItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.news_item, viewGroup, false);
        return new NewsItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final NewsItemViewHolder newsItemViewHolder, int i) {
        final ArticleModel articleModel = articleModels.get(i);
        final MultimediaModel[] multimediaArray = articleModel.getMultimedia();

        newsItemViewHolder.titleTexView.setText(articleModel.getTitle());
        newsItemViewHolder.authorTextView.setText(articleModel.getByline());
        newsItemViewHolder.dateTextView.setText(articleModel.getPublished_date());

        if (multimediaArray.length > 0) {
            final MultimediaModel multimediaModel = articleModel.getMultimedia()[1];
            Picasso.get().load(multimediaModel.getUrl())
                    .placeholder(R.drawable.logo_nyt)
                    .error(R.drawable.ic_placeholder_error)
                    .into(newsItemViewHolder.thumbnail);
        } else {
            newsItemViewHolder.thumbnail.setImageResource(R.drawable.logo_nyt);
        }

        newsItemViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailPageActivity.class);
                intent.putExtra("article", articleModel);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articleModels.size();
    }

    public void addItems(final List<ArticleModel> pResult) {
        articleModels.addAll(pResult);
        notifyDataSetChanged();
    }
}
