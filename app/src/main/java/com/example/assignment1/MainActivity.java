package com.example.assignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Calling function to initialize account balance.
        init_balance();

        // Creating button linking to transactions page.
        Button button_transactions = findViewById(R.id.btn_transactions);
        button_transactions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transactionActivity();
            }
        });

        // Creating button linking to transfer page.
        Button button_transfer = findViewById(R.id.btn_transfer);
        button_transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transferActivity();
            }
        });

    }


    // Starting activity 'TransactionActivity' when button btn_transactions is pressed.
    public void transactionActivity() {
        Intent intent = new Intent(this, TransactionsActivity.class);
        startActivity(intent);
    }

    // Starting activity 'TransferActivity' when button btn_transfer is pressed.
    public void transferActivity() {
        Intent intent = new Intent(this, TransferActivity.class);
        startActivity(intent);
    }

    // Initializing the account balance, range [90, 110].
    public void init_balance() {
        Random r = new Random();
        int balance = r.ints(1, 90, 111).findFirst().getAsInt();
        //int balance = ThreadLocalRandom.current().nextInt(90, 110+1);
        final TextView balance_text = (TextView) findViewById(R.id.lbl_balance);
        balance_text.setText(String.valueOf(balance));
    }
}
