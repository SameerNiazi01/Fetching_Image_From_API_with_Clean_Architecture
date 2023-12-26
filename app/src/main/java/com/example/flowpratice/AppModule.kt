package com.example.flowpratice

import com.example.flowpratice.data.RepoImp
import com.example.flowpratice.data.api.ApiService
import com.example.flowpratice.domain.UseCases
import com.example.flowpratice.peresentation.ViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun providesApiLogin(): ApiService {
        return  ApiService()
    }

    @Provides
    fun providesRepo(apiService: ApiService): RepoImp {
        return  RepoImp(apiService)
    }


    @Provides
    fun providesUseCases(repoimp: RepoImp): UseCases {
        return  UseCases(repoimp)
    }


    @Provides
        fun providesViewModel(useCases: UseCases): ViewModel {
            return ViewModel(useCases)
        }

}