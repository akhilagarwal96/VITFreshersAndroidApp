
package com.akhilagarwal96.vitfreshers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddProduct extends AppCompatActivity{

  //  Firebase ref = new Firebase("https://vit-freshers-app.firebaseio.com/");

    EditText name,location,number,desc;
    Button submit;
    ImageButton buy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference databaseReference = database.getReference("Products/");

        name = (EditText) findViewById(R.id.sell_name);
        location = (EditText) findViewById(R.id.sell_location);
        number = (EditText) findViewById(R.id.sell_number);
        desc = (EditText) findViewById(R.id.sell_description);

        submit = (Button) findViewById(R.id.sell_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddProduct.this, "Hello", Toast.LENGTH_SHORT).show();

                SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");

                String currentDate = DateFormat.getDateInstance().format(new Date());
                Log.d("Checking Date",currentDate);
                databaseReference.child(currentDate);

                DatabaseReference databaseReference1 = databaseReference.child(currentDate).push();

                databaseReference1.child("Seller Name").setValue(name.getText().toString());
                databaseReference1.child("Location").setValue(location.getText().toString());
                databaseReference1.child("Seller Contact").setValue(number.getText().toString());
                databaseReference1.child("Description").setValue(desc.getText().toString());
                databaseReference1.child("Verification Tag").setValue("N");
            }
        });

        buy = (ImageButton) findViewById(R.id.buy_button);
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
