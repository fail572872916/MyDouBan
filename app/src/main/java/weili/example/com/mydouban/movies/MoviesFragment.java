package weili.example.com.mydouban.movies;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
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

    private static final String TAG = MoviesFragment.class.getSimpleName();
    @BindView(R.id.rec_movies)
    RecyclerView recMovies;
    Unbinder unbinder;
    private List<Movie> mMovieList = new ArrayList<>();
    private MoviesAdapter moviesAdapter;

    public MoviesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("MoviesFragment", "onAttach:" + context.getClass().getSimpleName());
        loadMovie(new Callback<HotMoviesInfo>() {
            @Override
            public void onResponse(Call<HotMoviesInfo> call, Response<HotMoviesInfo> response) {
                Log.d(TAG, "Thread.currentThread().getId():" + Thread.currentThread().getId());

                mMovieList = response.body().getMovies();
                Log.d(TAG, " mMovieList.size():" + mMovieList.size());
                moviesAdapter.setdata(mMovieList);
                for (Movie movie : mMovieList) {
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
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    if(recMovies !=null){

        recMovies.setHasFixedSize(true);
        final GridLayoutManager layoutManager= new GridLayoutManager(getActivity().getApplicationContext(),3);
        recMovies.setLayoutManager(layoutManager);
        moviesAdapter = new MoviesAdapter(mMovieList,getContext(), R.layout.item_movie);
        recMovies.setAdapter(moviesAdapter);
    }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movies, container, false);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    private void loadMovie(Callback<HotMoviesInfo> callback) {
        IDoubanService doubanService = DoubanManger.createDoubanServerce();
        doubanService.searchHotMovies().enqueue(callback);

    }

    static class MoviesAdapter extends RecyclerView.Adapter<MoviesViewHoler> {
        private List<Movie> movies;
        private Context context;
        @LayoutRes
        private  int layoutResId;

        public MoviesAdapter(List<Movie> movies, Context context, int layoutResId) {
            this.movies = movies;
            this.context = context;
            this.layoutResId = layoutResId;
        }

        public  void setdata(List<Movie> movies){
            this.movies=movies;
            notifyDataSetChanged();
        }
        @Override
        public MoviesViewHoler onCreateViewHolder(ViewGroup parent, int viewType) {

            View itemView =LayoutInflater.from(context).inflate(layoutResId,parent,false);
            return new MoviesViewHoler(itemView);
        }

        @Override
        public void onBindViewHolder(MoviesViewHoler holder, int position) {

            if(holder==null){
                return;
            }
            holder.updateMovie(movies.get(position));
        }

        @Override
        public int getItemCount() {
            return movies.size();
        }

    }
        static  class  MoviesViewHoler extends  RecyclerView.ViewHolder implements  View.OnClickListener{

            ImageView mMovieImage;

            TextView mMovieTitle;

            RatingBar mMovieStars;

            TextView mMovieRatingAverage;


            public MoviesViewHoler(View itemView) {
                super(itemView);

                mMovieImage = (ImageView) itemView.findViewById(R.id.movie_cover);
                mMovieTitle = (TextView) itemView.findViewById(R.id.movie_title);
                mMovieStars = (RatingBar) itemView.findViewById(R.id.rating_star);
                mMovieRatingAverage = (TextView) itemView.findViewById(R.id.movie_average);

                itemView.setOnClickListener(this);
                }
            @Override
            public void onClick(View v) {

            }

            public void updateMovie(Movie movie) {
                Context context = itemView.getContext();
                if (movie == null || context == null) {return;}

                Picasso.with(context)
                        .load(movie.getImages().getLarge())
                        .placeholder(context.getResources().getDrawable(R.mipmap.ic_launcher))
                        .into(mMovieImage);

                mMovieTitle.setText(movie.getTitle());
                final double average = movie.getRating().getAverage();
                if (average == 0.0) {
                    mMovieStars.setVisibility(View.GONE);
                    mMovieRatingAverage.setText(context.getResources().getString(R.string.string_no_note));
                } else {
                    mMovieStars.setVisibility(View.VISIBLE);
                    mMovieRatingAverage.setText(String.valueOf(average));
                    mMovieStars.setStepSize(0.5f);
                    mMovieStars.setRating((float) (movie.getRating().getAverage() / 2));
                }
            }
            }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
