package com.akhilagarwal96.vitfreshers;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class FAQs extends Fragment{

    ListView list1;
    String[] text1={};
    String[] text2={};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_faqs, container, false);

        

        return rootView;
    }
}