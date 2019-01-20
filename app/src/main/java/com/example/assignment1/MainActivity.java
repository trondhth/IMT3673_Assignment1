package com.example.assignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        Button button = findViewById(R.id.app_logo);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transferActivity();
            }
        });
        */
    }

    public void transferActivity() {
        Intent intent = new Intent(this, AnotherActivity.class);
        startActivity(intent);
    }
}
