package com.vama.hidoc;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ServiceParama {
    String Base_URl = "http://devapi.hidoc.co/healthtips/";

    @FormUrlEncoded
    @POST("healthtips.php")
    Call<Example> getFeed(@Field("userid") String userid, @Field("lastcount") int lastcount);
}
