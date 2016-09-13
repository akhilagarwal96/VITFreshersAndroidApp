package com.akhilagarwal96.vitfreshers;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

class ListAdapterExchange extends ArrayAdapter{
Button sell;
    public ListAdapterExchange(Activity context, String[] text1, String[] text2,String[] text3,String[] text4){
        super(context,R.layout.resale_cards,text1);

        this.context=context;
        this.text1=text1;
        this.text2=text2;
        this.text3=text3;
        this.text4=text4;
    }

    private final Activity context;
    private final String[] text1;
    private final String[] text2;
    private final String[] text3;
    private final String[] text4;

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.resale_cards, null, true);

        TextView Name = (TextView) rowView.findViewById(R.id.name_ex);
        TextView Room = (TextView) rowView.findViewById(R.id.location_ex);
        TextView Number = (TextView) rowView.findViewById(R.id.phone_ex);
        TextView Product = (TextView) rowView.findViewById(R.id.product_ex);

        Name.setText(text1[position]);
        Room.setText(text2[position]);
        Number.setText(text3[position]);
        Product.setText(text4[position]);

        sell = (Button) Product.findViewById(R.id.sell_button);
/*
        sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i_sell = new Intent(this, Home.class);

                startActivity(i_sell);
            }
        });
*/
        return rowView;

    };
}