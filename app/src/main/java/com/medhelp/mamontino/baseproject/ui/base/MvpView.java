package com.medhelp.mamontino.baseproject.ui.base;


import android.support.annotation.StringRes;


public interface MvpView
{
    void showLoading();

    void showLineLoading();

    void hideLoading();

    void showError(@StringRes int resId);

    void showError(String message);

    void showMessage(String message);

    void showMessage(@StringRes int resId);

    boolean isNetworkConnected();

    void hideKeyboard();
}
