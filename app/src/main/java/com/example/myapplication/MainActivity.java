package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private String[] questions = {
            "Java is a person?", "Java was introduced in 1233?",
            "Java was created using Python?", "Java has abstract classes?",
            "Java supports interface?", "Java was created by CodeWithHarry in India?"
    };
    private boolean[] answer = {false, false, false, true, true, false};
    private int score = 0;
    private Button yes;
    private Button no;  // Corrected name to lowercase 'no'
    private int index = 0;

    private TextView question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);  // Corrected name to lowercase 'no'
        question = findViewById(R.id.question);
        question.setText(questions[index]);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index <= questions.length - 1) {
                    if (answer[index]) {  // Correct answer
                        score++;
                    }
                    index++;  // Move to next question
                    if (index <= questions.length - 1) {
                        question.setText(questions[index]);
                    } else {
                        Toast.makeText(MainActivity.this, "Your score is: " + score + "/" + questions.length, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Restart the app to play again", Toast.LENGTH_SHORT).show();
                }
            }
        });

        no.setOnClickListener(new View.OnClickListener() {  // Corrected name to lowercase 'no'
            @Override
            public void onClick(View v) {
                if (index <= questions.length - 1) {
                    if (!answer[index]) {  // Corrected name to 'answer'
                        score++;
                    }
                    index++;  // Move to next question
                    if (index <= questions.length - 1) {
                        question.setText(questions[index]);
                    } else {
                        Toast.makeText(MainActivity.this, "Your score is: " + score + "/" + questions.length, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Restart the app to play again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}