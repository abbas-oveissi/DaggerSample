package ir.oveissi.daggersample.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ir.oveissi.daggersample.R;
import ir.oveissi.daggersample.pojo.Movie;


public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private Context mContext;
    private List<Movie> itemsData;

    public MovieAdapter(Context mContext, List<Movie> itemsData) {
        this.mContext = mContext;
        this.itemsData = itemsData;
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
    ItemClickListener itemClickListener;
    public interface ItemClickListener {
        void ItemClicked(int position, Movie item);
    }

    public void clear()
    {
        int size = this.itemsData.size();
        this.itemsData.clear();
        notifyItemRangeRemoved(0, size);
    }
    public void addItem(Movie post)
    {
        this.itemsData.add(post);
        notifyItemInserted(this.itemsData.size()-1);
    }

    public void addAllItem(List<Movie> movies)
    {
        this.itemsData.addAll(movies);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_movie,  parent, false);
        ViewHolder viewHolder = new ViewHolder(itemLayoutView,mContext,this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Movie tempItem=itemsData.get(position);
        viewHolder.bind(tempItem);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public Movie item;
        public Context mcontext;
        public TextView tvMovieTitle;
        private final MovieAdapter movieAdapter;
        public ImageView imPoster;
        public ViewHolder(View itemLayoutView,Context context,MovieAdapter movieSearchAdapter) {
            super(itemLayoutView);
            this.mcontext = context;
            tvMovieTitle = (TextView) itemLayoutView.findViewById(R.id.tvMovieTitle);
            this.movieAdapter = movieSearchAdapter;
            imPoster = (ImageView) itemLayoutView.findViewById(R.id.imPoster);
            itemLayoutView.setOnClickListener(this);

        }

        void bind(Movie item)
        {
            tvMovieTitle.setText(item.title);
            Picasso.with(mcontext)
                    .load(item.poster)
                    .into(imPoster);
        }


        @Override
        public void onClick(View v) {
            if(movieAdapter.itemClickListener!=null)
            {
                movieAdapter.itemClickListener.ItemClicked(getAdapterPosition(),
                        movieAdapter.itemsData.get(getAdapterPosition()));
            }

        }
    }

    @Override
    public int getItemCount() {
        return itemsData.size();
    }
}