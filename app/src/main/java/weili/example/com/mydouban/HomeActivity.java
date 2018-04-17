package weili.example.com.mydouban;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import weili.example.com.mydouban.api.DoubanManger;
import weili.example.com.mydouban.book.BooksFragment;
import weili.example.com.mydouban.movies.MoviesContract;
import weili.example.com.mydouban.movies.MoviesFragment;
import weili.example.com.mydouban.movies.MoviesPresenter;

public class HomeActivity extends AppCompatActivity {

    public static final String TAG = "HomeActivity";
    @BindView(R.id.tab_main)
    TabLayout tabMain;
    @BindView(R.id.vp_main)
    ViewPager vpMain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        setUpViewPager(vpMain);
        if (tabMain != null) {
            tabMain.addTab(tabMain.newTab());
            tabMain.addTab(tabMain.newTab());
            tabMain.setupWithViewPager(vpMain);
        }
    }

    private void setUpViewPager(ViewPager vpMain) {

        DouBanPagerAdapter doubanPagerAdapter = new DouBanPagerAdapter(getSupportFragmentManager());
        MoviesFragment   moviesFragment =MoviesFragment.newInstance();
        doubanPagerAdapter.addFragment(moviesFragment, getApplicationContext().getResources().getString(R.string.tab_movies_fragment));
        doubanPagerAdapter.addFragment(new BooksFragment(), getApplicationContext().getResources().getString(R.string.tab_books_fragment));
        vpMain.setAdapter(doubanPagerAdapter);

        createPresenter(moviesFragment);
    }
    private  void createPresenter(MoviesContract.View  fragmentView){
        new MoviesPresenter(DoubanManger.createDoubanServerce(),fragmentView);
    }

    static class DouBanPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> fragmentList = new ArrayList<>();
        private final List<String> mFragmentTitle = new ArrayList<>();

        public DouBanPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String titile) {
            fragmentList.add(fragment);
            mFragmentTitle.add(titile);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitle.get(position);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
