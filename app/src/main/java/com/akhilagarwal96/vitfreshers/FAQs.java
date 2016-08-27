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

public class FAQs extends Fragment{

    ListView list1;
    String[] text1 = new String[20];
    String[] text2 = new String[20];
    int i=0;



    Firebase ref = new Firebase("https://vit-freshers.firebaseio.com/");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_faqs, container, false);

        ListAdapterFAQ adapter1 = new ListAdapterFAQ(getActivity(),text1,text2);

        list1 = (ListView)rootView.findViewById(R.id.list_faq);

        list1.setAdapter(adapter1);


        ref.child("FAQ").addChildEventListener(new ChildEventListener() {


            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                String x1 = "FAQ/" + (dataSnapshot.getKey());


                ref.child(x1).addChildEventListener(new ChildEventListener() {
                    int index = 1;

                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot2, String s) {


                        if (index == 1) {
                            String z1 = (String) dataSnapshot2.getValue();
                            text1[i] = z1;

                        }
                        if (index == 2) {
                            String z2 = (String) dataSnapshot2.getValue();
                            text2[i] = z2;

                        }
                        i = i + 1;
                        index = index + 1;

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