package com.justintuchek.testingplayground;


import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ConnectionHeaderView extends LinearLayout {

    private TextView tvState;
    private Button btAction;

    private boolean connected = false;

    public ConnectionHeaderView(@NonNull Context context) {
        super(context);
        init(context);
    }

    public ConnectionHeaderView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ConnectionHeaderView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_connection_header, this);
        tvState = findViewById(R.id.tv_connection_state_label);
        btAction = findViewById(R.id.btn_connection_action);
        btAction.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(connected) {
                    tvState.setText("disconnected");
                    btAction.setText("connect");
                } else {
                    tvState.setText("connected");
                    btAction.setText("disconnect");
                }

                connected = !connected;
            }
        });
    }

}
