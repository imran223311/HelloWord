package com.samegenes.helloword;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Restart extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle x) {
        super.onCreate(x);
    }
    public void goMain(View view){
        Intent main = new Intent(this, MainScreen.class);
        startActivity(main);
    }
}
