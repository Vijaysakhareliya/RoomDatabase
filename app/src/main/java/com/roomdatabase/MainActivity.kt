package com.roomdatabase

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.AsyncTask
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.roomdatabase.database.AppDatabase
import com.roomdatabase.database.UserDao
import com.roomdatabase.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), MainContract.MainView {

    private lateinit var mContext: Context
    private lateinit var mBinding : ActivityMainBinding
    private lateinit var mPresenter : MainPresenter
    private lateinit var mDatabase: AppDatabase
    private lateinit var mUserDao: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mContext = this@MainActivity

        init()
    }

    //Initialize objects
    private fun init() {
        mPresenter = MainPresenter(this)

        mBinding.presenter = mPresenter

        mDatabase = AppDatabase.getDatabase(mContext)
        mUserDao = mDatabase.userDao()

        getDataFromDatabase()
    }

    //Show toast message for error
    override fun showError(stMsg: String) {
        toast(stMsg)
    }

    //Insert data in Database with AsyncTask
    override fun insertData(stName: String, stEmail: String, stMobileNo: String) {
        AsyncTask.execute {
            val userData = UserModel(stName, stEmail, stMobileNo)
            mUserDao.addUser(userData)

            runOnUiThread {
                toast("User Inserted")
                getDataFromDatabase()
            }
        }
    }

    //Get User list from Database
    private fun getDataFromDatabase() {
        AsyncTask.execute {
            val listData = mUserDao.getAllUsers()

            runOnUiThread {
                if (listData.isNotEmpty()) {
                    setAdapterData(listData)
                }
            }
        }
    }

    //Set data in RecyclerView
    private fun setAdapterData(list:List<UserModel>){
        val mAdapter = UserAdapter(list, mPresenter)
        mBinding.recyclerView.adapter = mAdapter
    }

    //Delete user
    override fun deleteUser(position: Int, userData: UserModel) {
        AsyncTask.execute {
            mUserDao.deleteUser(userData)

            runOnUiThread {
                toast("User Deleted")
                getDataFromDatabase()
            }
        }
    }

    //Open web link in web browser
    override fun openLink(stLink: String) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(stLink))
        startActivity(browserIntent)
    }
}
