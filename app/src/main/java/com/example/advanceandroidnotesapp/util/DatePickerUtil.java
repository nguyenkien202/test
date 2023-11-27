package com.example.advanceandroidnotesapp.util;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;

import java.util.Calendar;

public class DatePickerUtil {
    public interface OnDateSelectedListener {
        void onDateSelected(int year, int month, int day);
    }

    public static void showDatePicker(Context context, final OnDateSelectedListener listener) {
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        int currentMonth = calendar.get(Calendar.MONTH);
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                listener.onDateSelected(year, month, dayOfMonth);
            }
        }, currentYear, currentMonth, currentDay);

        datePickerDialog.show();
    }
}