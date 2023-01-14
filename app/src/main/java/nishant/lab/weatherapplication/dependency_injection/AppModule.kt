package nishant.lab.weatherapplication.dependency_injection




import android.app.Application
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import nishant.lab.weatherapplication.comman.Constants
import nishant.lab.weatherapplication.data.remote.TimelineWeatherApi
import nishant.lab.weatherapplication.data.repository.TimeLineWeatherRepositoryImpl
import nishant.lab.weatherapplication.domain.repository.TimeLineWeatherRepository
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideTimeLineWeatherApi():TimelineWeatherApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(TimelineWeatherApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(api : TimelineWeatherApi):TimeLineWeatherRepository{
        return TimeLineWeatherRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideFusedLocationProviderClient(app: Application): FusedLocationProviderClient {
        return LocationServices.getFusedLocationProviderClient(app)
    }


}