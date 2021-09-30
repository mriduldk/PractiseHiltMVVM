package com.codingstudio.practisehiltmvvm.api

import com.codingstudio.practisehiltmvvm.model.Country
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitAPI {


    @GET("DevTides/countries/master/countriesV2.json")
    suspend fun fetchCountries() : Response<List<Country>>


}