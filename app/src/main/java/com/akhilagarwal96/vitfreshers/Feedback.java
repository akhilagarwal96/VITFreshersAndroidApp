package com.akhilagarwal96.vitfreshers;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.firebase.client.Firebase;

import static com.akhilagarwal96.vitfreshers.R.layout;

public class Feedback extends Fragment implements AdapterView.OnItemSelectedListener {

    Button button_submit;
    Spinner spinnerOption;
    EditText feedback;

    String emailID = "appledevelopersgroup@gmail.com";
    Firebase ref = new Firebase("https://vit-freshers-app.firebaseio.com/");
    private Window window;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(layout.activity_feedback, container, false);

        button_submit = (Button) rootView.findViewById(R.id.submit);
        feedback = (EditText) rootView.findViewById(R.id.feedback);
        spinnerOption = (Spinner) rootView.findViewById(R.id.spinner_option);

        spinnerOption.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ((TextView) adapterView.getChildAt(0)).setGravity(Gravity.CENTER_HORIZONTAL);
                ((TextView) adapterView.getChildAt(0)).setTextColor(Color.WHITE);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String subject = String.valueOf(spinnerOption.getSelectedItem());
                String message = feedback.getText().toString();
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", emailID, null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,
                        subject);
                emailIntent.putExtra(Intent.EXTRA_TEXT,
                        message);
                startActivity(Intent.createChooser(emailIntent, "Choose Client"));
            }
        });

        /*if (feedback.getText().toString().matches("")) {
            AlertDialog empty = new AlertDialog.Builder(getContext()).create();
            empty.setTitle("Incomplete!");
            empty.setMessage("Please fill in the details");
            empty.setButton("Back", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }

            });


        else {
           button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String subject = String.valueOf(spinnerOption.getSelectedItem());
                String message = feedback.getText().toString();
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", emailID, null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,
                        subject);
                emailIntent.putExtra(Intent.EXTRA_TEXT,
                        message);
                startActivity(Intent.createChooser(emailIntent, "Choose Client"));
            }
        }); */


       return rootView;
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}


