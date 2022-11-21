package com.code.hiltadroid.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AppDao {
    @Query("select * from user order by id desc")
    suspend fun getRecords():List<UserEntity>
    @Insert
    suspend fun insert(userEntity: UserEntity)
}