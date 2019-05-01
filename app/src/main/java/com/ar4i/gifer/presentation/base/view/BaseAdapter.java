package com.ar4i.gifer.presentation.base.view;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapter<T, VH extends BaseViewHolder<T>> extends RecyclerView.Adapter<VH> {
    protected List<T> items = new ArrayList<>();


    @Override
    public void onBindViewHolder(@NonNull VH vh, int i) {
        vh.bind(getItem(i));
    }

    private T getItem(int i) {
        return items.get(i);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addAllAndNotify(List<T> items) {
        this.items = items;
        notifyDataSetChanged();
    }
}

