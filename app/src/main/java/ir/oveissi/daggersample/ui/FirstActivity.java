package ir.oveissi.daggersample.ui;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import ir.oveissi.daggersample.DaggerSampleApplication;
import ir.oveissi.daggersample.R;
import ir.oveissi.daggersample.data.DataCallback;
import ir.oveissi.daggersample.data.DataManager;
import ir.oveissi.daggersample.di.ActivityComponent;
import ir.oveissi.daggersample.pojo.Movie;
import ir.oveissi.daggersample.utils.EndlessLinearLayoutRecyclerview;


public class FirstActivity extends AppCompatActivity {

    @Inject
    DataManager dataManager;

    EndlessLinearLayoutRecyclerview rvMovies;
    SwipeRefreshLayout swipeContainer;
    int current_page=1;
    MovieAdapter mListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActivityComponent dac= DaggerSampleApplication.getComponent().plus();
        dac.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        rvMovies= (EndlessLinearLayoutRecyclerview) findViewById(R.id.rvMovies);
        swipeContainer= (SwipeRefreshLayout) findViewById(R.id.swipeContainer);
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                current_page=1;
                initRecyclerview();
                getMovies(current_page);
            }
        });

        initRecyclerview();
        getMovies(current_page);
    }

    private void initRecyclerview() {

        if(mListAdapter!=null)
        {
            mListAdapter.clear();
        }
        mListAdapter=new MovieAdapter(FirstActivity.this, new ArrayList<Movie>());
        rvMovies.setAdapter(mListAdapter);
        rvMovies.setHasFixedSize(true);
        rvMovies.setLayoutManager(new LinearLayoutManager(this));
        rvMovies.setOnLoadMoreListener(new EndlessLinearLayoutRecyclerview.onLoadMoreListener() {
            @Override
            public void onLoadMore() {
                getMovies(current_page);
            }
        });
    }


    private void getMovies(Integer page)
    {
        dataManager.getMovies(page, new DataCallback() {
            @Override
            public void onSuccess(List<Movie> movies) {
                rvMovies.setLoading(false);
                mListAdapter.addAllItem(movies);
                // fix "Cannot call notifyDataSetChanged in a scroll callback" warning.
                // description: https://stackoverflow.com/a/42944450
                rvMovies.post(new Runnable() {
                    @Override
                    public void run() {
                        mListAdapter.notifyDataSetChanged();

                    }
                });
                current_page++;
                swipeContainer.setRefreshing(false);
            }

            @Override
            public void onFailure(String message) {
                Toast.makeText(FirstActivity.this, message, Toast.LENGTH_SHORT).show();
                swipeContainer.setRefreshing(false);
            }
        });
    }

}
