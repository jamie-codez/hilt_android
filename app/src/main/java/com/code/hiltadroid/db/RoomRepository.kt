package com.code.hiltadroid.db

import javax.inject.Inject

class RoomRepository @Inject constructor(private val appDao: AppDao) {
    suspend fun getRecords():List<UserEntity> = appDao.getRecords()
    suspend fun insertRecord(userEntity:UserEntity) = appDao.insert(userEntity)
}