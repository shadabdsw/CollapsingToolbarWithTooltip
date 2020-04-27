package com.thedarkshadows.collapsingtoolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.tooltip.Tooltip;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Toolbar toolbar;
    Tooltip tooltip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.tvContent);

        final Handler handler = new Handler();

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tooltip = new Tooltip.Builder(textView)
                        .setText("Tooltip Working")
                        .setTextSize(getResources().getDimension(R.dimen.text_size))
                        .setBackgroundColor(Color.parseColor("#000000"))
                        .setTextColor(Color.parseColor("#FFFFFF"))
                        .setGravity(Gravity.TOP)
                        .setCornerRadius(getResources().getDimension(R.dimen.corner_radius))
                        .setCancelable(true)
                        .show();

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        tooltip.dismiss();
                    }
                }, 2000);
            }
        });


    }
}
