package com.example.abdurahom1706;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FinishActivity extends AppCompatActivity {

    private String ball,correct,error;
    private TextView tvBall1,tvCorrect2,tvError3,textView1;
    private Button btnTamom;
    private ImageView img1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        ball = getIntent().getExtras().getString("ball");
        correct = getIntent().getStringExtra("correct");
        error = getIntent().getStringExtra("error");

        tvBall1 = findViewById(R.id.FinishTVBall);
        tvCorrect2 = findViewById(R.id.FinishTvCorrect);
        tvError3 = findViewById(R.id.FinishTvError);
        img1 = (ImageView) findViewById(R.id.imageView1);
        btnTamom = (Button) findViewById(R.id.BtTamom);
        textView1 = (TextView) findViewById(R.id.YouWinne1);

        setResult();


        btnTamom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FinishActivity.this,MainActivity2.class);
                startActivity(intent);
                finish();
            }
        });

    }
    void setResult(){
        tvBall1.setText(ball);
        tvCorrect2.setText(correct);
        tvError3.setText(error);
        if(Integer.parseInt(ball) >= 90){
            img1.setImageResource(R.drawable.medal_1);
            textView1.setText("You Winner 1");
        }else if(Integer.parseInt(ball) >= 70){
            img1.setImageResource(R.drawable.second_prize_2);
            textView1.setText("You Winner 2");
        }else if(Integer.parseInt(ball)>=50){
           img1.setImageResource(R.drawable.hfdghjfg_76);
           textView1.setText("You Winner 3");
        }else{
            img1.setImageResource(R.drawable.ic_launcher_foreground);
            textView1.setText("You Loser");
        }
    }
}