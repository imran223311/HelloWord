package com.samegenes.helloword;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

public class SettingScreen extends AppCompatActivity {

    MediaPlayer md;
    Switch aSwitch;
    int check = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_screen);
        aSwitch = findViewById(R.id.switch1);
        aSwitch.setChecked(true);
        builtSound();
        md.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        md.release();
        md = null;
    }
    public void onSwitchClick(View view){
        if(aSwitch.isChecked()){
            playMusic(view);
        }else{
            stopMusic(view);
        }
    }
    public void playMusic(View view){
        if(check == 0){
            builtSound();
            md.start();
            check =1;
        }
    }
    public void stopMusic(View view){
        if(check == 1){
            md.stop();
            md.release();
            md = null;
            check =0;
        }
    }
    public  void builtSound(){
        md = MediaPlayer.create(this,R.raw.leavemealone);
        md.setLooping(true);
        md.setVolume(50,50);
    }
}