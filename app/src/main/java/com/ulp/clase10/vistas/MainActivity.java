package com.ulp.clase10.vistas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.ulp.clase10.R;
import com.ulp.clase10.model.Programa;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    TextView etBuscar;
    MainViewModel mainViewModel;
    Button btnBuscar;
    ListView lvNombrePrograma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configView();
    }

    private void configView(){


        etBuscar = findViewById(R.id.etBuscar);
        lvNombrePrograma = findViewById(R.id.lvNombrePrograma);
        btnBuscar = findViewById(R.id.btnBuscar);

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        mainViewModel.getListaProg().observe(this, new Observer<ArrayList<Programa>>() {
            @Override
            public void onChanged(ArrayList<Programa> programas) {
                if(programas != null){
                    ArrayList<String> lista_nombres = new ArrayList<>();

                    for (Programa p: programas){
                        //buscar por lo engresado al tv
                        if(p.getNombre().contains(etBuscar.getText().toString())){
                            lista_nombres.add(p.getNombre());
                        }
                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),R.layout.activity_nombres_items,R.id.tvNombreItem,lista_nombres);
                    lvNombrePrograma.setAdapter(adapter);

                }

            }
        });



        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainViewModel.cargarProgramas();
            }
        });

       /*  mainViewModel.getLista().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                salida.setText(s);
            }


        }); */
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
