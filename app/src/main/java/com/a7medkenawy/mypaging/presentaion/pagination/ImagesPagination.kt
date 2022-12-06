package com.a7medkenawy.mypaging.presentaion.pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.a7medkenawy.mypaging.domain.model.Hit
import com.a7medkenawy.mypaging.domain.usecase.ResponseUseCase

class ImagesPagination(val responseUseCase: ResponseUseCase) : PagingSource<Int, Hit>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Hit> {
        try {
            val currentPageList = params.key ?: 1
            val response = responseUseCase.getImagesFromApi(currentPageList)
            val responseList = mutableListOf<Hit>()

            val data = response.body()?.hits ?: emptyList()
            responseList.addAll(data as Collection<Hit>)

            val previousKey = if (currentPageList == 1) null else currentPageList - 1
            return LoadResult.Page(
                responseList,
                previousKey,
                currentPageList.plus(1)
            )

        } catch (ex: Exception) {
            return LoadResult.Error(ex)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Hit>): Int? {
        return null
    }
}