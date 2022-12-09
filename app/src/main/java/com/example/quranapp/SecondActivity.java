package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    QuranData q = new QuranData();
    TextView ayyatDisplay;
    Button btnInc;
    Button btnDec;
    String ayyatno, ayyat;
    Integer ayyatNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ayyatDisplay = findViewById(R.id.txtAyyatDisplay);
        ayyatDisplay.setMovementMethod(new ScrollingMovementMethod());
        btnInc = findViewById(R.id.btnIncrement);
        btnDec = findViewById(R.id.btnDecrement);

        ayyatno = getIntent().getStringExtra("ayyatNo");
        ayyatNo = Integer.parseInt(ayyatno);
        System.out.println(ayyatNo);
        ayyat = q.QuranArabicText[ayyatNo];

        btnInc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ayyatNo = ayyatNo + 1;
                if(ayyatNo < q.QuranArabicText.length) {
                    ayyat = q.QuranArabicText[ayyatNo];
                    ayyatDisplay.setText(ayyat);
                }
                else{
                    ayyat = "You are at the last Verse of Quran";
                    ayyatNo = (q.QuranArabicText.length);
                    ayyatDisplay.setText(ayyat);
                }
            }
        });

        btnDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ayyatNo = ayyatNo - 1;
                if(ayyatNo >= 0) {
                    ayyat = q.QuranArabicText[ayyatNo];
                    ayyatDisplay.setText(ayyat);
                }
                else{
                    ayyat = "You are at the first Verse of Quran";
                    ayyatNo = 0;
                    ayyatDisplay.setText(ayyat);
                }
            }
        });

        ayyatDisplay.setText(ayyat);
    }
}