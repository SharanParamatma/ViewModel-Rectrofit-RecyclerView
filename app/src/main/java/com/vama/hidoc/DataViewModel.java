package com.vama.hidoc;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataViewModel extends ViewModel {

    private MutableLiveData<Example>  mutableLiveData = new MutableLiveData<>();
    public LiveData<Example> getText() {
        Retrofit retrofitN = new Retrofit.Builder().baseUrl(ServiceParama.Base_URl).addConverterFactory(GsonConverterFactory.create()).build();
        ServiceParama serviceCall = retrofitN.create(ServiceParama.class);
        Call<Example> callN = serviceCall.getFeed("2946",0);
        callN.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(@NonNull Call<Example> call, retrofit2.Response<Example> response) {
                mutableLiveData.setValue(response.body());
                Log.e("Failure", ""+mutableLiveData.toString());
            }

            @Override
            public void onFailure(@NonNull Call<Example> call, Throwable t) {
                Log.e("Failure", ""+t.getMessage());
            }

        });

        return mutableLiveData;
    }


}
