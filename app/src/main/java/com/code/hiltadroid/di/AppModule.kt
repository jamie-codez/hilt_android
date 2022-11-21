package com.code.hiltadroid.di

import android.app.Application
import android.content.Context
import com.code.hiltadroid.db.AppDao
import com.code.hiltadroid.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun getAppDB(context: Application): AppDatabase = AppDatabase.getAppDatabase(context)

    @Singleton
    @Provides
    fun getDao(appDB: AppDatabase): AppDao = appDB.getDao()
}