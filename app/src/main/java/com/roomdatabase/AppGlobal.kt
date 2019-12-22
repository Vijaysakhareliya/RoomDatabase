package com.roomdatabase

import android.content.Context
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

fun Context.toast(message: CharSequence): Toast = Toast
    .makeText(this, message, Toast.LENGTH_SHORT)
    .apply {
        show()
    }

fun snackbar(view: View, message: CharSequence) = Snackbar
    .make(view, message, Snackbar.LENGTH_SHORT)
    .apply { show() }

fun longSnackbar(view: View, message: CharSequence) = Snackbar
    .make(view, message, Snackbar.LENGTH_LONG)
    .apply { show() }


fun isEmptyString(text: String?): String {
    return if (text == null || text.trim { it <= ' ' } == "null" || text.trim { it <= ' ' }.isEmpty()) {
        ""
    } else {
        text
    }
}

fun isStringCheck(text: String?): Boolean {
    return return !(text == null || text.trim { it <= ' ' } == "null" || text.trim { it <= ' ' }.isEmpty())
}


fun isValidEmail(target: CharSequence): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches()
}

fun isValidPhone(number: String?): Boolean {
    return number != null && number.length == 10
}
