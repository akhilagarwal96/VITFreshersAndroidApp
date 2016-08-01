package com.akhilagarwal96.vitfreshers;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class ListAdapterFAQ extends ArrayAdapter{

    public ListAdapterFAQ(Activity context, String[] text1, String[] text2){
        super(context,R.layout.faq_cards,text1);

        this.context=context;
        this.text1=text1;
        this.text2=text2;
    }


    private final Activity context;
    private final String[] text1;
    private final String[] text2;

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.faq_cards,null, true);

        TextView txtQues = (TextView) rowView.findViewById(R.id.textView01);
        TextView txtAns = (TextView) rowView.findViewById(R.id.textView02);

        txtQues.setText(text1[position]);
        txtAns.setText(text2[position]);

        return rowView;

    };
}