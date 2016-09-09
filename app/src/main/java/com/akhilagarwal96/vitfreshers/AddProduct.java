package com.akhilagarwal96.vitfreshers;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class AddProduct extends Fragment {

    Button submit,resale_home;
    EditText name,location,number,desc;
    String n,l,no,d;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_resale, container, false);

        name = (EditText) rootView.findViewById(R.id.sell_name);
        location = (EditText) rootView.findViewById(R.id.sell_location);
        number = (EditText) rootView.findViewById(R.id.sell_number);
        desc = (EditText) rootView.findViewById(R.id.sell_description);

        n = name.getText().toString();
        l = location.getText().toString();
        no = number.getText().toString();
        d = desc.getText().toString();

        submit = (Button) rootView.findViewById(R.id.sell_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                    AlertDialog submitted = new AlertDialog.Builder(getContext()).create();
                    submitted.setTitle("Submitted!");
                    submitted.setMessage("Your product has been successfully added");
                    submitted.setButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            AddProduct.this.getActivity().finish();
                        }
                    });
                    submitted.show();
                }
            }
        });

        resale_home = (Button) rootView.findViewById(R.id.sell_button);
        resale_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent ex_home = new Intent(this,Resale.class);

            }
        });
        return rootView;
    }


}
