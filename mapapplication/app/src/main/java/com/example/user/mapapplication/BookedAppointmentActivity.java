package com.example.user.mapapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class BookedAppointmentActivity extends AppCompatActivity implements OnDateSelectedListener {
    static ArrayList<Appointment> AppointmentList = new ArrayList<Appointment>();
    MaterialCalendarView widget;
    public static int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booked_appointment);
        Intent intent = getIntent();
        userId = intent.getIntExtra("userId", 0);
        DataOperationUser dou = new DataOperationUser();
        AppointmentList = dou.getAppointmentList(userId);
        setView();
        if (AppointmentList!=null){
            Log.d("AppointmentList", new Gson().toJson(AppointmentList).toString());
            setCalendar(AppointmentList);
        }
        else {Log.d("AppointmentList", new Gson().toJson(AppointmentList).toString());}
    }

    public void setView(){
        widget = (MaterialCalendarView) findViewById(R.id.calendarView);

    }

    public void setCalendar(ArrayList<Appointment> AppointmentList){
        widget.setSelectionMode(MaterialCalendarView.SELECTION_MODE_MULTIPLE);
        ArrayList<Calendar> dateArrayList= new ArrayList<Calendar>();
        for (Appointment appointment:AppointmentList){
            Calendar firstChoiceDate = appointment.firstChoiceDate;
            dateArrayList.add(firstChoiceDate);
            Log.d("appointmentDate", new Gson().toJson(firstChoiceDate).toString());
        }
//        for (Date date: dateArrayList){
//            widget.setSelectedDate(date);
//        }
        Log.d("dateArrayList", new Gson().toJson(dateArrayList).toString());

        widget.addDecorators( new DateDecorator(dateArrayList));
    }

    @Override
    public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
        //If you change a decorate, you need to invalidate decorators
//        widget.invalidateDecorators();
    }
    @Override
    public void onResume(){
        super.onResume();
        DataOperationUser dou = new DataOperationUser();
        AppointmentList = dou.getAppointmentList(userId);
         setCalendar(AppointmentList);
    }
}
