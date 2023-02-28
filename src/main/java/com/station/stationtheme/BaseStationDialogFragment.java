package com.station.stationtheme;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import androidx.fragment.app.DialogFragment;

/**
 * author: Sam Leung
 * date:  2023/2/28
 */
public class BaseStationDialogFragment extends DialogFragment {
    @Override
    public void onStart() {
        super.onStart();
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }
}
