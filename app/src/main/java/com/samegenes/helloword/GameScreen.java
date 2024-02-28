package com.samegenes.helloword;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GameScreen extends AppCompatActivity {
    Dialog dialog;
    String total = "";
    int [] totals = new int[5];
    int[] ordertext = new int[5];
    int[] ordertext1 = {R.id.text1,R.id.text2,R.id.text3,R.id.text4,R.id.text5};
    int[] ordertext2 = {R.id.text11,R.id.text22,R.id.text33,R.id.text44,R.id.text55};
    int[] ordertext3 = {R.id.text111,R.id.text222,R.id.text333,R.id.text444,R.id.text555};
    int[] ordertext4 = {R.id.text1111,R.id.text2222,R.id.text3333,R.id.text4444,R.id.text5555};
    int[] ordertext5 = {R.id.text11111,R.id.text22222,R.id.text33333,R.id.text44444,R.id.text55555};
    int[] ordertext6 = {R.id.text111111,R.id.text222222,R.id.text333333,R.id.text444444,R.id.text555555};
    int count = 0,change = 0,checkpoint=0;
    String target = "TEETH";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
    }
    public void CreatedpopupEnd(){
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.popup);
        if(checkpoint==5){
            dialog.show();}
    }
    public void check(){
        for(int i = 0 ;i < 5;i++){
            TextView vls= findViewById(ordertext[i]);
            TextView vl= findViewById(totals[i]);
            if(target.substring(i,i+1).equals((total.substring(i,i+1)))){
                checkpoint++;
                vls.setBackgroundColor(android.graphics.Color.parseColor("#00FF00"));
                vl.setBackgroundColor(android.graphics.Color.parseColor("#00FF00"));
            }else if(target.contains(total.substring(i, i + 1))){
                vls.setBackgroundColor(android.graphics.Color.parseColor("#FFFF00"));
                vl.setBackgroundColor(android.graphics.Color.parseColor("#FFFF00"));
            }else{
                vls.setBackgroundColor(android.graphics.Color.parseColor("#B3B6B7"));
                vl.setBackgroundColor(android.graphics.Color.parseColor("#B3B6B7"));
            }
        }
        CreatedpopupEnd();
        checkpoint  =0;

    }
    public void clickLetter(View v) { //ส่วนของแป้นพิมพ์ตรงนี้น่าจะครบละ
        if(change == 0){
            ordertext = ordertext1;
        }else if(change == 1){
            ordertext = ordertext2;
        }else if(change == 2){
            ordertext = ordertext3;
        }else if(change == 3){
            ordertext = ordertext4;
        }else if(change == 4){
            ordertext = ordertext5;
        }else if(change == 5){
            ordertext = ordertext6;
        }
        TextView vl= findViewById(ordertext[count]);
        int y = v.getId();
        if(y == R.id.topp){
            TextView test = findViewById(R.id.topp);
            test.setText(String.valueOf(checkpoint));
        }
        else if( (y == R.id.Delete) && (count == 4) ){
            if(vl.getText().equals("")){
                TextView vlx= findViewById(ordertext[count-1]);
                vlx.setText("");
                count--;
            }else {
                vl.setText("");
            }
            total = total.substring(0,total.length()-1);
        }
        else if(count<0) {
            count = 0;
        } else if(count<5) {
            TextView x = findViewById(y);
            if (y == R.id.Delete) {
                TextView ch = findViewById(y);
                ch.setBackgroundColor(android.graphics.Color.parseColor("#D0D3D4"));
                if(count == 0){
                    vl.setText("");

                }else if(vl.getText().equals("")){
                    TextView vlx= findViewById(ordertext[count-1]);
                    vlx.setText("");
                    count--;
                    total = total.substring(0,total.length()-1);
                }else{
                    vl.setText("");
                    total = total.substring(0,total.length()-1);
                }
            } else if (y == R.id.Enter){
                if(total.length() <5){
                    //ถ้าหากใส่คำไม่ครบแล้วกดEnter
                }else{
                    check();
                    change++;
                    count = 0;
                    total = "";

                }
            } else {
                if(count == 4){
                    vl.setText(x.getText().toString());
                    total += x.getText().toString();
                    totals[count] = y;
                }else {
                    vl.setText(x.getText().toString());
                    totals[count] = y;
                    total += x.getText().toString();
                    count++;
                }
            }
        }
    }
}