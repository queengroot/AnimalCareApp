package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    static int correct = 0;
    static int correctChicken = 0;
    static int correctDog = 0;
    static int correctDragon = 0;
    int i = 0;
    int j = 0;
    //String[] catFacts = new String[600];
    String[] catFacts = {"A cat can not see directly under their nose.", "Cats can rotate their ears 180 degrees.",
                        "Cats are one of, if not the most, popular pet in the world.",
                        "Cats conserve energy by sleeping for an average of 13 to 14 hours a day.",
                        "On average cats live for around 12 to 15 years.",
                        "Cats spend a large amount of time licking their coats to keep them clean.",
                        "Feral cats are often seen as pests and threats to native animals.",
                        "Cats can rotate their ears 180 degrees.",
                        "Most cats have no eyelashes",
                        "Some believe that if you dream of a white cat, good luck will follow.",
                        "The hearing of the average cat is at least five times keener than that of a human adult."};

    String[] dogFacts = {"A dog’s nose print is unique, much like a person’s fingerprint.",
                        "All puppies are born deaf.",
                        "Dogs are not colorblind. They also see blue and yellow.",
                        "Human blood pressure goes down when petting a dog. And so does the dog’s.",
                        "A person who hunts with a Beagle is known as a 'Beagler'.",
                        "Dogs have about 1,700 taste buds.",
                        "Seventy percent of people sign their dog’s name on their holiday cards.",
                        "The name Collie means “black.”",
                        "Forty-five percent of U.S. dogs sleep in their owner’s bed.",
                        "Dog eyes have a part called the tapetum lucidum, allowing night vision."};

    String[] chickenFacts = {"There are more chickens on earth than people – 25 billion",
                        "Chickens can remember over 100 different faces of people or animals.",
                        "A mother hen turns her eggs about 50 times per day and can lay more than 300 eggs per year.",
                        "The record number of eggs laid by a chicken in one day is 7.",
                        "The record number of eggs laid by a chicken in one year is 371.",
                        "An egg develops at 88 degrees Fahrenheit and is laid at 105 degrees.",
                        "The color of the egg depends on the chicken’s earlobes. Red ear lobed chickens lay brown eggs, while white ear lobed chickens lay white eggs.",
                        "As chickens grow older, they lay larger eggs, but fewer than when they’re younger.",
                        "Chickens can taste saltiness, but not sweetness.",
                        "In Gainesville, Florida, you have to eat fried chicken with your bare hands. Eating it by any other method is illegal."};

    String[] dragonFacts = {"Their name comes from the ‘beard’ of spiny scales around their necks",
                            "They wave to each other",
                            "They develop unique behaviors",
                            "They can run up to 9mph",
                            "They can swim",
                            "Their teeth grow back",
                            "They can sleep standing up",
                            "They can run on two legs.",
                            " Their scales tell their mood",
                            " They can change color"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get a reference to the "Next Fact" button
        //btnCatNextFact = (Button) findViewById(R.id.nextFact);

        // Listen for all the button clicks
        //btnCatNextFact.setOnClickListener(this);

//        //private Button btnCatNextFact;
//        final Button buttonTwoTrue = findViewById(R.id.);
//        buttonTwoTrue.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                buttonTwoTrue.setBackgroundColor(getResources().getColor(R.color.teal_200));
//            }
//        });




    }

    //methods to switch between layouts
    public void loadHome(View v){

        //This is the home page
        setContentView(R.layout.activity_main);

    }

    public void loadHomePageCats(View v){

        //This is the cat page
        setContentView(R.layout.cat_home_page);

    }

    public void loadHomePageChicken(View v){

        //This is the chicken page
        setContentView(R.layout.chicken_home_page);

    }

    public void loadHomePageDog(View v){

        //This is the chicken page
        setContentView(R.layout.dog_home_page);

    }

    public void loadHomePageDragon(View v){

        //This is the chicken page
        setContentView(R.layout.dragon_home_page);

    }

    //Cat stuff here *************************************************************
    public void loadCatPictures(View v){

        //This is the chicken page
        setContentView(R.layout.cat_pictures);

    }

    public void loadCatFacts(View v){

        //This is the chicken page
        setContentView(R.layout.cat_facts);

    }

    public void loadCatQuiz(View v){

        setContentView(R.layout.cat_quiz);
    }
    
    public void loadCatSounds(View v){
        setContentView(R.layout.catsounds);
    }

    public void loadChickenSounds(View v){
        setContentView(R.layout.chickensounds);
    }

    public void loadDogSounds(View v){
        setContentView(R.layout.dogsounds);
    }

    public void loadDragonSounds(View v){
        setContentView(R.layout.dragonsounds);
    }
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

    public void catQuizTrue(View v)
    {
        switch (v.getId()){

            //if question one, correct
            case R.id.buttonTrueTwoChicken:
                v.setBackgroundColor(Color.parseColor("#FF03DAC5"));
                correct++;

                break;

            case R.id.buttonTrueFourChicken:
                v.setBackgroundColor(Color.parseColor("#FF03DAC5"));
                correct++;
                break;

            case R.id.buttonTrueThreeChicken:
                v.setBackgroundColor(Color.parseColor("#FF03DAC5"));



        }


    }

    public void catQuizFalse(View v)
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
                    correct++;


            }

    }

    public void quizResults(View v){

        EditText answer = findViewById(R.id.editTextAnswer);
        String results = answer.getText().toString();
        String correctAnswer = "12";
        //Toast.makeText(this, "You got " + results + " TEst!", Toast.LENGTH_SHORT).show();
        if (results.equals((correctAnswer)))
        {
            correct++;
        }

        // Your code goes here
        Toast.makeText(this, "You got " + correct + " answers correct!", Toast.LENGTH_SHORT).show();
        //results.setText("You got " + correct + " correct!");

        //reset colors, text box, and radio button
        correct = 0;
        final EditText userEntry = (EditText) findViewById(R.id.editTextAnswer);
        userEntry.setText("");

        RadioButton radioTwelve = (RadioButton) findViewById(R.id.radioButtonTwelve);
        radioTwelve.setChecked(false);

        Button buttonTrueTwo = (Button) findViewById(R.id.buttonTrueTwoChicken);
        buttonTrueTwo.setBackgroundColor(Color.parseColor("#FF6200EE"));

        Button buttonFalseThree = (Button) findViewById(R.id.buttonFalseThreeChicken);
        buttonFalseThree.setBackgroundColor(Color.parseColor("#FF6200EE"));

        Button buttonTrueFour = (Button) findViewById(R.id.buttonTrueFourChicken);
        buttonTrueFour.setBackgroundColor(Color.parseColor("#FF6200EE"));




    }

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

//    @Override
//    public void onClick(View v){
//
//        View inflatedView = getLayoutInflater().inflate(R.layout.cat_facts, null);
//        TextView nextFact = (TextView) inflatedView.findViewById(R.id.factsView);
//        nextFact.setText("" + catFacts[0]);
//
//    }

//  @Override
//    public void onClick (View view) {
//      View inflatedView = getLayoutInflater().inflate(R.layout.cat_facts, null);
//      TextView nextFact = (TextView) inflatedView.findViewById(R.id.factsView);
//        switch(view.getId()){
//            case R.id.nextFact:
//                nextFact.setText(catFacts[0]);
//
//
//        }
//    }
//
// End of cat stuff *****************************************************************
    //Start of chicken stuff *******************************************************
public void loadChickenPictures(View v){

    //This is the chicken page
    setContentView(R.layout.chicken_pictures);

}

    public void loadChickenFacts(View v){

        //This is the chicken page
        setContentView(R.layout.chicken_facts);

    }

    public void loadChickenQuiz(View v){

        setContentView(R.layout.chicken_quiz);
    }

    public void changeTextChicken(View v) {
        TextView facts = (TextView)findViewById(R.id.factsChickenView);

        facts.setText("" + chickenFacts[i]);
        i++;

        //reset the i variable so we can loop through the array again
        if (i == 11)
        {
            i = 0;
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

        Button buttonTrueTwo = (Button) findViewById(R.id.buttonTrueTwoChicken);
        buttonTrueTwo.setBackgroundColor(Color.parseColor("#FF6200EE"));

        Button buttonFalseThree = (Button) findViewById(R.id.buttonFalseThreeChicken);
        buttonFalseThree.setBackgroundColor(Color.parseColor("#FF6200EE"));

        Button buttonTrueFour = (Button) findViewById(R.id.buttonTrueFourChicken);
        buttonTrueFour.setBackgroundColor(Color.parseColor("#FF6200EE"));




    }






    // end of Chicken stuff *************************************************************

    //Start of dog stuff **************************************************************

    public void loadDogPictures(View v){

        //This is the chicken page
        setContentView(R.layout.dog_pictures);

    }

    public void loadDogFacts(View v){

        //This is the chicken page
        setContentView(R.layout.dog_facts);

    }

    public void loadDogQuiz(View v){

        setContentView(R.layout.dog_quiz);
    }

    public void changeTextDog(View v) {
        TextView facts = (TextView)findViewById(R.id.factsDogView);

        facts.setText("" + dogFacts[j]);
        j++;

        //reset the i variable so we can loop through the array again
        if (j == 10)
        {
            j = 0;
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


    }

    // End of dog stuff *************************************************************


    //*********************** Start of Bearded Dragon stuff ***************************

    public void loadDragonPictures(View v){

        //This is the chicken page
        setContentView(R.layout.dragon_pictures);

    }

    public void loadDragonFacts(View v){

        //This is the chicken page
        setContentView(R.layout.dragon_facts);

    }

    public void loadDragonQuiz(View v){

        setContentView(R.layout.dragon_quiz);
    }

    public void changeTextDragon(View v) {
        TextView facts = (TextView)findViewById(R.id.factsDragonView);

        facts.setText("" + dragonFacts[i]);
        i++;

        //reset the i variable so we can loop through the array again
        if (i == 11)
        {
            i = 0;
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

        Button buttonTrueTwo = (Button) findViewById(R.id.buttonTrueTwoChicken);
        buttonTrueTwo.setBackgroundColor(Color.parseColor("#FF6200EE"));

        Button buttonFalseThree = (Button) findViewById(R.id.buttonFalseThreeChicken);
        buttonFalseThree.setBackgroundColor(Color.parseColor("#FF6200EE"));

        Button buttonTrueFour = (Button) findViewById(R.id.buttonTrueFourChicken);
        buttonTrueFour.setBackgroundColor(Color.parseColor("#FF6200EE"));


    }

    //********************** End of Bearded Dragon stuff *****************************
}
