package com.hackathonix.eudora.view.activity

import android.os.Bundle
import com.hackathonix.eudora.model.UserModel
import com.hackathonix.eudora.view.activity.custom.tagList
import org.jetbrains.anko.progressBar
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.scrollView
import org.jetbrains.anko.textView
import org.jetbrains.anko.verticalLayout

/**
 * Created by daniel on 8/11/17.
 */
class GoalsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        scrollView {
            verticalLayout {
                //TODO CHECK IF IT IS CORRECT
                progressBar {
                    incrementProgressBy(100)
                    progress = UserModel.currentUser!!.money.toInt()
                    secondaryProgress = UserModel.currentUser!!.goal.toInt()
                }
                tagList {
                    text.text = "Combos Arrasa-Meta"
                }
//                textView("Combos Arrasa-Meta")
//                recyclerView {
//
//                }
//                textView("Preciso")
//                recyclerView {
//
//                }
//                textView("Sonhos")
//                recyclerView {
//
//                }
            }
        }
    }
}