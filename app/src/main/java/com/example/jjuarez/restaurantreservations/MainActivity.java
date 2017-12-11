package com.example.jjuarez.restaurantreservations;

import android.content.Intent;
import android.icu.text.IDNA;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnNext = (Button) findViewById(R.id.btnNext);
        final RadioButton radioOne = (RadioButton) findViewById(R.id.inputOne);
        final RadioButton radioTwo = (RadioButton) findViewById(R.id.inputTwo);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkData()){
                    // old way
                    // startActivity(new Intent(MainClassList.this, ChooseClass.class));

                    //new way
                    Intent nextScreen = new Intent(MainActivity.this, activity_information.class);
                    //nextScreen.putExtra("FirstName", firstName.getText().toString());
                    //nextScreen.putExtra("LastName", lastName.getText().toString());

                    //Start Activity
                    startActivity(nextScreen);
                }
            }
        });
    }

    private boolean checkData() {
        final RadioButton choiceOne = (RadioButton) findViewById(R.id.inputOne);
        final RadioButton choiceTwo = (RadioButton) findViewById(R.id.inputTwo);

        if (choiceOne.isChecked() || choiceTwo.isChecked()) {
                return true;
        }else {
            Toast.makeText(MainActivity.this, "Please Make a Selection",Toast.LENGTH_LONG).show();
            return false;
        }
    }

}

