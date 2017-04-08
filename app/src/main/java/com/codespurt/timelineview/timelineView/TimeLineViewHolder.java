package com.codespurt.timelineview.timelineView;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.codespurt.timelineview.R;
import com.github.vipulasri.timelineview.TimelineView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TimeLineViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.text_timeline_date)
    TextView mDate;
    @Bind(R.id.text_timeline_title)
    TextView mMessage;
    @Bind(R.id.time_marker)
    TimelineView mTimelineView;

    public TimeLineViewHolder(View itemView, int viewType) {
        super(itemView);

        ButterKnife.bind(this, itemView);
        mTimelineView.initLine(viewType);
    }
}