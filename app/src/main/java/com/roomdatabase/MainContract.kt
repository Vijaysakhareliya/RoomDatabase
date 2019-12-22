package com.roomdatabase

interface MainContract {
    interface MainPresenter {
        fun checkValidation(stName: String, stEmail: String, stMobileNo: String)
        fun deleteUser(position: Int, userData: UserModel)
        fun openLink(stLink: String)
    }

    interface MainView {
        fun showError(stMsg: String)
        fun insertData(stName: String, stEmail: String, stMobileNo: String)
        fun deleteUser(position: Int, userData: UserModel)
        fun openLink(stLink: String)
    }
}