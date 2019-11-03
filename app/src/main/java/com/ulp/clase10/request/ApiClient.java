package com.ulp.clase10.request;


import android.util.Log;

import com.ulp.clase10.model.Resultado;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.PATCH;


public class ApiClient {

    private static final  String path =  "https://apis.datos.gob.ar/georef/api/";
    private  static MyApiInterface myApiInterface;

    public static MyApiInterface getMyApiInterface(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(path)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        Log.d("mensaje", retrofit.baseUrl().toString());
        myApiInterface = retrofit.create(MyApiInterface.class);
        return  myApiInterface;
    }

    public interface MyApiInterface {

        String prov = "74";
        //get dice a que servicio va a llamar
         @GET("municipios?provincia="+prov)
         Call<Resultado> leer();

    }
}
