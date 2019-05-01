package com.ar4i.gifer.presentation.main.view;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.ar4i.gifer.R;
import com.ar4i.gifer.presentation.base.view.BaseViewHolder;
import com.bumptech.glide.Glide;

public class GifsViewHolder extends BaseViewHolder<String> {

    public GifsViewHolder(@NonNull View itemView) {
        super(itemView);
        imgGig = itemView.findViewById(R.id.img_gif);
    }

    //==========================================start ui=============================================
    ImageView imgGig;
    //-------------------------------------------end ui---------------------------------------------


    //==========================================start  extends BaseViewHolder<String>===============
    @Override
    public void bind(String item) {
        Glide.with(imgGig.getContext())
                .load(item)
                .centerCrop()
                .placeholder(R.drawable.ic_digital_campaign)
                .into(imgGig);
    }
    //-------------------------------------------end  extends BaseViewHolder<String>----------------
}
