package com.codingstudio.practisehiltmvvm.hiltModule

import com.codingstudio.practisehiltmvvm.repository.CountriesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Singleton


@Module
@InstallIn(ActivityComponent::class)
class NetworkModule {

    //@Singleton
    @Provides
    fun providesCountriesRepository(countriesRepository: CountriesRepository): CountriesRepository {
        return countriesRepository
    }


}