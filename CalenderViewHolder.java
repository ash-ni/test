package com.example.calendartesting;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CalenderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private final CalendarAdapter.OnItemListener onItemListener;
    public final TextView dayOfMonth;

    public CalenderViewHolder(CalendarAdapter.OnItemListener onItemListener, @NonNull View itemView) {
        super(itemView);
        this.onItemListener = onItemListener;
        dayOfMonth = itemView.findViewById(R.id.cellDayText);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        onItemListener.onItemClick(getAdapterPosition(), (String) dayOfMonth.getText());
    }
}
