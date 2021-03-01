package com.example.movieapp.data.repositories

import com.example.movieapp.data.data_providers.remote.RemoteDataProvider
import com.example.movieapp.data.models.PopularMoviesResModel
import com.example.movieapp.domain.repositories.PopularMoviesRepository
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

class PopularMoviesRepositoryImpl @Inject constructor(
    private val remoteDataProvider: RemoteDataProvider
): PopularMoviesRepository {
    override fun getPopularMovies(api_key: String): Flowable<PopularMoviesResModel> = remoteDataProvider.getPopularMovies(api_key)
    override fun getPopularMovies(api_key: String, page: Long): Flowable<PopularMoviesResModel> = remoteDataProvider.getPopularMoviesForPaging(api_key, page)

}