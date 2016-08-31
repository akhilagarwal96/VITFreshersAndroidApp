package com.akhilagarwal96.vitfreshers;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

public class Services extends Fragment {

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
    ListView ser_list;
    int[] buttons = {
            R.drawable.phone,
            R.drawable.phone,
            R.drawable.phone,
            R.drawable.phone,
            R.drawable.phone,
            R.drawable.phone,
            R.drawable.phone,
            R.drawable.phone,
            R.drawable.phone,
            R.drawable.phone,
    };
    String[] heading={
            "VIT",
            "Health Centre",
            "Health Centre",
            "UG Admissions",
            "Boys Hostel",
            "Girls Hostel",
            "Indian Bank",
            "Nate Laundry",
            "Dominos",
            "Papa Johns"
    };
    String[] number= {
            "+914162243091",
            "+914162202000",
            "+914162202217",
            "04162240005",
            "04162202127",
            "04162202719",
            "+914162202157",
            "08940212621",
            "04162244445",
            "04164202222"
    };
    Integer[] img = {
            R.drawable.vit,
            R.drawable.hc,
            R.drawable.hc,
            R.drawable.ugao,
            R.drawable.bh,
            R.drawable.lh,
            R.drawable.indianbank,
            R.drawable.nate,
            R.drawable.dominos,
            R.drawable.papa_johns
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_services, container, false);

        final ListAdapterServices adapter = new ListAdapterServices(getActivity(),heading,number,img,buttons);

        ser_list=(ListView)rootView.findViewById(R.id.list_services);

        ser_list.setAdapter(adapter);

        int i=0;

        Button b1=(Button)rootView.findViewById(R.id.ser_button);
        /*b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call_1 = new Intent(Intent.ACTION_DIAL);
                String p = "tel:" + number[1];
                call_1.setData(Uri.parse(p));
                startActivity(call_1);
            }
        });
        */
        return rootView;
    }

}



