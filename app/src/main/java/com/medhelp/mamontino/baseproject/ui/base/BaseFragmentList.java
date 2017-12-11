package com.medhelp.mamontino.baseproject.ui.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.ListFragment;
import android.view.View;

import com.medhelp.mamontino.baseproject.utils.ProgressUtils;


public abstract class BaseFragmentList extends ListFragment implements MvpView
{
    private BaseActivity activity;
    private ProgressDialog dialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        setUp(view);
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        if (context instanceof BaseActivity)
        {
            BaseActivity activity = (BaseActivity) context;
            this.activity = activity;
            activity.onFragmentAttached();
        }
    }

    @Override
    public void showLoading()
    {
        hideLoading();
        dialog = ProgressUtils.showOvalDialog(this.getContext());
    }

    @Override
    public void showLineLoading()
    {
        hideLoading();
        dialog = ProgressUtils.showLineDialog(this.getContext());
    }

    @Override
    public void hideLoading()
    {
        if (dialog != null && dialog.isShowing())
        {
            dialog.cancel();
        }
    }

    @Override
    public void showError(String message)
    {
        if (activity != null)
        {
            activity.showError(message);
        }
    }

    @Override
    public void showError(@StringRes int resId)
    {
        if (activity != null)
        {
            activity.showError(resId);
        }
    }

    @Override
    public void showMessage(String message)
    {
        if (activity != null)
        {
            activity.showMessage(message);
        }
    }

    @Override
    public void showMessage(@StringRes int resId)
    {
        if (activity != null)
        {
            activity.showMessage(resId);
        }
    }

    @Override
    public boolean isNetworkConnected()
    {
        if (activity != null)
        {
            return activity.isNetworkConnected();
        }
        return false;
    }

    @Override
    public void onDetach()
    {
        activity = null;
        super.onDetach();
    }

    @Override
    public void hideKeyboard()
    {
        if (activity != null)
        {
            activity.hideKeyboard();
        }
    }

    public BaseActivity getBaseActivity()
    {
        return activity;
    }

    protected abstract void setUp(View view);

    public interface Callback
    {
        void onFragmentAttached();

        void onFragmentDetached(String tag);
    }
}
