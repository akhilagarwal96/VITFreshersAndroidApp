package com.akhilagarwal96.vitfreshers;

public class DataProviderExchange {

    public DataProviderExchange(String t_name, String t_room, String t_phone, String t_desc){

        this.setT_name(t_name);
        this.setT_room(t_room);
        this.setT_phone(t_phone);
        this.setT_desc(t_desc);

    }

    private String t_name,t_room,t_phone,t_desc;

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public String getT_room() {
        return t_room;
    }

    public void setT_room(String t_room) {
        this.t_room = t_room;
    }

    public String getT_phone() {
        return t_phone;
    }

    public void setT_phone(String t_phone) {
        this.t_phone = t_phone;
    }

    public String getT_desc() {
        return t_desc;
    }

    public void setT_desc(String t_desc) {
        this.t_desc = t_desc;
    }
}

/*
package com.akhilagarwal96.vitfreshers;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

class DataProviderExchange extends ArrayAdapter{

    public DataProviderExchange(Activity context, */
/*String[] text1, String[] text2, String[] text3, String[] text4,*//*

                           List<String> txt1,List<String> txt2, List<String> txt3, List<String> txt4){
        super(context,R.layout.resale_cards,txt1);

        this.context=context;
        */
/*
        this.text1=text1;
        this.text2=text2;
        this.text3=text3;
        this.text4=text4;
        *//*

        this.txt1=txt1;
        this.txt2=txt2;
        this.txt3=txt3;
        this.txt4=txt4;
    }

    private final Activity context;
    */
/*
    private final String[] text1;
    private final String[] text2;
    private final String[] text3;
    private final String[] text4;
    *//*

    private final List<String> txt1;
    private final List<String> txt2;
    private final List<String> txt3;
    private final List<String> txt4;

    public View getView(int position,View view,ViewGroup parent) {
        final LayoutInflater inflater=context.getLayoutInflater();

        View rowView = inflater.inflate(R.layout.resale_cards, null, true);

        TextView Name = (TextView) rowView.findViewById(R.id.name_ex);
        TextView Room = (TextView) rowView.findViewById(R.id.location_ex);
        TextView Number = (TextView) rowView.findViewById(R.id.phone_ex);
        TextView Product = (TextView) rowView.findViewById(R.id.product_ex);

        Name.setText(txt1.toString());
        Room.setText(txt2.toString());
        Number.setText(txt3.toString());
        Product.setText(txt4.toString());

*/
/*
        Name.setText(txt1[position]);
        Room.setText(txt2[position]);
        Number.setText(txt3[position]);
        Product.setText(txt4[position]);
*//*


        return rowView;

    };
}

*/
