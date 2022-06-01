package com.azhar.absensi.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import com.azhar.absensi.model.ModelDatabase
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * Created by Azhar Rivaldi on 19-11-2021
 * Youtube Channel : https://bit.ly/2PJMowZ
 * Github : https://github.com/AzharRivaldi
 * Twitter : https://twitter.com/azharrvldi_
 * Instagram : https://www.instagram.com/azhardvls_
 * LinkedIn : https://www.linkedin.com/in/azhar-rivaldi
 */

@Dao
interface DatabaseDao {
    @Query("SELECT * FROM tbl_absensi")
    fun getAllHistory(): LiveData<List<ModelDatabase>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(vararg modelDatabases: ModelDatabase)

    @Query("DELETE FROM tbl_absensi WHERE uid= :uid")
    fun deleteHistoryById(uid: Int)

    @Query("DELETE FROM tbl_absensi")
    fun deleteAllHistory()
}