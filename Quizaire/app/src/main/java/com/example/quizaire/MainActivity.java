package com.example.quizaire;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView optionA, optionB, optionC, optionD;
    TextView questionnumber, question, score;
    TextView checkout1, checkout2;
    int currentIndex;
    int mscore =0;
    int question_number = 1;
    ProgressBar progressbar;
    int Currentquestion, CurrentoptionA, CurrentoptionB, CurrentoptionC, CurrentoptionD;


    private answerclass[] questionBank = new answerclass[]{

            new answerclass(R.string.question_1, R.string.question_1A, R.string.question_1B, R.string.question_1C, R.string.question_1D, R.string.answer_1),
            new answerclass(R.string.question_2, R.string.question_2A, R.string.question_2B, R.string.question_2C, R.string.question_2D, R.string.answer_2),
            new answerclass(R.string.question_3, R.string.question_3A, R.string.question_3B, R.string.question_3C, R.string.question_3D, R.string.answer_3),
            new answerclass(R.string.question_4, R.string.question_4A, R.string.question_4B, R.string.question_4C, R.string.question_4D, R.string.answer_4),
            new answerclass(R.string.question_5, R.string.question_5A, R.string.question_5B, R.string.question_5C, R.string.question_5D, R.string.answer_5),
            new answerclass(R.string.question_6, R.string.question_6A, R.string.question_6B, R.string.question_6C, R.string.question_6D, R.string.answer_6),
            new answerclass(R.string.question_7, R.string.question_7A, R.string.question_7B, R.string.question_7C, R.string.question_7D, R.string.answer_7),
            new answerclass(R.string.question_8, R.string.question_8A, R.string.question_8B, R.string.question_8C, R.string.question_8D, R.string.answer_8),
    };

    final int progress_bar = (int) Math.ceil(100/questionBank.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        optionA = findViewById(R.id.optionA);
        optionB = findViewById(R.id.optionB);
        optionC = findViewById(R.id.optionC);
        optionD = findViewById(R.id.optionD);

        question = findViewById(R.id.question);
        questionnumber = findViewById(R.id.questionnumber);
        score = findViewById(R.id.score);
        checkout1 =findViewById(R.id.selectoption);
        checkout2 = findViewById(R.id.correctanswer);
        progressbar = findViewById(R.id.progressbar);

        Currentquestion = questionBank[currentIndex].getQuestion_id();
        question.setText(Currentquestion);
        CurrentoptionA = questionBank[currentIndex].getOption_A();
        optionA.setText(CurrentoptionA);
        CurrentoptionB = questionBank[currentIndex].getOption_B();
        optionB.setText(CurrentoptionB);
        CurrentoptionC = questionBank[currentIndex].getOption_C();
        optionC.setText(CurrentoptionC);
        CurrentoptionD = questionBank[currentIndex].getOption_D();
        optionD.setText(CurrentoptionD);

        optionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(CurrentoptionA);
                updateQuestion();
            }
        });

        optionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(CurrentoptionB);
                updateQuestion();
            }
        });

        optionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(CurrentoptionC);
                updateQuestion();
            }
        });

        optionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(CurrentoptionD);
                updateQuestion();
            }
        });


    }

    private void updateQuestion() {

        currentIndex = (currentIndex + 1) % questionBank.length;

        if(currentIndex==0){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Game Over");
            alert.setCancelable(false);
            alert.setMessage("Your Score: " + mscore + " Points");
            alert.setPositiveButton("Close Application", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });

            alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    mscore = 0;
                    question_number = 1;
                    progressbar.setProgress(0);
                    score.setText("Score" + mscore + "/" +questionBank.length);
                    questionnumber.setText(question_number + "/" + questionBank.length + "Question");
                }
            });
            alert.show();
        }



        Currentquestion = questionBank[currentIndex].getQuestion_id();
        question.setText(Currentquestion);
        CurrentoptionA = questionBank[currentIndex].getOption_A();
        optionA.setText(CurrentoptionA);
        CurrentoptionB = questionBank[currentIndex].getOption_B();
        optionB.setText(CurrentoptionB);
        CurrentoptionC = questionBank[currentIndex].getOption_C();
        optionC.setText(CurrentoptionC);
        CurrentoptionD = questionBank[currentIndex].getOption_D();
        optionD.setText(CurrentoptionD);

        question_number = question_number + 1;

        if(question_number<questionBank.length){

            questionnumber.setText(question_number + "/" + questionBank.length + "Question");
        }

        score.setText("Score" + mscore + "/" + questionBank.length);
        progressbar.incrementProgressBy(progress_bar);

    }

    private void checkAnswer(int userSelection) {

        int correctanswer = questionBank[currentIndex].getAnswer_id();

        checkout1.setText(userSelection);
        checkout2.setText(correctanswer);

        String m = checkout1.getText().toString().trim();
        String n = checkout2.getText().toString().trim();

        if(m.equals(n)){
            Toast.makeText(this, "Right", Toast.LENGTH_SHORT).show();
            mscore = mscore + 1;
        }
        else{
            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
        }

    }
}