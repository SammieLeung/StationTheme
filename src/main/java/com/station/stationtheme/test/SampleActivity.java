package com.station.stationtheme.test;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.Spinner;

import androidx.activity.ComponentActivity;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.station.stationtheme.R;
import com.station.stationtheme.StationDialogFragment;
import com.station.stationtheme.spinner.StationSpinnerAdapter;

/**
 * author: Sam Leung
 * date:  2023/3/8
 */
public class SampleActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_layout);
        setTheme(R.style.StationTheme);
        initAlterDialog();
        initSpinner();
    }

    private void initAlterDialog() {
        findViewById(R.id.messageDialog).setOnClickListener(v -> {
            StationDialogFragment dialogFragment = new StationDialogFragment.Builder(getBaseContext())
                    .setTitle("标题")
                    .setMessage("这是一个消息对话框")
                    .build();
            dialogFragment.show(SampleActivity.this.getSupportFragmentManager(), "dialog");

        });
        findViewById(R.id.addCustomViewDialog).setOnClickListener(v -> {
            StationDialogFragment dialogFragment = new StationDialogFragment.Builder(getBaseContext())
                    .setTitle("标题和自定义View")
                    .setCustomView(R.layout.station_custom_view)
                    .setMessage("这是一个消息对话框")
                    .setNegativeButton("取消", (dialog, which) -> {
                        dialog.dismiss();
                    })
                    .setPositiveButton("确定", (dialog, which) -> {
                        dialog.dismiss();
                    })
                    .setNeutralButton("中立", (dialog, which) -> {
                        dialog.dismiss();
                    })
                    .build();
            dialogFragment.show(SampleActivity.this.getSupportFragmentManager(), "dialog");
        });
    }

    private void initSpinner() {
        StationSpinnerAdapter<CharSequence> adapter = new StationSpinnerAdapter(getBaseContext(), new String[]{"启用", "关闭"});// 设置下拉菜单的样式
        adapter.setDropDownViewResource(R.layout.station_spinner_dropdown_item);
// 将适配器绑定到spinner上
        Spinner spinner = findViewById(R.id.spinner_1);
        spinner.setAdapter(adapter);

        Spinner appCompatSpinner = findViewById(R.id.spinner_2);
        appCompatSpinner.setAdapter(adapter);
    }

}
