package com.example.finalproject;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Chicken extends AppCompatActivity {
    //******************Start of chicken stuff *******************************************************
    public void loadChickenSounds(View v){
        setContentView(R.layout.chickensounds);
        loadUIChicken();
        loadAnimationsChicken();

        Button chickenCluck = (Button) findViewById(R.id.chickenSoundOne);
        Button chickenCrow = (Button) findViewById(R.id.chickenSoundTwo);
        Button chickenBaby = (Button) findViewById(R.id.chickenSoundThree);

        chickenCrow.setOnClickListener(this);
        chickenCluck.setOnClickListener(this);
        chickenBaby.setOnClickListener(this);

    }


    public void loadChickenPictures(View v){

        //This is the chicken page
        setContentView(R.layout.chicken_pictures);

    }

    public void loadChickenFacts(View v){

        //This is the chicken page
        setContentView(R.layout.chicken_facts);

    }

    public void loadFoodChicken(View v){
        setContentView(R.layout.chickens_dos_donts);
    }

    public void loadChickenQuiz(View v){

        setContentView(R.layout.chicken_quiz);
    }

    //changing the text depending on what is in the array.
    public void changeTextChicken(View v) {
        TextView facts = (TextView)findViewById(R.id.factsChickenView);

        facts.setText("" + chickenFacts[j]);
        j++;

        //reset the i variable so we can loop through the array again
        if (j == 10)
        {
            j = 0;
        }

    }

    public void chickenQuizTrue(View v)
    {
        switch (v.getId()){

            //if question one, correct
            case R.id.buttonTrueTwoChicken:
                v.setBackgroundColor(Color.parseColor("#FF03DAC5"));
                correctChicken++;

                break;

            case R.id.buttonTrueFourChicken:
                v.setBackgroundColor(Color.parseColor("#FF03DAC5"));
                break;

            case R.id.buttonTrueThreeChicken:
                v.setBackgroundColor(Color.parseColor("#FF03DAC5"));
                correctChicken++;
                break;

        }


    }

    public void chickenQuizFalse(View v)
    {

        switch (v.getId()){

            //if question one, correct
            case R.id.buttonFalseTwoChicken:
                v.setBackgroundColor(Color.parseColor("#FF03DAC5"));
                break;

            case R.id.buttonFalseFourChicken:
                v.setBackgroundColor(Color.parseColor("#FF03DAC5"));
                correctChicken++;
                break;

            case R.id.buttonFalseThreeChicken:
                v.setBackgroundColor(Color.parseColor("#FF03DAC5"));
                break;

        }

    }

    public void quizResultsChicken(View v){

        EditText answer = findViewById(R.id.editTextAnswer);
        String results = answer.getText().toString();
        String correctAnswerChicken = "pullet";
        //Toast.makeText(this, "You got " + results + " TEst!", Toast.LENGTH_SHORT).show();
        if (results.equals((correctAnswerChicken)))
        {
            correctChicken++;
        }

        // Your code goes here
        Toast.makeText(this, "You got " + correctChicken + " answers correct!", Toast.LENGTH_SHORT).show();
        //results.setText("You got " + correct + " correct!");

        //reset colors, text box, and radio button
        correctChicken = 0;
        final EditText userEntry = (EditText) findViewById(R.id.editTextAnswer);
        userEntry.setText("");

        RadioButton radioTwelve = (RadioButton) findViewById(R.id.radioButtonTwelve);
        radioTwelve.setChecked(false);

        RadioButton radioOne = (RadioButton) findViewById(R.id.radioButtonOne);
        radioOne.setChecked(false);

        RadioButton radioThree = (RadioButton) findViewById(R.id.radioButtonThree);
        radioThree.setChecked(false);

        RadioButton radioFiveThousand = (RadioButton) findViewById(R.id.radioButtonFiveThousand);
        radioFiveThousand.setChecked(false);

        Button buttonTrueTwo = (Button) findViewById(R.id.buttonTrueTwoChicken);
        buttonTrueTwo.setBackgroundColor(Color.parseColor("#FF6200EE"));

        Button buttonTrueThree = (Button) findViewById(R.id.buttonTrueThreeChicken);
        buttonTrueThree.setBackgroundColor(Color.parseColor("#FF6200EE"));

        Button buttonFalseThree = (Button) findViewById(R.id.buttonFalseThreeChicken);
        buttonFalseThree.setBackgroundColor(Color.parseColor("#FF6200EE"));

        Button buttonTrueFour = (Button) findViewById(R.id.buttonTrueFourChicken);
        buttonTrueFour.setBackgroundColor(Color.parseColor("#FF6200EE"));

        Button buttonFalseFour = (Button) findViewById(R.id.buttonFalseFourChicken);
        buttonFalseFour.setBackgroundColor(Color.parseColor("#FF6200EE"));

        Button buttonFalseTwo = (Button) findViewById(R.id.buttonFalseTwoChicken);
        buttonFalseTwo.setBackgroundColor(Color.parseColor("#FF6200EE"));

    }

}
