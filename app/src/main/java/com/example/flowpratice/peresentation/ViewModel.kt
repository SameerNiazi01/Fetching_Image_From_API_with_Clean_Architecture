package com.example.flowpratice.peresentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flowpratice.data.dataholder.WallpaperData
import com.example.flowpratice.data.dataholder.flowHolderClass
import com.example.flowpratice.domain.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


data class UiState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val response: WallpaperData
)

@HiltViewModel
class ViewModel @Inject constructor(var useCases: UseCases) : ViewModel() {
    val _picsData = MutableStateFlow(WallpaperData(0,0,emptyList()))
    var showInProgress: MutableStateFlow<Boolean> = MutableStateFlow<Boolean>(true)
    var error: MutableStateFlow<String?> = MutableStateFlow<String?>(null)

    val UiState= combine(_picsData, showInProgress, error){
            _picsData ,showInProgress, error ->
        UiState(showInProgress, error, _picsData)
    }

    fun gettingData(picSearch: String) {
        viewModelScope.launch {
            useCases.gettingData(picSearch).collectLatest {apiresponse->
                _picsData.update {
                        apiresponse.response!!
                }
                showInProgress.update {
                    apiresponse.isLoading
                }
                error.update {
                    apiresponse.error
                }

            }
        }
    }

}