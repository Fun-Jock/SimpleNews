package com.lauren.simplenews.login;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

public class BaseAppCompatActivity extends AppCompatActivity {
    private ProgressDialog progressDialog;
    private AlertDialog dialog;

    public void showProgressDg(final int resId, final boolean isEnableCancel) {
        showProgressDg(getString(resId), isEnableCancel);
    }

    public void showProgressDg(final String info, final boolean isEnableCancel) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressDialog = new ProgressDialog(BaseAppCompatActivity.this);
                progressDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                progressDialog.setMessage(info);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.setCancelable(isEnableCancel);
                progressDialog.show();
            }
        });
    }

    public void showInfo(int resId) {
        dismiss();
        final String msg = getString(resId);
        runOnUiThread(new Runnable() {
            public void run() {
                dialog = new AlertDialog.Builder(BaseAppCompatActivity.this)
                        .setMessage(msg)
                        .setPositiveButton("确定", null)
                        .create();
                dialog.show();
            }
        });
    }

    public void showInfo(final String str) {
        dismiss();
        runOnUiThread(new Runnable() {
            public void run() {
                dialog = new AlertDialog.Builder(BaseAppCompatActivity.this)
                        .setMessage(str)
                        .setPositiveButton("确定", null)
                        .create();
                dialog.show();
            }
        });
    }

    public void showInfo(final String str, final DialogInterface.OnClickListener onClickListener) {
        dismiss();
        runOnUiThread(new Runnable() {
            public void run() {
                dialog = new AlertDialog.Builder(BaseAppCompatActivity.this)
                        .setMessage(str)
                        .setPositiveButton("确定",onClickListener)
                        .create();
                dialog.show();
            }
        });
    }

    public void dismiss() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (progressDialog != null) {
                    progressDialog.dismiss();
                    progressDialog = null;
                }
            }
        });
    }
}
