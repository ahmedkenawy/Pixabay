package com.a7medkenawy.mypaging.presentaion.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.a7medkenawy.mypaging.domain.usecase.ResponseUseCase
import com.a7medkenawy.mypaging.presentaion.pagination.ImagesPagination
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ImageViewModel @Inject constructor(val responseUseCase: ResponseUseCase) : ViewModel() {
    val photoList = Pager(PagingConfig(pageSize = 100)) {
        ImagesPagination(responseUseCase)
    }.flow.cachedIn(viewModelScope)
}