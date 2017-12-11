package com.medhelp.mamontino.baseproject.ui.base;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import com.medhelp.mamontino.baseproject.R;
import com.medhelp.mamontino.baseproject.utils.ProgressUtils;
import com.medhelp.mamontino.baseproject.utils.NetworkUtils;


public abstract class BaseActivity extends AppCompatActivity
        implements MvpView, BaseFragment.Callback
{
    private ProgressDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @TargetApi(Build.VERSION_CODES.M)
    public void requestPermissionsSafely(String[] permissions, int requestCode)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        {
            requestPermissions(permissions, requestCode);
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    public boolean hasPermission(String permission)
    {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M ||
                checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public void showLoading()
    {
        hideLoading();
        dialog = ProgressUtils.showOvalDialog(this);
    }

    @Override
    public void showLineLoading()
    {
        hideLoading();
        dialog = ProgressUtils.showLineDialog(this);
    }

    @Override
    public void hideLoading()
    {
        if (dialog != null && dialog.isShowing())
        {
            dialog.cancel();
        }
    }

    private void showSnackBar(String message)
    {
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT);
        View sbView = snackbar.getView();
        TextView textView = sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(this, R.color.white));
        snackbar.show();
    }

    @Override
    public void showError(String message)
    {
        if (message != null)
        {
            showSnackBar(message);
        } else
        {
            showSnackBar(getString(R.string.some_error));
        }
    }

    @Override
    public void showError(@StringRes int resId)
    {
        showError(getString(resId));
    }

    @Override
    public void showMessage(String message)
    {
        if (message != null)
        {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        } else
        {
            Toast.makeText(this, getString(R.string.some_error), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showMessage(@StringRes int resId)
    {
        showMessage(getString(resId));
    }

    @Override
    public boolean isNetworkConnected()
    {
        return NetworkUtils.isNetworkConnected(getApplicationContext());
    }

    @Override
    public void onFragmentAttached()
    {
    }

    @Override
    public void onFragmentDetached(String tag)
    {
    }

    public void hideKeyboard()
    {
        View view = this.getCurrentFocus();
        if (view != null)
        {
            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null)
            {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }
}
