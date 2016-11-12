package com.bridgelabz.facebookwhatsupsharing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by bridgeit007 on 11/11/16.
 */

public class GridAdapter extends BaseAdapter {

    ArrayList <Packagelist> mData ;
    Context mContext;

    public GridAdapter(ArrayList<Packagelist> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (view == null) {

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.item, null);
            TextView textView = (TextView) grid.findViewById(R.id.textview);
            ImageView imageView = (ImageView) grid.findViewById(R.id.imageview);
            textView.setText(mData.get(i).getAppname());
            imageView.setImageDrawable(mData.get(i).getImage());

        } else {
            grid = (View) view;
        }

        return grid;
    }


}
