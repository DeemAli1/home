package com.example.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class register extends AppCompatActivity {
    AutoCompleteTextView  txtname , txtphone ;
    EditText tv ;
    Spinner sptrack ;
    Button btnconf;
    Calendar mCurrntDate;
    CheckBox checkPaper , checkPlasic , checkOthers , checkGlass ;
    int day, month, year;
    DatabaseReference reff ;
    List<Customer> customers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        txtname = (AutoCompleteTextView) findViewById(R.id.edName);
        txtphone = (AutoCompleteTextView) findViewById(R.id.edPhone);
        sptrack = (Spinner)findViewById(R.id.edTrack);
        btnconf = (Button) findViewById(R.id.edSave);
        tv =(EditText) findViewById(R.id.edTime);
        checkGlass = (CheckBox)findViewById(R.id.edGlass);
        checkOthers = (CheckBox)findViewById(R.id.edOthers);
        checkPaper = (CheckBox)findViewById(R.id.edPaper);
        checkPlasic = (CheckBox)findViewById(R.id.edPlastic);




        //  date = (AutoCompleteTextView) findViewById(R.id.edTime);



        mCurrntDate = Calendar.getInstance();
        day = mCurrntDate.get(Calendar.DAY_OF_MONTH);
        month = mCurrntDate.get(Calendar.MONTH);
        year = mCurrntDate.get(Calendar.YEAR);

        month = month+1 ;

        tv.setText(day+"/"+month+"/"+year);



        reff = FirebaseDatabase.getInstance().getReference().child("Customer");


        customers = new ArrayList<>();
        //adding an onclicklistener to button
        btnconf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                customerAdd();  }
        });
        tv.setOnClickListener( new View.OnClickListener() {
            public void onClick (View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(register.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        monthOfYear += 1;
                        tv.setText(dayOfMonth+"/"+monthOfYear+"/"+year);
                    }

                },year,month,day);
                datePickerDialog.show();

            }
        });
    }


    public void customerAdd ( ) {

        //getting the values to save
        String name = txtname.getText().toString().trim();
        String phone =txtphone.getText().toString().trim();
        String truck = sptrack.getSelectedItem().toString();
        String time = tv.getText().toString().trim();



        //checking if the value is provided
        if (!TextUtils.isEmpty(phone) ) {
            //getting a unique id using push().getKey() method

            String id = reff.push().getKey();
            Customer customer = new Customer( id , name, phone, truck , time);

            if (checkPlasic.isChecked()){
                reff.child(id).setValue(customer);
                customer.setCatogres("Plasic");
            }
            if (checkPaper.isChecked()){
                reff.child(id).setValue(customer);
                customer.setCatogres("Paper");
            }
            if (checkOthers.isChecked()){

                reff.child(id).setValue(customer);
                customer.setCatogres("Others");
            }
            if (checkGlass.isChecked()){

                reff.child(id).setValue(customer);
                customer.setCatogres("Glass");
            }

            if (checkGlass.isChecked() && checkPaper.isChecked()){
                customer.setCatogres("Glass - Paper");
                reff.child(id).setValue(customer);
            }
            if (checkGlass.isChecked() && checkOthers.isChecked()){
                customer.setCatogres("Glass - Others");
                reff.child(id).setValue(customer);
            }
            if (checkGlass.isChecked() && checkPlasic.isChecked()){
                customer.setCatogres("Glass - Plasic");
                reff.child(id).setValue(customer);
            }
            if (checkPaper.isChecked() && checkPlasic.isChecked()){
                customer.setCatogres("Paper - Plasic");
                reff.child(id).setValue(customer);
            }
            if (checkPaper.isChecked() && checkOthers.isChecked()){
                customer.setCatogres("Paper - Others");
                reff.child(id).setValue(customer);
            }
            if (checkPlasic.isChecked() && checkOthers.isChecked()){
                customer.setCatogres("Plasic - Others");
                reff.child(id).setValue(customer);
            }

            if (checkPaper.isChecked() && checkPlasic.isChecked() && checkGlass.isChecked() ){
                customer.setCatogres("Paper - Plasic - Glass  ");
                reff.child(id).setValue(customer);
            }
            if (checkPaper.isChecked() && checkPlasic.isChecked()  && checkOthers.isChecked()){
                customer.setCatogres("Paper - Plasic - others ");
                reff.child(id).setValue(customer);
            }
            if (checkPaper.isChecked() && checkGlass.isChecked() && checkOthers.isChecked()){
                customer.setCatogres("Paper - Glass - others ");
                reff.child(id).setValue(customer);
            }
            if (checkPlasic.isChecked() && checkGlass.isChecked() && checkOthers.isChecked()){
                customer.setCatogres(" Plasic - Glass - others ");
                reff.child(id).setValue(customer);
            }

            if (checkPaper.isChecked() && checkPlasic.isChecked() && checkGlass.isChecked() && checkOthers.isChecked()){
                customer.setCatogres("Paper - Plasic - Glass - others ");
                reff.child(id).setValue(customer);
            }


            txtphone.setText("");
            txtname.setText("");


            //displaying a success toast
            Toast.makeText(this, " Wait For Contact ... ThankYOU :) ", Toast.LENGTH_LONG).show();
        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please enter a phone number", Toast.LENGTH_LONG).show();
        }


    }




}
