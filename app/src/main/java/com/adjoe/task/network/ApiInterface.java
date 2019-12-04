/**
 * @file ApiInterface.java
 * @brief This is the api interface class, it will contain all the Api call references
 * @author Shrikant
 * @date 14/04/2018
 */
package com.adjoe.task.network;

import com.adjoe.task.data.Album;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("albums")
    Call<List<Album>> getAlbums();

}
