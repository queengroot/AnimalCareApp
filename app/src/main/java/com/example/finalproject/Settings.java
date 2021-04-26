//package com.example.finalproject;
//
//import android.content.SharedPreferences;
//import android.os.Bundle;
//
//import android.content.SharedPreferences;
//import android.widget.CompoundButton;
//import android.widget.Switch;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//public class Settings extends AppCompatActivity {
//
//    //A SharedPreference for reading data
//    private SharedPreferences mPrefs;
//
//    //A SharedPreference.Editor for writing data
//    private SharedPreferences.Editor mEditor;
//
//    private boolean mPlaySounds;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.settings_layout);
//
//        //had to comment this out because there was an activity already
//        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        //setSupportActionBar(toolbar);
//
//
//        mPrefs = getSharedPreferences("Final Project", MODE_PRIVATE);
//        mEditor = mPrefs.edit();
//
//        mPlaySounds  = mPrefs.getBoolean("sound", true);
//
//        Switch switch1 = (Switch) findViewById(R.id.switch1);
//
//        // Set the switch on or off as appropriate
//        switch1.setChecked(mPlaySounds);
//
//        switch1.setOnCheckedChangeListener(
//                new CompoundButton.OnCheckedChangeListener() {
//
//                    public void onCheckedChanged(
//                            CompoundButton buttonView, boolean isChecked) {
//
//                        if(isChecked){
//                            mEditor.putBoolean(
//                                    "sound", true);
//                            mPlaySounds = true;
//
//
//                        }else{
//                            mEditor.putBoolean(
//                                    "sound", false);
//                            mPlaySounds = false;
//
//
//                        }
//                    }
//                });
//        Toast.makeText(this, "You saved data", Toast.LENGTH_SHORT).show();
//
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//
//        // Save the settings here
//        mEditor.commit();
//    }
//
//}
