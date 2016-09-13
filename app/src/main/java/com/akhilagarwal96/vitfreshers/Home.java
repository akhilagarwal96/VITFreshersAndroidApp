package com.akhilagarwal96.vitfreshers;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class Home extends Fragment {

    ListView list;
    String[] firstline = {
            "Commencement",
            "CAT 1",
            "CAT 2",
            "Last Instructional Day",
            "FAT",
            "Holidays",
            "Other Holidays"
    };
    String[] secondline = new String[7];
    Integer[] imgid={
            R.drawable.timeline,
            R.drawable.timeline,
            R.drawable.timeline,
            R.drawable.timeline,
            R.drawable.timeline,
            R.drawable.timeline,
            R.drawable.timeline,

    };
/*

    Handler handler = new Handler();
    Runnable refresh;

*/
    TextView txt1;
    Firebase ref = new Firebase("https://vit-freshers-app.firebaseio.com/");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        ref.child("Title/Title For Calendar").addValueEventListener(new ValueEventListener() {
            @Override

            public void onDataChange(DataSnapshot snapshot) {
                String x = (String) snapshot.getValue();
                txt1.setText(x);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
        ref.child("Calendar/Data/Beginning").addValueEventListener(new ValueEventListener() {
                    @Override

                    public void onDataChange(DataSnapshot snapshot) {
                        String y1 = (String) snapshot.getValue();
                        secondline[0] = y1;
                    }
                    @Override
                    public void onCancelled(FirebaseError firebaseError) {

                    }

                });
        ref.child("Calendar/Data/CAT 1").addValueEventListener(new ValueEventListener() {
            @Override

            public void onDataChange(DataSnapshot snapshot) {
                String y2 = (String) snapshot.getValue();
                secondline[1]=y2;

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }

        });
        ref.child("Calendar/Data/CAT 2").addValueEventListener(new ValueEventListener() {
            @Override

            public void onDataChange(DataSnapshot snapshot) {
                String y3 = (String) snapshot.getValue();
                secondline[2]=y3;

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }

        });
        ref.child("Calendar/Data/CAT Last Instructional Day").addValueEventListener(new ValueEventListener() {
            @Override

            public void onDataChange(DataSnapshot snapshot) {
                String y4 = (String) snapshot.getValue();
                secondline[3] = y4;
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }

        });
        ref.child("Calendar/Data/FAT").addValueEventListener(new ValueEventListener() {
            @Override

            public void onDataChange(DataSnapshot snapshot) {
                String y5 = (String) snapshot.getValue();
                secondline[4]=y5;
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }

        });
        ref.child("Calendar/Data/Holidays (Diwali, Holi)").addValueEventListener(new ValueEventListener() {
            @Override

            public void onDataChange(DataSnapshot snapshot) {
                String y6 = (String) snapshot.getValue();
                secondline[5]=y6;
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }

        });
        ref.child("Calendar/Data/Other Holidays").addValueEventListener(new ValueEventListener() {
            @Override

            public void onDataChange(DataSnapshot snapshot) {
                String y7 = (String) snapshot.getValue();
                secondline[6] = y7;

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }

        });

        /*refresh = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(refresh,5000);
            }

       };*/
        final View rootView = inflater.inflate(R.layout.activity_home, container, false);

        final ListAdapterHome adapter = new ListAdapterHome(getActivity(),firstline,secondline,imgid);

        list=(ListView)rootView.findViewById(R.id.list_home);

        list.setAdapter(adapter);

        txt1 = (TextView) rootView.findViewById(R.id.textView3);

        return rootView;
    }
}
