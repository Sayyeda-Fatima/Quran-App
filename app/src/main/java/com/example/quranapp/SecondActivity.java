package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    QuranData q = new QuranData();
    TextView ayyatDisplay;
    String ayyatno, ayyat;
    Integer ayyatNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ayyatDisplay = findViewById(R.id.txtAyyatDisplay);

        ayyatno = getIntent().getStringExtra("ayyatNo");
        ayyatNo = Integer.parseInt(ayyatno);
        System.out.println(ayyatNo);
        ayyat = q.QuranArabicText[ayyatNo];

        ayyatDisplay.setText(ayyat);

    }
}