package com.code.hiltadroid

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.code.hiltadroid.db.RoomRepository
import com.code.hiltadroid.db.UserEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repository: RoomRepository):ViewModel() {
    lateinit var userData:MutableLiveData<List<UserEntity>>
    init {
        userData = MutableLiveData()
    }
    fun getRecordObserver():MutableLiveData<List<UserEntity>>{
        CoroutineScope(Dispatchers.IO).launch {val list = repository.getRecords()
            userData.postValue(list)
        }
        return userData
    }
    fun insertRecord(userEntity: UserEntity){
        CoroutineScope(Dispatchers.IO).launch {
            repository.insertRecord(userEntity)
        }
    }
}