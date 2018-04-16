package weili.example.com.mydouban.movies;

import java.util.List;

import weili.example.com.mydouban.BasePresenter;
import weili.example.com.mydouban.BaseView;
import weili.example.com.mydouban.beans.Movie;

/**
 * @author Administrator
 * @name IDouBan
 * @class describe
 * @time 2018-04-11 18:08
 */
public interface MoviesContranct {

    interface View extends BaseView<Presenter> {

        void showmMovies(List<Movie> movies);

        void showMoMovies();

        void setLoadingInicator(boolean active);
    }

    interface Presenter extends BasePresenter {

        void loadMovies(boolean forceupdate);
    }
}
