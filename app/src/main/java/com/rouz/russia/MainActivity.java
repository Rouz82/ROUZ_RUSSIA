package com.rouz.russia;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private int dp(float value) {
        return (int) (value * getResources().getDisplayMetrics().density + 0.5f);
    }

    private GradientDrawable background(int color, float radius) {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(color);
        drawable.setCornerRadius(dp(radius));
        return drawable;
    }

    private TextView text(
            String value,
            float size,
            int color,
            boolean bold
    ) {
        TextView view = new TextView(this);
        view.setText(value);
        view.setTextSize(size);
        view.setTextColor(color);
        view.setGravity(Gravity.CENTER);

        if (bold) {
            view.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        }

        return view;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setStatusBarColor(Color.BLACK);
        getWindow().setNavigationBarColor(Color.BLACK);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setGravity(Gravity.CENTER_HORIZONTAL);
        root.setPadding(dp(24), dp(15), dp(24), dp(20));
        root.setBackgroundColor(Color.BLACK);

        // ЛОГОТИП ROUZ RUSSIA
        ImageView logo = new ImageView(this);
        logo.setImageResource(R.drawable.rouz_logo);
        logo.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

        root.addView(
                logo,
                new LinearLayout.LayoutParams(
                        -1,
                        dp(230)
                )
        );

        Space topSpace = new Space(this);

        root.addView(
                topSpace,
                new LinearLayout.LayoutParams(
                        1,
                        dp(5)
                )
        );

        // Карточка статуса
        LinearLayout statusCard = new LinearLayout(this);
        statusCard.setOrientation(LinearLayout.VERTICAL);
        statusCard.setGravity(Gravity.CENTER);
        statusCard.setPadding(
                dp(20),
                dp(18),
                dp(20),
                dp(18)
        );

        statusCard.setBackground(
                background(Color.rgb(22, 22, 22), 18)
        );

        TextView statusTitle = text(
                "ROUZ RUSSIA",
                19,
                Color.WHITE,
                true
        );

        statusCard.addView(
                statusTitle,
                new LinearLayout.LayoutParams(
                        -1,
                        dp(35)
                )
        );

        TextView status = text(
                "●  Сервер работает",
                15,
                Color.rgb(100, 220, 130),
                false
        );

        statusCard.addView(
                status,
                new LinearLayout.LayoutParams(
                        -1,
                        dp(30)
                )
        );

        root.addView(
                statusCard,
                new LinearLayout.LayoutParams(
                        -1,
                        dp(105)
                )
        );

        Space buttonSpace = new Space(this);

        root.addView(
                buttonSpace,
                new LinearLayout.LayoutParams(
                        1,
                        dp(25)
                )
        );

        // КНОПКА ИГРАТЬ
        Button playButton = new Button(this);

        playButton.setText("ИГРАТЬ");
        playButton.setTextSize(17);
        playButton.setTextColor(Color.WHITE);
        playButton.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        playButton.setAllCaps(false);
        playButton.setGravity(Gravity.CENTER);

        playButton.setBackground(
                background(Color.rgb(120, 40, 200), 16)
        );

        playButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(
                                MainActivity.this,
                                "Запуск игры будет добавлен позже",
                                Toast.LENGTH_SHORT
                        ).show();
                    }
                }
        );

        root.addView(
                playButton,
                new LinearLayout.LayoutParams(
                        -1,
                        dp(58)
                )
        );

        Space updateSpace = new Space(this);

        root.addView(
                updateSpace,
                new LinearLayout.LayoutParams(
                        1,
                        dp(12)
                )
        );

        // КНОПКА ОБНОВЛЕНИЯ
        Button updateButton = new Button(this);

        updateButton.setText("ПРОВЕРИТЬ ОБНОВЛЕНИЯ");
        updateButton.setTextSize(15);
        updateButton.setTextColor(Color.WHITE);
        updateButton.setAllCaps(false);
        updateButton.setGravity(Gravity.CENTER);

        updateButton.setBackground(
                background(Color.rgb(35, 35, 35), 16)
        );

        updateButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(
                                MainActivity.this,
                                "Проверка обновлений...",
                                Toast.LENGTH_SHORT
                        ).show();
                    }
                }
        );

        root.addView(
                updateButton,
                new LinearLayout.LayoutParams(
                        -1,
                        dp(54)
                )
        );

        Space bottomSpace = new Space(this);

        root.addView(
                bottomSpace,
                new LinearLayout.LayoutParams(
                        1,
                        0,
                        1
                )
        );

        TextView version = text(
                "ROUZ RUSSIA • v1.0",
                13,
                Color.GRAY,
                false
        );

        root.addView(
                version,
                new LinearLayout.LayoutParams(
                        -1,
                        dp(30)
                )
        );

        setContentView(root);
    }
}
