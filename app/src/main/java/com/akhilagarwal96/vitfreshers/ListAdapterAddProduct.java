package com.akhilagarwal96.vitfreshers;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class ListAdapterAddProduct extends ArrayAdapter{

    public ListAdapterAddProduct(Activity context, String txt_name, String txt_room, String txt_phone, String txt_desc) {
        super(context, R.layout.activity_add_product);

        this.context = context;
        this.txt_name = txt_name;
        this.txt_room = txt_room;
        this.txt_phone = txt_phone;
        this.txt_desc = txt_desc;
    }


    private final Activity context;
    private final String txt_name;
    private final String txt_room;
    private final String txt_phone;
    private final String txt_desc;


    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.activity_add_product, null, true);

        TextView Name = (TextView) rowView.findViewById(R.id.sell_name);
        TextView Room = (TextView) rowView.findViewById(R.id.sell_location);
        TextView Phone = (TextView) rowView.findViewById(R.id.sell_number);
        TextView Desc = (TextView) rowView.findViewById(R.id.sell_description);

        Name.setText(txt_name);
        Room.setText(txt_room);
        Phone.setText(txt_phone);
        Desc.setText(txt_desc);

        return rowView;

    };
}