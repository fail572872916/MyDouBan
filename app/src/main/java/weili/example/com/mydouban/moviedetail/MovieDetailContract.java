package weili.example.com.mydouban.moviedetail;


import weili.example.com.mydouban.BasePresenter;
import weili.example.com.mydouban.BaseView;

public interface MovieDetailContract {

    interface View extends BaseView<Presenter> {

        void showCollapsingToolbarTitle(String title);

        void showPicassoImage(String largeImagePath);

        void setMovieInfoToFragment(String movieInfo);

        void setMovieAltToFragment(String movieAlt);


    }

    interface Presenter extends BasePresenter {

        void loadMovieInfo();

        void loadMovieAlt();
    }
}
