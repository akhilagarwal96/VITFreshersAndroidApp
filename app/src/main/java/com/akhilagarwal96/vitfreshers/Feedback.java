package com.akhilagarwal96.vitfreshers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.firebase.client.Firebase;

public class Feedback extends Fragment {


    ImageButton imageButton;
    Spinner spinnerOption;
    EditText feedback;

    String[] Sugestions = new String[]{
            "Have an issue",
            "Report a bug",
            "Ask question"
    };

    Firebase myFirebaseRef = new Firebase("https://vit-freshers.firebaseio.com/");


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_feedback, container, false);

        imageButton = (ImageButton) rootView.findViewById(R.id.submit);
        spinnerOption = (Spinner) rootView.findViewById(R.id.spinner_option);
        feedback = (EditText) rootView.findViewById(R.id.feedback);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subject = String.valueOf(spinnerOption.getSelectedItem());
                Intent email = new Intent(Intent.ACTION_SEND);
                String message = feedback.getText().toString();
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"appledevlopersgroup@gmail.com"});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);
//need this to prompts email client only
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email client :"));
            }
        });

        return rootView;
    }
}


