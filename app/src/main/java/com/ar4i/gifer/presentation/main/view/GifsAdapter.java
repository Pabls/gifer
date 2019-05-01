package com.ar4i.gifer.presentation.main.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.ar4i.gifer.R;
import com.ar4i.gifer.presentation.base.view.BaseAdapter;

public class GifsAdapter extends BaseAdapter<String, GifsViewHolder> {

    @NonNull
    @Override
    public GifsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_gifs, parent, false);
        return new GifsViewHolder(view);
    }

}
