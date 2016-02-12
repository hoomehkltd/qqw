package com.example.user.mapapplication;

import android.app.Activity;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AppointmentConfirmActivity extends Activity implements DatePickerDialog.OnDateSetListener{
    ArrayList <String> apartmentSelectedList;
    ArrayList<Apartment> apartmentArrayList;
    public int userId;
    public Appointment appointment;
    public String firstChoiceDate;
    public String secChoiceDate;
    Button appointmentConfirm ;
    Button firstChoiceDateBtn;
    Button secChoiceDateBtn;
    EditText name;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("AptConfirmActivity","");
        appointment = new Appointment();
        setContentView(R.layout.activity_appointment_confirm);
        userId = getIntent().getIntExtra("userId", 0);
        apartmentSelectedList = getIntent().getStringArrayListExtra("apartmentSelectedList");
        super.onCreate(savedInstanceState);
        setView();
        setOnclick();
    }

    public void setView(){
        appointmentConfirm = (Button) findViewById(R.id.btn_appointmentconfirm);
        firstChoiceDateBtn = (Button) findViewById(R.id.btn_firstchoicedate);
        secChoiceDateBtn = (Button) findViewById(R.id.btn_secchoicedate);
        name  = (EditText) findViewById(R.id.textfield_name);
    }


    public void setOnclick(){
        View.OnClickListener firstChoiceDateBtnListener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d("btn_firstChoiceDate", "Clicked");
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        AppointmentConfirmActivity.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.show(getFragmentManager(), "firstChoiceDateBtn");
                Log.d("firstChoiceDateBtn", dpd.getTag());

            }
        };
        View.OnClickListener secChoiceDateBtnListener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d("btn_secChoiceDate", "Clicked");
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        AppointmentConfirmActivity.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.show(getFragmentManager(), "secChoiceDateBtn");
                Log.d("secChoiceDateBtn", dpd.getTag());
            }
        };

        View.OnClickListener appointmentConfirmListener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d("btn_appointmentconfirm", "clicked");
                appointment.apartmentSelectedList = apartmentSelectedList;
                appointment.userId = userId;
                appointment.name = name.getText().toString();
                Log.d("btn_appointmentconfirm", "Confirmed");

                DataOperationUser userDataOperation = new DataOperationUser();
                userDataOperation.addtoAppointmentList(userId, appointment);
                finish();

            }
        };

        firstChoiceDateBtn.setOnClickListener(firstChoiceDateBtnListener);
        secChoiceDateBtn.setOnClickListener(secChoiceDateBtnListener);
        appointmentConfirm.setOnClickListener(appointmentConfirmListener);

    }


    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        if(view.getTag().equals("secChoiceDateBtn")){
            secChoiceDate = Integer.toString(year)+"-"+Integer.toString(monthOfYear)+"-"+Integer.toString(dayOfMonth);
            secChoiceDateBtn.setText(secChoiceDate);
            Calendar date = new GregorianCalendar(year, monthOfYear, dayOfMonth);
            appointment.secChoiceDate = date;
        }
        else{
            firstChoiceDate = Integer.toString(year)+"-"+Integer.toString(monthOfYear)+"-"+Integer.toString(dayOfMonth);
            firstChoiceDateBtn.setText(firstChoiceDate);
            Calendar date = new GregorianCalendar(year, monthOfYear, dayOfMonth);
            appointment.firstChoiceDate = date;
            Log.d("firstChoiceDate", new Gson().toJson(date).toString());
        }
        Log.d("viewTag", view.getTag());
    }
}
