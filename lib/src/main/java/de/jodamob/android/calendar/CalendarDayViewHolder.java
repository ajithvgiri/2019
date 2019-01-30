package de.jodamob.android.calendar;

import android.graphics.Color;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import calendar.android.jodamob.de.cleansimplecalendar.R;

public class CalendarDayViewHolder extends RecyclerView.ViewHolder {

    private final View rootView;
    private final AppCompatTextView dateTextView;

    public CalendarDayViewHolder(View itemView) {
        super(itemView);
        this.rootView = itemView.findViewById(R.id.custom_cell);
        this.dateTextView = itemView.findViewById(R.id.date_text);
    }

    public void bind(Day day, DayState state) {
        setText(day);
        selectCell(state.isSelected());
        markAsCurrentMonth(state.isCurrentMonth());
        markAsToday(state.isToday());
    }

    private void markAsToday(boolean today) {
        if (today)
            dateTextView.setTextColor(Color.BLACK);

//        dateTextView.setTypeface(null, today ? Typeface.BOLD : Typeface.NORMAL);
    }

    private void setText(Day day) {
//        dateTextView.setTextColor(R.color.white);
        dateTextView.setText(String.valueOf(day.getDay()));
    }

    private void selectCell(boolean selected) {
        rootView.setSelected(selected);
    }

    public void markAsCurrentMonth(boolean currentMonth) {
        rootView.setEnabled(currentMonth);
        if (currentMonth)
            dateTextView.setTextColor(Color.WHITE);
    }
}
