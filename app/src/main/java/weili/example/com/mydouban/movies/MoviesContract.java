package weili.example.com.mydouban.movies;


import java.util.List;

import weili.example.com.mydouban.BasePresenter;
import weili.example.com.mydouban.BaseView;
import weili.example.com.mydouban.beans.Movie;


public interface MoviesContract {

    interface View extends BaseView<Presenter> {

        void showMovies(List<Movie> movies);

        void showNoMovies();

        void setLoadingIndicator(boolean active);
    }

    interface Presenter extends BasePresenter {
        void loadMovies(boolean forceUpdate);
    }
}
