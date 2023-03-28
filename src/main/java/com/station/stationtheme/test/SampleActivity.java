package com.station.stationtheme.test;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.activity.ComponentActivity;
import androidx.annotation.Nullable;

import com.dinuscxj.progressbar.CircleProgressBar;
import com.station.stationtheme.R;
import com.station.stationtheme.spinner.StationSpinnerAdapter;

/**
 * author: Sam Leung
 * date:  2023/3/8
 */
public class SampleActivity extends ComponentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_layout);
        initSpinner();
    }

    private void initSpinner() {
        StationSpinnerAdapter<CharSequence> adapter = new StationSpinnerAdapter(getBaseContext(),  new String[]{"启用", "关闭"});// 设置下拉菜单的样式

        adapter.setDropDownViewResource(R.layout.station_spinner_dropdown_item);
// 将适配器绑定到spinner上
        Spinner spinner = findViewById(R.id.spinner_1);
        spinner.setAdapter(adapter);

        Spinner appCompatSpinner = findViewById(R.id.spinner_2);
        appCompatSpinner.setAdapter(adapter);
    }

}
