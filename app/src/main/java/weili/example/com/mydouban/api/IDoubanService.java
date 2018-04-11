package weili.example.com.mydouban.api;
import retrofit2.Call;
import retrofit2.http.GET;
import weili.example.com.mydouban.movies.HotMoviesInfo;

/**
 * @author Administrator
 * @name IDouBan
 * @class describe
 * @time 2018-04-11 9:50
 */
public interface IDoubanService {
    String BASE_URL="http://api.douban.com/v2/";

    @GET("movie/in_theaters")
    Call <HotMoviesInfo> searchHotMovies();
}
