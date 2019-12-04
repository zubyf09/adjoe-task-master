package com.adjoe.task.view;

import android.arch.lifecycle.ViewModelProviders;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.adjoe.task.R;
import com.adjoe.task.data.Album;
import com.adjoe.task.databinding.ActivityAlbumsBinding;
import com.adjoe.task.utils.Constants;
import com.adjoe.task.utils.NotificationUtil;
import com.adjoe.task.utils.StringUtility;
import com.adjoe.task.viewmodel.AlbumsViewModel;

import java.util.List;


public class AlbumsActivity extends AppCompatActivity {
    private final String TAG = AlbumsActivity.class.getName();
    private AlbumsViewModel albumsViewModel;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupBindings(savedInstanceState);
    }

    private void setupBindings(Bundle savedInstanceState) {
        ActivityAlbumsBinding activityBinding = DataBindingUtil.setContentView(this, R.layout.activity_albums);
        albumsViewModel = ViewModelProviders.of(this).get(AlbumsViewModel.class);
        if (savedInstanceState == null) {
            albumsViewModel.init();
        }
        activityBinding.setAlbumsViewModel(albumsViewModel);

        setupListUpdate();

        sharedPreferences = getSharedPreferences(Constants.SHARED_PREFERENCES, MODE_PRIVATE);

        if (!sharedPreferences.contains(Constants.PHONE_UNLOCK_TIME)){
            sharedPreferences.edit().putLong(Constants.PHONE_UNLOCK_TIME, System.currentTimeMillis()).commit();
        }

        mHandler = new Handler();

        //        startService( new Intent(this, YourService.class));

    }

    @Override
    protected void onResume() {
        super.onResume();
        setTimer();
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (mHandler != null && runnable != null){
            mHandler.removeCallbacks(runnable);
        }
    }

    private void setupListUpdate() {
        albumsViewModel.loading.set(View.VISIBLE);
        albumsViewModel.fetchList();
        albumsViewModel.getAlbums().observe(this, (List<Album> albums) -> {
            albumsViewModel.loading.set(View.GONE);
            if (albums.size() == 0) {
                albumsViewModel.showEmpty.set(View.VISIBLE);
            } else {
                albumsViewModel.showEmpty.set(View.GONE);
                albumsViewModel.setAlbumInAdapter(albums);
            }
        });
    }

    Handler mHandler;
    Runnable runnable;

    private void setTimer() {

        runnable = new Runnable() {
            @Override
            public void run() {

                long time = sharedPreferences.getLong(Constants.PHONE_UNLOCK_TIME, System.currentTimeMillis());
                NotificationUtil.showNotification(AlbumsActivity.this, StringUtility.formatTime(time));
                mHandler.postDelayed(this, 5000);
            }
        };

        mHandler.post(runnable);
    }
}
