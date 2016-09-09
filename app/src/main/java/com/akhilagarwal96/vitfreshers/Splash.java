package com.akhilagarwal96.vitfreshers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends Activity {

    protected boolean _active = true;
    protected int _splashTime = 3500;
    /* Called when the activity is first created. */

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
        public void run() {

            finish();
            Intent i_splash = new Intent(Splash.this, MainActivity.class);
            startActivity(i_splash);
        }
        }, _splashTime);

    }

}
