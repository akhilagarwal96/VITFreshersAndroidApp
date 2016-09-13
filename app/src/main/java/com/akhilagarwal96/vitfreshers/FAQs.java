package com.akhilagarwal96.vitfreshers;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.firebase.client.Firebase;

public class FAQs extends Fragment{

    ListView list1;
    String[] text1 = {
            "What is FFCS?",
            "What are the attendance constraints?",
            "How and When do I need to apply for a leave?",
            "How can I access the Library after 9 pm?",
            "What is the procedure for mess change?",
            "What is the procedure to register for Physical Education?"
    };
    String[] text2 = {
            "FFCS is \"Fully Flexible Credit System\". Each course you take under FFCS has a fixed credit number. You need to complete 180 credits in total to attain a B.Tech degree.",
            "A minimum of 75% attendance is required in theory classes to attend all exams. Also, if you miss a Lab, only 75% of that day's assignment marks will be considered.",
            "A leave is required when you are out of campus for more than a night. You can send an online request to your FA directly through Student Login.",
            "Freshers (Men) are not allowed inside the library after 9 pm until and unless they have a signed permission from their Faculty Advisor.",
            "Mess can be changed once a month by paying the difference online or by DD. Mess change link is usually available in Student Login during the last week of every month.",
            "VIT offers a great number of Physical Education facilities including Squash, Swimming, Badminton, Gym and more. Registration to any of these can be done online through the Student Login."
    };
    int i=0;



    Firebase ref = new Firebase("https://vit-freshers-app.firebaseio.com/");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_faqs, container, false);

        ListAdapterFAQ adapter1 = new ListAdapterFAQ(getActivity(),text1,text2);

        list1 = (ListView)rootView.findViewById(R.id.list_faq);

        list1.setAdapter(adapter1);


     /*  ref.child("FAQ").addChildEventListener(new ChildEventListener() {


            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                String x1 = "FAQ/" + (dataSnapshot.getKey());


                ref.child(x1).addChildEventListener(new ChildEventListener() {
                    int index = 1;

                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot2, String s) {


                        if (index == 1) {
                            String z1 = (String) dataSnapshot2.getValue();
                            text2[i] = z1;

                        }
                        if (index == 2) {
                            String z2 = (String) dataSnapshot2.getValue();
                            text1[i] = z2;
                            i = i + 1;
                        }
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
     */   return rootView;
    }
}