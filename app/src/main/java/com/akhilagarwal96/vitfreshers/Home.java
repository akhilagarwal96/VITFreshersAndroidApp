package com.akhilagarwal96.vitfreshers;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Home extends Fragment {

    ListView list;

    String[] firstline = {"Commencement", "CAT 1", "CAT 2", "Last Instructional Day", "FAT", "Holidays", "Other Holidays"};
    String[] secondline = new String[7];
    Integer[] imgid={
            R.drawable.timeline,
            R.drawable.timeline,
            R.drawable.timeline,
            R.drawable.timeline,
            R.drawable.timeline,
            R.drawable.timeline,
            R.drawable.timeline
    };
    String[] str = {"Beginning","CAT 1","CAT 2","CAT Last Instructional Day", "FAT","Holidays (Diwali, Holi)","Other Holidays"};
    TextView txt1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.activity_home, container, false);

        final AdapterHome adapter = new AdapterHome(getActivity(),firstline,secondline,imgid);

        list=(ListView)rootView.findViewById(R.id.list_home);

        list.setAdapter(adapter);
        txt1 = (TextView) rootView.findViewById(R.id.Calendar_Heading);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("Title/Title For Calendar");
        DatabaseReference ref1 = database.getReference("Calendar/Data");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String x = (String) dataSnapshot.getValue();
                txt1.setText(x);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        ref1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot1) {
                for (int i = 0; i < 7; i++) {
                    String x = (String) dataSnapshot1.child(str[i]).getValue();
                    Log.d("Show", x);
                    secondline[i] = x;
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return rootView;
    }
}
