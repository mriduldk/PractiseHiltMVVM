package com.codingstudio.practisehiltmvvm.viewModel

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.codingstudio.practisehiltmvvm.RepoToVM
import com.codingstudio.practisehiltmvvm.model.Country
import com.codingstudio.practisehiltmvvm.repository.CountriesRepository

// @ViewModelInject

class ListViewModel @ViewModelInject constructor(val countriesRepository: CountriesRepository) : ViewModel(), RepoToVM {

    var countries : MutableLiveData<List<Country>> = MutableLiveData()


    fun fetchCountries() {

        countriesRepository.setInterface(this)
        countriesRepository.fetchCountriesRepo()
    }


    override fun passCountries(countries: List<Country>?) {
        this.countries.value = countries
    }


}