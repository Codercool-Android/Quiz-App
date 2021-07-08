package com.abeltarazona.test1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by AbelTarazona on 6/07/2021
 */

fun ViewGroup.inflate(layoutRes: Int) : View =
    LayoutInflater.from(context).inflate(layoutRes, this, false)
