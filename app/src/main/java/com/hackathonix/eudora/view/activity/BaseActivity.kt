package com.hackathonix.eudora.view.activity

import android.graphics.Color
import com.hackathonix.eudora.util.PARAM_LAYOUT
import org.jetbrains.anko.*

/**
 * Created by daniel on 8/10/17.
 */
abstract class BaseActivity : android.support.v7.app.AppCompatActivity() {
    val TAG = javaClass.simpleName

    lateinit var loadingDialog : android.app.ProgressDialog
    companion object {
        var purple = Color.rgb(82,44,132)
        var gold = Color.rgb(193,159,88)
    }


    val activity: com.hackathonix.eudora.view.activity.BaseActivity
        get() = this

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun goToActivity(clazz: Class<*>) {
        val intent = android.content.Intent(this, clazz)
        startActivity(intent)
        intent.addFlags(android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP);
    }

    fun goToActivityClearPrevious(clazz: Class<*>) {
        val intent = android.content.Intent(this, clazz)
        intent.addFlags(android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK or android.content.Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent)
    }

    fun showLoadingDialog() {
        loadingDialog = indeterminateProgressDialog(getString(com.hackathonix.eudora.R.string.loading))
        loadingDialog.setCancelable(false)
        loadingDialog.show()
    }

    fun closeLoadingDialog() {
        loadingDialog.dismiss()
    }

    fun showSavedDialog(message : String) {
        showImageDialog(com.hackathonix.eudora.R.drawable.ic_assignment_ind, message)
    }

    fun showErrorDialog() {
        showImageDialog(com.hackathonix.eudora.R.drawable.ic_report_problem, getString(com.hackathonix.eudora.R.string.error_occurred))
    }

    fun showImageDialog(drawable : Int, message: String) {
        alert {
            customView {
                verticalLayout {
                    lparams(width = org.jetbrains.anko.wrapContent, height = org.jetbrains.anko.wrapContent)
                    padding = PARAM_LAYOUT * 4
                    imageView {
                        imageResource = drawable

                    }
                    textView(message) {
                        textSize = (PARAM_LAYOUT * 3).toFloat()
                        gravity = android.view.Gravity.CENTER
                    }
                }
            }
            yesButton {  }

        }.show()
    }
}
