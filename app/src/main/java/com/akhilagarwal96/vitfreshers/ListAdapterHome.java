package com.akhilagarwal96.vitfreshers;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListAdapterHome extends ArrayAdapter {

    public ListAdapterHome(FragmentActivity context, String[] firstline, String[] secondline, Integer[] imgid) {
        super(context, R.layout.home_list, firstline);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.firstline=firstline;
        this.secondline=secondline;
        this.imgid=imgid;
    }

    private final Activity context;
    private final String[] firstline;
    private final String[] secondline;
    private final Integer[] imgid;

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.home_list, null, true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.first);
        TextView txtTitle1 = (TextView) rowView.findViewById(R.id.second);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.timeline);

        txtTitle.setText(firstline[position]);
        txtTitle1.setText(secondline[position]);
        imageView.setImageResource(imgid[position]);


        return rowView;
    };

}

