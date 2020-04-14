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

import net.fortinity.moviecatalogueuiux.Activity.FragmentTVShowActivity;
import net.fortinity.moviecatalogueuiux.Adapter.ListTVShowAdapter;
import net.fortinity.moviecatalogueuiux.Model.TVShow;
import net.fortinity.moviecatalogueuiux.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TVShowFragment extends Fragment {

    private RecyclerView rvTVShow;
    private ArrayList<TVShow> list = new ArrayList<>();

    public TVShowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tvshow, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvTVShow = view.findViewById(R.id.rv_tvshow);
        rvTVShow.setHasFixedSize(true);

        list.addAll(getListTVShow());
        showRecyclerList();
    }

    public ArrayList<TVShow> getListTVShow() {
        String[] dataNamaTVShow = getResources().getStringArray(R.array.data_nama_tvshow);
        String[] dataDeskripsiTVShow = getResources().getStringArray(R.array.data_deskripsi_tvshow);
        TypedArray dataFotoTVShow = getResources().obtainTypedArray(R.array.data_foto_tvshow);

        ArrayList<TVShow> listTVShow = new ArrayList<>();
        for (int i = 0; i < dataNamaTVShow.length; i++) {
            TVShow tvShow = new TVShow();
            tvShow.setName(dataNamaTVShow[i]);
            tvShow.setDescription(dataDeskripsiTVShow[i]);
            tvShow.setPhoto(dataFotoTVShow.getResourceId(i, -1));

            listTVShow.add(tvShow);
        }
        return listTVShow;
    }

    private void showRecyclerList() {
        rvTVShow.setLayoutManager(new LinearLayoutManager(getActivity()));
        ListTVShowAdapter listTVShowAdapter = new ListTVShowAdapter(list);
        rvTVShow.setAdapter(listTVShowAdapter);

        listTVShowAdapter.setOnItemClickCallback(new ListTVShowAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(TVShow data) {
                showSelectedTVShow(data);
            }
        });
    }

    private void showSelectedTVShow(TVShow tvShow) {
        Intent i = new Intent(getActivity().getBaseContext(), FragmentTVShowActivity.class);
        i.putExtra(FragmentTVShowActivity.EXTRA_TVSHOW, tvShow);
        getActivity().startActivity(i);
    }

}
