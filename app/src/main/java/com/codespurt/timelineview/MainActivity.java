package com.codespurt.timelineview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.codespurt.timelineview.timelineView.TimeLineActivity;
import com.codespurt.timelineview.timelineView.model.Orientation;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public final static String EXTRA_ORIENTATION = "EXTRA_ORIENTATION";
    public final static String EXTRA_WITH_LINE_PADDING = "EXTRA_WITH_LINE_PADDING";

    @Bind(R.id.verticalTimeLineButton)
    Button mVerticalTimeLineButton;
    @Bind(R.id.verticalTimeLineButtonWPadding)
    Button mVerticalTimeLineButtonWPadding;
    @Bind(R.id.horizontalTimeLineButton)
    Button mHorizontalTimeLineButton;
    @Bind(R.id.horizontalTimeLineButtonWPadding)
    Button mHorizontalTimeLineButtonWPadding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mVerticalTimeLineButton.setOnClickListener(this);
        mVerticalTimeLineButtonWPadding.setOnClickListener(this);
        mHorizontalTimeLineButton.setOnClickListener(this);
        mHorizontalTimeLineButtonWPadding.setOnClickListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mVerticalTimeLineButton.setOnClickListener(null);
        mVerticalTimeLineButtonWPadding.setOnClickListener(null);
        mHorizontalTimeLineButton.setOnClickListener(null);
        mHorizontalTimeLineButtonWPadding.setOnClickListener(null);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.verticalTimeLineButton:
                onButtonClick(Orientation.VERTICAL, false);
                break;
            case R.id.verticalTimeLineButtonWPadding:
                onButtonClick(Orientation.HORIZONTAL, false);
                break;
            case R.id.horizontalTimeLineButton:
                onButtonClick(Orientation.VERTICAL, true);
                break;
            case R.id.horizontalTimeLineButtonWPadding:
                onButtonClick(Orientation.HORIZONTAL, true);
                break;
        }
    }

    private void onButtonClick(Orientation orientation, boolean withLinePadding) {
        Intent intent = new Intent(this, TimeLineActivity.class);
        intent.putExtra(EXTRA_ORIENTATION, orientation);
        intent.putExtra(EXTRA_WITH_LINE_PADDING, withLinePadding);
        startActivity(intent);
    }
}