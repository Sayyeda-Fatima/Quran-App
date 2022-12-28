package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    String currentDateTimeString = java.text.DateFormat.getDateTimeInstance().format(new Date());
    TextView date;
    EditText ayyatnumber;
    Button searchBtn;
    QuranData q = new QuranData();
    String [] surah;
    Integer surahStartingAyyat;
    Integer nextSurahStartingAyyat;
    ArrayAdapter<String> adpt;
    Spinner surahDropDown;
    int idOfSelectedSurah;
    int ayyatToBeDiaplayed;
    TextView validAyyat;
    String ayyatNo = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        date = findViewById(R.id.txtDateTime);
        date.setText(currentDateTimeString);

        surah = q.urduSurahNames;

        adpt = new ArrayAdapter<String>(this,  R.layout.spinner_item, surah);

        surahDropDown = findViewById(R.id.spinnerSurahName);

        surahDropDown.setAdapter(adpt);

        ayyatnumber = (EditText) findViewById(R.id.txtAyyatInput);
        searchBtn = findViewById(R.id.btnSearch);
        validAyyat = findViewById(R.id.txtValid);

        surahDropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                idOfSelectedSurah = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validAyyat.setText("");
                if (ayyatnumber.getText().toString().trim().length() > 0){

                    surahStartingAyyat = q.SSP[idOfSelectedSurah];
                    if(idOfSelectedSurah < 113) {
                        nextSurahStartingAyyat = q.SSP[idOfSelectedSurah + 1];
                    }
                    else{
                        nextSurahStartingAyyat = q.QuranArabicText.length + 1;
                    }

                    ayyatToBeDiaplayed = surahStartingAyyat + Integer.parseInt(ayyatnumber.getText().toString());

                    if(ayyatToBeDiaplayed< nextSurahStartingAyyat){
                        Intent i = new Intent(MainActivity.this, SecondActivity.class);
                        i.putExtra("ayyatNo", Integer.toString(ayyatToBeDiaplayed-1));
                        startActivity(i);
                    }
                    else {
                        validAyyat.setText("Please give a valid ayyat number!");
                    }
                }
                else {
                    validAyyat.setText("Please give a valid ayyat number!");
                }
            }
        });
    }
}