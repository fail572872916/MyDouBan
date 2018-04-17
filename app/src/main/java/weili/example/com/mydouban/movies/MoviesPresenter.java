package weili.example.com.mydouban.movies;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import weili.example.com.mydouban.api.IDoubanService;
import weili.example.com.mydouban.beans.HotMoviesInfo;
import weili.example.com.mydouban.beans.Movie;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author Administrator
 * @name IDouBan
 * @class describe
 * @time 2018-04-12 9:26
 */
public class MoviesPresenter implements MoviesContract.Presenter {
    private IDoubanService mDoubanService;
    private MoviesContract.View mMoviesView;


    boolean mFirstLoad = true;

    public MoviesPresenter(IDoubanService moviesService, MoviesContract.View moviesView) {
        mDoubanService = checkNotNull(moviesService, "IDoubanServie cannot be null!");
        mMoviesView = checkNotNull(moviesView, "IDoubanServie cannot be null!");
        mMoviesView.setPresenter(this);

    }
    @Override
    public void loadMovies(boolean forceUpdate) {

        loadMovies(forceUpdate || mFirstLoad, true);

        mFirstLoad = false;


    }
    @Override
    public void start() {
        //MoviesFragemnt显示

        loadMovies(false);

        Log.d("MoviesPresenter", "ok?");
    }

    private void loadMovies(boolean forceUpdate, final boolean showLoadingUI) {
                 //    MovieFrgment需要显示Loading界面
            if(showLoadingUI){
                //MoviesFragment需要显示Loading 界面
                mMoviesView.setLoadingIndicator(true);
            }
        if(forceUpdate){
            mDoubanService.searchHotMovies().enqueue(new Callback<HotMoviesInfo>() {
                @Override
                public void onResponse(Call<HotMoviesInfo> call, Response<HotMoviesInfo> response) {
                    List<Movie> movieList = response.body().getMovies();
                    Log.d("MoviesPresenter", "movieList.size():" + movieList.size());
                    if (showLoadingUI) {
                        mMoviesView.setLoadingIndicator(false);
                    }
                    processMovives(movieList);

                }


                @Override
                public void onFailure(Call<HotMoviesInfo> call, Throwable t) {
                    Log.d("MoviesPresenter", t.getMessage());
                    if (showLoadingUI) {
                        mMoviesView.setLoadingIndicator(false);
                    }
                }
            });

        }      }
    private void processMovives(List<Movie> movies) {
        if (movies.isEmpty()) {
            processEmptyTasks();
        } else {
            mMoviesView.showMovies(movies);
        }
    }

    private void processEmptyTasks() {
        mMoviesView.showNoMovies();
    }





}