package com.example.chohaeun.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
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
    public int mScore = 0;
    private int questionsLength = questions.mQuestions.length;
    private int qCount = 0;

    Random r;

    int alreadyPlayed =0;

    TextView score, question;

    Button answerA, answerB, answerC, answerD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        r = new Random();

        answerA = (Button) findViewById(R.id.button);
        answerB = (Button) findViewById(R.id.button2);
        answerC = (Button) findViewById(R.id.button3);
        answerD = (Button) findViewById(R.id.button4);

        score = (TextView) findViewById(R.id.score);
        question = (TextView) findViewById(R.id.textView2);

        score.setText("Score: " + mScore + "/" + questionsLength);

        updateQuestion(alreadyPlayed);

        answerA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alreadyPlayed++;
                if(answerA.getText() == mAnswer) {
                    mScore++;
                    correctAnswer();
                    answerA.setBackgroundColor(Color.GREEN);
                }
                else {
                    answerA.setBackgroundColor(Color.RED);
                    incorrectAnswer();
                }
            }
        });

        answerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alreadyPlayed++;
                if(answerB.getText() == mAnswer){
                    mScore++;
                    correctAnswer();
                    answerB.setBackgroundColor(Color.GREEN);
             }

                else {
                    answerB.setBackgroundColor(Color.RED);
                    incorrectAnswer();
                }

            }
        });

        answerC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alreadyPlayed++;
                if(answerC.getText() == mAnswer){
                    mScore++;
                    answerC.setBackgroundColor(Color.GREEN);
                    correctAnswer();                }

                else {
                    answerC.setBackgroundColor(Color.RED);
                    incorrectAnswer();
                }


            }
        });

        answerD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alreadyPlayed++;
                if(answerD.getText() == mAnswer){
                    mScore++;
                    answerD.setBackgroundColor(Color.GREEN);
                    correctAnswer();
                }

                else {
                    answerD.setBackgroundColor(Color.RED);
                    incorrectAnswer();
                }



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

    public void correctAnswer(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Correct!")
                //.setMessage("Final Score is " + mScore + "/10")

                .setPositiveButton("Next", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        score.setText("Score: " + mScore + "/" + questionsLength);
                        updateQuestion(alreadyPlayed);
                        qCount++;
                        resetColor(answerA);
                        resetColor(answerB);
                        resetColor(answerC);
                        resetColor(answerD);
                        if(qCount == 10) {
                            endgame();
                        }
                    }
                })

                .show();

    }

    public void incorrectAnswer(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Incorrect!")
                .setMessage("The correct answer is " + mAnswer)

                .setPositiveButton("Next", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        score.setText("Score: " + mScore + "/" + questionsLength);
                        qCount++;
                        resetColor(answerA);
                        resetColor(answerB);
                        resetColor(answerC);
                        resetColor(answerD);
                        if(qCount == 10) {
                            endgame();
                        }
                        else{
                            updateQuestion(alreadyPlayed);
                        }
                    }
                })

                .show();

    }

    public void endgame() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Game Over")
                .setMessage("Final Score is " + mScore + "/10")

                .setNegativeButton("Play Again", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        recreate();
                    }
                })
                .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MainActivity.this, welcomeScreen.class);
                        startActivity(intent);
                    }
                })

                .show()
                .setCancelable(false);
    }

    public void resetColor(Button b)
    {
        b.setBackgroundResource(android.R.drawable.btn_default);
    }
}
