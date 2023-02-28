package com.station.stationtheme;

import android.app.Dialog;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * author: Sam Leung
 * date:  2023/2/28
 */
public abstract class BaseStationDialog extends Dialog {
    public BaseStationDialog(@NonNull Context context) {
        super(context);
    }

    public BaseStationDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected BaseStationDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
