package com.akhilagarwal96.vitfreshers;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

public class Resale extends Fragment{

    ListView ex_list;
    int i=0;
    String[] text1 = new String[10];
    String[] text2 = new String[10];
    String[] text3 = new String[10];
    String[] text4 = new String[10];


    Firebase ref = new Firebase("https://vit-freshers-app.firebaseio.com/");

    @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.activity_resale, container, false);

        ListAdapterExchange adapter_ex = new ListAdapterExchange(getActivity(), text1, text2, text3, text4);

        ex_list = (ListView)rootView.findViewById(R.id.list_ex);

        ex_list.setAdapter(adapter_ex);

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
                                    text4[i] = a;
                                }
                                if (index == 2) {
                                    String b = (String) dataSnapshot2.getValue();
                                    text2[i] = b;
                                }

                                if (index == 3) {
                                    String c = (String) dataSnapshot2.getValue();
                                    text3[i] = c;
                                }

                                if (index == 4) {
                                    String d = (String) dataSnapshot2.getValue();
                                    text1[i] = d;
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

        return rootView;
        }
}

