package com.example.jennykuma.peticularme;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by evech on 2016-11-25.
 */

public class ImageAdapter extends BaseAdapter {
    private Context context;
    public ImageAdapter(Context mContext){
        context = mContext;
    }
    public int getCount(){
        return imageIds.length;
    }
    public Object getItem(int position){
        return null;
    }
    public long getItemId(int position){
        return 0;
    }
    public View getView(int position, View newView, ViewGroup viewgroup){
        ImageView imageView;
        if(newView == null){
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else{
            imageView = (ImageView) newView;
        }
        imageView.setImageResource(imageIds[position]);
        return imageView;
    }
    public Integer[] imageIds = {
            R.drawable.ic_notifications_black_24dp,
            R.drawable.ic_sync_black_24dp,
            R.drawable.ic_info_black_24dp,
            R.drawable.ic_person,
            R.drawable.ic_action_name
    };

}