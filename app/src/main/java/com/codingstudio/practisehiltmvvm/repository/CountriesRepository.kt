package com.codingstudio.practisehiltmvvm.repository

import androidx.lifecycle.MutableLiveData
import com.codingstudio.practisehiltmvvm.RepoToVM
import com.codingstudio.practisehiltmvvm.api.RetrofitInstance
import com.codingstudio.practisehiltmvvm.model.Country
import kotlinx.coroutines.*
import retrofit2.Response
import javax.inject.Inject

// @Inject Constructor injection

class CountriesRepository @Inject constructor() {

    //var countriesRepository : MutableLiveData<List<Country>> = MutableLiveData()
    var job: Job?= null
    var response: Response<List<Country>>?= null
    lateinit var repoToVM: RepoToVM

    fun fetchCountriesRepo() {

        job = CoroutineScope(Dispatchers.IO).launch {

            try {
                response = RetrofitInstance.api.fetchCountries()
            }catch (e: Exception){
                println("\nException Occurred: $e\n")
            }
            withContext(Dispatchers.Main){
                response?.let {
                    if (it.isSuccessful){
                        repoToVM.passCountries(it.body())
                    }
                }
            }
        }

    }


    fun setInterface(repoToVM: RepoToVM){
        this.repoToVM = repoToVM

    }


















}