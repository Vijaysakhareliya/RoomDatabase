package com.roomdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_data")
data class UserModel(
    @ColumnInfo(name = "name") var stName: String,
    @ColumnInfo(name = "email") var stEmail: String,
    @ColumnInfo(name = "phone_no") @PrimaryKey var stMobile: String)