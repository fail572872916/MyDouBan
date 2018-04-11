package weili.example.com.mydouban.movies;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import weili.example.com.mydouban.R;
import weili.example.com.mydouban.api.DoubanManger;
import weili.example.com.mydouban.api.IDoubanService;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment {

    private  static  final  String TAG = MoviesFragment.class.getSimpleName();
    private List<Movie> mMovieList = new ArrayList<>();

    public MoviesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("MoviesFragment", "onAttach:"+context.getClass().getSimpleName());
        loadMovie(new Callback<HotMoviesInfo>() {
            @Override
            public void onResponse(Call<HotMoviesInfo> call, Response<HotMoviesInfo> response) {
                Log.d(TAG, "Thread.currentThread().getId():" + Thread.currentThread().getId());

                mMovieList=response.body().getMovies();
                Log.d(TAG, " mMovieList.size():" + mMovieList.size());
                for(Movie movie :mMovieList){
                    Log.d(TAG, movie.getTitle());
                }
            }

            @Override
            public void onFailure(Call<HotMoviesInfo> call, Throwable t) {
                Log.d(TAG, "Thread.currentThread().getId():" + Thread.currentThread().getId());
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false);
    }

    private   void loadMovie(Callback<HotMoviesInfo> callback){
        IDoubanService  doubanService = DoubanManger.createDoubanServerce();
        doubanService.searchHotMovies().enqueue(callback);

    }

}
