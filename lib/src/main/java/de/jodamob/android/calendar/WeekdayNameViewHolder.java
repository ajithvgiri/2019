package de.jodamob.android.calendar;

import android.graphics.Color;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import calendar.android.jodamob.de.cleansimplecalendar.R;

public class WeekdayNameViewHolder extends RecyclerView.ViewHolder {

    private final android.support.v7.widget.AppCompatTextView dayView;

    public WeekdayNameViewHolder(View itemView) {
        super(itemView);
        this.dayView = itemView.findViewById(R.id.day);
    }

    public void bind(String day) {
        dayView.setText(day);
    }
}
