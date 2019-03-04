package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Objects;

public class TransactionsActivity<transactions> extends AppCompatActivity {

    private RecyclerView rec;
    private RecyclerView.LayoutManager layoutManager;
    private Recycler adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactions);

        rec = findViewById(R.id.lbl_transactions);
        layoutManager = new LinearLayoutManager(this);
        rec.setLayoutManager(layoutManager);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        ArrayList<transactions> transactions = (ArrayList<transactions>) Objects.requireNonNull(bundle).getParcelableArrayList(ARRAY);

        ArrayList<String> printOut = new ArrayList<>();
        assert transactions != null;
        for (int j = 0; j < transactions.size(); j++) {
            printOut.add(transactions.get(j).toString().replace(",", "").replace("[", "").replace("]", "").trim());
        }
        adapter = new Recycler(printOut);

        adapter.setOnItemClickListener(new Recycler.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Log.d("onItemClick", Integer.toString(position));
            }

            @Override
            public void onItemLongClick(int position, View v) {
                Log.d("onItemLongClick", Integer.toString(position));
            }
        });
        rec.setHasFixedSize(true);
        rec.setAdapter(adapter);


    }
}