package com.example.aplikacja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.aplikacja.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    //Dzieki binding mozna nei uzywac findViewById
    private ActivityMainBinding binding;
    PunktyViewModel punktyViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        punktyViewModel = new ViewModelProvider(this).get(PunktyViewModel.class);

        binding.text.setText(Integer.toString(punktyViewModel.getPunkty()));
        //Wazna kolejnosc najpierw tworzyszpozniej robisz punkjty


        binding.button.setOnClickListener(view1 -> {
            punktyViewModel.dodajPunkty(1);
            binding.text.setText(Integer.toString(punktyViewModel.getPunkty())); //value of zamiast to stringa bo nie ma Integera
        });
        binding.button2.setOnClickListener(view1 -> {
            punktyViewModel.dodajPunkty(2);
            binding.text.setText(Integer.toString(punktyViewModel.getPunkty())); //value of zamiast to stringa bo nie ma Integera
        });
        binding.button3.setOnClickListener(view1 -> {
            punktyViewModel.dodajPunkty(3);
            binding.text.setText(Integer.toString(punktyViewModel.getPunkty())); //value of zamiast to stringa bo nie ma Integera
        });
    }
    //Anty znikacz
}