package com.a7medkenawy.mypaging.presentaion.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.a7medkenawy.mypaging.domain.usecase.ResponseUseCase
import com.a7medkenawy.mypaging.presentaion.pagination.ImagesPagination
import dagger.hilt.android.internal.Contexts.getApplication
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class ImageViewModel @Inject constructor(
    val responseUseCase: ResponseUseCase,
    @ApplicationContext val context: Context,
) : ViewModel() {


    val photoList = Pager(PagingConfig(pageSize = 100)) {
        ImagesPagination(responseUseCase,context)
    }.flow.cachedIn(viewModelScope)


}