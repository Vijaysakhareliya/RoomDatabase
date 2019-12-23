package com.roomdatabase.main

import com.roomdatabase.isStringCheck
import com.roomdatabase.isValidEmail
import com.roomdatabase.isValidPhone

class MainPresenter(var viewMain: MainContract.MainView) :
    MainContract.MainPresenter {
    override fun checkValidation(stName: String, stEmail: String, stMobileNo: String) {
        if (!isStringCheck(stName)) {
            viewMain.showError("Enter Name")
        } else if (!isStringCheck(stEmail)) {
            viewMain.showError("Enter Email")
        } else if (!isValidEmail(stEmail)) {
            viewMain.showError("Enter valid Email id")
        } else if (!isStringCheck(stMobileNo)) {
            viewMain.showError("Enter Mobile no")
        } else if (!isValidPhone(stMobileNo)) {
            viewMain.showError("Enter valid Mobile no")
        } else {
            viewMain.insertData(stName, stEmail, stMobileNo)
        }
    }

    override fun deleteUser(position: Int, userData: UserModel) {
        viewMain.deleteUser(position, userData)
    }

    override fun openLink(stLink: String) {
        viewMain.openLink(stLink)
    }
}