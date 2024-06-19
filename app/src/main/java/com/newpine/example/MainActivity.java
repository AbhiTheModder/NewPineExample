package com.newpine.example;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.annotation.NonNull;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        TextView tv = new TextView(this);
        tv.setGravity(Gravity.CENTER);
        tv.setTextSize(20);
        if (isPro()) {
            tv.setText("Pro");
        } else {
            tv.setText("Free");
        }

        setContentView(tv);
    }

    public boolean isPro() {
        return false;
    }
}