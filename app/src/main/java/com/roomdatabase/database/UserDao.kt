package com.roomdatabase.database

import androidx.room.*
import com.roomdatabase.UserModel

/**
 * Dao : Data access object
 * It's for perform all the operations on Table like insert, update, delete and custom query
 * It is connected to direct database class with Entity
 */
@Dao
interface UserDao {

    /**
     *  Function Uses : Get All users from database
     *  @Query : Annotation for write your custom query
     **/
    @Query("SELECT * from user_data ORDER BY name ASC")
    fun getAllUsers(): List<UserModel>

    /**
     *  Function Uses : Insert Single User
     *  @Insert : Annotation for insert user
     *  onConflict = OnConflictStrategy.REPLACE : Replace user info if we were added same user in database
     **/
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUser(user: UserModel)

    /**
     *  Function Uses : Update User Info
     *  @Update : Annotation for Update user
     **/
    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateUser(user: UserModel)

    /**
     *  Function Uses : Delete User from database
     *  @Delete : Annotation for Delete user directly
     **/
    @Delete
    fun deleteUser(user: UserModel)
}