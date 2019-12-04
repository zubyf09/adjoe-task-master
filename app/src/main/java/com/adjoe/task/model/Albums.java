package com.adjoe.task.model;


import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.adjoe.task.data.Album;
import com.adjoe.task.network.ApiClient;
import com.adjoe.task.network.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Albums {

    private final String TAG = Albums.class.getName();

//    private List<DAOAlbum> albumsList;
    private MutableLiveData<List<Album>> albums;

    public Albums() {
//        albumsList = new ArrayList<>();
        albums = new MutableLiveData<>();
    }

//    public List<DAOAlbum> getAlbumsList() {
//        return albumsList;
//    }

//    public void setAlbumsList(List<DAOAlbum> albumsList) {
//        this.albumsList = albumsList;
//    }

    public void setAlbums(MutableLiveData<List<Album>> albums) {
        this.albums = albums;
    }

//    public void addMeal(DAOAlbum meal) {
//        albumsList.add(0, meal);
//    }

    public MutableLiveData<List<Album>> getAlbums() {
        return albums;
    }

    public void fetchList() {

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<List<Album>> call = apiService.getAlbums();
        call.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                albums.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });

    }


}
