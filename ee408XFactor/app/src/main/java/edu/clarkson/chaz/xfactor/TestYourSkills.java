package edu.clarkson.chaz.xfactor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class TestYourSkills extends AppCompatActivity {

    private Button a1, a2, a3, a4, backButton, nextQuestion;
    private int int1 = 0;
    private int int2 = 0;
    private int answer = 0;
    private int rotation = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_your_skills);

        final Random randGenerator = new Random();

        a1 = (Button) findViewById(R.id.a1);
        a2 = (Button) findViewById(R.id.a2);
        a3 = (Button) findViewById(R.id.a3);
        a4 = (Button) findViewById(R.id.a4);
        nextQuestion = (Button) findViewById(R.id.nextQuestion);
        backButton = (Button) findViewById(R.id.back_button);
        final TextView dialog = (TextView) findViewById(R.id.dialog);
        TextView question = (TextView) findViewById(R.id.question);

        int1 = randGenerator.nextInt(101);
        int2 = randGenerator.nextInt(101);

        question.setText("What is the product of " + int1 + " and " + int2 + "?");

        answer = int1 * int2;

        rotation = randGenerator.nextInt(4);

        if(rotation == 0) {
            a1.setText(String.valueOf(answer));
            a2.setText(String.valueOf(randGenerator.nextInt(10001)));
            a3.setText(String.valueOf(randGenerator.nextInt(10001)));
            a4.setText(String.valueOf(randGenerator.nextInt(10001)));
        } else if (rotation == 1) {
            a1.setText(String.valueOf(randGenerator.nextInt(10001)));
            a2.setText(String.valueOf(answer));
            a3.setText(String.valueOf(randGenerator.nextInt(10001)));
            a4.setText(String.valueOf(randGenerator.nextInt(10001)));
        } else if (rotation == 2) {
            a1.setText(String.valueOf(randGenerator.nextInt(10001)));
            a2.setText(String.valueOf(randGenerator.nextInt(10001)));
            a3.setText(String.valueOf(answer));
            a4.setText(String.valueOf(randGenerator.nextInt(10001)));
        } else if (rotation == 3) {
            a1.setText(String.valueOf(randGenerator.nextInt(10001)));
            a2.setText(String.valueOf(randGenerator.nextInt(10001)));
            a3.setText(String.valueOf(randGenerator.nextInt(10001)));
            a4.setText(String.valueOf(answer));
        }

        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(a1.getText().toString()) == answer) {
                    dialog.setText("Correct!");
                } else {
                    dialog.setText("Incorrect!");
                }
            }
        });

        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(a2.getText().toString()) == answer) {
                    dialog.setText("Correct!");
                } else {
                    dialog.setText("Incorrect!");
                }
            }
        });

        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(a3.getText().toString()) == answer) {
                    dialog.setText("Correct!");
                } else {
                    dialog.setText("Incorrect!");
                }
            }
        });

        a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(a4.getText().toString()) == answer) {
                    dialog.setText("Correct!");
                } else {
                    dialog.setText("Incorrect!");
                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TestYourSkills.this, Menu.class));
            }
        });

        nextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int1 = randGenerator.nextInt(101);
                int2 = randGenerator.nextInt(101);

                TextView question = (TextView) findViewById(R.id.question);
                TextView dialog = (TextView) findViewById(R.id.dialog);

                dialog.setText("");

                answer = int1 * int2;

                question.setText("What is the product of " + int1 + " and " + int2 + "?");

                rotation = randGenerator.nextInt(4);

                if(rotation == 0) {
                    a1.setText(String.valueOf(answer));
                    a2.setText(String.valueOf(randGenerator.nextInt(10001)));
                    a3.setText(String.valueOf(randGenerator.nextInt(10001)));
                    a4.setText(String.valueOf(randGenerator.nextInt(10001)));
                } else if (rotation == 1) {
                    a1.setText(String.valueOf(randGenerator.nextInt(10001)));
                    a2.setText(String.valueOf(answer));
                    a3.setText(String.valueOf(randGenerator.nextInt(10001)));
                    a4.setText(String.valueOf(randGenerator.nextInt(10001)));
                } else if (rotation == 2) {
                    a1.setText(String.valueOf(randGenerator.nextInt(10001)));
                    a2.setText(String.valueOf(randGenerator.nextInt(10001)));
                    a3.setText(String.valueOf(answer));
                    a4.setText(String.valueOf(randGenerator.nextInt(10001)));
                } else if (rotation == 3) {
                    a1.setText(String.valueOf(randGenerator.nextInt(10001)));
                    a2.setText(String.valueOf(randGenerator.nextInt(10001)));
                    a3.setText(String.valueOf(randGenerator.nextInt(10001)));
                    a4.setText(String.valueOf(answer));
                }
            }
        });
    }
}
