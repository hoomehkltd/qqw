package com.example.user.mapapplication;

import android.graphics.Color;
import android.graphics.Typeface;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.Log;


import com.google.gson.Gson;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.spans.DotSpan;
import com.wdullaer.materialdatetimepicker.date.MonthAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by user on 9/1/2016.
 */
public class DateDecorator implements DayViewDecorator {
    public static ArrayList<CalendarDay> calendarDates  = new ArrayList<CalendarDay>();;

    public DateDecorator(ArrayList<Calendar> dateArrayList) {
        Log.d("dateArrayListDecorator", new Gson().toJson(dateArrayList).toString());
        for(Calendar date:dateArrayList){
            Log.d("DateinList", date.get(Calendar.YEAR) + " Year " + date.get(Calendar.MONTH) + " Month " + date.get(Calendar.DAY_OF_MONTH) + " Day ");
            CalendarDay calendarDay = CalendarDay.from(date.get(Calendar.YEAR),date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_MONTH));
            calendarDates.add(calendarDay);
            Log.d("CalDateinList",calendarDay.getYear()+" Year "+calendarDay.getMonth()+" Month "+calendarDay.getDay()+" Day ");
        }
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        Log.d("CalDateDecorate", day.getYear() + " Year " + day.getMonth() + " Month " + day.getDay()+" Day ");
        if (calendarDates.contains(day)){
            Log.d("ShouldDecorate", Integer.toString(day.getDay()));
        }

        return calendarDates.contains(day);
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.addSpan(new DotSpan(5, Color.BLACK));
//        view.addSpan(new StyleSpan(Typeface.BOLD));
//        view.addSpan(new RelativeSizeSpan(1.4f));
    }


}
