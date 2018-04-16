package weili.example.com.mydouban;

/**
 * @author Administrator
 * @name IDouBan
 * @class describe
 * @time 2018-04-11 18:05
 */
public interface BaseView<T> {

    /**
     *  连接view 与presenter
     * @param presenter
     */
    void  setPresenter( T presenter);

}
