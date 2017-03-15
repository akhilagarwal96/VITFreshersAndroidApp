
package com.akhilagarwal96.vitfreshers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class AddProduct extends AppCompatActivity{

  //  Firebase ref = new Firebase("https://vit-freshers-app.firebaseio.com/");

    EditText name,location,number,desc;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        name = (EditText) findViewById(R.id.sell_name);
        location = (EditText) findViewById(R.id.sell_location);
        number = (EditText) findViewById(R.id.sell_number);
        desc = (EditText) findViewById(R.id.sell_description);

        submit = (Button) findViewById(R.id.sell_submit);

    }
}
/*
    private RelativeLayout layout_buy;
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

                    //ref.child("Products").setValue("Do you have data? You'll love Firebase.");

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

        layout_buy = (RelativeLayout) rootView.findViewById(R.id.sell_cards);
        resale_home = (Button) rootView.findViewById(R.id.sell_button);
        resale_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               layout_buy.setVisibility(RelativeLayout.VISIBLE);
            }
        });
        return rootView;
    }


}*/
