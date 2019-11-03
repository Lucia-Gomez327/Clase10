package com.ulp.clase10.vistas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ulp.clase10.model.Municipio;
import com.ulp.clase10.model.Resultado;
import com.ulp.clase10.request.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainViewModel extends ViewModel {

//observando el estring del textView
    private MutableLiveData<String> lista;

    public LiveData<String> getLista(){
        if(lista == null){
            lista = new MutableLiveData<>();
        }

        return lista;

    }

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

}
