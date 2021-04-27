package com.example.finalproject;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Cat extends AppCompatActivity {

    //This handles all of the cat layouts and the quiz answers
    public void loadCatPictures(View v){

        //This is the chicken page
        setContentView(R.layout.cat_pictures);

    }

    public void loadCatFacts(View v){

        //This is the chicken page
        setContentView(R.layout.cat_facts);

    }

    public void loadFoodCat(View v){

        //food view
        setContentView(R.layout.cat_dos_donts);
    }

    public void loadCatQuiz(View v){

        //quiz view
        setContentView(R.layout.cat_quiz);
    }

    //set onClickListener on sound buttons
    public void loadCatSounds(View v){
        setContentView(R.layout.catsounds);
        loadUICat();
        loadAnimationsCat();

        //sounds of cats
        Button catMeow = (Button) findViewById(R.id.soundOneCat);
        Button catHungry = (Button) findViewById(R.id.soundTwoCat);
        Button catPurr = (Button) findViewById(R.id.soundThreeCat);


        catMeow.setOnClickListener(this);
        catHungry.setOnClickListener(this);
        catPurr.setOnClickListener(this);

    }

    //This is iterating through the array and changing the text on the screen depending on what value is in the array
    public void changeText(View v) {

        TextView facts = (TextView)findViewById(R.id.factsView);

        facts.setText("" + catFacts[i]);
        i++;

        //reset the i variable so we can loop through the array again
        if (i == 11)
        {
            i = 0;
        }

    }

    //If the user selects the correct button, depending on which view we are on, it will increment the correct counter
    public void catQuizTrue(View v)
    {
        switch (v.getId()){

            //if question one, correct
            case R.id.buttonTrueTwoChicken:
                v.setBackgroundColor(Color.parseColor("#FF03DAC5"));
                correct++;

                break;

            //correct answer if on cat page
            case R.id.buttonTrueFourChicken:
                v.setBackgroundColor(Color.parseColor("#FF03DAC5"));
                correct++;
                break;

            //incorrect answer if on cat page, so don't increment correct
            case R.id.buttonTrueThreeChicken:
                v.setBackgroundColor(Color.parseColor("#FF03DAC5"));
        }
    }

    //same concept as above. Depending on which view, it will call a different method and increment the correct variable for the animal
    public void catQuizFalse(View v)
    {
        switch (v.getId()){

            //not correct
            case R.id.buttonFalseTwoChicken:
                v.setBackgroundColor(Color.parseColor("#FF03DAC5"));
                break;

            //not correct
            case R.id.buttonFalseFourChicken:
                v.setBackgroundColor(Color.parseColor("#FF03DAC5"));
                break;

            //correct, so increment correct variables
            case R.id.buttonFalseThreeChicken:
                v.setBackgroundColor(Color.parseColor("#FF03DAC5"));
                correct++;
        }
    }

    //Here we display the quiz results in a toast message and then clear everything on screen so the user can try again
    public void quizResults(View v){

        EditText answer = findViewById(R.id.editTextAnswer);
        String results = answer.getText().toString();
        String correctAnswer = "12";
        //Toast.makeText(this, "You got " + results + " TEst!", Toast.LENGTH_SHORT).show();
        if (results.equals((correctAnswer)))
        {
            correct++;
        }

        // Let the user know how many answers they got correct and then reset the quiz
        Toast.makeText(this, "You got " + correct + " answers correct!", Toast.LENGTH_SHORT).show();
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

    //checking radio button values and if the answers are correct or not.
    public void onRadioButtonClicked (View v){

        String testView = "";

        //Is the button now checked?
        boolean checked = ((RadioButton) v).isChecked();


        // Check which radio button was clicked
        switch(v.getId()) {
            case R.id.radioButtonTwelve:
                if (checked)
                    correct++;
                correctDog++;
                break;
            case R.id.radioButtonOne:
                correctChicken++;
                break;
            case R.id.radioButtonThree:
                correctDragon++;
                break;
            case R.id.radioButtonFiveThousand:

                break;
        }


    }

}
