package com.example.sampletoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            LayoutInflater inflater = getLayoutInflater();
            //다른 layout xml에 있는 레이아웃을 지정해서 교체
            View layout = inflater.inflate(R.layout.toastborder,
                    (ViewGroup) findViewById(R.id.toast_layout_root));

            TextView text = layout.findViewById(R.id.text);

            Toast toast = new Toast(this);
            text.setText("모양 바꾼 토스트");
            toast.setGravity(Gravity.CENTER, 0, -100);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setView(layout);
            toast.show();
        });

        Button btnSnackbar = findViewById(R.id.buttonSnackbar);
        btnSnackbar.setOnClickListener(v -> {
            Snackbar.make(v,"스낵바 테스트", Snackbar.LENGTH_LONG).show();
        });
    }
}