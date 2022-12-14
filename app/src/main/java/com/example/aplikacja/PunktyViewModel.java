package com.example.aplikacja;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PunktyViewModel extends ViewModel {
    private MutableLiveData<Integer> punkty = new MutableLiveData<>(); //Mozna uzyc bo dodalismy w build.gradle
    //MutableLiveData to zapisana klasa wartosci czy cos

    public MutableLiveData<Integer> getPunkty() {
        if(punkty == null) {
            punkty = new MutableLiveData<>();
            punkty.setValue(0);
        }
        return punkty;
    }

    public void setPunkty(int punkty) {
        this.punkty.setValue(punkty);
    }

    public void dodajPunkty(int i ){
        if(punkty.getValue()!= null)
        {
            punkty.setValue(punkty.getValue()+i);
        }
    }
    public int getP(){
        return punkty.getValue();
    }
}
