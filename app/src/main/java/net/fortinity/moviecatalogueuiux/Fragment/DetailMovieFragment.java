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

import net.fortinity.moviecatalogueuiux.Activity.FragmentMovieActivity;
import net.fortinity.moviecatalogueuiux.Model.Movie;
import net.fortinity.moviecatalogueuiux.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailMovieFragment extends Fragment {

    ImageView photo;
    TextView title, description;

    Movie movie;

    public static final String EXTRA_MOVIE = "extra_movie";

    public DetailMovieFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_detail_movie, container, false);
        if (getArguments() != null) {
            movie = getArguments().getParcelable(FragmentMovieActivity.EXTRA_MOVIE);
        }

        if (movie != null) {
            initializeViews(v);
            photo.setImageResource(movie.getPhoto());
            title.setText(movie.getName());
            description.setText(movie.getDescription());
        }

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void initializeViews(View view) {
        photo = view.findViewById(R.id.gambar_movie);
        title = view.findViewById(R.id.judul_movie);
        description = view.findViewById(R.id.deskripsi_movie);
    }
}
