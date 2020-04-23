package com.example.viewassignment;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StudentListApiClient {
    private static final String BASE_URL ="http://jsonplaceholder.typicode.com/" ;

    public static Retrofit retrofit=null;

    public static Retrofit getData(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;

    }


}
