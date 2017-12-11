package com.medhelp.mamontino.baseproject.ui.main;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.medhelp.mamontino.baseproject.R;
import com.medhelp.mamontino.baseproject.ui.base.BaseActivity;

public class MainActivity extends BaseActivity implements MainViewHelper
{
    public static Intent start(Context context)
    {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
