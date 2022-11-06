package com.example.abdurahom1706;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abdurahom1706.Modul.Questions;

public class EnglishProgramActivity extends AppCompatActivity {

    private RadioGroup rg;
    private RadioButton rb1,rb2,rb3,rb4,rbtanlanganlar;
    private TextView textRaqam,textSavol;
    private Button btn2;
    private int questionid = 0;
    private int ball = 0;
    private int correct = 0;
    private int error = 0;
    private Questions questions = new Questions();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_program);
        
        btn2 = (Button) findViewById(R.id.button2);
        textRaqam = (TextView) findViewById(R.id.textRaqam);
        textSavol = (TextView) findViewById(R.id.textSavol);
        rg = (RadioGroup) findViewById(R.id.radio2Group);
        rb1 = (RadioButton) findViewById(R.id.radioButton2);
        rb2 = (RadioButton) findViewById(R.id.radio2Button2);
        rb3 = (RadioButton) findViewById(R.id.radio2Button3);
        rb4 = (RadioButton) findViewById(R.id.radio2Button4);

        setQuestions();

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checAns();
                if (questionid == 5) {
                    Intent i = new Intent(EnglishProgramActivity.this,
                            FinishActivity.class);

                    i.putExtra("ball",String.valueOf(ball));
                    i.putExtra("correct", String.valueOf(correct));
                    i.putExtra("error", String.valueOf(error));
                    startActivity(i);
                }
            }
        });
    }

    private void checAns() {
        int id = rg.getCheckedRadioButtonId();
        if (id > 0) {
            rbtanlanganlar = (RadioButton) findViewById(id);
            if (questions.trueEnglsh[questionid] == rbtanlanganlar.getText().toString()) {
                rbtanlanganlar.setChecked(false);
                ball += 20;
                correct++;
                questionid++;
            } else {
                rbtanlanganlar.setChecked(false);
                questionid++;
                error++;
                ball -= 5;
            }
            if (questionid == questions.questionEnglsh.length) {
                Intent i = new Intent(EnglishProgramActivity.this,FinishActivity.class);
                i.putExtra("ball", String.valueOf(ball));
                i.putExtra("correct", String.valueOf(correct));
                i.putExtra("error", String.valueOf(error));
                startActivity(i);
            } else {
                setQuestions();
            }
        }else {
            Toast.makeText( EnglishProgramActivity.this, "Tanla", Toast.LENGTH_SHORT).show();
        }

    }


    void setQuestions(){
        int savolRaqam = questionid;
        textRaqam.setText(String.format("%s", savolRaqam += 1));
        String a = questions.questionEnglsh[questionid];
        textSavol.setText(a);
        rb1.setText(questions.answersEnglsh[questionid][0]);
        rb2.setText(questions.answersEnglsh[questionid][1]);
        rb3.setText(questions.answersEnglsh[questionid][2]);
        rb4.setText(questions.answersEnglsh[questionid][3]);
    }



}