package com.example.aplikacja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.aplikacja.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    //Dzieki binding mozna nei uzywac findViewById
    private ActivityMainBinding binding;
    PunktyViewModel punktyViewModel;// Po oborocie
    private SharedPreferences punktySharedPreferences; // po wylaczeniu aplikacji

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        punktySharedPreferences = getPreferences(MODE_PRIVATE);

        punktyViewModel = new ViewModelProvider(this).get(PunktyViewModel.class);
        odczytajSHP(); //Nusi byc po stworzeniu viewModela ^^^
        punktyViewModel.getPunkty().observe(this,
                new Observer<Integer>() {
                    @Override
                    public void onChanged(Integer integer) { //integer to zmieniona liczba
                        binding.text.setText(String.valueOf(integer)) ;
                    }
                });
        //Wazna kolejnosc najpierw tworzyszpozniej robisz punkjty


        binding.button.setOnClickListener(view1 -> {
            punktyViewModel.dodajPunkty(1);
        });
        binding.button2.setOnClickListener(view1 -> {
            punktyViewModel.dodajPunkty(2);
        });
        binding.button3.setOnClickListener(view1 -> {
            punktyViewModel.dodajPunkty(3);
        });
    }
    private void zapiszSHP(){
        SharedPreferences.Editor edytor =punktySharedPreferences.edit();
        edytor.putInt("PUNKTY", punktyViewModel.getPunkty().getValue() );
        edytor.apply();
    }
    private void odczytajSHP(){ //Shp SharedPrefeferences
        int  p = punktySharedPreferences.getInt("PUNKTY", 0) ;
//        Log.d("Punkty", Integer.toString(p));
        punktyViewModel.setPunkty(p);
    }

    @Override
    protected void onPause() {
        super.onPause();
        zapiszSHP();
    }



}