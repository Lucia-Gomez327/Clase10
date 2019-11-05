package com.ulp.clase10.vistas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.ulp.clase10.R;
import com.ulp.clase10.model.Programa;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView salida;
MainViewModel mainViewModel;

private EditText etBuscar;

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
        etBuscar = findViewById(R.id.etBuscar);
        ArrayAdapter<>


        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        final ArrayList<String> nombre;

        mainViewModel.getListaProg().observe(this, new Observer<ArrayList<Programa>>() {
            @Override
            public void onChanged(ArrayList<Programa> programas) {
                
                for(Programa it: programas )
                {
                    lvNombrePrograma.add()

                }
            }
        });



        mainViewModel.getLista().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                salida.setText(s);
            }


        });


    }

    public  void listarNombres(View view){
        mainViewModel.cargarProgramas();
    }


    public void buscar(View view){
        mainViewModel.buscarViewModel();
    }


}
