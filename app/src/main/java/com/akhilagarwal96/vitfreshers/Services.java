package com.akhilagarwal96.vitfreshers;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Services extends Fragment {

Button buttons[];

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_services, container, false);

        Button buttons[] = new Button[9];
        buttons[0]=(Button) rootView.findViewById(R.id.button1);
        buttons[1]=(Button) rootView.findViewById(R.id.button2);
        buttons[2]=(Button) rootView.findViewById(R.id.button3);
        buttons[3]=(Button) rootView.findViewById(R.id.button4);
        buttons[4]=(Button) rootView.findViewById(R.id.button5);
        buttons[5]=(Button) rootView.findViewById(R.id.button6);
        buttons[6]=(Button) rootView.findViewById(R.id.button7);
        buttons[7]=(Button) rootView.findViewById(R.id.button8);
        buttons[8]=(Button) rootView.findViewById(R.id.button9);


        return rootView;
    }

}



