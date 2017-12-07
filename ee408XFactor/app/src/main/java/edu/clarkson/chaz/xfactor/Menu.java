package edu.clarkson.chaz.xfactor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button basicsButton = (Button)findViewById(R.id.button_basics);
        Button tryButton = (Button)findViewById(R.id.button_try);
        Button testButton = (Button)findViewById(R.id.button_test);

        basicsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, BasicsOfMultiplication.class));
            }
        });

        tryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, TryItOut.class));
            }
        });

        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, TestYourSkills.class));
            }
        });

    }
}
