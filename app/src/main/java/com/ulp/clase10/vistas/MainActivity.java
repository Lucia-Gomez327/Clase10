package com.ulp.clase10.vistas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.ulp.clase10.R;
import com.ulp.clase10.model.Programa;
import com.ulp.clase10.model.ProgramaAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    private TextView salida;
    MainViewModel mainViewModel;
    private Button btnBuscar;

    private EditText etBuscar;
    private ListView lvNombrePrograma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configView();
    }

    private void configView(){


        etBuscar = findViewById(R.id.etBuscar);
        lvNombrePrograma = findViewById(R.id.ltNombrePrograma);
        btnBuscar = findViewById(R.id.btnBuscar);
        ArrayList<Programa> programaArrayList = new ArrayList<Programa>();

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        listarNombres();

        mainViewModel.getListaProg().observe(this, new Observer<ArrayList<Programa>>() {
            @Override
            public void onChanged(ArrayList<Programa> programas) {
                if(programas != null){
                    ArrayList<String> lista_nombres = new ArrayList<>();

                    for (Programa p: programas){
                        Log.d("NOmbre",p.getNombre());
                        if(p.getNombre().contains(etBuscar.getText().toString())){
                            lista_nombres.add(p.getNombre());
                        }
                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),R.layout.activity_nombres_items,R.id.tvNombreItem,lista_nombres);
                    lvNombrePrograma.setAdapter(adapter);

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

    public  void listarNombres(){
        mainViewModel.cargarProgramas();
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

    //public void buscar(View view){
        //mainViewModel.buscarViewModel();
    //}


}
