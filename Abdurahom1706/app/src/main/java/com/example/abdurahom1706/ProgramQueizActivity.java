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

public class ProgramQueizActivity extends AppCompatActivity {


    private RadioGroup rg;
    private RadioButton rb1,rb2,rb3,rb4,rbtanlanganlar;
    private TextView textRaqam,textSavol;
    private Button btn1;
    private int questionid = 0;
    private int ball = 0;
    private int correct = 0;
    private int error = 0;
    private Questions questions = new Questions();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_quiz);



        btn1 = (Button) findViewById(R.id.button1);
        textRaqam = (TextView) findViewById(R.id.textRaqam);
        textSavol = (TextView) findViewById(R.id.textSavol);
        rg = (RadioGroup) findViewById(R.id.radio1Group);
        rb1 = (RadioButton) findViewById(R.id.radioButton1);
        rb2 = (RadioButton) findViewById(R.id.radio1Button2);
        rb3 = (RadioButton) findViewById(R.id.radio1Button3);
        rb4 = (RadioButton) findViewById(R.id.radio1Button4);

        setQuestions();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checAns();
                if (questionid == 5) {
                    Intent i = new Intent(ProgramQueizActivity.this,
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
            if (questions.trueProgram[questionid] == rbtanlanganlar.getText().toString()) {
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
            if (questionid == questions.questionProgram.length) {
                Intent i = new Intent(ProgramQueizActivity.this,FinishActivity.class);
                i.putExtra("ball", String.valueOf(ball));
                i.putExtra("correct", String.valueOf(correct));
                i.putExtra("error", String.valueOf(error));
                startActivity(i);
            } else {
                setQuestions();
            }
        }else {
            Toast.makeText( ProgramQueizActivity.this, "Tanla", Toast.LENGTH_SHORT).show();
        }


    }
    void setQuestions() {
        int savolRaqam = questionid;
        textRaqam.setText(String.format("%s", savolRaqam += 1));
        String a = questions.questionProgram[questionid];
        textSavol.setText(a);
        rb1.setText(questions.answersProgram[questionid][0]);
        rb2.setText(questions.answersProgram[questionid][1]);
        rb3.setText(questions.answersProgram[questionid][2]);
        rb4.setText(questions.answersProgram[questionid][3]);
    }
}
