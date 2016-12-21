package com.akhilagarwal96.vitfreshers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;
import java.util.List;

public class Resale extends Fragment {

    ImageButton sell, buy;
    ListView ex_list, add_pro_list;
    int i = 0;
/*
    String[] text1 = new String[20];
    String[] text2 = new String[20];
    String[] text3 = new String[20];
    String[] text4 = new String[20];
*/

    List<String> txt1 = new ArrayList<String>();
    List<String> txt2 = new ArrayList<String>();
    List<String> txt3 = new ArrayList<String>();
    List<String> txt4 = new ArrayList<String>();

    Button submit;

    EditText Name, Room, Phone, Desc;
    String n, r, p, d;

    Firebase ref = new Firebase("https://vit-freshers-app.firebaseio.com/");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.activity_resale, container, false);

        final View rootView1 = inflater.inflate(R.layout.activity_add_product, container);

        AdapterExchange adapter_ex = new AdapterExchange(getActivity(), txt1, txt2, txt3, txt4);

        ex_list = (ListView) rootView.findViewById(R.id.list_ex);

        ex_list.setAdapter(adapter_ex);

        //AdapterAddProduct adapterAddProduct = new AdapterAddProduct(getActivity(),txt_name,txt_room,txt_phone,txt_desc);

        ref.child("Products").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                final String x = "Products/" + dataSnapshot.getKey() + "/";

                ref.child(x).addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot1, String s) {

                        String y = x + (dataSnapshot1.getKey());

                        ref.child(y).addChildEventListener(new ChildEventListener() {
                            int index = 1;

                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot2, String s) {

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

                            @Override
                            public void onChildChanged(DataSnapshot dataSnapshot2, String s) {

                            }

                            @Override
                            public void onChildRemoved(DataSnapshot dataSnapshot2) {

                            }

                            @Override
                            public void onChildMoved(DataSnapshot dataSnapshot2, String s) {

                            }

                            @Override
                            public void onCancelled(FirebaseError firebaseError) {

                            }
                        });
                    }

                    @Override
                    public void onChildChanged(DataSnapshot dataSnapshot1, String s) {

                    }

                    @Override
                    public void onChildRemoved(DataSnapshot dataSnapshot1) {

                    }

                    @Override
                    public void onChildMoved(DataSnapshot dataSnapshot1, String s) {

                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {

                    }
                });
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

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


            /*

            submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    private void writeNewPost(String n, String r, String p, String d) {
                // Create new post at /user-posts/$userid/$postid and at
                // /posts/$postid simultaneously
                String key = ref.child("Products").push().getKey();
*//*                  Post post = new Post(n,r,p,d);
                    Map<String, Object> postValues = post.toMap();

                    Map<String, Object> childUpdates = new HashMap<>();
                    childUpdates.put("/posts/" + key, postValues);
                    childUpdates.put("/user-posts/" + userId + "/" + key, postValues);

                    ref.updateChildren(childUpdates);
 *//*
            }*/
                /*
                        if (n == "" || l == "" || no == "" || d == "") {
                            AlertDialog empty = new AlertDialog.Builder(getContext()).create();
                            empty.setTitle("Oops! Your product cannot be added");
                            empty.setMessage("Please fill in the details");
                            empty.setButton("Back", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                        }
                        else {

                            //ref.child("Products").setValue("Do you have data? You'll love Firebase.");

                            AlertDialog submitted = new AlertDialog.Builder(getContext()).create();
                            submitted.setTitle("Submitted!");
                            submitted.setMessage("Your product has been successfully added");
                            submitted.setButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                    //Resale.this.getActivity().finish();
                                }
                            });
                            submitted.show();
                        }
                    }
                });*/

                buy = (ImageButton) rootView.findViewById(R.id.buy_button);
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

        return rootView;
    }
}