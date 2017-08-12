package com.hackathonix.eudora.model

import android.support.constraint.solver.Goal

/**
 * Created by daniel on 8/11/17.
 */
data class User(var email: String, var password: String, var name : String = "", var goal: Double = 0.0, var money: Double = 0.0)