package com.samegenes.helloword;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class GiveUp extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle x) {
        super.onCreate(x);
        setContentView(R.layout.giveuppopup);
    }
    public void goMain(View view) {
        Intent main = new Intent(this, MainScreen.class);
        startActivity(main);
    }
}
