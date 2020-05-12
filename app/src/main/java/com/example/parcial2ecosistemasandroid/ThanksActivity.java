package com.example.parcial2ecosistemasandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class ThanksActivity extends AppCompatActivity {

    private Button volverBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanks);

        volverBtn = findViewById(R.id.volverBtn);

        volverBtn.setOnClickListener(
                (v) -> {
                    finish();
                }
        );
    }
}
