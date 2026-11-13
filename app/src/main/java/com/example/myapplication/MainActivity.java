package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button buttonCzarny;
    private Button buttonZolty;
    private Button buttonNastepny;
    private LinearLayout Layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        buttonNastepny = findViewById(R.id.button1);
        buttonCzarny = findViewById(R.id.button2);
        buttonZolty = findViewById(R.id.button3);
        Layout = findViewById(R.id.main);

        ArrayList<Object> arrayList = new ArrayList<>();

        buttonCzarny.setOnClickListener(view -> {
            Layout.setBackgroundColor(Color.BLACK);
        });

        buttonZolty.setOnClickListener(view -> {
            Layout.setBackgroundColor(Color.YELLOW);
        });
    }
}