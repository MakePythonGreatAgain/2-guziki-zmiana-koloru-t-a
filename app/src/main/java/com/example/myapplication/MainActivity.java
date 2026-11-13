package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Wprowadzenie Danych
    private Button buttonCzarny;
    private Button buttonZolty;
    private Button buttonNastepny;
    private LinearLayout Layout;
    private ImageView imageView;

    private final int[] imageArray=new int[] //Array na obrazki
    {
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
            R.drawable.okapi
    };

    //pierwszy obraz
    private int ktoryNrObrazka = 0;



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

        //Zdefiniowanie Danych

        buttonNastepny = findViewById(R.id.button1);
        buttonCzarny = findViewById(R.id.button2);
        buttonZolty = findViewById(R.id.button3);
        Layout = findViewById(R.id.main);
        imageView = findViewById(R.id.imageView1);

        //Wstawiamy przed pierwszym wstawieniu obrazka if który da teraźniejszy indeks obrazka przy obrocie
        if(savedInstanceState != null)
        {
            ktoryNrObrazka = savedInstanceState.getInt("obraz", 0);
        }


        //Ustaw Obraz podstawowy jako pierwszy obraz
        imageView.setImageResource(imageArray[ktoryNrObrazka]);


        //czarny button ustawia tło czarne
        buttonCzarny.setOnClickListener(view -> {
            Layout.setBackgroundColor(Color.BLACK);
        });

        //button żółty ustawie tło żółte
        buttonZolty.setOnClickListener(view -> {
            Layout.setBackgroundColor(Color.YELLOW);
        });

        //button nastepny
        buttonNastepny.setOnClickListener(view -> {

            //Z obrazka 1 idzie do obrazka 2 (Z arrayimage)
            ktoryNrObrazka++;

            if (ktoryNrObrazka >= imageArray.length){
                //Jeśli obrazek ma index większy niż wielkość

                ktoryNrObrazka = 0;
            }
            //Zmienia index na 0 (pierwszy) a potem ustawia obrazek pierwszy (Znowu na start)
            imageView.setImageResource(imageArray[ktoryNrObrazka]);
        });

    }

    private int imageArray(int ktoryNrObrazka) {
        return 0;
    }

    //Ważne do zapisania obrazka przy obrocie
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("obraz", ktoryNrObrazka);

    }
}