package com.akhilagarwal96.vitfreshers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class Resale extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    ImageButton sell, buy;
    ListView ex_list, add_pro_list;
    int i = 0;

    String[] E_name,E_room,E_phone,E_desc;
    EditText Name, Room, Phone, Desc;
    String n, r, p, d;

    Date date = new Date();

    Button submit;

    //Firebase ref = new Firebase("https://vit-freshers-app.firebaseio.com/");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        final View rootView = inflater.inflate(R.layout.activity_resale, container, false);

        final View rootView1 = inflater.inflate(R.layout.activity_add_product, container);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_buy);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference databaseReference = database.getReference("Products/");

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

                submit = (Button) rootView1.findViewById(R.id.sell_submit);

                EditText Name = (EditText) rootView1.findViewById(R.id.sell_name);
                EditText Room = (EditText) rootView1.findViewById(R.id.sell_location);
                EditText Phone = (EditText) rootView1.findViewById(R.id.sell_number);
                EditText Desc = (EditText) rootView1.findViewById(R.id.sell_description);

                n = Name.getText().toString();
                r = Room.getText().toString();
                p = Phone.getText().toString();
                d = Desc.getText().toString();

                final DatabaseReference newProduct = databaseReference.push();

                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        newProduct.child("Date").setValue(date.getTime());

                        newProduct.child("Date").child("Name").setValue(n);
                        newProduct.child("Date").child("Location").setValue(r);
                        newProduct.child("Date").child("Phone").setValue(p);
                        newProduct.child("Date").child("Description").setValue(d);

                        buy = (ImageButton) rootView1.findViewById(R.id.buy_button);
                        buy.setOnClickListener(new View.OnClickListener()

                        {
                            @Override
                            public void onClick(View v) {
                                Intent back = new Intent(getActivity(), Resale.class);
                                startActivity(back);
                                return;
                            }
                        });
                    }
                });
            }
        });
        return rootView;
    }
}