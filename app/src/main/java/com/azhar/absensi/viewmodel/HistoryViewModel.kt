package com.azhar.absensi.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.azhar.absensi.database.DatabaseClient.Companion.getInstance
import com.azhar.absensi.database.dao.DatabaseDao
import com.azhar.absensi.model.ModelDatabase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * Created by Azhar Rivaldi on 19-11-2021
 * Youtube Channel : https://bit.ly/2PJMowZ
 * Github : https://github.com/AzharRivaldi
 * Twitter : https://twitter.com/azharrvldi_
 * Instagram : https://www.instagram.com/azhardvls_
 * LinkedIn : https://www.linkedin.com/in/azhar-rivaldi
 */

class HistoryViewModel(application: Application) : AndroidViewModel(application) {
    var dataLaporan: LiveData<List<ModelDatabase>>
    var databaseDao: DatabaseDao? = getInstance(application)?.appDatabase?.databaseDao()

    fun deleteDataById(uid: Int) {
        Completable.fromAction {
            databaseDao?.deleteHistoryById(uid)
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }

    init {
        dataLaporan = databaseDao!!.getAllHistory()
    }
}