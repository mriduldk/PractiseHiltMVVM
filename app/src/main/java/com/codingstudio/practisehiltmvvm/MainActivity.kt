package com.codingstudio.practisehiltmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.codingstudio.practisehiltmvvm.repository.CountriesRepository
import com.codingstudio.practisehiltmvvm.viewModel.ListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val viewModel by viewModels<ListViewModel>() //{ ListViewModelFactory(CountriesRepository()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.countries.observe(this, Observer { response ->

            println("\n$response\n")
        })
    }
}




/*

class ListViewModelFactory constructor(private val countriesRepository: CountriesRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        */
/*if (modelClass.isAssignableFrom(ListViewModel::class.java)){
        }*//*


        return ListViewModel(countriesRepository) as T
    }

}
*/






















