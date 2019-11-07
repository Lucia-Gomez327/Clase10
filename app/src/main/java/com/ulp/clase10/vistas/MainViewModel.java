package com.ulp.clase10.vistas;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ulp.clase10.model.ListaProgramas;
import com.ulp.clase10.model.Municipio;
import com.ulp.clase10.model.Programa;
import com.ulp.clase10.model.Resultado;
import com.ulp.clase10.request.ApiClient;
import com.ulp.clase10.request.ApiClientCultura;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainViewModel extends ViewModel {

//observando el estring del textView

    private MutableLiveData<ArrayList<Programa>> listaProg;
    private MutableLiveData<String> link;

    private MutableLiveData<String> lista;

    public LiveData<String> getLista(){
        if(lista == null){
            lista = new MutableLiveData<>();
        }
        return lista;
    }

    public LiveData<ArrayList<Programa>> getListaProg(){
        if(listaProg == null){
            listaProg = new MutableLiveData<>();
        }
        return listaProg;
    }

    public void modificaLink (int idPrograma) {


        Call<Programa> programaCall = ApiClientCultura.getMyApiInterface().leerPrograma(idPrograma);
        programaCall.enqueue(new Callback<Programa>() {
            @Override
            public void onResponse(Call<Programa> call, Response<Programa> response) {

                if(response.isSuccessful()){
                    Programa programa = response.body();
                    link.postValue(programa.getLink());
                }
            }

            @Override
            public void onFailure(Call<Programa> call, Throwable t) {
                link.postValue("No hay link");
            }
        });
    }


    public void cargarProgramas (){
        //conectar con el objeto Retrofit
        //invicar el metodo leer
        //leer devuelve un resultado
        Call<ListaProgramas> datos = ApiClientCultura.getMyApiInterface().leerProgramas();
        datos.enqueue(new Callback<ListaProgramas>() {
            //se ejecuta una vez que tuvo la respuesta
            @Override
            public void onResponse(Call<ListaProgramas> call, Response<ListaProgramas> response) {
                //respons tiene mi resultado
                if(response.isSuccessful()){
                    ArrayList<Programa> listaProgramas = response.body().getProgramas();
                   
                    listaProg.postValue(listaProgramas);
                }
            }
            // se ejecuta si hay algun error
            @Override
            public void onFailure(Call<ListaProgramas> call, Throwable t) {
                Log.d("mensaaa","mensaje error en observer mainviewmodel");
                listaProg.postValue(null);
            }
        });
    }



    public void descripcionViewModel(){
        Call<Resultado> datos = ApiClient.getMyApiInterface().leer();
        datos.enqueue(new Callback<Resultado>() {
            @Override
            public void onResponse(Call<Resultado> call, Response<Resultado> response) {
                if(response.isSuccessful()){
                    Resultado resultado = response.body();

                    StringBuffer cadena = new StringBuffer();

                    for (Municipio it:resultado.getMunicipios())
                    {
                        cadena.append(it.getNombre()+"\n");
                    }
                    lista.postValue(cadena.toString());
                }
            }
            // se ejecuta si hay algun error
            @Override
            public void onFailure(Call<Resultado> call, Throwable t) {
                lista.postValue(t.getMessage());
            }
        });
    }

/*

    public void buscarViewModel (){
        //conectar con el objeto Retrofit
        //invicar el metodo leer
        //leer devuelve un resultado
        Call<Resultado> datos = ApiClient.getMyApiInterface().leer();
        datos.enqueue(new Callback<Resultado>() {
            //se ejecuta una vez que tuvo la respuesta
            @Override
            public void onResponse(Call<Resultado> call, Response<Resultado> response) {
                //respons tiene mi resultado
                if(response.isSuccessful()){
                    Resultado resultado = response.body();

                    StringBuffer cadena = new StringBuffer();

                    for (Municipio it :resultado.getMunicipios())
                    {
                        cadena.append(it.getNombre()+"\n");
                    }
                    lista.postValue(cadena.toString());
                }
            }
            // se ejecuta si hay algun error
            @Override
            public void onFailure(Call<Resultado> call, Throwable t) {
                lista.postValue(t.getMessage());
            }
        });
    }

*/

}
