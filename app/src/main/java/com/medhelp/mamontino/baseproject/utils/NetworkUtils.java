package com.medhelp.mamontino.baseproject.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public final class NetworkUtils
{
    private NetworkUtils()
    {
    }

    public static boolean isNetworkConnected(Context context)
    {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo isOnline = null;
        if (cm != null)
        {
            isOnline = cm.getActiveNetworkInfo();
        }
        return isOnline != null && isOnline.isConnectedOrConnecting();
    }
}
