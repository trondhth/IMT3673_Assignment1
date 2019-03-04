package com.example.assignment1;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;

import java.io.Serializable;

@SuppressLint("Registered")
public class transactions extends AppCompatActivity implements Serializable {
    public String time;
    public String name;
    public String amount;

    // Each object prints out it's own data.
    @Override
    public String toString() {
        return time  + "     |     "   + name + "     |     " +  amount + "     |     " + current;
    }

    public String current;

    public transactions(String t, String n, String a, String c){
        time= t;
        name = n;
        amount = a;
        current = c;
    }
}