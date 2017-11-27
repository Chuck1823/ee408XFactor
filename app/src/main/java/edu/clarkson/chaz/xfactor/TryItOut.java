package edu.clarkson.chaz.xfactor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TryItOut extends AppCompatActivity {

    private EditText num1;
    private EditText num2;

    private TextView num1_dig3;
    private TextView num1_dig2;
    private TextView num1_dig1;

    private TextView num2_dig3;
    private TextView num2_dig2;
    private TextView num2_dig1;

    private TextView carry_dig3;
    private TextView carry_dig2;
    private TextView carry_dig1;

    private TextView answer_H4;
    private TextView answer_H3;
    private TextView answer_H2;
    private TextView answer_H1;

    private TextView answer_T4;
    private TextView answer_T3;
    private TextView answer_T2;
    private TextView answer_T1;

    private TextView answer_O4;
    private TextView answer_O3;
    private TextView answer_O2;
    private TextView answer_O1;

    private TextView sum_6;
    private TextView sum_5;
    private TextView sum_4;
    private TextView sum_3;
    private TextView sum_2;
    private TextView sum_1;

    private Button submit, previous, menu, next;

    private int page_num; //-1==nums not set; 1 and on is page number; once submit defaults to 1
    private int max_page_num;
    private int ans_O_1, ans_O_2, ans_O_3, ans_O_4, ans_T_1, ans_T_2, ans_T_3, ans_T_4, ans_H_1, ans_H_2, ans_H_3, ans_H_4, ans_Th_1, ans_Th_2, ans_Th_3, ans_Th_4, sum1, sum2, sum3, sum4, sum5, sum6, carryO1, carryO2, carryO3, carryO4, carryT1, carryT2, carryT3, carryT4, carryH1, carryH2, carryH3, carryH4;

    private void steps() {
        if (max_page_num == 3) {
            if (page_num > 1) {
                answer_O1.setText(Integer.toString(ans_O_1));
                answer_O2.setText(Integer.toString(carryO1));
            }
            if (page_num == 3) {
                sum_1.setText(answer_O1.getText());
                sum_2.setText(answer_O2.getText());
            }
        }else if (max_page_num == 4) {
            if (page_num > 1) {
                answer_O1.setText(Integer.toString(ans_O_1));
                answer_O2.setText(Integer.toString(carryO1));
            }
            if (page_num > 2) {
                answer_O2.setText(Integer.toString(ans_O_2));
                answer_O3.setText(Integer.toString(carryO2));
            }
            if (page_num == 4) {
                sum_1.setText(answer_O1.getText());
                sum_2.setText(answer_O2.getText());
                sum_3.setText(answer_O3.getText());
            }
        }else if (max_page_num == 5) {
            if (page_num > 1) {
                answer_O1.setText(Integer.toString(ans_O_1));
                answer_O2.setText(Integer.toString(carryO1));
            }
            if (page_num > 2) {
                answer_O2.setText(Integer.toString(ans_O_2));
                answer_O3.setText(Integer.toString(carryO2));
            }
            if(page_num > 3) {
                answer_O3.setText(Integer.toString(ans_O_3));
                answer_O4.setText(Integer.toString(carryO4));
            }
            if (page_num == 5) {
                sum_1.setText(answer_O1.getText());
                sum_2.setText(answer_O2.getText());
                sum_3.setText(answer_O3.getText());
                sum_4.setText(answer_O4.getText());
            }
        }else if (max_page_num == 6) {
            if (page_num > 1) {
                answer_O1.setText(Integer.toString(ans_O_1));
                answer_O2.setText(Integer.toString(carryO1));
            }
            if (page_num > 2) {
                answer_O2.setText(Integer.toString(ans_O_2));
                answer_O3.setText(Integer.toString(carryO2));
            }
            if(page_num > 3) {
                answer_T1.setText(Integer.toString(ans_T_1));
                answer_T2.setText(Integer.toString(carryT1));
            }
            if (page_num > 4) {
                answer_T2.setText(Integer.toString(ans_T_2));
                answer_T3.setText(Integer.toString(carryT2));
            }
            if (page_num == 6) {
                sum_1.setText(answer_O1.getText());
                sum_2.setText(Integer.toString(ans_O_2 + ans_T_1));
                sum_3.setText(Integer.toString(ans_O_3 + ans_T_2));
                sum_4.setText(answer_T3.getText());
            }

        }else if (max_page_num == 8) {
            if (page_num > 1) {
                answer_O1.setText(Integer.toString(ans_O_1));
                answer_O2.setText(Integer.toString(carryO1));
            }
            if (page_num > 2) {
                answer_O2.setText(Integer.toString(ans_O_2));
                answer_O3.setText(Integer.toString(carryO2));
            }
            if(page_num > 3) {
                answer_O3.setText(Integer.toString(ans_O_3));
                answer_O4.setText(Integer.toString(carryO4));
            }
            if(page_num > 4) {
                answer_T1.setText(Integer.toString(ans_T_1));
                answer_T2.setText(Integer.toString(carryT1));
            }
            if (page_num > 5) {
                answer_T2.setText(Integer.toString(ans_T_2));
                answer_T3.setText(Integer.toString(carryT2));
            }
            if (page_num > 6) {
                answer_T3.setText(Integer.toString(ans_T_2));
                answer_T4.setText(Integer.toString(carryT3));
            }
            if (page_num == 8) {
                sum_1.setText(answer_O1.getText());
                sum_2.setText(Integer.toString(ans_O_2 + ans_T_1));
                sum_3.setText(Integer.toString(ans_O_3 + ans_T_2));
                sum_4.setText(Integer.toString(ans_O_4 + ans_T_3));
                sum_5.setText(answer_T4.getText());
            }

        }else {
            if (page_num > 1) {
                answer_O1.setText(Integer.toString(ans_O_1));
                answer_O2.setText(Integer.toString(carryO1));
            }
            if (page_num > 2) {
                answer_O2.setText(Integer.toString(ans_O_2));
                answer_O3.setText(Integer.toString(carryO2));
            }
            if(page_num > 3) {
                answer_O3.setText(Integer.toString(ans_O_3));
                answer_O4.setText(Integer.toString(carryO4));
            }
            if(page_num > 4) {
                answer_T1.setText(Integer.toString(ans_T_1));
                answer_T2.setText(Integer.toString(carryT1));
            }
            if (page_num > 5) {
                answer_T2.setText(Integer.toString(ans_T_2));
                answer_T3.setText(Integer.toString(carryT2));
            }
            if (page_num > 6) {
                answer_T3.setText(Integer.toString(ans_T_3));
                answer_T4.setText(Integer.toString(carryT3));
            }
            if (page_num > 7) {
                answer_H1.setText(Integer.toString(ans_H_1));
                answer_H2.setText(Integer.toString(carryH1));
            }
            if (page_num > 8) {
                answer_H2.setText(Integer.toString(ans_H_2));
                answer_H3.setText(Integer.toString(carryH2));
            }
            if (page_num > 9) {
                answer_H3.setText(Integer.toString(ans_H_3));
                answer_H4.setText(Integer.toString(carryH3));
            }
            if (page_num == 11) {
                sum_1.setText(answer_O1.getText());
                sum_2.setText(Integer.toString(ans_O_2 + ans_T_1));
                sum_3.setText(Integer.toString(ans_O_3 + ans_T_2 + ans_H_1));
                sum_4.setText(Integer.toString(ans_O_4 + ans_T_3 + ans_H_2));
                sum_5.setText(Integer.toString(ans_T_4 + ans_H_3));
                sum_6.setText(Integer.toString(ans_H_3));
            }
        }
    }

    //clears all answers, makes steps easier
    private void clearAns() {
        answer_H4.setText("");
        answer_H3.setText("");
        answer_H2.setText("");
        answer_H1.setText("");
        answer_T4.setText("");
        answer_T3.setText("");
        answer_T2.setText("");
        answer_T1.setText("");
        answer_O4.setText("");
        answer_O3.setText("");
        answer_O2.setText("");
        answer_O1.setText("");
        sum_1.setText("");
        sum_2.setText("");
        sum_3.setText("");
        sum_4.setText("");
        sum_5.setText("");
        sum_6.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try_it_out);

        submit = (Button)findViewById(R.id.submit_nums);
        previous = (Button)findViewById(R.id.previous);
        menu = (Button)findViewById(R.id.menu);
        next = (Button)findViewById(R.id.next);

        num1_dig1 = (TextView)findViewById(R.id.num1_O);
        num1_dig2 = (TextView)findViewById(R.id.num1_T);
        num1_dig3 = (TextView)findViewById(R.id.num1_H);

        num2_dig1 = (TextView)findViewById(R.id.num2_O);
        num2_dig2 = (TextView)findViewById(R.id.num2_T);
        num2_dig3 = (TextView)findViewById(R.id.num2_H);

        carry_dig1 = (TextView)findViewById(R.id.carry_T);
        carry_dig2 = (TextView)findViewById(R.id.carry_H);
        carry_dig3 = (TextView)findViewById(R.id.carry_Th);

        answer_H1 = (TextView)findViewById(R.id.answer_H1);
        answer_H2 = (TextView)findViewById(R.id.answer_H2);
        answer_H3 = (TextView)findViewById(R.id.answer_H3);
        answer_H4 = (TextView)findViewById(R.id.answer_H4);

        answer_T1 = (TextView)findViewById(R.id.answer_T1);
        answer_T2 = (TextView)findViewById(R.id.answer_T2);
        answer_T3 = (TextView)findViewById(R.id.answer_T3);
        answer_T4 = (TextView)findViewById(R.id.answer_T4);

        answer_O1 = (TextView)findViewById(R.id.answer_O1);
        answer_O2 = (TextView)findViewById(R.id.answer_O2);
        answer_O3 = (TextView)findViewById(R.id.answer_O3);
        answer_O4 = (TextView)findViewById(R.id.answer_O4);

        sum_1 = (TextView)findViewById(R.id.sum_1);
        sum_2 = (TextView)findViewById(R.id.sum_2);
        sum_3 = (TextView)findViewById(R.id.sum_3);
        sum_4 = (TextView)findViewById(R.id.sum_4);
        sum_5 = (TextView)findViewById(R.id.sum_5);
        sum_6 = (TextView)findViewById(R.id.sum_6);

        num1 = (EditText)findViewById(R.id.num1);
        num2 = (EditText)findViewById(R.id.num2);

        page_num = -1;



        //Submit listener
        View.OnClickListener submitNums = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Retrieve Values and initialize numbers
                int dig1;
                int dig2;
                int num1_val = Integer.parseInt(num1.getText().toString());
                int num2_val = Integer.parseInt(num2.getText().toString());

                if (num1_val < num2_val) {
                    int temp = num1_val;
                    num1_val = num2_val;
                    num2_val = temp;
                }

                int num1_H_val = num1_val / 100;
                int num1_T_val = (num1_val - (num1_H_val * 100)) / 10;
                int num1_O_val = (num1_val - (num1_H_val * 100) - (num1_T_val * 100));

                int num2_H_val = num2_val / 100;
                int num2_T_val = (num2_val - (num2_H_val * 100)) / 10;
                int num2_O_val = (num2_val - (num2_H_val * 100) - (num2_T_val * 10));

                if (num1_H_val != 0) {
                    num1_dig3.setText(Integer.toString(num1_H_val));
                    num2_dig2.setText(Integer.toString(num1_T_val));
                    dig1 = 3;
                }else if (num1_T_val == 0 && num1_H_val != 0) {
                    num1_dig2.setText(Integer.toString(num1_T_val));
                    dig1 = 2;
                }else {
                    dig1 = 1;
                }

                num1_dig1.setText(Integer.toString(num1_O_val));

                if (num2_H_val != 0) {
                    num2_dig3.setText(Integer.toString(num2_H_val));
                    num2_dig2.setText(Integer.toString(num2_T_val));
                    dig2 = 3;
                }else if (num2_T_val == 0 && num2_H_val != 0) {
                    num2_dig2.setText(Integer.toString(num2_T_val));
                    dig2 = 2;
                }else {
                    dig2 = 1;
                }

                num2_dig1.setText(Integer.toString(num2_O_val));

                page_num = 1;

                //Make all calculations
                max_page_num = 3;
                ans_O_1 = num1_O_val * num2_O_val;
                carryO1 = ans_O_1 / 10;
                ans_O_1 = ans_O_1 % 10;
                if (dig2 > 1) {
                    max_page_num = 4;
                    ans_T_1 = num1_O_val * num2_T_val;
                    carryT1 = ans_T_1 / 10;
                    ans_T_1 = ans_T_1 % 10;
                }
                if (dig2 > 2) {
                    max_page_num = 5;
                    ans_H_1 = num1_O_val * num2_H_val;
                    carryH1 = ans_H_1 / 10;
                    ans_H_1 = ans_H_1 % 10;
                }
                if (dig1 > 1) {
                    max_page_num = 4;
                    ans_O_2 = num1_T_val * num2_O_val + carryO1;
                    carryO2 = ans_O_2 / 10;
                    ans_O_2 = ans_O_2 % 10;
                    if (dig2 > 1) {
                        max_page_num = 6;
                        ans_T_2 = num1_T_val * num2_T_val + carryT1;
                        carryT2 = ans_T_2 / 10;
                        ans_T_2 = ans_T_2 % 10;
                    }
                    if (dig2 > 2){
                        max_page_num = 8;
                        ans_H_2 = num1_T_val * num2_H_val + carryH1;
                        carryH2 = ans_H_2 / 10;
                        ans_H_2 = ans_H_2 % 10;
                    }
                }
                if (dig1 > 2) {
                    max_page_num = 5;
                    ans_O_3 = num1_H_val * num2_O_val + carryO2;
                    carryO3 = ans_O_3 / 10;
                    ans_O_3 = ans_O_3 % 10;
                    if (dig2 > 1) {
                        max_page_num = 8;
                        ans_T_3 = num1_H_val * num2_T_val + carryT2;
                        carryT3 = ans_T_3 / 10;
                        ans_T_3 = ans_T_3 % 10;
                    }
                    if (dig2 > 2 ) {
                        max_page_num = 11;
                        ans_H_3 = num1_H_val * num2_H_val + carryT3;
                        carryH3 = ans_H_3 / 10;
                        ans_H_3 = ans_H_3 % 10;
                    }
                }
            }

        };

        View.OnClickListener prevPage = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (page_num > 1) {
                    page_num--;
                    clearAns();
                    steps();
                }

            }
        };

        View.OnClickListener nextPage = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (page_num < max_page_num) {
                    page_num++;
                    clearAns();
                    steps();
                }

            }
        };

        View.OnClickListener mainMenu = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TryItOut.this, Menu.class));

            }
        };

        submit.setOnClickListener(submitNums);
        previous.setOnClickListener(prevPage);
        next.setOnClickListener(nextPage);
        menu.setOnClickListener(mainMenu);
    }
}
