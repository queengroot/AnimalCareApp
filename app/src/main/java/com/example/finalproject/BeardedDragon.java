package com.example.finalproject;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BeardedDragon extends AppCompatActivity {

    //*********************** Start of Bearded Dragon stuff ***************************

    public void loadDragonPictures(View v){

        //This is the chicken page
        setContentView(R.layout.dragon_pictures);

    }

    public void loadDragonSounds(View v){
        setContentView(R.layout.dragonsounds);
        loadAnimationsDragon();
        loadUIDragon();

        Button dragonHiss = (Button) findViewById(R.id.soundDragonOne);
        dragonHiss.setOnClickListener(this);

    }

    public void loadDragonFacts(View v){

        //This is the chicken page
        setContentView(R.layout.dragon_facts);

    }

    public void loadDragonQuiz(View v){

        setContentView(R.layout.dragon_quiz);
    }

    public void loadFoodDragon(View v){
        setContentView(R.layout.dragon_dos_donts);
    }

    public void changeTextDragon(View v) {
        TextView facts = (TextView)findViewById(R.id.factsDragonView);

        facts.setText("" + dragonFacts[l]);
        l++;

        //reset the i variable so we can loop through the array again
        if (l == 10)
        {
            l = 0;
        }



    }
    public void dragonQuizTrue(View v)
    {
        switch (v.getId()){

            //if question one, correct
            case R.id.buttonTrueTwoChicken:
                v.setBackgroundColor(Color.parseColor("#FF03DAC5"));
                correctDragon++;

                break;

            case R.id.buttonTrueFourChicken:
                v.setBackgroundColor(Color.parseColor("#FF03DAC5"));
                correctDragon++;
                break;

            case R.id.buttonTrueThreeChicken:
                v.setBackgroundColor(Color.parseColor("#FF03DAC5"));
                break;
        }
    }

    public void dragonQuizFalse(View v)
    {
        switch (v.getId()){

            //if question one, correct
            case R.id.buttonFalseTwoChicken:
                v.setBackgroundColor(Color.parseColor("#FF03DAC5"));
                break;

            case R.id.buttonFalseFourChicken:
                v.setBackgroundColor(Color.parseColor("#FF03DAC5"));

                break;

            case R.id.buttonFalseThreeChicken:
                v.setBackgroundColor(Color.parseColor("#FF03DAC5"));
                correctDragon++;
                break;
        }

    }

    public void quizResultsDragon(View v){

        EditText answer = findViewById(R.id.editTextAnswer);
        String results = answer.getText().toString();
        String correctAnswerChicken = "9";
        //Toast.makeText(this, "You got " + results + " TEst!", Toast.LENGTH_SHORT).show();
        if (results.equals((correctAnswerChicken)))
        {
            correct++;
        }

        // Your code goes here
        Toast.makeText(this, "You got " + correctDragon + " answers correct!", Toast.LENGTH_SHORT).show();
        //results.setText("You got " + correct + " correct!");

        //reset colors, text box, and radio button
        correct = 0;
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

    //********************** End of Bearded Dragon stuff *****************************
}
