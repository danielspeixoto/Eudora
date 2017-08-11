package com.hackathonix.eudora

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import org.jetbrains.anko.*

/**
 * Created by daniel on 8/10/17.
 */
abstract class BaseActivity : AppCompatActivity() {
    val TAG = javaClass.simpleName

    lateinit var loadingDialog : ProgressDialog

    val activity: BaseActivity
        get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun goToActivity(clazz: Class<*>) {
        val intent = Intent(this, clazz)
        startActivity(intent)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    }

    fun goToActivityClearPrevious(clazz: Class<*>) {
        val intent = Intent(this, clazz)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent)
    }

    fun showLoadingDialog() {
        loadingDialog = indeterminateProgressDialog(getString(R.string.loading))
        loadingDialog.setCancelable(false)
        loadingDialog.show()
    }

    fun closeLoadingDialog() {
        loadingDialog.dismiss()
    }

    fun showSavedDialog(message : String) {
        showImageDialog(R.drawable.ic_assignment_ind, message)
    }

    fun showErrorDialog() {
        showImageDialog(R.drawable.ic_report_problem, getString(R.string.error_occurred))
    }

    fun showImageDialog(drawable : Int, message: String) {
        alert {
            customView {
                verticalLayout {
                    lparams(width = wrapContent, height = wrapContent)
                    padding = PARAM_LAYOUT * 4
                    imageView {
                        imageResource = drawable

                    }
                    textView(message) {
                        textSize = (PARAM_LAYOUT * 3).toFloat()
                        gravity = Gravity.CENTER
                    }
                }
            }
            yesButton {  }

        }.show()
    }
}
