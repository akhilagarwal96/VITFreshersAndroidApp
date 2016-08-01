package com.akhilagarwal96.vitfreshers;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Adm on 01-Aug-16.
 */
public class ListAdapterServices extends ArrayAdapter {

    public ListAdapterServices(FragmentActivity context, String[] text01, String[] text02, Integer[] imgid01, int[] button01) {
        super(context, R.layout.services_cards,text01);

        this.context=context;
        this.text01=text01;
        this.text02=text02;
        this.imgid01=imgid01;
        this.button01=button01;
    }

    private final Activity context;
    private final String[] text01;
    private final String[] text02;
    private final Integer[] imgid01;
    private final int[] button01;

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.services_cards, null, true);

        TextView txtHead = (TextView) rowView.findViewById(R.id.ser_txt1);
        TextView txtNum = (TextView) rowView.findViewById(R.id.ser_txt2);
        ImageView imagView = (ImageView) rowView.findViewById(R.id.ser_img);
        ImageButton bcall = (ImageButton) rowView.findViewById(R.id.ser_button);

        txtHead.setText(text01[position]);
        txtNum.setText(text02[position]);
        imagView.setImageResource(imgid01[position]);
        bcall.setImageResource(button01[position]);


        return rowView;

    };

}