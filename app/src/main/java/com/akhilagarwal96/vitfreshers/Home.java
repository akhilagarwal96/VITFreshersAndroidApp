package com.akhilagarwal96.vitfreshers;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

public class Home extends Fragment {
    ListView list;
    String[] firstline = {
            "Safari",
            "Camera",
            "Global",
            "FireFox",
            "UC Browser",
            "Android Folder",
            "VLC Player"
    };

    String[] secondline = {
            "Safari",
            "Camera",
            "Global",
            "FireFox",
            "UC Browser",
            "Android Folder",
            "VLC Player"
    };

    Integer[] imgid={
            R.drawable.timeline,
            R.drawable.timeline,
            R.drawable.timeline,
            R.drawable.timeline,
            R.drawable.timeline,
            R.drawable.timeline,
            R.drawable.timeline
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_home, container, false);

        ListAdapterHome adapter = new ListAdapterHome(getActivity(),firstline,secondline,imgid);

        list=(ListView)rootView.findViewById(R.id.list_home);

        Log.e("list",list.toString());
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String first = firstline[+position];
                String second = secondline[+position];

            }
        });

        return rootView;
    }
}
