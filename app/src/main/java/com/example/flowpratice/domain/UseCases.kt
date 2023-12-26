package com.example.flowpratice.domain

import com.example.flowpratice.data.RepoImp
import com.example.flowpratice.data.dataholder.flowHolderClass
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UseCases @Inject constructor(var repoImp: RepoImp) {

    fun gettingData(picSearch: String): Flow<flowHolderClass> {
      return  repoImp.gettingData(picSearch)
    }
}