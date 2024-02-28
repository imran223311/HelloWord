package com.samegenes.helloword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

    }

    public void goGameScreen(View view){

        Intent gameScreen = new Intent(this, GameScreen.class);
        startActivity(gameScreen);
    }

    public void goSettingScreen(View view){

        Intent settingScreen = new Intent(this, SettingScreen.class);
        startActivity(settingScreen);
    }
}