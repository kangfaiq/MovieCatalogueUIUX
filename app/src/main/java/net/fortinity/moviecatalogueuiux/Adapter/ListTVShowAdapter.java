package net.fortinity.moviecatalogueuiux.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import net.fortinity.moviecatalogueuiux.Model.TVShow;
import net.fortinity.moviecatalogueuiux.R;

import java.util.ArrayList;

public class ListTVShowAdapter extends RecyclerView.Adapter<ListTVShowAdapter.ListViewHolder> {
    private ArrayList<TVShow> listTVShow;

    private ListTVShowAdapter.OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(ListTVShowAdapter.OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public ListTVShowAdapter(ArrayList<TVShow> list) {
        this.listTVShow = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_movies, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        TVShow tvShow = listTVShow.get(position);
        Glide.with(holder.itemView.getContext())
                .load(tvShow.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);
        holder.tvName.setText(tvShow.getName());
        holder.tvDescription.setText(tvShow.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(listTVShow.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listTVShow.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDescription;

        ListViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDescription = itemView.findViewById(R.id.tv_item_description);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(TVShow data);
    }
}
