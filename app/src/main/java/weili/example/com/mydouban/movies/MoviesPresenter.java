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
public class MoviesPresenter implements MoviesContranct.Presenter {
    private IDoubanService mDoubanService;
    private   MoviesContranct.View mMoviesView;


     boolean mFirstLoad=true;

    public MoviesPresenter( IDoubanService moviesService,MoviesContranct.View moviesView) {
        mDoubanService = checkNotNull(moviesService,"IDoubanServie cannot be null!");
        mMoviesView =checkNotNull(moviesView,"IDoubanServie cannot be null!");
        mMoviesView.setPresenter(this);
    }

    @Override
    public void start() {
        //MoviesFragemnt显示

        loadMovies(true);
        Log.d("MoviesPresenter", "ok?");
    }

    private void loadMovies(boolean forceUpdate, final boolean showLoadingUI) {
        if (showLoadingUI) {
            //    MovieFrgment需要显示Loading界面

            mDoubanService.searchHotMovies().enqueue(new Callback<HotMoviesInfo>() {
                @Override
                public void onResponse(Call<HotMoviesInfo> call, Response<HotMoviesInfo> response) {
                    List<Movie> movieList = response.body().getMovies();
                    Log.d("MoviesPresenter", "movieList.size():" + movieList.size());
                    if (showLoadingUI) {
                        mMoviesView.setLoadingInicator(false);
                    }
                    processMovives(movieList);

                }

                                private void processMovives(List<Movie> movieList) {
                    if (movieList.isEmpty()) {
                        processEmptyTasks();
                    } else {
                        mMoviesView.showmMovies(movieList);
                    }
                }

                private void processEmptyTasks() {
                    mMoviesView.showMoMovies();
                }

                @Override
                public void onFailure(Call<HotMoviesInfo> call, Throwable t) {
                    Log.d("MoviesPresenter", t.getMessage());
                    if (showLoadingUI) {
                        mMoviesView.setLoadingInicator(false);
                    }
                }
            });
        }
//        if (forceUpdate) {
//            Log.d("MoviesPresenter", "forceUpdate:" + forceUpdate);
//            mDoubanService.searchHotMovies().enqueue(new Callback<HotMoviesInfo>() {
//                @Override
//                public void onResponse(Call<HotMoviesInfo> call, Response<HotMoviesInfo> response) {
//                    List<Movie> movieList = response.body().getMovies();
//                    Log.d("MoviesPresenter", "movieList.size():" + movieList.size());
//                    if (showLoadingUI) {
//                        mMoviesView.setLoadingInicator(false);
//                    }
//                    processMovives(movieList);
//                }
//
//                private void processMovives(List<Movie> movieList) {
//                    if (movieList.isEmpty()) {
//                        processEmptyTasks();
//                    } else {
//                        mMoviesView.showmMovies(movieList);
//                    }
//                }
//
//                private void processEmptyTasks() {
//                    mMoviesView.showMoMovies();
//                }
//
//                @Override
//                public void onFailure(Call<HotMoviesInfo> call, Throwable t) {
//                    Log.d("MoviesPresenter", t.getMessage());
//                    if (showLoadingUI) {
//                        mMoviesView.setLoadingInicator(false);
//                    }
//                }
//            });
//        }
    }

    @Override
    public void loadMovies(boolean forceUpdate) {

        loadMovies (forceUpdate || mFirstLoad,true);

            mFirstLoad=true;


    }
}
