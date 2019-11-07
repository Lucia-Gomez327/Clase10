package com.ulp.clase10.request;


import android.util.Log;

import com.ulp.clase10.model.ListaProgramas;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;


public class ApiClientCultura {

    private static final  String path =  "https://www.cultura.gob.ar/api/v2.0/programas/";
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

        //get dice a que servicio va a llamar
         @GET("?format=json&limit=15")
         Call<ListaProgramas> leerProgramas();
         //Metodo para traer un solo programa
         //@GET("{idPrograma}")Call<Programa> leerPrograma(@Path("idPrograma") int idP);

    }


}
