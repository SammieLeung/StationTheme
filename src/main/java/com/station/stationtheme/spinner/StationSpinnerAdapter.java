package com.station.stationtheme.spinner;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import com.station.stationtheme.R;

import java.util.Arrays;
import java.util.List;

/**
 * author: Sam Leung
 * date:  2023/3/20
 */
public class StationSpinnerAdapter<T> extends ArrayAdapter<T> {
    public StationSpinnerAdapter(@NonNull Context context, @NonNull T[] objects) {
        this(context, Arrays.asList(objects));
    }

    public StationSpinnerAdapter(@NonNull Context context, @NonNull List<T> objects) {
        super(context, R.layout.station_spinner_item, objects);
        setDropDownViewResource(R.layout.station_spinner_dropdown_item);
    }


}
