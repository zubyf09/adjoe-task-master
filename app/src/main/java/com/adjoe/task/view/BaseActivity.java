package com.adjoe.task.view;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;

import com.adjoe.task.R;


public class BaseActivity extends AppCompatActivity {

    private ProgressDialog mProgressDialog;

    public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setCancelable(false);
            mProgressDialog.setMessage(getResources().getString(R.string.loading));
        }

        mProgressDialog.show(); 
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

}
