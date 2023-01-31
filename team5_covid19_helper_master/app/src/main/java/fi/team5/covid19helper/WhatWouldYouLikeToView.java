package fi.team5.covid19helper;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import fi.team5.covid19helper.learnMore.Age18to44;
import fi.team5.covid19helper.learnMore.Age45to64;
import fi.team5.covid19helper.learnMore.Age65AndAbove;
import fi.team5.covid19helper.learnMore.RiskGroup;
import fi.team5.covid19helper.learnMore.Under18;

/**
 * Getting info from LearnMoreActivity that which button user has pressed
 */

public class WhatWouldYouLikeToView extends AppCompatActivity {

    /**
     * @param savedInstanceState
     * Retrieve the number that was saved (check LearnMoreActivity)
     * Using IF statements to assign a number to int test
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int test;
        SharedPreferences prefGet = getSharedPreferences("MyTestPref" ,MODE_PRIVATE);
        if (prefGet.getInt("ageGroup", 0) == 1){
            test = 1;
        } else if (prefGet.getInt("ageGroup", 0) == 2){
            test = 2;
        } else if (prefGet.getInt("ageGroup", 0) == 3){
            test = 3;
        } else if (prefGet.getInt("ageGroup", 0) == 4){
            test = 4;
        } else {
            test = 5;
        }

        /*
         * Using switch statements for the correct page to show up
         * Page - cases from 1 to 5 depending on the preference/button selected in Learn More
         */

        switch (test){
            case 1:
                setContentView(R.layout.whatwouldyouliketoview);
                Button genInfoUnder18 = findViewById(R.id.generalInfoBtn);

                genInfoUnder18.setOnClickListener(v -> {
                    Intent getGenInfoUnder18 = new Intent(getApplicationContext(), Under18.class);
                    startActivity(getGenInfoUnder18);
            });
                goToSymAndPrevInfo();
                break;
            case 2:
                setContentView(R.layout.whatwouldyouliketoview);
                Button genInfo18To44 = findViewById(R.id.generalInfoBtn);

                genInfo18To44.setOnClickListener(v -> {
                    Intent getGenInfo18To44 = new Intent(getApplicationContext(), Age18to44.class);
                    startActivity(getGenInfo18To44);

                });
                goToSymAndPrevInfo();
                break;
            case 3:
                setContentView(R.layout.whatwouldyouliketoview);
                Button genInfo45To64 = findViewById(R.id.generalInfoBtn);

                genInfo45To64.setOnClickListener(v -> {
                    Intent getGenInfo45To64 = new Intent(getApplicationContext(), Age45to64.class);
                    startActivity(getGenInfo45To64);

                });
                goToSymAndPrevInfo();
                break;
            case 4:
                setContentView(R.layout.whatwouldyouliketoview);
                Button genInfo65AndAbove = findViewById(R.id.generalInfoBtn);

                genInfo65AndAbove.setOnClickListener(v -> {
                    Intent getGenInfo65AndAbove = new Intent(getApplicationContext(), Age65AndAbove.class);
                    startActivity(getGenInfo65AndAbove);

                });
                goToSymAndPrevInfo();
                break;
            case 5:
                setContentView(R.layout.whatwouldyouliketoview);
                Button genInfoRiskGroup = findViewById(R.id.generalInfoBtn);

                genInfoRiskGroup.setOnClickListener(v -> {
                    Intent getGenInfoRiskGroup = new Intent(getApplicationContext(), RiskGroup.class);
                    startActivity(getGenInfoRiskGroup);

                });
                goToSymAndPrevInfo();
                break;
        }

    }

    /**
     * Use this for all cases, in symptoms and preventions button onClickListener
     */

    public void goToSymAndPrevInfo() {
        Button symAndPrevBtn = findViewById(R.id.symAndPrevBtn);
        symAndPrevBtn.setOnClickListener(v -> {
            Intent symAndPrevInfo = new Intent(getApplicationContext(), SymptomsAndPreventionsInfo.class);
            startActivity(symAndPrevInfo);
        });
    }



}
