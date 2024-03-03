package com.samegenes.helloword;

import android.annotation.SuppressLint;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

public class GameScreen extends AppCompatActivity {
    private Dialog dialog;
    private String total = "";
    private final int[] totals = new int[5];
    private int[] ordertext = new int[5];
    private final int[] ordertext1 = {R.id.text1, R.id.text2, R.id.text3, R.id.text4, R.id.text5};
    private final int[] ordertext2 = {R.id.text11, R.id.text22, R.id.text33, R.id.text44, R.id.text55};
    private final int[] ordertext3 = {R.id.text111, R.id.text222, R.id.text333, R.id.text444, R.id.text555};
    private final int[] ordertext4 = {R.id.text1111, R.id.text2222, R.id.text3333, R.id.text4444, R.id.text5555};
    private final int[] ordertext5 = {R.id.text11111, R.id.text22222, R.id.text33333, R.id.text44444, R.id.text55555};
    private final int[] ordertext6 = {R.id.text111111, R.id.text222222, R.id.text333333, R.id.text444444, R.id.text555555};
    private int count = 0, change = 0, checkpoint = 0;
//    Context context = getApplicationContext();
    private final InGameWord ans = new InGameWord(helloword.getAppContext());
    private String target = ans.getword();

    @Override
    protected void onCreate(Bundle x) {
        super.onCreate(x);
        setContentView(R.layout.activity_game_screen);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
    }
    @SuppressLint("SetTextI18n")
    public void giveups(View view) {
        dialog = new Dialog(this);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.giveuppopup);
        TextView text = (TextView) dialog.findViewById(R.id.show);
        text.setText(target);
        dialog.show();
        TextView lost = findViewById(R.id.lostshow);
        lost.setText("You Lost!");
        change = 6;
    }
    @SuppressLint("SetTextI18n")
    public void CreatedpopupEnd() {
        if (checkpoint == 5) {
            dialog = new Dialog(this);
            dialog.setContentView(R.layout.popupwin);
            Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();
            change = 6;
        }else if(change == 5 && checkpoint != 5){
            dialog = new Dialog(this);
            Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.setContentView(R.layout.giveuppopup);
            TextView text = (TextView) dialog.findViewById(R.id.show);
            text.setText(target);
            dialog.show();
            TextView lost = findViewById(R.id.lostshow);
            lost.setText("You Lost!");
            change = 6;
        }
    }
    public void check() {
        for (int i = 0; i < 5; i++) {
            TextView vls = findViewById(ordertext[i]);
            TextView vl = findViewById(totals[i]);
            if (target.substring(i, i + 1).equals((total.substring(i, i + 1)))) {
                checkpoint++;
                vls.setBackgroundColor(android.graphics.Color.parseColor("#00FF00"));
                vl.setBackgroundColor(android.graphics.Color.parseColor("#00FF00"));
            } else if (target.contains(total.substring(i, i + 1))) {
                vls.setBackgroundColor(android.graphics.Color.parseColor("#FFFF00"));
                vl.setBackgroundColor(android.graphics.Color.parseColor("#FFFF00"));
            } else {
                vls.setBackgroundColor(android.graphics.Color.parseColor("#B3B6B7"));
                vl.setBackgroundColor(android.graphics.Color.parseColor("#B3B6B7"));
            }
        }
        CreatedpopupEnd();
        checkpoint = 0;
    }
    public void clickLetter(View v) { //ส่วนของแป้นพิมพ์ตรงนี้น่าจะครบละ
        if (change < 6) {
            if (change == 0) {
                ordertext = ordertext1;
            } else if (change == 1) {
                ordertext = ordertext2;
            } else if (change == 2) {
                ordertext = ordertext3;
            } else if (change == 3) {
                ordertext = ordertext4;
            } else if (change == 4) {
                ordertext = ordertext5;
            } else if (change == 5) {
                ordertext = ordertext6;
            }
            TextView vl = findViewById(ordertext[count]);
            int y = v.getId();
            if ((y == R.id.Delete) && (count == 4)) {
                if (vl.getText().equals("")) {
                    TextView vlx = findViewById(ordertext[count - 1]);
                    vlx.setText("");
                    count--;
                } else {
                    vl.setText("");
                }
                total = total.substring(0, total.length() - 1);
            } else if (count < 0) {
                count = 0;
            } else if (count < 5) {
                TextView x = findViewById(y);
                if (y == R.id.Delete) {
                    TextView ch = findViewById(y);
                    ch.setBackgroundColor(android.graphics.Color.parseColor("#D0D3D4"));
                    if (count == 0) {
                        vl.setText("");

                    } else if (vl.getText().equals("")) {
                        TextView vlx = findViewById(ordertext[count - 1]);
                        vlx.setText("");
                        count--;
                        total = total.substring(0, total.length() - 1);
                    } else {
                        vl.setText("");
                        total = total.substring(0, total.length() - 1);
                    }
                } else if (y == R.id.Enter) {
                    if (total.length() < 5) {
                        Toast.makeText(GameScreen.this,"Complete The Word With 5 Letter",Toast.LENGTH_LONG).show();
                    } else{
                        ans.setWordforcheck(total);
                        if(ans.CheckValid()) {
                            check();
                            change++;
                            count = 0;
                            total = "";
                        }else{
                            Toast.makeText(GameScreen.this,"Please Enter A Meaningful Word",Toast.LENGTH_LONG).show();
                        }
                    }
                } else {
                    if (count == 4) {
                        vl.setText(x.getText().toString());
                        total += x.getText().toString();
                        totals[count] = y;
                    } else {
                        vl.setText(x.getText().toString());
                        totals[count] = y;
                        total += x.getText().toString();
                        count++;
                    }
                }
            }
        }
    }
    public void goMain(View view) {
        Intent main = new Intent(this, MainScreen.class);
        startActivity(main);
    }
}

class InGameWord {
    private int size,randIdx;
    private String check ,word = "";
    private final Set<String> Word_set = new HashSet<>();
    public InGameWord(Context context){
        AssetManager am = context.getAssets();
        BufferedReader buffer = null;

        try {
            buffer = new BufferedReader(new InputStreamReader(am.open("validwords.txt")));
            String mLine;
            while ((mLine = buffer.readLine()) != null){
                Word_set.add(mLine);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (buffer != null) {
                try{
                    buffer.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);}
            }
        }
        List<String> list = new ArrayList<>(Word_set);
        size = list.size();
        randIdx = new Random().nextInt(size);

        String randomElem = list.get(randIdx);
        word = randomElem.toUpperCase();

    }
    public String getword(){
        return word;}
    public void setWordforcheck(String x){
        check = x;
    }
    public boolean CheckValid(){
        return Word_set.contains(check.toLowerCase());
    }
}

