package com.hackathonix.eudora.view.recycler.adapter

import com.hackathonix.eudora.R
import com.hackathonix.eudora.model.Link
import com.hackathonix.eudora.model.UserModel
import com.hackathonix.eudora.view.activity.BaseActivity
import java.security.Permissions

/**
 * Created by daniel on 8/11/17.
 */
class DrawerAdapter(activity: BaseActivity) :
        LinksAdapter(activity) {

    init {
        addItem(
                Link("Produtos",
                    Runnable {

                    })
        )
        addItem(
                Link("Financeiro",
                        Runnable {

                        })
        )
        addItem(
                Link("Meta Pessoal",
                        Runnable {

                        })
        )
        addItem(
                Link("Benefícios",
                        Runnable {

                        })
        )
        addItem(
                Link("Ajuda",
                        Runnable {

                        })
        )

    }
}
