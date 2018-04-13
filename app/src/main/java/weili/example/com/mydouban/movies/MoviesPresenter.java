package weili.example.com.mydouban.movies;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import weili.example.com.mydouban.api.IDoubanService;
import weili.example.com.mydouban.beans.HotMoviesInfo;

/**
 * @author Administrator
 * @name IDouBan
 * @class describe
 * @time 2018-04-12 9:26
 */
public class MoviesPresenter implements MoviesContranct.Presenter {

    private final MoviesContranct.View mMoviesViews;
    private final IDoubanService mDoubanService;

    public MoviesPresenter(MoviesContranct.View mMoviesViews, IDoubanService mDoubanService) {
        this.mMoviesViews = mMoviesViews;
        this.mDoubanService = mDoubanService;

        mMoviesViews.setPresenter(this);
    }

    @Override
    public void start() {
        //MoviesFragemnt显示
        loadMovies(false);
    }

    @Override
    public void loadMovies(boolean forceupdate) {
        if(forceupdate){

            mDoubanService.searchHotMovies().enqueue(new Callback<HotMoviesInfo>() {
                @Override
                public void onResponse(Call<HotMoviesInfo> call, Response<HotMoviesInfo> response) {

                }

                @Override
                public void onFailure(Call<HotMoviesInfo> call, Throwable t) {

                }
            });
        }

    }
}
