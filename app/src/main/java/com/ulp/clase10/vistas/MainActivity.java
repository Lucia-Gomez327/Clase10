package com.ulp.clase10.vistas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.ulp.clase10.R;

public class MainActivity extends AppCompatActivity {

    private TextView salida;
MainViewModel mainViewModel;

private ListView lvNombrePrograma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configView();
    }

    /*private void configView(){
       salida = findViewById(R.id.salida);

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mainViewModel.getLista().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                salida.setText(s);
            }
        });
    }*/
    private void configView(){

        lvNombrePrograma = findViewById(R.id.ltNombrePrograma);

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
       

        mainViewModel.getLista().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                salida.setText(s);
            }


        });

        lvNombrePrograma
    }


    public void buscar(View view){
        mainViewModel.buscarViewModel();
    }
}
