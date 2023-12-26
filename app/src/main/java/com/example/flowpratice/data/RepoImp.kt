package com.example.flowpratice.data

import com.example.flowpratice.data.api.ApiService
import com.example.flowpratice.data.dataholder.flowHolderClass
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

import javax.inject.Inject

class RepoImp @Inject constructor(private val apiService: ApiService) : Repo {

    override fun gettingData(picSearch: String): Flow<flowHolderClass> = flow {
        try {
            val response = apiService.ServiceConnection().gettingWallpapers(picSearch, "photo").execute()

            if (response.isSuccessful) {
                emit(flowHolderClass(isLoading = false, error = null, response = response.body()))
            } else {
                emit(flowHolderClass(isLoading = false, error = response.message(), response = null))
            }
        } catch (e: Exception) {
            // Handle exceptions here, emit an error state if needed
            emit(flowHolderClass(isLoading = false, error = e.message ?: "Unknown error", response = null))
        }
    }.flowOn(Dispatchers.IO)
}