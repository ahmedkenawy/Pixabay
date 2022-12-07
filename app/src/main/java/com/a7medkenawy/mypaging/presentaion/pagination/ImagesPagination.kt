package com.a7medkenawy.mypaging.presentaion.pagination

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.util.Log
import android.widget.Toast
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.a7medkenawy.mypaging.domain.model.Hit
import com.a7medkenawy.mypaging.domain.model.databaseentity.ImagesResponseEntity
import com.a7medkenawy.mypaging.domain.usecase.ResponseUseCase
import dagger.hilt.android.internal.Contexts.getApplication

class ImagesPagination(val responseUseCase: ResponseUseCase, var context: Context) :
    PagingSource<Int, Hit>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Hit> {
        try {
            val currentPageList = params.key ?: 1
            val responseList = mutableListOf<Hit>()
            var data = emptyList<Hit>()
            if (isOnline()) {
                val response = responseUseCase.getImagesFromApi(currentPageList)
                if (response.isSuccessful){
                    data = (response.body()?.hits ?: emptyList())
                    responseUseCase.insertAllImages(ImagesResponseEntity(response.body()!!))}
            } else {
                responseUseCase.getAllImages().collect {
                    if (!it[0].imageResponse.hits.isNullOrEmpty())
                        data = it[0].imageResponse.hits
                }
            }

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

    private fun isOnline(): Boolean {
        val connectivityManager = getApplication(context).getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager
        val activeNetwork: Network = (connectivityManager.activeNetwork ?: false) as Network
        val capacities: NetworkCapabilities =
            (connectivityManager.getNetworkCapabilities(activeNetwork)
                ?: false) as NetworkCapabilities
        return when {
            capacities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            capacities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            capacities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    }
}