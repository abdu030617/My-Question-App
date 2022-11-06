package com.example.abdurahom1706;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private LinearLayout btnP, btnE, btnM;
    private Button btn;
    private int intentNamber = 0;
    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn = (Button) findViewById(R.id.button);
        btnP = (LinearLayout) findViewById(R.id.mainPrograming);
        btnE = (LinearLayout) findViewById(R.id.mainEnglish);
        btnM = (LinearLayout) findViewById(R.id.mainMathematic);

        btnP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLayoutBackgroundOnClic(btnP,R.id.imageProgramma,R.id.textProgramma, R.drawable.web_programming_white);
                setLayoutBackgroundOnBack(btnM,R.id.imageMathematic,R.id.textMathematik, R.drawable.ic_math);
                setLayoutBackgroundOnBack(btnE,R.id.imageEnglish,R.id.textEnlish,R.drawable.ic_eng);
                intentNamber = 1;

            }
        });
        btnE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLayoutBackgroundOnBack(btnP,R.id.imageProgramma,R.id.textProgramma,R.drawable.ic_programming);
                setLayoutBackgroundOnBack(btnM,R.id.imageMathematic,R.id.textMathematik,R.drawable.ic_math);
                setLayoutBackgroundOnClic(btnE,R.id.imageEnglish,R.id.textEnlish,R.drawable.understanding_white);
                intentNamber = 2;
            }
        });
        btnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLayoutBackgroundOnBack(btnP,R.id.imageProgramma,R.id.textProgramma,
                        R.drawable.ic_programming);
                setLayoutBackgroundOnClic(btnM,R.id.imageMathematic,R.id.textMathematik,
                        R.drawable.math_white);
                setLayoutBackgroundOnBack(btnE,R.id.imageEnglish,R.id.textEnlish,
                        R.drawable.ic_eng);
                intentNamber = 3;
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (intentNamber == 1 ){
                    i = new Intent(MainActivity2.this, ProgramQueizActivity.class);
                }else if (intentNamber == 2){
                    i = new Intent(MainActivity2.this, EnglishProgramActivity.class);
                }else if (intentNamber == 3){
                    i = new Intent(MainActivity2.this,MathActivity.class);
                }else {
                    Toast.makeText(MainActivity2.this, "Testlardan birini tanlang", Toast.LENGTH_SHORT).show();
                }
                if (intentNamber != 0){
                    startActivity(i);
                }
            }
        });


    }
    void setLayoutBackgroundOnClic(View view,int img, int text, int newImg){
        ImageView image = (ImageView) findViewById(img);
        TextView textView = (TextView) findViewById(text);
        view.setBackgroundColor(Color.parseColor("#A257EB"));
        image.setImageResource(newImg);
        textView.setTextColor(Color.WHITE);
    }
    void setLayoutBackgroundOnBack(View view,int img, int text, int newImg){
        ImageView image = (ImageView) findViewById(img);
        TextView textView = (TextView) findViewById(text);
        view.setBackgroundColor(Color.WHITE);
        image.setImageResource(newImg);
        textView.setTextColor(Color.parseColor("#000000"));
    }
}
