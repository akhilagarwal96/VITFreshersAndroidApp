package com.akhilagarwal96.vitfreshers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Resale extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    ImageButton sell;

    int i = 0;

    String[] E_name = {"a","e"};
    String[] E_room = {"b","f"};
    String[] E_phone = {"c","g"};
    String[] E_desc = {"d","h"};
    String name,room,phone,desc;

    ArrayList<DataProviderExchange> arrayList = new ArrayList<DataProviderExchange>();

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.activity_resale, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_buy);

/*
        int i = 0;
        for (String name: E_name)
        {
            DataProviderExchange dataProviderExchange = new DataProviderExchange(E_name[i],E_room[i],E_phone[i],E_desc[i]);
            arrayList.add(dataProviderExchange);
            i++;
        }
*/

        adapter = new RecyclerAdapterExchange(arrayList);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference databaseReference = database.getReference("Products/");

        DatabaseReference ref = database.getReference("Title/Title For Calendar");

        final DataProviderExchange dataProviderExchange1 = new DataProviderExchange(name,room,phone,desc);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String x = (String) dataSnapshot.getValue();
                dataProviderExchange1.setT_room(x);
                dataProviderExchange1.setT_name("dsfsf");
                arrayList.add(dataProviderExchange1);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
/*
        databaseReference.child("Products").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                final String x = "Products/" + dataSnapshot.getKey() + "/";
                databaseReference.child(x).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot1) {
                        String y = x + (dataSnapshot1.getKey());
                        databaseReference.child(y).addValueEventListener(new ValueEventListener() {
                            int index = 1;

                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot2) {
                                if (index == 1) {
                                    String a = (String) dataSnapshot2.getValue();
                                    txt4.add(a);
                                    txt4.add("**");
                                    System.out.println(txt4);
                                }
                                if (index == 2) {
                                    String b = (String) dataSnapshot2.getValue();
                                    txt2.add(b);
                                    txt2.add("**");
                                }
                                if (index == 3) {
                                    String c = (String) dataSnapshot2.getValue();
                                    txt3.add(c);
                                    txt3.add("**");
                                }
                                if (index == 4) {
                                    String d = (String) dataSnapshot2.getValue();
                                    txt1.add(d);
                                    txt1.add("**");
                                    i = i + 1;
                                }
                                index = index + 1;
                            }
                        });
                        @Override
                        public void onCancelled (DatabaseError databaseError){
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                }
*/

        sell = (ImageButton) rootView.findViewById(R.id.sell_button);
        sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sell_intent = new Intent(Resale.this.getActivity(), AddProduct.class);
                startActivity(sell_intent);

            }
        });
        return rootView;
    }
}