package com.akhilagarwal96.vitfreshers;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class Services extends Fragment {

    ListView ser_list;
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
            R.drawable.ug,
            R.drawable.ambulance,
            R.drawable.ambulance,
            R.drawable.ug,
            R.drawable.building,
            R.drawable.building,
            R.drawable.indianbank,
            R.drawable.laundry,
            R.drawable.dominos,
            R.drawable.papa_johns
    };
    int[] button = {
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
    int j=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_services, container, false);

        final AdapterServices adapter = new AdapterServices(getActivity(),heading,number,img,button);

        ser_list=(ListView)rootView.findViewById(R.id.list_services);

        ser_list.setAdapter(adapter);

        return rootView;
    }

}



