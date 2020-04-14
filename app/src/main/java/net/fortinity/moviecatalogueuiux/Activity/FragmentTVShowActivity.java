package net.fortinity.moviecatalogueuiux.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import net.fortinity.moviecatalogueuiux.Fragment.DetailTVShowFragment;
import net.fortinity.moviecatalogueuiux.Model.TVShow;
import net.fortinity.moviecatalogueuiux.R;

public class FragmentTVShowActivity extends AppCompatActivity {

    public static final String EXTRA_TVSHOW = "extra_tvshow";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_tvshow_activity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FragmentManager mFragmentManager = getSupportFragmentManager();

        DetailTVShowFragment mDetailTVShowFragment = new DetailTVShowFragment();
        Fragment fragment = mFragmentManager.findFragmentByTag(DetailTVShowFragment.class.getSimpleName());

        if (!(fragment instanceof DetailTVShowFragment && fragment != null)) {
            TVShow tvShow = getIntent().getParcelableExtra(EXTRA_TVSHOW);

            Bundle mBundle = new Bundle();

            mBundle.putParcelable(DetailTVShowFragment.EXTRA_TVSHOW, tvShow);

            mDetailTVShowFragment.setArguments(mBundle);

            if (mFragmentManager != null) {
                mFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_tvshow, mDetailTVShowFragment, DetailTVShowFragment.class.getSimpleName())
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
