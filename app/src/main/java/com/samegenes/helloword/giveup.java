package com.samegenes.helloword;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class giveup extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.giveuppopup);
        TextView x = findViewById(R.id.show);
        String y = getIntent().getExtras().getString("Value");
        x.setText(y);
    }
    public void goMain(View view) {
        Intent main = new Intent(this, MainScreen.class);
        startActivity(main);
    }
}
