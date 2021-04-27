package com.example.finalproject;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Dog extends AppCompatActivity {

    public void loadDogPictures(View v){

        //This is the chicken page
        setContentView(R.layout.dog_pictures);

    }

    public void loadDogSounds(View v){
        setContentView(R.layout.dogsounds);
        loadUIDog();
        loadAnimationsDog();

        Button dogBark = (Button) findViewById(R.id.soundDogOne);
        Button dogGrowl = (Button) findViewById(R.id.soundDogThree);
        Button dogHowl = (Button) findViewById(R.id.soundDogTwo);

        dogBark.setOnClickListener(this);
        dogGrowl.setOnClickListener(this);
        dogHowl.setOnClickListener(this);



    }

    public void loadDogFacts(View v){

        //This is the chicken page
        setContentView(R.layout.dog_facts);

    }

    public void loadFoodDog(View v){
        setContentView(R.layout.dog_dos_donts);
    }

    public void loadDogQuiz(View v){

        setContentView(R.layout.dog_quiz);
    }

    public void changeTextDog(View v) {
        TextView facts = (TextView)findViewById(R.id.factsDogView);

        facts.setText("" + dogFacts[k]);
        k++;

        //reset the i variable so we can loop through the array again
        if (k == 10)
        {
            k = 0;
        }

    }
    public void dogQuizTrue(View v)
    {
        switch (v.getId()){

            //if question one, correct
            case R.id.buttonTrueTwoChicken:
                v.setBackgroundColor(Color.parseColor("#FF03DAC5"));
                correctDog++;

                break;

            case R.id.buttonTrueFourChicken:
                v.setBackgroundColor(Color.parseColor("#FF03DAC5"));
                break;

            case R.id.buttonTrueThreeChicken:
                v.setBackgroundColor(Color.parseColor("#FF03DAC5"));
                correctDog++;
                break;

        }

    }

    public void dogQuizFalse(View v)
    {


        switch (v.getId()){

            //if question one, correct
            case R.id.buttonFalseTwoChicken:
                v.setBackgroundColor(Color.parseColor("#FF03DAC5"));
                break;

            case R.id.buttonFalseFourChicken:
                v.setBackgroundColor(Color.parseColor("#FF03DAC5"));
                correctDog++;
                break;

            case R.id.buttonFalseThreeChicken:
                v.setBackgroundColor(Color.parseColor("#FF03DAC5"));
                break;


        }

    }

    public void quizResultsDog(View v){

        EditText answer = findViewById(R.id.editTextAnswer);
        String results = answer.getText().toString();
        String correctAnswerChicken = "great dane";
        //Toast.makeText(this, "You got " + results + " TEst!", Toast.LENGTH_SHORT).show();
        if (results.equals((correctAnswerChicken)))
        {
            correctDog++;
        }

        // Your code goes here
        Toast.makeText(this, "You got " + correctDog + " answers correct!", Toast.LENGTH_SHORT).show();
        //results.setText("You got " + correct + " correct!");

        //reset colors, text box, and radio button
        correctDog = 0;
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

    // End of dog stuff *************************************************************

}
