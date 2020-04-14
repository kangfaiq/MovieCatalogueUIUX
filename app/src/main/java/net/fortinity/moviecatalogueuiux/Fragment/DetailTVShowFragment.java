package net.fortinity.moviecatalogueuiux.Fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import net.fortinity.moviecatalogueuiux.Activity.FragmentTVShowActivity;
import net.fortinity.moviecatalogueuiux.Model.TVShow;
import net.fortinity.moviecatalogueuiux.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailTVShowFragment extends Fragment {

    TVShow tvShow;

    ImageView photo;
    TextView title, description;

    public static final String EXTRA_TVSHOW = "extra_tvshow";

    public DetailTVShowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_detail_tvshow, container, false);
        if (getArguments() != null) {
            tvShow = getArguments().getParcelable(FragmentTVShowActivity.EXTRA_TVSHOW);
        }

        if (tvShow != null) {
            initializeViews(v);
            photo.setImageResource(tvShow.getPhoto());
            title.setText(tvShow.getName());
            description.setText(tvShow.getDescription());
        }

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void initializeViews(View view) {
        photo = view.findViewById(R.id.gambar_tvshow);
        title = view.findViewById(R.id.judul_tvshow);
        description = view.findViewById(R.id.deskripsi_tvshow);
    }
}
