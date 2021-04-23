package com.coderefer.baseandroidskeleton.di.modules

import android.content.Context
import com.coderefer.baseandroidskeleton.data.api.BaseService
import com.coderefer.baseandroidskeleton.data.database.BaseAndroidSkeletonDatabase
import com.coderefer.baseandroidskeleton.data.repos.home.HomeLocalDataSource
import com.coderefer.baseandroidskeleton.data.repos.home.HomeRemoteDataSource
import com.coderefer.baseandroidskeleton.data.repos.home.HomeRepo
import com.coderefer.baseandroidskeleton.utils.CoroutineDispatchProvider
import dagger.Module
import dagger.Provides

@Module(includes = [NetworkModule::class])
class StorageModule{

    @Provides
    fun provideDatabase(context: Context) : BaseAndroidSkeletonDatabase {
        return BaseAndroidSkeletonDatabase.getDatabase(context)
    }

    @Provides
    fun provideHomeRepo(localDataSource: HomeLocalDataSource, remoteDataSource: HomeRemoteDataSource) : HomeRepo {
        return HomeRepo(localDataSource, remoteDataSource)
    }

    @Provides
    fun provideHomeLocalDataSource(database: BaseAndroidSkeletonDatabase) : HomeLocalDataSource {
        return HomeLocalDataSource(database)
    }
    @Provides
    fun provideHomeRemoteDataSource(service : BaseService) : HomeRemoteDataSource {
        return HomeRemoteDataSource(service)
    }

    @Provides
    fun provideCoroutineDispatchProvider(): CoroutineDispatchProvider {
        return CoroutineDispatchProvider()
    }
}