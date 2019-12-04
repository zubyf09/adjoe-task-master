package com.adjoe.task.adapter.viewholder;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

import com.adjoe.task.viewmodel.AlbumsViewModel;

public class AlbumViewHolder extends RecyclerView.ViewHolder {
    final ViewDataBinding binding;

    public AlbumViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(AlbumsViewModel viewModel, Integer position) {
        binding.setVariable(com.adjoe.task.BR.mealViewModel, viewModel);
        binding.setVariable(com.adjoe.task.BR.position, position);
        binding.executePendingBindings();
    }

}