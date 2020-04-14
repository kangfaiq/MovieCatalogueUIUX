package net.fortinity.moviecatalogueuiux.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import net.fortinity.moviecatalogueuiux.Fragment.DetailMovieFragment;
import net.fortinity.moviecatalogueuiux.Model.Movie;
import net.fortinity.moviecatalogueuiux.R;

public class FragmentMovieActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_movie_activity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FragmentManager mFragmentManager = getSupportFragmentManager();

        DetailMovieFragment mDetailMovieFragment = new DetailMovieFragment();
        Fragment fragment = mFragmentManager.findFragmentByTag(DetailMovieFragment.class.getSimpleName());

        if (!(fragment instanceof DetailMovieFragment && fragment != null)) {
            Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);

            Bundle mBundle = new Bundle();

            mBundle.putParcelable(DetailMovieFragment.EXTRA_MOVIE, movie);

            mDetailMovieFragment.setArguments(mBundle);

            if (mFragmentManager != null) {
                mFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_movie, mDetailMovieFragment, DetailMovieFragment.class.getSimpleName())
                        .commit();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_change_settings) {
            Intent mIntent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(mIntent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
