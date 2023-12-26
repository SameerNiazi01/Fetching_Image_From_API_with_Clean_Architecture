package com.example.flowpratice.data

import com.example.flowpratice.data.dataholder.flowHolderClass
import kotlinx.coroutines.flow.Flow


interface Repo {
    fun gettingData(picSearch:String): Flow<flowHolderClass>

}