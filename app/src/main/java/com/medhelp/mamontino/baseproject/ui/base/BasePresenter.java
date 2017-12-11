package com.medhelp.mamontino.baseproject.ui.base;

public class BasePresenter<V extends MvpView> implements MvpPresenter<V>
{
    private V mvpView;

    @Override
    public void onAttach(V mvpView)
    {
        this.mvpView = mvpView;
    }

    @Override
    public void onDetach()
    {
        mvpView = null;
    }

    public boolean isViewAttached()
    {
        return mvpView != null;
    }

    public V getMvpView()
    {
        return mvpView;
    }

    public void checkViewAttached()
    {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    public static class MvpViewNotAttachedException extends RuntimeException
    {
        public MvpViewNotAttachedException()
        {
            super("Please call Presenter.onAttach(MvpView) before" +
                    " requesting data to the Presenter");
        }
    }
}
