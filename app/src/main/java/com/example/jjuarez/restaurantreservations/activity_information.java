package com.example.jjuarez.restaurantreservations;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class activity_information extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        final Button btnNext = (Button) findViewById(R.id.btnNext);

        final EditText firstName = (EditText) findViewById(R.id.txtFirstName);
        final EditText lastName = (EditText) findViewById(R.id.txtLastName);
        final EditText phone = (EditText) findViewById(R.id.txtPhone);

        final Spinner spMonth = (Spinner) findViewById(R.id.spnMonth);
        final EditText txtDay = (EditText) findViewById(R.id.txtDay);

        final Spinner spTime = (Spinner) findViewById(R.id.spnTime);

        firstName.requestFocus();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkData()){
                String dateReservation = "";
                dateReservation = spMonth.getSelectedItem().toString() + "/" + txtDay.getText().toString();
                String timeReservation = "";
                timeReservation = spTime.getSelectedItem().toString();
                // old way
                // startActivity(new Intent(MainClassList.this, ChooseClass.class));

                //new way
                /*
                    Intent nextScreen = new Intent(activity_information.this, activity_confirmation.class);

                    nextScreen.putExtra("FirstName", firstName.getText().toString());
                    nextScreen.putExtra("LastName", lastName.getText().toString());
                    nextScreen.putExtra("Phone", phone.getText().toString());
                    nextScreen.putExtra("Reservation", dateReservation);
                    nextScreen.putExtra("Time", timeReservation);
                //Start Activity
                startActivity(nextScreen);
                */
                }
            }
        });

    }

    private boolean checkData(){                //check data for any empty inputs
        final EditText firstName = (EditText) findViewById(R.id.txtFirstName);
        final EditText lastName = (EditText) findViewById(R.id.txtLastName);
        final EditText phone = (EditText) findViewById(R.id.txtPhone);
        final EditText txtDay = (EditText) findViewById(R.id.txtDay);
        //final EditText txtYear = (EditText) findViewById(R.id.txtYear);

        if(firstName.getText().toString().isEmpty()){
            //error
            firstName.setError("Invalid First Name");
            firstName.requestFocus();
            return false;
        }

        if(lastName.getText().toString().isEmpty()){
            lastName.setError("Invalid Last Name");
            lastName.requestFocus();
            return false;
        }

        if(phone.getText().toString().isEmpty()){
            phone.setError("Invalid Phone Number");
            phone.requestFocus();
            return false;
        }

        if(txtDay.getText().toString().isEmpty() ){
            txtDay.setError("Invalid Date Selection");
            txtDay.requestFocus();
            return false;
        }





        return true;
    }
}
