package com.medhelp.mamontino.baseproject.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.medhelp.mamontino.baseproject.R;
import com.medhelp.mamontino.baseproject.ui.base.BaseViewHolder;

import java.util.List;


public class MainAdapter extends RecyclerView.Adapter<BaseViewHolder>
{
    private static final int VIEW_TYPE_NORMAL = 111;
    private List<String> response;

    public MainAdapter(List<String> response)
    {
        this.response = response;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position)
    {
        holder.onBind(position);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        switch (viewType)
        {
            case VIEW_TYPE_NORMAL:
                return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main, parent, false));
        }
        return new EmptyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main, parent, false));
    }

    @Override
    public int getItemViewType(int position)
    {
        if (response != null && response.size() > 0)
        {
            return VIEW_TYPE_NORMAL;
        }
        return 0;
    }

    @Override
    public int getItemCount()
    {
        if (response != null && response.size() > 0)
        {
            return response.size();
        } else
        {
            return 0;
        }
    }

    void addItems(List<String> repoList)
    {
        response.clear();
        response.addAll(repoList);
        notifyDataSetChanged();
    }

    class ViewHolder extends BaseViewHolder
    {
        ViewHolder(View itemView)
        {
            super(itemView);
        }

        protected void clear()
        {
        }

        public void onBind(int position)
        {
            super.onBind(position);
        }
    }

    class EmptyViewHolder extends BaseViewHolder
    {

        EmptyViewHolder(View itemView)
        {
            super(itemView);
        }

        @Override
        protected void clear()
        {
        }
    }
}
