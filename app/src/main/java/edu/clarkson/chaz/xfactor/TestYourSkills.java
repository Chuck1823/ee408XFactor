package edu.clarkson.chaz.xfactor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class TestYourSkills extends AppCompatActivity {

    private Button a1, a2, a3, a4, backButton, nextQuestion, hint;
    private int int1 = 0;
    private int int2 = 0;
    private int hintCount = 0;
    private int hintRotation = 0;
    private int answer = 0;
    private int answerRotation = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_your_skills);

        final Random randGenerator = new Random();
        final Animation shakeNBake = AnimationUtils.loadAnimation(this, R.anim.shake);
        final TextView dialog = (TextView) findViewById(R.id.dialog);

        a1 = (Button) findViewById(R.id.a1);
        a2 = (Button) findViewById(R.id.a2);
        a3 = (Button) findViewById(R.id.a3);
        a4 = (Button) findViewById(R.id.a4);
        nextQuestion = (Button) findViewById(R.id.next_question);
        backButton = (Button) findViewById(R.id.back_button);
        hint = (Button) findViewById(R.id.hint_button);
        TextView question = (TextView) findViewById(R.id.question);

        int1 = randGenerator.nextInt(10000);
        int2 = randGenerator.nextInt(10000);

        question.setText("What is the product of " + int1 + " and " + int2 + "?");

        answer = int1 * int2;

        dialog.setText("Get three correct answers in a row to activate the hint button!");

        answerRotation = randGenerator.nextInt(4);

        if(answerRotation == 0) {
            a1.setText(String.valueOf(answer));
            a2.setText(String.valueOf(randGenerator.nextInt(99980002)));
            a3.setText(String.valueOf(randGenerator.nextInt(99980002)));
            a4.setText(String.valueOf(randGenerator.nextInt(99980002)));
        } else if (answerRotation == 1) {
            a1.setText(String.valueOf(randGenerator.nextInt(99980002)));
            a2.setText(String.valueOf(answer));
            a3.setText(String.valueOf(randGenerator.nextInt(99980002)));
            a4.setText(String.valueOf(randGenerator.nextInt(99980002)));
        } else if (answerRotation == 2) {
            a1.setText(String.valueOf(randGenerator.nextInt(99980002)));
            a2.setText(String.valueOf(randGenerator.nextInt(99980002)));
            a3.setText(String.valueOf(answer));
            a4.setText(String.valueOf(randGenerator.nextInt(99980002)));
        } else if (answerRotation == 3) {
            a1.setText(String.valueOf(randGenerator.nextInt(99980002)));
            a2.setText(String.valueOf(randGenerator.nextInt(99980002)));
            a3.setText(String.valueOf(randGenerator.nextInt(99980002)));
            a4.setText(String.valueOf(answer));
        }

        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(a1.getText().toString()) == answer) {
                    dialog.setText("Correct!");
                    if(hintCount == 3) {
                        hintCount = 0;
                    } else {
                        hintCount++;
                    }
                } else {
                    dialog.setText("Incorrect!");
                    hintCount = 0;
                }
            }
        });

        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(a2.getText().toString()) == answer) {
                    dialog.setText("Correct!");
                    if(hintCount == 3) {
                        hintCount = 0;
                    } else {
                        hintCount++;
                    }
                } else {
                    dialog.setText("Incorrect!");
                    hintCount = 0;
                }
            }
        });

        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(a3.getText().toString()) == answer) {
                    dialog.setText("Correct!");
                    if(hintCount == 3) {
                        hintCount = 0;
                    } else {
                        hintCount++;
                    }
                } else {
                    dialog.setText("Incorrect!");
                    hintCount = 0;
                }
            }
        });

        a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(a4.getText().toString()) == answer) {
                    dialog.setText("Correct!");
                    if(hintCount == 3) {
                        hintCount = 0;
                    } else {
                        hintCount++;
                    }
                } else {
                    dialog.setText("Incorrect!");
                    hintCount = 0;
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
                int1 = randGenerator.nextInt(10000);
                int2 = randGenerator.nextInt(10000);

                TextView question = (TextView) findViewById(R.id.question);
                final TextView dialog = (TextView) findViewById(R.id.dialog);

                dialog.setText("");

                answer = int1 * int2;

                question.setText("What is the product of " + int1 + " and " + int2 + "?");

                if(hintCount == 3) {
                    hint.startAnimation(shakeNBake);
                    hint.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (hintCount == 3) {
                                dialog.setTextSize(25);
                                hintRotation = randGenerator.nextInt(4);
                                if (hintRotation == 0) {
                                    String firstNum = String.valueOf(int1);
                                    String secondNum = String.valueOf(int2);
                                    dialog.setText("Start by multiplying " + firstNum.substring(firstNum.length() - 1) + " with " + secondNum.substring(secondNum.length() - 1) + ".");
                                    hintCount = 0;
                                } else if (hintRotation == 1) {
                                    int length = String.valueOf(answer).length();
                                    dialog.setText("The answer is " + length + " digits long.");
                                    hintCount = 0;
                                } else if (hintRotation == 2) {
                                    String firstNumTemp = String.valueOf(int1);
                                    String secondNumTemp = String.valueOf(int2);
                                    int firstNum = Integer.parseInt(firstNumTemp.substring(firstNumTemp.length() - 1));
                                    int secondNum = Integer.parseInt(secondNumTemp.substring(secondNumTemp.length() - 1));
                                    int firstProduct = firstNum * secondNum;
                                    dialog.setText("The result of the first product is " + firstProduct + ".");
                                    hintCount = 0;
                                } else if (hintRotation == 3) {
                                    String answerFirstDigit = String.valueOf(answer);
                                    dialog.setText("The first digit of the answer is " + answerFirstDigit.substring(answerFirstDigit.length() - 1) + ".");
                                    hintCount = 0;
                                }
                            }
                        }
                    });
                }


                answerRotation = randGenerator.nextInt(4);

                if(answerRotation == 0) {
                    a1.setText(String.valueOf(answer));
                    a2.setText(String.valueOf(randGenerator.nextInt(99980002)));
                    a3.setText(String.valueOf(randGenerator.nextInt(99980002)));
                    a4.setText(String.valueOf(randGenerator.nextInt(99980002)));
                } else if (answerRotation == 1) {
                    a1.setText(String.valueOf(randGenerator.nextInt(99980002)));
                    a2.setText(String.valueOf(answer));
                    a3.setText(String.valueOf(randGenerator.nextInt(99980002)));
                    a4.setText(String.valueOf(randGenerator.nextInt(99980002)));
                } else if (answerRotation == 2) {
                    a1.setText(String.valueOf(randGenerator.nextInt(99980002)));
                    a2.setText(String.valueOf(randGenerator.nextInt(99980002)));
                    a3.setText(String.valueOf(answer));
                    a4.setText(String.valueOf(randGenerator.nextInt(99980002)));
                } else if (answerRotation == 3) {
                    a1.setText(String.valueOf(randGenerator.nextInt(99980002)));
                    a2.setText(String.valueOf(randGenerator.nextInt(99980002)));
                    a3.setText(String.valueOf(randGenerator.nextInt(99980002)));
                    a4.setText(String.valueOf(answer));
                }
            }
        });
    }
}
