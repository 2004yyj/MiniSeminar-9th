package com.woowahan.pattern.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.woowahan.pattern.model.DBModel

class MainViewModel(
    private val db: DBModel = DBModel()
): ViewModel() {
    private val _queriedDB = MutableLiveData<String>()
    val queriedDB: LiveData<String> = _queriedDB

    fun updateDB() {
        db.updateDB()
        _queriedDB.value = db.getDB()
    }
}