//Kate Blunt
//COP3667
//Final Project App

package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.media.SoundPool;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioAttributes;
import android.media.AudioManager;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Animation.AnimationListener  {

    //variable declaration
    private boolean mPlaySounds;
    private SharedPreferences mPrefs;

    public boolean soundOnOff = true;

    Animation animBounce;
    Animation animLeftRight;
    Animation animRotateRight;
    Animation animRotateLeft;
    ImageView imageView;
    ImageView imageViewTwo;
    ImageView imageViewThree;
    ImageView imageViewFour;


    static int correct = 0;
    static int correctChicken = 0;
    static int correctDog = 0;
    static int correctDragon = 0;
    int i = 0;
    int j = 0;
    int k = 0;
    int l = 0;

    //Array for facts
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

        //retrieve the value of the boolean soundOnOff to determine what the user had selected.
        SharedPreferences sharedPrefs = getSharedPreferences("Final Project", MODE_PRIVATE);
        soundOnOff = sharedPrefs.getBoolean("sound", true);


        }





    //Sound On and Sound Off buttons to change the boolearn value, which is then stored
    public void changeBooleanTrue(View v){
        Button sound = (Button) findViewById(R.id.button15);
        soundOnOff = true;

        //save the data
        SharedPreferences.Editor editor = getSharedPreferences("Final Project", MODE_PRIVATE).edit();
        editor.putBoolean("sound", true);
        editor.commit();
    }

    //Sound On and Sound Off buttons to change the boolearn value, which is then stored
    public void changeBooleanTrueTwo(View v){
        Button sound = (Button) findViewById(R.id.button17);
        soundOnOff = true;

        //save the data
        SharedPreferences.Editor editor = getSharedPreferences("Final Project", MODE_PRIVATE).edit();
        editor.putBoolean("sound", true);
        editor.commit();
    }

    //Sound On and Sound Off buttons to change the boolearn value, which is then stored
    public void changeBooleanFalse(View v){
        soundOnOff = false;

        SharedPreferences.Editor editor = getSharedPreferences("Final Project", MODE_PRIVATE).edit();
        editor.putBoolean("sound", false);
        editor.commit();
        //save the data

    }

    //Sound On and Sound Off buttons to change the boolearn value, which is then stored
    public void changeBooleanFalseTwo(View v){
        Button sound = (Button) findViewById(R.id.button18);
        soundOnOff = false;

        SharedPreferences.Editor editor = getSharedPreferences("Final Project", MODE_PRIVATE).edit();
        editor.putBoolean("sound", false);
        editor.commit();
        //save the data

    }

    //These are loading animations for the various animations
    public void loadAnimationsDragon(){
        animBounce = AnimationUtils.loadAnimation(this, R.anim.bounce);
        animLeftRight = AnimationUtils.loadAnimation(this, R.anim.left_right);
    }

    public void loadAnimationsDog(){

        animBounce = AnimationUtils.loadAnimation(this, R.anim.bounce);
        animLeftRight = AnimationUtils.loadAnimation(this, R.anim.left_right);
    }

    public void loadAnimationsChicken(){

        animRotateRight = AnimationUtils.loadAnimation(this, R.anim.rotate_right);
    }

    public void loadAnimationsCat(){

        animRotateLeft = AnimationUtils.loadAnimation(this, R.anim.rotate_left);
    }

    //loading UI for animations
    public void loadUIDragon(){

        imageView = (ImageView) findViewById(R.id.imageView12);

        imageView.setOnClickListener(this);

    }

    public void loadUIDog(){
        imageViewTwo = (ImageView) findViewById(R.id.imageView11);
        imageViewTwo.setOnClickListener(this);

    }

    public void loadUIChicken(){
        imageViewThree = (ImageView) findViewById(R.id.imageView10);
        imageViewThree.setOnClickListener(this);

    }

    public void loadUICat(){
        imageViewFour = (ImageView) findViewById(R.id.imageView9);
        imageViewFour.setOnClickListener(this);

    }

    //needed for animation
    @Override
    public void onAnimationRepeat(Animation animation) {


    }

    //needed for animation
    @Override
    public void onAnimationEnd(Animation animation) {


    }

    //needed for animation
    @Override
    public void onAnimationStart(Animation animation) {


    }

    //the OnClick handles pretty much all of the animations and sounds
    //depending on what is clicked, animations/sound will happen
    @Override
    public void onClick(View v) {


        switch (v.getId()) {


            case R.id.imageView12:
                animLeftRight.setDuration(5000);
                animLeftRight.setAnimationListener(this);
                imageView.startAnimation(animLeftRight);

                break;
            case R.id.imageView11:
                animBounce.setDuration(3000);
                animBounce.setAnimationListener(this);
                imageViewTwo.startAnimation(animBounce);

                break;

            case R.id.imageView10:
                animRotateRight.setDuration(3000);
                animRotateRight.setAnimationListener(this);
                imageViewThree.startAnimation(animRotateRight);

                break;

            case R.id.imageView9:
                animRotateLeft.setDuration(3000);
                animRotateLeft.setAnimationListener(this);
                imageViewFour.startAnimation(animRotateLeft);

                break;

                //cat noises
            case R.id.soundOneCat:


                final MediaPlayer mp = MediaPlayer.create(this, R.raw.meow);

                if (soundOnOff) {

                    mp.setVolume(1,1);
                }
                else {
                    mp.setVolume(0,0);
                }

                mp.start();
                break;

            case R.id.soundTwoCat:
                final MediaPlayer mpTwo = MediaPlayer.create(this, R.raw.hungrycat);

                if (soundOnOff) {

                    mpTwo.setVolume(1,1);
                }
                else {
                    mpTwo.setVolume(0,0);
                }

                mpTwo.start();
                break;

            case R.id.soundThreeCat:
                final MediaPlayer mpThree = MediaPlayer.create(this, R.raw.purr);
                if (soundOnOff) {

                    mpThree.setVolume(1,1);
                }
                else {
                    mpThree.setVolume(0,0);
                }
                mpThree.start();
                break;

                //dog noises

            case R.id.soundDogOne:
                final MediaPlayer mpFour = MediaPlayer.create(this, R.raw.bark);
                if (soundOnOff) {

                    mpFour.setVolume(1,1);
                }
                else {
                    mpFour.setVolume(0,0);
                }
                mpFour.start();
                break;

            case R.id.soundDogThree:
                final MediaPlayer mpFive = MediaPlayer.create(this, R.raw.growl);
                if (soundOnOff) {

                    mpFive.setVolume(1,1);
                }
                else {
                    mpFive.setVolume(0,0);
                }

                mpFive.start();
                break;

            case R.id.soundDogTwo:
                final MediaPlayer mpSix = MediaPlayer.create(this, R.raw.howl);
                if (soundOnOff) {

                    mpSix.setVolume(1,1);
                }
                else {
                    mpSix.setVolume(0,0);
                }

                mpSix.start();
                break;

                //chicken noises
            case R.id.chickenSoundOne:
                final MediaPlayer mpEight = MediaPlayer.create(this, R.raw.cluck);
                if (soundOnOff) {

                    mpEight.setVolume(1,1);
                }
                else {
                    mpEight.setVolume(0,0);
                }
                mpEight.start();
                break;

            case R.id.chickenSoundTwo:
                final MediaPlayer mpSeven = MediaPlayer.create(this, R.raw.crow);
                if (soundOnOff) {

                    mpSeven.setVolume(1,1);
                }
                else {
                    mpSeven.setVolume(0,0);
                }
                mpSeven.start();
                break;

            case R.id.chickenSoundThree:
                final MediaPlayer mpNine = MediaPlayer.create(this, R.raw.babychick);
                if (soundOnOff) {

                    mpNine.setVolume(1,1);
                }
                else {
                    mpNine.setVolume(0,0);
                }
                mpNine.start();
                break;

                //bearded dragon noise
            case R.id.soundDragonOne:
                final MediaPlayer mpTen = MediaPlayer.create(this, R.raw.hiss);
                if (soundOnOff) {

                    mpTen.setVolume(1,1);
                }
                else {
                    mpTen.setVolume(0,0);
                }
                mpTen.start();
                break;


        }


    }


    //methods to switch between layouts
    public void loadHome(View v){

        //Back to main menu page
        setContentView(R.layout.activity_main);

    }

    public void loadSettings (View v){

        //settings layout
        setContentView(R.layout.settings_layout);
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

    //********************Cat stuff here *************************************************************
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

// ***************End of cat stuff *****************************************************************
//same methods/functionality are utilized in all of the other animals functions.

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

    //******************* end of Chicken stuff *************************************************************

    //*********************Start of dog stuff **************************************************************

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
