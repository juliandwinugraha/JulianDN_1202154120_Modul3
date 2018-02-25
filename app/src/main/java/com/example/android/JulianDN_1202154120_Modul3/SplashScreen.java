package com.example.android.JulianDN_1202154120_Modul3;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SplashScreen extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH = 5000;
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent mainIntent = new Intent(SplashScreen.this,MenuLogin.class);
                SplashScreen.this.startActivity(mainIntent);
                SplashScreen.this.finish();
                Toast.makeText(SplashScreen.this,"JULIAN_1202154120_SI3908",Toast.LENGTH_LONG).show();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}