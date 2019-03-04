package com.example.assignment1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    public static final String TRANSFER_OBJECT = "obj";
    public static final int RESULT_CODE_TRANSFER = 0;
    public static final String TRANSFER_CURRENT = "current";
    public static final String TRANSFER_AMOUNT = "amount";
    public static final String TRANSFER_NAME = "name";
    public static final String TRANSFER_TIME = "time";
    public static final String ARRAY = "array";
    public static final int MIN = 90;
    public static final int MAX = 110;

    ArrayList<transactions> transactions = new ArrayList<>();



    private TextView balance_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Storing a random int between MIN(90) and MAX(110) in variable 'balance'
        // and sending it into the label 'lbl_balance' to display on the screen.
        final int balance = init_balance();
        this.balance_text = (TextView) findViewById(R.id.lbl_balance);
        balance_text.setText(String.valueOf(balance));

        // Creating button linking to transactions page.
        Button button_transactions = findViewById(R.id.btn_transactions);
        button_transactions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TransactionsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable(ARRAY, transactions);
                intent.putExtra("Balance", balance);
                startActivity(intent);
            }
        });

        // Creating button linking to transfer page.
        Button button_transfer = findViewById(R.id.btn_transfer);
        button_transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TransferActivity.class);
                final float balance_float = Float.parseFloat(balance_text.getText().toString());
                intent.putExtra("Balance", balance);
                startActivityForResult(intent, 0);
            }
        });

    }

    // Initializing the account balance, range [MIN, MAX].
    public int init_balance() {
        Random r = new Random();
        return r.ints(1, MIN, MAX+1).findFirst().getAsInt();
    }

}

