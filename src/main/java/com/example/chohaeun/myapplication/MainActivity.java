package com.example.chohaeun.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Questions questions = new Questions();
    private String mAnswer;
    private int mScore = 0;
    private int questionsLength = questions.mQuestions.length;
    private int qCount = 0;

    Random r;

    TextView score, question;

    Button answerA, answerB, answerC, answerD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        r = new Random();

        answerA = (Button) findViewById(R.id.button);
        answerB = (Button) findViewById(R.id.button2);
        answerC = (Button) findViewById(R.id.button3);
        answerD = (Button) findViewById(R.id.button4);

        score = (TextView) findViewById(R.id.score);
        question = (TextView) findViewById(R.id.textView2);

        score.setText("Score: " + mScore);

        updateQuestion(r.nextInt(questionsLength));

        answerA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answerA.getText() == mAnswer){
                    mScore++;
                    score.setText("Score: " + mScore + "/" + questionsLength);
                    updateQuestion(r.nextInt(questionsLength));
                }

                else {
                    updateQuestion(r.nextInt(questionsLength));
                    answerA.setHighlightColor(Color.RED);
                }

                qCount++;

            }
        });

        answerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answerB.getText() == mAnswer){
                    mScore++;
                    score.setText("Score: " + mScore + "/" + questionsLength);
                    updateQuestion(r.nextInt(questionsLength));
                }

                else {
                    updateQuestion(r.nextInt(questionsLength));
                }

                qCount++;
            }
        });

        answerC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answerC.getText() == mAnswer){
                    mScore++;
                    score.setText("Score: " + mScore + "/" + questionsLength);
                    updateQuestion(r.nextInt(questionsLength));
                }

                else {
                    updateQuestion(r.nextInt(questionsLength));
                }
                qCount++;
            }
        });

        answerD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answerD.getText() == mAnswer){
                    mScore++;
                    score.setText("Score: " + mScore + "/" + questionsLength);
                    updateQuestion(r.nextInt(questionsLength));
                }

                else {
                    updateQuestion(r.nextInt(questionsLength));
                }
                qCount++;
            }
        });
    }

    private void updateQuestion(int n){
        question.setText(questions.getQuestion(n));
        answerA.setText(questions.getChoice1(n));
        answerB.setText(questions.getChoice2(n));
        answerC.setText(questions.getChoice3(n));
        answerD.setText(questions.getChoice4(n));

        mAnswer = questions.getAnswer(n);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
