package net.fortinity.moviecatalogueuiux.Fragment;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import net.fortinity.moviecatalogueuiux.Activity.FragmentMovieActivity;
import net.fortinity.moviecatalogueuiux.Adapter.ListMovieAdapter;
import net.fortinity.moviecatalogueuiux.Model.Movie;
import net.fortinity.moviecatalogueuiux.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment {

    private RecyclerView rvMovies;
    private ArrayList<Movie> list = new ArrayList<>();

    public MoviesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvMovies = view.findViewById(R.id.rv_movies);
        rvMovies.setHasFixedSize(true);

        list.addAll(getListMovies());
        showRecyclerList();
    }

    public ArrayList<Movie> getListMovies() {
        String[] dataNamaMovie = getResources().getStringArray(R.array.data_nama_movie);
        String[] dataDeskripsiMovie = getResources().getStringArray(R.array.data_deskripsi_movie);
        TypedArray dataFotoMovie = getResources().obtainTypedArray(R.array.data_foto_movie);

        ArrayList<Movie> listMovie = new ArrayList<>();
        for (int i = 0; i < dataNamaMovie.length; i++) {
            Movie movie = new Movie();
            movie.setName(dataNamaMovie[i]);
            movie.setDescription(dataDeskripsiMovie[i]);
            movie.setPhoto(dataFotoMovie.getResourceId(i, -1));

            listMovie.add(movie);
        }
        return listMovie;
    }

    private void showRecyclerList() {
        rvMovies.setLayoutManager(new LinearLayoutManager(getActivity()));
        ListMovieAdapter listMovieAdapter = new ListMovieAdapter(list);
        rvMovies.setAdapter(listMovieAdapter);

        listMovieAdapter.setOnItemClickCallback(new ListMovieAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Movie data) {
                showSelectedMovie(data);
            }
        });
    }

    private void showSelectedMovie(Movie movie) {
        Intent i = new Intent(getActivity().getBaseContext(), FragmentMovieActivity.class);
        i.putExtra(FragmentMovieActivity.EXTRA_MOVIE, movie);
        getActivity().startActivity(i);
    }
}
