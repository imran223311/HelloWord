package com.samegenes.helloword;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import java.util.Objects;
public class MainScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle x) {
        super.onCreate(x);
        setContentView(R.layout.activity_main_screen);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
    }
    public void helps(View view){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.help);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }
    public void goGameScreen(View view){
        Intent gameScreen = new Intent(this, GameScreen.class);
        startActivity(gameScreen);
    }
}