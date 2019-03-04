package com.example.assignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

/*
public class TransactionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactions);
    }
}
*/

public class TransactionsActivity extends AppCompatActivity {
    private TextView balance_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactions);
        balance_text = (TextView)findViewById(R.id.lbl_balance2);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        //String test = (String) bundle.describeContents();
        //balance_text.setText(test);

        if(bundle != null) {
            int j = bundle.getInt("Balance");
            balance_text.setText(Integer.toString(j));
            //Log.d("martin", j);
        }
    }
}