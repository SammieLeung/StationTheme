package com.station.stationtheme;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Space;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.DialogFragment;

/**
 * author: Sam Leung
 * date:  2023/2/28
 */
public class StationDialogFragment extends DialogFragment {
    private static final int TYPE_DEFAULT = 0x1;
    private static final int TYPE_LOADING = 0x2;
    private static final int TYPE_EDITTEXT = 0x4;
    private static final int TYPE_LIST = 0x8;
    private static final int TYPE_SINGLE_CHOICE = 0x10;
    private static final int TYPE_MULTI_CHOICE = 0x20;
    private static final int TYPE_SPINNER = 0x40;
    private static final int TYPE_DATE_PICKER = 0x80;
    private static final int TYPE_TIME_PICKER = 0x100;
    private static final int TYPE_CUSTOM = 0x200;

    private Context context;
    private int type = TYPE_DEFAULT;
    private String title;
    private String message;
    private String positiveButtonText;
    private String negativeButtonText;
    private String neutralButtonText;
    private DialogInterface.OnClickListener positiveButtonListener;
    private DialogInterface.OnClickListener negativeButtonListener;
    private DialogInterface.OnClickListener neutralButtonListener;
    private boolean cancelable = true;
    private int iconResId;
    private int titleResId;
    private int messageResId;
    private View customView;

    public StationDialogFragment() {
    }

    private StationDialogFragment(Context context, int type, String title, String message, String positiveButtonText, String negativeButtonText, String neutralButtonText, DialogInterface.OnClickListener positiveButtonListener, DialogInterface.OnClickListener negativeButtonListener, DialogInterface.OnClickListener neutralButtonListener, boolean cancelable, int iconResId, int titleResId, int messageResId, View customView) {
        this.context = context;
        this.type = type;
        this.title = title;
        this.message = message;
        this.positiveButtonText = positiveButtonText;
        this.negativeButtonText = negativeButtonText;
        this.neutralButtonText = neutralButtonText;
        this.positiveButtonListener = positiveButtonListener;
        this.negativeButtonListener = negativeButtonListener;
        this.neutralButtonListener = neutralButtonListener;
        this.cancelable = cancelable;
        this.iconResId = iconResId;
        this.titleResId = titleResId;
        this.messageResId = messageResId;
        this.customView = customView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onStart() {
        super.onStart();
        getDialog().getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.station_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView titleView = view.findViewById(R.id.titleView);
        TextView messageView = view.findViewById(R.id.messageView);
        ConstraintLayout contentLayout = view.findViewById(R.id.contentLayout);
        Button positiveButton = view.findViewById(R.id.positiveButton);
        Button negativeButton = view.findViewById(R.id.negativeButton);
        Button neutralButton = view.findViewById(R.id.neutralButton);
        ViewGroup buttonViewGroup=view.findViewById(R.id.buttonViewGroup);
        ViewGroup contentView = view.findViewById(R.id.customView);


        if (title != null) {
            titleView.setText(title);
            titleView.setVisibility(View.VISIBLE);
        } else if (titleResId != 0) {
            titleView.setText(titleResId);
            titleView.setVisibility(View.VISIBLE);
        }
        if (message != null || customView != null || messageResId != 0) {
            contentLayout.setVisibility(View.VISIBLE);
        }

        if (message != null) {
            messageView.setVisibility(View.VISIBLE);
            messageView.setText(message);
        } else if (messageResId != 0) {
            messageView.setVisibility(View.VISIBLE);
            messageView.setText(messageResId);
        }

        if (customView != null) {
            if (message != null)
                appendSpacer(contentView);
            contentView.addView(customView);
            customView.setVisibility(View.VISIBLE);
        }


        if (positiveButtonText != null || positiveButtonListener != null) {
            buttonViewGroup.setVisibility(View.VISIBLE);
            positiveButton.setVisibility(View.VISIBLE);
            positiveButton.setOnClickListener(v -> {
                if (positiveButtonListener != null)
                    positiveButtonListener.onClick(getDialog(), DialogInterface.BUTTON_POSITIVE);
                getDialog().dismiss();
            });
            positiveButton.setText(positiveButtonText);
        }

        if (negativeButtonText != null || negativeButtonListener != null) {
            buttonViewGroup.setVisibility(View.VISIBLE);
            negativeButton.setVisibility(View.VISIBLE);
            negativeButton.setOnClickListener(v->{
                if (negativeButtonListener != null)
                    negativeButtonListener.onClick(getDialog(), DialogInterface.BUTTON_NEGATIVE);
                getDialog().dismiss();
            });
            negativeButton.setText(negativeButtonText);
        }

        if (neutralButtonText != null || neutralButtonListener != null) {
            buttonViewGroup.setVisibility(View.VISIBLE);
            neutralButton.setVisibility(View.VISIBLE);
            neutralButton.setOnClickListener(v->{
                if (neutralButtonListener != null)
                    neutralButtonListener.onClick(getDialog(), DialogInterface.BUTTON_NEUTRAL);
                getDialog().dismiss();
            });
            neutralButton.setText(neutralButtonText);
        }


        if (iconResId != 0) {
            titleView.setCompoundDrawablesWithIntrinsicBounds(iconResId, 0, 0, 0);
            titleView.setCompoundDrawablePadding((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics()));
            titleView.setVisibility(View.VISIBLE);
        }


    }

    private void appendSpacer(ViewGroup parentView) {
        Space space = new Space(context);
        space.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics())));
        parentView.addView(space);
    }

    public static class Builder {
        private Context context;
        private String title;
        private String message;
        private String positiveButtonText;
        private String negativeButtonText;
        private String neutralButtonText;
        private DialogInterface.OnClickListener positiveButtonListener;
        private DialogInterface.OnClickListener negativeButtonListener;
        private DialogInterface.OnClickListener neutralButtonListener;
        private boolean cancelable = true;
        private int iconResId;
        private int titleResId;
        private int messageResId;
        private View customView;
        private int type = TYPE_DEFAULT;

        public Builder(Context context) {
            this.context = context;
        }


        public Builder setPositiveButton(String text, DialogInterface.OnClickListener listener) {
            this.positiveButtonText = text;
            this.positiveButtonListener = listener;
            return this;
        }

        public Builder setNegativeButton(String text, DialogInterface.OnClickListener listener) {
            this.negativeButtonText = text;
            this.negativeButtonListener = listener;
            return this;
        }

        public Builder setNeutralButton(String text, DialogInterface.OnClickListener listener) {
            this.neutralButtonText = text;
            this.neutralButtonListener = listener;
            return this;
        }

        public Builder setCancelable(boolean cancelable) {
            this.cancelable = cancelable;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setTitle(int titleResId) {
            this.titleResId = titleResId;
            return this;
        }

        public Builder setIcon(int iconResId) {
            this.iconResId = iconResId;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            this.type = TYPE_DEFAULT;
            return this;
        }

        public Builder setMessage(int messageResId) {
            this.messageResId = messageResId;
            return this;
        }

        public Builder setCustomView(View view) {
            this.customView = view;
            this.type = TYPE_CUSTOM;
            return this;
        }

        public Builder setCustomView(int layoutResId) {
            this.customView = LayoutInflater.from(context).inflate(layoutResId, null);
            this.type = TYPE_CUSTOM;
            return this;
        }

        public StationDialogFragment build() {
            return new StationDialogFragment(context, type, title, message, positiveButtonText, negativeButtonText, neutralButtonText, positiveButtonListener, negativeButtonListener, neutralButtonListener, cancelable, iconResId, titleResId, messageResId, customView);
        }

    }

}
