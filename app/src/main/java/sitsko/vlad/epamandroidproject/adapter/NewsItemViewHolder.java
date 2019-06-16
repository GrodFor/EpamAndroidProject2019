package sitsko.vlad.epamandroidproject.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import sitsko.vlad.epamandroidproject.R;

class NewsItemViewHolder extends RecyclerView.ViewHolder {

    final TextView titleTexView;
    final TextView authorTextView;
    final TextView dateTextView;
    final ImageView thumbnail;

    NewsItemViewHolder(View itemView) {
        super(itemView);

        titleTexView = itemView.findViewById(R.id.title_textView);
        authorTextView = itemView.findViewById(R.id.author_textView);
        dateTextView = itemView.findViewById(R.id.published_date);
        thumbnail = itemView.findViewById(R.id.thumbnail);
    }
}
