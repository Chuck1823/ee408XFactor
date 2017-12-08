package edu.clarkson.chaz.xfactor;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class BasicsOfMultiplication extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basics_of_multiplication);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        Button backButton = (Button) this.findViewById(R.id.back_button);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BasicsOfMultiplication.this, Menu.class));
            }
        });

    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            final Animation darthFader = AnimationUtils.loadAnimation(getActivity(), R.anim.fadein);

            View rootView = inflater.inflate(R.layout.fragment_basics_of_multiplication, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.step_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            TextView explanation = (TextView) rootView.findViewById(R.id.explanation);
            TextView carryOnes = (TextView) rootView.findViewById(R.id.carryOnes);
            TextView carryTens = (TextView) rootView.findViewById(R.id.carryTens);
            TextView topOnes = (TextView) rootView.findViewById(R.id.topOnes);
            TextView topTens = (TextView) rootView.findViewById(R.id.topTens);
            TextView topHundreds = (TextView) rootView.findViewById(R.id.topHundreds);
            TextView bottomOnes = (TextView) rootView.findViewById(R.id.bottomOnes);
            TextView bottomTens = (TextView) rootView.findViewById(R.id.bottomTens);
            TextView multiplicationSign = (TextView) rootView.findViewById(R.id.multiplicationSign);
            TextView multiplicationBar = (TextView) rootView.findViewById(R.id.multiplicationBar);
            TextView answerTopOnes = (TextView) rootView.findViewById(R.id.answerTopOnes);
            TextView answerTopTens = (TextView) rootView.findViewById(R.id.answerTopTens);
            TextView answerTopHundreds = (TextView) rootView.findViewById(R.id.answerTopHundreds);
            TextView answerBottomOnes = (TextView) rootView.findViewById(R.id.answerBottomOnes);
            TextView answerBottomTens = (TextView) rootView.findViewById(R.id.answerBottomTens);
            TextView answerBottomHundreds = (TextView) rootView.findViewById(R.id.answerBottomHundreds);
            TextView answerBottomThousands = (TextView) rootView.findViewById(R.id.answerBottomThousands);
            TextView additionSign = (TextView) rootView.findViewById(R.id.additionSign);
            TextView additionBar = (TextView) rootView.findViewById(R.id.additionBar);
            TextView finalAnswerOnes = (TextView) rootView.findViewById(R.id.finalAnswerOnes);
            TextView finalAnswerTens = (TextView) rootView.findViewById(R.id.finalAnswerTens);
            TextView finalAnswerHundreds = (TextView) rootView.findViewById(R.id.finalAnswerHundreds);
            TextView finalAnswerThousands = (TextView) rootView.findViewById(R.id.finalAnswerThousands);
            TextView topNumLabel = (TextView) rootView.findViewById(R.id.topNumLabel);
            TextView bottomNumLabel = (TextView) rootView.findViewById(R.id.bottomNumLabel);
            TextView carryAdd = (TextView) rootView.findViewById(R.id.carryAdd);

            topNumLabel.startAnimation(darthFader);
            bottomNumLabel.startAnimation(darthFader);

            if(getArguments().getInt(ARG_SECTION_NUMBER) == 1) {
                carryOnes.setText("1");
                bottomOnes.setBackground(getResources().getDrawable(R.drawable.highlight1));
                topOnes.setBackground(getResources().getDrawable(R.drawable.highlight1));
                answerTopOnes.setBackground(getResources().getDrawable(R.drawable.highlight3));

                topNumLabel.startAnimation(darthFader);
                bottomNumLabel.startAnimation(darthFader);
                carryOnes.startAnimation(darthFader);
                topOnes.startAnimation(darthFader);
                answerTopOnes.startAnimation(darthFader);

                explanation.setText("Long integer multiplication is always from right to left and bottom to top." +
                        " We first take the ones digit of the bottom number, which is 5, and multiply it" +
                        " with the ones digit of the top number, which is 3. The resulting product is" +
                        " 15. We now note the number 5 below the multiplication line and add a 1 above the tens" +
                        " digit of the top number in order to remember to add it in our next multiplication.");
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 2) {

                topNumLabel.clearAnimation();
                bottomNumLabel.clearAnimation();
                carryOnes.clearAnimation();
                bottomOnes.clearAnimation();
                topOnes.clearAnimation();
                answerTopOnes.clearAnimation();

                carryOnes.setText("1");
                answerTopTens.setText("1");
                carryTens.setText("1");
                bottomOnes.setBackground(getResources().getDrawable(R.drawable.highlight1));
                topTens.setBackground(getResources().getDrawable(R.drawable.highlight1));
                carryOnes.setBackground(getResources().getDrawable(R.drawable.highlight2));
                answerTopTens.setBackground(getResources().getDrawable(R.drawable.highlight3));

                answerTopTens.startAnimation(darthFader);
                carryTens.startAnimation(darthFader);
                topTens.startAnimation(darthFader);
                answerTopTens.startAnimation(darthFader);

                explanation.setText("Next we perform the multiplication of the ones digit of the bottom number" +
                        " with the tens digits of the top number. Consequently this step consists of  multiplying" +
                        " 5 by 2. The result is 10. Recall the 1 we carried from the previous multiplication and do" +
                        " not forget to add it to the result. The  final result is 11. Therefore, we write a 1 below" +
                        " the multiplication line and carry another 1 that we place above the hundreds digit of the top number.");
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 3) {

                topNumLabel.clearAnimation();
                bottomNumLabel.clearAnimation();
                carryOnes.clearAnimation();
                answerTopTens.clearAnimation();
                carryTens.clearAnimation();
                bottomOnes.clearAnimation();
                topTens.clearAnimation();
                carryOnes.clearAnimation();
                answerTopTens.clearAnimation();

                answerTopTens.setText("1");
                carryTens.setText("1");
                answerTopHundreds.setText("6");
                carryOnes.setText("1");
                bottomOnes.setBackground(getResources().getDrawable(R.drawable.highlight1));
                topHundreds.setBackground(getResources().getDrawable(R.drawable.highlight1));
                carryTens.setBackground(getResources().getDrawable(R.drawable.highlight2));
                answerTopHundreds.setBackground(getResources().getDrawable(R.drawable.highlight3));

                answerTopHundreds.startAnimation(darthFader);
                topHundreds.startAnimation(darthFader);
                answerTopHundreds.startAnimation(darthFader);

                explanation.setText("We perform the same procedure as the last step and multiply 5 by 1. The result is 5" +
                        " but we need to add the 1 that we carried over from the previous mutiplication. Thus, the final result" +
                        " is 6. We can now mark the answer, remove the 1s we carried over and move on to the tens" +
                        " digit of the bottom number.");
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 4) {

                topNumLabel.clearAnimation();
                bottomNumLabel.clearAnimation();
                answerTopTens.clearAnimation();
                carryTens.clearAnimation();
                answerTopHundreds.clearAnimation();
                carryOnes.clearAnimation();
                bottomOnes.clearAnimation();
                topHundreds.clearAnimation();
                carryTens.clearAnimation();
                answerTopHundreds.clearAnimation();

                answerTopTens.setText("1");
                answerTopHundreds.setText("6");
                carryOnes.setText("1");
                answerBottomOnes.setText("0");
                answerBottomTens.setText("2");
                bottomTens.setBackground(getResources().getDrawable(R.drawable.highlight1));
                topOnes.setBackground(getResources().getDrawable(R.drawable.highlight1));
                answerBottomOnes.setBackground(getResources().getDrawable(R.drawable.highlight3));
                answerBottomTens.setBackground(getResources().getDrawable(R.drawable.highlight3));

                carryOnes.startAnimation(darthFader);
                answerBottomOnes.startAnimation(darthFader);
                answerBottomTens.startAnimation(darthFader);
                topOnes.startAnimation(darthFader);
                answerBottomOnes.startAnimation(darthFader);
                answerBottomTens.startAnimation(darthFader);

                explanation.setText("Since we are now working with the tens digit of the bottom number we need to" +
                        " carry a placeholder of value 0 below the ones digit of the number 615. For this step," +
                        " we multiply the tens digit of the bottom number with the ones digit of the top number." +
                        " 4 multiplied with 3 yields a result of 12. Therefore we write the number 2 at the tens" +
                        " position with a carry of 1 above the tens digit of the top number.");
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 5) {

                topNumLabel.clearAnimation();
                bottomNumLabel.clearAnimation();
                answerTopTens.clearAnimation();
                answerTopHundreds.clearAnimation();
                carryOnes.clearAnimation();
                answerBottomOnes.clearAnimation();
                answerBottomTens.clearAnimation();
                bottomTens.clearAnimation();
                topOnes.clearAnimation();
                answerBottomOnes.clearAnimation();
                answerBottomTens.clearAnimation();

                answerTopTens.setText("1");
                answerTopHundreds.setText("6");
                carryOnes.setText("1");
                answerBottomOnes.setText("0");
                answerBottomTens.setText("2");
                answerBottomHundreds.setText("9");
                bottomTens.setBackground(getResources().getDrawable(R.drawable.highlight1));
                topTens.setBackground(getResources().getDrawable(R.drawable.highlight1));
                carryOnes.setBackground(getResources().getDrawable(R.drawable.highlight2));
                answerBottomHundreds.setBackground(getResources().getDrawable(R.drawable.highlight3));

                answerBottomHundreds.startAnimation(darthFader);
                topTens.startAnimation(darthFader);
                answerBottomHundreds.startAnimation(darthFader);

                explanation.setText("The next step consists of multiplying the tens digit of the bottom number" +
                        " with the next number in line of the top number which is 2 at the tens position. The result" +
                        " of 4 times 2 is 8 but we add 1 to 8 since we had a carry of 1 from the previous step. We" +
                        " then proceed to mark the result in the hundreds position of the second number below the" +
                        " multiplication line.");
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 6) {

                topNumLabel.clearAnimation();
                bottomNumLabel.clearAnimation();
                answerTopTens.clearAnimation();
                answerTopHundreds.clearAnimation();
                carryOnes.clearAnimation();
                answerBottomOnes.clearAnimation();
                answerBottomTens.clearAnimation();
                answerBottomHundreds.clearAnimation();
                bottomTens.clearAnimation();
                topTens.clearAnimation();
                carryOnes.clearAnimation();
                answerBottomHundreds.clearAnimation();

                answerTopTens.setText("1");
                answerTopHundreds.setText("6");
                carryOnes.setText("1");
                answerBottomOnes.setText("0");
                answerBottomTens.setText("2");
                answerBottomHundreds.setText("9");
                answerBottomThousands.setText("4");
                bottomTens.setBackground(getResources().getDrawable(R.drawable.highlight1));
                topHundreds.setBackground(getResources().getDrawable(R.drawable.highlight1));
                answerBottomThousands.setBackground(getResources().getDrawable(R.drawable.highlight3));

                answerBottomThousands.startAnimation(darthFader);
                topHundreds.startAnimation(darthFader);
                answerBottomThousands.startAnimation(darthFader);

                explanation.setText("Step 6 involves multplying the tens digit of the bottom number with" +
                        " the last digit at the hundreds place of the top number. The product is 4 times 1 which" +
                        " yields a result of 4 with no carries. Since there are no more digits to be used from the" +
                        " bottom number, the multiplication (harder) part of the problem is done!");
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 7) {

                topNumLabel.clearAnimation();
                bottomNumLabel.clearAnimation();
                answerTopTens.clearAnimation();
                answerBottomHundreds.clearAnimation();
                carryOnes.clearAnimation();
                answerBottomOnes.clearAnimation();
                answerBottomTens.clearAnimation();
                answerBottomHundreds.clearAnimation();
                answerBottomThousands.clearAnimation();
                bottomTens.clearAnimation();
                topHundreds.clearAnimation();
                answerBottomThousands.clearAnimation();

                answerTopTens.setText("1");
                answerTopHundreds.setText("6");
                carryOnes.setText("1");
                answerBottomOnes.setText("0");
                answerBottomTens.setText("2");
                answerBottomHundreds.setText("9");
                answerBottomThousands.setText("4");
                additionSign.setText("+");
                additionBar.setText("__________________");
                finalAnswerOnes.setText("5");
                finalAnswerTens.setText("3");
                finalAnswerHundreds.setText("3");
                finalAnswerThousands.setText("5");
                carryAdd.setText("1");

                answerBottomOnes.setBackground(getResources().getDrawable(R.drawable.highlight3));
                answerBottomTens.setBackground(getResources().getDrawable(R.drawable.highlight3));
                answerBottomHundreds.setBackground(getResources().getDrawable(R.drawable.highlight3));
                answerBottomThousands.setBackground(getResources().getDrawable(R.drawable.highlight3));
                answerTopOnes.setBackground(getResources().getDrawable(R.drawable.highlight3));
                answerTopTens.setBackground(getResources().getDrawable(R.drawable.highlight3));
                answerTopHundreds.setBackground(getResources().getDrawable(R.drawable.highlight3));
                finalAnswerOnes.setBackgroundColor(Color.parseColor("#FF70FF37"));
                finalAnswerTens.setBackgroundColor(Color.parseColor("#FF70FF37"));
                finalAnswerHundreds.setBackgroundColor(Color.parseColor("#FF70FF37"));
                finalAnswerThousands.setBackgroundColor(Color.parseColor("#FF70FF37"));

                answerTopOnes.startAnimation(darthFader);
                answerTopTens.startAnimation(darthFader);
                answerTopHundreds.startAnimation(darthFader);
                carryOnes.startAnimation(darthFader);
                answerBottomOnes.startAnimation(darthFader);
                answerBottomTens.startAnimation(darthFader);
                answerBottomHundreds.startAnimation(darthFader);
                answerBottomThousands.startAnimation(darthFader);
                additionSign.startAnimation(darthFader);
                finalAnswerOnes.startAnimation(darthFader);
                finalAnswerTens.startAnimation(darthFader);
                finalAnswerHundreds.startAnimation(darthFader);
                finalAnswerThousands.startAnimation(darthFader);

                explanation.setText("The final step to the problem involves addition. We need to carefully" +
                        " add both numbers obtained through multiplication of each digit of the bottom numbers." +
                        " The sum of 615 and 4920 equals an ultimate value of 5535. The numbers need to be carefully" +
                        " aligned with proper placeholders for the result to be valid. Step 8 contains important" +
                        " information.");
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 8) {

                answerTopTens.clearAnimation();
                answerTopHundreds.clearAnimation();
                carryOnes.clearAnimation();
                answerBottomOnes.clearAnimation();
                answerBottomTens.clearAnimation();
                answerBottomHundreds.clearAnimation();
                answerBottomThousands.clearAnimation();
                additionSign.clearAnimation();
                finalAnswerOnes.clearAnimation();
                finalAnswerTens.clearAnimation();
                finalAnswerHundreds.clearAnimation();
                finalAnswerThousands.clearAnimation();
                carryAdd.clearAnimation();

                carryOnes.setText("");
                carryTens.setText("");
                topOnes.setText("");
                topTens.setText("");
                topHundreds.setText("");
                bottomOnes.setText("");
                bottomTens.setText("");
                multiplicationBar.setText("");
                multiplicationSign.setText("");
                answerTopOnes.setText("");
                answerTopTens.setText("");
                answerTopHundreds.setText("");
                answerBottomOnes.setText("");
                answerBottomTens.setText("");
                answerBottomHundreds.setText("");
                answerBottomThousands.setText("");
                additionBar.setText("");
                additionSign.setText("");
                finalAnswerOnes.setText("");
                finalAnswerTens.setText("");
                finalAnswerHundreds.setText("");
                finalAnswerThousands.setText("");
                topNumLabel.setText("");
                bottomNumLabel.setText("");
                carryAdd.setText("");
                explanation.setText("This was a step-by-step tutorial of how to perform long multiplication" +
                        " using integers. The same methodology can be applied with integers containing less" +
                        " or more digits. This is a powerful technique of mathematics. You are now a champion of" +
                        " multiplication! Go try the other sections of the app to get a walk-through with other numbers" +
                        " or to test your skills if you are up to the challenge! :)");
            }
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 8 total pages.
            return 8;
        }


        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Step 1";
                case 1:
                    return "Step 2";
                case 2:
                    return "Step 3";
                case 3:
                    return "Step 4";
                case 4:
                    return "Step 5";
                case 5:
                    return "Step 6";
                case 6:
                    return "Step 7";
                case 7:
                    return "Step 8";
            }
            return null;
        }
    }
}
