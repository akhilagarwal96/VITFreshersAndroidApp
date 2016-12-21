package com.akhilagarwal96.vitfreshers;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
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
public class AdapterServices extends ArrayAdapter {

    public AdapterServices(FragmentActivity context, String[] heading, String[] number, Integer[] img, int[] button) {
        super(context, R.layout.services_cards,heading);

        this.context=context;
        this.heading=heading;
        this.number=number;
        this.img=img;
        this.button=button;
    }

    private final Activity context;
    private final String[] heading;
    private final String[] number;
    private final Integer[] img;
    private final int[] button;

    int i = 0;
    public View getView(final int position,View view,ViewGroup parent) {

        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.services_cards, null, true);

        TextView txtHead = (TextView) rowView.findViewById(R.id.ser_txt1);
        TextView txtNum = (TextView) rowView.findViewById(R.id.ser_txt2);
        ImageView imagView = (ImageView) rowView.findViewById(R.id.ser_img);
        ImageButton bcall = (ImageButton) rowView.findViewById(R.id.call_button);

        txtHead.setText(heading[position]);
        txtNum.setText(number[position]);
        imagView.setImageResource(img[position]);
        bcall.setImageResource(button[position]);

        bcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + number[position]));
                context.startActivity(callIntent);
            }
        });

        return rowView;

    };

}