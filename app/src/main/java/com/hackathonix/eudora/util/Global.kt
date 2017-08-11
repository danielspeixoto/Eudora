package com.hackathonix.eudora.util

import android.widget.TextView

/**
 * Created by danielspeixoto on 4/21/17.
 */
val EMPTY_STRING = ""

fun TextView.isEmpty() = this.text.toString() == EMPTY_STRING

val TextView.content
    get() = this.text.toString()

fun TextView.clear() {
    this.text = EMPTY_STRING
}

val String.integer
    get() = Integer.valueOf(this)

val Int.string
    get() = Integer.toString(this)

val PARAM_LAYOUT = 8