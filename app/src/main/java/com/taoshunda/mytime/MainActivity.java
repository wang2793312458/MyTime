package com.taoshunda.mytime;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.jzxiang.pickerview.TimePickerDialog;
import com.jzxiang.pickerview.data.Type;
import com.jzxiang.pickerview.listener.OnDateSetListener;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements OnDateSetListener {
    private TimePickerDialog mDialogMonthDayHourMinute;
//    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sf = new SimpleDateFormat("HH:mm");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                mDialogMonthDayHourMinute = new TimePickerDialog.Builder()
                        .setType(Type.ALL)
                        .setCallBack(this)
                        .setThemeColor(getResources().getColor(R.color.colorAccent))
                        .build();
                mDialogMonthDayHourMinute.show(getSupportFragmentManager(), "All");
                break;
            case R.id.btn2:
                mDialogMonthDayHourMinute = new TimePickerDialog.Builder()
                        .setType(Type.YEAR_MONTH_DAY)
                        .setCallBack(this)
                        .build();
                mDialogMonthDayHourMinute.show(getSupportFragmentManager(), "YEAR_MONTH_DAY");
                break;
            case R.id.btn3:
                mDialogMonthDayHourMinute = new TimePickerDialog.Builder()
                        .setType(Type.HOURS_MINS)
                        .setCallBack(this)
                        .build();
                mDialogMonthDayHourMinute.show(getSupportFragmentManager(), "HOURS_MINS");
                break;
            case R.id.btn4:
                mDialogMonthDayHourMinute = new TimePickerDialog.Builder()
                        .setType(Type.MONTH_DAY_HOUR_MIN)
                        .setCallBack(this)
                        .build();
                mDialogMonthDayHourMinute.show(getSupportFragmentManager(), "month_day_hour_minute");
                break;
            case R.id.btn5:
                mDialogMonthDayHourMinute = new TimePickerDialog.Builder()
                        .setType(Type.YEAR_MONTH)
                        .setCallBack(this)
                        .build();
                mDialogMonthDayHourMinute.show(getSupportFragmentManager(), "YEAR");
                break;
        }
    }

    @Override
    public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
        String text = getDateToString(millseconds);
        Toast.makeText(this, "" + text, Toast.LENGTH_SHORT).show();
    }

    public String getDateToString(long time) {
        Date d = new Date(time);
        return sf.format(d);
    }

    /**
     * long tenYears = 10L * 365 * 1000 * 60 * 60 * 24L;
     TimePickerDialog mDialogAll = new TimePickerDialog.Builder()
     .setCallBack(this)//回调
     .setCancelStringId("Cancel")//取消按钮
     .setSureStringId("Sure")//确定按钮
     .setTitleStringId("TimePicker")//标题
     .setYearText("Year")//Year
     .setMonthText("Month")//Month
     .setDayText("Day")//Day
     .setHourText("Hour")//Hour
     .setMinuteText("Minute")//Minute
     .setCyclic(false)//是否可循环
     .setMinMillseconds(System.currentTimeMillis())//最小日期和时间
     .setMaxMillseconds(System.currentTimeMillis() + tenYears)//最大日期和时间
     .setCurrentMillseconds(System.currentTimeMillis())
     .setThemeColor(getResources().getColor(R.color.timepicker_dialog_bg))
     .setType(Type.ALL)//类型
     .setWheelItemTextNormalColor(getResources().getColor(R.color.timetimepicker_default_text_color))//未选中的文本颜色
     .setWheelItemTextSelectorColor(getResources().getColor(R.color.timepicker_toolbar_bg))//当前文本颜色
     .setWheelItemTextSize(12)//字体大小
     .build();

     mDialogAll.show(getSupportFragmentManager(), "ALL");
     */



}
