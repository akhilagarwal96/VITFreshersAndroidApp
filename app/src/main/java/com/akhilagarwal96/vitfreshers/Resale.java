package com.akhilagarwal96.vitfreshers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;

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

    ImageButton sell, buy;
    ListView ex_list, add_pro_list;
    int i = 0;

    String[] E_name = {"a","c"};
    String[] E_room = {"a","c"};
    String[] E_phone = {"a","c"};
    String[] E_desc = {"a","c"};
    ArrayList<DataProviderExchange> arrayList = new ArrayList<DataProviderExchange>();

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {


        final View rootView = inflater.inflate(R.layout.activity_resale, container, false);

        final View rootView1 = inflater.inflate(R.layout.activity_add_product, container);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_buy);

        int i = 0;

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference databaseReference = database.getReference("Products/");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String x = "Products/" + dataSnapshot.getKey();
                Log.d("qwerty",x);
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