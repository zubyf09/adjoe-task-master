package com.adjoe.task.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableInt;
import android.databinding.ObservableList;
import android.util.Log;
import android.view.View;

import com.adjoe.task.R;
import com.adjoe.task.adapter.AlbumsAdapter;
import com.adjoe.task.data.Album;
import com.adjoe.task.model.Albums;

import java.util.List;

public class AlbumsViewModel extends ViewModel {

    private final String TAG = AlbumsViewModel.class.getName();

    public ObservableList<Album> albumList;
    public MutableLiveData<Album> selected;
    public ObservableInt loading;
    public ObservableInt showEmpty;

    public Albums albums;

    AlbumsAdapter albumsAdapter;

    public void init() {
        albums = new Albums();

        albumList = new ObservableArrayList<>();
        selected = new MutableLiveData<>();
        loading = new ObservableInt(View.GONE);
        showEmpty = new ObservableInt(View.GONE);
        albumsAdapter = new AlbumsAdapter(R.layout.item_album, this);

    }


    public void fetchList() {
        albums.fetchList();
    }

    public MutableLiveData<List<Album>> getAlbums() {
        return albums.getAlbums();
    }

    public AlbumsAdapter getAdapter() {
        return albumsAdapter;
    }

    public void setAlbumInAdapter(List<Album> meals) {
        albumsAdapter.setMeals(meals);
        albumsAdapter.notifyDataSetChanged();
    }

    public Album getMealAt(Integer index) {
        Log.i(TAG, "Index: " + index);

        if (albums.getAlbums().getValue() != null && index != null && albums.getAlbums().getValue().size() > index) {
            Album meal = albums.getAlbums().getValue().get(index);
            Log.i(TAG, meal.toString());
            return meal;
        }

        return null;
    }

}