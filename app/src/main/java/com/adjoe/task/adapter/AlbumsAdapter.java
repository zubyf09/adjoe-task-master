package com.adjoe.task.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.adjoe.task.data.Album;
import com.adjoe.task.adapter.viewholder.AlbumViewHolder;
import com.adjoe.task.viewmodel.AlbumsViewModel;

import java.util.List;

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumViewHolder> {

    private int layoutId;
    private List<Album> meals;
    private AlbumsViewModel viewModel;

    public AlbumsAdapter(@LayoutRes int layoutId, AlbumsViewModel viewModel) {
        this.layoutId = layoutId;
        this.viewModel = viewModel;
    }

    private int getLayoutIdForPosition(int position) {
        return layoutId;
    }

    @Override
    public int getItemCount() {
        return meals == null ? 0 : meals.size();
    }

    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, viewType, parent, false);

        return new AlbumViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
        holder.bind(viewModel, position);
    }

    @Override
    public int getItemViewType(int position) {
        return getLayoutIdForPosition(position);
    }

    public void setMeals(List<Album> meals) {
        this.meals = meals;
    }
}
